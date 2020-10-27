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
    private volatile boolean bTD = false;
    private String cqC;
    private a.InterfaceC0433a ejq;
    private CyberExtractor ejr;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cqC = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.ejr = new CyberExtractor(true);
        aVar.eY(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String atc() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cqC;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.aua();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0433a interfaceC0433a) {
        this.ejq = interfaceC0433a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bTD) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.ejr.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.ou(str)), map);
                    Bundle metaData = a.this.ejr.getMetaData();
                    if (a.this.ejq != null) {
                        a.this.ejq.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bTD = true;
        if (this.ejr != null) {
            this.ejr.release();
        }
        this.ejr = null;
        if (this.ejq != null) {
            this.ejq.onRelease();
        }
        this.ejq = null;
    }
}
