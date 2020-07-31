package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.p.b.a;
import com.baidu.swan.apps.p.d;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes3.dex */
public class a implements com.baidu.swan.apps.p.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private String bOl;
    private volatile boolean bvu = false;
    private a.InterfaceC0371a dDD;
    private CyberExtractor dDE;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.bOl = str;
    }

    @Override // com.baidu.swan.apps.p.d
    public void a(@NonNull d.a aVar) {
        this.dDE = new CyberExtractor(true);
        aVar.ed(true);
    }

    @Override // com.baidu.swan.apps.p.d
    @Nullable
    public String agD() {
        return null;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.ahj();
    }

    @Override // com.baidu.swan.apps.p.b.a
    public void a(a.InterfaceC0371a interfaceC0371a) {
        this.dDD = interfaceC0371a;
    }

    @Override // com.baidu.swan.apps.p.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bvu) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.dDE.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.p.e.a.lb(str)), map);
                    Bundle metaData = a.this.dDE.getMetaData();
                    if (a.this.dDD != null) {
                        a.this.dDD.B(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.p.b.a
    public void release() {
        this.bvu = true;
        if (this.dDE != null) {
            this.dDE.release();
        }
        this.dDE = null;
        if (this.dDD != null) {
            this.dDD.onRelease();
        }
        this.dDD = null;
    }
}
