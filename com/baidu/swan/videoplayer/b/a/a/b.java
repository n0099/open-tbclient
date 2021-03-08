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
    private com.baidu.swan.videoplayer.media.a.a eCm;
    private int eCn;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eCn = 0;
        this.eCm = new com.baidu.swan.videoplayer.media.a.a();
        this.eCm.register(this.mContext);
        this.eCm.a(new a.InterfaceC0554a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0554a
            public void aD(int i, int i2) {
                b.this.bfZ();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int awK() {
        return this.eCn;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void oA(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void N(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.dfQ != null) {
                        b.this.dfQ.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aIO = e.aIO();
        if (aIO == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.N(0);
        } else if (com.baidu.swan.apps.ad.a.a.aFh()) {
            this.eCn = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.N(Integer.valueOf(this.eCn));
        } else {
            aIO.aIZ().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void N(h<b.d> hVar) {
                    boolean b = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.djT + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b);
                    }
                    b.this.eCn = b ? 1 : 2;
                    bVar.N(Integer.valueOf(b.this.eCn));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eCm != null) {
            this.eCm.unregister();
            this.eCm = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bfY() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
    }
}
