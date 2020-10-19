package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.inlinewidget.b.a;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes12.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private volatile boolean bLh = false;
    private String cib;
    private a.InterfaceC0419a eaU;
    private CyberExtractor eaV;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cib = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.eaV = new CyberExtractor(true);
        aVar.eL(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String arh() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cib;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.asf();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0419a interfaceC0419a) {
        this.eaU = interfaceC0419a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bLh) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.eaV.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.nZ(str)), map);
                    Bundle metaData = a.this.eaV.getMetaData();
                    if (a.this.eaU != null) {
                        a.this.eaU.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bLh = true;
        if (this.eaV != null) {
            this.eaV.release();
        }
        this.eaV = null;
        if (this.eaU != null) {
            this.eaU.onRelease();
        }
        this.eaU = null;
    }
}
