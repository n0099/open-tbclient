package com.airbnb.lottie.model;

import android.os.AsyncTask;
/* loaded from: classes2.dex */
public abstract class b<Params> extends AsyncTask<Params, Void, com.airbnb.lottie.e> implements com.airbnb.lottie.a {
    @Override // com.airbnb.lottie.a
    public void cancel() {
        cancel(true);
    }
}
