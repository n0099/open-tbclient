package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.nadcore.download.view.AdProgressButton;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.styles.Font;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.txt.UnifyTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.bz0;
import com.baidu.tieba.cz0;
import com.baidu.tieba.jh0;
import com.baidu.tieba.jz0;
import com.baidu.tieba.mn0;
import com.baidu.tieba.qe0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.wg0;
/* loaded from: classes3.dex */
public abstract class AdBaseTailFrameView extends FrameLayout {
    public AdImageView a;
    public AdImageView b;
    public TextView c;
    public TextView d;
    public AdProgressButton e;
    public FrameLayout f;
    public jh0 g;
    public d h;
    public e i;
    public View.OnClickListener j;
    public TextView k;
    public c l;

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, String str2);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    public abstract int e();

    public void f() {
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdBaseTailFrameView.this.g.l();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ mn0 b;

        public b(boolean z, mn0 mn0Var) {
            this.a = z;
            this.b = mn0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object tag = AdBaseTailFrameView.this.getTag();
            if (!(tag instanceof mn0)) {
                return;
            }
            mn0 mn0Var = (mn0) tag;
            if (this.a) {
                if (mn0Var.v) {
                    AdBaseTailFrameView.this.e.performClick();
                    return;
                } else {
                    AdBaseTailFrameView.this.c(this.b, view2);
                    return;
                }
            }
            AdBaseTailFrameView.this.c(this.b, view2);
        }
    }

    public AdBaseTailFrameView(Context context) {
        this(context, null);
    }

    public final void b(mn0 mn0Var) {
        if (mn0Var == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            cz0.b(mn0Var.q);
        } else {
            eVar.a();
        }
    }

    public final void g(mn0 mn0Var) {
        if (mn0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.AD_TAIL).p(mn0Var.r);
            bz0.e(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void i(View view2) {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
    }

    public void setAdTailCloseListener(c cVar) {
        this.l = cVar;
    }

    public void setAlsHandler(d dVar) {
        this.h = dVar;
    }

    public void setOnChargeHandler(e eVar) {
        this.i = eVar;
    }

    public void setOnJumpHandler(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }

    public AdBaseTailFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdBaseTailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(context);
    }

    public final void h(String str, String str2, mn0 mn0Var) {
        if (mn0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(str).u(ClogBuilder.Page.AD_TAIL).j(str2).p(mn0Var.r);
            bz0.e(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public final void c(mn0 mn0Var, View view2) {
        String str;
        if (TextUtils.isEmpty(mn0Var.e)) {
            return;
        }
        String str2 = mn0Var.e;
        if (R.id.ad_video_tail_frame_check_btn_txt == view2.getId() && !TextUtils.isEmpty(mn0Var.g) && !"__BTN_SCHEME__".equals(mn0Var.g)) {
            str2 = mn0Var.g;
        }
        qe0.c(str2, getContext());
        int id = view2.getId();
        if (id == R.id.ad_video_tail_frame_avatar) {
            str = ClogBuilder.Area.ICON.type;
        } else if (id == R.id.ad_video_tail_frame_name) {
            str = ClogBuilder.Area.NAME.type;
        } else if (id == R.id.ad_video_tail_frame_check_btn_txt) {
            str = ClogBuilder.Area.BUTTON.type;
        } else {
            str = ClogBuilder.Area.HOTAREA.type;
        }
        h(ClogBuilder.LogType.CLICK.type, str, mn0Var);
        b(mn0Var);
        i(view2);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d(Context context) {
        LayoutInflater.from(context).inflate(e(), this);
        this.a = (AdImageView) findViewById(R.id.ad_video_tail_frame_video_cover);
        this.b = (AdImageView) findViewById(R.id.ad_video_tail_frame_avatar);
        this.c = (TextView) findViewById(R.id.ad_video_tail_frame_name);
        TextView textView = (TextView) findViewById(R.id.ad_video_tail_frame_check_btn_txt);
        this.d = textView;
        jz0.b(textView, Font.F_F_X02);
        this.e = (AdProgressButton) findViewById(R.id.ad_video_tail_frame_download_btn_txt);
        this.f = (FrameLayout) findViewById(R.id.ad_video_tail_frame_btn_container);
        this.k = (TextView) findViewById(R.id.video_ad_suffix_close_divider);
        f();
    }

    public boolean j(mn0 mn0Var) {
        if (mn0Var != null && mn0Var.j()) {
            setVisibility(0);
            if (!TextUtils.isEmpty(mn0Var.p)) {
                this.a.setImageURI(Uri.parse(mn0Var.p));
            }
            if (!TextUtils.isEmpty(mn0Var.d)) {
                this.b.setVisibility(0);
                this.b.u(mn0Var.d);
            } else {
                this.b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(mn0Var.c)) {
                this.c.setVisibility(0);
                ((UnifyTextView) this.c).setTextWithUnifiedPadding(mn0Var.c, TextView.BufferType.NORMAL);
            } else {
                this.c.setVisibility(8);
            }
            boolean i = mn0Var.i();
            if (i) {
                this.d.setVisibility(8);
                tm0 tm0Var = mn0Var.s;
                if (tm0Var != null && tm0Var.e) {
                    this.e.setVisibility(0);
                    if (!TextUtils.isEmpty(mn0Var.h)) {
                        this.e.setText(mn0Var.h);
                    } else {
                        this.e.setText(getResources().getString(R.string.nad_button_download));
                    }
                    wg0 d2 = wg0.d(mn0Var.s, mn0Var.r, mn0Var.g);
                    d2.e = TextUtils.isEmpty(d2.d);
                    this.g = new jh0(d2, this.e);
                    this.e.setOnClickListener(new a());
                } else {
                    this.e.setVisibility(8);
                    this.g = null;
                }
            } else {
                if (this.g != null) {
                    this.g = null;
                }
                this.e.setVisibility(8);
                this.d.setVisibility(0);
                if (!TextUtils.isEmpty(mn0Var.h)) {
                    this.d.setText(mn0Var.h);
                } else {
                    this.d.setText(getResources().getText(R.string.nad_ad_video_check_btn_txt));
                }
            }
            b bVar = new b(i, mn0Var);
            this.b.setOnClickListener(bVar);
            this.c.setOnClickListener(bVar);
            this.d.setOnClickListener(bVar);
            if (mn0Var.u) {
                setOnClickListener(bVar);
            } else {
                setOnClickListener(null);
            }
            g(mn0Var);
            setTag(mn0Var);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
