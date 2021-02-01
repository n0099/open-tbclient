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
/* loaded from: classes15.dex */
public class b extends a {
    private com.baidu.swan.videoplayer.media.a.a eAL;
    private int eAM;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.eAM = 0;
        this.eAL = new com.baidu.swan.videoplayer.media.a.a();
        this.eAL.register(this.mContext);
        this.eAL.a(new a.InterfaceC0548a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0548a
            public void aD(int i, int i2) {
                b.this.bfX();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public int awH() {
        return this.eAM;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void ot(String str) {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        c(this.mContext, new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.deo != null) {
                        b.this.deo.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void c(@NonNull Context context, @NonNull final com.baidu.swan.apps.ao.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aIL = e.aIL();
        if (aIL == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.L(0);
        } else if (com.baidu.swan.apps.ad.a.a.aFe()) {
            this.eAM = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.L(Integer.valueOf(this.eAM));
        } else {
            aIL.aIW().b(context, "mapp_i_live_player", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(h<b.d> hVar) {
                    boolean b2 = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.diq + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b2);
                    }
                    b.this.eAM = b2 ? 1 : 2;
                    bVar.L(Integer.valueOf(b.this.eAM));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.inlinewidget.f.c.a
    public void release() {
        super.release();
        if (this.eAL != null) {
            this.eAL.unregister();
            this.eAL = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bfW() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
    }
}
