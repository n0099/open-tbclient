package com.baidu.ar.load;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.task.ActionResponseListener;
import com.baidu.ar.util.ARLog;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class QueryTask extends ARAsyncTask<Object, Double, String> {
    public static final int REQUEST_MODE_GET = 0;
    public static final int REQUEST_MODE_POST = 1;
    public static final int STATUS_CANCEL = 3;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_TIMEOUT = 2;
    private ExtraOperateListener mExtraOperateListener;
    private String mHttpParams;
    private ActionResponseListener<String> mListener;
    private int mRequestMode;
    private String mUrl;
    private boolean mIsPause = false;
    private boolean mUseParallel = false;

    /* loaded from: classes3.dex */
    public interface ExtraOperateListener {
        String excuteChangeResult(String str);
    }

    public QueryTask(String str, String str2, int i, ActionResponseListener<String> actionResponseListener, ExtraOperateListener extraOperateListener) {
        this.mUrl = null;
        this.mHttpParams = null;
        this.mRequestMode = 0;
        this.mUrl = str;
        this.mHttpParams = str2;
        this.mRequestMode = i;
        this.mListener = actionResponseListener;
        this.mExtraOperateListener = extraOperateListener;
    }

    private void checkPauseValid() {
        while (this.mIsPause) {
            ARLog.d("mIsPause = " + this.mIsPause);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String doQuery() {
        if (TextUtils.isEmpty(this.mUrl)) {
            ARLog.e("mUrl is null!");
            return null;
        }
        String executeExtraOperation = executeExtraOperation(this.mHttpParams);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mUrl).openConnection();
            httpURLConnection.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            if (this.mRequestMode == 0) {
                httpURLConnection.setRequestMethod("GET");
            } else if (this.mRequestMode == 1) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                ARLog.d("post params = " + executeExtraOperation);
                dataOutputStream.write(executeExtraOperation.getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            checkPauseValid();
            return readLine;
        } catch (IOException e) {
            e.printStackTrace();
            ARLog.e("IOException: " + e.getMessage());
            return null;
        }
    }

    private String executeExtraOperation(String str) {
        if (this.mExtraOperateListener != null) {
            String excuteChangeResult = this.mExtraOperateListener.excuteChangeResult(str);
            return !TextUtils.isEmpty(excuteChangeResult) ? excuteChangeResult : str;
        }
        return str;
    }

    public void cancel() {
        this.mIsPause = false;
        cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public String doInBackground(Object[] objArr) {
        if (TextUtils.isEmpty(this.mUrl)) {
            return null;
        }
        return doQuery();
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onCancelled() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(3, "query cancel!", null));
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onError(String str) {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "query task execute error:" + str, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.mListener != null) {
                this.mListener.onResponse(ResponseUtil.getActionResponseInfo(1, "query result is null!", null));
                return;
            }
            return;
        }
        onProgressUpdate(Double.valueOf(100.0d));
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(0, "query success!", str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    public void onProgressUpdate(Double... dArr) {
        super.onProgressUpdate((Object[]) dArr);
        if (dArr.length <= 0 || this.mListener == null) {
            return;
        }
        this.mListener.onProgress(dArr[0].intValue());
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onTimeout() {
        if (this.mListener != null) {
            this.mListener.onResponse(ResponseUtil.getActionResponseInfo(2, "query time out!", null));
        }
    }

    public void pause() {
        this.mIsPause = true;
    }

    public void resume() {
        this.mIsPause = false;
    }

    public void setParallel() {
        this.mUseParallel = true;
    }

    public void start() {
        if (this.mUseParallel) {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }

    public void startDelay(long j) {
        if (this.mUseParallel) {
            postDelay(j, 1);
        } else {
            postDelay(j, 0);
        }
    }
}
