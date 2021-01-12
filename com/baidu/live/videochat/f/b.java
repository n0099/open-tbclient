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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private InterfaceC0224b bNK;
    private LinearLayout bNN;
    private HeadImageView bNO;
    private TextView bNP;
    private TextView bNQ;
    private FrameLayout bNR;
    private ImageView bNS;
    private View bNT;
    private CountDownTimer bNU;
    private a bNV;
    private FrameLayout bNW;
    private View rootView;

    /* loaded from: classes10.dex */
    public interface a {
        void Uh();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0224b {
        void Ui();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0224b interfaceC0224b) {
        if (activity != null) {
            this.bNV = aVar;
            this.bNK = interfaceC0224b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bNN = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bNO = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bNQ = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bNP = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bNR = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bNS = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bNT = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bNW = (FrameLayout) this.rootView.findViewById(a.f.frame_follow);
            this.bNO.setIsRound(true);
            this.bNO.setAutoChangeStyle(false);
            this.bNO.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bNT.setOnClickListener(this);
            this.bNR.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNT) {
            if (this.bNV != null) {
                this.bNV.Uh();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkclose_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                return;
            }
            return;
        }
        if (view == this.bNR) {
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
            this.bNR.removeAllViews();
            this.bNR.setVisibility(8);
            this.bNN.setVisibility(0);
            this.bNQ.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bNO.setUrl(cVar.getAvatar());
                m.a(this.bNO, cVar.getAvatar(), false, false);
            }
            if (this.bNU != null) {
                this.bNU.cancel();
            }
            if (cVar.Vx()) {
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
            this.bNP.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bNP.setVisibility(0);
            this.bNU = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bNP.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bNP.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bNK != null) {
                        b.this.bNK.Ui();
                    }
                    b.this.release();
                }
            };
            this.bNU.start();
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
                this.bNS.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bNS.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bNR.removeAllViews();
            this.bNR.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bNN.setVisibility(8);
            this.bNR.setVisibility(0);
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
        if (this.bNU != null) {
            this.bNU.cancel();
        }
        this.bNR.removeAllViews();
        this.bNR.setVisibility(8);
        this.bNN.setVisibility(8);
        this.rootView.setVisibility(8);
    }

    public FrameLayout Vw() {
        return this.bNW;
    }
}
