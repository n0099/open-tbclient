package com.baidu.live.videochat.f;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.m;
import java.util.Locale;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private HeadImageView bSA;
    private TextView bSB;
    private TextView bSC;
    private FrameLayout bSD;
    private ImageView bSE;
    private View bSF;
    private CountDownTimer bSG;
    private a bSH;
    private FrameLayout bSI;
    private InterfaceC0233b bSw;
    private LinearLayout bSz;
    private View rootView;

    /* loaded from: classes11.dex */
    public interface a {
        void Ya();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0233b {
        void Yb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0233b interfaceC0233b) {
        if (activity != null) {
            this.bSH = aVar;
            this.bSw = interfaceC0233b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bSz = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bSA = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bSC = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bSB = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bSD = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bSE = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bSF = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bSI = (FrameLayout) this.rootView.findViewById(a.f.frame_follow);
            this.bSA.setIsRound(true);
            this.bSA.setAutoChangeStyle(false);
            this.bSA.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bSF.setOnClickListener(this);
            this.bSD.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bSF) {
            if (this.bSH != null) {
                this.bSH.Ya();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkclose_clk").setContentExt(null, "popup", null));
                return;
            }
            return;
        }
        if (view == this.bSD) {
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void a(x xVar, c cVar) {
        long j;
        long j2;
        if (cVar != null) {
            this.rootView.setVisibility(0);
            this.bSD.removeAllViews();
            this.bSD.setVisibility(8);
            this.bSz.setVisibility(0);
            this.bSC.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bSA.setUrl(cVar.getAvatar());
                m.a(this.bSA, cVar.getAvatar(), false, false);
            }
            if (this.bSG != null) {
                this.bSG.cancel();
            }
            if (cVar.Zq()) {
                j = (xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.videoBBChatData == null) ? 0L : xVar.mLiveInfo.videoBBChatData.invitePendantTime;
                if (j <= 0) {
                    j2 = 20;
                }
                j2 = j;
            } else {
                j = (xVar == null || xVar.mLiveInfo == null || xVar.mLiveInfo.videoBBChatData == null) ? 0L : xVar.mLiveInfo.videoBBChatData.acceptPendantTime;
                if (j <= 0) {
                    j2 = 10;
                }
                j2 = j;
            }
            this.bSB.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bSB.setVisibility(0);
            this.bSG = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bSB.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bSB.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bSw != null) {
                        b.this.bSw.Yb();
                    }
                    b.this.release();
                }
            };
            this.bSG.start();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_TAB_SHOW).setContentExt(null, "popup", null));
        }
    }

    public void ag(View view) {
        if (view != null) {
            release();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(a.d.sdk_ds18);
            if (Build.VERSION.SDK_INT >= 21) {
                n(view, dimensionPixelSize);
                this.bSE.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bSE.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bSD.removeAllViews();
            this.bSD.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bSz.setVisibility(8);
            this.bSD.setVisibility(0);
        }
    }

    @RequiresApi(api = 21)
    private void n(View view, final float f) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.baidu.live.videochat.f.b.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), f);
            }
        });
        view.setClipToOutline(true);
    }

    public void release() {
        if (this.bSG != null) {
            this.bSG.cancel();
        }
        this.bSD.removeAllViews();
        this.bSD.setVisibility(8);
        this.bSz.setVisibility(8);
        this.rootView.setVisibility(8);
    }

    public FrameLayout Zp() {
        return this.bSI;
    }
}
