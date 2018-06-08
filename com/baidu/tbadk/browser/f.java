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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f {
    private MorePopupWindow abA;
    protected View abB;
    private View abC;
    private View abD;
    private int abE;
    private int abF;
    private BaseWebViewActivity abo;
    private TextView abq;
    private View abr;
    private ImageView abt;
    protected ImageView abu;
    private ImageView abv;
    private LinearLayout abw;
    private TextView abx;
    private View.OnClickListener aby;
    private View abz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View abp = null;
    private ProgressBar mProgressBar = null;
    private boolean abG = true;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.abo = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.abo.setContentView(d.i.base_webview_activity);
        this.abp = this.abo.findViewById(d.g.root_view);
        if (this.abo.isTranslucent()) {
            al.j(this.abp, this.abo.getResources().getColor(d.C0141d.black_alpha0));
            this.abp.setOnClickListener(this.abo);
        }
        this.mNavigationBar = (NavigationBar) this.abo.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cW("");
        this.abw = (LinearLayout) this.abo.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abw.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abw.setLayoutParams(layoutParams);
        this.abx = (TextView) this.abo.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.abo.findViewById(d.g.webview_progress);
        this.abr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abo != null) {
                    f.this.abo.finish();
                }
            }
        });
        this.abt = (ImageView) this.abr.findViewById(d.g.widget_navi_back_button);
        this.abt.setContentDescription(this.abo.getResources().getString(d.k.close));
        this.abz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abv.getVisibility() != 0) {
                    f.this.sK();
                }
            }
        });
        this.abu = (ImageView) this.abz.findViewById(d.g.widget_navi_more_button);
        this.abv = (ImageView) this.abz.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.abo.getPageContext().getPageActivity()).inflate(d.i.tb_webview_pop_more, (ViewGroup) null);
        this.abA = new MorePopupWindow(this.abo.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.abo.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sO() {
                f.this.sK();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sP() {
            }
        });
        this.abB = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.abB.setOnClickListener(this.abo);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.abo.getPageContext().getPageActivity())) {
            this.abB.setVisibility(0);
        } else {
            this.abB.setVisibility(8);
        }
        this.abA.refresh();
        this.abD = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.abD.setOnClickListener(this.abo);
        this.abC = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.abC.setOnClickListener(this.abo);
        sF();
    }

    private void sF() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = l.e(this.abo.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.p(this.abo.getPageContext().getPageActivity()).heightPixels;
        this.abE = (i - statusBarHeight) - e;
        this.abF = i - statusBarHeight;
    }

    public void sG() {
        if (this.mNavigationBar != null && this.abu != null && this.abv != null) {
            this.mNavigationBar.setVisibility(0);
            this.abu.setVisibility(8);
            this.abv.setVisibility(0);
            this.abv.setOnClickListener(this.abo);
        }
    }

    public boolean sH() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void sI() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.abt != null) {
            al.a(this.abt, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean sJ() {
        try {
            this.abw.addView(this.abo.createWebView());
            this.abx.setVisibility(8);
            if (!this.abG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abx.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abw.getLayoutParams().height = this.abE;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abw.getLayoutParams().height = this.abF;
        this.mNavigationBar.setVisibility(8);
    }

    public void aj(boolean z) {
        if (this.abB != null) {
            if (z) {
                this.abB.setVisibility(0);
            } else {
                this.abB.setVisibility(8);
            }
            this.abA.refresh();
        }
    }

    public void ak(boolean z) {
        if (this.abz != null) {
            if (z) {
                this.abz.setVisibility(0);
            } else {
                this.abz.setVisibility(8);
            }
        }
    }

    public void sK() {
        this.abA.showWindowInRightBottomOfHost();
    }

    public void sL() {
        g.a(this.abA, this.abo.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.abx.setVisibility(0);
    }

    public void hideCrashTip() {
        this.abx.setVisibility(8);
    }

    public void cW(String str) {
        this.abq = this.mNavigationBar.setCenterTextTitle(str);
        al.b(this.abq, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.abo.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.ah("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.abo.getPageContext().getPageActivity(), dVar, true, sM())));
        }
    }

    private SparseArray<String> sM() {
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
            this.mNavigationBar.onChangeSkinType(this.abo.getPageContext(), i);
        }
        if (this.abA != null) {
            this.abA.onChangeSkinType(this.abo, i, al.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.abo.getPageContext(), i);
        }
        al.a(this.abt, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        al.a(this.abu, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        al.a(this.abv, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abw.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.abo.getPageContext().getPageActivity(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aj(null, this.abo.getPageContext().getString(d.k.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.abo.getResources().getString(d.k.refresh), this.aby)));
        }
        this.mNoDataView.onChangeSkinType(this.abo.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abw.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aby = onClickListener;
    }

    public void release() {
        if (this.abw != null) {
            this.abw.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abA != null) {
            g.a(this.abA, this.abo.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abw.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abw.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.abt, d.f.frs_star_navigation_bg);
        al.i(this.abu, d.f.frs_star_navigation_bg);
        al.i(this.abv, d.f.frs_star_navigation_bg);
        cW("");
        this.abo.getWindow().setFlags(1024, 1024);
    }

    public void sN() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abw.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abw.setLayoutParams(layoutParams);
        this.abt.setBackgroundDrawable(null);
        this.abu.setBackgroundDrawable(null);
        this.abv.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.abo.getWindow().clearFlags(1024);
    }

    public void al(boolean z) {
        this.abG = z;
    }
}
