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
/* loaded from: classes11.dex */
public class c {
    private a bPk;
    private ViewGroup bRX;
    private FrameLayout bRY;
    private View bRZ;
    private b bSa;
    private TextView bSb;
    private Animation bSc;
    private Animation bSd;
    private com.baidu.live.videochat.panel.b.a bSe;
    private String bSf;
    private com.baidu.live.videochat.panel.a.a bSg;
    private CommonEmptyView bxT;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mChatStatus = -1;
    private View.OnClickListener bSh = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Zj();
            if (c.this.bSe != null) {
                c.this.bSe.dy(false);
            }
        }
    };
    private a.InterfaceC0234a bSi = new a.InterfaceC0234a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0234a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.al(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0234a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0234a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bSg = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0234a
        public void Z(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bSg = null;
        }
    };
    private b.a bRM = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.UW()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Zk() || c.this.bSg != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bSe != null && aVar != null) {
                c.this.bSg = aVar;
                c.this.bSe.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bPk = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bSc = AnimationUtils.loadAnimation(this.mContext, a.C0203a.sdk_push_up_in);
        this.bSd = AnimationUtils.loadAnimation(this.mContext, a.C0203a.sdk_push_up_out);
        Ik();
        this.bSe = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bSi);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bRX = viewGroup;
    }

    private void Ik() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bRY = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bRZ = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bRZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bSa = new b(this.mPageContext);
        this.bSa.a(this.bRM);
        this.mListView.setAdapter((ListAdapter) this.bSa);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bSe.dy(true);
                }
            }
        });
        this.bSb = new TextView(this.mContext);
        this.bSb.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bSb.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bSb.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bSb.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.EB()) {
                if (liveBBVideoCheckStatusResponseMessage.Zl()) {
                    if (this.bPk != null && this.bSg != null) {
                        this.bPk.b(this.bSg);
                        return;
                    }
                    return;
                }
                if (this.bSg != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bSg.userName));
                }
                this.bSe.dy(false);
                return;
            }
            this.mPageContext.showToast(a.h.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.h.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            Zh();
        } else {
            Zi();
        }
        if (!StringUtils.isNull(this.bSf)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bSf.equals(aVar.bSm)) {
                    if (Zk()) {
                        aVar.bSk = 1;
                    } else if (UW() && 2 != aVar.bSk) {
                        aVar.bSk = 2;
                    }
                }
            }
        }
        this.bSa.setData(list);
    }

    public void Y(int i, String str) {
        if (this.bRX != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.mChatStatus = i;
            this.bSf = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bRX.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bRX.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bSc);
            this.isShowing = true;
            this.bSe.dy(false);
        }
    }

    private void Zh() {
        this.bSb.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bSb);
        this.mListView.addFooterView(this.bSb);
    }

    private void Zi() {
        this.bSb.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bSb);
        this.mListView.addFooterView(this.bSb);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bxT == null) {
                this.bxT = new CommonEmptyView(this.mContext);
                this.bxT.addToParent(this.bRY);
            }
            this.bxT.reset();
            this.bxT.setTitle(i);
            this.bxT.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bSh);
            }
            this.bxT.setVisibility(0);
        }
    }

    public void Zj() {
        if (this.bxT != null) {
            this.bxT.setVisibility(8);
        }
    }

    public void fC(int i) {
        this.mChatStatus = i;
        this.bSa.E(this.bSf, false);
        this.bSf = null;
    }

    public void gL(int i) {
        this.mChatStatus = i;
        this.bSa.E(this.bSf, true);
    }

    public void gM(int i) {
        this.mChatStatus = i;
        this.bSa.E(this.bSf, false);
        this.bSf = null;
    }

    public boolean UW() {
        return h.gI(this.mChatStatus);
    }

    public boolean Zk() {
        return h.gJ(this.mChatStatus);
    }

    public void hide() {
        if (this.bRX != null && this.mRootView != null) {
            Zj();
            this.bSd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bRX.removeView(c.this.mRootView);
                    if (c.this.bSa != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bSb);
                        c.this.bSa.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.mChatStatus = -1;
                    c.this.bSf = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bSd);
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
        this.bRX = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bSc != null) {
                this.bSc.cancel();
                this.bSc = null;
            }
            if (this.bSd != null) {
                this.bSd.cancel();
                this.bSd = null;
            }
        }
        if (this.bSe != null) {
            this.bSe.onDestroy();
        }
    }
}
