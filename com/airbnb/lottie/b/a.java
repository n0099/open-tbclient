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
    private final AssetManager qc;
    @Nullable
    private com.airbnb.lottie.b qd;
    private final i<String> pZ = new i<>();
    private final Map<i<String>, Typeface> qa = new HashMap();
    private final Map<String, Typeface> qb = new HashMap();
    private String qe = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.qd = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.qc = null;
            return;
        }
        this.qc = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.qd = bVar;
    }

    public Typeface n(String str, String str2) {
        this.pZ.set(str, str2);
        Typeface typeface = this.qa.get(this.pZ);
        if (typeface == null) {
            Typeface a = a(ab(str), str2);
            this.qa.put(this.pZ, a);
            return a;
        }
        return typeface;
    }

    private Typeface ab(String str) {
        String T;
        Typeface typeface = this.qb.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.qd != null) {
                typeface = this.qd.S(str);
            }
            if (this.qd != null && typeface == null && (T = this.qd.T(str)) != null) {
                typeface = Typeface.createFromAsset(this.qc, T);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.qc, "fonts/" + str + this.qe);
            }
            this.qb.put(str, typeface);
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
