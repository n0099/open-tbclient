package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RetrieveProcesser {
    public static final String TAG = "RetrieveProcesser";

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6 A[Catch: all -> 0x0124, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x001f, B:11:0x0053, B:13:0x0059, B:16:0x0061, B:19:0x006e, B:21:0x0082, B:29:0x00a0, B:37:0x00b6, B:38:0x00db, B:32:0x00aa, B:41:0x00ef), top: B:48:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x001f, B:11:0x0053, B:13:0x0059, B:16:0x0061, B:19:0x006e, B:21:0x0082, B:29:0x00a0, B:37:0x00b6, B:38:0x00db, B:32:0x00aa, B:41:0x00ef), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean process(final JSONObject jSONObject, final Context context) {
        boolean z;
        synchronized (RetrieveProcesser.class) {
            char c2 = 0;
            if (jSONObject == null) {
                LogUtils.d(TAG, "retrieve-->data is null");
                RetrieveReportImpl.getInstance(context).reportDispatchCheckFail("", "", "", "0", null);
                return false;
            }
            LogUtils.d(TAG, "retrieve-->data is：" + jSONObject.toString());
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString(RetrieveFileData.JOB_ID);
            String optString3 = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                String optString4 = jSONObject.optString(RetrieveFileData.EXPIRED);
                if (!TextUtils.isEmpty(optString4)) {
                    if (System.currentTimeMillis() >= Long.valueOf(optString4).longValue() * 1000) {
                        LogUtils.d(TAG, "retrieve-->任务过期");
                        RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "1", null);
                        z = false;
                        if (!z) {
                            return false;
                        }
                    } else {
                        z = true;
                        if (!z) {
                        }
                    }
                }
                if (optString.hashCode() == 3143036 && optString.equals("file")) {
                    if (c2 == 0) {
                        LogUtils.d(TAG, "retrieve-->不支持的回捞类型：" + optString);
                        RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "2", null);
                    } else {
                        RetrieveReportImpl.getInstance(context).reportDispatch(optString, optString2, optString3, jSONObject, "0", new IReportListener() { // from class: com.baidu.android.imsdk.retrieve.RetrieveProcesser.1
                            @Override // com.baidu.android.imsdk.retrieve.IReportListener
                            public void onFailure() {
                            }

                            @Override // com.baidu.android.imsdk.retrieve.IReportListener
                            public void onSuccess(ReportResult reportResult) {
                                RetrieveFileJob retrieveFileJob = new RetrieveFileJob();
                                if (reportResult == null || !"1".equals(reportResult.getValid())) {
                                    return;
                                }
                                retrieveFileJob.dispatch(jSONObject, context);
                            }
                        });
                    }
                    return true;
                }
                c2 = 65535;
                if (c2 == 0) {
                }
                return true;
            }
            LogUtils.d(TAG, "retrieve-->缺少必要字段，type：" + optString + ", jobId:" + optString2 + ", version:" + optString3);
            RetrieveReportImpl.getInstance(context).reportDispatchCheckFail(optString, optString2, optString3, "1", jSONObject);
            return false;
        }
    }
}
