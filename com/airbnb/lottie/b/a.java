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
    private final AssetManager nx;
    @Nullable
    private com.airbnb.lottie.b ny;
    private final i<String> nu = new i<>();
    private final Map<i<String>, Typeface> nv = new HashMap();
    private final Map<String, Typeface> nw = new HashMap();
    private String nz = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.ny = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.nx = null;
            return;
        }
        this.nx = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.ny = bVar;
    }

    public Typeface g(String str, String str2) {
        this.nu.set(str, str2);
        Typeface typeface = this.nv.get(this.nu);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.nv.put(this.nu, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.nw.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.ny != null) {
                typeface = this.ny.B(str);
            }
            if (this.ny != null && typeface == null && (C = this.ny.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.nx, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.nx, "fonts/" + str + this.nz);
            }
            this.nw.put(str, typeface);
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
