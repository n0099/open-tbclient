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
/* loaded from: classes8.dex */
public final class f {
    final String a = "===" + System.currentTimeMillis() + "===";
    private HttpURLConnection adA;
    private OutputStream adB;
    PrintWriter adC;
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.adA = (HttpURLConnection) new URL(str).openConnection();
        this.adA.setUseCaches(false);
        this.adA.setDoOutput(true);
        this.adA.setDoInput(true);
        this.adA.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.adA.setRequestProperty("User-Agent", str3);
        this.adB = this.adA.getOutputStream();
        this.adC = new PrintWriter((Writer) new OutputStreamWriter(this.adB, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.adC.append((CharSequence) "\r\n").flush();
        this.adC.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.adC.close();
        int responseCode = this.adA.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.adA.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.adA.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.adC.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.adC.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.adC.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.adC.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.adC.append((CharSequence) "\r\n");
        this.adC.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.adB.flush();
                fileInputStream.close();
                this.adC.append((CharSequence) "\r\n");
                this.adC.flush();
                return;
            }
            this.adB.write(bArr, 0, read);
        }
    }
}
