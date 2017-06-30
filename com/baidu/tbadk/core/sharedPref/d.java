package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ b adp;
    private final /* synthetic */ Uri val$uri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.adp = bVar;
        this.val$uri = uri;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        this.adp.deleteValueInner(this.val$uri);
        return null;
    }
}
