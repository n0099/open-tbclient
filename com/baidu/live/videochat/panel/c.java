package com.baidu.live.videochat.panel;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.videochat.d.h;
import com.baidu.live.videochat.panel.b;
import com.baidu.live.videochat.panel.b.a;
import com.baidu.live.videochat.panel.message.LiveBBVideoCheckStatusResponseMessage;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private a bPI;
    private ViewGroup bSB;
    private FrameLayout bSC;
    private View bSD;
    private b bSE;
    private TextView bSF;
    private Animation bSG;
    private Animation bSH;
    private com.baidu.live.videochat.panel.b.a bSI;
    private String bSJ;
    private com.baidu.live.videochat.panel.a.a bSK;
    private CommonEmptyView byj;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mChatStatus = -1;
    private View.OnClickListener bSL = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Xc();
            if (c.this.bSI != null) {
                c.this.bSI.dC(false);
            }
        }
    };
    private a.InterfaceC0233a bSM = new a.InterfaceC0233a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0233a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.am(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0233a
        public void d(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0233a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bSK = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0233a
        public void ae(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bSK = null;
        }
    };
    private b.a bSq = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.SN()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Xd() || c.this.bSK != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bSI != null && aVar != null) {
                c.this.bSK = aVar;
                c.this.bSI.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bPI = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bSG = AnimationUtils.loadAnimation(this.mContext, a.C0201a.sdk_push_up_in);
        this.bSH = AnimationUtils.loadAnimation(this.mContext, a.C0201a.sdk_push_up_out);
        FI();
        this.bSI = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bSM);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bSB = viewGroup;
    }

    private void FI() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bSC = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bSD = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bSE = new b(this.mPageContext);
        this.bSE.a(this.bSq);
        this.mListView.setAdapter((ListAdapter) this.bSE);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bSI.dC(true);
                }
            }
        });
        this.bSF = new TextView(this.mContext);
        this.bSF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bSF.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bSF.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bSF.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.BW()) {
                if (liveBBVideoCheckStatusResponseMessage.Xe()) {
                    if (this.bPI != null && this.bSK != null) {
                        this.bPI.b(this.bSK);
                        return;
                    }
                    return;
                }
                if (this.bSK != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bSK.userName));
                }
                this.bSI.dC(false);
                return;
            }
            this.mPageContext.showToast(a.h.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.h.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            Xa();
        } else {
            Xb();
        }
        if (!StringUtils.isNull(this.bSJ)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bSJ.equals(aVar.bSQ)) {
                    if (Xd()) {
                        aVar.bSO = 1;
                    } else if (SN() && 2 != aVar.bSO) {
                        aVar.bSO = 2;
                    }
                }
            }
        }
        this.bSE.setData(list);
    }

    public void ad(int i, String str) {
        if (this.bSB != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.mChatStatus = i;
            this.bSJ = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bSB.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bSB.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bSG);
            this.isShowing = true;
            this.bSI.dC(false);
        }
    }

    private void Xa() {
        this.bSF.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bSF);
        this.mListView.addFooterView(this.bSF);
    }

    private void Xb() {
        this.bSF.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bSF);
        this.mListView.addFooterView(this.bSF);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.byj == null) {
                this.byj = new CommonEmptyView(this.mContext);
                this.byj.addToParent(this.bSC);
            }
            this.byj.reset();
            this.byj.setTitle(i);
            this.byj.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bSL);
            }
            this.byj.setVisibility(0);
        }
    }

    public void Xc() {
        if (this.byj != null) {
            this.byj.setVisibility(8);
        }
    }

    public void eb(int i) {
        this.mChatStatus = i;
        this.bSE.E(this.bSJ, false);
        this.bSJ = null;
    }

    public void fj(int i) {
        this.mChatStatus = i;
        this.bSE.E(this.bSJ, true);
    }

    public void fk(int i) {
        this.mChatStatus = i;
        this.bSE.E(this.bSJ, false);
        this.bSJ = null;
    }

    public boolean SN() {
        return h.fg(this.mChatStatus);
    }

    public boolean Xd() {
        return h.fh(this.mChatStatus);
    }

    public void hide() {
        if (this.bSB != null && this.mRootView != null) {
            Xc();
            this.bSH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bSB.removeView(c.this.mRootView);
                    if (c.this.bSE != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bSF);
                        c.this.bSE.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.mChatStatus = -1;
                    c.this.bSJ = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bSH);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.isShowing) {
            hide();
            return true;
        }
        return false;
    }

    public void onDestroy() {
        if (this.mRootView.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.bSB = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bSG != null) {
                this.bSG.cancel();
                this.bSG = null;
            }
            if (this.bSH != null) {
                this.bSH.cancel();
                this.bSH = null;
            }
        }
        if (this.bSI != null) {
            this.bSI.onDestroy();
        }
    }
}
