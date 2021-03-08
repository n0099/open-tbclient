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
/* loaded from: classes14.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private String cFI;
    private volatile boolean ckt = false;
    private a.InterfaceC0433a eDf;
    private CyberExtractor eDg;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cFI = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.eDg = new CyberExtractor(true);
        aVar.fG(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String awb() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cFI;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.awZ();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0433a interfaceC0433a) {
        this.eDf = interfaceC0433a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void d(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.b(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ckt) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.eDg.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.oq(str)), map);
                    Bundle metaData = a.this.eDg.getMetaData();
                    if (a.this.eDf != null) {
                        a.this.eDf.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.ckt = true;
        if (this.eDg != null) {
            this.eDg.release();
        }
        this.eDg = null;
        if (this.eDf != null) {
            this.eDf.onRelease();
        }
        this.eDf = null;
    }
}
