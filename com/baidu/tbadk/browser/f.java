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
    private TextView abA;
    private View.OnClickListener abB;
    private View abC;
    private MorePopupWindow abD;
    protected View abE;
    private View abF;
    private View abG;
    private int abH;
    private int abI;
    private com.baidu.tieba.person.e abL;
    private BaseWebViewActivity abr;
    private TextView abu;
    private View abv;
    private ImageView abw;
    protected ImageView abx;
    private ImageView aby;
    private LinearLayout abz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View abt = null;
    private ProgressBar mProgressBar = null;
    private boolean abJ = true;
    private boolean abK = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.abr = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.abr.setContentView(d.i.base_webview_activity);
        this.abt = this.abr.findViewById(d.g.root_view);
        if (this.abr.isTranslucent()) {
            am.j(this.abt, this.abr.getResources().getColor(d.C0142d.black_alpha0));
            this.abt.setOnClickListener(this.abr);
        }
        this.mNavigationBar = (NavigationBar) this.abr.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        cY("");
        this.abz = (LinearLayout) this.abr.findViewById(d.g.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abz.setLayoutParams(layoutParams);
        this.abA = (TextView) this.abr.findViewById(d.g.webview_crash_tip);
        this.mProgressBar = (ProgressBar) this.abr.findViewById(d.g.webview_progress);
        this.abv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abr != null) {
                    f.this.abr.finish();
                }
            }
        });
        this.abw = (ImageView) this.abv.findViewById(d.g.widget_navi_back_button);
        this.abw.setContentDescription(this.abr.getResources().getString(d.k.close));
        this.abC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.sK()) {
                    f.this.sL();
                } else if (f.this.aby.getVisibility() != 0) {
                    f.this.sM();
                }
            }
        });
        this.abx = (ImageView) this.abC.findViewById(d.g.widget_navi_more_button);
        this.aby = (ImageView) this.abC.findViewById(d.g.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.abr.getPageContext().getPageActivity()).inflate(d.i.tb_webview_pop_more, (ViewGroup) null);
        this.abD = new MorePopupWindow(this.abr.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.abr.getPageContext().getResources().getDrawable(d.f.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.3
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sQ() {
                f.this.sM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void sR() {
            }
        });
        this.abE = inflate.findViewById(d.g.webview_more_pop_item_share_friend_layout);
        this.abE.setOnClickListener(this.abr);
        if (com.baidu.tbadk.coreExtra.c.e.aX(this.abr.getPageContext().getPageActivity())) {
            this.abE.setVisibility(0);
        } else {
            this.abE.setVisibility(8);
        }
        this.abD.refresh();
        this.abG = inflate.findViewById(d.g.webview_more_pop_item_open_browser_layout);
        this.abG.setOnClickListener(this.abr);
        this.abF = inflate.findViewById(d.g.webview_more_pop_item_copy_link_layout);
        this.abF.setOnClickListener(this.abr);
        sF();
    }

    private void sF() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int e = l.e(this.abr.getPageContext().getPageActivity(), d.e.ds88);
        int i = l.p(this.abr.getPageContext().getPageActivity()).heightPixels;
        this.abH = (i - statusBarHeight) - e;
        this.abI = i - statusBarHeight;
    }

    public void sG() {
        if (this.mNavigationBar != null && this.abx != null && this.aby != null) {
            this.mNavigationBar.setVisibility(0);
            this.abx.setVisibility(8);
            this.aby.setVisibility(0);
            this.aby.setOnClickListener(this.abr);
        }
    }

    public boolean sH() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void sI() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.abw != null) {
            am.a(this.abw, d.f.icon_return_bg_s, d.f.icon_return_bg);
        }
    }

    public boolean sJ() {
        try {
            this.abz.addView(this.abr.createWebView());
            this.abA.setVisibility(8);
            if (!this.abJ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.abA.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.abz.getLayoutParams().height = this.abH;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.abz.getLayoutParams().height = this.abI;
        this.mNavigationBar.setVisibility(8);
    }

    public void aj(boolean z) {
        if (this.abE != null) {
            if (z) {
                this.abE.setVisibility(0);
            } else {
                this.abE.setVisibility(8);
            }
            this.abD.refresh();
        }
    }

    public void ak(boolean z) {
        if (this.abC != null) {
            if (z) {
                this.abC.setVisibility(0);
            } else {
                this.abC.setVisibility(8);
            }
        }
    }

    public boolean sK() {
        return this.abK;
    }

    public void al(boolean z) {
        this.abK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sL() {
        if (this.abL == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.abr);
            ArrayList arrayList = new ArrayList();
            a.C0251a c0251a = new a.C0251a(this.abr.getString(d.k.report_text), aVar);
            c0251a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.4
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.abL != null && f.this.abr != null) {
                        f.this.abL.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(f.this.abr).createNormalCfg(f.this.abr.getResources().getString(d.k.user_feedback), null)));
                    }
                }
            });
            arrayList.add(c0251a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.abL != null) {
                        f.this.abL.dismiss();
                    }
                }
            });
            aVar.dQ(arrayList);
            this.abL = new com.baidu.tieba.person.e(this.abr, aVar.bFF());
            this.abL.aA(0.7f);
        }
        this.abL.show();
    }

    public void sM() {
        this.abD.showWindowInRightBottomOfHost();
    }

    public void sN() {
        g.a(this.abD, this.abr.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showCrashTip() {
        this.abA.setVisibility(0);
    }

    public void hideCrashTip() {
        this.abA.setVisibility(8);
    }

    public void cY(String str) {
        this.abu = this.mNavigationBar.setCenterTextTitle(str);
        am.b(this.abu, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar) {
        if (dVar != null) {
            TiebaStatic.eventStat(this.abr.getPageContext().getPageActivity(), "share", "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.ah("obj_url", dVar.linkUrl);
            TiebaStatic.log(anVar);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.abr, dVar, true, sO())));
        }
    }

    private SparseArray<String> sO() {
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
            this.mNavigationBar.onChangeSkinType(this.abr.getPageContext(), i);
        }
        if (this.abD != null) {
            this.abD.onChangeSkinType(this.abr, i, am.getDrawable(d.f.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.abr.getPageContext(), i);
        }
        am.a(this.abw, d.f.icon_topbar_close_n, d.f.icon_topbar_close_s, d.f.icon_topbar_close_n, i);
        am.a(this.abx, d.f.icon_more_bg_s, d.f.icon_more_bg_s, d.f.icon_more_bg_s, i);
        am.a(this.aby, d.f.icon_home_card_share, d.f.icon_home_card_share, d.f.icon_home_card_share, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.abz.setVisibility(0);
        }
    }

    public void showNoDataView() {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.abr.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT)), NoDataViewFactory.d.aj(null, this.abr.getPageContext().getString(d.k.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.abr.getResources().getString(d.k.refresh), this.abB)));
        }
        this.mNoDataView.onChangeSkinType(this.abr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.abz.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void b(View.OnClickListener onClickListener) {
        this.abB = onClickListener;
    }

    public void release() {
        if (this.abz != null) {
            this.abz.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.abD != null) {
            g.a(this.abD, this.abr.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.abz.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.i(this.abw, d.f.frs_star_navigation_bg);
        am.i(this.abx, d.f.frs_star_navigation_bg);
        am.i(this.aby, d.f.frs_star_navigation_bg);
        cY("");
        this.abr.getWindow().setFlags(1024, 1024);
    }

    public void sP() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.abz.getLayoutParams();
        layoutParams.addRule(3, d.g.view_navigation_bar);
        this.abz.setLayoutParams(layoutParams);
        this.abw.setBackgroundDrawable(null);
        this.abx.setBackgroundDrawable(null);
        this.aby.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.abr.getWindow().clearFlags(1024);
    }

    public void am(boolean z) {
        this.abJ = z;
    }
}
