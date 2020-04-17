package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes11.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String aUW = "";
    private boolean cbQ = false;
    protected Object cbR = null;
    private d cbS = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.cbQ && this.cbS != null) {
            this.cbS.a(bool.booleanValue(), this.aUW, this.cbR);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.cbS = dVar;
    }
}
