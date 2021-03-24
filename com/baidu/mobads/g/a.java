package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static IXAdContainerFactory f8248e;

    /* renamed from: b  reason: collision with root package name */
    public Context f8250b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f8251c;

    /* renamed from: d  reason: collision with root package name */
    public double f8252d;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f8253f;

    /* renamed from: a  reason: collision with root package name */
    public double f8249a = 0.1d;

    /* renamed from: g  reason: collision with root package name */
    public IXAdLogger f8254g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d2, Boolean bool) {
        this.f8251c = null;
        this.f8251c = cls;
        this.f8250b = context;
        this.f8252d = d2;
        this.f8253f = bool;
    }

    public IXAdContainerFactory a() {
        if (f8248e == null) {
            try {
                IXAdContainerFactory iXAdContainerFactory = (IXAdContainerFactory) this.f8251c.getDeclaredConstructor(Context.class).newInstance(this.f8250b);
                f8248e = iXAdContainerFactory;
                this.f8249a = iXAdContainerFactory.getRemoteVersion();
                f8248e.setDebugMode(this.f8253f);
                f8248e.handleShakeVersion(this.f8252d, XAdSDKProxyVersion.RELEASE_TAG);
            } catch (Throwable th) {
                this.f8254g.w("XAdContainerFactoryBuilder", th.getMessage());
                throw new g.a("newXAdContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f8248e;
    }

    public void b() {
        f8248e = null;
    }
}
