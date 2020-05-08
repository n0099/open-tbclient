package com.baidu.swan.apps.media.chooser.d;

import android.os.AsyncTask;
import com.baidu.swan.apps.media.chooser.c.d;
/* loaded from: classes11.dex */
public abstract class a extends AsyncTask<Void, Void, Boolean> {
    private String aVb = "";
    private boolean cbW = false;
    protected Object cbX = null;
    private d cbY = null;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        if (!this.cbW && this.cbY != null) {
            this.cbY.a(bool.booleanValue(), this.aVb, this.cbX);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d dVar) {
        this.cbY = dVar;
    }
}
