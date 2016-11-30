package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ b Zf;
    private final /* synthetic */ Uri Zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Zf = bVar;
        this.Zg = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        this.Zf.e(this.Zg);
        return null;
    }
}
