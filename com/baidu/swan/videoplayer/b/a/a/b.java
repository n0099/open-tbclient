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
    private com.baidu.swan.videoplayer.media.a.a eaa;
    private int eab;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eab = 0;
        this.eaa = new com.baidu.swan.videoplayer.media.a.a();
        this.eaa.register(this.mContext);
        this.eaa.a(new a.InterfaceC0541a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0541a
            public void aG(int i, int i2) {
                b.this.baq();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int arQ() {
        return this.eab;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ok(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.cIu != null) {
                        b.this.cIu.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aDb = e.aDb();
        if (aDb == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.M(0);
        } else if (com.baidu.swan.apps.ad.a.a.aAp()) {
            this.eab = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.M(Integer.valueOf(this.eab));
        } else {
            aDb.aDm().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    boolean b = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cMu + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b);
                    }
                    b.this.eab = b ? 1 : 2;
                    bVar.M(Integer.valueOf(b.this.eab));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eaa != null) {
            this.eaa.unregister();
            this.eaa = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bap() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
    }
}
