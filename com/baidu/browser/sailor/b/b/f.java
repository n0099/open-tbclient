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
    private HttpURLConnection WH;
    PrintWriter WI;
    final String a = "===" + System.currentTimeMillis() + "===";
    String b;
    private OutputStream e;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, String str2, String str3) throws IOException {
        this.b = str2;
        this.WH = (HttpURLConnection) new URL(str).openConnection();
        this.WH.setUseCaches(false);
        this.WH.setDoOutput(true);
        this.WH.setDoInput(true);
        this.WH.setRequestProperty("Content-Type", "multipart/form-data; mBoundary=" + this.a);
        this.WH.setRequestProperty(HTTP.USER_AGENT, str3);
        this.e = this.WH.getOutputStream();
        this.WI = new PrintWriter((Writer) new OutputStreamWriter(this.e, str2), true);
    }

    public final List<String> a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.WI.append((CharSequence) SystemInfoUtil.LINE_END).flush();
        this.WI.append((CharSequence) ("--" + this.a + "--")).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.close();
        int responseCode = this.WH.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.WH.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                this.WH.disconnect();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    public final void a(String str, File file) throws IOException {
        String name = file.getName();
        this.WI.append((CharSequence) ("--" + this.a)).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + name + "\"")).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.append((CharSequence) ("Content-Type: " + URLConnection.guessContentTypeFromName(name))).append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.append((CharSequence) SystemInfoUtil.LINE_END);
        this.WI.flush();
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                this.e.flush();
                fileInputStream.close();
                this.WI.append((CharSequence) SystemInfoUtil.LINE_END);
                this.WI.flush();
                return;
            }
            this.e.write(bArr, 0, read);
        }
    }
}
