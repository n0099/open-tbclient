package com.baidu.tbadk.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class g {
    private BaseWebViewActivity aHS;
    private TextView aHU;
    private View aHV;
    private ImageView aHW;
    protected ImageView aHX;
    private ImageView aHY;
    private LinearLayout aHZ;
    private TextView aIa;
    private View.OnClickListener aIb;
    private View aIc;
    private MorePopupWindow aId;
    protected View aIe;
    private View aIf;
    private View aIg;
    private int aIh;
    private int aIi;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    protected View aHT = null;
    private ProgressBar mProgressBar = null;
    private boolean aIj = true;

    public g(BaseWebViewActivity baseWebViewActivity) {
        this.aHS = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aHS.setContentView(d.h.base_webview_activity);
        this.aHT = this.aHS.findViewById(d.g.root_view);
        if (this.aHS.isTranslucent()) {
            aj.t(this.aHT, this.aHS.getResources().getColor(d.C0141d.black_alpha0));
            this.aHT.setOnClickListener(this.aHS);
        }
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cF("");
        this.aHZ = (LinearLayout) this.aHS.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHZ.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aHZ.setLayoutParams(layoutParams);
        this.aIa = (TextView) this.aHS.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aHS.findViewById(d.g.webview_progress);
        this.aHV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aHS != null) {
                    g.this.aHS.finish();
                }
            }
        });
        this.aHW = (ImageView) this.aHV.findViewById(d.g.widget_navi_back_button);
        this.aHW.setContentDescription(this.aHS.getResources().getString(d.j.close));
        this.aIc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aHY.getVisibility() != 0) {
                    g.this.wG();
                }
            }
        });
        this.aHX = (ImageView) this.aIc.findViewById(d.g.widget_navi_more_button);
        this.aHY = (ImageView) this.aIc.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aHS.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aId = new MorePopupWindow(this.aHS.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aHS.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tbadk.browser.g.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void wK() {
                g.this.wG();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void wL() {
            }
        });
        this.aIe = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aIe.setOnClickListener(this.aHS);
        if (com.baidu.tbadk.coreExtra.c.e.bc(this.aHS.getPageContext().getPageActivity())) {
            this.aIe.setVisibility(0);
        } else {
            this.aIe.setVisibility(8);
        }
        this.aId.refresh();
        this.aIg = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aIg.setOnClickListener(this.aHS);
        this.aIf = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aIf.setOnClickListener(this.aHS);
        wB();
    }

    private void wB() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int t = l.t(this.aHS.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.q(this.aHS.getPageContext().getPageActivity()).heightPixels;
        this.aIh = (i - statusBarHeight) - t;
        this.aIi = i - statusBarHeight;
    }

    public void wC() {
        if (this.mNavigationBar != null && this.aHX != null && this.aHY != null) {
            this.mNavigationBar.setVisibility(0);
            this.aHX.setVisibility(8);
            this.aHY.setVisibility(0);
            this.aHY.setOnClickListener(this.aHS);
        }
    }

    public boolean wD() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void wE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aHW != null) {
            aj.a(this.aHW, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean wF() {
        try {
            this.aHZ.addView(this.aHS.createWebView());
            this.aIa.setVisibility(8);
            if (!this.aIj) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aIa.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aHZ.getLayoutParams().height = this.aIh;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aHZ.getLayoutParams().height = this.aIi;
        this.mNavigationBar.setVisibility(8);
    }

    public void aN(boolean z) {
        if (this.aIe != null) {
            if (z) {
                this.aIe.setVisibility(0);
            } else {
                this.aIe.setVisibility(8);
            }
            this.aId.refresh();
        }
    }

    public void aO(boolean z) {
        if (this.aIc != null) {
            if (z) {
                this.aIc.setVisibility(0);
            } else {
                this.aIc.setVisibility(8);
            }
        }
    }

    public void wG() {
        this.aId.showWindowInRightBottomOfHost();
    }

    public void wH() {
        com.baidu.adp.lib.g.g.a(this.aId, this.aHS.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aIa.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aIa.setVisibility(8);
    }

    public void cF(String str) {
        this.aHU = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aHU, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aHS.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aHS.getPageContext().getPageActivity(), dVar, true, wI())));
        }
    }

    private SparseArray<String> wI() {
        if (0 != 0) {
            return null;
        }
        SparseArray<String> sparseArray = new SparseArray<>(8);
        sparseArray.put(2, "pb_wx_timeline");
        sparseArray.put(3, "pb_wx_friend");
        sparseArray.put(4, "pb_qq_zone");
        sparseArray.put(5, "pb_tencent_weibo");
        sparseArray.put(6, "pb_sina_weibo");
        sparseArray.put(7, "pb_renren");
        return sparseArray;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.aHS.getPageContext(), i);
        }
        if (this.aId != null) {
            this.aId.onChangeSkinType(this.aHS, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aHS.getPageContext(), i);
        }
        aj.a(this.aHW, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aHX, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        aj.a(this.aHY, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aHZ.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aHS.getPageContext().getPageActivity(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.aHS.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aHS.getResources().getString(d.j.refresh), this.aIb)));
        }
        this.mNoDataView.onChangeSkinType(this.aHS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aHZ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIb = onClickListener;
    }

    public void release() {
        if (this.aHZ != null) {
            this.aHZ.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aId != null) {
            com.baidu.adp.lib.g.g.a(this.aId, this.aHS.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHZ.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aHZ.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aHW, d.f.frs_star_navigation_bg);
        aj.s(this.aHX, d.f.frs_star_navigation_bg);
        aj.s(this.aHY, d.f.frs_star_navigation_bg);
        cF("");
        this.aHS.getWindow().setFlags(1024, 1024);
    }

    public void wJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHZ.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aHZ.setLayoutParams(layoutParams);
        this.aHW.setBackgroundDrawable(null);
        this.aHX.setBackgroundDrawable(null);
        this.aHY.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aHS.getWindow().clearFlags(1024);
    }

    public void aP(boolean z) {
        this.aIj = z;
    }
}
