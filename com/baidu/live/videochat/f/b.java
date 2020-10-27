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
import com.baidu.platform.comapi.map.MapController;
import java.util.Locale;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private InterfaceC0216b bEF;
    private LinearLayout bEH;
    private HeadImageView bEI;
    private TextView bEJ;
    private TextView bEK;
    private FrameLayout bEL;
    private ImageView bEM;
    private View bEN;
    private CountDownTimer bEO;
    private a bEP;
    private View rootView;

    /* loaded from: classes4.dex */
    public interface a {
        void Ss();
    }

    /* renamed from: com.baidu.live.videochat.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0216b {
        void St();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity, a aVar, InterfaceC0216b interfaceC0216b) {
        if (activity != null) {
            this.bEP = aVar;
            this.bEF = interfaceC0216b;
            this.rootView = LayoutInflater.from(activity).inflate(a.h.video_chat_pendant, (ViewGroup) null);
            this.bEH = (LinearLayout) this.rootView.findViewById(a.g.live_bb_video_pendant_connecting);
            this.bEI = (HeadImageView) this.rootView.findViewById(a.g.live_bb_video_avatar);
            this.bEK = (TextView) this.rootView.findViewById(a.g.live_bb_video_name);
            this.bEJ = (TextView) this.rootView.findViewById(a.g.live_bb_video_timer);
            this.bEL = (FrameLayout) this.rootView.findViewById(a.g.live_bb_video_pendant_player);
            this.bEM = (ImageView) this.rootView.findViewById(a.g.live_bb_video_pendant_close);
            this.bEN = this.rootView.findViewById(a.g.live_bb_video_pendant_close_layout);
            this.bEI.setIsRound(true);
            this.bEI.setAutoChangeStyle(false);
            this.bEI.setDefaultBgResource(a.f.sdk_default_avatar);
            this.bEN.setOnClickListener(this);
            this.bEL.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEN) {
            if (this.bEP != null) {
                this.bEP.Ss();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_CLOSE_CLICK).setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                return;
            }
            return;
        }
        if (view == this.bEL) {
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
            this.bEL.removeAllViews();
            this.bEL.setVisibility(8);
            this.bEH.setVisibility(0);
            this.bEK.setText(TextUtils.isEmpty(cVar.getNickName()) ? "" : cVar.getNickName());
            if (!TextUtils.isEmpty(cVar.getAvatar())) {
                this.bEI.setUrl(cVar.getAvatar());
                l.a(this.bEI, cVar.getAvatar(), false, false);
            }
            if (this.bEO != null) {
                this.bEO.cancel();
            }
            if (cVar.TQ()) {
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
            this.bEJ.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j2)));
            this.bEJ.setVisibility(0);
            this.bEO = new CountDownTimer(j2 * 1000, 1000L) { // from class: com.baidu.live.videochat.f.b.1
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.bEJ.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", Long.valueOf(j3 / 1000)));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.bEJ.setText(String.format(Locale.SIMPLIFIED_CHINESE, "%ds", 0));
                    if (b.this.bEF != null) {
                        b.this.bEF.St();
                    }
                    b.this.release();
                }
            };
            this.bEO.start();
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_TAB_SHOW).setContentExt(null, MapController.POPUP_LAYER_TAG, null));
        }
    }

    public void ac(View view) {
        if (view != null) {
            release();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(a.e.sdk_ds18);
            if (Build.VERSION.SDK_INT >= 21) {
                n(view, dimensionPixelSize);
                this.bEM.setImageResource(a.f.icon_live_video_chat_close);
            } else {
                this.bEM.setImageResource(a.f.icon_live_video_chat_close_frame);
            }
            this.rootView.setVisibility(0);
            this.bEL.removeAllViews();
            this.bEL.addView(view, new FrameLayout.LayoutParams(-1, -1));
            this.bEH.setVisibility(8);
            this.bEL.setVisibility(0);
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
        if (this.bEO != null) {
            this.bEO.cancel();
        }
        this.bEL.removeAllViews();
        this.bEL.setVisibility(8);
        this.bEH.setVisibility(8);
        this.rootView.setVisibility(8);
    }
}
