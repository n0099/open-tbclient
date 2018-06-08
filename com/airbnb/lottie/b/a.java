package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.model.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private final AssetManager mW;
    @Nullable
    private com.airbnb.lottie.b mZ;
    private final i<String> mT = new i<>();
    private final Map<i<String>, Typeface> mU = new HashMap();
    private final Map<String, Typeface> mV = new HashMap();
    private String na = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.mZ = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mW = null;
            return;
        }
        this.mW = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.mZ = bVar;
    }

    public Typeface g(String str, String str2) {
        this.mT.set(str, str2);
        Typeface typeface = this.mU.get(this.mT);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.mU.put(this.mT, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.mV.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mZ != null) {
                typeface = this.mZ.B(str);
            }
            if (this.mZ != null && typeface == null && (C = this.mZ.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.mW, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.mW, "fonts/" + str + this.na);
            }
            this.mV.put(str, typeface);
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
