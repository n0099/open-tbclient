package com.baidu.swan.games.view.recommend.a;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.apps.a;
/* loaded from: classes10.dex */
public class d {
    private float dNg;
    private float dNh;
    private a dNi;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField
    public volatile float top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes10.dex */
    public interface a {
        void vf(String str);
    }

    public d() {
        Resources resources = com.baidu.swan.apps.t.a.asf() != null ? com.baidu.swan.apps.t.a.asf().getResources() : null;
        this.left = b(resources, a.d.swangame_recommend_button_default_left);
        this.top = b(resources, a.d.swangame_recommend_button_default_top);
        this.width = b(resources, a.d.swangame_recommend_button_default_width);
        this.height = b(resources, a.d.swangame_recommend_button_default_height);
        this.dNg = this.width;
        this.dNh = this.height;
    }

    private float b(Resources resources, int i) {
        if (resources == null || i == 0) {
            return 0.0f;
        }
        return com.baidu.swan.games.utils.e.T(resources.getDimension(i));
    }

    public void a(a aVar) {
        this.dNi = aVar;
    }

    public void onFieldChangedCallback(String str) {
        this.width = this.dNg;
        this.height = this.dNh;
        if (this.dNi != null) {
            this.dNi.vf(str);
        }
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
