package com.baidu.swan.games.view.recommend.a;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public class d {
    private float ctY;
    private float ctZ;
    private a cua;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField

    /* renamed from: top  reason: collision with root package name */
    public volatile float f1015top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes11.dex */
    public interface a {
        void nS(String str);
    }

    public d() {
        Resources resources = com.baidu.swan.apps.w.a.TU() != null ? com.baidu.swan.apps.w.a.TU().getResources() : null;
        this.left = b(resources, a.d.swangame_recommend_button_default_left);
        this.f1015top = b(resources, a.d.swangame_recommend_button_default_top);
        this.width = b(resources, a.d.swangame_recommend_button_default_width);
        this.height = b(resources, a.d.swangame_recommend_button_default_height);
        this.ctY = this.width;
        this.ctZ = this.height;
    }

    private float b(Resources resources, int i) {
        if (resources == null || i == 0) {
            return 0.0f;
        }
        return com.baidu.swan.games.utils.d.ab(resources.getDimension(i));
    }

    public void a(a aVar) {
        this.cua = aVar;
    }

    public void onFieldChangedCallback(String str) {
        this.width = this.ctY;
        this.height = this.ctZ;
        if (this.cua != null) {
            this.cua.nS(str);
        }
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.f1015top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
