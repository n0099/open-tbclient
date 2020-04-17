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
    private HttpURLConnection acH;
    private OutputStream acI;
    PrintWriter acJ;
    String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.acH = (HttpURLConnection) new URL(str).openConnection();
        this.acH.setUseCaches(false);
        this.acH.setDoOutput(true);
        this.acH.setDoInput(true);
        this.acH.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.acH.setRequestProperty("User-Agent", str3);
        this.acI = this.acH.getOutputStream();
        this.acJ = new PrintWriter((Writer) new OutputStreamWriter(this.acI, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.acJ.append((CharSequence) "\r\n").flush();
        this.acJ.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) "\r\n");
        this.acJ.close();
        int responseCode = this.acH.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.acH.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.acH.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.acJ.append((CharSequence) ("--" + this.a)).append((CharSequence) "\r\n");
        this.acJ.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) "\r\n");
        this.acJ.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) "\r\n");
        this.acJ.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
        this.acJ.append((CharSequence) "\r\n");
        this.acJ.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.acI.flush();
                fileInputStream.close();
                this.acJ.append((CharSequence) "\r\n");
                this.acJ.flush();
                return;
            }
            this.acI.write(bArr, 0, read);
        }
    }
}
