package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SysUpdateObservable {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SysUpdateObservable f2246a;
    private List<SysUpdateObserver> b;

    private SysUpdateObservable() {
        this.b = null;
        this.b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (f2246a == null) {
            synchronized (SysUpdateObservable.class) {
                if (f2246a == null) {
                    f2246a = new SysUpdateObservable();
                }
            }
        }
        return f2246a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.b.add(sysUpdateObserver);
    }

    public void init(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init(str);
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo(String str) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo(str);
            }
        }
    }
}
