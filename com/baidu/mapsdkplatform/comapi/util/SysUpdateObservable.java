package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SysUpdateObservable f3154a;

    /* renamed from: b  reason: collision with root package name */
    private List<SysUpdateObserver> f3155b;

    private SysUpdateObservable() {
        this.f3155b = null;
        this.f3155b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f3154a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f3154a == null) {
                    f3154a = new SysUpdateObservable();
                }
            }
        }
        return f3154a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f3155b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f3155b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3155b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f3155b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f3155b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
