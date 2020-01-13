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
/* loaded from: classes10.dex */
public final class f {
    private HttpURLConnection Jh;
    private OutputStream Ji;
    PrintWriter Jj;
    final String a = "===" + System.currentTimeMillis() + "===";
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.Jh = (HttpURLConnection) new URL(str).openConnection();
        this.Jh.setUseCaches(false);
        this.Jh.setDoOutput(true);
        this.Jh.setDoInput(true);
        this.Jh.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.Jh.setRequestProperty("User-Agent", str3);
        this.Ji = this.Jh.getOutputStream();
        this.Jj = new PrintWriter((Writer) new OutputStreamWriter(this.Ji, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.Jj.append((CharSequence) "\r\n").flush();
        this.Jj.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.Jj.close();
        int responseCode = this.Jh.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.Jh.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.Jh.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.Jj.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.Jj.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.Jj.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.Jj.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.Jj.append((CharSequence) "\r\n");
        this.Jj.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.Ji.flush();
                fileInputStream.close();
                this.Jj.append((CharSequence) "\r\n");
                this.Jj.flush();
                return;
            }
            this.Ji.write(bArr, 0, read);
        }
    }
}
