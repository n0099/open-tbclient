package com.airbnb.lottie.model;

import android.content.res.Resources;
import com.airbnb.lottie.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class h extends b<JSONObject> {
    private final com.airbnb.lottie.h mo;
    private final Resources pF;

    public h(Resources resources, com.airbnb.lottie.h hVar) {
        this.pF = resources;
        this.mo = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.airbnb.lottie.e doInBackground(JSONObject... jSONObjectArr) {
        return e.a.a(this.pF, jSONObjectArr[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: j */
    public void onPostExecute(com.airbnb.lottie.e eVar) {
        this.mo.a(eVar);
    }
}
