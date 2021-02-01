package com.baidu.swan.videoplayer.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.cyberplayer.sdk.extractor.CyberExtractor;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.inlinewidget.b.a;
import com.baidu.swan.apps.inlinewidget.d;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import java.util.Map;
/* loaded from: classes15.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private String cEi;
    private volatile boolean ciT = false;
    private a.InterfaceC0427a eBE;
    private CyberExtractor eBF;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cEi = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.eBF = new CyberExtractor(true);
        aVar.fG(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avY() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cEi;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.awW();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0427a interfaceC0427a) {
        this.eBE = interfaceC0427a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void d(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.b(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ciT) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.eBF.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.oi(str)), map);
                    Bundle metaData = a.this.eBF.getMetaData();
                    if (a.this.eBE != null) {
                        a.this.eBE.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.ciT = true;
        if (this.eBF != null) {
            this.eBF.release();
        }
        this.eBF = null;
        if (this.eBE != null) {
            this.eBE.onRelease();
        }
        this.eBE = null;
    }
}
