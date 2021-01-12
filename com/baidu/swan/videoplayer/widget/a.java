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
    private String cBM;
    private volatile boolean ceK = false;
    private a.InterfaceC0430a ezx;
    private CyberExtractor ezy;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cBM = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.ezy = new CyberExtractor(true);
        aVar.fE(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String avA() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cBM;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.awy();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0430a interfaceC0430a) {
        this.ezx = interfaceC0430a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void e(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.b(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ceK) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.ezy.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.nP(str)), map);
                    Bundle metaData = a.this.ezy.getMetaData();
                    if (a.this.ezx != null) {
                        a.this.ezx.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.ceK = true;
        if (this.ezy != null) {
            this.ezy.release();
        }
        this.ezy = null;
        if (this.ezx != null) {
            this.ezx.onRelease();
        }
        this.ezx = null;
    }
}
