package com.baidu.ar.i.a;

import android.os.AsyncTask;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes3.dex */
public class d extends AsyncTask<String, Integer, b> {
    private static final String a = d.class.getSimpleName();
    private static final String b = UUID.randomUUID().toString();
    private String c;
    private String d;
    private String e;
    private Map<String, String> f;
    private String g;
    private c h;
    private long i;

    public d(String str, String str2, String str3, Map<String, String> map, String str4, c cVar) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = map;
        this.g = str4;
        this.h = cVar;
    }

    private b a(String str) {
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        StringBuffer stringBuffer;
        b bVar = new b();
        File file = new File(this.c);
        if (!file.exists() || file.length() <= 0) {
            bVar.a = 10001;
            bVar.b = "file not found ";
            return bVar;
        }
        this.i = file.length();
        try {
            httpURLConnection = (HttpURLConnection) new URL(this.e).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + b);
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        } catch (MalformedURLException e) {
            e = e;
            dataOutputStream = null;
        } catch (IOException e2) {
            e = e2;
            dataOutputStream = null;
        }
        try {
            stringBuffer = new StringBuffer();
            stringBuffer.append(a(this.f));
        } catch (MalformedURLException e3) {
            e = e3;
            e.printStackTrace();
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            bVar.a = 10002;
            bVar.b = e.getMessage();
            return bVar;
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            bVar.a = 10001;
            bVar.b = e.getMessage();
            return bVar;
        }
        if (file == null) {
            com.baidu.ar.util.b.d("file not exist");
            bVar.a = 10001;
            bVar.b = "file not found ";
            return bVar;
        }
        stringBuffer.append("--");
        stringBuffer.append(b);
        stringBuffer.append("\r\n");
        stringBuffer.append("Content-Disposition: form-data; name=\"" + this.g + "\"; filename=\"" + file.getName() + "\"\r\n");
        stringBuffer.append("Content-Type: " + this.g + "\r\n");
        stringBuffer.append("\r\n");
        dataOutputStream.write(stringBuffer.toString().getBytes());
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
                j += read;
                publishProgress(Integer.valueOf((int) ((((float) (100 * j)) * 1.0f) / ((float) this.i))));
            }
            fileInputStream.close();
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(("--" + b + "--\r\n").getBytes());
            publishProgress(100);
        }
        if (this.d != null && new File(this.d).exists()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            File file2 = new File(this.d);
            stringBuffer2.append("--");
            stringBuffer2.append(b);
            stringBuffer2.append("\r\n");
            this.g = "thumbImg";
            stringBuffer2.append("Content-Disposition: form-data; name=\"" + this.g + "\"; filename=\"" + file2.getName() + "\"\r\n");
            stringBuffer2.append("Content-Type: " + this.g + "\r\n");
            stringBuffer2.append("\r\n");
            dataOutputStream.write(stringBuffer2.toString().getBytes());
            if (file2 != null) {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                byte[] bArr2 = new byte[1024];
                long j2 = 0;
                while (true) {
                    int read2 = fileInputStream2.read(bArr2);
                    if (read2 == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr2, 0, read2);
                    j2 += read2;
                }
                fileInputStream2.close();
                dataOutputStream.write("\r\n".getBytes());
                dataOutputStream.write(("--" + b + "--\r\n").getBytes());
            }
        }
        dataOutputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer3 = new StringBuffer();
            while (true) {
                int read3 = inputStream.read();
                if (read3 == -1) {
                    break;
                }
                stringBuffer3.append((char) read3);
            }
            String stringBuffer4 = stringBuffer3.toString();
            bVar.a = responseCode;
            bVar.b = stringBuffer4;
            com.baidu.ar.util.b.d("result : " + stringBuffer4);
        } else {
            bVar.a = responseCode;
            bVar.b = httpURLConnection.getResponseMessage();
            com.baidu.ar.util.b.d("request error ,and the code is : " + responseCode + " , reason is : " + httpURLConnection.getResponseMessage());
        }
        dataOutputStream.close();
        return bVar;
    }

    private static StringBuffer a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    stringBuffer.append("--");
                    stringBuffer.append(b);
                    stringBuffer.append("\r\n");
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n");
                    stringBuffer.append("\r\n");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "utf-8"));
                    stringBuffer.append("\r\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public b doInBackground(String... strArr) {
        return a(strArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(b bVar) {
        super.onPostExecute(bVar);
        if (bVar != null) {
            if (bVar.a == 200) {
                this.h.a(bVar.a, bVar.b);
            } else {
                this.h.b(bVar.a, bVar.b);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.h.a(numArr[0].intValue());
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.h.a();
    }
}
