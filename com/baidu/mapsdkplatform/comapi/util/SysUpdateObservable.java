package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SysUpdateObservable f3156a;

    /* renamed from: b  reason: collision with root package name */
    private List<SysUpdateObserver> f3157b;

    private SysUpdateObservable() {
        this.f3157b = null;
        this.f3157b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f3156a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f3156a == null) {
                    f3156a = new SysUpdateObservable();
                }
            }
        }
        return f3156a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f3157b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f3157b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3157b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3157b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f3157b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
