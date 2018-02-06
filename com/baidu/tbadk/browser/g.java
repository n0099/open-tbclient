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
    private BaseWebViewActivity aIc;
    private TextView aIe;
    private View aIf;
    private ImageView aIg;
    protected ImageView aIh;
    private ImageView aIi;
    private LinearLayout aIj;
    private TextView aIk;
    private View.OnClickListener aIl;
    private View aIm;
    private MorePopupWindow aIn;
    protected View aIo;
    private View aIp;
    private View aIq;
    private int aIr;
    private int aIs;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    protected View aId = null;
    private ProgressBar mProgressBar = null;
    private boolean aIt = true;

    public g(BaseWebViewActivity baseWebViewActivity) {
        this.aIc = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aIc.setContentView(d.h.base_webview_activity);
        this.aId = this.aIc.findViewById(d.g.root_view);
        if (this.aIc.isTranslucent()) {
            aj.t(this.aId, this.aIc.getResources().getColor(d.C0140d.black_alpha0));
            this.aId.setOnClickListener(this.aIc);
        }
        this.mNavigationBar = (NavigationBar) this.aIc.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cF("");
        this.aIj = (LinearLayout) this.aIc.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aIj.setLayoutParams(layoutParams);
        this.aIk = (TextView) this.aIc.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aIc.findViewById(d.g.webview_progress);
        this.aIf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aIc != null) {
                    g.this.aIc.finish();
                }
            }
        });
        this.aIg = (ImageView) this.aIf.findViewById(d.g.widget_navi_back_button);
        this.aIg.setContentDescription(this.aIc.getResources().getString(d.j.close));
        this.aIm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.aIi.getVisibility() != 0) {
                    g.this.wG();
                }
            }
        });
        this.aIh = (ImageView) this.aIm.findViewById(d.g.widget_navi_more_button);
        this.aIi = (ImageView) this.aIm.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aIc.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.aIn = new MorePopupWindow(this.aIc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aIc.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new f.a() { // from class: com.baidu.tbadk.browser.g.3
            @Override // com.baidu.tbadk.core.view.f.a
            public void wK() {
                g.this.wG();
            }

            @Override // com.baidu.tbadk.core.view.f.a
            public void wL() {
            }
        });
        this.aIo = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.aIo.setOnClickListener(this.aIc);
        if (com.baidu.tbadk.coreExtra.c.e.bc(this.aIc.getPageContext().getPageActivity())) {
            this.aIo.setVisibility(0);
        } else {
            this.aIo.setVisibility(8);
        }
        this.aIn.refresh();
        this.aIq = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.aIq.setOnClickListener(this.aIc);
        this.aIp = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.aIp.setOnClickListener(this.aIc);
        wB();
    }

    private void wB() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int t = l.t(this.aIc.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.q(this.aIc.getPageContext().getPageActivity()).heightPixels;
        this.aIr = (i - statusBarHeight) - t;
        this.aIs = i - statusBarHeight;
    }

    public void wC() {
        if (this.mNavigationBar != null && this.aIh != null && this.aIi != null) {
            this.mNavigationBar.setVisibility(0);
            this.aIh.setVisibility(8);
            this.aIi.setVisibility(0);
            this.aIi.setOnClickListener(this.aIc);
        }
    }

    public boolean wD() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void wE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aIg != null) {
            aj.a(this.aIg, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean wF() {
        try {
            this.aIj.addView(this.aIc.createWebView());
            this.aIk.setVisibility(8);
            if (!this.aIt) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aIk.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aIj.getLayoutParams().height = this.aIr;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aIj.getLayoutParams().height = this.aIs;
        this.mNavigationBar.setVisibility(8);
    }

    public void aN(boolean z) {
        if (this.aIo != null) {
            if (z) {
                this.aIo.setVisibility(0);
            } else {
                this.aIo.setVisibility(8);
            }
            this.aIn.refresh();
        }
    }

    public void aO(boolean z) {
        if (this.aIm != null) {
            if (z) {
                this.aIm.setVisibility(0);
            } else {
                this.aIm.setVisibility(8);
            }
        }
    }

    public void wG() {
        this.aIn.showWindowInRightBottomOfHost();
    }

    public void wH() {
        com.baidu.adp.lib.g.g.a(this.aIn, this.aIc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aIk.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aIk.setVisibility(8);
    }

    public void cF(String str) {
        this.aIe = this.mNavigationBar.setCenterTextTitle(str);
        aj.d(this.aIe, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aIc.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            ak akVar = new ak("c10898");
            akVar.ab("obj_url", dVar.linkUrl);
            TiebaStatic.log(akVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aIc.getPageContext().getPageActivity(), dVar, true, wI())));
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
            this.mNavigationBar.onChangeSkinType(this.aIc.getPageContext(), i);
        }
        if (this.aIn != null) {
            this.aIn.onChangeSkinType(this.aIc, i, aj.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aIc.getPageContext(), i);
        }
        aj.a(this.aIg, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        aj.a(this.aIh, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        aj.a(this.aIi, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aIj.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aIc.getPageContext().getPageActivity(), this.aId, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ae(null, this.aIc.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aIc.getResources().getString(d.j.refresh), this.aIl)));
        }
        this.mNoDataView.onChangeSkinType(this.aIc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aIj.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aIl = onClickListener;
    }

    public void release() {
        if (this.aIj != null) {
            this.aIj.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aIn != null) {
            com.baidu.adp.lib.g.g.a(this.aIn, this.aIc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aIj.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        aj.s(this.aIg, d.f.frs_star_navigation_bg);
        aj.s(this.aIh, d.f.frs_star_navigation_bg);
        aj.s(this.aIi, d.f.frs_star_navigation_bg);
        cF("");
        this.aIc.getWindow().setFlags(1024, 1024);
    }

    public void wJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIj.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.aIj.setLayoutParams(layoutParams);
        this.aIg.setBackgroundDrawable(null);
        this.aIh.setBackgroundDrawable(null);
        this.aIi.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aIc.getWindow().clearFlags(1024);
    }

    public void aP(boolean z) {
        this.aIt = z;
    }
}
