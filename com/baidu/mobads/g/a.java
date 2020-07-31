package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
/* loaded from: classes20.dex */
public class a {
    private static IXAdContainerFactory e;
    private Context b;
    private Class<?> c;
    private double d;
    private Boolean f;
    public double a = 0.1d;
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
                this.a = e.getRemoteVersion();
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
