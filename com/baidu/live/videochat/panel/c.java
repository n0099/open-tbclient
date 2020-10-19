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
    private ViewGroup bBk;
    private FrameLayout bBl;
    private View bBm;
    private b bBn;
    private TextView bBo;
    private Animation bBp;
    private Animation bBq;
    private com.baidu.live.videochat.panel.b.a bBr;
    private String bBs;
    private com.baidu.live.videochat.panel.a.a bBt;
    private CommonEmptyView bmS;
    private a bxU;
    private boolean isShowing;
    private Context mContext;
    private boolean mHasMore;
    private BdListView mListView;
    private TbPageContext mPageContext;
    private View mRootView;
    private int bye = -1;
    private View.OnClickListener bBu = new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.SK();
            if (c.this.bBr != null) {
                c.this.bBr.cS(false);
            }
        }
    };
    private a.InterfaceC0211a bBv = new a.InterfaceC0211a() { // from class: com.baidu.live.videochat.panel.c.2
        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0211a
        public void g(List<com.baidu.live.videochat.panel.a.a> list, boolean z) {
            c.this.mHasMore = z;
            c.this.Z(list);
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0211a
        public void e(int i, String str, boolean z) {
            if (z) {
                c.this.mPageContext.showToast(a.i.sdk_neterror);
            } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                c.this.a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.SERVER_ERROR);
            } else {
                c.this.a(a.i.sdk_net_fail_tip, CommonEmptyView.ImgType.NO_NET);
            }
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0211a
        public void b(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
            c.this.a(liveBBVideoCheckStatusResponseMessage);
            c.this.bBt = null;
        }

        @Override // com.baidu.live.videochat.panel.b.a.InterfaceC0211a
        public void R(int i, String str) {
            c.this.mPageContext.showToast(a.i.sdk_neterror);
            c.this.bBt = null;
        }
    };
    private b.a bAZ = new b.a() { // from class: com.baidu.live.videochat.panel.c.3
        @Override // com.baidu.live.videochat.panel.b.a
        public void c(com.baidu.live.videochat.panel.a.a aVar) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_INVITE_BTN_CLICK));
            if (c.this.RX()) {
                c.this.mPageContext.showToast(a.i.video_chat_active_not_invite);
            } else if (c.this.SL() || c.this.bBt != null) {
                c.this.mPageContext.showToast(a.i.video_chat_inviting_not_invite);
            } else if (c.this.bBr != null && aVar != null) {
                c.this.bBt = aVar;
                c.this.bBr.d(aVar);
            }
        }
    };

    public c(TbPageContext tbPageContext, a aVar) {
        this.bxU = aVar;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.bBp = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_up_in);
        this.bBq = AnimationUtils.loadAnimation(this.mContext, a.C0194a.sdk_push_up_out);
        GD();
        this.bBr = new com.baidu.live.videochat.panel.b.a(this.mPageContext, this.bBv);
    }

    public void a(TbPageContext tbPageContext, ViewGroup viewGroup) {
        this.bBk = viewGroup;
    }

    private void GD() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.video_chat_friends_panel, (ViewGroup) null);
        this.bBl = (FrameLayout) this.mRootView.findViewById(a.g.video_chat_container);
        this.bBm = this.mRootView.findViewById(a.g.video_chat_top_space);
        this.bBm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.videochat.panel.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.hide();
            }
        });
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.video_chat_friends_list);
        this.bBn = new b(this.mPageContext);
        this.bBn.a(this.bAZ);
        this.mListView.setAdapter((ListAdapter) this.bBn);
        this.mListView.setOnSrollToBottomListener(new BdListView.OnScrollToBottomListener() { // from class: com.baidu.live.videochat.panel.c.5
            @Override // com.baidu.live.adp.widget.listview.BdListView.OnScrollToBottomListener
            public void onScrollToBottom() {
                if (c.this.mHasMore) {
                    c.this.bBr.cS(true);
                }
            }
        });
        this.bBo = new TextView(this.mContext);
        this.bBo.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_e));
        this.bBo.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.bBo.setPadding(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28), 0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bBo.setGravity(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveBBVideoCheckStatusResponseMessage liveBBVideoCheckStatusResponseMessage) {
        if (liveBBVideoCheckStatusResponseMessage != null) {
            if (liveBBVideoCheckStatusResponseMessage.SM()) {
                if (liveBBVideoCheckStatusResponseMessage.SN()) {
                    if (this.bxU != null && this.bBt != null) {
                        this.bxU.b(this.bBt);
                        return;
                    }
                    return;
                }
                if (this.bBt != null) {
                    this.mPageContext.showToast(String.format(this.mContext.getString(a.i.video_chat_rival_living), this.bBt.userName));
                }
                this.bBr.cS(false);
                return;
            }
            this.mPageContext.showToast(a.i.video_chat_rival_not_live);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(List<com.baidu.live.videochat.panel.a.a> list) {
        if (ListUtils.isEmpty(list)) {
            a(a.i.video_chat_list_empty, CommonEmptyView.ImgType.NO_DATA);
            return;
        }
        if (this.mHasMore) {
            SI();
        } else {
            SJ();
        }
        if (!StringUtils.isNull(this.bBs)) {
            for (com.baidu.live.videochat.panel.a.a aVar : list) {
                if (aVar != null && this.bBs.equals(aVar.bBz)) {
                    if (SL()) {
                        aVar.bBx = 1;
                    } else if (RX() && 2 != aVar.bBx) {
                        aVar.bBx = 2;
                    }
                }
            }
        }
        this.bBn.setData(list);
    }

    public void Q(int i, String str) {
        if (this.bBk != null && this.mRootView != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_INVITE_TAB_SHOW));
            this.bye = i;
            this.bBs = str;
            if (this.mRootView.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            if (this.mRootView.getLayoutParams() == null) {
                this.bBk.addView(this.mRootView, new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.bBk.addView(this.mRootView);
            }
            this.mRootView.startAnimation(this.bBp);
            this.isShowing = true;
            this.bBr.cS(false);
        }
    }

    private void SI() {
        this.bBo.setText(this.mContext.getString(a.i.sdk_loading_text_with_ellipsis));
        this.mListView.removeFooterView(this.bBo);
        this.mListView.addFooterView(this.bBo);
    }

    private void SJ() {
        this.bBo.setText(this.mContext.getString(a.i.sdk_list_no_more));
        this.mListView.removeFooterView(this.bBo);
        this.mListView.addFooterView(this.bBo);
    }

    public void a(int i, CommonEmptyView.ImgType imgType) {
        if (this.mContext != null) {
            if (this.bmS == null) {
                this.bmS = new CommonEmptyView(this.mContext);
                this.bmS.addToParent(this.bBl);
            }
            this.bmS.reset();
            this.bmS.setTitle(i);
            this.bmS.setup(imgType, CommonEmptyView.StyleType.LIGHT);
            if (imgType == CommonEmptyView.ImgType.NO_NET || imgType == CommonEmptyView.ImgType.SERVER_ERROR) {
                this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, this.bBu);
            }
            this.bmS.setVisibility(0);
        }
    }

    public void SK() {
        if (this.bmS != null) {
            this.bmS.setVisibility(8);
        }
    }

    public void fZ(int i) {
        this.bye = i;
        this.bBn.C(this.bBs, false);
        this.bBs = null;
    }

    public void ga(int i) {
        this.bye = i;
        this.bBn.C(this.bBs, true);
    }

    public void gb(int i) {
        this.bye = i;
        this.bBn.C(this.bBs, false);
        this.bBs = null;
    }

    public boolean RX() {
        return h.fW(this.bye);
    }

    public boolean SL() {
        return h.fX(this.bye);
    }

    public void hide() {
        if (this.bBk != null && this.mRootView != null) {
            SK();
            this.bBq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.videochat.panel.c.6
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    c.this.bBk.removeView(c.this.mRootView);
                    if (c.this.bBn != null) {
                        c.this.mListView.setSelection(0);
                        c.this.mListView.removeFooterView(c.this.bBo);
                        c.this.bBn.clearData();
                    }
                    c.this.isShowing = false;
                    c.this.bye = -1;
                    c.this.bBs = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.mRootView.startAnimation(this.bBq);
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
        this.bBk = null;
        this.mRootView = null;
        if (Build.VERSION.SDK_INT >= 8) {
            if (this.bBp != null) {
                this.bBp.cancel();
                this.bBp = null;
            }
            if (this.bBq != null) {
                this.bBq.cancel();
                this.bBq = null;
            }
        }
    }
}
