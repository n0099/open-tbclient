package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes11.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String aBp = "";
    private boolean bDs = false;
    protected Object bDt = null;
    private d bDu = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.bDs && this.bDu != null) {
            this.bDu.onResult(bool.booleanValue(), this.aBp, this.bDt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.bDu = dVar;
    }
}
