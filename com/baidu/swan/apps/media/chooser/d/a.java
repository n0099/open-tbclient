package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes11.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String aAZ = "";
    private boolean bDf = false;
    protected Object bDg = null;
    private d bDh = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.bDf && this.bDh != null) {
            this.bDh.onResult(bool.booleanValue(), this.aAZ, this.bDg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.bDh = dVar;
    }
}
