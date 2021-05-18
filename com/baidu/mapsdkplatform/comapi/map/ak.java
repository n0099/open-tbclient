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
    public ImageView f7704a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7705b;

    /* renamed from: c  reason: collision with root package name */
    public Context f7706c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f7707d;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f7708e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f7709f;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f7710g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f7711h;

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f7712i;
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
        this.f7706c = context;
        c();
        if (this.f7707d == null || this.f7708e == null || this.f7709f == null || this.f7710g == null) {
            return;
        }
        this.f7704a = new ImageView(this.f7706c);
        this.f7705b = new ImageView(this.f7706c);
        this.f7704a.setImageBitmap(this.f7707d);
        this.f7705b.setImageBitmap(this.f7709f);
        this.l = a(this.f7709f.getHeight() / 6);
        a(this.f7704a, "main_topbtn_up.9.png");
        a(this.f7705b, "main_bottombtn_up.9.png");
        this.f7704a.setId(0);
        this.f7705b.setId(1);
        this.f7704a.setClickable(true);
        this.f7705b.setClickable(true);
        this.f7704a.setOnTouchListener(this);
        this.f7705b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f7704a);
        addView(this.f7705b);
        this.n = true;
    }

    public ak(Context context, boolean z) {
        super(context);
        this.m = false;
        this.n = false;
        this.f7706c = context;
        this.m = z;
        this.f7704a = new ImageView(this.f7706c);
        this.f7705b = new ImageView(this.f7706c);
        if (z) {
            d();
            if (this.f7711h == null || this.f7712i == null || this.j == null || this.k == null) {
                return;
            }
            this.f7704a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7705b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f7704a.setImageBitmap(this.f7711h);
            this.f7705b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            Bitmap bitmap = this.f7707d;
            if (bitmap == null || this.f7708e == null || this.f7709f == null || this.f7710g == null) {
                return;
            }
            this.f7704a.setImageBitmap(bitmap);
            this.f7705b.setImageBitmap(this.f7709f);
            this.l = a(this.f7709f.getHeight() / 6);
            a(this.f7704a, "main_topbtn_up.9.png");
            a(this.f7705b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f7704a.setId(0);
        this.f7705b.setId(1);
        this.f7704a.setClickable(true);
        this.f7705b.setClickable(true);
        this.f7704a.setOnTouchListener(this);
        this.f7705b.setOnTouchListener(this);
        addView(this.f7704a);
        addView(this.f7705b);
        this.n = true;
    }

    private int a(int i2) {
        return (int) ((this.f7706c.getResources().getDisplayMetrics().density * i2) + 0.5f);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        float f2 = densityDpi > 480 ? 1.8f : (densityDpi <= 320 || densityDpi > 480) ? 1.2f : 1.5f;
        matrix.postScale(f2, f2);
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7706c);
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    private void a(View view, String str) {
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.f7706c);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        int i2 = this.l;
        view.setPadding(i2, i2, i2, i2);
    }

    private void c() {
        this.f7707d = a("main_icon_zoomin.png");
        this.f7708e = a("main_icon_zoomin_dis.png");
        this.f7709f = a("main_icon_zoomout.png");
        this.f7710g = a("main_icon_zoomout_dis.png");
    }

    private void d() {
        this.f7711h = a("wear_zoom_in.png");
        this.f7712i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public void a(View.OnClickListener onClickListener) {
        this.f7704a.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f7704a.setEnabled(z);
        if (z) {
            imageView = this.f7704a;
            bitmap = this.f7707d;
        } else {
            imageView = this.f7704a;
            bitmap = this.f7708e;
        }
        imageView.setImageBitmap(bitmap);
    }

    public boolean a() {
        return this.n;
    }

    public void b() {
        Bitmap bitmap = this.f7707d;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f7707d.recycle();
            this.f7707d = null;
        }
        Bitmap bitmap2 = this.f7708e;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f7708e.recycle();
            this.f7708e = null;
        }
        Bitmap bitmap3 = this.f7709f;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.f7709f.recycle();
            this.f7709f = null;
        }
        Bitmap bitmap4 = this.f7710g;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.f7710g.recycle();
            this.f7710g = null;
        }
        Bitmap bitmap5 = this.f7711h;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            this.f7711h.recycle();
            this.f7711h = null;
        }
        Bitmap bitmap6 = this.f7712i;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            this.f7712i.recycle();
            this.f7712i = null;
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
        this.f7705b.setOnClickListener(onClickListener);
    }

    public void b(boolean z) {
        ImageView imageView;
        Bitmap bitmap;
        this.f7705b.setEnabled(z);
        if (z) {
            imageView = this.f7705b;
            bitmap = this.f7709f;
        } else {
            imageView = this.f7705b;
            bitmap = this.f7710g;
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
                        imageView = this.f7704a;
                        bitmap = this.f7712i;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7704a;
                    str = "main_topbtn_down.9.png";
                    a(imageView2, str);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    if (this.m) {
                        imageView = this.f7704a;
                        bitmap = this.f7711h;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7704a;
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
                        imageView = this.f7705b;
                        bitmap = this.k;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7705b;
                    str = "main_bottombtn_down.9.png";
                    a(imageView2, str);
                    return false;
                } else if (motionEvent.getAction() == 1) {
                    if (this.m) {
                        imageView = this.f7705b;
                        bitmap = this.j;
                        imageView.setImageBitmap(bitmap);
                        return false;
                    }
                    imageView2 = this.f7705b;
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
