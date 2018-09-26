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
    private String pt;
    @Nullable
    private c pu;
    private final Map<String, g> pv;
    private final Map<String, Bitmap> pw = new HashMap();

    public b(Drawable.Callback callback, String str, c cVar, Map<String, g> map) {
        this.pt = str;
        if (!TextUtils.isEmpty(str) && this.pt.charAt(this.pt.length() - 1) != '/') {
            this.pt += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.pv = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.pv = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.pu = cVar;
    }

    @Nullable
    public Bitmap ac(String str) {
        Bitmap bitmap = this.pw.get(str);
        if (bitmap == null) {
            g gVar = this.pv.get(str);
            if (gVar == null) {
                return null;
            }
            if (this.pu != null) {
                Bitmap a = this.pu.a(gVar);
                if (a != null) {
                    this.pw.put(str, a);
                    return a;
                }
                return a;
            }
            try {
                if (TextUtils.isEmpty(this.pt)) {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
                InputStream open = this.context.getAssets().open(this.pt + gVar.getFileName());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.pw.put(str, decodeStream);
                return decodeStream;
            } catch (IOException e) {
                Log.w("LOTTIE", "Unable to open asset.", e);
                return null;
            }
        }
        return bitmap;
    }

    public void cc() {
        Iterator<Map.Entry<String, Bitmap>> it = this.pw.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    public boolean ay(Context context) {
        return (context == null && this.context == null) || (context != null && this.context.equals(context));
    }
}
