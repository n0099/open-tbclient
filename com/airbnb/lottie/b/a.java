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
    private com.airbnb.lottie.b Do;
    private final AssetManager assetManager;
    private final h<String> Dl = new h<>();
    private final Map<h<String>, Typeface> Dm = new HashMap();
    private final Map<String, Typeface> Dn = new HashMap();
    private String Dp = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.Do = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.Do = bVar;
    }

    public Typeface n(String str, String str2) {
        this.Dl.set(str, str2);
        Typeface typeface = this.Dm.get(this.Dl);
        if (typeface == null) {
            Typeface a = a(bd(str), str2);
            this.Dm.put(this.Dl, a);
            return a;
        }
        return typeface;
    }

    private Typeface bd(String str) {
        String aV;
        Typeface typeface = this.Dn.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.Do != null) {
                typeface = this.Do.aU(str);
            }
            if (this.Do != null && typeface == null && (aV = this.Do.aV(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, aV);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Dp);
            }
            this.Dn.put(str, typeface);
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
