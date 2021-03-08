package com.airbnb.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    private static final Object Go = new Object();
    private String Gp;
    @Nullable
    private com.airbnb.lottie.b Gq;
    private final Map<String, g> Gr;
    private final Context context;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        this.Gp = str;
        if (!TextUtils.isEmpty(str) && this.Gp.charAt(this.Gp.length() - 1) != '/') {
            this.Gp += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.Gr = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.Gr = map;
        a(bVar);
    }

    public void a(@Nullable com.airbnb.lottie.b bVar) {
        this.Gq = bVar;
    }

    @Nullable
    public Bitmap bn(String str) {
        g gVar = this.Gr.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.Gq != null) {
            Bitmap a2 = this.Gq.a(gVar);
            if (a2 != null) {
                b(str, a2);
                return a2;
            }
            return a2;
        }
        String fileName = gVar.getFileName();
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
            if (TextUtils.isEmpty(this.Gp)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return b(str, BitmapFactory.decodeStream(this.context.getAssets().open(this.Gp + fileName), null, options));
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void recycleBitmaps() {
        synchronized (Go) {
            for (Map.Entry<String, g> entry : this.Gr.entrySet()) {
                g value = entry.getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public boolean G(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap b(String str, @Nullable Bitmap bitmap) {
        synchronized (Go) {
            this.Gr.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
