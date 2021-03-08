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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private InterfaceC0232b bTa;
    private LinearLayout bTd;
    private HeadImageView bTe;
    private TextView bTf;
    private TextView bTg;
    private FrameLayout bTh;
    private ImageView bTi;
    private View bTj;
    private CountDownTimer bTk;
    private a bTl;
    private FrameLayout bTm;
    private View rootView;

    /* loaded from: classes10.dex */
    public interface a {
        void VT();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0232b {
        void VU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0232b interfaceC0232b) {
        if (activity != null) {
            this.bTl = aVar;
            this.bTa = interfaceC0232b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bTd = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bTe = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bTg = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bTf = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bTh = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bTi = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bTj = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bTm = (FrameLayout) this.rootView.findViewById(a.f.frame_follow);
            this.bTe.setIsRound(true);
            this.bTe.setAutoChangeStyle(false);
            this.bTe.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bTj.setOnClickListener(this);
            this.bTh.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bTj) {
            if (this.bTl != null) {
                this.bTl.VT();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "linkclose_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        } else if (view == this.bTh) {
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
            this.bTh.removeAllViews();
            this.bTh.setVisibility(8);
            this.bTd.setVisibility(0);
            this.bTg.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bTe.setUrl(cVar.getAvatar());
                m.a(this.bTe, cVar.getAvatar(), false, false);
            }
            if (this.bTk != null) {
                this.bTk.cancel();
            }
            if (cVar.Xj()) {
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
            this.bTf.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bTf.setVisibility(0);
            this.bTk = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bTf.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bTf.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bTa != null) {
                        b.this.bTa.VU();
                    }
                    b.this.release();
                }
            };
            this.bTk.start();
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
                this.bTi.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bTi.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bTh.removeAllViews();
            this.bTh.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bTd.setVisibility(8);
            this.bTh.setVisibility(0);
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
        if (this.bTk != null) {
            this.bTk.cancel();
        }
        this.bTh.removeAllViews();
        this.bTh.setVisibility(8);
        this.bTd.setVisibility(8);
        this.rootView.setVisibility(8);
    }

    public FrameLayout Xi() {
        return this.bTm;
    }
}
