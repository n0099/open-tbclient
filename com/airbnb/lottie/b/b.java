package com.airbnb.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    private final Context context;
    private final Map<String, Bitmap> fA = new HashMap();
    private String fx;
    @Nullable
    private c fy;
    private final Map<String, g> fz;

    public b(Drawable.Callback callback, String str, c cVar, Map<String, g> map) {
        this.fx = str;
        if (!TextUtils.isEmpty(str) && this.fx.charAt(this.fx.length() - 1) != '/') {
            this.fx += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.fz = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.fz = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.fy = cVar;
    }

    @Nullable
    public Bitmap L(String str) {
        Bitmap bitmap = this.fA.get(str);
        if (bitmap == null) {
            g gVar = this.fz.get(str);
            if (gVar == null) {
                return null;
            }
            if (this.fy != null) {
                Bitmap a = this.fy.a(gVar);
                if (a != null) {
                    this.fA.put(str, a);
                    return a;
                }
                return a;
            }
            try {
                if (TextUtils.isEmpty(this.fx)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                InputStream open = this.context.getAssets().open(this.fx + gVar.getFileName());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.fA.put(str, decodeStream);
                return decodeStream;
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        return bitmap;
    }

    public void recycleBitmaps() {
        Iterator<Map.Entry<String, Bitmap>> it = this.fA.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    public boolean P(Context context) {
        return (context == null && this.context == null) || (context != null && this.context.equals(context));
    }
}
