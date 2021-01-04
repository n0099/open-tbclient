package com.baidu.swan.videoplayer.b.a.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.videoplayer.media.a.a;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class b extends a {
    private com.baidu.swan.videoplayer.media.a.a eDq;
    private int eDr;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eDr = 0;
        this.eDq = new com.baidu.swan.videoplayer.media.a.a();
        this.eDq.register(this.mContext);
        this.eDq.a(new a.InterfaceC0568a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0568a
            public void aG(int i, int i2) {
                b.this.bjD();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int aAc() {
        return this.eDr;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void pm(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.dgQ != null) {
                        b.this.dgQ.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aMl = e.aMl();
        if (aMl == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.L(0);
        } else if (com.baidu.swan.apps.ad.a.a.aIC()) {
            this.eDr = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.L(Integer.valueOf(this.eDr));
        } else {
            aMl.aMw().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    boolean b2 = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.dkT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b2);
                    }
                    b.this.eDr = b2 ? 1 : 2;
                    bVar.L(Integer.valueOf(b.this.eDr));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eDq != null) {
            this.eDq.unregister();
            this.eDq = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bjC() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
    }
}
