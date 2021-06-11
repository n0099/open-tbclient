package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SysUpdateObservable f7938a;

    /* renamed from: b  reason: collision with root package name */
    public List<SysUpdateObserver> f7939b;

    public SysUpdateObservable() {
        this.f7939b = null;
        this.f7939b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f7938a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f7938a == null) {
                    f7938a = new SysUpdateObservable();
                }
            }
        }
        return f7938a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f7939b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f7939b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f7939b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f7939b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f7939b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
