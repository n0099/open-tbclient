package com.baidu.swan.game.ad.f;

import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class f {
    private a ciL;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int realHeight;
    @V8JavascriptField
    public int realWidth;
    @V8JavascriptField

    /* renamed from: top  reason: collision with root package name */
    public int f1011top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes11.dex */
    public interface a {
        void nS(String str);
    }

    public f(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        a(cVar);
    }

    private void a(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        this.left = cVar.optInt("left", this.left);
        this.f1011top = cVar.optInt(VerticalTranslateLayout.TOP, this.f1011top);
        this.width = cVar.optInt("width", this.width);
        this.height = cVar.optInt("height", this.height);
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BannerAdStyle", "onFieldChangedCallback fieldName=" + str);
        }
        if (this.ciL != null) {
            this.ciL.nS(str);
        }
    }

    public void a(a aVar) {
        this.ciL = aVar;
    }
}
