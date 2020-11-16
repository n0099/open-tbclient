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
    private a bFo;
    private ViewGroup bIc;
    private FrameLayout bId;
    private View bIe;
    private b bIf;
    private TextView bIg;
    private Animation bIh;
    private Animation bIi;
    private com.baidu.live.videochat.panel.b.a bIj;
    private String bIk;
    private com.baidu.live.videochat.panel.a.a bIl;
    private CommonEmptyView bnY;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int bwz = -1;
    private View.OnClickListener bIm = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.VB();
            if (c.this.bIj != null) {
                c.this.bIj.dh(false);
            }
        }
    };
    private a.InterfaceC0227a bIn = new a.InterfaceC0227a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.ai(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void e(int i, String str, boolean z) {
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
            c.this.bIl = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0227a
        public void X(int i, String str) {
            c.this.mPageContext.showToast(a.h.sdk_neterror);
            c.this.bIl = null;
        }
    };
    private b.a bHR = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.Rt()) {
                c.this.mPageContext.showToast(a.h.video_chat_active_not_invite);
            } else if (c.this.VC() || c.this.bIl != null) {
                c.this.mPageContext.showToast(a.h.video_chat_inviting_not_invite);
            } else if (c.this.bIj != null && aVar != null) {
                c.this.bIl = aVar;
                c.this.bIj.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bFo = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bIh = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_in);
        this.bIi = AnimationUtils.loadAnimation(this.mContext, a.C0195a.sdk_push_up_out);
        GR();
        this.bIj = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bIn);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bIc = viewGroup;
    }

    private void GR() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.video_chat_friends_panel, (ViewGroup) null);
        this.bId = (FrameLayout) this.mRootView.findViewById(a.f.video_chat_container);
        this.bIe = this.mRootView.findViewById(a.f.video_chat_top_space);
        this.bIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.video_chat_friends_list);
        this.bIf = new b(this.mPageContext);
        this.bIf.a(this.bHR);
        this.mListView.setAdapter((ListAdapter) this.bIf);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bIj.dh(true);
                }
            }
        });
        this.bIg = new TextView(this.mContext);
        this.bIg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_e));
        this.bIg.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bIg.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bIg.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.DA()) {
                if (liveBBVideoCheckStatusResponseMessage.VD()) {
                    if (this.bFo != null && this.bIl != null) {
                        this.bFo.b(this.bIl);
                        return;
                    }
                    return;
                }
                if (this.bIl != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.h.video_chat_rival_living), this.bIl.userName));
                }
                this.bIj.dh(false);
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
            Vz();
        } else {
            VA();
        }
        if (!StringUtils.isNull(this.bIk)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bIk.equals(aVar.bIr)) {
                    if (VC()) {
                        aVar.bIp = 1;
                    } else if (Rt() && 2 != aVar.bIp) {
                        aVar.bIp = 2;
                    }
                }
            }
        }
        this.bIf.setData(list);
    }

    public void W(int i, String str) {
        if (this.bIc != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.bwz = i;
            this.bIk = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bIc.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bIc.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bIh);
            this.isShowing = true;
            this.bIj.dh(false);
        }
    }

    private void Vz() {
        this.bIg.setText(this.mContext.getString(a.h.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bIg);
        this.mListView.addFooterView(this.bIg);
    }

    private void VA() {
        this.bIg.setText(this.mContext.getString(a.h.sdk_list_no_more));
        this.mListView.removeFooterView(this.bIg);
        this.mListView.addFooterView(this.bIg);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bnY == null) {
                this.bnY = new CommonEmptyView(this.mContext);
                this.bnY.addToParent(this.bId);
            }
            this.bnY.reset();
            this.bnY.setTitle(i);
            this.bnY.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, this.bIm);
            }
            this.bnY.setVisibility(0);
        }
    }

    public void VB() {
        if (this.bnY != null) {
            this.bnY.setVisibility(8);
        }
    }

    public void fd(int i) {
        this.bwz = i;
        this.bIf.D(this.bIk, false);
        this.bIk = null;
    }

    public void gl(int i) {
        this.bwz = i;
        this.bIf.D(this.bIk, true);
    }

    public void gm(int i) {
        this.bwz = i;
        this.bIf.D(this.bIk, false);
        this.bIk = null;
    }

    public boolean Rt() {
        return h.gi(this.bwz);
    }

    public boolean VC() {
        return h.gj(this.bwz);
    }

    public void hide() {
        if (this.bIc != null && this.mRootView != null) {
            VB();
            this.bIi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bIc.removeView(c.this.mRootView);
                    if (c.this.bIf != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bIg);
                        c.this.bIf.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.bwz = -1;
                    c.this.bIk = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bIi);
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
        this.bIc = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bIh != null) {
                this.bIh.cancel();
                this.bIh = null;
            }
            if (this.bIi != null) {
                this.bIi.cancel();
                this.bIi = null;
            }
        }
    }
}
