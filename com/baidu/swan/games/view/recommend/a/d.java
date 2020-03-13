package com.baidu.swan.games.view.recommend.a;

import android.content.res.Resources;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.swan.apps.a;
/* loaded from: classes11.dex */
public class d {
    private float cua;
    private float cub;
    private a cuc;
    @V8JavascriptField
    public volatile float height;
    @V8JavascriptField
    public volatile float left;
    @V8JavascriptField

    /* renamed from: top  reason: collision with root package name */
    public volatile float f1014top;
    @V8JavascriptField
    public volatile float width;

    /* loaded from: classes11.dex */
    public interface a {
        void nS(String str);
    }

    public d() {
        Resources resources = com.baidu.swan.apps.w.a.TW() != null ? com.baidu.swan.apps.w.a.TW().getResources() : null;
        this.left = b(resources, a.d.swangame_recommend_button_default_left);
        this.f1014top = b(resources, a.d.swangame_recommend_button_default_top);
        this.width = b(resources, a.d.swangame_recommend_button_default_width);
        this.height = b(resources, a.d.swangame_recommend_button_default_height);
        this.cua = this.width;
        this.cub = this.height;
    }

    private float b(Resources resources, int i) {
        if (resources == null || i == 0) {
            return 0.0f;
        }
        return com.baidu.swan.games.utils.d.ab(resources.getDimension(i));
    }

    public void a(a aVar) {
        this.cuc = aVar;
    }

    public void onFieldChangedCallback(String str) {
        this.width = this.cua;
        this.height = this.cub;
        if (this.cuc != null) {
            this.cuc.nS(str);
        }
    }

    public String toString() {
        return "{left=" + this.left + ", top=" + this.f1014top + ", width=" + this.width + ", height=" + this.height + "}";
    }
}
