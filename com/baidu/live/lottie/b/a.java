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
/* loaded from: classes9.dex */
public class a {
    private final AssetManager assetManager;
    @Nullable
    private com.baidu.live.lottie.b bpJ;
    private final h<String> bpI = new h<>();
    private final Map<h<String>, Typeface> ER = new HashMap();
    private final Map<String, Typeface> ES = new HashMap();
    private String EU = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.baidu.live.lottie.b bVar) {
        this.bpJ = bVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.assetManager = null;
            return;
        }
        this.assetManager = ((View) callback).getContext().getAssets();
    }

    public void a(@Nullable com.baidu.live.lottie.b bVar) {
        this.bpJ = bVar;
    }

    public Typeface q(String str, String str2) {
        this.bpI.set(str, str2);
        Typeface typeface = this.ER.get(this.bpI);
        if (typeface == null) {
            Typeface b2 = b(bi(str), str2);
            this.ER.put(this.bpI, b2);
            return b2;
        }
        return typeface;
    }

    private Typeface bi(String str) {
        String ba;
        Typeface typeface = this.ES.get(str);
        if (typeface == null) {
            typeface = null;
            if (this.bpJ != null) {
                typeface = this.bpJ.aZ(str);
            }
            if (this.bpJ != null && typeface == null && (ba = this.bpJ.ba(str)) != null) {
                typeface = Typeface.createFromAsset(this.assetManager, ba);
            }
            if (typeface == null) {
                typeface = Typeface.createFromAsset(this.assetManager, "fonts/" + str + this.EU);
            }
            this.ES.put(str, typeface);
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
