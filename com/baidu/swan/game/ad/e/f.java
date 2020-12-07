package com.baidu.swan.game.ad.e;

import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes14.dex */
public class f {
    private a dUc;
    @V8JavascriptField
    public int height;
    @V8JavascriptField
    public int left;
    @V8JavascriptField
    public int realHeight;
    @V8JavascriptField
    public int realWidth;
    @V8JavascriptField
    public int top;
    @V8JavascriptField
    public int width;

    /* loaded from: classes14.dex */
    public interface a {
        void wo(String str);
    }

    public f(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        a(cVar);
    }

    private void a(@NonNull com.baidu.swan.games.binding.model.c cVar) {
        this.left = cVar.optInt("left", this.left);
        this.top = cVar.optInt(VerticalTranslateLayout.TOP, this.top);
        this.width = cVar.optInt("width", this.width);
        this.height = cVar.optInt("height", this.height);
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("BannerAdStyle", "onFieldChangedCallback fieldName=" + str);
        }
        if (this.dUc != null) {
            this.dUc.wo(str);
        }
    }

    public void a(a aVar) {
        this.dUc = aVar;
    }
}
