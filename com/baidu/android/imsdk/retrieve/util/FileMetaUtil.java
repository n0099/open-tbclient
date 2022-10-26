package com.baidu.android.imsdk.retrieve.util;

import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FileMetaUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CREATE_TIME = "createTime";
    public static final String ERR_MSG = "errmsg";
    public static final String ERR_NO = "errno";
    public static final String ISFILE = "1";
    public static final String IS_FILE = "isFile";
    public static final String MODIFY_TIME = "modifiedTime";
    public static final String NOTFILE = "0";
    public static final String SIZE = "size";
    public static final String TAG = "FileMetaUtil";
    public static final String ZIP_PATH = "zipPath";
    public transient /* synthetic */ FieldHolder $fh;

    public FileMetaUtil() {
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

    public static JSONObject makeFileMeta(File file, String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, str, str2, str3, Boolean.valueOf(z)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", str2);
                jSONObject.put("errmsg", str3);
                if (z) {
                    str4 = "1";
                } else {
                    str4 = "0";
                }
                jSONObject.put(IS_FILE, str4);
                if (file != null && file.exists() && file.isFile()) {
                    jSONObject.put(ZIP_PATH, str);
                    jSONObject.put("size", String.valueOf(file.length()));
                    jSONObject.put(CREATE_TIME, file.lastModified());
                    jSONObject.put(MODIFY_TIME, file.lastModified());
                }
            } catch (Exception e) {
                LogUtils.d(TAG, e.toString());
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }
}
