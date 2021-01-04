package com.baidu.ar.auth;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobstat.Config;
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
class e {
    public static void a(byte[] bArr, f fVar) {
        JSONObject jSONObject = new JSONObject(new String(a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDn6dzi813ZXXfMIeXrxJxtVekfpxksX9N5XPh9g4D94cOvZnYL93PngexbPfGW9T7DhGnPdgRxR6Ux1pGRdTfrL9yK8nR7uCa5Va9IXbNd4T5QPpbmJ5hvmk7qg8GY8BxcC/0M+a5ylVP8bUDq50Y9Si+7g844wOCbrOkzSe920wIDAQAB".getBytes(), bArr)));
        fVar.jH = jSONObject.getInt("authType");
        fVar.jI = jSONObject.getInt("ignoreNetError") == 1;
        fVar.jJ = jSONObject.getInt("noAuthTip") == 1;
        fVar.jL = jSONObject.optString("appId");
        fVar.jM = jSONObject.optString("apiKey");
        fVar.jO = jSONObject.optInt("grantedAll", 0) == 1;
        if (jSONObject.has("expiredTime")) {
            fVar.jP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString("expiredTime")).getTime();
        } else {
            fVar.jP = 0L;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                fVar.jK.add(optJSONArray.getString(i));
            }
        }
        String optString = jSONObject.optString(Config.INPUT_DEF_PKG);
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
        for (int i2 = 0; i2 < length2; i2++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i2)));
        }
        fVar.jN = arrayList;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(bArr, 0)));
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(2, generatePublic);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = bArr2.length;
        int i = 0;
        while (length > i) {
            int i2 = length - i;
            if (i2 > 128) {
                i2 = 128;
            }
            byteArrayOutputStream.write(cipher.doFinal(bArr2, i, i2));
            i = i2 + i;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static f m(Context context) {
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

    private static byte[] n(Context context) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr = null;
        try {
            inputStream = context.getAssets().open("dumixar.license");
            try {
                byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[512];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream2.toByteArray();
                    com.baidu.ar.h.k.closeQuietly(byteArrayOutputStream2);
                    com.baidu.ar.h.k.closeQuietly(inputStream);
                } catch (IOException e) {
                    com.baidu.ar.h.k.closeQuietly(byteArrayOutputStream2);
                    com.baidu.ar.h.k.closeQuietly(inputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.baidu.ar.h.k.closeQuietly(byteArrayOutputStream);
                    com.baidu.ar.h.k.closeQuietly(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e3) {
            byteArrayOutputStream2 = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
        }
        return bArr;
    }
}
