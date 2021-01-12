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
    private a bKy;
    private ViewGroup bNl;
    private FrameLayout bNm;
    private View bNn;
    private b bNo;
    private TextView bNp;
    private Animation bNq;
    private Animation bNr;
    private com.baidu.live.videochat.panel.b.a bNs;
    private String bNt;
    private com.baidu.live.videochat.panel.a.a bNu;
    private CommonEmptyView btf;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int mChatStatus = -1;
    private View.OnClickListener bNv = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.Vq();
            if (c.this.bNs != null) {
                c.this.bNs.du(false);
            }
        }
    };
    private a.InterfaceC0225a bNw = new a.InterfaceC0225a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0225a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.al(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0225a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.h.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.h.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0225a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bNu = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0225a
        public void aa(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bNu = null;
        }
    };
    private b.a bNa = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.Rb()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.Vr() || c.this.bNu != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bNs != null && aVar != null) {
                c.this.bNu = aVar;
                c.this.bNs.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bKy = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bNq = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_up_in);
        this.bNr = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_up_out);
        Ep();
        this.bNs = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bNw);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bNl = viewGroup;
    }

    private void Ep() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bNm = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bNn = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bNo = new b(this.mPageContext);
        this.bNo.a(this.bNa);
        this.mListView.setAdapter((ListAdapter) this.bNo);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bNs.du(true);
                }
            }
        });
        this.bNp = new TextView(this.mContext);
        this.bNp.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bNp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bNp.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bNp.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.AG()) {
                if (liveBBVideoCheckStatusResponseMessage.Vs()) {
                    if (this.bKy != null && this.bNu != null) {
                        this.bKy.b(this.bNu);
                        return;
                    }
                    return;
                }
                if (this.bNu != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bNu.userName));
                }
                this.bNs.du(false);
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
            Vo();
        } else {
            Vp();
        }
        if (!StringUtils.isNull(this.bNt)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bNt.equals(aVar.bNA)) {
                    if (Vr()) {
                        aVar.bNy = 1;
                    } else if (Rb() && 2 != aVar.bNy) {
                        aVar.bNy = 2;
                    }
                }
            }
        }
        this.bNo.setData(list);
    }

    public void Z(int i, String str) {
        if (this.bNl != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.mChatStatus = i;
            this.bNt = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bNl.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bNl.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bNq);
            this.isShowing = true;
            this.bNs.du(false);
        }
    }

    private void Vo() {
        this.bNp.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bNp);
        this.mListView.addFooterView(this.bNp);
    }

    private void Vp() {
        this.bNp.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bNp);
        this.mListView.addFooterView(this.bNp);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.btf == null) {
                this.btf = new CommonEmptyView(this.mContext);
                this.btf.addToParent(this.bNm);
            }
            this.btf.reset();
            this.btf.setTitle(i);
            this.btf.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bNv);
            }
            this.btf.setVisibility(0);
        }
    }

    public void Vq() {
        if (this.btf != null) {
            this.btf.setVisibility(8);
        }
    }

    public void dW(int i) {
        this.mChatStatus = i;
        this.bNo.E(this.bNt, false);
        this.bNt = null;
    }

    public void fe(int i) {
        this.mChatStatus = i;
        this.bNo.E(this.bNt, true);
    }

    public void ff(int i) {
        this.mChatStatus = i;
        this.bNo.E(this.bNt, false);
        this.bNt = null;
    }

    public boolean Rb() {
        return h.fb(this.mChatStatus);
    }

    public boolean Vr() {
        return h.fc(this.mChatStatus);
    }

    public void hide() {
        if (this.bNl != null && this.mRootView != null) {
            Vq();
            this.bNr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bNl.removeView(c.this.mRootView);
                    if (c.this.bNo != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bNp);
                        c.this.bNo.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.mChatStatus = -1;
                    c.this.bNt = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bNr);
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
        this.bNl = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bNq != null) {
                this.bNq.cancel();
                this.bNq = null;
            }
            if (this.bNr != null) {
                this.bNr.cancel();
                this.bNr = null;
            }
        }
        if (this.bNs != null) {
            this.bNs.onDestroy();
        }
    }
}
