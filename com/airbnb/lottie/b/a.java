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
    private final AssetManager fT;
    @Nullable
    private com.airbnb.lottie.b fU;
    private final i<String> fQ = new i<>();
    private final Map<i<String>, Typeface> fR = new HashMap();
    private final Map<String, Typeface> fS = new HashMap();
    private String fV = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.b bVar) {
        this.fU = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.fT = null;
            return;
        }
        this.fT = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.fU = bVar;
    }

    public Typeface g(String str, String str2) {
        this.fQ.set(str, str2);
        Typeface typeface = this.fR.get(this.fQ);
        if (typeface == null) {
            Typeface a = a(K(str), str2);
            this.fR.put(this.fQ, a);
            return a;
        }
        return typeface;
    }

    private Typeface K(String str) {
        String C;
        Typeface typeface = this.fS.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.fU != null) {
                typeface = this.fU.B(str);
            }
            if (this.fU != null && typeface == null && (C = this.fU.C(str)) != null) {
                typeface = Typeface.createFromAsset(this.fT, C);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.fT, "fonts/" + str + this.fV);
            }
            this.fS.put(str, typeface);
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
