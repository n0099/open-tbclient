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
    private final AssetManager mL;
    @Nullable
    private com.airbnb.lottie.b mM;
    private final i<String> mI = new i<>();
    private final Map<i<String>, Typeface> mJ = new HashMap();
    private final Map<String, Typeface> mK = new HashMap();
    private String mN = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.mM = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mL = null;
            return;
        }
        this.mL = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.mM = bVar;
    }

    public Typeface g(String str, String str2) {
        this.mI.set(str, str2);
        Typeface typeface = this.mJ.get(this.mI);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.mJ.put(this.mI, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.mK.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.mM != null) {
                typeface = this.mM.B(str);
            }
            if (this.mM != null && typeface == null && (C = this.mM.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.mL, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.mL, "fonts/" + str + this.mN);
            }
            this.mK.put(str, typeface);
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
