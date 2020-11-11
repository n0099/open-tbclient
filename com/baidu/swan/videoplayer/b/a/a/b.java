package com.baidu.swan.videoplayer.b.a.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.videoplayer.media.a.a;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes12.dex */
public class b extends a {
    private com.baidu.swan.videoplayer.media.a.a eor;
    private int eos;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eos = 0;
        this.eor = new com.baidu.swan.videoplayer.media.a.a();
        this.eor.register(this.mContext);
        this.eor.a(new a.InterfaceC0567a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0567a
            public void aH(int i, int i2) {
                b.this.beJ();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int awl() {
        return this.eos;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void oS(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.cWJ != null) {
                        b.this.cWJ.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aHv = e.aHv();
        if (aHv == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.M(0);
        } else if (com.baidu.swan.apps.ad.a.a.aEJ()) {
            this.eos = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.M(Integer.valueOf(this.eos));
        } else {
            aHv.aHG().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    boolean b = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.daK + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b);
                    }
                    b.this.eos = b ? 1 : 2;
                    bVar.M(Integer.valueOf(b.this.eos));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eor != null) {
            this.eor.unregister();
            this.eor = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void beI() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
    }
}
