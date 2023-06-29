package com.baidu.nadcore.player.tail;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.player.tail.AdBaseTailFrameView;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.ds0;
import com.baidu.tieba.g61;
import com.baidu.tieba.ow0;
import com.baidu.tieba.pw0;
import com.baidu.tieba.pz0;
import com.baidu.tieba.r31;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class AdVideoTailFrameView extends AdEmbeddedTailFrameView implements View.OnClickListener {
    public ds0 m;
    public int n;
    public int o;
    public boolean p;
    public Handler q;
    public b r;
    public View s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public pz0 y;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public class a implements AdBaseTailFrameView.d {
        public a() {
        }

        @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView.d
        public void a(String str, String str2) {
            AdVideoTailFrameView.this.u(str, str2, "");
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Handler {
        public WeakReference<AdVideoTailFrameView> a;

        public c(AdVideoTailFrameView adVideoTailFrameView) {
            this.a = new WeakReference<>(adVideoTailFrameView);
        }

        public /* synthetic */ c(AdVideoTailFrameView adVideoTailFrameView, a aVar) {
            this(adVideoTailFrameView);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            AdVideoTailFrameView adVideoTailFrameView = this.a.get();
            if (adVideoTailFrameView == null || message.what != 1 || adVideoTailFrameView.p) {
                return;
            }
            adVideoTailFrameView.o++;
            Message message2 = new Message();
            message2.what = 1;
            if (adVideoTailFrameView.w.getVisibility() == 0) {
                adVideoTailFrameView.w.setText(String.format("%ds", Integer.valueOf(adVideoTailFrameView.n - adVideoTailFrameView.o)));
            }
            sendMessageDelayed(message2, 1000L);
            adVideoTailFrameView.o();
        }
    }

    public AdVideoTailFrameView(Context context, pz0 pz0Var, boolean z) {
        super(context);
        this.n = 5;
        this.o = 0;
        this.y = pz0Var;
        p();
    }

    public void n(boolean z) {
        ds0 ds0Var = this.m;
        if (ds0Var != null && TextUtils.equals(ds0Var.s, "ad_full_video")) {
            z(z);
        }
        r(z);
    }

    public void s(boolean z) {
        g();
    }

    public void setCallBack(b bVar) {
        this.r = bVar;
    }

    public void setData(@NonNull Object obj) {
        if (obj instanceof ds0) {
            this.m = (ds0) obj;
        }
    }

    @Override // com.baidu.nadcore.player.tail.AdBaseTailFrameView
    public void d() {
        t();
        this.o = 0;
        pz0 pz0Var = this.y;
        if (pz0Var != null) {
            pz0Var.P();
            this.y.R(8);
        }
    }

    public final void o() {
        b bVar;
        int i = this.o;
        int i2 = this.n;
        if (i == i2) {
            b bVar2 = this.r;
            if (bVar2 != null) {
                bVar2.b();
            }
            d();
        } else if (i2 - i <= 3 && i2 - i > 0 && (bVar = this.r) != null) {
            bVar.a();
        }
    }

    public boolean q() {
        ds0 ds0Var = this.m;
        if (ds0Var != null && ds0Var.i()) {
            return true;
        }
        return false;
    }

    public void t() {
        this.p = true;
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public void y() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(1);
        } else {
            this.q = new c(this, null);
        }
        this.p = false;
        this.q.sendMessage(this.q.obtainMessage(1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        pz0 pz0Var;
        if (view2.getId() != R.id.video_ad_suffix_timer_close || (pz0Var = this.y) == null) {
            return;
        }
        pz0Var.R(8);
        this.y.P();
        this.y.H(ow0.w("layer_event_ad_finish"));
        if (!this.y.u().a0()) {
            this.y.H(pw0.w(PlayerEvent.ACTION_ON_COMPLETE));
        }
        u(ClogBuilder.LogType.FREE_CLICK.type, ClogBuilder.Area.BUTTON.type, "");
    }

    public void p() {
        s(false);
        setAlsHandler(new a());
        this.x = findViewById(R.id.video_ad_suffix_timer_close);
        this.w = (TextView) findViewById(R.id.video_ad_suffix_timer);
        this.s = findViewById(R.id.video_ad_suffix_timer_close_area);
        this.t = (ImageView) findViewById(R.id.video_ad_suffix_close);
        this.u = (TextView) findViewById(R.id.video_ad_suffix_close_divider);
        this.v = (TextView) findViewById(R.id.video_ad_suffix_close_txt);
        this.s.setBackground(getResources().getDrawable(R.drawable.nad_videoplayer_video_ad_tip_bg));
        this.t.setImageDrawable(getResources().getDrawable(R.drawable.nad_videoplayer_video_ad_icon_close));
        this.x.setOnClickListener(this);
    }

    public void r(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        if (z) {
            layoutParams.width = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_width_half);
            layoutParams.height = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_width_half);
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_margin_bottom_half);
            layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_name_margin_bottom_half);
            layoutParams3.width = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_operate_btn_width_half);
            layoutParams3.height = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_operate_btn_height_half);
            this.c.setTextSize(14.0f);
            this.d.setTextSize(13.0f);
            this.e.setTextSize(g61.c.a(getContext(), 13.0f));
        } else {
            layoutParams.width = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_width_full);
            layoutParams.height = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_width_full);
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_avatar_margin_bottom_full);
            layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_name_margin_bottom_full);
            layoutParams3.width = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_operate_btn_width_full);
            layoutParams3.height = (int) getResources().getDimension(R.dimen.nad_suffix_video_tail_frame_operate_btn_height_full);
            this.c.setTextSize(17.0f);
            this.d.setTextSize(14.0f);
            this.e.setTextSize(14);
        }
        this.b.setLayoutParams(layoutParams);
        this.c.setLayoutParams(layoutParams2);
        this.f.setLayoutParams(layoutParams3);
    }

    public void u(String str, String str2, String str3) {
        if (this.m == null || !NetUtil.a(getContext())) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.z(str);
        clogBuilder.u(ClogBuilder.Page.AD_TAIL);
        if (!TextUtils.isEmpty(str2)) {
            clogBuilder.j(str2);
        }
        clogBuilder.p(this.m.q);
        if (!TextUtils.isEmpty(str3)) {
            clogBuilder.m(str3);
        }
        r31.b(clogBuilder);
    }

    public void x() {
        ds0 ds0Var = this.m;
        if (ds0Var != null) {
            this.n = ds0Var.j;
            k(ds0Var);
            if (this.m.v) {
                y();
            } else {
                t();
            }
            if (TextUtils.equals(this.m.s, "ad_full_video")) {
                this.x.setVisibility(0);
                z(!this.y.u().V0());
            }
        }
    }

    public final void z(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
                layoutParams2.setMargins(getResources().getDimensionPixelSize(R.dimen.nad_dimen_15dp), 0, 0, getResources().getDimensionPixelSize(R.dimen.nad_dimen_10dp));
                this.x.setLayoutParams(layoutParams2);
            }
            this.w.setGravity(8388629);
            this.u.setVisibility(0);
            this.v.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.x.getLayoutParams();
        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
            layoutParams4.gravity = BadgeDrawable.TOP_END;
            layoutParams4.setMargins(0, getResources().getDimensionPixelSize(R.dimen.nad_dimen_10dp), getResources().getDimensionPixelSize(R.dimen.nad_dimen_15dp), 0);
            this.x.setLayoutParams(layoutParams3);
        }
        this.w.setGravity(17);
        this.u.setVisibility(8);
        this.v.setVisibility(8);
        this.t.setVisibility(8);
    }
}
