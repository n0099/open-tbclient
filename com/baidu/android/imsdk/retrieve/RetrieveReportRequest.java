package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.searchbox.aperf.bosuploader.BOSBizType;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RetrieveReportRequest extends BaseHttpRequest {
    private static final String APP_NAME = "imsdk";
    private static final String REPORT_HOST_ONLINE = "https://mbd.baidu.com/";
    private static final String REPORT_HOST_TEST = "http://10.26.139.34:8092/";
    private static final String TAG = "RetrieveReportRequest";
    private String mFileMeta;
    private String mFileid;
    private String mJobId;
    private IReportListener mListener;
    private String mOrigin;
    private String mRetrieveType;
    private String mStatus;
    private String mValue;

    public RetrieveReportRequest(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, IReportListener iReportListener) {
        this.mContext = context;
        this.mRetrieveType = str;
        this.mValue = str2;
        this.mJobId = str3;
        this.mStatus = str4;
        this.mOrigin = str5;
        this.mFileMeta = str6;
        this.mFileid = str7;
        this.mListener = iReportListener;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONObject optJSONObject;
        String str = new String(bArr);
        LogUtils.d(TAG, "retrieve-->onSuccess :" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("0".equals(jSONObject.optString(BaseJsonData.TAG_ERRNO, "")) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                String optString = optJSONObject.optString("jobid", "");
                String optString2 = optJSONObject.optString(CloudControlUBCUtils.KEY_VALID, "");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString2.equals("1")) {
                    LogUtils.d(TAG, "retrieve-->start upload task");
                    if (this.mListener != null) {
                        this.mListener.onSuccess(new ReportResult(optString, optString2));
                    }
                } else {
                    LogUtils.d(TAG, "可能是无效的任务，valid-》0无效：" + optString2);
                }
            }
        } catch (Exception e) {
            LogUtils.d(TAG, e.toString());
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "任务上传失败");
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        String str = null;
        switch (Utility.readIntData(this.mContext, com.baidu.android.imsdk.internal.Constants.KEY_ENV, 0)) {
            case 0:
                str = REPORT_HOST_ONLINE;
                break;
            case 1:
            case 2:
            case 3:
                str = REPORT_HOST_TEST;
                break;
        }
        return str + "fetchlog/appupstream" + getRequestParam();
    }

    protected String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            treeSet.add(keys.next());
        }
        for (String str : treeSet) {
            sb.append(str);
            sb.append("=");
            sb.append(jSONObject.opt(str));
        }
        sb.append(BOSBizType.RETRIEVE);
        LogUtils.d(TAG, "sign string:" + ((Object) sb));
        return getMd5(sb.toString());
    }

    private String getRequestParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        sb.append("appname=imsdk");
        sb.append("&uid=" + Utility.getDeviceId(this.mContext));
        return sb.toString();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", this.mRetrieveType);
            jSONObject.put("value", this.mValue);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.put("jobid", this.mJobId);
            jSONObject.put("version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext)));
            jSONObject.put("status", this.mStatus);
            if (!TextUtils.isEmpty(this.mOrigin)) {
                jSONObject.put("origin", this.mOrigin);
            }
            if (!TextUtils.isEmpty(this.mFileMeta)) {
                jSONObject.put("filemeta", this.mFileMeta);
            }
            if (!TextUtils.isEmpty(this.mFileid)) {
                jSONObject.put("fileid", this.mFileid);
            }
            jSONObject.put("sign", generateSign(jSONObject));
            jSONObject2.put("req", jSONObject);
            LogUtils.d(TAG, "retrieve-->getRequestParameter:" + jSONObject2.toString());
        } catch (Exception e) {
            LogUtils.d(TAG, "retrieve-->getRequestParameter error:" + e.toString());
        }
        return jSONObject2.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return HttpHelper.CONTENT_JSON;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
