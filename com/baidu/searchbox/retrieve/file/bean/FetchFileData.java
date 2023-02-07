package com.baidu.searchbox.retrieve.file.bean;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FetchFileData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_PATH_IV = "1357902468135246";
    public static final boolean DEBUG;
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

    /* loaded from: classes3.dex */
    public static final class FetchBean {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long mExpiredTime;
        public String mJobId;
        public long mMaxFileSize;
        public List<String> mPathList;
        public String mPathStr;
        public String mType;
        public String mVersion;

        public FetchBean(String str, String str2, String str3, long j, List<String> list, String str4, long j2) {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668900384, "Lcom/baidu/searchbox/retrieve/file/bean/FetchFileData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668900384, "Lcom/baidu/searchbox/retrieve/file/bean/FetchFileData;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FetchFileData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FetchBean parseJsonContent(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        String str2;
        long longValue;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
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
                    Log.d("FetchFileData", e.getMessage());
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
        return (FetchBean) invokeL.objValue;
    }

    public static void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, str2, str3, jSONObject) == null) {
            if (DEBUG) {
                Log.w("FetchFileData", "文件回捞命令校验失败" + jSONObject.toString());
            }
            ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(str, str2, str3, jSONObject);
        }
    }
}
