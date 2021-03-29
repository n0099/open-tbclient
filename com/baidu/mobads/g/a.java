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
    public static IXAdContainerFactory f8249e;

    /* renamed from: b  reason: collision with root package name */
    public Context f8251b;

    /* renamed from: c  reason: collision with root package name */
    public Class<?> f8252c;

    /* renamed from: d  reason: collision with root package name */
    public double f8253d;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f8254f;

    /* renamed from: a  reason: collision with root package name */
    public double f8250a = 0.1d;

    /* renamed from: g  reason: collision with root package name */
    public IXAdLogger f8255g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d2, Boolean bool) {
        this.f8252c = null;
        this.f8252c = cls;
        this.f8251b = context;
        this.f8253d = d2;
        this.f8254f = bool;
    }

    public IXAdContainerFactory a() {
        if (f8249e == null) {
            try {
                IXAdContainerFactory iXAdContainerFactory = (IXAdContainerFactory) this.f8252c.getDeclaredConstructor(Context.class).newInstance(this.f8251b);
                f8249e = iXAdContainerFactory;
                this.f8250a = iXAdContainerFactory.getRemoteVersion();
                f8249e.setDebugMode(this.f8254f);
                f8249e.handleShakeVersion(this.f8253d, XAdSDKProxyVersion.RELEASE_TAG);
            } catch (Throwable th) {
                this.f8255g.w("XAdContainerFactoryBuilder", th.getMessage());
                throw new g.a("newXAdContainerFactory() failed, possibly API incompatible: " + th.getMessage());
            }
        }
        return f8249e;
    }

    public void b() {
        f8249e = null;
    }
}
