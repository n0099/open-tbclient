package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, Bitmap> {
    com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ Login2Activity Qf;
    private volatile boolean kK;

    private ai(Login2Activity login2Activity) {
        this.Qf = login2Activity;
        this.AR = null;
        this.kK = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(Login2Activity login2Activity, ai aiVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.Qf.Qd = null;
        if (this.AR != null) {
            this.AR.dL();
            this.AR = null;
        }
        this.kK = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.Qf.PG;
        imageView.setImageDrawable(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.kK) {
            return null;
        }
        this.AR = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AR.ow());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.Qf.Qd = null;
        if (bitmap != null) {
            imageView2 = this.Qf.PG;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.Qf.PG;
            imageView.setImageResource(com.baidu.tieba.v.background);
        }
        progressBar = this.Qf.mProgressBar;
        progressBar.setVisibility(8);
        super.onPostExecute((ai) bitmap);
    }
}
