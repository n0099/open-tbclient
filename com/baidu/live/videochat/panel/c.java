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
    private a bAQ;
    private ViewGroup bEg;
    private FrameLayout bEh;
    private View bEi;
    private b bEj;
    private TextView bEk;
    private Animation bEl;
    private Animation bEm;
    private com.baidu.live.videochat.panel.b.a bEn;
    private String bEo;
    private com.baidu.live.videochat.panel.a.a bEp;
    private CommonEmptyView boq;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int bBa = -1;
    private View.OnClickListener bEq = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.TK();
            if (c.this.bEn != null) {
                c.this.bEn.cY(false);
            }
        }
    };
    private a.InterfaceC0217a bEr = new a.InterfaceC0217a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0217a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.ad(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0217a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.i.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0217a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bEp = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0217a
        public void T(int i, String str) {
            c.this.mPageContext.showToast(a.i.sdk_neterror);
            c.this.bEp = null;
        }
    };
    private b.a bDV = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.SX()) {
                c.this.mPageContext.showToast(a.i.video_chat_active_not_invite);
            } else if (c.this.TL() || c.this.bEp != null) {
                c.this.mPageContext.showToast(a.i.video_chat_inviting_not_invite);
            } else if (c.this.bEn != null && aVar != null) {
                c.this.bEp = aVar;
                c.this.bEn.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bAQ = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bEl = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_in);
        this.bEm = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_out);
        GZ();
        this.bEn = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bEr);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bEg = viewGroup;
    }

    private void GZ() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.video_chat_friends_panel, (ViewGroup) null);
        this.bEh = (FrameLayout) this.mRootView.findViewById(a.g.video_chat_container);
        this.bEi = this.mRootView.findViewById(a.g.video_chat_top_space);
        this.bEi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.video_chat_friends_list);
        this.bEj = new b(this.mPageContext);
        this.bEj.a(this.bDV);
        this.mListView.setAdapter((ListAdapter) this.bEj);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bEn.cY(true);
                }
            }
        });
        this.bEk = new TextView(this.mContext);
        this.bEk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
        this.bEk.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.bEk.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bEk.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.DQ()) {
                if (liveBBVideoCheckStatusResponseMessage.TM()) {
                    if (this.bAQ != null && this.bEp != null) {
                        this.bAQ.b(this.bEp);
                        return;
                    }
                    return;
                }
                if (this.bEp != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.i.video_chat_rival_living), this.bEp.userName));
                }
                this.bEn.cY(false);
                return;
            }
            this.mPageContext.showToast(a.i.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.i.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            TI();
        } else {
            TJ();
        }
        if (!StringUtils.isNull(this.bEo)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bEo.equals(aVar.bEv)) {
                    if (TL()) {
                        aVar.bEt = 1;
                    } else if (SX() && 2 != aVar.bEt) {
                        aVar.bEt = 2;
                    }
                }
            }
        }
        this.bEj.setData(list);
    }

    public void S(int i, String str) {
        if (this.bEg != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.bBa = i;
            this.bEo = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bEg.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bEg.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bEl);
            this.isShowing = true;
            this.bEn.cY(false);
        }
    }

    private void TI() {
        this.bEk.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bEk);
        this.mListView.addFooterView(this.bEk);
    }

    private void TJ() {
        this.bEk.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.bEk);
        this.mListView.addFooterView(this.bEk);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.boq == null) {
                this.boq = new CommonEmptyView(this.mContext);
                this.boq.addToParent(this.bEh);
            }
            this.boq.reset();
            this.boq.setTitle(i);
            this.boq.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.boq.setRefreshButton(a.i.sdk_click_refresh_net_text, this.bEq);
            }
            this.boq.setVisibility(0);
        }
    }

    public void TK() {
        if (this.boq != null) {
            this.boq.setVisibility(8);
        }
    }

    public void ge(int i) {
        this.bBa = i;
        this.bEj.D(this.bEo, false);
        this.bEo = null;
    }

    public void gf(int i) {
        this.bBa = i;
        this.bEj.D(this.bEo, true);
    }

    public void gg(int i) {
        this.bBa = i;
        this.bEj.D(this.bEo, false);
        this.bEo = null;
    }

    public boolean SX() {
        return h.gb(this.bBa);
    }

    public boolean TL() {
        return h.gc(this.bBa);
    }

    public void hide() {
        if (this.bEg != null && this.mRootView != null) {
            TK();
            this.bEm.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bEg.removeView(c.this.mRootView);
                    if (c.this.bEj != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bEk);
                        c.this.bEj.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.bBa = -1;
                    c.this.bEo = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bEm);
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
        this.bEg = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bEl != null) {
                this.bEl.cancel();
                this.bEl = null;
            }
            if (this.bEm != null) {
                this.bEm.cancel();
                this.bEm = null;
            }
        }
    }
}
