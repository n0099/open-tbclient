package com.baidu.live.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.model.h;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.baidu.live.lottie.b bux;
    private final h<String> buw = new h<>();
    private final Map<h<String>, Typeface> ET = new HashMap();
    private final Map<String, Typeface> EU = new HashMap();
    private String EW = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.baidu.live.lottie.b bVar) {
        this.bux = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.baidu.live.lottie.b bVar) {
        this.bux = bVar;
    }

    public Typeface q(String str, String str2) {
        this.buw.set(str, str2);
        Typeface typeface = this.ET.get(this.buw);
        if (typeface == null) {
            Typeface b2 = b(bi(str), str2);
            this.ET.put(this.buw, b2);
            return b2;
        }
        return typeface;
    }

    private Typeface bi(String str) {
        String ba;
        Typeface typeface = this.EU.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.bux != null) {
                typeface = this.bux.aZ(str);
            }
            if (this.bux != null && typeface == null && (ba = this.bux.ba(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, ba);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.EW);
            }
            this.EU.put(str, typeface);
        }
        return typeface;
    }

    private Typeface b(Typeface typeface, String str) {
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
