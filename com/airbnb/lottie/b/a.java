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
    private final AssetManager mV;
    @Nullable
    private com.airbnb.lottie.b mW;
    private final i<String> mS = new i<>();
    private final Map<i<String>, Typeface> mT = new HashMap();
    private final Map<String, Typeface> mU = new HashMap();
    private String mZ = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.mW = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mV = null;
            return;
        }
        this.mV = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.mW = bVar;
    }

    public Typeface g(String str, String str2) {
        this.mS.set(str, str2);
        Typeface typeface = this.mT.get(this.mS);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.mT.put(this.mS, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.mU.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mW != null) {
                typeface = this.mW.B(str);
            }
            if (this.mW != null && typeface == null && (C = this.mW.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.mV, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.mV, "fonts/" + str + this.mZ);
            }
            this.mU.put(str, typeface);
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
