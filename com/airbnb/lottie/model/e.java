package com.airbnb.lottie.model;

import android.content.res.Resources;
import com.airbnb.lottie.e;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class e extends b<InputStream> {
    private final com.airbnb.lottie.h jQ;
    private final Resources nd;

    public e(Resources resources, com.airbnb.lottie.h hVar) {
        this.nd = resources;
        this.jQ = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.airbnb.lottie.e doInBackground(InputStream... inputStreamArr) {
        return e.a.a(this.nd, inputStreamArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: j */
    public void onPostExecute(com.airbnb.lottie.e eVar) {
        this.jQ.a(eVar);
    }
}
