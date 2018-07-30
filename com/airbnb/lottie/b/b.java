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
    private String mO;
    @Nullable
    private c mP;
    private final Map<String, g> mQ;
    private final Map<String, Bitmap> mR = new HashMap();

    public b(Drawable.Callback callback, String str, c cVar, Map<String, g> map) {
        this.mO = str;
        if (!TextUtils.isEmpty(str) && this.mO.charAt(this.mO.length() - 1) != '/') {
            this.mO += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.mQ = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.mQ = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.mP = cVar;
    }

    @Nullable
    public Bitmap L(String str) {
        Bitmap bitmap = this.mR.get(str);
        if (bitmap == null) {
            g gVar = this.mQ.get(str);
            if (gVar == null) {
                return null;
            }
            if (this.mP != null) {
                Bitmap a = this.mP.a(gVar);
                if (a != null) {
                    this.mR.put(str, a);
                    return a;
                }
                return a;
            }
            try {
                if (TextUtils.isEmpty(this.mO)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                InputStream open = this.context.getAssets().open(this.mO + gVar.getFileName());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.mR.put(str, decodeStream);
                return decodeStream;
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        return bitmap;
    }

    public void aV() {
        Iterator<Map.Entry<String, Bitmap>> it = this.mR.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    public boolean R(Context context) {
        return (context == null && this.context == null) || (context != null && this.context.equals(context));
    }
}
