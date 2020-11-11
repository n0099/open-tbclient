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
/* loaded from: classes4.dex */
public class a {
    private FrameLayout bvQ;
    private FrameLayout bvR;
    private FrameLayout bvS;
    private LinearLayout bvT;
    private LinearLayout bvU;
    private LinearLayout bvV;
    private TextView bvW;
    private TextView bvX;
    private TextView bvY;
    private TextView bvZ;
    private ImageView bwa;
    private ImageView bwb;
    private InterfaceC0202a bwc;
    private int bwd;
    private long bwe;
    private long bwf;
    private boolean bwg;
    private boolean bwh;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0202a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0202a interfaceC0202a) {
        if (activity != null) {
            this.bwc = interfaceC0202a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bvQ = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bvR = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.bvS = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bvT = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.bvU = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.bvV = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bvW = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bvX = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bvY = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.bvZ = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bwa = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.bwb = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bvW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bwc != null) {
                        a.this.bwc.a(view, 1, a.this.bwe);
                    }
                }
            });
            this.bvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bwc != null) {
                        a.this.bwc.a(view, 2, a.this.bwf);
                    }
                }
            });
            this.bwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bwc != null) {
                        a.this.bwg = !a.this.bwg;
                        a.this.bwa.setImageResource(a.this.bwg ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bwc.b(view, a.this.bwg);
                    }
                }
            });
            this.bwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bwc != null) {
                        a.this.bwh = !a.this.bwh;
                        a.this.bwb.setImageResource(a.this.bwh ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bwc.b(view, a.this.bwh);
                    }
                }
            });
            u(activity);
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
            this.bwe = j;
            this.bvW.setVisibility(z ? 0 : 8);
            this.bvY.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.bwf = j;
            this.bvX.setVisibility(z ? 0 : 8);
            this.bvZ.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        Rl();
        Rm();
        Rn();
    }

    private void u(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bvT.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bvT.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bvT.setLayoutParams(layoutParams);
        if (this.bvQ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bvQ.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bwd = (int) (realScreenWidth * 0.26f);
        int i = this.bwd;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bwd) / 2;
        this.bvQ.setLayoutParams(layoutParams2);
    }

    public void Rl() {
        this.bwe = 0L;
        this.bwg = false;
        this.bvR.removeAllViews();
        this.bwa.setVisibility(8);
        this.bvW.setVisibility(8);
        this.bvR.setVisibility(8);
        this.bvU.setVisibility(0);
        this.bvY.setText(a.h.live_chat_waiting_user);
        this.bwa.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Rm() {
        this.bwf = 0L;
        this.bwh = false;
        this.bvS.removeAllViews();
        this.bwb.setVisibility(8);
        this.bvX.setVisibility(8);
        this.bvS.setVisibility(8);
        this.bvV.setVisibility(0);
        this.bvZ.setText(a.h.live_chat_waiting_user);
        this.bwb.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Rn() {
        this.bvQ.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bvR, view);
        this.bvU.setVisibility(8);
        this.bvR.setVisibility(0);
        this.bvW.setVisibility(z ? 0 : 8);
        this.bwa.setVisibility(z2 ? 0 : 8);
        this.bwe = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.bvS, view);
        this.bvV.setVisibility(8);
        this.bvS.setVisibility(0);
        this.bvX.setVisibility(z ? 0 : 8);
        this.bwb.setVisibility(z2 ? 0 : 8);
        this.bwf = j;
    }

    public void aa(View view) {
        int i = this.bwd / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bvQ, view);
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
