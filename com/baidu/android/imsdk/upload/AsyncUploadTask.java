package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
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
/* loaded from: classes2.dex */
public class AsyncUploadTask extends AsyncTask<Void, Integer, Integer> {
    public static final int DOWNLOAD_BYTES_SIZE = 8192;
    public static final String TAG = AsyncUploadTask.class.getSimpleName();
    public String mAuthorization;
    public String mContentType;
    public Context mContext;
    public String mFilePath;
    public IUploadTransferListener mListener;
    public String mRemoteUrl;
    public int mType;
    public String mUrl;
    public String mXbcs;

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

    private Integer doUpload() {
        long length;
        InputStream fileInputStream;
        try {
            long j = 0;
            if (Utility.isMediaUri(this.mFilePath)) {
                fileInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mFilePath));
                length = fileInputStream != null ? fileInputStream.available() : 0L;
            } else {
                File file = new File(this.mFilePath);
                if (file.exists() && !file.isDirectory()) {
                    length = file.length();
                    fileInputStream = new FileInputStream(this.mFilePath);
                }
                return 1007;
            }
            if (fileInputStream == null) {
                return 1007;
            }
            String str = TAG;
            LogUtils.d(str, "upload url is " + this.mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "utf-8");
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
                HttpURLConnection httpURLConnection2 = httpURLConnection;
                j += read;
                String str2 = TAG;
                LogUtils.d(str2, "write bytes:" + read + "  total:" + j + "  time:" + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 1000.0f));
                onProgressUpdate(Integer.valueOf((int) ((100 * j) / length)));
                httpURLConnection = httpURLConnection2;
            }
            fileInputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String str3 = TAG;
                LogUtils.i(str3, "upload success " + responseCode);
                return 0;
            }
            String str4 = TAG;
            LogUtils.e(str4, "upload failure " + responseCode);
            return 1008;
        } catch (MalformedURLException e2) {
            String str5 = TAG;
            Log.e(str5, "MalformedURLException:" + e2);
            return 1008;
        } catch (ProtocolException e3) {
            String str6 = TAG;
            Log.e(str6, "ProtocolException:" + e3);
            return 1008;
        } catch (IOException e4) {
            String str7 = TAG;
            Log.e(str7, "IOException:" + e4);
            return 1008;
        }
    }

    private void notifyFailed(int i) {
        try {
            if (this.mListener != null) {
                this.mListener.onFailed(i, this.mType, this.mFilePath);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "notifyFailed", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    private void notifyFinished() {
        try {
            if (this.mListener != null) {
                this.mListener.onFinished(this.mType, this.mRemoteUrl);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "notifyFinished", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    public String showTime() {
        return new SimpleDateFormat("MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return 1002;
        }
        return doUpload();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        if (num.equals(0)) {
            notifyFinished();
        } else {
            notifyFailed(num.intValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        IUploadTransferListener iUploadTransferListener = this.mListener;
        if (iUploadTransferListener != null) {
            iUploadTransferListener.onProgress(numArr[0].intValue());
        }
    }

    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, String str6, IUploadTransferListener iUploadTransferListener) {
        this(context, i, str, str3, str4, str5, str6, iUploadTransferListener);
        this.mRemoteUrl = str2;
    }
}
