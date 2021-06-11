package com.baidu.apollon.base.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.imagemanager.ImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class NetImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public static final String f3630b = "NetImageView";
    public static Handler k;
    public static HashMap<String, Integer> l;
    public String m;
    public Drawable n;
    public Drawable o;
    public boolean p;
    public int q;
    public int r;
    public ImageView.ScaleType s;
    public boolean t;
    public int u;
    public ImageLoader.OnGetBitmapListener v;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3629a = ApollonConstants.DEBUG & true;

    /* renamed from: c  reason: collision with root package name */
    public static String f3631c = "ldpi";

    /* renamed from: d  reason: collision with root package name */
    public static String f3632d = "mdpi";

    /* renamed from: e  reason: collision with root package name */
    public static String f3633e = "hdpi";

    /* renamed from: f  reason: collision with root package name */
    public static String f3634f = "xhdpi";

    /* renamed from: g  reason: collision with root package name */
    public static String f3635g = "xxhdpi";

    /* renamed from: h  reason: collision with root package name */
    public static String f3636h = "xxxhdpi";

    /* renamed from: i  reason: collision with root package name */
    public static String f3637i = "tvdpi";
    public static String j = "density";

    /* loaded from: classes.dex */
    public static class a implements ImageLoader.OnGetBitmapListener {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<NetImageView> f3638a;

        public a(NetImageView netImageView) {
            this.f3638a = new WeakReference<>(netImageView);
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public boolean needCancel(String str, Object obj) {
            WeakReference<NetImageView> weakReference = this.f3638a;
            boolean z = false;
            if (weakReference != null) {
                NetImageView netImageView = weakReference.get();
                if (netImageView == null) {
                    return false;
                }
                z = (netImageView.o == null && TextUtils.equals(str, netImageView.m)) ? true : true;
                if (NetImageView.f3629a && z) {
                    Log.i(NetImageView.f3630b, "Canceled   url: " + str);
                }
            }
            return z;
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onError(final String str, Object obj) {
            final NetImageView netImageView;
            if (NetImageView.f3629a) {
                Log.d(NetImageView.f3630b, "getImage error: " + str);
                WeakReference<NetImageView> weakReference = this.f3638a;
                if (weakReference == null || (netImageView = weakReference.get()) == null) {
                    return;
                }
                netImageView.post(new Runnable() { // from class: com.baidu.apollon.base.widget.NetImageView.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TextUtils.equals(netImageView.m, str)) {
                            netImageView.onLoadUrlError(true);
                        }
                    }
                });
            }
        }

        @Override // com.baidu.apollon.imagemanager.ImageLoader.OnGetBitmapListener
        public void onGetBitmap(final String str, Object obj, final Bitmap bitmap) {
            WeakReference<NetImageView> weakReference = this.f3638a;
            if (weakReference != null) {
                final NetImageView netImageView = weakReference.get();
                if (NetImageView.k == null || netImageView == null) {
                    return;
                }
                NetImageView.k.post(new Runnable() { // from class: com.baidu.apollon.base.widget.NetImageView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        netImageView.setRemoteDrawable(str, bitmap);
                    }
                });
            }
        }
    }

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        l = hashMap;
        hashMap.put(f3631c, 120);
        l.put(f3632d, 160);
        l.put(f3637i, 213);
        l.put(f3633e, 240);
        l.put(f3634f, Integer.valueOf((int) MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP));
        l.put(f3635g, 480);
        l.put(f3636h, 640);
    }

    public NetImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = false;
        this.v = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    private void c() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i2 = this.q;
        if (i2 != Integer.MIN_VALUE) {
            layoutParams.width = i2;
        }
        int i3 = this.r;
        if (i3 != Integer.MIN_VALUE) {
            layoutParams.height = i3;
        }
    }

    private void setDensity(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, j);
        if (TextUtils.isEmpty(attributeValue)) {
            return;
        }
        Integer num = l.get(attributeValue.trim().toLowerCase());
        if (num != null) {
            this.u = num.intValue();
        }
    }

    public void callRealSetImageDrawable(Drawable drawable, boolean z) {
        Drawable drawable2;
        if (hasRemoteDrawableDone() && (drawable2 = this.o) != null) {
            super.setImageDrawable(drawable2);
            return;
        }
        c();
        if (drawable != null) {
            super.setImageDrawable(drawable);
        }
        if (z) {
            requestLoadingRemoteImage();
        }
    }

    public boolean hasRemoteDrawableDone() {
        return this.o != null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.t) {
            releaseRemoteDrawable();
        }
        this.v = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.p && !hasRemoteDrawableDone()) {
            requestLoadingRemoteImage();
        }
        super.onDraw(canvas);
    }

    public void onLoadUrlError(boolean z) {
    }

    public void releaseRemoteDrawable() {
        this.m = null;
        this.o = null;
        callRealSetImageDrawable(this.n, false);
    }

    public void requestLoadingRemoteImage() {
        if (hasRemoteDrawableDone()) {
            callRealSetImageDrawable(this.o, false);
        } else if (this.p || TextUtils.isEmpty(this.m)) {
        } else {
            ImageLoader.getInstance(getContext()).getBitmapFromDiskOrNet(this.m, this.v, null, this.u);
            this.p = true;
        }
    }

    public void setDefaultSize(int i2, int i3) {
        this.q = i2;
        this.r = i3;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        super.setImageDrawable(drawable);
        this.m = null;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.m = null;
        try {
            this.n = getResources().getDrawable(i2);
        } catch (Exception unused) {
            this.n = null;
        }
        Drawable drawable = this.n;
        setImageDrawable(drawable != null ? drawable : null);
    }

    public void setImageUrl(String str) {
        setImageUrl(str, true);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        c();
    }

    public void setReleaseWhenDetachFlag(boolean z) {
        this.t = z;
    }

    public void setRemoteDrawable(String str, Bitmap bitmap) {
        if (this.o == null && TextUtils.equals(str, this.m)) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            this.o = bitmapDrawable;
            callRealSetImageDrawable(bitmapDrawable, false);
            if (f3629a) {
                Log.d(f3630b, "getImage ok: " + this.o.getIntrinsicWidth() + "x" + this.o.getIntrinsicHeight() + " url: " + str);
            }
        }
    }

    public void setImageUrl(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.m = null;
        } else if (TextUtils.equals(this.m, str)) {
        } else {
            if (f3629a) {
                Log.d(f3630b, "req: " + z + " img url: " + str);
            }
            this.m = str;
            this.o = null;
            this.p = false;
            Bitmap bitmapFromMemCache = ImageLoader.getInstance(getContext()).getBitmapFromMemCache(this.m);
            if (bitmapFromMemCache != null) {
                setRemoteDrawable(this.m, bitmapFromMemCache);
            } else {
                callRealSetImageDrawable(this.n, z);
            }
        }
    }

    private void a(Context context) {
        if (k == null) {
            synchronized (NetImageView.class) {
                if (k == null) {
                    k = new Handler(context.getMainLooper());
                }
            }
        }
        if (this.s == null) {
            this.s = ImageView.ScaleType.FIT_CENTER;
        }
        this.q = Integer.MIN_VALUE;
        this.r = Integer.MIN_VALUE;
    }

    public NetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = false;
        this.v = new a(this);
        setDensity(attributeSet);
        a(context);
    }

    public NetImageView(Context context) {
        super(context);
        this.t = false;
        this.v = new a(this);
        a(context);
    }
}
