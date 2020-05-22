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
/* loaded from: classes11.dex */
public class b extends a {
    private com.baidu.swan.videoplayer.media.a.a dsf;
    private int dsg;

    public b(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
        this.dsg = 0;
        this.dsf = new com.baidu.swan.videoplayer.media.a.a();
        this.dsf.register(this.mContext);
        this.dsf.a(new a.InterfaceC0465a() { // from class: com.baidu.swan.videoplayer.b.a.a.b.1
            @Override // com.baidu.swan.videoplayer.media.a.a.InterfaceC0465a
            public void ay(int i, int i2) {
                b.this.aJE();
            }
        });
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.p.e.b.a
    public int aeD() {
        return this.dsg;
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.p.e.b.a
    public boolean prepareAsync() {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start prepareAsync");
        }
        a(this.mContext, new com.baidu.swan.apps.aq.e.b<Integer>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(Integer num) {
                if (num.intValue() == 2) {
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize deny => onError 0");
                    }
                    if (b.this.cfX != null) {
                        b.this.cfX.onError(0);
                        return;
                    }
                    return;
                }
                if (a.DEBUG) {
                    Log.d("SwanInlineLiveWidget", b.this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " real do prepareAsync");
                }
                b.super.prepareAsync();
            }
        });
        return true;
    }

    private void a(@NonNull Context context, @NonNull final com.baidu.swan.apps.aq.e.b<Integer> bVar) {
        if (DEBUG) {
            Log.d("SwanInlineLiveWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " start authorize");
        }
        e aoG = e.aoG();
        if (aoG == null) {
            if (DEBUG) {
                throw new RuntimeException("inline live authorize: swan app is null");
            }
            bVar.H(0);
        } else if (com.baidu.swan.apps.af.a.a.amj()) {
            this.dsg = 1;
            if (DEBUG) {
                Log.d("SwanInlineLiveWidget", this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize debug: true");
            }
            bVar.H(Integer.valueOf(this.dsg));
        } else {
            aoG.aoR().b(context, "mapp_i_live_player", new com.baidu.swan.apps.aq.e.b<h<b.d>>() { // from class: com.baidu.swan.videoplayer.b.a.a.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(h<b.d> hVar) {
                    boolean b = com.baidu.swan.apps.setting.oauth.c.b(hVar);
                    if (a.DEBUG) {
                        Log.d("SwanInlineLiveWidget", b.this.cjA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + hashCode() + " authorize: " + b);
                    }
                    b.this.dsg = b ? 1 : 2;
                    bVar.H(Integer.valueOf(b.this.dsg));
                }
            });
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a, com.baidu.swan.apps.p.e.b.a
    public void release() {
        super.release();
        if (this.dsf != null) {
            this.dsf.unregister();
            this.dsf = null;
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void aJD() {
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void g(int i, int i2, String str) {
    }
}
