package com.baidu.browser.sailor.platform.nativeability;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class f {
    final String a = "===" + System.currentTimeMillis() + "===";
    private HttpURLConnection adb;
    private OutputStream adc;
    PrintWriter ade;
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.adb = (HttpURLConnection) new URL(str).openConnection();
        this.adb.setUseCaches(false);
        this.adb.setDoOutput(true);
        this.adb.setDoInput(true);
        this.adb.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.adb.setRequestProperty("User-Agent", str3);
        this.adc = this.adb.getOutputStream();
        this.ade = new PrintWriter((Writer) new OutputStreamWriter(this.adc, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.ade.append((CharSequence) "\r\n").flush();
        this.ade.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.ade.close();
        int responseCode = this.adb.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.adb.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.adb.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.ade.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.ade.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.ade.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.ade.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.ade.append((CharSequence) "\r\n");
        this.ade.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.adc.flush();
                fileInputStream.close();
                this.ade.append((CharSequence) "\r\n");
                this.ade.flush();
                return;
            }
            this.adc.write(bArr, 0, read);
        }
    }
}
