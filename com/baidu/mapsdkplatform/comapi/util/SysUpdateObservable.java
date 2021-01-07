package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SysUpdateObservable f3211a;

    /* renamed from: b  reason: collision with root package name */
    private List<SysUpdateObserver> f3212b;

    private SysUpdateObservable() {
        this.f3212b = null;
        this.f3212b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f3211a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f3211a == null) {
                    f3211a = new SysUpdateObservable();
                }
            }
        }
        return f3211a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f3212b.add(sysUpdateObserver);
    }

    public void init(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f3212b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init(str);
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3212b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3212b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f3212b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo(str);
            }
        }
    }
}
