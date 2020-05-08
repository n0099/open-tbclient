package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.ar.ARType;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.baidu.ar.libloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0082a {
        void a(ARType aRType, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onSuccess();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onReady();
    }

    void a(Context context, b bVar);

    void a(ARType aRType, String str, String str2, InterfaceC0082a interfaceC0082a);

    void a(String str, c cVar);

    void an(String str);

    void release();

    void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin);
}
