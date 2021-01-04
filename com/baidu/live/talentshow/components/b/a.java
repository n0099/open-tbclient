package com.baidu.live.talentshow.components.b;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.util.ScreenHelper;
/* loaded from: classes11.dex */
public class a {
    private FrameLayout bEc;
    private FrameLayout bEd;
    private FrameLayout bEe;
    private LinearLayout bEf;
    private LinearLayout bEg;
    private LinearLayout bEh;
    private TextView bEi;
    private TextView bEj;
    private TextView bEk;
    private TextView bEl;
    private ImageView bEm;
    private ImageView bEn;
    private InterfaceC0208a bEo;
    private int bEp;
    private long bEq;
    private long bEr;
    private boolean bEs;
    private boolean bEt;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0208a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0208a interfaceC0208a) {
        if (activity != null) {
            this.bEo = interfaceC0208a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bEc = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bEd = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.bEe = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bEf = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.bEg = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.bEh = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bEi = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bEj = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bEk = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.bEl = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bEm = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.bEn = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEo != null) {
                        a.this.bEo.a(view, 1, a.this.bEq);
                    }
                }
            });
            this.bEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEo != null) {
                        a.this.bEo.a(view, 2, a.this.bEr);
                    }
                }
            });
            this.bEm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEo != null) {
                        a.this.bEs = !a.this.bEs;
                        a.this.bEm.setImageResource(a.this.bEs ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bEo.b(view, a.this.bEs);
                    }
                }
            });
            this.bEn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEo != null) {
                        a.this.bEt = !a.this.bEt;
                        a.this.bEn.setImageResource(a.this.bEt ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bEo.b(view, a.this.bEt);
                    }
                }
            });
            s(activity);
        }
    }

    public void c(FrameLayout frameLayout) {
        if (frameLayout != null) {
            if (this.rootView.getParent() == null || this.rootView.getParent() != frameLayout) {
                if (this.rootView.getParent() != null) {
                    ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
                }
                frameLayout.addView(this.rootView, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public void a(int i, long j, boolean z, boolean z2) {
        if (i == 1) {
            this.bEq = j;
            this.bEi.setVisibility(z ? 0 : 8);
            this.bEk.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.bEr = j;
            this.bEj.setVisibility(z ? 0 : 8);
            this.bEl.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        Uf();
        Ug();
        Uh();
    }

    private void s(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bEf.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bEf.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bEf.setLayoutParams(layoutParams);
        if (this.bEc.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bEc.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bEp = (int) (realScreenWidth * 0.26f);
        int i = this.bEp;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bEp) / 2;
        this.bEc.setLayoutParams(layoutParams2);
    }

    public void Uf() {
        this.bEq = 0L;
        this.bEs = false;
        this.bEd.removeAllViews();
        this.bEm.setVisibility(8);
        this.bEi.setVisibility(8);
        this.bEd.setVisibility(8);
        this.bEg.setVisibility(0);
        this.bEk.setText(a.h.live_chat_waiting_user);
        this.bEm.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Ug() {
        this.bEr = 0L;
        this.bEt = false;
        this.bEe.removeAllViews();
        this.bEn.setVisibility(8);
        this.bEj.setVisibility(8);
        this.bEe.setVisibility(8);
        this.bEh.setVisibility(0);
        this.bEl.setText(a.h.live_chat_waiting_user);
        this.bEn.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Uh() {
        this.bEc.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bEd, view);
        this.bEg.setVisibility(8);
        this.bEd.setVisibility(0);
        this.bEi.setVisibility(z ? 0 : 8);
        this.bEm.setVisibility(z2 ? 0 : 8);
        this.bEq = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.bEe, view);
        this.bEh.setVisibility(8);
        this.bEe.setVisibility(0);
        this.bEj.setVisibility(z ? 0 : 8);
        this.bEn.setVisibility(z2 ? 0 : 8);
        this.bEr = j;
    }

    public void aa(View view) {
        int i = this.bEp / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bEc, view);
    }

    private void a(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null && viewGroup.indexOfChild(view) == -1) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void n(View view, final float f) {
        if (view != null && Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.baidu.live.talentshow.components.b.a.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    Rect rect = new Rect();
                    view2.getGlobalVisibleRect(rect);
                    outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), f);
                }
            });
            view.setClipToOutline(true);
        }
    }
}
