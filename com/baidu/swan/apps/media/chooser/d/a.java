package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes9.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String avX = "";
    private boolean byl = false;
    protected Object bym = null;
    private d byn = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.byl && this.byn != null) {
            this.byn.onResult(bool.booleanValue(), this.avX, this.bym);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.byn = dVar;
    }
}
