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
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private volatile boolean bBf = false;
    private String bTJ;
    private a.InterfaceC0407a dMM;
    private CyberExtractor dMN;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.bTJ = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.dMN = new CyberExtractor(true);
        aVar.eq(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String anL() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bTJ;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.aoJ();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0407a interfaceC0407a) {
        this.dMM = interfaceC0407a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bBf) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.dMN.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.mT(str)), map);
                    Bundle metaData = a.this.dMN.getMetaData();
                    if (a.this.dMM != null) {
                        a.this.dMM.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bBf = true;
        if (this.dMN != null) {
            this.dMN.release();
        }
        this.dMN = null;
        if (this.dMM != null) {
            this.dMM.onRelease();
        }
        this.dMM = null;
    }
}
