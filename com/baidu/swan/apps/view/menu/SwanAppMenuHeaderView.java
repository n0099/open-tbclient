package com.baidu.swan.apps.view.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import d.a.h0.a.g;
import d.a.h0.a.h;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.s;
import d.a.h0.a.y0.e.b;
/* loaded from: classes3.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {

    /* renamed from: e  reason: collision with root package name */
    public TextView f12247e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAppRoundedImageView f12248f;

    /* renamed from: g  reason: collision with root package name */
    public View f12249g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12250h;

    /* renamed from: i  reason: collision with root package name */
    public e f12251i;
    public f j;
    public e k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public Runnable q;

    /* loaded from: classes3.dex */
    public class a implements s.b {
        public a() {
        }

        @Override // d.a.h0.a.i2.s.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap == null || SwanAppMenuHeaderView.this.f12248f == null) {
                return;
            }
            SwanAppMenuHeaderView.this.f12248f.setImageBitmap(bitmap);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppMenuHeaderView.this.f12251i != null) {
                SwanAppMenuHeaderView.this.f12251i.onClick(view);
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
            if (SwanAppMenuHeaderView.this.k != null) {
                SwanAppMenuHeaderView.this.k.onClick(view);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppMenuHeaderView.this.j == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = SwanAppMenuHeaderView.this;
            swanAppMenuHeaderView.n = swanAppMenuHeaderView.j.onLongClick(SwanAppMenuHeaderView.this.f12249g);
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
        this.f12249g = view.findViewById(d.a.h0.a.f.header_content);
        this.f12248f = (SwanAppRoundedImageView) view.findViewById(d.a.h0.a.f.swan_app_icon);
        this.f12247e = (TextView) view.findViewById(d.a.h0.a.f.swan_app_title);
        this.f12250h = (TextView) view.findViewById(d.a.h0.a.f.btn_item_attenion);
        b.a J = d.a.h0.a.r1.d.e().p().J();
        this.f12248f.setImageBitmap(k0.l(J.P(), "SwanAppMenuHeaderView", false, new a()));
        this.f12247e.setText(J.J());
        this.f12249g.setOnTouchListener(this);
        this.f12249g.setOnClickListener(new b());
        this.f12250h.setOnClickListener(new c());
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && (Math.abs(this.o - x) > 10.0f || Math.abs(this.p - y) > 10.0f)) {
                return true;
            }
        } else {
            this.o = (int) x;
            this.p = (int) y;
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
                removeCallbacks(this.q);
                if (!this.n && (eVar = this.f12251i) != null) {
                    eVar.onClick(this.f12249g);
                }
                this.n = false;
                view.setPressed(false);
                return false;
            } else if (action != 2) {
                if (action == 3) {
                    removeCallbacks(this.q);
                    this.n = false;
                    view.setPressed(false);
                }
            } else if (Math.abs(this.l - x) > 10 || Math.abs(this.m - y) > 10) {
                removeCallbacks(this.q);
                this.n = false;
            }
        } else if (this.j == null) {
            return super.onTouchEvent(motionEvent);
        } else {
            removeCallbacks(this.q);
            this.n = false;
            this.l = x;
            this.m = y;
            postDelayed(this.q, 3000L);
            view.setPressed(true);
        }
        return true;
    }

    public void setAttentionBtnShow(boolean z) {
        this.f12250h.setVisibility(z ? 0 : 8);
    }

    public void setAttentionBtnStates(boolean z) {
        if (!z) {
            this.f12250h.setText(h.aiapps_favorite_guide_add);
            this.f12250h.setBackground(d.a.h0.m.a.b.a.d(getContext(), d.a.h0.a.e.swanapp_attention_btn_bg));
            this.f12250h.setTextColor(d.a.h0.m.a.b.a.c(getContext(), d.a.h0.a.c.swanapp_attention_btn_text_color));
            return;
        }
        this.f12250h.setText(h.swanapp_favored);
        this.f12250h.setBackground(d.a.h0.m.a.b.a.d(getContext(), d.a.h0.a.e.swanapp_cancel_attention_btn_bg));
        this.f12250h.setTextColor(d.a.h0.m.a.b.a.c(getContext(), d.a.h0.a.c.swanapp_cancel_attention_btn_text_color));
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        this.k = eVar;
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        this.f12251i = eVar;
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        this.j = fVar;
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.n = false;
        this.q = new d();
        g(FrameLayout.inflate(context, g.swan_app_menu_header_view, this));
        setAttentionBtnStates(d.a.h0.a.g0.c.a.n(d.a.h0.a.r1.d.e().getAppId()));
    }
}
