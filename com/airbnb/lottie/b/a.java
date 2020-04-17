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
/* loaded from: classes6.dex */
public class a {
    @Nullable
    private com.airbnb.lottie.b CJ;
    private final AssetManager assetManager;
    private final h<String> CG = new h<>();
    private final Map<h<String>, Typeface> CH = new HashMap();
    private final Map<String, Typeface> CI = new HashMap();
    private String CK = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.CJ = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.CJ = bVar;
    }

    public Typeface n(String str, String str2) {
        this.CG.set(str, str2);
        Typeface typeface = this.CH.get(this.CG);
        if (typeface == null) {
            Typeface a = a(bc(str), str2);
            this.CH.put(this.CG, a);
            return a;
        }
        return typeface;
    }

    private Typeface bc(String str) {
        String aU;
        Typeface typeface = this.CI.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.CJ != null) {
                typeface = this.CJ.aT(str);
            }
            if (this.CJ != null && typeface == null && (aU = this.CJ.aU(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, aU);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.CK);
            }
            this.CI.put(str, typeface);
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
