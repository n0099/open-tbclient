package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes10.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String awJ = "";
    private boolean byY = false;
    protected Object byZ = null;
    private d bza = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.byY && this.bza != null) {
            this.bza.onResult(bool.booleanValue(), this.awJ, this.byZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.bza = dVar;
    }
}
