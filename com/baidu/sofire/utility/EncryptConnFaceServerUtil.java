package com.baidu.sofire.utility;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.sofire.core.RandomKeyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class EncryptConnFaceServerUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncryptConnFaceServerUtil() {
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

    public static RequestInfo buildRequestInfo(Context context, String str, byte[] bArr, String str2) throws Throwable {
        InterceptResult invokeLLLL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, bArr, str2)) == null) {
            byte[] randomKey = RandomKeyUtil.getRandomKey();
            if (!TextUtils.isEmpty(str)) {
                bytes = F.getInstance().ae(GZipUtil.compress(str.getBytes()), randomKey);
            } else {
                bytes = "".getBytes();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", Base64.encodeToString(bytes, 0).replace("\n", "").replace("\t", "").replace("\r", ""));
            jSONObject.put("app", "android");
            String encodeToString = Base64.encodeToString(F.getInstance().re(randomKey, MD5Util.getMD5(DbUtil.getCUID(context)).getBytes()), 0);
            String md5 = MD5Util.getMD5(DbUtil.getCUID(context));
            if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(str2)) {
                byte[] ae = F.getInstance().ae(WbEncryptUtil.wbEncrypt(context, bArr), randomKey);
                File file = new File(str2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "tmp_v_" + System.currentTimeMillis());
                if (CommonMethods.writeByteArrayToFile(context, ae, file2)) {
                    return new RequestInfo(encodeToString, md5, jSONObject, file2.getAbsolutePath());
                }
                throw new RuntimeException("Wirte File Error.");
            }
            return new RequestInfo(encodeToString, md5, jSONObject);
        }
        return (RequestInfo) invokeLLLL.objValue;
    }

    public static RequestInfo buildRequestInfo(Context context, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? buildRequestInfo(context, str, null, null) : (RequestInfo) invokeLL.objValue;
    }
}
