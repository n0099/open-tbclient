package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RetrieveProcesser {
    private static final String TAG = "RetrieveProcesser";

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e1, code lost:
        if (r0 == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean process(final JSONObject jSONObject, final Context context) {
        boolean z;
        boolean z2 = false;
        synchronized (RetrieveProcesser.class) {
            if (jSONObject == null) {
                LogUtils.d(TAG, "retrieve-->data is null");
                RetrieveReportImpl.getInstance(context).reportDispatchCheckFail("", "", "", "0", null);
            } else {
                LogUtils.d(TAG, "retrieve-->data is：" + jSONObject.toString());
                String optString = jSONObject.optString("type");
                String optString2 = jSONObject.optString("jobId");
                String optString3 = jSONObject.optString("version");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                    LogUtils.d(TAG, "retrieve-->缺少必要字段，type：" + optString + ", jobId:" + optString2 + ", version:" + optString3);
                    RetrieveReportImpl.getInstance(context).reportDispatchCheckFail(optString, optString2, optString3, "1", jSONObject);
                } else {
                    String optString4 = jSONObject.optString("expiredTime");
                    if (!TextUtils.isEmpty(optString4)) {
                        try {
                            if (System.currentTimeMillis() >= Long.valueOf(optString4).longValue() * 1000) {
                                LogUtils.d(TAG, "retrieve-->任务过期");
                                RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "1", null);
                                z = false;
                            } else {
                                z = true;
                            }
                        } catch (Exception e) {
                            z = false;
                        }
                    }
                    switch (optString.hashCode()) {
                        case 3143036:
                            if (optString.equals("file")) {
                                break;
                            }
                        default:
                            z2 = true;
                            break;
                    }
                    switch (z2) {
                        case false:
                            RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "0", new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveProcesser.1
                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onSuccess(ReportResult reportResult) {
                                    RetrieveFileJob retrieveFileJob = new RetrieveFileJob();
                                    if (reportResult != null && "1".equals(reportResult.getValid())) {
                                        retrieveFileJob.dispatch(jSONObject, context);
                                    }
                                }

                                @Override // com.baidu.android.imsdk.retrieve.IReportListener
                                public void onFailure() {
                                }
                            });
                            break;
                        default:
                            LogUtils.d(TAG, "retrieve-->不支持的回捞类型：" + optString);
                            RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "2", null);
                            break;
                    }
                    z2 = true;
                }
            }
        }
        return z2;
    }
}
