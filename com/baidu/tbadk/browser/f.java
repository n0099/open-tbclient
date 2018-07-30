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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BaseWebViewActivity aaU;
    private TextView aaW;
    private View aaX;
    private ImageView aaY;
    protected ImageView aaZ;
    private ImageView aba;
    private LinearLayout abb;
    private TextView abd;
    private View.OnClickListener abe;
    private View abf;
    private MorePopupWindow abg;
    protected View abh;
    private View abi;
    private View abj;
    private int abk;
    private int abl;
    private com.baidu.tieba.person.e abo;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aaV = null;
    private ProgressBar mProgressBar = null;
    private boolean abm = true;
    private boolean abn = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.aaU = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aaU.setContentView(d.h.base_webview_activity);
        this.aaV = this.aaU.findViewById(d.g.root_view);
        if (this.aaU.isTranslucent()) {
            am.j(this.aaV, this.aaU.getResources().getColor(d.C0140d.black_alpha0));
            this.aaV.setOnClickListener(this.aaU);
        }
        this.mNavigationBar = (NavigationBar) this.aaU.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cV("");
        this.abb = (LinearLayout) this.aaU.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abb.setLayoutParams(layoutParams);
        this.abd = (TextView) this.aaU.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aaU.findViewById(d.g.webview_progress);
        this.aaX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aaU != null) {
                    f.this.aaU.finish();
                }
            }
        });
        this.aaY = (ImageView) this.aaX.findViewById(d.g.widget_navi_back_button);
        this.aaY.setContentDescription(this.aaU.getResources().getString(d.j.close));
        this.abf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.sw()) {
                    f.this.sx();
                } else if (f.this.aba.getVisibility() != 0) {
                    f.this.sy();
                }
            }
        });
        this.aaZ = (ImageView) this.abf.findViewById(d.g.widget_navi_more_button);
        this.aba = (ImageView) this.abf.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aaU.getPageContext().getPageActivity()).inflate(d.h.tb_webview_pop_more, (ViewGroup) null);
        this.abg = new MorePopupWindow(this.aaU.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aaU.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sC() {
                f.this.sy();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sD() {
            }
        });
        this.abh = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.abh.setOnClickListener(this.aaU);
        if (com.baidu.tbadk.coreExtra.c.e.aY(this.aaU.getPageContext().getPageActivity())) {
            this.abh.setVisibility(0);
        } else {
            this.abh.setVisibility(8);
        }
        this.abg.refresh();
        this.abj = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.abj.setOnClickListener(this.aaU);
        this.abi = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.abi.setOnClickListener(this.aaU);
        sr();
    }

    private void sr() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.aaU.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.p(this.aaU.getPageContext().getPageActivity()).heightPixels;
        this.abk = (i - statusBarHeight) - f;
        this.abl = i - statusBarHeight;
    }

    public void ss() {
        if (this.mNavigationBar != null && this.aaZ != null && this.aba != null) {
            this.mNavigationBar.setVisibility(0);
            this.aaZ.setVisibility(8);
            this.aba.setVisibility(0);
            this.aba.setOnClickListener(this.aaU);
        }
    }

    public boolean st() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void su() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aaY != null) {
            am.a(this.aaY, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean sv() {
        try {
            this.abb.addView(this.aaU.createWebView());
            this.abd.setVisibility(8);
            if (!this.abm) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abd.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abb.getLayoutParams().height = this.abk;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abb.getLayoutParams().height = this.abl;
        this.mNavigationBar.setVisibility(8);
    }

    public void af(boolean z) {
        if (this.abh != null) {
            if (z) {
                this.abh.setVisibility(0);
            } else {
                this.abh.setVisibility(8);
            }
            this.abg.refresh();
        }
    }

    public void ag(boolean z) {
        if (this.abf != null) {
            if (z) {
                this.abf.setVisibility(0);
            } else {
                this.abf.setVisibility(8);
            }
        }
    }

    public boolean sw() {
        return this.abn;
    }

    public void ah(boolean z) {
        this.abn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx() {
        if (this.abo == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.aaU);
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.aaU.getString(d.j.report_text), aVar);
            c0251a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.abo != null && f.this.aaU != null) {
                        f.this.abo.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.aaU).createNormalCfg(f.this.aaU.getResources().getString(d.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0251a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.abo != null) {
                        f.this.abo.dismiss();
                    }
                }
            });
            aVar.dM(arrayList);
            this.abo = new com.baidu.tieba.person.e(this.aaU, aVar.bEq());
            this.abo.aB(0.7f);
        }
        this.abo.show();
    }

    public void sy() {
        this.abg.showWindowInRightBottomOfHost();
    }

    public void sz() {
        g.a(this.abg, this.aaU.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.abd.setVisibility(0);
    }

    public void hideCrashTip() {
        this.abd.setVisibility(8);
    }

    public void cV(String str) {
        this.aaW = this.mNavigationBar.setCenterTextTitle(str);
        am.b(this.aaW, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aaU.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.af("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aaU, dVar, true, sA())));
        }
    }

    private SparseArray<String> sA() {
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
            this.mNavigationBar.onChangeSkinType(this.aaU.getPageContext(), i);
        }
        if (this.abg != null) {
            this.abg.onChangeSkinType(this.aaU, i, am.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaU.getPageContext(), i);
        }
        am.a(this.aaY, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        am.a(this.aaZ, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        am.a(this.aba, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abb.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aaU.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ah(null, this.aaU.getPageContext().getString(d.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaU.getResources().getString(d.j.refresh), this.abe)));
        }
        this.mNoDataView.onChangeSkinType(this.aaU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abb.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abe = onClickListener;
    }

    public void release() {
        if (this.abb != null) {
            this.abb.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abg != null) {
            g.a(this.abg, this.aaU.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abb.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.aaY, d.f.frs_star_navigation_bg);
        am.i(this.aaZ, d.f.frs_star_navigation_bg);
        am.i(this.aba, d.f.frs_star_navigation_bg);
        cV("");
        this.aaU.getWindow().setFlags(1024, 1024);
    }

    public void sB() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abb.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abb.setLayoutParams(layoutParams);
        this.aaY.setBackgroundDrawable(null);
        this.aaZ.setBackgroundDrawable(null);
        this.aba.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aaU.getWindow().clearFlags(1024);
    }

    public void ai(boolean z) {
        this.abm = z;
    }
}
