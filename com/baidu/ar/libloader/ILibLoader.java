package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
/* loaded from: classes6.dex */
public interface ILibLoader {

    /* loaded from: classes6.dex */
    public interface a {
        void a(ARType aRType, String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onReady();
    }

    void load(Context context, b bVar);

    void prepareCaseRes(ARType aRType, String str, String str2, a aVar);

    void release();

    void require(String str);

    void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin);

    void setLibReadyListener(String str, c cVar);
}
