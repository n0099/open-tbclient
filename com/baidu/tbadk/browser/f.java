package com.baidu.tbadk.browser;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
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
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BaseWebViewActivity bCA;
    private TextView bCB;
    private View bCC;
    private ImageView bCD;
    private View bCE;
    private ImageView bCF;
    protected ImageView bCG;
    private ImageView bCH;
    private LinearLayout bCI;
    private TextView bCJ;
    private View.OnClickListener bCL;
    private View bCM;
    private MorePopupWindow bCN;
    protected View bCO;
    private View bCP;
    private View bCQ;
    private int bCR;
    private int bCS;
    private com.baidu.tieba.person.e bCV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView bCK = null;
    private boolean bCT = true;
    private boolean bCU = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bCA = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bCA.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.bCA.findViewById(R.id.root_view);
        if (this.bCA.isTranslucent()) {
            am.l(this.mRoot, this.bCA.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.bCA);
        }
        this.mNavigationBar = (NavigationBar) this.bCA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        mg("");
        this.bCI = (LinearLayout) this.bCA.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCI.setLayoutParams(layoutParams);
        this.bCJ = (TextView) this.bCA.findViewById(R.id.webview_crash_tip);
        this.bCK = (ContinuousAnimationView) this.bCA.findViewById(R.id.webview_progress);
        this.bCC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bCA != null) {
                    if ((!(f.this.bCA instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bCA).isDisableGoBack || !((TbWebViewActivity) f.this.bCA).needDealClickGoBack()) && !f.this.bCA.webViewGoBack()) {
                        f.this.bCA.finish();
                    }
                }
            }
        });
        this.bCD = (ImageView) this.bCC.findViewById(R.id.widget_navi_back_button);
        this.bCD.setContentDescription(this.bCA.getResources().getString(R.string.back));
        this.bCE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bCA != null) {
                    f.this.bCA.finish();
                }
            }
        });
        this.bCF = (ImageView) this.bCE.findViewById(R.id.widget_navi_back_button);
        this.bCF.setContentDescription(this.bCA.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCF.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.bCA.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bCF.setLayoutParams(layoutParams2);
        this.bCM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abz()) {
                    f.this.abA();
                } else if (f.this.bCH.getVisibility() != 0) {
                    f.this.UP();
                }
            }
        });
        this.bCG = (ImageView) this.bCM.findViewById(R.id.widget_navi_more_button);
        this.bCH = (ImageView) this.bCM.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bCA.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bCN = new MorePopupWindow(this.bCA.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bCA.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abD() {
                f.this.UP();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abE() {
            }
        });
        this.bCO = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bCO.setOnClickListener(this.bCA);
        if (com.baidu.tbadk.coreExtra.c.f.cJ(this.bCA.getPageContext().getPageActivity())) {
            this.bCO.setVisibility(0);
        } else {
            this.bCO.setVisibility(8);
        }
        this.bCN.refresh();
        this.bCQ = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bCQ.setOnClickListener(this.bCA);
        this.bCP = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bCP.setOnClickListener(this.bCA);
        abu();
    }

    private void abu() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.bCA.getPageContext().getPageActivity(), R.dimen.ds88);
        int i = l.v(this.bCA.getPageContext().getPageActivity()).heightPixels;
        this.bCR = (i - statusBarHeight) - g;
        this.bCS = statusBarHeight + i;
    }

    public void abv() {
        if (this.mNavigationBar != null && this.bCG != null && this.bCH != null) {
            this.mNavigationBar.setVisibility(0);
            this.bCG.setVisibility(8);
            this.bCH.setVisibility(0);
            this.bCH.setOnClickListener(this.bCA);
        }
    }

    public void gs(int i) {
        if (this.mNavigationBar != null && this.bCG != null) {
            this.bCG.setVisibility(i);
        }
    }

    public boolean abw() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void abx() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bCF != null) {
            this.bCF.setVisibility(8);
        }
    }

    public boolean aby() {
        try {
            this.bCI.addView(this.bCA.createWebView(), new LinearLayout.LayoutParams(-1, -1));
            this.bCJ.setVisibility(8);
            if (!this.bCT) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bCJ.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bCI.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        if (UtilHelper.hasNavBar(this.bCA)) {
            this.bCI.getLayoutParams().height = this.bCS + UtilHelper.getVirtualBarHeight(this.bCA);
        } else {
            this.bCI.getLayoutParams().height = this.bCS;
        }
        this.mNavigationBar.setVisibility(8);
    }

    public void dA(boolean z) {
        if (this.bCO != null) {
            if (z) {
                this.bCO.setVisibility(0);
            } else {
                this.bCO.setVisibility(8);
            }
            this.bCN.refresh();
        }
    }

    public void dB(boolean z) {
        if (this.bCM != null) {
            if (z) {
                this.bCM.setVisibility(0);
            } else {
                this.bCM.setVisibility(8);
            }
        }
    }

    public boolean abz() {
        return this.bCU;
    }

    public void dC(boolean z) {
        this.bCU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abA() {
        if (this.bCV == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bCA);
            ArrayList arrayList = new ArrayList();
            a.C0442a c0442a = new a.C0442a(this.bCA.getString(R.string.report_text), aVar);
            c0442a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bCV != null && f.this.bCA != null) {
                        f.this.bCV.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bCA).createNormalCfg(f.this.bCA.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0442a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bCV != null) {
                        f.this.bCV.dismiss();
                    }
                }
            });
            aVar.W(arrayList);
            this.bCV = new com.baidu.tieba.person.e(this.bCA, aVar.ahh());
            this.bCV.an(0.7f);
        }
        this.bCV.show();
    }

    public void UP() {
        this.bCN.showWindowInRightBottomOfHost();
    }

    public void UQ() {
        g.a(this.bCN, this.bCA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bCK.setVisibility(0);
        this.bCK.br();
    }

    public void hideProgressBar() {
        this.bCK.setVisibility(8);
        this.bCK.cancelAnimation();
    }

    public void showCrashTip() {
        this.bCJ.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bCJ.setVisibility(8);
    }

    public void mg(String str) {
        this.bCB = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bCD != null && this.bCD.getVisibility() == 0 && this.bCF != null && this.bCF.getVisibility() == 0) {
            this.bCB.setMaxWidth(l.g(this.bCA.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.e(this.bCB, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.bCA.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.bT("obj_url", eVar.linkUrl);
            anVar.P("obj_type", 0);
            TiebaStatic.log(anVar);
            if (eVar.clC) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.bCA, eVar, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bch().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bCA, eVar, true, abB())));
        }
    }

    private SparseArray<String> abB() {
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
            this.mNavigationBar.onChangeSkinType(this.bCA.getPageContext(), i);
        }
        if (this.bCN != null) {
            this.bCN.onChangeSkinType(this.bCA, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCA.getPageContext(), i);
        }
        SvgManager.ajv().a(this.bCD, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.bCF, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.bCG, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.ajv().a(this.bCH, R.drawable.icon_pure_topbar_share_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bCI.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bCA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bX(null, this.bCA.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bCA.getResources().getString(R.string.refresh), this.bCL)));
        }
        if (!j.jQ()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bCA.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bCA.getPageContext());
        }
        this.bCI.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCL = onClickListener;
    }

    public void release() {
        if (this.bCI != null) {
            this.bCI.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bCN != null) {
            g.a(this.bCN, this.bCA.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bCI.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.k(this.bCD, R.drawable.frs_star_navigation_bg);
        am.k(this.bCF, R.drawable.frs_star_navigation_bg);
        am.k(this.bCG, R.drawable.frs_star_navigation_bg);
        am.k(this.bCH, R.drawable.frs_star_navigation_bg);
        mg("");
        this.bCA.getWindow().setFlags(1024, 1024);
    }

    public void abC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCI.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCI.setLayoutParams(layoutParams);
        this.bCD.setBackgroundDrawable(null);
        this.bCF.setBackgroundDrawable(null);
        this.bCG.setBackgroundDrawable(null);
        this.bCH.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bCA.getWindow().clearFlags(1024);
    }

    public void dD(boolean z) {
        this.bCT = z;
    }
}
