package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RetrieveFileData {
    private static final String AES_PATH_IV = "1357902468135246";
    private static final String EXPIRED = "expiredTime";
    private static final String INFO = "info";
    private static final String JOB_ID = "jobId";
    private static final String MAX_FILE_SIZE = "maxTotalFileSize";
    private static final String PATH = "path";
    private static final String TAG = "FetchFileData";
    private static final String TYPE = "type";
    private static final String VERSION = "version";

    public static RetrieveFileBean parseJsonContent(JSONObject jSONObject, Context context) {
        JSONObject optJSONObject;
        long longValue;
        String str;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
            return null;
        }
        String optString = jSONObject.optString(JOB_ID);
        String optString2 = jSONObject.optString("type");
        String optString3 = jSONObject.optString("version");
        try {
            longValue = Long.valueOf(jSONObject.optString(EXPIRED)).longValue();
        } catch (Exception e) {
            LogUtils.d(TAG, e.toString());
        }
        if (longValue < System.currentTimeMillis() / 1000) {
            LogUtils.d(TAG, "retrieve--> 文件回捞命令过期");
            RetrieveReportImpl.getInstance(context).reportDispatch(optString2, optString, optString3, jSONObject, "1", null);
            return null;
        } else if ("file".equals(optString2)) {
            try {
                str = new String(Utility.decrypt(AES_PATH_IV, String.format("aperf_%s", optString3), Base64.decode(optJSONObject.optString("path"), 0)));
                LogUtils.d(TAG, "解密后的path路径：" + str);
            } catch (Exception e2) {
                str = null;
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                if (str.indexOf(",") > 0) {
                    arrayList.addAll(Arrays.asList(str.split(",")));
                } else {
                    arrayList.add(str);
                }
                return new RetrieveFileBean(optString, optString2, optString3, longValue, arrayList, str, optJSONObject.optLong(MAX_FILE_SIZE));
            }
            return null;
        } else {
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static final class RetrieveFileBean {
        public long mExpiredTime;
        public String mJobId;
        public long mMaxFileSize;
        public List<String> mPathList;
        public String mPathStr;
        public String mType;
        public String mVersion;

        public RetrieveFileBean(String str, String str2, String str3, long j, List<String> list, String str4, long j2) {
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
}
