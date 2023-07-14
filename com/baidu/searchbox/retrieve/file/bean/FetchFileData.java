package com.baidu.searchbox.retrieve.file.bean;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FetchFileData {
    public static final String AES_PATH_IV = "1357902468135246";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DECRYPT_KEY_LENGTH = 16;
    public static final String EXPIRED = "expiredTime";
    public static final String INFO = "info";
    public static final String JOB_ID = "jobId";
    public static final String MAX_FILE_SIZE = "maxTotalFileSize";
    public static final String PATH = "path";
    public static final String TAG = "FetchFileData";
    public static final String TYPE = "type";
    public static final String VERSION = "version";

    /* loaded from: classes4.dex */
    public static final class FetchBean {
        public long mExpiredTime;
        public String mJobId;
        public long mMaxFileSize;
        public List<String> mPathList;
        public String mPathStr;
        public String mType;
        public String mVersion;

        public FetchBean(String str, String str2, String str3, long j, List<String> list, String str4, long j2) {
            this.mPathList = new ArrayList();
            this.mJobId = str;
            this.mType = str2;
            this.mVersion = str3;
            this.mExpiredTime = j;
            this.mPathList = list;
            this.mPathStr = str4;
            this.mMaxFileSize = j2;
        }

        public String toString() {
            return "FetchBean{mJobId='" + this.mJobId + "', mType='" + this.mType + "', mVersion='" + this.mVersion + "', mExpiredTime=" + this.mExpiredTime + ", mPathList=" + this.mPathList + ", mMaxFileSize=" + this.mMaxFileSize + '}';
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FetchBean parseJsonContent(JSONObject jSONObject) {
        String str;
        String str2;
        long longValue;
        String str3;
        if (jSONObject == null) {
            return null;
        }
        if (DEBUG) {
            Log.d("FetchFileData", "文件回捞收到命令 " + jSONObject.toString());
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("info");
        if (optJSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("jobId");
        String optString2 = jSONObject.optString("type");
        String optString3 = jSONObject.optString("version");
        try {
            longValue = Long.valueOf(jSONObject.optString("expiredTime")).longValue();
        } catch (Exception e) {
            e = e;
            str = optString;
            str2 = optString2;
            if (DEBUG) {
            }
            reportTaskCheckFail(str2, str, str, jSONObject);
            return null;
        }
        if (longValue < System.currentTimeMillis() / 1000) {
            if (DEBUG) {
                Log.w("FetchFileData", "文件回捞命令已过期");
            }
            reportTaskCheckFail(optString2, optString, optString, jSONObject);
            return null;
        }
        if ("file".equals(optString2)) {
            try {
                String optString4 = optJSONObject.optString("path");
                StringBuilder sb = new StringBuilder(String.format("aperf_%s", optString3));
                int length = sb.length();
                if (length < 16) {
                    for (int i = 0; i < 16 - length; i++) {
                        sb.append("\u0000");
                    }
                }
                str3 = new String(AESUtil.decryptCBC("1357902468135246", sb.toString(), Base64.decode(optString4, 0)));
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                ArrayList arrayList = new ArrayList();
                if (str3.indexOf(",") > 0) {
                    arrayList.addAll(Arrays.asList(str3.split(",")));
                } else {
                    arrayList.add(str3);
                }
                long optLong = optJSONObject.optLong("maxTotalFileSize");
                str = optString;
                str2 = optString2;
                try {
                    return new FetchBean(optString, optString2, optString3, longValue, arrayList, str3, optLong);
                } catch (Exception e3) {
                    e = e3;
                    if (DEBUG) {
                        Log.d("FetchFileData", e.getMessage());
                    }
                    reportTaskCheckFail(str2, str, str, jSONObject);
                    return null;
                }
            }
        }
        str = optString;
        str2 = optString2;
        reportTaskCheckFail(str2, str, str, jSONObject);
        return null;
    }

    public static void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        if (DEBUG) {
            Log.w("FetchFileData", "文件回捞命令校验失败" + jSONObject.toString());
        }
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(str, str2, str3, jSONObject);
    }
}
