package com.baidu.ar.ui;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import com.baidu.ar.ARController;
import com.baidu.ar.component.logo.LogoComponent;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.rotate.Orientation;
import com.baidu.ar.speech.SpeechManager;
import com.baidu.ar.util.UiThreadUtil;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {
    Activity a;
    private LinearLayout b;
    private ARController c;
    private Context d;
    private com.baidu.ar.b e;
    private com.baidu.ar.component.c.a f;
    private com.baidu.ar.component.b.c g;
    private com.baidu.ar.component.a.a h;
    private LogoComponent i;
    private SlidingDrawer.OnDrawerOpenListener j = new SlidingDrawer.OnDrawerOpenListener() { // from class: com.baidu.ar.ui.f.1
        @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
        public void onDrawerOpened() {
            if (f.this.d()) {
                if (f.this.g != null) {
                    f.this.g.c();
                }
                f.this.e.l().a(f.this.k);
            }
        }
    };
    private SlidingDrawer.OnDrawerCloseListener k = new SlidingDrawer.OnDrawerCloseListener() { // from class: com.baidu.ar.ui.f.2
        @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
        public void onDrawerClosed() {
            f.this.e.l().a((SlidingDrawer.OnDrawerCloseListener) null);
            if (f.this.g == null || f.this.g.i()) {
                return;
            }
            f.this.g.a();
        }
    };

    public f(Context context, com.baidu.ar.b bVar, Activity activity) {
        this.d = context;
        this.e = bVar;
        this.a = activity;
        this.c = bVar.i();
        bVar.l().a(this.j);
    }

    private void h() {
        if (this.i != null) {
            this.i.releaseRecg();
            this.i = null;
        }
    }

    private void i() {
        if (this.i != null) {
            this.i.onPause();
        }
    }

    private void j() {
        if (this.g != null) {
            this.g.e();
        }
    }

    private void k() {
        if (this.g != null) {
            this.g.f();
        }
    }

    private void l() {
        if (this.g != null) {
            this.g.g();
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.b();
        }
        if (this.g != null) {
            this.g.b();
        }
        i();
    }

    public void a(LinearLayout linearLayout) {
        this.b = linearLayout;
    }

    public void a(Orientation orientation) {
        switch (orientation) {
            case PORTRAIT:
                j();
                return;
            case LANDSCAPE:
                l();
                return;
            case LANDSCAPE_REVERSE:
                k();
                return;
            default:
                return;
        }
    }

    public void a(final HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            switch (MsgParamsUtil.obj2Int(hashMap.get("id"), -1)) {
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                    if (this.g == null) {
                        this.g = new com.baidu.ar.component.b.c(this.d, this.c, this.e);
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.ui.f.3
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.g.a(f.this.b);
                                f.this.g.a(hashMap);
                            }
                        });
                    }
                    this.g.a(hashMap);
                    return;
                case 2005:
                case 2006:
                case 2007:
                case 2008:
                    if (this.f == null) {
                        this.f = com.baidu.ar.component.c.a.a(this.d, this.c);
                    }
                    this.f.a(hashMap);
                    return;
                case ComponentMessageType.MSG_TYPE_LOGO_START /* 3005 */:
                case ComponentMessageType.MSG_TYPE_LOGO_STOP /* 3006 */:
                    if (this.i == null) {
                        this.i = LogoComponent.getInstance(this.a, this.c, this.e.c(), this.e);
                    }
                    this.i.onLuaMessage(hashMap);
                    return;
                case 10301:
                case 10401:
                    if (this.h == null) {
                        this.h = new com.baidu.ar.component.a.a(this.d, this.e);
                    }
                    this.h.a(hashMap);
                    return;
                default:
                    return;
            }
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.c();
        }
        if (this.i != null) {
            this.i.onResume();
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.d();
        }
        if (this.g != null) {
            this.g.b();
            this.g.d();
        }
        if (this.h != null) {
            this.h.a();
        }
        h();
    }

    public boolean d() {
        return (this.g == null || this.g.h() == SpeechManager.SpeechStatus.SPEECH_IDLE) ? false : true;
    }

    public void e() {
        if (this.g == null || !d()) {
            return;
        }
        this.g.b();
    }

    public void f() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public void g() {
        if (this.f != null) {
            this.f.c();
        }
    }
}
