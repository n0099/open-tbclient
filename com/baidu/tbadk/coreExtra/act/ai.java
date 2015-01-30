package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, Bitmap> {
    com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ Login2Activity QG;
    private volatile boolean kN;

    private ai(Login2Activity login2Activity) {
        this.QG = login2Activity;
        this.AR = null;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(Login2Activity login2Activity, ai aiVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.QG.QE = null;
        if (this.AR != null) {
            this.AR.dJ();
            this.AR = null;
        }
        this.kN = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.QG.Qi;
        imageView.setImageDrawable(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.kN) {
            return null;
        }
        this.AR = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AR.oz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.QG.QE = null;
        if (bitmap != null) {
            imageView2 = this.QG.Qi;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.QG.Qi;
            imageView.setImageResource(com.baidu.tieba.v.background);
        }
        progressBar = this.QG.mProgressBar;
        progressBar.setVisibility(8);
        super.onPostExecute((ai) bitmap);
    }
}
