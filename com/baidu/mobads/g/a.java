package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes4.dex */
public class a {
    private static IXAdContainerFactory e;
    private Context b;
    private Class<?> c;
    private double d;
    private Boolean f;

    /* renamed from: a  reason: collision with root package name */
    public double f2385a = 0.1d;
    private IXAdLogger g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d, Boolean bool) {
        this.c = null;
        this.c = cls;
        this.b = context;
        this.d = d;
        this.f = bool;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.c.getDeclaredConstructor(Context.class).newInstance(this.b);
                this.f2385a = e.getRemoteVersion();
                e.setDebugMode(this.f);
                e.handleShakeVersion(this.d, XAdSDKProxyVersion.RELEASE_TAG);
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
