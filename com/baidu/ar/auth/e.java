package com.baidu.ar.auth;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(byte[] bArr, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bArr, fVar) == null) {
            JSONObject jSONObject = new JSONObject(new String(a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDn6dzi813ZXXfMIeXrxJxtVekfpxksX9N5XPh9g4D94cOvZnYL93PngexbPfGW9T7DhGnPdgRxR6Ux1pGRdTfrL9yK8nR7uCa5Va9IXbNd4T5QPpbmJ5hvmk7qg8GY8BxcC/0M+a5ylVP8bUDq50Y9Si+7g844wOCbrOkzSe920wIDAQAB".getBytes(), bArr)));
            fVar.jH = jSONObject.getInt("authType");
            fVar.jI = jSONObject.getInt("ignoreNetError") == 1;
            fVar.jJ = jSONObject.getInt("noAuthTip") == 1;
            fVar.jL = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            fVar.jM = jSONObject.optString("apiKey");
            fVar.jO = jSONObject.optInt("grantedAll", 0) == 1;
            fVar.jP = jSONObject.has(RetrieveFileData.EXPIRED) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString(RetrieveFileData.EXPIRED)).getTime() : 0L;
            JSONArray optJSONArray = jSONObject.optJSONArray("pkgs");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    fVar.jK.add(optJSONArray.getString(i2));
                }
            }
            String optString = jSONObject.optString("pkg");
            if (!TextUtils.isEmpty(optString) && !fVar.jK.contains(optString)) {
                fVar.jK.add(optString);
            }
            if (fVar.jO) {
                fVar.jN = FeatureCodes.getAll();
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("features");
            ArrayList arrayList = new ArrayList();
            int length2 = jSONArray.length();
            for (int i3 = 0; i3 < length2; i3++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
            }
            fVar.jN = arrayList;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, bArr2)) == null) {
            int i2 = 0;
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(bArr, 0)));
            Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
            cipher.init(2, generatePublic);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length = bArr2.length;
            while (length > i2) {
                int i3 = length - i2;
                if (i3 > 128) {
                    i3 = 128;
                }
                byte[] doFinal = cipher.doFinal(bArr2, i2, i3);
                i2 += i3;
                byteArrayOutputStream.write(doFinal);
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    public static f m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            f fVar = new f();
            byte[] n = n(context);
            if (n != null) {
                a(n, fVar);
            } else {
                fVar.jH = 1;
                fVar.jI = false;
                fVar.jN = FeatureCodes.getAll();
            }
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    public static byte[] n(Context context) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            byte[] bArr = null;
            try {
                inputStream = context.getAssets().open("dumixar.license");
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException unused) {
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    byteArrayOutputStream = null;
                    th = th2;
                }
                try {
                    byte[] bArr2 = new byte[512];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.ar.h.k.closeQuietly(byteArrayOutputStream);
                    com.baidu.ar.h.k.closeQuietly(inputStream);
                    throw th;
                }
            } catch (IOException unused3) {
                inputStream = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                byteArrayOutputStream = null;
                th = th4;
                inputStream = null;
            }
            com.baidu.ar.h.k.closeQuietly(byteArrayOutputStream);
            com.baidu.ar.h.k.closeQuietly(inputStream);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
