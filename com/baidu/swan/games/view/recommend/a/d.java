package com.baidu.swan.games.view.recommend.a;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public class d {
    private float bFe;
    private float bFf;
    private a bFg;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField
    public volatile float top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes2.dex */
    public interface a {
        void jp(String str);
    }

    public d() {
        Resources resources = com.baidu.swan.apps.u.a.Jj() != null ? com.baidu.swan.apps.u.a.Jj().getResources() : null;
        this.left = a(resources, a.d.swangame_recommend_button_default_left);
        this.top = a(resources, a.d.swangame_recommend_button_default_top);
        this.width = a(resources, a.d.swangame_recommend_button_default_width);
        this.height = a(resources, a.d.swangame_recommend_button_default_height);
        this.bFe = this.width;
        this.bFf = this.height;
    }

    private float a(Resources resources, int i) {
        if (resources == null || i == 0) {
            return 0.0f;
        }
        return com.baidu.swan.games.utils.b.Y(resources.getDimension(i));
    }

    public void a(a aVar) {
        this.bFg = aVar;
    }

    public void onFieldChangedCallback(String str) {
        this.width = this.bFe;
        this.height = this.bFf;
        if (this.bFg != null) {
            this.bFg.jp(str);
        }
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
