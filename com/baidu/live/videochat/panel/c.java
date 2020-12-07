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
    private a bKx;
    private ViewGroup bNk;
    private FrameLayout bNl;
    private View bNm;
    private b bNn;
    private TextView bNo;
    private Animation bNp;
    private Animation bNq;
    private com.baidu.live.videochat.panel.b.a bNr;
    private String bNs;
    private com.baidu.live.videochat.panel.a.a bNt;
    private CommonEmptyView btg;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mChatStatus = -1;
    private View.OnClickListener bNu = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Yb();
            if (c.this.bNr != null) {
                c.this.bNr.dv(false);
            }
        }
    };
    private a.InterfaceC0236a bNv = new a.InterfaceC0236a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0236a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.ak(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0236a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0236a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bNt = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0236a
        public void X(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bNt = null;
        }
    };
    private b.a bMZ = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.TR()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Yc() || c.this.bNt != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bNr != null && aVar != null) {
                c.this.bNt = aVar;
                c.this.bNr.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bKx = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bNp = AnimationUtils.loadAnimation(this.mContext, a.C0205a.sdk_push_up_in);
        this.bNq = AnimationUtils.loadAnimation(this.mContext, a.C0205a.sdk_push_up_out);
        II();
        this.bNr = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bNv);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bNk = viewGroup;
    }

    private void II() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bNl = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bNm = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bNm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bNn = new b(this.mPageContext);
        this.bNn.a(this.bMZ);
        this.mListView.setAdapter((ListAdapter) this.bNn);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bNr.dv(true);
                }
            }
        });
        this.bNo = new TextView(this.mContext);
        this.bNo.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bNo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bNo.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bNo.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.Fl()) {
                if (liveBBVideoCheckStatusResponseMessage.Yd()) {
                    if (this.bKx != null && this.bNt != null) {
                        this.bKx.b(this.bNt);
                        return;
                    }
                    return;
                }
                if (this.bNt != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bNt.userName));
                }
                this.bNr.dv(false);
                return;
            }
            this.mPageContext.showToast(a.h.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.h.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            XZ();
        } else {
            Ya();
        }
        if (!StringUtils.isNull(this.bNs)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bNs.equals(aVar.bNz)) {
                    if (Yc()) {
                        aVar.bNx = 1;
                    } else if (TR() && 2 != aVar.bNx) {
                        aVar.bNx = 2;
                    }
                }
            }
        }
        this.bNn.setData(list);
    }

    public void W(int i, String str) {
        if (this.bNk != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.mChatStatus = i;
            this.bNs = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bNk.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bNk.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bNp);
            this.isShowing = true;
            this.bNr.dv(false);
        }
    }

    private void XZ() {
        this.bNo.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bNo);
        this.mListView.addFooterView(this.bNo);
    }

    private void Ya() {
        this.bNo.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bNo);
        this.mListView.addFooterView(this.bNo);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.btg == null) {
                this.btg = new CommonEmptyView(this.mContext);
                this.btg.addToParent(this.bNl);
            }
            this.btg.reset();
            this.btg.setTitle(i);
            this.btg.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.btg.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bNu);
            }
            this.btg.setVisibility(0);
        }
    }

    public void Yb() {
        if (this.btg != null) {
            this.btg.setVisibility(8);
        }
    }

    public void fB(int i) {
        this.mChatStatus = i;
        this.bNn.E(this.bNs, false);
        this.bNs = null;
    }

    public void gK(int i) {
        this.mChatStatus = i;
        this.bNn.E(this.bNs, true);
    }

    public void gL(int i) {
        this.mChatStatus = i;
        this.bNn.E(this.bNs, false);
        this.bNs = null;
    }

    public boolean TR() {
        return h.gH(this.mChatStatus);
    }

    public boolean Yc() {
        return h.gI(this.mChatStatus);
    }

    public void hide() {
        if (this.bNk != null && this.mRootView != null) {
            Yb();
            this.bNq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bNk.removeView(c.this.mRootView);
                    if (c.this.bNn != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bNo);
                        c.this.bNn.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.mChatStatus = -1;
                    c.this.bNs = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bNq);
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
        this.bNk = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bNp != null) {
                this.bNp.cancel();
                this.bNp = null;
            }
            if (this.bNq != null) {
                this.bNq.cancel();
                this.bNq = null;
            }
        }
    }
}
