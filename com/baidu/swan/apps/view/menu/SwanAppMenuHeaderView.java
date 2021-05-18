package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.g;
import d.a.i0.a.h;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.t;
/* loaded from: classes3.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f11482e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppRoundedImageView f11483f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f11484g;

    /* renamed from: h  reason: collision with root package name */
    public View f11485h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f11486i;
    public e j;
    public f k;
    public e l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public Runnable r;

    /* loaded from: classes3.dex */
    public class a implements t.b {
        public a() {
        }

        @Override // d.a.i0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null || SwanAppMenuHeaderView.this.f11483f == null) {
                return;
            }
            SwanAppMenuHeaderView.this.f11483f.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppMenuHeaderView.this.j != null) {
                SwanAppMenuHeaderView.this.j.onClick(view);
                view.setPressed(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppMenuHeaderView.this.l != null) {
                SwanAppMenuHeaderView.this.l.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppMenuHeaderView.this.k == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = SwanAppMenuHeaderView.this;
            swanAppMenuHeaderView.o = swanAppMenuHeaderView.k.onLongClick(SwanAppMenuHeaderView.this.f11485h);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onClick(View view);
    }

    /* loaded from: classes3.dex */
    public interface f {
        boolean onLongClick(View view);
    }

    public SwanAppMenuHeaderView(Context context) {
        this(context, null);
    }

    public final void g(View view) {
        this.f11485h = view.findViewById(d.a.i0.a.f.header_content);
        this.f11483f = (SwanAppRoundedImageView) view.findViewById(d.a.i0.a.f.swan_app_icon);
        this.f11482e = (TextView) view.findViewById(d.a.i0.a.f.swan_app_title);
        this.f11486i = (TextView) view.findViewById(d.a.i0.a.f.btn_item_attenion);
        this.f11484g = (ImageView) view.findViewById(d.a.i0.a.f.apply_guarantee);
        b.a L = d.a.i0.a.a2.d.g().r().L();
        this.f11483f.setImageBitmap(q0.k(L.Q(), "SwanAppMenuHeaderView", false, new a()));
        this.f11482e.setText(L.K());
        this.f11482e.setMaxWidth(getResources().getDimensionPixelSize(d.a.i0.a.d.swan_menu_title_max_width_no_icon));
        if (q0.O()) {
            this.f11484g.setVisibility(0);
            this.f11482e.setMaxWidth(getResources().getDimensionPixelSize(d.a.i0.a.d.swan_menu_title_max_width_with_icon));
        }
        this.f11485h.setOnTouchListener(this);
        this.f11485h.setOnClickListener(new b());
        this.f11486i.setOnClickListener(new c());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && (Math.abs(this.p - x) > 10.0f || Math.abs(this.q - y) > 10.0f)) {
                return true;
            }
        } else {
            this.p = (int) x;
            this.q = (int) y;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        e eVar;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                removeCallbacks(this.r);
                if (!this.o && (eVar = this.j) != null) {
                    eVar.onClick(this.f11485h);
                }
                this.o = false;
                view.setPressed(false);
                return false;
            } else if (action != 2) {
                if (action == 3) {
                    removeCallbacks(this.r);
                    this.o = false;
                    view.setPressed(false);
                }
            } else if (Math.abs(this.m - x) > 10 || Math.abs(this.n - y) > 10) {
                removeCallbacks(this.r);
                this.o = false;
            }
        } else if (this.k == null) {
            return super.onTouchEvent(motionEvent);
        } else {
            removeCallbacks(this.r);
            this.o = false;
            this.m = x;
            this.n = y;
            postDelayed(this.r, 3000L);
            view.setPressed(true);
        }
        return true;
    }

    public void setAttentionBtnShow(boolean z) {
        this.f11486i.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.f11486i.setText(h.aiapps_follow_action_text);
            this.f11486i.setTypeface(Typeface.create("sans-serif-medium", 1));
            this.f11486i.setBackground(d.a.i0.o.a.b.a.d(getContext(), d.a.i0.a.e.swanapp_attention_btn_bg));
            this.f11486i.setTextColor(d.a.i0.o.a.b.a.c(getContext(), d.a.i0.a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.f11486i.setText(h.swanapp_favored);
        this.f11486i.setTypeface(Typeface.create(TypefaceCompatApi28Impl.DEFAULT_FAMILY, 0));
        this.f11486i.setBackground(d.a.i0.o.a.b.a.d(getContext(), d.a.i0.a.e.swanapp_cancel_attention_btn_bg));
        this.f11486i.setTextColor(d.a.i0.o.a.b.a.c(getContext(), d.a.i0.a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        this.l = eVar;
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        this.j = eVar;
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        this.k = fVar;
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.o = false;
        this.r = new d();
        g(FrameLayout.inflate(context, g.swan_app_menu_header_view, this));
        setAttentionBtnStates(d.a.i0.a.j0.b.a.n(d.a.i0.a.a2.d.g().getAppId()));
    }
}
