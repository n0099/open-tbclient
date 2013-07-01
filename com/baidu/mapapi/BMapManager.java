package com.baidu.mapapi;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
/* loaded from: classes.dex */
public class BMapManager {
    static Context b = null;
    static boolean c = false;

    /* renamed from: a  reason: collision with root package name */
    Mj f501a = null;

    public BMapManager(Context context) {
        b = context;
    }

    private Mj getMj() {
        return this.f501a;
    }

    public void destroy() {
        if (c) {
            stop();
        }
        c = false;
        if (this.f501a != null) {
            if (Mj.f != null) {
                try {
                    Mj.f.close();
                    Mj.f = null;
                } catch (IOException e) {
                    Log.d("baidumap", e.getMessage());
                    Mj.f = null;
                }
            }
            this.f501a.UnInitMapApiEngine();
            this.f501a = null;
        }
    }

    public MKLocationManager getLocationManager() {
        return Mj.b;
    }

    public boolean init(String str, MKGeneralListener mKGeneralListener) {
        if (str == null) {
            return false;
        }
        c = false;
        if (getMj() == null) {
            this.f501a = new Mj(this, b);
            if (!this.f501a.a(str, mKGeneralListener)) {
                this.f501a = null;
                return false;
            }
            if (Mj.b.a(this)) {
                Mj.b.b();
            }
            d.a(b);
            s.a().a(b);
            return true;
        }
        return false;
    }

    public boolean start() {
        if (c) {
            return true;
        }
        if (this.f501a != null && this.f501a.a()) {
            c = true;
            return true;
        }
        return false;
    }

    public boolean stop() {
        if (c) {
            if (this.f501a != null && this.f501a.b()) {
                c = false;
                return true;
            }
            return false;
        }
        return true;
    }
}
