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
    private a bOi;
    private ViewGroup bRb;
    private FrameLayout bRc;
    private View bRd;
    private b bRe;
    private TextView bRf;
    private Animation bRg;
    private Animation bRh;
    private com.baidu.live.videochat.panel.b.a bRi;
    private String bRj;
    private com.baidu.live.videochat.panel.a.a bRk;
    private CommonEmptyView bwJ;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mChatStatus = -1;
    private View.OnClickListener bRl = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.WZ();
            if (c.this.bRi != null) {
                c.this.bRi.dC(false);
            }
        }
    };
    private a.InterfaceC0227a bRm = new a.InterfaceC0227a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.am(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void d(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bRk = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void ae(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bRk = null;
        }
    };
    private b.a bQQ = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.SK()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Xa() || c.this.bRk != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bRi != null && aVar != null) {
                c.this.bRk = aVar;
                c.this.bRi.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bOi = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bRg = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_in);
        this.bRh = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_out);
        FF();
        this.bRi = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bRm);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bRb = viewGroup;
    }

    private void FF() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bRc = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bRd = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bRd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bRe = new b(this.mPageContext);
        this.bRe.a(this.bQQ);
        this.mListView.setAdapter((ListAdapter) this.bRe);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bRi.dC(true);
                }
            }
        });
        this.bRf = new TextView(this.mContext);
        this.bRf.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bRf.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bRf.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bRf.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.BT()) {
                if (liveBBVideoCheckStatusResponseMessage.Xb()) {
                    if (this.bOi != null && this.bRk != null) {
                        this.bOi.b(this.bRk);
                        return;
                    }
                    return;
                }
                if (this.bRk != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bRk.userName));
                }
                this.bRi.dC(false);
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
            WX();
        } else {
            WY();
        }
        if (!StringUtils.isNull(this.bRj)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bRj.equals(aVar.bRq)) {
                    if (Xa()) {
                        aVar.bRo = 1;
                    } else if (SK() && 2 != aVar.bRo) {
                        aVar.bRo = 2;
                    }
                }
            }
        }
        this.bRe.setData(list);
    }

    public void ad(int i, String str) {
        if (this.bRb != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.mChatStatus = i;
            this.bRj = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bRb.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bRb.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bRg);
            this.isShowing = true;
            this.bRi.dC(false);
        }
    }

    private void WX() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    private void WY() {
        this.bRf.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bRf);
        this.mListView.addFooterView(this.bRf);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bwJ == null) {
                this.bwJ = new CommonEmptyView(this.mContext);
                this.bwJ.addToParent(this.bRc);
            }
            this.bwJ.reset();
            this.bwJ.setTitle(i);
            this.bwJ.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bRl);
            }
            this.bwJ.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }

    public void ea(int i) {
        this.mChatStatus = i;
        this.bRe.E(this.bRj, false);
        this.bRj = null;
    }

    public void fi(int i) {
        this.mChatStatus = i;
        this.bRe.E(this.bRj, true);
    }

    public void fj(int i) {
        this.mChatStatus = i;
        this.bRe.E(this.bRj, false);
        this.bRj = null;
    }

    public boolean SK() {
        return h.ff(this.mChatStatus);
    }

    public boolean Xa() {
        return h.fg(this.mChatStatus);
    }

    public void hide() {
        if (this.bRb != null && this.mRootView != null) {
            WZ();
            this.bRh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bRb.removeView(c.this.mRootView);
                    if (c.this.bRe != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bRf);
                        c.this.bRe.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.mChatStatus = -1;
                    c.this.bRj = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bRh);
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
        this.bRb = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bRg != null) {
                this.bRg.cancel();
                this.bRg = null;
            }
            if (this.bRh != null) {
                this.bRh.cancel();
                this.bRh = null;
            }
        }
        if (this.bRi != null) {
            this.bRi.onDestroy();
        }
    }
}
