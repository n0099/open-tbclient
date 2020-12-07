package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidubce.http.Headers;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.HTTP;
/* loaded from: classes9.dex */
public class AsyncUploadTask extends AsyncTask<Void, Integer, Integer> {
    private static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG = AsyncUploadTask.class.getSimpleName();
    private String mAuthorization;
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private IUploadTransferListener mListener;
    private String mRemoteUrl;
    private int mType;
    private String mUrl;
    private String mXbcs;

    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, IUploadTransferListener iUploadTransferListener) {
        this.mRemoteUrl = "";
        this.mContext = context;
        this.mListener = iUploadTransferListener;
        this.mUrl = str;
        this.mType = i;
        this.mFilePath = str2;
        this.mContentType = str3;
        this.mAuthorization = str4;
        this.mXbcs = str5;
    }

    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        this(context, i, str, str3, str4, str5, str6, iUploadTransferListener);
        this.mRemoteUrl = str2;
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
        if (this.mListener != null) {
            this.mListener.onProgress(numArr[0].intValue());
        }
    }

    private Integer doUpload() {
        long length;
        FileInputStream fileInputStream;
        long j = 0;
        try {
            if (Utility.isMediaUri(this.mFilePath)) {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                if (openInputStream != null) {
                    length = openInputStream.available();
                    fileInputStream = openInputStream;
                } else {
                    fileInputStream = openInputStream;
                    length = 0;
                }
            } else {
                File file = new File(this.mFilePath);
                if (!file.exists() || file.isDirectory()) {
                    return 1007;
                }
                length = file.length();
                fileInputStream = new FileInputStream(this.mFilePath);
            }
            if (fileInputStream == null) {
                return 1007;
            }
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
            byte[] bArr = new byte[8192];
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, read);
                j += read;
                LogUtils.d(TAG, "write bytes:" + read + "  total:" + j + "  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
                onProgressUpdate(Integer.valueOf((int) ((100 * j) / length)));
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
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException:" + e);
            return 1008;
        } catch (ProtocolException e2) {
            Log.e(TAG, "ProtocolException:" + e2);
            return 1008;
        } catch (IOException e3) {
            Log.e(TAG, "IOException:" + e3);
            return 1008;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        if (num.equals(0)) {
            notifyFinished();
        } else {
            notifyFailed(num.intValue());
        }
    }

    private void notifyFailed(int i) {
        try {
            if (this.mListener != null) {
                this.mListener.onFailed(i, this.mType, this.mFilePath);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "notifyFailed", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    private void notifyFinished() {
        try {
            if (this.mListener != null) {
                this.mListener.onFinished(this.mType, this.mRemoteUrl);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "notifyFinished", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public String showTime() {
        return new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }
}
