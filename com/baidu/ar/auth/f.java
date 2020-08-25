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
/* loaded from: classes11.dex */
class f {
    public static void a(byte[] bArr, g gVar) {
        JSONObject jSONObject = new JSONObject(new String(a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDn6dzi813ZXXfMIeXrxJxtVekfpxksX9N5XPh9g4D94cOvZnYL93PngexbPfGW9T7DhGnPdgRxR6Ux1pGRdTfrL9yK8nR7uCa5Va9IXbNd4T5QPpbmJ5hvmk7qg8GY8BxcC/0M+a5ylVP8bUDq50Y9Si+7g844wOCbrOkzSe920wIDAQAB".getBytes(), bArr)));
        gVar.js = jSONObject.getInt("authType");
        gVar.jt = jSONObject.getInt("ignoreNetError") == 1;
        gVar.ju = jSONObject.getInt("noAuthTip") == 1;
        gVar.jw = jSONObject.optString("appId");
        gVar.jx = jSONObject.optString("apiKey");
        gVar.jz = jSONObject.optInt("grantedAll", 0) == 1;
        if (jSONObject.has("expiredTime")) {
            gVar.jA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jSONObject.getString("expiredTime")).getTime();
        } else {
            gVar.jA = 0L;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY);
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                gVar.jv.add(optJSONArray.getString(i));
            }
        }
        String optString = jSONObject.optString(Config.INPUT_DEF_PKG);
        if (!TextUtils.isEmpty(optString) && !gVar.jv.contains(optString)) {
            gVar.jv.add(optString);
        }
        if (gVar.jz) {
            gVar.jy = FeatureCodes.getAll();
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("features");
        ArrayList arrayList = new ArrayList();
        int length2 = jSONArray.length();
        for (int i2 = 0; i2 < length2; i2++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i2)));
        }
        gVar.jy = arrayList;
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

    public static g l(Context context) {
        g gVar = new g();
        byte[] m = m(context);
        if (m != null) {
            a(m, gVar);
        } else {
            gVar.js = 1;
            gVar.jt = false;
            gVar.jy = FeatureCodes.getAll();
        }
        return gVar;
    }

    private static byte[] m(Context context) {
        InputStream inputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            inputStream = context.getAssets().open("dumixar.license");
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e) {
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                byteArrayOutputStream = null;
                th = th2;
            }
        } catch (IOException e2) {
            byteArrayOutputStream = null;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            byteArrayOutputStream = null;
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
            com.baidu.ar.g.k.closeQuietly(byteArrayOutputStream);
            com.baidu.ar.g.k.closeQuietly(inputStream);
        } catch (IOException e3) {
            com.baidu.ar.g.k.closeQuietly(byteArrayOutputStream);
            com.baidu.ar.g.k.closeQuietly(inputStream);
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            com.baidu.ar.g.k.closeQuietly(byteArrayOutputStream);
            com.baidu.ar.g.k.closeQuietly(inputStream);
            throw th;
        }
        return bArr;
    }
}
