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
    private final AssetManager pY;
    @Nullable
    private com.airbnb.lottie.b pZ;
    private final i<String> pV = new i<>();
    private final Map<i<String>, Typeface> pW = new HashMap();
    private final Map<String, Typeface> pX = new HashMap();
    private String qa = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.pZ = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.pY = null;
            return;
        }
        this.pY = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.pZ = bVar;
    }

    public Typeface n(String str, String str2) {
        this.pV.set(str, str2);
        Typeface typeface = this.pW.get(this.pV);
        if (typeface == null) {
            Typeface a = a(ab(str), str2);
            this.pW.put(this.pV, a);
            return a;
        }
        return typeface;
    }

    private Typeface ab(String str) {
        String T;
        Typeface typeface = this.pX.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.pZ != null) {
                typeface = this.pZ.S(str);
            }
            if (this.pZ != null && typeface == null && (T = this.pZ.T(str)) != null) {
                typeface = Typeface.createFromAsset(this.pY, T);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.pY, "fonts/" + str + this.qa);
            }
            this.pX.put(str, typeface);
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
