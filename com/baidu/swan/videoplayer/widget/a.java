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
/* loaded from: classes25.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private volatile boolean bEF = false;
    private String bVN;
    private a.InterfaceC0402a dOT;
    private CyberExtractor dOU;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.bVN = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.dOU = new CyberExtractor(true);
        aVar.ep(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String aov() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.bVN;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.apu();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0402a interfaceC0402a) {
        this.dOT = interfaceC0402a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void f(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bEF) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.dOU.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.nn(str)), map);
                    Bundle metaData = a.this.dOU.getMetaData();
                    if (a.this.dOT != null) {
                        a.this.dOT.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bEF = true;
        if (this.dOU != null) {
            this.dOU.release();
        }
        this.dOU = null;
        if (this.dOT != null) {
            this.dOT.onRelease();
        }
        this.dOT = null;
    }
}
