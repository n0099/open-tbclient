package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.http.Headers;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
/* loaded from: classes18.dex */
public class FileUploadTask extends AsyncTask<Void, Integer, Integer> {
    private static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG = FileUploadTask.class.getSimpleName();
    private String mAuthorization;
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private IFileUploadListener mListener;
    private String mUrl;
    private String mXbcs;

    public FileUploadTask(Context context, String str, String str2, String str3, String str4, String str5, IFileUploadListener iFileUploadListener) {
        this.mContext = context;
        this.mListener = iFileUploadListener;
        this.mUrl = str;
        this.mFilePath = str2;
        this.mContentType = str3;
        this.mAuthorization = str4;
        this.mXbcs = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return 1002;
        }
        return doUpload();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        this.mListener.onProgress(numArr[0].intValue());
    }

    private Integer doUpload() {
        try {
            File file = new File(this.mFilePath);
            if (!file.exists() || file.isDirectory()) {
                return 1007;
            }
            this.mUrl = replaceToHttps(this.mUrl);
            LogUtils.d(TAG, "upload url is " + this.mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-type", this.mContentType);
            httpURLConnection.setRequestProperty("Authorization", this.mAuthorization);
            httpURLConnection.setRequestProperty(Headers.BCE_DATE, this.mXbcs);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            FileInputStream fileInputStream = new FileInputStream(this.mFilePath);
            byte[] bArr = new byte[8192];
            long j = 0;
            long length = file.length();
            int i = -1;
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
                j += read;
                LogUtils.d(TAG, "write bytes:" + read + "  total:" + j + "  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
                int i2 = (int) ((100 * j) / length);
                if (i2 != i) {
                    this.mListener.onProgress(i2);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            fileInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                LogUtils.i(TAG, "upload success " + responseCode);
                return 0;
            }
            LogUtils.e(TAG, "upload failure " + responseCode);
            return 1008;
        } catch (Exception e) {
            LogUtils.e(TAG, "IOException:" + e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            return 1008;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        if (num.equals(0)) {
            LogUtils.d(TAG, "upload ok");
            notifyFinished();
            return;
        }
        LogUtils.d(TAG, "upload failure ");
        notifyFailed(num.intValue());
    }

    private void notifyFailed(int i) {
        try {
            if (this.mListener != null) {
                this.mListener.onFailed(i, "upload failure");
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "IOException notifyFailed:" + e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    private void notifyFinished() {
        try {
            if (this.mListener != null) {
                this.mListener.onFinished(0);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "IOException notifyFinished:" + e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public String replaceToHttps(String str) {
        return str.replace("http://", SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
