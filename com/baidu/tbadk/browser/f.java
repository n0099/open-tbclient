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
    private ImageView aiA;
    protected ImageView aiB;
    private ImageView aiC;
    private LinearLayout aiD;
    private TextView aiE;
    private View.OnClickListener aiF;
    private View aiG;
    private MorePopupWindow aiH;
    protected View aiI;
    private View aiJ;
    private View aiK;
    private int aiL;
    private int aiM;
    private com.baidu.tieba.person.e aiP;
    private BaseWebViewActivity aiw;
    private TextView aiy;
    private View aiz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View aix = null;
    private ProgressBar mProgressBar = null;
    private boolean aiN = true;
    private boolean aiO = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.aiw = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.aiw.setContentView(e.h.base_webview_activity);
        this.aix = this.aiw.findViewById(e.g.root_view);
        if (this.aiw.isTranslucent()) {
            al.j(this.aix, this.aiw.getResources().getColor(e.d.black_alpha0));
            this.aix.setOnClickListener(this.aiw);
        }
        this.mNavigationBar = (NavigationBar) this.aiw.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        dE("");
        this.aiD = (LinearLayout) this.aiw.findViewById(e.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.aiD.setLayoutParams(layoutParams);
        this.aiE = (TextView) this.aiw.findViewById(e.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.aiw.findViewById(e.g.webview_progress);
        this.aiz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aiw != null) {
                    f.this.aiw.finish();
                }
            }
        });
        this.aiA = (ImageView) this.aiz.findViewById(e.g.widget_navi_back_button);
        this.aiA.setContentDescription(this.aiw.getResources().getString(e.j.close));
        this.aiG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.vL()) {
                    f.this.vM();
                } else if (f.this.aiC.getVisibility() != 0) {
                    f.this.vN();
                }
            }
        });
        this.aiB = (ImageView) this.aiG.findViewById(e.g.widget_navi_more_button);
        this.aiC = (ImageView) this.aiG.findViewById(e.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.aiw.getPageContext().getPageActivity()).inflate(e.h.tb_webview_pop_more, (ViewGroup) null);
        this.aiH = new MorePopupWindow(this.aiw.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.aiw.getPageContext().getResources().getDrawable(e.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void vR() {
                f.this.vN();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void vS() {
            }
        });
        this.aiI = inflate.findViewById(e.g.webview_more_pop_item_share_friend_layout);
        this.aiI.setOnClickListener(this.aiw);
        if (com.baidu.tbadk.coreExtra.c.e.bL(this.aiw.getPageContext().getPageActivity())) {
            this.aiI.setVisibility(0);
        } else {
            this.aiI.setVisibility(8);
        }
        this.aiH.refresh();
        this.aiK = inflate.findViewById(e.g.webview_more_pop_item_open_browser_layout);
        this.aiK.setOnClickListener(this.aiw);
        this.aiJ = inflate.findViewById(e.g.webview_more_pop_item_copy_link_layout);
        this.aiJ.setOnClickListener(this.aiw);
        vG();
    }

    private void vG() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int h = l.h(this.aiw.getPageContext().getPageActivity(), e.C0175e.ds88);
        int i = l.s(this.aiw.getPageContext().getPageActivity()).heightPixels;
        this.aiL = (i - statusBarHeight) - h;
        this.aiM = i - statusBarHeight;
    }

    public void vH() {
        if (this.mNavigationBar != null && this.aiB != null && this.aiC != null) {
            this.mNavigationBar.setVisibility(0);
            this.aiB.setVisibility(8);
            this.aiC.setVisibility(0);
            this.aiC.setOnClickListener(this.aiw);
        }
    }

    public boolean vI() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void vJ() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.aiA != null) {
            al.a(this.aiA, e.f.icon_return_bg_s, e.f.icon_return_bg);
        }
    }

    public boolean vK() {
        try {
            this.aiD.addView(this.aiw.createWebView());
            this.aiE.setVisibility(8);
            if (!this.aiN) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.aiE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.aiD.getLayoutParams().height = this.aiL;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.aiD.getLayoutParams().height = this.aiM;
        this.mNavigationBar.setVisibility(8);
    }

    public void aA(boolean z) {
        if (this.aiI != null) {
            if (z) {
                this.aiI.setVisibility(0);
            } else {
                this.aiI.setVisibility(8);
            }
            this.aiH.refresh();
        }
    }

    public void aB(boolean z) {
        if (this.aiG != null) {
            if (z) {
                this.aiG.setVisibility(0);
            } else {
                this.aiG.setVisibility(8);
            }
        }
    }

    public boolean vL() {
        return this.aiO;
    }

    public void aC(boolean z) {
        this.aiO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vM() {
        if (this.aiP == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.aiw);
            ArrayList arrayList = new ArrayList();
            a.C0292a c0292a = new a.C0292a(this.aiw.getString(e.j.report_text), aVar);
            c0292a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.aiP != null && f.this.aiw != null) {
                        f.this.aiP.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.aiw).createNormalCfg(f.this.aiw.getResources().getString(e.j.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0292a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.aiP != null) {
                        f.this.aiP.dismiss();
                    }
                }
            });
            aVar.eb(arrayList);
            this.aiP = new com.baidu.tieba.person.e(this.aiw, aVar.bKv());
            this.aiP.av(0.7f);
        }
        this.aiP.show();
    }

    public void vN() {
        this.aiH.showWindowInRightBottomOfHost();
    }

    public void vO() {
        g.a(this.aiH, this.aiw.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.aiE.setVisibility(0);
    }

    public void hideCrashTip() {
        this.aiE.setVisibility(8);
    }

    public void dE(String str) {
        this.aiy = this.mNavigationBar.setCenterTextTitle(str);
        al.b(this.aiy, e.d.cp_cont_b, e.d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.aiw.getPageContext().getPageActivity(), "share", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            am amVar = new am("c10898");
            amVar.ax("obj_url", dVar.linkUrl);
            TiebaStatic.log(amVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.aiw, dVar, true, vP())));
        }
    }

    private SparseArray<String> vP() {
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
            this.mNavigationBar.onChangeSkinType(this.aiw.getPageContext(), i);
        }
        if (this.aiH != null) {
            this.aiH.onChangeSkinType(this.aiw, i, al.getDrawable(e.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aiw.getPageContext(), i);
        }
        al.a(this.aiA, e.f.icon_topbar_close_n, e.f.icon_topbar_close_s, e.f.icon_topbar_close_n, i);
        al.a(this.aiB, e.f.icon_more_bg_s, e.f.icon_more_bg_s, e.f.icon_more_bg_s, i);
        al.a(this.aiC, e.f.icon_home_card_share, e.f.icon_home_card_share, e.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.aiD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.aiw.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aA(null, this.aiw.getPageContext().getString(e.j.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aiw.getResources().getString(e.j.refresh), this.aiF)));
        }
        this.mNoDataView.onChangeSkinType(this.aiw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.aiD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.aiF = onClickListener;
    }

    public void release() {
        if (this.aiD != null) {
            this.aiD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aiH != null) {
            g.a(this.aiH, this.aiw.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.aiD.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        al.i(this.aiA, e.f.frs_star_navigation_bg);
        al.i(this.aiB, e.f.frs_star_navigation_bg);
        al.i(this.aiC, e.f.frs_star_navigation_bg);
        dE("");
        this.aiw.getWindow().setFlags(1024, 1024);
    }

    public void vQ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiD.getLayoutParams();
        layoutParams.addRule(3, e.g.view_navigation_bar);
        this.aiD.setLayoutParams(layoutParams);
        this.aiA.setBackgroundDrawable(null);
        this.aiB.setBackgroundDrawable(null);
        this.aiC.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.aiw.getWindow().clearFlags(1024);
    }

    public void aD(boolean z) {
        this.aiN = z;
    }
}
