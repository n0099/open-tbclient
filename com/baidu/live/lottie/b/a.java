package com.baidu.live.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.baidu.live.lottie.b buM;
    private final h<String> buL = new h<>();
    private final Map<h<String>, Typeface> Gk = new HashMap();
    private final Map<String, Typeface> Gl = new HashMap();
    private String Gn = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.baidu.live.lottie.b bVar) {
        this.buM = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.baidu.live.lottie.b bVar) {
        this.buM = bVar;
    }

    public Typeface n(String str, String str2) {
        this.buL.set(str, str2);
        Typeface typeface = this.Gk.get(this.buL);
        if (typeface == null) {
            Typeface b = b(bm(str), str2);
            this.Gk.put(this.buL, b);
            return b;
        }
        return typeface;
    }

    private Typeface bm(String str) {
        String be;
        Typeface typeface = this.Gl.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.buM != null) {
                typeface = this.buM.bd(str);
            }
            if (this.buM != null && typeface == null && (be = this.buM.be(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, be);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Gn);
            }
            this.Gl.put(str, typeface);
        }
        return typeface;
    }

    private Typeface b(Typeface typeface, String str) {
        int i = 0;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i = 3;
        } else if (contains) {
            i = 2;
        } else if (contains2) {
            i = 1;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
