package com.baidu.browser.sailor.b.b;

import com.baidu.ar.util.SystemInfoUtil;
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
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class f {
    private HttpURLConnection WS;
    PrintWriter WT;
    final String a = "===" + System.currentTimeMillis() + "===";
    String b;
    private OutputStream e;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.WS = (HttpURLConnection) new URL(str).openConnection();
        this.WS.setUseCaches(false);
        this.WS.setDoOutput(true);
        this.WS.setDoInput(true);
        this.WS.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.WS.setRequestProperty(HTTP.USER_AGENT, str3);
        this.e = this.WS.getOutputStream();
        this.WT = new PrintWriter((Writer) new OutputStreamWriter(this.e, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.WT.append((CharSequence) SystemInfoUtil.LINE_END).flush();
        this.WT.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.close();
        int responseCode = this.WS.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.WS.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.WS.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.WT.append((CharSequence) ("--" + this.a)).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.append((CharSequence) SystemInfoUtil.LINE_END);
        this.WT.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.e.flush();
                fileInputStream.close();
                this.WT.append((CharSequence) SystemInfoUtil.LINE_END);
                this.WT.flush();
                return;
            }
            this.e.write(bArr, 0, read);
        }
    }
}
