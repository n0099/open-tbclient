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
/* loaded from: classes14.dex */
public class b extends a {
    private com.baidu.swan.videoplayer.media.a.a eyE;
    private int eyF;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eyF = 0;
        this.eyE = new com.baidu.swan.videoplayer.media.a.a();
        this.eyE.register(this.mContext);
        this.eyE.a(new a.InterfaceC0551a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0551a
            public void aG(int i, int i2) {
                b.this.bfK();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int awj() {
        return this.eyF;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void nZ(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.dcb != null) {
                        b.this.dcb.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aIs = e.aIs();
        if (aIs == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.L(0);
        } else if (com.baidu.swan.apps.ad.a.a.aEJ()) {
            this.eyF = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.L(Integer.valueOf(this.eyF));
        } else {
            aIs.aID().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    boolean b2 = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.dge + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b2);
                    }
                    b.this.eyF = b2 ? 1 : 2;
                    bVar.L(Integer.valueOf(b.this.eyF));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eyE != null) {
            this.eyE.unregister();
            this.eyE = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bfJ() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
    }
}
