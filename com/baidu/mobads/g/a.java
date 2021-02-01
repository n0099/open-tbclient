package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes5.dex */
public class a {
    private static IXAdContainerFactory e;

    /* renamed from: b  reason: collision with root package name */
    private Context f3337b;
    private Class<?> c;
    private double d;
    private Boolean f;

    /* renamed from: a  reason: collision with root package name */
    public double f3336a = 0.1d;
    private IXAdLogger g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d, Boolean bool) {
        this.c = null;
        this.c = cls;
        this.f3337b = context;
        this.d = d;
        this.f = bool;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.c.getDeclaredConstructor(Context.class).newInstance(this.f3337b);
                this.f3336a = e.getRemoteVersion();
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
