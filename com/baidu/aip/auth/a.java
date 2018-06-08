package com.baidu.aip.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            URL url = new URL(str);
            byte[] a = a(str2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "text/html");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(a);
            return g(httpURLConnection);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AuthException(283504, AuthException.b);
        }
    }

    public static byte[] a(String str) {
        byte[] bArr = new byte[0];
        return str.getBytes("UTF-8");
    }

    public static String g(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = new char[512];
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                bufferedReader.close();
                return stringBuffer.toString();
            }
            stringBuffer.append(new String(cArr, 0, read));
        }
    }
}
