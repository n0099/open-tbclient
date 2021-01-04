package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SysUpdateObservable f3210a;

    /* renamed from: b  reason: collision with root package name */
    private List<SysUpdateObserver> f3211b;

    private SysUpdateObservable() {
        this.f3211b = null;
        this.f3211b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f3210a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f3210a == null) {
                    f3210a = new SysUpdateObservable();
                }
            }
        }
        return f3210a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f3211b.add(sysUpdateObserver);
    }

    public void init(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f3211b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init(str);
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3211b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3211b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.f3211b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo(str);
            }
        }
    }
}
