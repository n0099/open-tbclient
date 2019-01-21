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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
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
import com.baidu.tieba.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    protected View anA;
    private View anB;
    private View anC;
    private int anD;
    private int anE;
    private com.baidu.tieba.person.e anH;
    private BaseWebViewActivity ano;
    private TextView anq;
    private View anr;
    private ImageView ans;
    protected ImageView ant;
    private ImageView anu;
    private LinearLayout anv;
    private TextView anw;
    private View.OnClickListener anx;
    private View any;
    private MorePopupWindow anz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View anp = null;
    private ProgressBar mProgressBar = null;
    private boolean anF = true;
    private boolean anG = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.ano = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ano.setContentView(e.h.base_webview_activity);
        this.anp = this.ano.findViewById(e.g.root_view);
        if (this.ano.isTranslucent()) {
            al.j(this.anp, this.ano.getResources().getColor(e.d.black_alpha0));
            this.anp.setOnClickListener(this.ano);
        }
        this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        ef("");
        this.anv = (LinearLayout) this.ano.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anv.setLayoutParams(layoutParams);
        this.anw = (TextView) this.ano.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.ano.findViewById(e.g.webview_progress);
        this.anr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ano != null) {
                    if (!(f.this.ano instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.ano).isDisableGoBack || !((TbWebViewActivity) f.this.ano).needDealClickGoBack()) {
                        f.this.ano.finish();
                    }
                }
            }
        });
        this.ans = (ImageView) this.anr.findViewById(e.g.widget_navi_back_button);
        this.ans.setContentDescription(this.ano.getResources().getString(e.j.close));
        this.any = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.xm()) {
                    f.this.xn();
                } else if (f.this.anu.getVisibility() != 0) {
                    f.this.showPopMenu();
                }
            }
        });
        this.ant = (ImageView) this.any.findViewById(e.g.widget_navi_more_button);
        this.anu = (ImageView) this.any.findViewById(e.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.ano.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.anz = new MorePopupWindow(this.ano.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.ano.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xq() {
                f.this.showPopMenu();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void xr() {
            }
        });
        this.anA = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.anA.setOnClickListener(this.ano);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.ano.getPageContext().getPageActivity())) {
            this.anA.setVisibility(0);
        } else {
            this.anA.setVisibility(8);
        }
        this.anz.refresh();
        this.anC = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.anC.setOnClickListener(this.ano);
        this.anB = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.anB.setOnClickListener(this.ano);
        xh();
    }

    private void xh() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.ano.getPageContext().getPageActivity(), e.C0210e.ds88);
        int i = l.s(this.ano.getPageContext().getPageActivity()).heightPixels;
        this.anD = (i - statusBarHeight) - h;
        this.anE = i - statusBarHeight;
    }

    public void xi() {
        if (this.mNavigationBar != null && this.ant != null && this.anu != null) {
            this.mNavigationBar.setVisibility(0);
            this.ant.setVisibility(8);
            this.anu.setVisibility(0);
            this.anu.setOnClickListener(this.ano);
        }
    }

    public boolean xj() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void xk() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.ans != null) {
            al.a(this.ans, e.f.icon_return_bg_s, e.f.icon_return_bg);
        }
    }

    public boolean xl() {
        try {
            this.anv.addView(this.ano.createWebView());
            this.anw.setVisibility(8);
            if (!this.anF) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.anw.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.anv.getLayoutParams().height = this.anD;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.anv.getLayoutParams().height = this.anE;
        this.mNavigationBar.setVisibility(8);
    }

    public void aS(boolean z) {
        if (this.anA != null) {
            if (z) {
                this.anA.setVisibility(0);
            } else {
                this.anA.setVisibility(8);
            }
            this.anz.refresh();
        }
    }

    public void aT(boolean z) {
        if (this.any != null) {
            if (z) {
                this.any.setVisibility(0);
            } else {
                this.any.setVisibility(8);
            }
        }
    }

    public boolean xm() {
        return this.anG;
    }

    public void aU(boolean z) {
        this.anG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xn() {
        if (this.anH == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.ano);
            ArrayList arrayList = new ArrayList();
            a.C0333a c0333a = new a.C0333a(this.ano.getString(e.j.report_text), aVar);
            c0333a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.anH != null && f.this.ano != null) {
                        f.this.anH.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.ano).createNormalCfg(f.this.ano.getResources().getString(e.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0333a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.anH != null) {
                        f.this.anH.dismiss();
                    }
                }
            });
            aVar.ef(arrayList);
            this.anH = new com.baidu.tieba.person.e(this.ano, aVar.bNw());
            this.anH.ax(0.7f);
        }
        this.anH.show();
    }

    public void showPopMenu() {
        this.anz.showWindowInRightBottomOfHost();
    }

    public void dismissPopMenu() {
        g.a(this.anz, this.ano.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.anw.setVisibility(0);
    }

    public void hideCrashTip() {
        this.anw.setVisibility(8);
    }

    public void ef(String str) {
        this.anq = this.mNavigationBar.setCenterTextTitle(str);
        al.b(this.anq, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.ano.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.aB("obj_url", dVar.linkUrl);
            amVar.y("obj_type", 0);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.ano, dVar, true, xo())));
        }
    }

    private SparseArray<String> xo() {
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
            this.mNavigationBar.onChangeSkinType(this.ano.getPageContext(), i);
        }
        if (this.anz != null) {
            this.anz.onChangeSkinType(this.ano, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ano.getPageContext(), i);
        }
        al.a(this.ans, e.f.icon_topbar_close_n, e.f.icon_topbar_close_s, e.f.icon_topbar_close_n, i);
        al.a(this.ant, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
        al.a(this.anu, e.f.icon_home_card_share, e.f.icon_home_card_share, e.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.anv.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ano.getPageContext().getPageActivity(), this.anp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aE(null, this.ano.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ano.getResources().getString(e.j.refresh), this.anx)));
        }
        this.mNoDataView.onChangeSkinType(this.ano.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.anv.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void release() {
        if (this.anv != null) {
            this.anv.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.anz != null) {
            g.a(this.anz, this.ano.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.anv.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.ans, e.f.frs_star_navigation_bg);
        al.i(this.ant, e.f.frs_star_navigation_bg);
        al.i(this.anu, e.f.frs_star_navigation_bg);
        ef("");
        this.ano.getWindow().setFlags(1024, 1024);
    }

    public void xp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.anv.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.anv.setLayoutParams(layoutParams);
        this.ans.setBackgroundDrawable(null);
        this.ant.setBackgroundDrawable(null);
        this.anu.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.ano.getWindow().clearFlags(1024);
    }

    public void aV(boolean z) {
        this.anF = z;
    }
}
