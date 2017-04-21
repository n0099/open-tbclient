package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ b ads;
    private final /* synthetic */ ContentValues adt;
    private final /* synthetic */ Uri val$uri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.ads = bVar;
        this.val$uri = uri;
        this.adt = contentValues;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        this.ads.b(this.val$uri, this.adt);
        return null;
    }
}
