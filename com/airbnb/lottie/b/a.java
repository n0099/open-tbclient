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
    private final AssetManager ny;
    @Nullable
    private com.airbnb.lottie.b nz;
    private final i<String> nv = new i<>();
    private final Map<i<String>, Typeface> nw = new HashMap();
    private final Map<String, Typeface> nx = new HashMap();
    private String nA = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.nz = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.ny = null;
            return;
        }
        this.ny = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.nz = bVar;
    }

    public Typeface g(String str, String str2) {
        this.nv.set(str, str2);
        Typeface typeface = this.nw.get(this.nv);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.nw.put(this.nv, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.nx.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.nz != null) {
                typeface = this.nz.B(str);
            }
            if (this.nz != null && typeface == null && (C = this.nz.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.ny, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.ny, "fonts/" + str + this.nA);
            }
            this.nx.put(str, typeface);
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
