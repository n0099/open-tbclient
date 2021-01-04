package b.a.a.a.a;

import android.net.http.Headers;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public double f1068a;

    /* renamed from: b  reason: collision with root package name */
    public double f1069b;
    public double c;
    public float d;

    public o() {
    }

    public o(JSONObject jSONObject) throws JSONException {
        this.f1068a = jSONObject.optDouble("latitude", 0.0d);
        this.f1069b = jSONObject.optDouble("longitude", 0.0d);
        this.c = jSONObject.optDouble("altitude", 0.0d);
        this.d = (float) jSONObject.optDouble("accuracy", 0.0d);
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        byte[] bArr = new byte[256];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String b(String str) {
        if (str != null) {
            for (String str2 : str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR)) {
                String trim = str2.trim();
                int indexOf = trim.indexOf("charset=");
                if (-1 != indexOf) {
                    return trim.substring(indexOf + 8, trim.length());
                }
            }
            return "GBK";
        }
        return "GBK";
    }

    public static boolean b(Handler handler, int i) {
        Message obtainMessage = handler == null ? null : handler.obtainMessage(i);
        if (obtainMessage == null || handler == null) {
            return false;
        }
        return handler.sendMessageDelayed(obtainMessage, 0L);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static Bundle d(String str, byte[] bArr) throws IOException {
        Bundle bundle = new Bundle();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            bundle.putInt("http_ret_code", responseCode);
            switch (responseCode) {
                case 200:
                    String b2 = b(httpURLConnection.getHeaderField(Headers.CONTENT_TYPE));
                    byte[] a2 = a(httpURLConnection.getInputStream());
                    bundle.putInt("status", 0);
                    bundle.putByteArray("data_bytes", a2);
                    bundle.putString("data_charset", b2);
                    return bundle;
                default:
                    bundle.putInt("status", -1);
                    throw new IOException("net error: retCode:".concat(String.valueOf(responseCode)));
            }
        } catch (Throwable th) {
            try {
                throw new IOException(th.getMessage());
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }
}
