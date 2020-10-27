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
    private com.baidu.swan.videoplayer.media.a.a eix;
    private int eiy;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eiy = 0;
        this.eix = new com.baidu.swan.videoplayer.media.a.a();
        this.eix.register(this.mContext);
        this.eix.a(new a.InterfaceC0555a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0555a
            public void aH(int i, int i2) {
                b.this.bcj();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int atL() {
        return this.eiy;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void oE(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.cQQ != null) {
                        b.this.cQQ.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ap.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aEV = e.aEV();
        if (aEV == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.M(0);
        } else if (com.baidu.swan.apps.ad.a.a.aCj()) {
            this.eiy = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.M(Integer.valueOf(this.eiy));
        } else {
            aEV.aFg().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ap.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(h<b.d> hVar) {
                    boolean b = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cUQ + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b);
                    }
                    b.this.eiy = b ? 1 : 2;
                    bVar.M(Integer.valueOf(b.this.eiy));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eix != null) {
            this.eix.unregister();
            this.eix = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bci() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
    }
}
