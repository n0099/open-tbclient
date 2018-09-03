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
    private String mP;
    @Nullable
    private c mQ;
    private final Map<String, g> mR;
    private final Map<String, Bitmap> mS = new HashMap();

    public b(Drawable.Callback callback, String str, c cVar, Map<String, g> map) {
        this.mP = str;
        if (!TextUtils.isEmpty(str) && this.mP.charAt(this.mP.length() - 1) != '/') {
            this.mP += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mR = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.mR = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.mQ = cVar;
    }

    @Nullable
    public Bitmap L(String str) {
        Bitmap bitmap = this.mS.get(str);
        if (bitmap == null) {
            g gVar = this.mR.get(str);
            if (gVar == null) {
                return null;
            }
            if (this.mQ != null) {
                Bitmap a = this.mQ.a(gVar);
                if (a != null) {
                    this.mS.put(str, a);
                    return a;
                }
                return a;
            }
            try {
                if (TextUtils.isEmpty(this.mP)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                InputStream open = this.context.getAssets().open(this.mP + gVar.getFileName());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.mS.put(str, decodeStream);
                return decodeStream;
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        return bitmap;
    }

    public void aV() {
        Iterator<Map.Entry<String, Bitmap>> it = this.mS.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    public boolean R(Context context) {
        return (context == null && this.context == null) || (context != null && this.context.equals(context));
    }
}
