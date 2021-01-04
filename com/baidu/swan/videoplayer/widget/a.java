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
/* loaded from: classes3.dex */
public class a implements com.baidu.swan.apps.inlinewidget.b.a {
    private static final boolean DEBUG = b.DEBUG;
    private String cGy;
    private volatile boolean cjx = false;
    private a.InterfaceC0447a eEj;
    private CyberExtractor eEk;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cGy = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.eEk = new CyberExtractor(true);
        aVar.fI(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String azt() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cGy;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.aAr();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0447a interfaceC0447a) {
        this.eEj = interfaceC0447a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void e(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.b(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cjx) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.eEk.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.pc(str)), map);
                    Bundle metaData = a.this.eEk.getMetaData();
                    if (a.this.eEj != null) {
                        a.this.eEj.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.cjx = true;
        if (this.eEk != null) {
            this.eEk.release();
        }
        this.eEk = null;
        if (this.eEj != null) {
            this.eEj.onRelease();
        }
        this.eEj = null;
    }
}
