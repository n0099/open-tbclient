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
/* loaded from: classes7.dex */
public class a {
    @Nullable
    private com.airbnb.lottie.b Fg;
    private final AssetManager assetManager;
    private final h<String> Fd = new h<>();
    private final Map<h<String>, Typeface> Fe = new HashMap();
    private final Map<String, Typeface> Ff = new HashMap();
    private String Fh = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.Fg = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.Fg = bVar;
    }

    public Typeface q(String str, String str2) {
        this.Fd.set(str, str2);
        Typeface typeface = this.Fe.get(this.Fd);
        if (typeface == null) {
            Typeface a2 = a(bl(str), str2);
            this.Fe.put(this.Fd, a2);
            return a2;
        }
        return typeface;
    }

    private Typeface bl(String str) {
        String bd;
        Typeface typeface = this.Ff.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.Fg != null) {
                typeface = this.Fg.bc(str);
            }
            if (this.Fg != null && typeface == null && (bd = this.Fg.bd(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, bd);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.Fh);
            }
            this.Ff.put(str, typeface);
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
