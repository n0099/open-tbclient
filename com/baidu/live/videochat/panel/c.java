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
/* loaded from: classes4.dex */
public class c {
    private a bGZ;
    private ViewGroup bJN;
    private FrameLayout bJO;
    private View bJP;
    private b bJQ;
    private TextView bJR;
    private Animation bJS;
    private Animation bJT;
    private com.baidu.live.videochat.panel.b.a bJU;
    private String bJV;
    private com.baidu.live.videochat.panel.a.a bJW;
    private CommonEmptyView bpJ;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int byk = -1;
    private View.OnClickListener bJX = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Wk();
            if (c.this.bJU != null) {
                c.this.bJU.df(false);
            }
        }
    };
    private a.InterfaceC0229a bJY = new a.InterfaceC0229a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0229a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.ai(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0229a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0229a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bJW = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0229a
        public void X(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bJW = null;
        }
    };
    private b.a bJC = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.Sc()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Wl() || c.this.bJW != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bJU != null && aVar != null) {
                c.this.bJW = aVar;
                c.this.bJU.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bGZ = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bJS = AnimationUtils.loadAnimation(this.mContext, a.C0197a.sdk_push_up_in);
        this.bJT = AnimationUtils.loadAnimation(this.mContext, a.C0197a.sdk_push_up_out);
        HA();
        this.bJU = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bJY);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bJN = viewGroup;
    }

    private void HA() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bJO = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bJP = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bJP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bJQ = new b(this.mPageContext);
        this.bJQ.a(this.bJC);
        this.mListView.setAdapter((ListAdapter) this.bJQ);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bJU.df(true);
                }
            }
        });
        this.bJR = new TextView(this.mContext);
        this.bJR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bJR.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bJR.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bJR.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.Ej()) {
                if (liveBBVideoCheckStatusResponseMessage.Wm()) {
                    if (this.bGZ != null && this.bJW != null) {
                        this.bGZ.b(this.bJW);
                        return;
                    }
                    return;
                }
                if (this.bJW != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bJW.userName));
                }
                this.bJU.df(false);
                return;
            }
            this.mPageContext.showToast(a.h.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.h.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            Wi();
        } else {
            Wj();
        }
        if (!StringUtils.isNull(this.bJV)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bJV.equals(aVar.bKc)) {
                    if (Wl()) {
                        aVar.bKa = 1;
                    } else if (Sc() && 2 != aVar.bKa) {
                        aVar.bKa = 2;
                    }
                }
            }
        }
        this.bJQ.setData(list);
    }

    public void W(int i, String str) {
        if (this.bJN != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.byk = i;
            this.bJV = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bJN.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bJN.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bJS);
            this.isShowing = true;
            this.bJU.df(false);
        }
    }

    private void Wi() {
        this.bJR.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bJR);
        this.mListView.addFooterView(this.bJR);
    }

    private void Wj() {
        this.bJR.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bJR);
        this.mListView.addFooterView(this.bJR);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bpJ == null) {
                this.bpJ = new CommonEmptyView(this.mContext);
                this.bpJ.addToParent(this.bJO);
            }
            this.bpJ.reset();
            this.bpJ.setTitle(i);
            this.bpJ.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bpJ.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bJX);
            }
            this.bpJ.setVisibility(0);
        }
    }

    public void Wk() {
        if (this.bpJ != null) {
            this.bpJ.setVisibility(8);
        }
    }

    public void fh(int i) {
        this.byk = i;
        this.bJQ.D(this.bJV, false);
        this.bJV = null;
    }

    public void gq(int i) {
        this.byk = i;
        this.bJQ.D(this.bJV, true);
    }

    public void gr(int i) {
        this.byk = i;
        this.bJQ.D(this.bJV, false);
        this.bJV = null;
    }

    public boolean Sc() {
        return h.gm(this.byk);
    }

    public boolean Wl() {
        return h.gn(this.byk);
    }

    public void hide() {
        if (this.bJN != null && this.mRootView != null) {
            Wk();
            this.bJT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bJN.removeView(c.this.mRootView);
                    if (c.this.bJQ != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bJR);
                        c.this.bJQ.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.byk = -1;
                    c.this.bJV = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bJT);
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
        this.bJN = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bJS != null) {
                this.bJS.cancel();
                this.bJS = null;
            }
            if (this.bJT != null) {
                this.bJT.cancel();
                this.bJT = null;
            }
        }
    }
}
