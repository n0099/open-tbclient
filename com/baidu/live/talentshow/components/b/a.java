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
    private FrameLayout bCW;
    private FrameLayout bCX;
    private FrameLayout bCY;
    private LinearLayout bCZ;
    private LinearLayout bDa;
    private LinearLayout bDb;
    private TextView bDc;
    private TextView bDd;
    private TextView bDe;
    private TextView bDf;
    private ImageView bDg;
    private ImageView bDh;
    private InterfaceC0201a bDi;
    private int bDj;
    private long bDk;
    private long bDl;
    private boolean bDm;
    private boolean bDn;
    private ViewGroup rootView;

    /* renamed from: com.baidu.live.talentshow.components.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0201a {
        void a(View view, int i, long j);

        void b(View view, boolean z);
    }

    public a(Activity activity, InterfaceC0201a interfaceC0201a) {
        if (activity != null) {
            this.bDi = interfaceC0201a;
            this.rootView = (ViewGroup) LayoutInflater.from(activity).inflate(a.g.layout_live_talent_show_player, (ViewGroup) null);
            this.bCW = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_master);
            this.bCX = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_left_layout);
            this.bCY = (FrameLayout) this.rootView.findViewById(a.f.live_talent_show_player_right_layout);
            this.bCZ = (LinearLayout) this.rootView.findViewById(a.f.layout_talent_player_layout);
            this.bDa = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_left_layout);
            this.bDb = (LinearLayout) this.rootView.findViewById(a.f.live_talent_show_def_right_layout);
            this.bDc = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_left);
            this.bDd = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_right);
            this.bDe = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_left);
            this.bDf = (TextView) this.rootView.findViewById(a.f.live_talent_show_hangup_hint_right);
            this.bDg = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_left);
            this.bDh = (ImageView) this.rootView.findViewById(a.f.live_talent_show_chat_mute_right);
            this.bDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDi != null) {
                        a.this.bDi.a(view, 1, a.this.bDk);
                    }
                }
            });
            this.bDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDi != null) {
                        a.this.bDi.a(view, 2, a.this.bDl);
                    }
                }
            });
            this.bDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDi != null) {
                        a.this.bDm = !a.this.bDm;
                        a.this.bDg.setImageResource(a.this.bDm ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bDi.b(view, a.this.bDm);
                    }
                }
            });
            this.bDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.b.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.bDi != null) {
                        a.this.bDn = !a.this.bDn;
                        a.this.bDh.setImageResource(a.this.bDn ? a.e.live_show_video_chat_mute : a.e.live_show_video_chat_voice);
                        a.this.bDi.b(view, a.this.bDn);
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
            this.bDk = j;
            this.bDc.setVisibility(z ? 0 : 8);
            this.bDe.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        } else if (i == 2) {
            this.bDl = j;
            this.bDd.setVisibility(z ? 0 : 8);
            this.bDf.setText(z2 ? a.h.live_chat_connecting : a.h.live_chat_waiting_user);
        }
    }

    public void release() {
        if (this.rootView.getParent() != null) {
            ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        }
        RU();
        RV();
        RW();
    }

    private void s(Activity activity) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int realScreenWidth = ScreenHelper.getRealScreenWidth(activity);
        if (this.bCZ.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) this.bCZ.getLayoutParams();
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.height = (int) ((realScreenWidth / 6.0f) * 4.0f);
        layoutParams.topMargin = (int) (UtilHelper.getStatusBarHeight() + activity.getResources().getDimension(a.d.sdk_ds264));
        this.bCZ.setLayoutParams(layoutParams);
        if (this.bCW.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) this.bCW.getLayoutParams();
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        this.bDj = (int) (realScreenWidth * 0.26f);
        int i = this.bDj;
        layoutParams2.height = i;
        layoutParams2.width = i;
        layoutParams2.topMargin = (-this.bDj) / 2;
        this.bCW.setLayoutParams(layoutParams2);
    }

    public void RU() {
        this.bDk = 0L;
        this.bDm = false;
        this.bCX.removeAllViews();
        this.bDg.setVisibility(8);
        this.bDc.setVisibility(8);
        this.bCX.setVisibility(8);
        this.bDa.setVisibility(0);
        this.bDe.setText(a.h.live_chat_waiting_user);
        this.bDg.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void RV() {
        this.bDl = 0L;
        this.bDn = false;
        this.bCY.removeAllViews();
        this.bDh.setVisibility(8);
        this.bDd.setVisibility(8);
        this.bCY.setVisibility(8);
        this.bDb.setVisibility(0);
        this.bDf.setText(a.h.live_chat_waiting_user);
        this.bDh.setImageResource(a.e.live_show_video_chat_voice);
    }

    public void RW() {
        this.bCW.removeAllViews();
    }

    public void a(View view, boolean z, long j, boolean z2) {
        a(this.bCX, view);
        this.bDa.setVisibility(8);
        this.bCX.setVisibility(0);
        this.bDc.setVisibility(z ? 0 : 8);
        this.bDg.setVisibility(z2 ? 0 : 8);
        this.bDk = j;
    }

    public void b(View view, boolean z, long j, boolean z2) {
        a(this.bCY, view);
        this.bDb.setVisibility(8);
        this.bCY.setVisibility(0);
        this.bDd.setVisibility(z ? 0 : 8);
        this.bDh.setVisibility(z2 ? 0 : 8);
        this.bDl = j;
    }

    public void aa(View view) {
        int i = this.bDj / 2;
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, i);
        }
        a(this.bCW, view);
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
