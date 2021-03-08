package com.baidu.live.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.lottie.c;
import com.baidu.live.lottie.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    private static final Object Go = new Object();
    private String Gp;
    private final Map<String, i> Gr;
    @Nullable
    private c buN;
    private final Context context;

    public b(Drawable.Callback callback, String str, c cVar, Map<String, i> map) {
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
        a(cVar);
    }

    public void a(@Nullable c cVar) {
        this.buN = cVar;
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            i iVar = this.Gr.get(str);
            Bitmap bitmap2 = iVar.getBitmap();
            iVar.setBitmap(null);
            return bitmap2;
        }
        return b(str, bitmap);
    }

    @Nullable
    public Bitmap bn(String str) {
        i iVar = this.Gr.get(str);
        if (iVar == null) {
            return null;
        }
        Bitmap bitmap = iVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        if (this.buN != null) {
            Bitmap fetchBitmap = this.buN.fetchBitmap(iVar);
            if (fetchBitmap != null) {
                b(str, fetchBitmap);
                return fetchBitmap;
            }
            return fetchBitmap;
        }
        String fileName = iVar.getFileName();
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
            for (Map.Entry<String, i> entry : this.Gr.entrySet()) {
                i value = entry.getValue();
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
