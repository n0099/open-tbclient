package com.baidu.cloudsdk.social.share.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MediaIconManager {
    private static MediaIconManager h;

    /* renamed from: a  reason: collision with root package name */
    private Map f873a = new HashMap();
    private Map b = new HashMap();
    private Map c = new HashMap();
    private Map d = new HashMap();
    private Map e = new HashMap();
    private Context f;
    private SocialShareConfig g;

    private MediaIconManager(Context context) {
        Validator.notNull(context, "context");
        this.f = context;
        this.g = SocialShareConfig.getInstance(context);
    }

    private Drawable a(Drawable drawable, int i, PorterDuff.Mode mode) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawRect(0.0f, 0.0f, createBitmap.getWidth(), createBitmap.getHeight(), paint);
        canvas.save(31);
        canvas.restore();
        return new BitmapDrawable(createBitmap);
    }

    public static MediaIconManager getInstance(Context context) {
        if (h == null) {
            h = new MediaIconManager(context);
        }
        return h;
    }

    public Drawable getDisabledIcon(String str) {
        int pixel;
        Drawable drawable = (Drawable) this.e.get(str);
        if (drawable == null) {
            Bitmap copy = ((BitmapDrawable) getNormalIcon(str)).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            for (int i = 0; i < copy.getWidth(); i++) {
                for (int i2 = 0; i2 < copy.getHeight(); i2++) {
                    int pixel2 = 2097152000 & copy.getPixel(i, i2);
                    int i3 = (int) ((((65280 & pixel) >> 8) * 0.59d) + (((16711680 & pixel) >> 16) * 0.3d) + ((pixel & Util.MASK_8BIT) * 0.11d));
                    copy.setPixel(i, i2, i3 | pixel2 | (i3 << 16) | (i3 << 8));
                }
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(copy);
            this.e.put(str, bitmapDrawable);
            return bitmapDrawable;
        }
        return drawable;
    }

    public Drawable getNightModeIcon(String str) {
        Drawable drawable = (Drawable) this.b.get(str);
        if (drawable == null) {
            Drawable a2 = a(getNormalIcon(str), 1275068416, PorterDuff.Mode.SRC_ATOP);
            this.b.put(str, a2);
            return a2;
        }
        return drawable;
    }

    public Drawable getNightModePressedIcon(String str) {
        Drawable drawable = (Drawable) this.b.get(str);
        if (drawable == null) {
            Drawable a2 = a(getNormalIcon(str), 2130706432, PorterDuff.Mode.SRC_ATOP);
            this.d.put(str, a2);
            return a2;
        }
        return drawable;
    }

    public Drawable getNormalIcon(String str) {
        Drawable drawable = (Drawable) this.f873a.get(str);
        if (drawable == null) {
            Drawable drawable2 = DrawableUtils.getDrawable(this.f, this.g.getAssetFileName(str));
            this.f873a.put(str, drawable2);
            return drawable2;
        }
        return drawable;
    }

    public Drawable getNormalPressedIcon(String str) {
        Drawable drawable = (Drawable) this.c.get(str);
        if (drawable == null) {
            Drawable a2 = a(getNormalIcon(str), 855638016, PorterDuff.Mode.SRC_ATOP);
            this.c.put(str, a2);
            return a2;
        }
        return drawable;
    }
}
