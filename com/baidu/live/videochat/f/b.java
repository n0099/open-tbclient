package com.baidu.live.videochat.f;

import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.l;
import java.util.Locale;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private InterfaceC0235b bNJ;
    private LinearLayout bNL;
    private HeadImageView bNM;
    private TextView bNN;
    private TextView bNO;
    private FrameLayout bNP;
    private ImageView bNQ;
    private View bNR;
    private CountDownTimer bNS;
    private a bNT;
    private View rootView;

    /* loaded from: classes4.dex */
    public interface a {
        void WT();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0235b {
        void WU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0235b interfaceC0235b) {
        if (activity != null) {
            this.bNT = aVar;
            this.bNJ = interfaceC0235b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bNL = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bNM = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bNO = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bNN = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bNP = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bNQ = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bNR = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bNM.setIsRound(true);
            this.bNM.setAutoChangeStyle(false);
            this.bNM.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bNR.setOnClickListener(this);
            this.bNP.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNR) {
            if (this.bNT != null) {
                this.bNT.WT();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkclose_clk").setContentExt(null, "popup", null));
                return;
            }
            return;
        }
        if (view == this.bNP) {
        }
    }

    public View getView() {
        return this.rootView;
    }

    public void a(w wVar, c cVar) {
        long j;
        long j2;
        if (cVar != null) {
            this.rootView.setVisibility(0);
            this.bNP.removeAllViews();
            this.bNP.setVisibility(8);
            this.bNL.setVisibility(0);
            this.bNO.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bNM.setUrl(cVar.getAvatar());
                l.a(this.bNM, cVar.getAvatar(), false, false);
            }
            if (this.bNS != null) {
                this.bNS.cancel();
            }
            if (cVar.Yh()) {
                j = (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.videoBBChatData == null) ? 0L : wVar.mLiveInfo.videoBBChatData.invitePendantTime;
                if (j <= 0) {
                    j2 = 20;
                }
                j2 = j;
            } else {
                j = (wVar == null || wVar.mLiveInfo == null || wVar.mLiveInfo.videoBBChatData == null) ? 0L : wVar.mLiveInfo.videoBBChatData.acceptPendantTime;
                if (j <= 0) {
                    j2 = 10;
                }
                j2 = j;
            }
            this.bNN.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bNN.setVisibility(0);
            this.bNS = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bNN.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bNN.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bNJ != null) {
                        b.this.bNJ.WU();
                    }
                    b.this.release();
                }
            };
            this.bNS.start();
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
                this.bNQ.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bNQ.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bNP.removeAllViews();
            this.bNP.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bNL.setVisibility(8);
            this.bNP.setVisibility(0);
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
        if (this.bNS != null) {
            this.bNS.cancel();
        }
        this.bNP.removeAllViews();
        this.bNP.setVisibility(8);
        this.bNL.setVisibility(8);
        this.rootView.setVisibility(8);
    }
}
