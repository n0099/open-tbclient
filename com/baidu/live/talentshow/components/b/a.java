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
    private LinearLayout bEA;
    private LinearLayout bEB;
    private TextView bEC;
    private TextView bED;
    private TextView bEE;
    private TextView bEF;
    private ImageView bEG;
    private ImageView bEH;
    private InterfaceC0207a bEI;
    private int bEJ;
    private long bEK;
    private long bEL;
    private boolean bEM;
    private boolean bEN;
    private FrameLayout bEw;
    private FrameLayout bEx;
    private FrameLayout bEy;
    private LinearLayout bEz;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0207a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0207a interfaceC0207a) {
        if (activity != null) {
            this.bEI = interfaceC0207a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bEw = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bEx = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.bEy = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bEz = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.bEA = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.bEB = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bEC = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bED = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bEE = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.bEF = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bEG = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.bEH = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bEC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEI != null) {
                        a.this.bEI.a(view, 1, a.this.bEK);
                    }
                }
            });
            this.bED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEI != null) {
                        a.this.bEI.a(view, 2, a.this.bEL);
                    }
                }
            });
            this.bEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEI != null) {
                        a.this.bEM = !a.this.bEM;
                        a.this.bEG.setImageResource(a.this.bEM ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bEI.b(view, a.this.bEM);
                    }
                }
            });
            this.bEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bEI != null) {
                        a.this.bEN = !a.this.bEN;
                        a.this.bEH.setImageResource(a.this.bEN ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bEI.b(view, a.this.bEN);
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
            this.bEK = j;
            this.bEC.setVisibility(z ? 0 : 8);
            this.bEE.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.bEL = j;
            this.bED.setVisibility(z ? 0 : 8);
            this.bEF.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        RX();
        RY();
        RZ();
    }

    private void s(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bEz.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bEz.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bEz.setLayoutParams(layoutParams);
        if (this.bEw.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bEw.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bEJ = (int) (realScreenWidth * 0.26f);
        int i = this.bEJ;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bEJ) / 2;
        this.bEw.setLayoutParams(layoutParams2);
    }

    public void RX() {
        this.bEK = 0L;
        this.bEM = false;
        this.bEx.removeAllViews();
        this.bEG.setVisibility(8);
        this.bEC.setVisibility(8);
        this.bEx.setVisibility(8);
        this.bEA.setVisibility(0);
        this.bEE.setText(a.h.live_chat_waiting_user);
        this.bEG.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void RY() {
        this.bEL = 0L;
        this.bEN = false;
        this.bEy.removeAllViews();
        this.bEH.setVisibility(8);
        this.bED.setVisibility(8);
        this.bEy.setVisibility(8);
        this.bEB.setVisibility(0);
        this.bEF.setText(a.h.live_chat_waiting_user);
        this.bEH.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void RZ() {
        this.bEw.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bEx, view);
        this.bEA.setVisibility(8);
        this.bEx.setVisibility(0);
        this.bEC.setVisibility(z ? 0 : 8);
        this.bEG.setVisibility(z2 ? 0 : 8);
        this.bEK = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.bEy, view);
        this.bEB.setVisibility(8);
        this.bEy.setVisibility(0);
        this.bED.setVisibility(z ? 0 : 8);
        this.bEH.setVisibility(z2 ? 0 : 8);
        this.bEL = j;
    }

    public void aa(View view) {
        int i = this.bEJ / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bEw, view);
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
