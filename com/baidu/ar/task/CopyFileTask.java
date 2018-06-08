package com.baidu.ar.task;

import android.os.AsyncTask;
import com.baidu.ar.util.Utils;
import java.io.File;
/* loaded from: classes3.dex */
public class CopyFileTask extends AsyncTask<String, Integer, Boolean> {
    OnCopyFileListener a;

    /* loaded from: classes3.dex */
    public interface OnCopyFileListener {
        void onFail();

        void onSuccess();
    }

    public CopyFileTask(OnCopyFileListener onCopyFileListener) {
        this.a = onCopyFileListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(Utils.copyfile(new File(strArr[0]), new File(strArr[1]), new Boolean(true)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool.booleanValue()) {
            if (this.a != null) {
                this.a.onSuccess();
            }
        } else if (this.a != null) {
            this.a.onFail();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
