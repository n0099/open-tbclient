package com.baidu.live.alphavideo;

import android.view.View;
/* loaded from: classes3.dex */
public interface c {

    /* loaded from: classes3.dex */
    public interface a {
        void onEnd();

        void onError(int i, String str);

        void onStart();
    }

    void a(a aVar);

    void ef(String str);

    long getDuration();

    View getView();

    boolean isDestroyed();

    void release();

    void reset();

    void stop();
}
