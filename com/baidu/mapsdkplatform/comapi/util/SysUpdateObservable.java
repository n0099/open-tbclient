package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SysUpdateObservable f7901a;

    /* renamed from: b  reason: collision with root package name */
    public List<SysUpdateObserver> f7902b;

    public SysUpdateObservable() {
        this.f7902b = null;
        this.f7902b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f7901a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f7901a == null) {
                    f7901a = new SysUpdateObservable();
                }
            }
        }
        return f7901a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f7902b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f7902b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f7902b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f7902b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f7902b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
