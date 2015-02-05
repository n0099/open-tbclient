package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, Bitmap> {
    com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ Login2Activity QD;
    private volatile boolean kN;

    private ai(Login2Activity login2Activity) {
        this.QD = login2Activity;
        this.AO = null;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(Login2Activity login2Activity, ai aiVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.QD.QB = null;
        if (this.AO != null) {
            this.AO.dJ();
            this.AO = null;
        }
        this.kN = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.QD.Qf;
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
        this.AO = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AO.os());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.QD.QB = null;
        if (bitmap != null) {
            imageView2 = this.QD.Qf;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.QD.Qf;
            imageView.setImageResource(com.baidu.tieba.v.background);
        }
        progressBar = this.QD.mProgressBar;
        progressBar.setVisibility(8);
        super.onPostExecute((ai) bitmap);
    }
}
