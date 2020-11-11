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
    private volatile boolean bZn = false;
    private String cwA;
    private a.InterfaceC0445a epk;
    private CyberExtractor epl;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cwA = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.epl = new CyberExtractor(true);
        aVar.fh(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avC() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cwA;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.awA();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0445a interfaceC0445a) {
        this.epk = interfaceC0445a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bZn) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.epl.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.oI(str)), map);
                    Bundle metaData = a.this.epl.getMetaData();
                    if (a.this.epk != null) {
                        a.this.epk.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bZn = true;
        if (this.epl != null) {
            this.epl.release();
        }
        this.epl = null;
        if (this.epk != null) {
            this.epk.onRelease();
        }
        this.epk = null;
    }
}
