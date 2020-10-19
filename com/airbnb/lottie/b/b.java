package com.airbnb.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class b {
    private static final Object Er = new Object();
    private String Es;
    @Nullable
    private c Et;
    private final Map<String, h> Eu;
    private final Context context;

    public b(Drawable.Callback callback, String str, c cVar, Map<String, h> map) {
        this.Es = str;
        if (!TextUtils.isEmpty(str) && this.Es.charAt(this.Es.length() - 1) != '/') {
            this.Es += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.Eu = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.Eu = map;
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.Et = cVar;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            h hVar = this.Eu.get(str);
            Bitmap bitmap2 = hVar.getBitmap();
            hVar.setBitmap(null);
            return bitmap2;
        }
        return b(str, bitmap);
    }

    @Nullable
    public Bitmap bj(String str) {
        h hVar = this.Eu.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap bitmap = hVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.Et != null) {
            Bitmap fetchBitmap = this.Et.fetchBitmap(hVar);
            if (fetchBitmap != null) {
                b(str, fetchBitmap);
                return fetchBitmap;
            }
            return fetchBitmap;
        }
        String fileName = hVar.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return b(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.Es)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return b(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.Es + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (Er) {
            for (Map.Entry<String, h> entry : this.Eu.entrySet()) {
                h value = entry.getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public boolean F(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap b(String str, @Nullable Bitmap bitmap) {
        synchronized (Er) {
            this.Eu.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
