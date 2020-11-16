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
    private FrameLayout bue;
    private FrameLayout bug;
    private FrameLayout buh;
    private LinearLayout bui;
    private LinearLayout buj;
    private LinearLayout buk;
    private TextView bul;
    private TextView bum;
    private TextView bun;
    private TextView buo;
    private ImageView bup;
    private ImageView buq;
    private InterfaceC0200a bur;
    private int bus;
    private long but;
    private long buu;
    private boolean buv;
    private boolean buw;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0200a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0200a interfaceC0200a) {
        if (activity != null) {
            this.bur = interfaceC0200a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bue = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bug = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.buh = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bui = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.buj = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.buk = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bul = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bum = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bun = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.buo = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bup = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.buq = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bul.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bur != null) {
                        a.this.bur.a(view, 1, a.this.but);
                    }
                }
            });
            this.bum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bur != null) {
                        a.this.bur.a(view, 2, a.this.buu);
                    }
                }
            });
            this.bup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bur != null) {
                        a.this.buv = !a.this.buv;
                        a.this.bup.setImageResource(a.this.buv ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bur.b(view, a.this.buv);
                    }
                }
            });
            this.buq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bur != null) {
                        a.this.buw = !a.this.buw;
                        a.this.buq.setImageResource(a.this.buw ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bur.b(view, a.this.buw);
                    }
                }
            });
            t(activity);
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
            this.but = j;
            this.bul.setVisibility(z ? 0 : 8);
            this.bun.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.buu = j;
            this.bum.setVisibility(z ? 0 : 8);
            this.buo.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        QC();
        QD();
        QE();
    }

    private void t(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bui.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bui.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bui.setLayoutParams(layoutParams);
        if (this.bue.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bue.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bus = (int) (realScreenWidth * 0.26f);
        int i = this.bus;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bus) / 2;
        this.bue.setLayoutParams(layoutParams2);
    }

    public void QC() {
        this.but = 0L;
        this.buv = false;
        this.bug.removeAllViews();
        this.bup.setVisibility(8);
        this.bul.setVisibility(8);
        this.bug.setVisibility(8);
        this.buj.setVisibility(0);
        this.bun.setText(a.h.live_chat_waiting_user);
        this.bup.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void QD() {
        this.buu = 0L;
        this.buw = false;
        this.buh.removeAllViews();
        this.buq.setVisibility(8);
        this.bum.setVisibility(8);
        this.buh.setVisibility(8);
        this.buk.setVisibility(0);
        this.buo.setText(a.h.live_chat_waiting_user);
        this.buq.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void QE() {
        this.bue.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bug, view);
        this.buj.setVisibility(8);
        this.bug.setVisibility(0);
        this.bul.setVisibility(z ? 0 : 8);
        this.bup.setVisibility(z2 ? 0 : 8);
        this.but = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.buh, view);
        this.buk.setVisibility(8);
        this.buh.setVisibility(0);
        this.bum.setVisibility(z ? 0 : 8);
        this.buq.setVisibility(z2 ? 0 : 8);
        this.buu = j;
    }

    public void aa(View view) {
        int i = this.bus / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bue, view);
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
