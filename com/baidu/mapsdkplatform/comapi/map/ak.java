package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.common.SysOSUtil;
/* loaded from: classes2.dex */
public class ak extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f7635a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7636b;

    /* renamed from: c  reason: collision with root package name */
    public Context f7637c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7638d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f7639e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f7640f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f7641g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f7642h;
    public Bitmap i;
    public Bitmap j;
    public Bitmap k;
    public int l;
    public boolean m;
    public boolean n;

    @Deprecated
    public ak(Context context) {
        super(context);
        this.m = false;
        this.n = false;
        this.f7637c = context;
        c();
        if (this.f7638d == null || this.f7639e == null || this.f7640f == null || this.f7641g == null) {
            return;
        }
        this.f7635a = new ImageView(this.f7637c);
        this.f7636b = new ImageView(this.f7637c);
        this.f7635a.setImageBitmap(this.f7638d);
        this.f7636b.setImageBitmap(this.f7640f);
        this.l = a(this.f7640f.getHeight() / 6);
        a(this.f7635a, "main_topbtn_up.9.png");
        a(this.f7636b, "main_bottombtn_up.9.png");
        this.f7635a.setId(0);
        this.f7636b.setId(1);
        this.f7635a.setClickable(true);
        this.f7636b.setClickable(true);
        this.f7635a.setOnTouchListener(this);
        this.f7636b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f7635a);
        addView(this.f7636b);
        this.n = true;
    }

    public ak(Context context, boolean z) {
        super(context);
        this.m = false;
        this.n = false;
        this.f7637c = context;
        this.m = z;
        this.f7635a = new ImageView(this.f7637c);
        this.f7636b = new ImageView(this.f7637c);
        if (z) {
            d();
            if (this.f7642h == null || this.i == null || this.j == null || this.k == null) {
                return;
            }
            this.f7635a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7636b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7635a.setImageBitmap(this.f7642h);
            this.f7636b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f7638d;
            if (bitmap == null || this.f7639e == null || this.f7640f == null || this.f7641g == null) {
                return;
            }
            this.f7635a.setImageBitmap(bitmap);
            this.f7636b.setImageBitmap(this.f7640f);
            this.l = a(this.f7640f.getHeight() / 6);
            a(this.f7635a, "main_topbtn_up.9.png");
            a(this.f7636b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f7635a.setId(0);
        this.f7636b.setId(1);
        this.f7635a.setClickable(true);
        this.f7636b.setClickable(true);
        this.f7635a.setOnTouchListener(this);
        this.f7636b.setOnTouchListener(this);
        addView(this.f7635a);
        addView(this.f7636b);
        this.n = true;
    }

    private int a(int i) {
        return (int) ((this.f7637c.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
        matrix.postScale(f2, f2);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7637c);
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    private void a(View view, String str) {
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7637c);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        int i = this.l;
        view.setPadding(i, i, i, i);
    }

    private void c() {
        this.f7638d = a("main_icon_zoomin.png");
        this.f7639e = a("main_icon_zoomin_dis.png");
        this.f7640f = a("main_icon_zoomout.png");
        this.f7641g = a("main_icon_zoomout_dis.png");
    }

    private void d() {
        this.f7642h = a("wear_zoom_in.png");
        this.i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public void a(View.OnClickListener onClickListener) {
        this.f7635a.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f7635a.setEnabled(z);
        if (z) {
            imageView = this.f7635a;
            bitmap = this.f7638d;
        } else {
            imageView = this.f7635a;
            bitmap = this.f7639e;
        }
        imageView.setImageBitmap(bitmap);
    }

    public boolean a() {
        return this.n;
    }

    public void b() {
        Bitmap bitmap = this.f7638d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7638d.recycle();
            this.f7638d = null;
        }
        Bitmap bitmap2 = this.f7639e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f7639e.recycle();
            this.f7639e = null;
        }
        Bitmap bitmap3 = this.f7640f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f7640f.recycle();
            this.f7640f = null;
        }
        Bitmap bitmap4 = this.f7641g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.f7641g.recycle();
            this.f7641g = null;
        }
        Bitmap bitmap5 = this.f7642h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.f7642h.recycle();
            this.f7642h = null;
        }
        Bitmap bitmap6 = this.i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        Bitmap bitmap7 = this.j;
        if (bitmap7 != null && !bitmap7.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        Bitmap bitmap8 = this.k;
        if (bitmap8 == null || bitmap8.isRecycled()) {
            return;
        }
        this.k.recycle();
        this.k = null;
    }

    public void b(View.OnClickListener onClickListener) {
        this.f7636b.setOnClickListener(onClickListener);
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f7636b.setEnabled(z);
        if (z) {
            imageView = this.f7636b;
            bitmap = this.f7640f;
        } else {
            imageView = this.f7636b;
            bitmap = this.f7641g;
        }
        imageView.setImageBitmap(bitmap);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        String str;
        if (view instanceof ImageView) {
            int id = ((ImageView) view).getId();
            if (id == 0) {
                if (motionEvent.getAction() == 0) {
                    if (this.m) {
                        imageView = this.f7635a;
                        bitmap = this.i;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7635a;
                    str = "main_topbtn_down.9.png";
                    a(imageView2, str);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    if (this.m) {
                        imageView = this.f7635a;
                        bitmap = this.f7642h;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7635a;
                    str = "main_topbtn_up.9.png";
                    a(imageView2, str);
                    return false;
                } else {
                    return false;
                }
            } else if (id != 1) {
                return false;
            } else {
                if (motionEvent.getAction() == 0) {
                    if (this.m) {
                        imageView = this.f7636b;
                        bitmap = this.k;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7636b;
                    str = "main_bottombtn_down.9.png";
                    a(imageView2, str);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    if (this.m) {
                        imageView = this.f7636b;
                        bitmap = this.j;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7636b;
                    str = "main_bottombtn_up.9.png";
                    a(imageView2, str);
                    return false;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
