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
    private final AssetManager qd;
    @Nullable
    private com.airbnb.lottie.b qe;
    private final i<String> qa = new i<>();
    private final Map<i<String>, Typeface> qb = new HashMap();
    private final Map<String, Typeface> qc = new HashMap();
    private String qf = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.qe = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.qd = null;
            return;
        }
        this.qd = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.qe = bVar;
    }

    public Typeface n(String str, String str2) {
        this.qa.set(str, str2);
        Typeface typeface = this.qb.get(this.qa);
        if (typeface == null) {
            Typeface a = a(ab(str), str2);
            this.qb.put(this.qa, a);
            return a;
        }
        return typeface;
    }

    private Typeface ab(String str) {
        String T;
        Typeface typeface = this.qc.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.qe != null) {
                typeface = this.qe.S(str);
            }
            if (this.qe != null && typeface == null && (T = this.qe.T(str)) != null) {
                typeface = Typeface.createFromAsset(this.qd, T);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.qd, "fonts/" + str + this.qf);
            }
            this.qc.put(str, typeface);
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
