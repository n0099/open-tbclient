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
    private com.baidu.tieba.person.e ajC;
    private BaseWebViewActivity ajj;
    private TextView ajl;
    private View ajm;
    private ImageView ajn;
    protected ImageView ajo;
    private ImageView ajp;
    private LinearLayout ajq;
    private TextView ajr;
    private View.OnClickListener ajs;
    private View ajt;
    private MorePopupWindow aju;
    protected View ajv;
    private View ajw;
    private View ajx;
    private int ajy;
    private int ajz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View ajk = null;
    private ProgressBar mProgressBar = null;
    private boolean ajA = true;
    private boolean ajB = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.ajj = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.ajj.setContentView(e.h.base_webview_activity);
        this.ajk = this.ajj.findViewById(e.g.root_view);
        if (this.ajj.isTranslucent()) {
            al.j(this.ajk, this.ajj.getResources().getColor(e.d.black_alpha0));
            this.ajk.setOnClickListener(this.ajj);
        }
        this.mNavigationBar = (NavigationBar) this.ajj.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        dE("");
        this.ajq = (LinearLayout) this.ajj.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajq.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.ajq.setLayoutParams(layoutParams);
        this.ajr = (TextView) this.ajj.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.ajj.findViewById(e.g.webview_progress);
        this.ajm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ajj != null) {
                    f.this.ajj.finish();
                }
            }
        });
        this.ajn = (ImageView) this.ajm.findViewById(e.g.widget_navi_back_button);
        this.ajn.setContentDescription(this.ajj.getResources().getString(e.j.close));
        this.ajt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.vV()) {
                    f.this.vW();
                } else if (f.this.ajp.getVisibility() != 0) {
                    f.this.showPopMenu();
                }
            }
        });
        this.ajo = (ImageView) this.ajt.findViewById(e.g.widget_navi_more_button);
        this.ajp = (ImageView) this.ajt.findViewById(e.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.ajj.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.aju = new MorePopupWindow(this.ajj.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.ajj.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void vZ() {
                f.this.showPopMenu();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void wa() {
            }
        });
        this.ajv = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.ajv.setOnClickListener(this.ajj);
        if (com.baidu.tbadk.coreExtra.c.e.bI(this.ajj.getPageContext().getPageActivity())) {
            this.ajv.setVisibility(0);
        } else {
            this.ajv.setVisibility(8);
        }
        this.aju.refresh();
        this.ajx = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.ajx.setOnClickListener(this.ajj);
        this.ajw = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.ajw.setOnClickListener(this.ajj);
        vQ();
    }

    private void vQ() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.ajj.getPageContext().getPageActivity(), e.C0200e.ds88);
        int i = l.s(this.ajj.getPageContext().getPageActivity()).heightPixels;
        this.ajy = (i - statusBarHeight) - h;
        this.ajz = i - statusBarHeight;
    }

    public void vR() {
        if (this.mNavigationBar != null && this.ajo != null && this.ajp != null) {
            this.mNavigationBar.setVisibility(0);
            this.ajo.setVisibility(8);
            this.ajp.setVisibility(0);
            this.ajp.setOnClickListener(this.ajj);
        }
    }

    public boolean vS() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void vT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.ajn != null) {
            al.a(this.ajn, e.f.icon_return_bg_s, e.f.icon_return_bg);
        }
    }

    public boolean vU() {
        try {
            this.ajq.addView(this.ajj.createWebView());
            this.ajr.setVisibility(8);
            if (!this.ajA) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.ajr.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.ajq.getLayoutParams().height = this.ajy;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.ajq.getLayoutParams().height = this.ajz;
        this.mNavigationBar.setVisibility(8);
    }

    public void aQ(boolean z) {
        if (this.ajv != null) {
            if (z) {
                this.ajv.setVisibility(0);
            } else {
                this.ajv.setVisibility(8);
            }
            this.aju.refresh();
        }
    }

    public void aR(boolean z) {
        if (this.ajt != null) {
            if (z) {
                this.ajt.setVisibility(0);
            } else {
                this.ajt.setVisibility(8);
            }
        }
    }

    public boolean vV() {
        return this.ajB;
    }

    public void aS(boolean z) {
        this.ajB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW() {
        if (this.ajC == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.ajj);
            ArrayList arrayList = new ArrayList();
            a.C0320a c0320a = new a.C0320a(this.ajj.getString(e.j.report_text), aVar);
            c0320a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.ajC != null && f.this.ajj != null) {
                        f.this.ajC.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.ajj).createNormalCfg(f.this.ajj.getResources().getString(e.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0320a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.ajC != null) {
                        f.this.ajC.dismiss();
                    }
                }
            });
            aVar.dZ(arrayList);
            this.ajC = new com.baidu.tieba.person.e(this.ajj, aVar.bJU());
            this.ajC.ax(0.7f);
        }
        this.ajC.show();
    }

    public void showPopMenu() {
        this.aju.showWindowInRightBottomOfHost();
    }

    public void dismissPopMenu() {
        g.a(this.aju, this.ajj.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.ajr.setVisibility(0);
    }

    public void hideCrashTip() {
        this.ajr.setVisibility(8);
    }

    public void dE(String str) {
        this.ajl = this.mNavigationBar.setCenterTextTitle(str);
        al.b(this.ajl, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.ajj.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.ax("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.ajj, dVar, true, vX())));
        }
    }

    private SparseArray<String> vX() {
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
            this.mNavigationBar.onChangeSkinType(this.ajj.getPageContext(), i);
        }
        if (this.aju != null) {
            this.aju.onChangeSkinType(this.ajj, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ajj.getPageContext(), i);
        }
        al.a(this.ajn, e.f.icon_topbar_close_n, e.f.icon_topbar_close_s, e.f.icon_topbar_close_n, i);
        al.a(this.ajo, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
        al.a(this.ajp, e.f.icon_home_card_share, e.f.icon_home_card_share, e.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ajq.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ajj.getPageContext().getPageActivity(), this.ajk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aA(null, this.ajj.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ajj.getResources().getString(e.j.refresh), this.ajs)));
        }
        this.mNoDataView.onChangeSkinType(this.ajj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ajq.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void c(View.OnClickListener onClickListener) {
        this.ajs = onClickListener;
    }

    public void release() {
        if (this.ajq != null) {
            this.ajq.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aju != null) {
            g.a(this.aju, this.ajj.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajq.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.ajq.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.ajn, e.f.frs_star_navigation_bg);
        al.i(this.ajo, e.f.frs_star_navigation_bg);
        al.i(this.ajp, e.f.frs_star_navigation_bg);
        dE("");
        this.ajj.getWindow().setFlags(1024, 1024);
    }

    public void vY() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ajq.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.ajq.setLayoutParams(layoutParams);
        this.ajn.setBackgroundDrawable(null);
        this.ajo.setBackgroundDrawable(null);
        this.ajp.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.ajj.getWindow().clearFlags(1024);
    }

    public void aT(boolean z) {
        this.ajA = z;
    }
}
