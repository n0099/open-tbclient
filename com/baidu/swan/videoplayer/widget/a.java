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
    private volatile boolean bXC = false;
    private String cuQ;
    private a.InterfaceC0443a enC;
    private CyberExtractor enD;

    public a(ZeusPluginFactory.Invoker invoker, String str) {
        this.cuQ = str;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    public void a(@NonNull d.a aVar) {
        this.enD = new CyberExtractor(true);
        aVar.fk(true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String auU() {
        return null;
    }

    @Override // com.baidu.swan.apps.inlinewidget.d
    @Nullable
    public String getSlaveId() {
        return this.cuQ;
    }

    public Context getContext() {
        return com.baidu.swan.apps.t.a.avS();
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void a(a.InterfaceC0443a interfaceC0443a) {
        this.enC = interfaceC0443a;
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void e(final String str, final Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.videoplayer.widget.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.bXC) {
                        if (a.DEBUG) {
                            Log.d("MediaExtractorWidget", "media extractor already released");
                            return;
                        }
                        return;
                    }
                    a.this.enD.setDataSource(a.this.getContext(), Uri.parse(com.baidu.swan.apps.inlinewidget.e.a.oC(str)), map);
                    Bundle metaData = a.this.enD.getMetaData();
                    if (a.this.enC != null) {
                        a.this.enC.z(metaData);
                    }
                }
            }, "loadMetadata");
        }
    }

    @Override // com.baidu.swan.apps.inlinewidget.b.a
    public void release() {
        this.bXC = true;
        if (this.enD != null) {
            this.enD.release();
        }
        this.enD = null;
        if (this.enC != null) {
            this.enC.onRelease();
        }
        this.enC = null;
    }
}
