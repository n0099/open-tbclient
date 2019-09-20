package com.baidu.swan.b;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.swan.c.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private static String bxQ;

    public static void YD() {
        bxQ = null;
    }

    public static String getToken() {
        if (TextUtils.isEmpty(bxQ)) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                SecureRandom secureRandom = SecureRandom.getInstance(com.coloros.mcssdk.c.a.c);
                byte[] bArr = new byte[cipher.getBlockSize()];
                secureRandom.nextBytes(bArr);
                cipher.init(1, new SecretKeySpec("dde4b1f8a9e6b814".getBytes(HTTP.UTF_8), "AES"), new IvParameterSpec(bArr));
                bq(Base64.encodeToString(bArr, 11), Base64.encodeToString(cipher.doFinal("1.2".getBytes(HTTP.UTF_8)), 11));
            } catch (UnsupportedEncodingException e) {
            } catch (InvalidAlgorithmParameterException e2) {
            } catch (InvalidKeyException e3) {
            } catch (NoSuchAlgorithmException e4) {
            } catch (BadPaddingException e5) {
            } catch (IllegalBlockSizeException e6) {
            } catch (NoSuchPaddingException e7) {
            }
        }
        return bxQ;
    }

    private static void bq(String str, String str2) {
        HttpUrl parse = HttpUrl.parse("https://mbd.baidu.com/ma/log/token");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && parse != null) {
            new OkHttpClient().newCall(new Request.Builder().url(parse.newBuilder().addQueryParameter("iv", str).addQueryParameter("data", str2).build()).build()).enqueue(new Callback() { // from class: com.baidu.swan.b.c.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Log.e("OpenStatToken", "request token failed", iOException);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(e.k(body.byteStream())).getJSONObject("data");
                            br(jSONObject.getString("token_data"), jSONObject.getString("token_iv"));
                        } catch (NoSuchAlgorithmException e) {
                        } catch (JSONException e2) {
                        }
                    }
                }

                private void br(String str3, String str4) throws NoSuchAlgorithmException {
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        byte[] decode = Base64.decode(str3, 11);
                        byte[] decode2 = Base64.decode(str4, 11);
                        try {
                            SecretKeySpec secretKeySpec = new SecretKeySpec("dde4b1f8a9e6b814".getBytes(HTTP.UTF_8), "AES");
                            IvParameterSpec ivParameterSpec = new IvParameterSpec(decode2);
                            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                            cipher.init(2, secretKeySpec, ivParameterSpec);
                            String unused = c.bxQ = new String(cipher.doFinal(decode), HTTP.UTF_8);
                        } catch (UnsupportedEncodingException e) {
                        } catch (InvalidAlgorithmParameterException e2) {
                        } catch (InvalidKeyException e3) {
                        } catch (BadPaddingException e4) {
                        } catch (IllegalBlockSizeException e5) {
                        } catch (NoSuchPaddingException e6) {
                        }
                    }
                }
            });
        }
    }
}
