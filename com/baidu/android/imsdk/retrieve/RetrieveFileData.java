package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RetrieveFileData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_PATH_IV = "1357902468135246";
    public static final int DECRYPT_KEY_LENGTH = 16;
    public static final String EXPIRED = "expiredTime";
    public static final String INFO = "info";
    public static final String JOB_ID = "jobId";
    public static final String MAX_FILE_SIZE = "maxTotalFileSize";
    public static final String PATH = "path";
    public static final String TAG = "FetchFileData";
    public static final String TYPE = "type";
    public static final String VERSION = "version";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static final class RetrieveFileBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mExpiredTime;
        public String mJobId;
        public long mMaxFileSize;
        public List<String> mPathList;
        public String mPathStr;
        public String mType;
        public String mVersion;

        public RetrieveFileBean(String str, String str2, String str3, long j, List<String> list, String str4, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Long.valueOf(j), list, str4, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FetchBean{mJobId='" + this.mJobId + "', mType='" + this.mType + "', mVersion='" + this.mVersion + "', mExpiredTime=" + this.mExpiredTime + ", mPathList=" + this.mPathList + ", mMaxFileSize=" + this.mMaxFileSize + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public RetrieveFileData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static RetrieveFileBean parseJsonContent(JSONObject jSONObject, Context context) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        long longValue;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jSONObject, context)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("info")) == null) {
                return null;
            }
            String optString = jSONObject.optString("jobId");
            String optString2 = jSONObject.optString("type");
            String optString3 = jSONObject.optString("version");
            try {
                longValue = Long.valueOf(jSONObject.optString("expiredTime")).longValue();
            } catch (Exception e) {
                LogUtils.d("FetchFileData", e.toString());
            }
            if (longValue < System.currentTimeMillis() / 1000) {
                LogUtils.d("FetchFileData", "retrieve--> 文件回捞命令过期");
                RetrieveReportImpl.getInstance(context).reportDispatch(optString2, optString, optString3, jSONObject, "1", null);
                return null;
            } else if (!"file".equals(optString2)) {
                return null;
            } else {
                try {
                    String optString4 = optJSONObject.optString("path");
                    StringBuilder sb = new StringBuilder(String.format("aperf_%s", optString3));
                    int length = sb.length();
                    if (length < 16) {
                        for (int i = 0; i < 16 - length; i++) {
                            sb.append("\u0000");
                        }
                    }
                    str = new String(Utility.decrypt(AES_PATH_IV, sb.toString(), Base64.decode(optString4, 0)));
                    LogUtils.d("FetchFileData", "解密后的path路径：" + str);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    ArrayList arrayList = new ArrayList();
                    if (str.indexOf(",") > 0) {
                        arrayList.addAll(Arrays.asList(str.split(",")));
                    } else {
                        arrayList.add(str);
                    }
                    return new RetrieveFileBean(optString, optString2, optString3, longValue, arrayList, str, optJSONObject.optLong("maxTotalFileSize"));
                }
                return null;
            }
        }
        return (RetrieveFileBean) invokeLL.objValue;
    }
}
