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
    private InterfaceC0226b bIB;
    private LinearLayout bID;
    private HeadImageView bIE;
    private TextView bIF;
    private TextView bIG;
    private FrameLayout bIH;
    private ImageView bII;
    private View bIJ;
    private CountDownTimer bIK;
    private a bIL;
    private View rootView;

    /* loaded from: classes4.dex */
    public interface a {
        void Ur();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0226b {
        void Us();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0226b interfaceC0226b) {
        if (activity != null) {
            this.bIL = aVar;
            this.bIB = interfaceC0226b;
            this.rootView = LayoutInflater.from(activity).inflate(a.g.video_chat_pendant, (ViewGroup) null);
            this.bID = (LinearLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_connecting);
            this.bIE = (HeadImageView) this.rootView.findViewById(a.f.live_bb_video_avatar);
            this.bIG = (TextView) this.rootView.findViewById(a.f.live_bb_video_name);
            this.bIF = (TextView) this.rootView.findViewById(a.f.live_bb_video_timer);
            this.bIH = (FrameLayout) this.rootView.findViewById(a.f.live_bb_video_pendant_player);
            this.bII = (ImageView) this.rootView.findViewById(a.f.live_bb_video_pendant_close);
            this.bIJ = this.rootView.findViewById(a.f.live_bb_video_pendant_close_layout);
            this.bIE.setIsRound(true);
            this.bIE.setAutoChangeStyle(false);
            this.bIE.setDefaultBgResource(a.e.sdk_default_avatar);
            this.bIJ.setOnClickListener(this);
            this.bIH.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bIJ) {
            if (this.bIL != null) {
                this.bIL.Ur();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "linkclose_clk").setContentExt(null, "popup", null));
                return;
            }
            return;
        }
        if (view == this.bIH) {
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
            this.bIH.removeAllViews();
            this.bIH.setVisibility(8);
            this.bID.setVisibility(0);
            this.bIG.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bIE.setUrl(cVar.getAvatar());
                l.a(this.bIE, cVar.getAvatar(), false, false);
            }
            if (this.bIK != null) {
                this.bIK.cancel();
            }
            if (cVar.VH()) {
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
            this.bIF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bIF.setVisibility(0);
            this.bIK = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bIF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bIF.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bIB != null) {
                        b.this.bIB.Us();
                    }
                    b.this.release();
                }
            };
            this.bIK.start();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_TAB_SHOW).setContentExt(null, "popup", null));
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
                this.bII.setImageResource(a.e.icon_live_video_chat_close);
            } else {
                this.bII.setImageResource(a.e.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bIH.removeAllViews();
            this.bIH.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bID.setVisibility(8);
            this.bIH.setVisibility(0);
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
        if (this.bIK != null) {
            this.bIK.cancel();
        }
        this.bIH.removeAllViews();
        this.bIH.setVisibility(8);
        this.bID.setVisibility(8);
        this.rootView.setVisibility(8);
    }
}
