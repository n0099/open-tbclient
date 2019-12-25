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
/* loaded from: classes9.dex */
public final class f {
    private HttpURLConnection Ja;
    private OutputStream Jb;
    PrintWriter Jc;
    final String a = "===" + System.currentTimeMillis() + "===";
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.Ja = (HttpURLConnection) new URL(str).openConnection();
        this.Ja.setUseCaches(false);
        this.Ja.setDoOutput(true);
        this.Ja.setDoInput(true);
        this.Ja.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.Ja.setRequestProperty("User-Agent", str3);
        this.Jb = this.Ja.getOutputStream();
        this.Jc = new PrintWriter((Writer) new OutputStreamWriter(this.Jb, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.Jc.append((CharSequence) "\r\n").flush();
        this.Jc.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.Jc.close();
        int responseCode = this.Ja.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.Ja.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.Ja.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.Jc.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.Jc.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.Jc.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.Jc.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.Jc.append((CharSequence) "\r\n");
        this.Jc.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.Jb.flush();
                fileInputStream.close();
                this.Jc.append((CharSequence) "\r\n");
                this.Jc.flush();
                return;
            }
            this.Jb.write(bArr, 0, read);
        }
    }
}
