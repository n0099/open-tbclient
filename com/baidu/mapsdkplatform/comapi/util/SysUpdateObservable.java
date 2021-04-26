package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SysUpdateObservable f8187a;

    /* renamed from: b  reason: collision with root package name */
    public List<SysUpdateObserver> f8188b;

    public SysUpdateObservable() {
        this.f8188b = null;
        this.f8188b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f8187a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f8187a == null) {
                    f8187a = new SysUpdateObservable();
                }
            }
        }
        return f8187a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.f8188b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.f8188b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f8188b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.f8188b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.f8188b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
