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
    private com.airbnb.lottie.b DY;
    private final AssetManager assetManager;
    private final h<String> DV = new h<>();
    private final Map<h<String>, Typeface> DW = new HashMap();
    private final Map<String, Typeface> DX = new HashMap();
    private String DZ = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.DY = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.DY = bVar;
    }

    public Typeface q(String str, String str2) {
        this.DV.set(str, str2);
        Typeface typeface = this.DW.get(this.DV);
        if (typeface == null) {
            Typeface a = a(bi(str), str2);
            this.DW.put(this.DV, a);
            return a;
        }
        return typeface;
    }

    private Typeface bi(String str) {
        String ba;
        Typeface typeface = this.DX.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.DY != null) {
                typeface = this.DY.aZ(str);
            }
            if (this.DY != null && typeface == null && (ba = this.DY.ba(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, ba);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.DZ);
            }
            this.DX.put(str, typeface);
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
