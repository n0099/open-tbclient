package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes16.dex */
public class a {
    @Nullable
    private com.airbnb.lottie.b Ep;
    private final AssetManager assetManager;
    private final h<String> Em = new h<>();
    private final Map<h<String>, Typeface> En = new HashMap();
    private final Map<String, Typeface> Eo = new HashMap();
    private String Eq = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.Ep = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.Ep = bVar;
    }

    public Typeface q(String str, String str2) {
        this.Em.set(str, str2);
        Typeface typeface = this.En.get(this.Em);
        if (typeface == null) {
            Typeface a2 = a(bi(str), str2);
            this.En.put(this.Em, a2);
            return a2;
        }
        return typeface;
    }

    private Typeface bi(String str) {
        String ba;
        Typeface typeface = this.Eo.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.Ep != null) {
                typeface = this.Ep.aZ(str);
            }
            if (this.Ep != null && typeface == null && (ba = this.Ep.ba(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, ba);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Eq);
            }
            this.Eo.put(str, typeface);
        }
        return typeface;
    }

    private Typeface a(Typeface typeface, String str) {
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
