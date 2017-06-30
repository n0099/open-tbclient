package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ b adp;
    private final /* synthetic */ ContentValues adq;
    private final /* synthetic */ Uri val$uri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.adp = bVar;
        this.val$uri = uri;
        this.adq = contentValues;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        this.adp.setValueInner(this.val$uri, this.adq);
        return null;
    }
}
