package b.a.p0.a.h0.o.g.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        InputStream inputStream;
        int i2;
        HttpURLConnection httpURLConnection;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            String str5 = null;
            if (TextUtils.isEmpty(str) || !Patterns.WEB_URL.matcher(str).matches()) {
                return null;
            }
            String scheme = Uri.parse(str).getScheme();
            int i3 = 200;
            HttpURLConnection httpURLConnection2 = null;
            while (true) {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        if (map != null) {
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                            }
                        }
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setConnectTimeout(b.a.p0.a.h0.o.g.c.a.a().e());
                        httpURLConnection.setReadTimeout(b.a.p0.a.h0.o.g.c.a.a().h());
                        String headerField = httpURLConnection.getHeaderField("Location");
                        String scheme2 = headerField == null ? null : Uri.parse(headerField).getScheme();
                        if (headerField == null || (scheme2 != null && scheme2.equals(scheme))) {
                            break;
                        }
                        scheme = scheme2;
                        httpURLConnection2 = httpURLConnection;
                        str = headerField;
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection2 = httpURLConnection;
                        str2 = null;
                        if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                            Log.getStackTraceString(e);
                        }
                        str3 = str2;
                        inputStream = null;
                        i2 = i3;
                        httpURLConnection = httpURLConnection2;
                        HashMap hashMap = new HashMap();
                        str4 = "UTF-8";
                        if (httpURLConnection != null) {
                        }
                        String str6 = str4;
                        String str7 = str5;
                        if (TextUtils.isEmpty(str3)) {
                        }
                        return new b(i2, str3, inputStream, hashMap, str6, str7);
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            }
            i3 = httpURLConnection.getResponseCode();
            str3 = httpURLConnection.getResponseMessage();
            try {
                inputStream = httpURLConnection.getInputStream();
                i2 = i3;
            } catch (Exception e4) {
                httpURLConnection2 = httpURLConnection;
                str2 = str3;
                e = e4;
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                }
                str3 = str2;
                inputStream = null;
                i2 = i3;
                httpURLConnection = httpURLConnection2;
                HashMap hashMap2 = new HashMap();
                str4 = "UTF-8";
                if (httpURLConnection != null) {
                }
                String str62 = str4;
                String str72 = str5;
                if (TextUtils.isEmpty(str3)) {
                }
                return new b(i2, str3, inputStream, hashMap2, str62, str72);
            }
            HashMap hashMap22 = new HashMap();
            str4 = "UTF-8";
            if (httpURLConnection != null) {
                str4 = httpURLConnection.getContentEncoding() != null ? httpURLConnection.getContentEncoding() : "UTF-8";
                str5 = httpURLConnection.getContentType();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                if (headerFields != null) {
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        List<String> value = entry2.getValue();
                        if (!value.isEmpty()) {
                            hashMap22.put(entry2.getKey(), value.get(0));
                        }
                    }
                }
            }
            String str622 = str4;
            String str722 = str5;
            if (TextUtils.isEmpty(str3)) {
                str3 = NewBindCardEntry.BING_CARD_SUCCESS_MSG;
            }
            return new b(i2, str3, inputStream, hashMap22, str622, str722);
        }
        return (b) invokeLL.objValue;
    }
}
