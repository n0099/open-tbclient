package com.baidu.android.imsdk.upload;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidubce.http.Headers;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
/* loaded from: classes2.dex */
public class AsyncUploadTask extends AsyncTask<Void, Integer, Integer> {
    private static final int RESPONSE_TIMEOUT = 6000;
    public static final String TAG = AsyncUploadTask.class.getSimpleName();
    private static final int UPLOAD_TIMEOUT = 30000;
    private AsyncChatTask mAsycChatTask;
    private String mAuthorization;
    private String mContentType;
    private Context mContext;
    private String mFilePath;
    private int mType;
    private String mUrl;
    private String mXbcs;

    public AsyncUploadTask(Context context, int i, String str, String str2, String str3, String str4, String str5, AsyncChatTask asyncChatTask) {
        this.mContext = context;
        this.mAsycChatTask = asyncChatTask;
        this.mUrl = str;
        this.mType = i;
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
        this.mAsycChatTask.onProgress(numArr[0].intValue());
    }

    private Integer doUpload() {
        int i;
        try {
            File file = new File(this.mFilePath);
            if (!file.exists() || file.isDirectory()) {
                i = 1007;
            } else {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 6000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 6000);
                HttpClientParams.setRedirecting(basicHttpParams, true);
                HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                final HttpPut httpPut = new HttpPut(this.mUrl);
                httpPut.addHeader("Content-type", this.mContentType);
                httpPut.addHeader("Authorization", this.mAuthorization);
                httpPut.addHeader(Headers.BCE_DATE, this.mXbcs);
                IMUpLoadFileEntity iMUpLoadFileEntity = new IMUpLoadFileEntity(file, "UTF-8");
                iMUpLoadFileEntity.setTransferListener(this.mAsycChatTask);
                httpPut.setEntity(iMUpLoadFileEntity);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() { // from class: com.baidu.android.imsdk.upload.AsyncUploadTask.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        httpPut.abort();
                    }
                }, 30000L);
                HttpResponse execute = defaultHttpClient.execute(httpPut);
                timer.cancel();
                if (execute.getStatusLine().getStatusCode() == 200 || execute.getStatusLine().getStatusCode() == 201) {
                    LogUtils.i(TAG, "upload success " + execute.getStatusLine().getStatusCode());
                    i = 0;
                } else {
                    LogUtils.e(TAG, "upload failure " + execute.getStatusLine());
                    i = 1008;
                }
            }
            return i;
        } catch (Exception e) {
            LogUtils.e(LogUtils.TAG, "Exception:" + e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
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
            if (this.mAsycChatTask != null) {
                this.mAsycChatTask.onFailed(i, this.mType, this.mFilePath);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "notifyFailed", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    private void notifyFinished() {
        try {
            if (this.mAsycChatTask != null) {
                this.mAsycChatTask.onFinished(this.mType, this.mFilePath);
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
