package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ b Zf;
    private final /* synthetic */ Uri Zg;
    private final /* synthetic */ ContentValues Zh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Zf = bVar;
        this.Zg = uri;
        this.Zh = contentValues;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        this.Zf.b(this.Zg, this.Zh);
        return null;
    }
}
