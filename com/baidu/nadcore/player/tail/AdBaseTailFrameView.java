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
import com.baidu.tieba.ak0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.n41;
import com.baidu.tieba.o41;
import com.baidu.tieba.os0;
import com.baidu.tieba.tm0;
import com.baidu.tieba.v41;
import com.baidu.tieba.xr0;
/* loaded from: classes3.dex */
public abstract class AdBaseTailFrameView extends FrameLayout {
    public AdImageView a;
    public AdImageView b;
    public TextView c;
    public TextView d;
    public AdProgressButton e;
    public FrameLayout f;
    public tm0 g;
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

    public abstract int f();

    public void g() {
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
        public final /* synthetic */ os0 b;

        public b(boolean z, os0 os0Var) {
            this.a = z;
            this.b = os0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Object tag = AdBaseTailFrameView.this.getTag();
            if (!(tag instanceof os0)) {
                return;
            }
            os0 os0Var = (os0) tag;
            if (this.a) {
                if (os0Var.u) {
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

    public final void b(os0 os0Var) {
        if (os0Var == null) {
            return;
        }
        e eVar = this.i;
        if (eVar == null) {
            o41.b(os0Var.p);
        } else {
            eVar.a();
        }
    }

    public final void h(os0 os0Var) {
        if (os0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).u(ClogBuilder.Page.AD_TAIL).p(os0Var.q);
            n41.e(clogBuilder);
            return;
        }
        dVar.a(ClogBuilder.LogType.FREE_SHOW.type, "");
    }

    public final void j(View view2) {
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
        e(context);
    }

    public final void i(String str, String str2, os0 os0Var) {
        if (os0Var == null) {
            return;
        }
        d dVar = this.h;
        if (dVar == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(str).u(ClogBuilder.Page.AD_TAIL).j(str2).p(os0Var.q);
            n41.e(clogBuilder);
            return;
        }
        dVar.a(str, str2);
    }

    public final void c(os0 os0Var, View view2) {
        String str;
        if (TextUtils.isEmpty(os0Var.e)) {
            return;
        }
        String str2 = os0Var.e;
        if (R.id.ad_video_tail_frame_check_btn_txt == view2.getId() && !TextUtils.isEmpty(os0Var.f) && !"__BTN_SCHEME__".equals(os0Var.f)) {
            str2 = os0Var.f;
        }
        ak0.c(str2, getContext());
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
        i(ClogBuilder.LogType.CLICK.type, str, os0Var);
        b(os0Var);
        j(view2);
        c cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void d() {
        setVisibility(8);
    }

    public void e(Context context) {
        LayoutInflater.from(context).inflate(f(), this);
        this.a = (AdImageView) findViewById(R.id.ad_video_tail_frame_video_cover);
        this.b = (AdImageView) findViewById(R.id.ad_video_tail_frame_avatar);
        this.c = (TextView) findViewById(R.id.ad_video_tail_frame_name);
        TextView textView = (TextView) findViewById(R.id.ad_video_tail_frame_check_btn_txt);
        this.d = textView;
        v41.b(textView, Font.F_F_X02);
        this.e = (AdProgressButton) findViewById(R.id.ad_video_tail_frame_download_btn_txt);
        this.f = (FrameLayout) findViewById(R.id.ad_video_tail_frame_btn_container);
        this.k = (TextView) findViewById(R.id.video_ad_suffix_close_divider);
        g();
    }

    public boolean k(os0 os0Var) {
        if (os0Var != null && os0Var.i()) {
            setVisibility(0);
            if (!TextUtils.isEmpty(os0Var.o)) {
                this.a.setImageURI(Uri.parse(os0Var.o));
            }
            if (!TextUtils.isEmpty(os0Var.d)) {
                this.b.setVisibility(0);
                this.b.o(os0Var.d);
            } else {
                this.b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(os0Var.c)) {
                this.c.setVisibility(0);
                ((UnifyTextView) this.c).setTextWithUnifiedPadding(os0Var.c, TextView.BufferType.NORMAL);
            } else {
                this.c.setVisibility(8);
            }
            boolean h = os0Var.h();
            if (h) {
                this.d.setVisibility(8);
                xr0 xr0Var = os0Var.r;
                if (xr0Var != null && xr0Var.e) {
                    this.e.setVisibility(0);
                    if (!TextUtils.isEmpty(os0Var.g)) {
                        this.e.setText(os0Var.g);
                    } else {
                        this.e.setText(getResources().getString(R.string.nad_button_download));
                    }
                    gm0 d2 = gm0.d(os0Var.r, os0Var.q, os0Var.f);
                    d2.e = TextUtils.isEmpty(d2.d);
                    this.g = new tm0(d2, this.e);
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
                if (!TextUtils.isEmpty(os0Var.g)) {
                    this.d.setText(os0Var.g);
                } else {
                    this.d.setText(getResources().getText(R.string.nad_ad_video_check_btn_txt));
                }
            }
            b bVar = new b(h, os0Var);
            this.b.setOnClickListener(bVar);
            this.c.setOnClickListener(bVar);
            this.d.setOnClickListener(bVar);
            if (os0Var.t) {
                setOnClickListener(bVar);
            } else {
                setOnClickListener(null);
            }
            h(os0Var);
            setTag(os0Var);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
