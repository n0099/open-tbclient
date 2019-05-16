package com.baidu.swan.games.view.recommend.a;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.apps.a;
/* loaded from: classes2.dex */
public class d {
    private float blX;
    private float blY;
    private a blZ;
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
        void iE(String str);
    }

    public d() {
        Resources resources = com.baidu.swan.apps.u.a.DB() != null ? com.baidu.swan.apps.u.a.DB().getResources() : null;
        this.left = a(resources, a.d.swangame_recommend_button_default_left);
        this.top = a(resources, a.d.swangame_recommend_button_default_top);
        this.width = a(resources, a.d.swangame_recommend_button_default_width);
        this.height = a(resources, a.d.swangame_recommend_button_default_height);
        this.blX = this.width;
        this.blY = this.height;
    }

    private float a(Resources resources, int i) {
        if (resources == null || i == 0) {
            return 0.0f;
        }
        return com.baidu.swan.games.utils.b.aj(resources.getDimension(i));
    }

    public void a(a aVar) {
        this.blZ = aVar;
    }

    public void onFieldChangedCallback(String str) {
        this.width = this.blX;
        this.height = this.blY;
        if (this.blZ != null) {
            this.blZ.iE(str);
        }
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
