package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ Login2Activity KT;
    private volatile boolean kJ;
    com.baidu.tbadk.core.util.ac mNetWork;

    private ai(Login2Activity login2Activity) {
        this.KT = login2Activity;
        this.mNetWork = null;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(Login2Activity login2Activity, ai aiVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.KT.KR = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
            this.mNetWork = null;
        }
        this.kJ = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.KT.Kw;
        imageView.setImageDrawable(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.kJ) {
            return null;
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(str);
        return com.baidu.tbadk.core.util.d.w(this.mNetWork.lB());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.KT.KR = null;
        if (bitmap != null) {
            imageView2 = this.KT.Kw;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.KT.Kw;
            imageView.setImageResource(com.baidu.tieba.u.background);
        }
        progressBar = this.KT.mProgressBar;
        progressBar.setVisibility(8);
        super.onPostExecute(bitmap);
    }
}
