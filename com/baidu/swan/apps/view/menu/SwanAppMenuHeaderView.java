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
import com.baidu.swan.apps.view.SwanAppRoundedImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bp4;
import com.baidu.tieba.fu2;
import com.baidu.tieba.so3;
import com.baidu.tieba.vn3;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wh2;
import com.baidu.tieba.xa3;
/* loaded from: classes4.dex */
public class SwanAppMenuHeaderView extends FrameLayout implements View.OnTouchListener {
    public TextView a;
    public SwanAppRoundedImageView b;
    public ImageView c;
    public View d;
    public TextView e;
    public e f;
    public f g;
    public e h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public Runnable n;

    /* loaded from: classes4.dex */
    public interface e {
        void onClick(View view2);
    }

    /* loaded from: classes4.dex */
    public interface f {
        boolean onLongClick(View view2);
    }

    /* loaded from: classes4.dex */
    public class a implements vn3.b {
        public a() {
        }

        @Override // com.baidu.tieba.vn3.b
        public void a(String str, Bitmap bitmap) {
            if (bitmap != null && SwanAppMenuHeaderView.this.b != null) {
                SwanAppMenuHeaderView.this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SwanAppMenuHeaderView.this.f != null) {
                SwanAppMenuHeaderView.this.f.onClick(view2);
                view2.setPressed(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (SwanAppMenuHeaderView.this.h != null) {
                SwanAppMenuHeaderView.this.h.onClick(view2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppMenuHeaderView.this.g == null) {
                return;
            }
            SwanAppMenuHeaderView swanAppMenuHeaderView = SwanAppMenuHeaderView.this;
            swanAppMenuHeaderView.k = swanAppMenuHeaderView.g.onLongClick(SwanAppMenuHeaderView.this.d);
        }
    }

    public SwanAppMenuHeaderView(Context context) {
        this(context, null);
    }

    public void setAttentionBtnShow(boolean z) {
        int i;
        TextView textView = this.e;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void setOnAttentionBtnClickListener(e eVar) {
        this.h = eVar;
    }

    public void setOnMenuHeaderClickListener(e eVar) {
        this.f = eVar;
    }

    public void setOnMenuHeaderLongClickListener(f fVar) {
        this.g = fVar;
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwanAppMenuHeaderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        this.k = false;
        this.n = new d();
        g(FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0910, this));
        setAttentionBtnStates(wh2.n(xa3.K().getAppId()));
    }

    public final void g(View view2) {
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090f13);
        this.b = (SwanAppRoundedImageView) view2.findViewById(R.id.obfuscated_res_0x7f0922fb);
        this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922ff);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0904c8);
        this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0902c2);
        vv2.a W = xa3.K().q().W();
        this.b.setImageBitmap(so3.k(W.Q(), "SwanAppMenuHeaderView", false, new a()));
        this.a.setText(W.K());
        this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070818));
        if (so3.P()) {
            this.c.setVisibility(0);
            this.a.setMaxWidth(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070819));
        }
        this.d.setOnTouchListener(this);
        this.d.setOnClickListener(new b());
        this.e.setOnClickListener(new c());
    }

    public void setAttentionBtnStates(boolean z) {
        if (fu2.y0().d()) {
            this.e.setText(R.string.obfuscated_res_0x7f0f018d);
            this.e.setBackground(bp4.d(getContext(), R.drawable.obfuscated_res_0x7f081474));
            this.e.setTextColor(bp4.b(getContext(), R.color.obfuscated_res_0x7f060b0e));
        } else if (!z) {
            this.e.setText(R.string.obfuscated_res_0x7f0f018d);
            this.e.setTypeface(Typeface.create("sans-serif-medium", 1));
            this.e.setBackground(bp4.d(getContext(), R.drawable.obfuscated_res_0x7f081448));
            this.e.setTextColor(bp4.c(getContext(), R.color.obfuscated_res_0x7f060afd));
        } else {
            this.e.setText(R.string.obfuscated_res_0x7f0f1520);
            this.e.setTypeface(Typeface.create("sans-serif", 0));
            this.e.setBackground(bp4.d(getContext(), R.drawable.obfuscated_res_0x7f08144f));
            this.e.setTextColor(bp4.c(getContext(), R.color.obfuscated_res_0x7f060afe));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && (Math.abs(this.l - x) > 10.0f || Math.abs(this.m - y) > 10.0f)) {
                return true;
            }
        } else {
            this.l = (int) x;
            this.m = (int) y;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        e eVar;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        removeCallbacks(this.n);
                        this.k = false;
                        view2.setPressed(false);
                    }
                } else if (Math.abs(this.i - x) > 10 || Math.abs(this.j - y) > 10) {
                    removeCallbacks(this.n);
                    this.k = false;
                }
            } else {
                removeCallbacks(this.n);
                if (!this.k && (eVar = this.f) != null) {
                    eVar.onClick(this.d);
                }
                this.k = false;
                view2.setPressed(false);
                return false;
            }
        } else if (this.g == null) {
            return super.onTouchEvent(motionEvent);
        } else {
            removeCallbacks(this.n);
            this.k = false;
            this.i = x;
            this.j = y;
            postDelayed(this.n, 3000L);
            view2.setPressed(true);
        }
        return true;
    }
}
