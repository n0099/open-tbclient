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
import com.baidu.tieba.f;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BaseWebViewActivity aaV;
    private TextView aaX;
    private View aaY;
    private ImageView aaZ;
    protected ImageView aba;
    private ImageView abb;
    private LinearLayout abd;
    private TextView abe;
    private View.OnClickListener abf;
    private View abg;
    private MorePopupWindow abh;
    protected View abi;
    private View abj;
    private View abk;
    private int abl;
    private int abm;
    private com.baidu.tieba.person.e abp;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aaW = null;
    private ProgressBar mProgressBar = null;
    private boolean abn = true;
    private boolean abo = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.aaV = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aaV.setContentView(f.h.base_webview_activity);
        this.aaW = this.aaV.findViewById(f.g.root_view);
        if (this.aaV.isTranslucent()) {
            am.j(this.aaW, this.aaV.getResources().getColor(f.d.black_alpha0));
            this.aaW.setOnClickListener(this.aaV);
        }
        this.mNavigationBar = (NavigationBar) this.aaV.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cW("");
        this.abd = (LinearLayout) this.aaV.findViewById(f.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, f.g.view_navigation_bar);
        this.abd.setLayoutParams(layoutParams);
        this.abe = (TextView) this.aaV.findViewById(f.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aaV.findViewById(f.g.webview_progress);
        this.aaY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aaV != null) {
                    f.this.aaV.finish();
                }
            }
        });
        this.aaZ = (ImageView) this.aaY.findViewById(f.g.widget_navi_back_button);
        this.aaZ.setContentDescription(this.aaV.getResources().getString(f.j.close));
        this.abg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.sv()) {
                    f.this.sw();
                } else if (f.this.abb.getVisibility() != 0) {
                    f.this.sx();
                }
            }
        });
        this.aba = (ImageView) this.abg.findViewById(f.g.widget_navi_more_button);
        this.abb = (ImageView) this.abg.findViewById(f.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aaV.getPageContext().getPageActivity()).inflate(f.h.tb_webview_pop_more, (ViewGroup) null);
        this.abh = new MorePopupWindow(this.aaV.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aaV.getPageContext().getResources().getDrawable(f.C0146f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sB() {
                f.this.sx();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sC() {
            }
        });
        this.abi = inflate.findViewById(f.g.webview_more_pop_item_share_friend_layout);
        this.abi.setOnClickListener(this.aaV);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.aaV.getPageContext().getPageActivity())) {
            this.abi.setVisibility(0);
        } else {
            this.abi.setVisibility(8);
        }
        this.abh.refresh();
        this.abk = inflate.findViewById(f.g.webview_more_pop_item_open_browser_layout);
        this.abk.setOnClickListener(this.aaV);
        this.abj = inflate.findViewById(f.g.webview_more_pop_item_copy_link_layout);
        this.abj.setOnClickListener(this.aaV);
        sq();
    }

    private void sq() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int f = l.f(this.aaV.getPageContext().getPageActivity(), f.e.ds88);
        int i = l.o(this.aaV.getPageContext().getPageActivity()).heightPixels;
        this.abl = (i - statusBarHeight) - f;
        this.abm = i - statusBarHeight;
    }

    public void sr() {
        if (this.mNavigationBar != null && this.aba != null && this.abb != null) {
            this.mNavigationBar.setVisibility(0);
            this.aba.setVisibility(8);
            this.abb.setVisibility(0);
            this.abb.setOnClickListener(this.aaV);
        }
    }

    public boolean ss() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void st() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aaZ != null) {
            am.a(this.aaZ, f.C0146f.icon_return_bg_s, f.C0146f.icon_return_bg);
        }
    }

    public boolean su() {
        try {
            this.abd.addView(this.aaV.createWebView());
            this.abe.setVisibility(8);
            if (!this.abn) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abe.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abd.getLayoutParams().height = this.abl;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abd.getLayoutParams().height = this.abm;
        this.mNavigationBar.setVisibility(8);
    }

    public void ag(boolean z) {
        if (this.abi != null) {
            if (z) {
                this.abi.setVisibility(0);
            } else {
                this.abi.setVisibility(8);
            }
            this.abh.refresh();
        }
    }

    public void ah(boolean z) {
        if (this.abg != null) {
            if (z) {
                this.abg.setVisibility(0);
            } else {
                this.abg.setVisibility(8);
            }
        }
    }

    public boolean sv() {
        return this.abo;
    }

    public void ai(boolean z) {
        this.abo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sw() {
        if (this.abp == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.aaV);
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.aaV.getString(f.j.report_text), aVar);
            c0251a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.abp != null && f.this.aaV != null) {
                        f.this.abp.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.aaV).createNormalCfg(f.this.aaV.getResources().getString(f.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0251a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.abp != null) {
                        f.this.abp.dismiss();
                    }
                }
            });
            aVar.dM(arrayList);
            this.abp = new com.baidu.tieba.person.e(this.aaV, aVar.bEs());
            this.abp.aA(0.7f);
        }
        this.abp.show();
    }

    public void sx() {
        this.abh.showWindowInRightBottomOfHost();
    }

    public void sy() {
        g.a(this.abh, this.aaV.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.abe.setVisibility(0);
    }

    public void hideCrashTip() {
        this.abe.setVisibility(8);
    }

    public void cW(String str) {
        this.aaX = this.mNavigationBar.setCenterTextTitle(str);
        am.b(this.aaX, f.d.cp_cont_b, f.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aaV.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.ae("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aaV, dVar, true, sz())));
        }
    }

    private SparseArray<String> sz() {
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
            this.mNavigationBar.onChangeSkinType(this.aaV.getPageContext(), i);
        }
        if (this.abh != null) {
            this.abh.onChangeSkinType(this.aaV, i, am.getDrawable(f.C0146f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaV.getPageContext(), i);
        }
        am.a(this.aaZ, f.C0146f.icon_topbar_close_n, f.C0146f.icon_topbar_close_s, f.C0146f.icon_topbar_close_n, i);
        am.a(this.aba, f.C0146f.icon_more_bg_s, f.C0146f.icon_more_bg_s, f.C0146f.icon_more_bg_s, i);
        am.a(this.abb, f.C0146f.icon_home_card_share, f.C0146f.icon_home_card_share, f.C0146f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abd.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aaV.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.ag(null, this.aaV.getPageContext().getString(f.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaV.getResources().getString(f.j.refresh), this.abf)));
        }
        this.mNoDataView.onChangeSkinType(this.aaV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abd.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abf = onClickListener;
    }

    public void release() {
        if (this.abd != null) {
            this.abd.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abh != null) {
            g.a(this.abh, this.aaV.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abd.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.aaZ, f.C0146f.frs_star_navigation_bg);
        am.i(this.aba, f.C0146f.frs_star_navigation_bg);
        am.i(this.abb, f.C0146f.frs_star_navigation_bg);
        cW("");
        this.aaV.getWindow().setFlags(1024, 1024);
    }

    public void sA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abd.getLayoutParams();
        layoutParams.addRule(3, f.g.view_navigation_bar);
        this.abd.setLayoutParams(layoutParams);
        this.aaZ.setBackgroundDrawable(null);
        this.aba.setBackgroundDrawable(null);
        this.abb.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aaV.getWindow().clearFlags(1024);
    }

    public void aj(boolean z) {
        this.abn = z;
    }
}
