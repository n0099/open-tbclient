package com.baidu.live.videochat.f;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.live.data.ab;
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
    private InterfaceC0226b bRA;
    private LinearLayout bRD;
    private HeadImageView bRE;
    private TextView bRF;
    private TextView bRG;
    private FrameLayout bRH;
    private ImageView bRI;
    private View bRJ;
    private CountDownTimer bRK;
    private a bRL;
    private FrameLayout bRM;
    private View rootView;

    /* loaded from: classes11.dex */
    public interface a {
        void VQ();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0226b {
        void VR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0226b interfaceC0226b) {
        if (activity != null) {
            this.bRL = aVar;
            this.bRA = interfaceC0226b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bRD = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bRE = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bRG = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bRF = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bRH = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bRI = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bRJ = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bRM = (FrameLayout) this.rootView.findViewById(a.f.frame_follow);
            this.bRE.setIsRound(true);
            this.bRE.setAutoChangeStyle(false);
            this.bRE.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bRJ.setOnClickListener(this);
            this.bRH.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bRJ) {
            if (this.bRL != null) {
                this.bRL.VQ();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkclose_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        } else if (view == this.bRH) {
            Log.d("bugbye", "bugbye");
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void a(ab abVar, c cVar) {
        long j;
        long j2;
        if (cVar != null) {
            this.rootView.setVisibility(0);
            this.bRH.removeAllViews();
            this.bRH.setVisibility(8);
            this.bRD.setVisibility(0);
            this.bRG.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bRE.setUrl(cVar.getAvatar());
                m.a(this.bRE, cVar.getAvatar(), false, false);
            }
            if (this.bRK != null) {
                this.bRK.cancel();
            }
            if (cVar.Xg()) {
                j = (abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.videoBBChatData == null) ? 0L : abVar.mLiveInfo.videoBBChatData.invitePendantTime;
                if (j <= 0) {
                    j2 = 20;
                }
                j2 = j;
            } else {
                j = (abVar == null || abVar.mLiveInfo == null || abVar.mLiveInfo.videoBBChatData == null) ? 0L : abVar.mLiveInfo.videoBBChatData.acceptPendantTime;
                if (j <= 0) {
                    j2 = 10;
                }
                j2 = j;
            }
            this.bRF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bRF.setVisibility(0);
            this.bRK = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bRF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bRF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bRA != null) {
                        b.this.bRA.VR();
                    }
                    b.this.release();
                }
            };
            this.bRK.start();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_TAB_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
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
                this.bRI.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bRI.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bRH.removeAllViews();
            this.bRH.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bRD.setVisibility(8);
            this.bRH.setVisibility(0);
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
        if (this.bRK != null) {
            this.bRK.cancel();
        }
        this.bRH.removeAllViews();
        this.bRH.setVisibility(8);
        this.bRD.setVisibility(8);
        this.rootView.setVisibility(8);
    }

    public FrameLayout Xf() {
        return this.bRM;
    }
}
