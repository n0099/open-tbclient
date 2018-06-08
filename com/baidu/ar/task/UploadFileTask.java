package com.baidu.ar.task;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.MediaUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.ar.util.Utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes3.dex */
public class UploadFileTask extends AsyncTask<String, Integer, a> {
    private static final String a = UploadFileTask.class.getSimpleName();
    private static final String b = UUID.randomUUID().toString();
    private long c;
    private String d;
    private String e;
    private String f;
    private Map<String, String> g;
    private String h;
    private OnFileUploadListener i;

    public UploadFileTask(String str, String str2, String str3, Map<String, String> map, String str4, OnFileUploadListener onFileUploadListener) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = map;
        this.h = str4;
        this.i = onFileUploadListener;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x0030 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0281 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x030b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:90:0x0370 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.io.DataOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.io.DataOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.DataOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a a() {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream = 10001;
        int i = 0;
        a aVar = new a();
        File file = new File(this.d);
        if (!file.exists() || file.length() <= 0) {
            aVar.a = 10001;
            aVar.b = "file not found ";
            return aVar;
        }
        this.c = file.length();
        try {
            try {
                if (this.h != null && this.h.equalsIgnoreCase("video") && (this.e == null || !new File(this.e).exists())) {
                    this.e = b();
                }
                if (ARConfig.isAipAuth()) {
                    this.f += "?access_token=" + ARConfig.getToken();
                }
                httpURLConnection = (HttpURLConnection) new URL(this.f).openConnection();
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Charset", IoUtils.UTF_8);
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + b);
                httpURLConnection.setChunkedStreamingMode(0);
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.write(a(this.g).toString().getBytes(StandardCharsets.UTF_8));
                } catch (MalformedURLException e) {
                    e = e;
                    e.printStackTrace();
                    DataOutputStream dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream != 0) {
                        try {
                            dataOutputStream.close();
                            dataOutputStream2 = null;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            dataOutputStream2 = dataOutputStream;
                        }
                    }
                    aVar.a = 10002;
                    aVar.b = e.getMessage();
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return aVar;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    DataOutputStream dataOutputStream3 = dataOutputStream;
                    if (dataOutputStream != 0) {
                        try {
                            dataOutputStream.close();
                            dataOutputStream3 = null;
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            dataOutputStream3 = dataOutputStream;
                        }
                    }
                    aVar.a = 10001;
                    aVar.b = e.getMessage();
                    if (dataOutputStream3 != null) {
                        try {
                            dataOutputStream3.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return aVar;
                }
            } catch (Throwable th) {
                th = th;
                if (dataOutputStream != 0) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (MalformedURLException e8) {
            e = e8;
            dataOutputStream = 0;
        } catch (IOException e9) {
            e = e9;
            dataOutputStream = 0;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream = 0;
            if (dataOutputStream != 0) {
            }
            throw th;
        }
        if (!file.exists()) {
            ARLog.e("file not exist");
            aVar.a = 10001;
            aVar.b = "file not found ";
            if (dataOutputStream != 0) {
                try {
                    dataOutputStream.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(b);
        sb.append(SystemInfoUtil.LINE_END);
        sb.append("Content-Disposition: form-data; name=\"" + this.h + "\"; filename=\"" + file.getName() + "\"" + SystemInfoUtil.LINE_END);
        sb.append("Content-Type: " + this.h + SystemInfoUtil.LINE_END);
        sb.append(SystemInfoUtil.LINE_END);
        dataOutputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        if (file.exists()) {
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
                int i2 = (int) ((((float) (100 * j)) * 1.0f) / ((float) this.c));
                if (i2 > i) {
                    publishProgress(Integer.valueOf(i2));
                }
                i = i2;
            }
            publishProgress(100);
            fileInputStream.close();
            dataOutputStream.write(SystemInfoUtil.LINE_END.getBytes(StandardCharsets.UTF_8));
        }
        if (this.e != null && new File(this.e).exists()) {
            File file2 = new File(this.e);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("--");
            sb2.append(b);
            sb2.append(SystemInfoUtil.LINE_END);
            this.h = "thumbImg";
            sb2.append("Content-Disposition: form-data; name=\"" + this.h + "\"; filename=\"" + file2.getName() + "\"" + SystemInfoUtil.LINE_END);
            sb2.append("Content-Type: application/octet-stream\r\n");
            sb2.append(SystemInfoUtil.LINE_END);
            dataOutputStream.write(sb2.toString().getBytes(StandardCharsets.UTF_8));
            if (file2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read2 = fileInputStream2.read(bArr2);
                    if (read2 == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr2, 0, read2);
                }
                fileInputStream2.close();
                dataOutputStream.write(SystemInfoUtil.LINE_END.getBytes(StandardCharsets.UTF_8));
            }
        }
        dataOutputStream.write(("--" + b + "--" + SystemInfoUtil.LINE_END).getBytes(StandardCharsets.UTF_8));
        dataOutputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            char[] cArr = new char[512];
            while (true) {
                int read3 = bufferedReader.read(cArr);
                if (read3 == -1) {
                    break;
                }
                stringBuffer.append(new String(cArr, 0, read3));
            }
            String stringBuffer2 = stringBuffer.toString();
            aVar.a = responseCode;
            aVar.b = stringBuffer2;
        } else {
            aVar.a = responseCode;
            aVar.b = httpURLConnection.getResponseMessage();
            ARLog.e("request error ,and the code is : " + responseCode + " , reason is : " + httpURLConnection.getResponseMessage());
        }
        if (dataOutputStream != 0) {
            try {
                dataOutputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
        return aVar;
    }

    private static StringBuffer a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    stringBuffer.append("--");
                    stringBuffer.append(b);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + SystemInfoUtil.LINE_END);
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), IoUtils.UTF_8));
                    stringBuffer.append(SystemInfoUtil.LINE_END);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    private String b() {
        Bitmap frameAtTime = MediaUtils.getFrameAtTime(this.d, 250L, 2);
        if (frameAtTime != null) {
            return Utils.saveBitmap(frameAtTime, Utils.getDir(), ".AR_video_thumbnail.jpg");
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public a doInBackground(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(a aVar) {
        super.onPostExecute(aVar);
        if (aVar != null) {
            if (aVar.a == 200) {
                this.i.onSuccess(aVar.a, aVar.b);
            } else {
                this.i.onFailure(aVar.a, aVar.b);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.i.onProgressUpdate(numArr[0].intValue());
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        this.i.onStartUpload();
    }
}
