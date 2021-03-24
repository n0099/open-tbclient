package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.aperf.bosuploader.BOSBizType;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RetrieveReportRequest extends BaseHttpRequest {
    public static final String APP_NAME = "imsdk";
    public static final String REPORT_HOST_ONLINE = "https://mbd.baidu.com/";
    public static final String REPORT_HOST_TEST = "http://10.26.139.34:8092/";
    public static final String TAG = "RetrieveReportRequest";
    public String mFileMeta;
    public String mFileid;
    public String mJobId;
    public IReportListener mListener;
    public String mOrigin;
    public String mRetrieveType;
    public String mStatus;
    public String mValue;

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

    private String getRequestParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        sb.append("appname=imsdk");
        sb.append("&uid=" + Utility.getDeviceId(this.mContext));
        return sb.toString();
    }

    public String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        int readIntData = Utility.readIntData(this.mContext, com.baidu.android.imsdk.internal.Constants.KEY_ENV, 0);
        String str = readIntData != 0 ? (readIntData == 1 || readIntData == 2 || readIntData == 3) ? REPORT_HOST_TEST : null : REPORT_HOST_ONLINE;
        return str + "fetchlog/appupstream" + getRequestParam();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
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
            jSONObject2.put(ContentUtil.REQ_KEY_REQ, jSONObject);
            LogUtils.d(TAG, "retrieve-->getRequestParameter:" + jSONObject2.toString());
        } catch (Exception e2) {
            LogUtils.d(TAG, "retrieve-->getRequestParameter error:" + e2.toString());
        }
        return jSONObject2.toString().getBytes();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        LogUtils.d(TAG, "任务上传失败");
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        JSONObject optJSONObject;
        String str = new String(bArr);
        LogUtils.d(TAG, "retrieve-->onSuccess :" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if ("0".equals(jSONObject.optString("errno", "")) && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                String optString = optJSONObject.optString("jobid", "");
                String optString2 = optJSONObject.optString("valid", "");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && optString2.equals("1")) {
                    LogUtils.d(TAG, "retrieve-->start upload task");
                    if (this.mListener != null) {
                        this.mListener.onSuccess(new ReportResult(optString, optString2));
                    }
                } else {
                    LogUtils.d(TAG, "可能是无效的任务，valid-》0无效：" + optString2);
                }
            }
        } catch (Exception e2) {
            LogUtils.d(TAG, e2.toString());
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
