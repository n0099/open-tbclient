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
/* loaded from: classes4.dex */
public class ak extends LinearLayout implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f2219a;
    private ImageView b;
    private Context c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private int l;
    private boolean m;
    private boolean n;

    @Deprecated
    public ak(Context context) {
        super(context);
        this.m = false;
        this.n = false;
        this.c = context;
        c();
        if (this.d == null || this.e == null || this.f == null || this.g == null) {
            return;
        }
        this.f2219a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        this.f2219a.setImageBitmap(this.d);
        this.b.setImageBitmap(this.f);
        this.l = a(this.f.getHeight() / 6);
        a(this.f2219a, "main_topbtn_up.9.png");
        a(this.b, "main_bottombtn_up.9.png");
        this.f2219a.setId(0);
        this.b.setId(1);
        this.f2219a.setClickable(true);
        this.b.setClickable(true);
        this.f2219a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f2219a);
        addView(this.b);
        this.n = true;
    }

    public ak(Context context, boolean z) {
        super(context);
        this.m = false;
        this.n = false;
        this.c = context;
        this.m = z;
        this.f2219a = new ImageView(this.c);
        this.b = new ImageView(this.c);
        if (z) {
            d();
            if (this.h == null || this.i == null || this.j == null || this.k == null) {
                return;
            }
            this.f2219a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.f2219a.setImageBitmap(this.h);
            this.b.setImageBitmap(this.j);
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(0);
        } else {
            c();
            if (this.d == null || this.e == null || this.f == null || this.g == null) {
                return;
            }
            this.f2219a.setImageBitmap(this.d);
            this.b.setImageBitmap(this.f);
            this.l = a(this.f.getHeight() / 6);
            a(this.f2219a, "main_topbtn_up.9.png");
            a(this.b, "main_bottombtn_up.9.png");
            setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            setOrientation(1);
        }
        this.f2219a.setId(0);
        this.b.setId(1);
        this.f2219a.setClickable(true);
        this.b.setClickable(true);
        this.f2219a.setOnTouchListener(this);
        this.b.setOnTouchListener(this);
        addView(this.f2219a);
        addView(this.b);
        this.n = true;
    }

    private int a(int i) {
        return (int) ((this.c.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        if (densityDpi > 480) {
            matrix.postScale(1.8f, 1.8f);
        } else if (densityDpi <= 320 || densityDpi > 480) {
            matrix.postScale(1.2f, 1.2f);
        } else {
            matrix.postScale(1.5f, 1.5f);
        }
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
        return Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true);
    }

    private void a(View view, String str) {
        Bitmap a2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(str, this.c);
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(a2, ninePatchChunk, new Rect(), null));
        view.setPadding(this.l, this.l, this.l, this.l);
    }

    private void c() {
        this.d = a("main_icon_zoomin.png");
        this.e = a("main_icon_zoomin_dis.png");
        this.f = a("main_icon_zoomout.png");
        this.g = a("main_icon_zoomout_dis.png");
    }

    private void d() {
        this.h = a("wear_zoom_in.png");
        this.i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public void a(View.OnClickListener onClickListener) {
        this.f2219a.setOnClickListener(onClickListener);
    }

    public void a(boolean z) {
        this.f2219a.setEnabled(z);
        if (z) {
            this.f2219a.setImageBitmap(this.d);
        } else {
            this.f2219a.setImageBitmap(this.e);
        }
    }

    public boolean a() {
        return this.n;
    }

    public void b() {
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        if (this.f != null && !this.f.isRecycled()) {
            this.f.recycle();
            this.f = null;
        }
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
        if (this.h != null && !this.h.isRecycled()) {
            this.h.recycle();
            this.h = null;
        }
        if (this.i != null && !this.i.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        if (this.j != null && !this.j.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
        if (this.k == null || this.k.isRecycled()) {
            return;
        }
        this.k.recycle();
        this.k = null;
    }

    public void b(View.OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    public void b(boolean z) {
        this.b.setEnabled(z);
        if (z) {
            this.b.setImageBitmap(this.f);
        } else {
            this.b.setImageBitmap(this.g);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof ImageView) {
            switch (((ImageView) view).getId()) {
                case 0:
                    if (motionEvent.getAction() == 0) {
                        if (this.m) {
                            this.f2219a.setImageBitmap(this.i);
                            return false;
                        }
                        a(this.f2219a, "main_topbtn_down.9.png");
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            this.f2219a.setImageBitmap(this.h);
                            return false;
                        }
                        a(this.f2219a, "main_topbtn_up.9.png");
                        return false;
                    } else {
                        return false;
                    }
                case 1:
                    if (motionEvent.getAction() == 0) {
                        if (this.m) {
                            this.b.setImageBitmap(this.k);
                            return false;
                        }
                        a(this.b, "main_bottombtn_down.9.png");
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        if (this.m) {
                            this.b.setImageBitmap(this.j);
                            return false;
                        }
                        a(this.b, "main_bottombtn_up.9.png");
                        return false;
                    } else {
                        return false;
                    }
                default:
                    return false;
            }
        }
        return false;
    }
}
