package com.baidu.searchbox.ugc.utils;

import android.os.AsyncTask;
/* loaded from: classes11.dex */
public abstract class BaseTask extends AsyncTask<Void, Void, Result> {
    protected String error = "";
    protected boolean interrupt = false;
    protected OnTaskResultListener resultListener = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Result result) {
        if (!this.interrupt && this.resultListener != null && result != null) {
            this.resultListener.onResult(result.isSuccess, this.error, result.list);
        }
    }

    public void cancel() {
        super.cancel(true);
        this.interrupt = true;
    }

    public void setOnResultListener(OnTaskResultListener onTaskResultListener) {
        this.resultListener = onTaskResultListener;
    }

    /* loaded from: classes11.dex */
    public static final class Result {
        public boolean isSuccess;
        public Object list;

        public Result(boolean z, Object obj) {
            this.isSuccess = z;
            this.list = obj;
        }
    }
}
