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
    private BaseWebViewActivity aHR;
    private TextView aHT;
    private View aHU;
    private ImageView aHV;
    protected ImageView aHW;
    private ImageView aHX;
    private LinearLayout aHY;
    private TextView aHZ;
    private View.OnClickListener aIa;
    private View aIb;
    private MorePopupWindow aIc;
    protected View aId;
    private View aIe;
    private View aIf;
    private int aIg;
    private int aIh;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    protected View aHS = null;
    private ProgressBar mProgressBar = null;
    private boolean aIi = true;

    public g(BaseWebViewActivity baseWebViewActivity) {
        this.aHR = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aHR.setContentView(d.h.base_webview_activity);
        this.aHS = this.aHR.findViewById(d.g.root_view);
        if (this.aHR.isTranslucent()) {
            aj.t(this.aHS, this.aHR.getResources().getColor(d.C0141d.black_alpha0));
            this.aHS.setOnClickListener(this.aHR);
        }
        this.mNavigationBar = (NavigationBar) this.aHR.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cF("");
        this.aHY = (LinearLayout) this.aHR.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHY.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aHY.setLayoutParams(layoutParams);
        this.aHZ = (TextView) this.aHR.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aHR.findViewById(d.g.webview_progress);
        this.aHU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aHR != null) {
                    g.this.aHR.finish();
                }
            }
        });
        this.aHV = (ImageView) this.aHU.findViewById(d.g.widget_navi_back_button);
        this.aHV.setContentDescription(this.aHR.getResources().getString(d.j.close));
        this.aIb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aHX.getVisibility() != 0) {
                    g.this.wG();
                }
            }
        });
        this.aHW = (ImageView) this.aIb.findViewById(d.g.widget_navi_more_button);
        this.aHX = (ImageView) this.aIb.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aHR.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aIc = new MorePopupWindow(this.aHR.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aHR.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tbadk.browser.g.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void wK() {
                g.this.wG();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void wL() {
            }
        });
        this.aId = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aId.setOnClickListener(this.aHR);
        if (com.baidu.tbadk.coreExtra.c.e.bc(this.aHR.getPageContext().getPageActivity())) {
            this.aId.setVisibility(0);
        } else {
            this.aId.setVisibility(8);
        }
        this.aIc.refresh();
        this.aIf = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aIf.setOnClickListener(this.aHR);
        this.aIe = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aIe.setOnClickListener(this.aHR);
        wB();
    }

    private void wB() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int t = l.t(this.aHR.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.q(this.aHR.getPageContext().getPageActivity()).heightPixels;
        this.aIg = (i - statusBarHeight) - t;
        this.aIh = i - statusBarHeight;
    }

    public void wC() {
        if (this.mNavigationBar != null && this.aHW != null && this.aHX != null) {
            this.mNavigationBar.setVisibility(0);
            this.aHW.setVisibility(8);
            this.aHX.setVisibility(0);
            this.aHX.setOnClickListener(this.aHR);
        }
    }

    public boolean wD() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void wE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aHV != null) {
            aj.a(this.aHV, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean wF() {
        try {
            this.aHY.addView(this.aHR.createWebView());
            this.aHZ.setVisibility(8);
            if (!this.aIi) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aHZ.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aHY.getLayoutParams().height = this.aIg;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aHY.getLayoutParams().height = this.aIh;
        this.mNavigationBar.setVisibility(8);
    }

    public void aN(boolean z) {
        if (this.aId != null) {
            if (z) {
                this.aId.setVisibility(0);
            } else {
                this.aId.setVisibility(8);
            }
            this.aIc.refresh();
        }
    }

    public void aO(boolean z) {
        if (this.aIb != null) {
            if (z) {
                this.aIb.setVisibility(0);
            } else {
                this.aIb.setVisibility(8);
            }
        }
    }

    public void wG() {
        this.aIc.showWindowInRightBottomOfHost();
    }

    public void wH() {
        com.baidu.adp.lib.g.g.a(this.aIc, this.aHR.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aHZ.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aHZ.setVisibility(8);
    }

    public void cF(String str) {
        this.aHT = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aHT, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aHR.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aHR.getPageContext().getPageActivity(), dVar, true, wI())));
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
            this.mNavigationBar.onChangeSkinType(this.aHR.getPageContext(), i);
        }
        if (this.aIc != null) {
            this.aIc.onChangeSkinType(this.aHR, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aHR.getPageContext(), i);
        }
        aj.a(this.aHV, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aHW, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        aj.a(this.aHX, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aHY.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aHR.getPageContext().getPageActivity(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.aHR.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aHR.getResources().getString(d.j.refresh), this.aIa)));
        }
        this.mNoDataView.onChangeSkinType(this.aHR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aHY.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIa = onClickListener;
    }

    public void release() {
        if (this.aHY != null) {
            this.aHY.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aIc != null) {
            com.baidu.adp.lib.g.g.a(this.aIc, this.aHR.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHY.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aHY.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aHV, d.f.frs_star_navigation_bg);
        aj.s(this.aHW, d.f.frs_star_navigation_bg);
        aj.s(this.aHX, d.f.frs_star_navigation_bg);
        cF("");
        this.aHR.getWindow().setFlags(1024, 1024);
    }

    public void wJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHY.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aHY.setLayoutParams(layoutParams);
        this.aHV.setBackgroundDrawable(null);
        this.aHW.setBackgroundDrawable(null);
        this.aHX.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aHR.getWindow().clearFlags(1024);
    }

    public void aP(boolean z) {
        this.aIi = z;
    }
}
