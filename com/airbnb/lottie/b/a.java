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
    private final AssetManager pp;
    @Nullable
    private com.airbnb.lottie.b pq;
    private final i<String> pj = new i<>();
    private final Map<i<String>, Typeface> pl = new HashMap();
    private final Map<String, Typeface> po = new HashMap();
    private String pr = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.pq = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.pp = null;
            return;
        }
        this.pp = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.pq = bVar;
    }

    public Typeface n(String str, String str2) {
        this.pj.set(str, str2);
        Typeface typeface = this.pl.get(this.pj);
        if (typeface == null) {
            Typeface a = a(ab(str), str2);
            this.pl.put(this.pj, a);
            return a;
        }
        return typeface;
    }

    private Typeface ab(String str) {
        String T;
        Typeface typeface = this.po.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.pq != null) {
                typeface = this.pq.S(str);
            }
            if (this.pq != null && typeface == null && (T = this.pq.T(str)) != null) {
                typeface = Typeface.createFromAsset(this.pp, T);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.pp, "fonts/" + str + this.pr);
            }
            this.po.put(str, typeface);
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
