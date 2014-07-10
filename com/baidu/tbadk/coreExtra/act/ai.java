package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, Bitmap> {
    aq a;
    final /* synthetic */ Login2Activity b;
    private volatile boolean c;

    private ai(Login2Activity login2Activity) {
        this.b = login2Activity;
        this.a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(Login2Activity login2Activity, ai aiVar) {
        this(login2Activity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.O = null;
        if (this.a != null) {
            this.a.g();
            this.a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ImageView imageView;
        imageView = this.b.s;
        imageView.setImageBitmap(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.c) {
            return null;
        }
        this.a = new aq(str);
        return com.baidu.tbadk.core.util.h.a(this.a.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.b.O = null;
        if (bitmap != null) {
            imageView2 = this.b.s;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.b.s;
            imageView.setImageResource(com.baidu.tieba.u.background);
        }
        progressBar = this.b.v;
        progressBar.setVisibility(8);
        super.onPostExecute(bitmap);
    }
}
