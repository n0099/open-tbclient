package com.baidu.sofire.utility;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.RequestInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RequestInfo a(Context context, String str, byte[] bArr, String str2) throws Throwable {
        InterceptResult invokeLLLL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, context, str, bArr, str2)) == null) {
            byte[] a2 = com.baidu.sofire.core.h.a();
            if (!TextUtils.isEmpty(str)) {
                bytes = F.getInstance().ae(k.a(str.getBytes()), a2);
            } else {
                bytes = "".getBytes();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", Base64.encodeToString(bytes, 0).replace(StringUtils.LF, "").replace(TrackUI.SEPERATOR, "").replace(StringUtils.CR, ""));
            jSONObject.put("app", "android");
            String encodeToString = Base64.encodeToString(F.getInstance().re(a2, q.a(e.b(context)).getBytes()), 0);
            String a3 = q.a(e.b(context));
            if (bArr != null && bArr.length != 0 && !TextUtils.isEmpty(str2)) {
                byte[] ae = F.getInstance().ae(WbEncryptUtil.wbEncrypt(context, bArr), a2);
                File file = new File(str2);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "tmp_v_" + System.currentTimeMillis());
                if (c.a(context, ae, file2)) {
                    return new RequestInfo(encodeToString, a3, jSONObject, file2.getAbsolutePath());
                }
                throw new RuntimeException("Wirte File Error.");
            }
            return new RequestInfo(encodeToString, a3, jSONObject);
        }
        return (RequestInfo) invokeLLLL.objValue;
    }
}
