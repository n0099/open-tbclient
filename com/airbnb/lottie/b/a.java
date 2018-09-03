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
    private final AssetManager mM;
    @Nullable
    private com.airbnb.lottie.b mN;
    private final i<String> mJ = new i<>();
    private final Map<i<String>, Typeface> mK = new HashMap();
    private final Map<String, Typeface> mL = new HashMap();
    private String mO = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.mN = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mM = null;
            return;
        }
        this.mM = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.mN = bVar;
    }

    public Typeface g(String str, String str2) {
        this.mJ.set(str, str2);
        Typeface typeface = this.mK.get(this.mJ);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.mK.put(this.mJ, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.mL.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mN != null) {
                typeface = this.mN.B(str);
            }
            if (this.mN != null && typeface == null && (C = this.mN.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.mM, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.mM, "fonts/" + str + this.mO);
            }
            this.mL.put(str, typeface);
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
