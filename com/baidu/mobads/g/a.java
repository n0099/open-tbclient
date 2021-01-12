package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes14.dex */
public class a {
    private static IXAdContainerFactory e;

    /* renamed from: b  reason: collision with root package name */
    private Context f3325b;
    private Class<?> c;
    private double d;
    private Boolean f;

    /* renamed from: a  reason: collision with root package name */
    public double f3324a = 0.1d;
    private IXAdLogger g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d, Boolean bool) {
        this.c = null;
        this.c = cls;
        this.f3325b = context;
        this.d = d;
        this.f = bool;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.c.getDeclaredConstructor(Context.class).newInstance(this.f3325b);
                this.f3324a = e.getRemoteVersion();
                e.setDebugMode(this.f);
                e.handleShakeVersion(this.d, "8.8146");
            } catch (Throwable th) {
                this.g.w("XAdContainerFactoryBuilder", th.getMessage());
                throw new g.a("newXAdContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}
