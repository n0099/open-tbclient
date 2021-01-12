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
/* loaded from: classes10.dex */
public class a {
    private ImageView bzA;
    private ImageView bzB;
    private InterfaceC0199a bzC;
    private int bzD;
    private long bzE;
    private long bzF;
    private boolean bzG;
    private boolean bzH;
    private FrameLayout bzq;
    private FrameLayout bzr;
    private FrameLayout bzs;
    private LinearLayout bzt;
    private LinearLayout bzu;
    private LinearLayout bzv;
    private TextView bzw;
    private TextView bzx;
    private TextView bzy;
    private TextView bzz;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0199a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0199a interfaceC0199a) {
        if (activity != null) {
            this.bzC = interfaceC0199a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bzq = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bzr = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.bzs = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bzt = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.bzu = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.bzv = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bzw = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bzx = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bzy = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.bzz = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bzA = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.bzB = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bzC != null) {
                        a.this.bzC.a(view, 1, a.this.bzE);
                    }
                }
            });
            this.bzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bzC != null) {
                        a.this.bzC.a(view, 2, a.this.bzF);
                    }
                }
            });
            this.bzA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bzC != null) {
                        a.this.bzG = !a.this.bzG;
                        a.this.bzA.setImageResource(a.this.bzG ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bzC.b(view, a.this.bzG);
                    }
                }
            });
            this.bzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bzC != null) {
                        a.this.bzH = !a.this.bzH;
                        a.this.bzB.setImageResource(a.this.bzH ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bzC.b(view, a.this.bzH);
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
            this.bzE = j;
            this.bzw.setVisibility(z ? 0 : 8);
            this.bzy.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.bzF = j;
            this.bzx.setVisibility(z ? 0 : 8);
            this.bzz.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        Qk();
        Ql();
        Qm();
    }

    private void s(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bzt.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bzt.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bzt.setLayoutParams(layoutParams);
        if (this.bzq.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bzq.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bzD = (int) (realScreenWidth * 0.26f);
        int i = this.bzD;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bzD) / 2;
        this.bzq.setLayoutParams(layoutParams2);
    }

    public void Qk() {
        this.bzE = 0L;
        this.bzG = false;
        this.bzr.removeAllViews();
        this.bzA.setVisibility(8);
        this.bzw.setVisibility(8);
        this.bzr.setVisibility(8);
        this.bzu.setVisibility(0);
        this.bzy.setText(a.h.live_chat_waiting_user);
        this.bzA.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Ql() {
        this.bzF = 0L;
        this.bzH = false;
        this.bzs.removeAllViews();
        this.bzB.setVisibility(8);
        this.bzx.setVisibility(8);
        this.bzs.setVisibility(8);
        this.bzv.setVisibility(0);
        this.bzz.setText(a.h.live_chat_waiting_user);
        this.bzB.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void Qm() {
        this.bzq.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bzr, view);
        this.bzu.setVisibility(8);
        this.bzr.setVisibility(0);
        this.bzw.setVisibility(z ? 0 : 8);
        this.bzA.setVisibility(z2 ? 0 : 8);
        this.bzE = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.bzs, view);
        this.bzv.setVisibility(8);
        this.bzs.setVisibility(0);
        this.bzx.setVisibility(z ? 0 : 8);
        this.bzB.setVisibility(z2 ? 0 : 8);
        this.bzF = j;
    }

    public void aa(View view) {
        int i = this.bzD / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bzq, view);
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
