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
    private HttpURLConnection JC;
    private OutputStream JD;
    PrintWriter JE;
    final String a = "===" + System.currentTimeMillis() + "===";
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.JC = (HttpURLConnection) new URL(str).openConnection();
        this.JC.setUseCaches(false);
        this.JC.setDoOutput(true);
        this.JC.setDoInput(true);
        this.JC.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.JC.setRequestProperty("User-Agent", str3);
        this.JD = this.JC.getOutputStream();
        this.JE = new PrintWriter((Writer) new OutputStreamWriter(this.JD, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.JE.append((CharSequence) "\r\n").flush();
        this.JE.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.JE.close();
        int responseCode = this.JC.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.JC.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.JC.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.JE.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.JE.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.JE.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.JE.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.JE.append((CharSequence) "\r\n");
        this.JE.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.JD.flush();
                fileInputStream.close();
                this.JE.append((CharSequence) "\r\n");
                this.JE.flush();
                return;
            }
            this.JD.write(bArr, 0, read);
        }
    }
}
