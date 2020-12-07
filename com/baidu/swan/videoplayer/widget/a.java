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
/* loaded from: classes6.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private String cBI;
    private volatile boolean ccT = false;
    private a.InterfaceC0455a euC;
    private CyberExtractor euD;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cBI = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.euD = new CyberExtractor(true);
        aVar.fz(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String ayc() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBI;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.aza();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0455a interfaceC0455a) {
        this.euC = interfaceC0455a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void e(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ccT) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.euD.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.pj(str)), map);
                    Bundle metaData = a.this.euD.getMetaData();
                    if (a.this.euC != null) {
                        a.this.euC.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.ccT = true;
        if (this.euD != null) {
            this.euD.release();
        }
        this.euD = null;
        if (this.euC != null) {
            this.euC.onRelease();
        }
        this.euC = null;
    }
}
