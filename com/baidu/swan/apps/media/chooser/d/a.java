package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes11.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String bcp = "";
    private boolean cmA = false;
    protected Object cmB = null;
    private d cmC = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.cmA && this.cmC != null) {
            this.cmC.a(bool.booleanValue(), this.bcp, this.cmB);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.cmC = dVar;
    }
}
