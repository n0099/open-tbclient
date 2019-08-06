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
    private BaseWebViewActivity bCc;
    private TextView bCd;
    private View bCe;
    private ImageView bCf;
    private View bCg;
    private ImageView bCh;
    protected ImageView bCi;
    private ImageView bCj;
    private LinearLayout bCk;
    private TextView bCl;
    private View.OnClickListener bCn;
    private View bCo;
    private MorePopupWindow bCp;
    protected View bCq;
    private View bCr;
    private View bCs;
    private int bCt;
    private int bCu;
    private com.baidu.tieba.person.e bCx;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView bCm = null;
    private boolean bCv = true;
    private boolean bCw = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bCc = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bCc.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.bCc.findViewById(R.id.root_view);
        if (this.bCc.isTranslucent()) {
            am.l(this.mRoot, this.bCc.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.bCc);
        }
        this.mNavigationBar = (NavigationBar) this.bCc.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        me("");
        this.bCk = (LinearLayout) this.bCc.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCk.setLayoutParams(layoutParams);
        this.bCl = (TextView) this.bCc.findViewById(R.id.webview_crash_tip);
        this.bCm = (ContinuousAnimationView) this.bCc.findViewById(R.id.webview_progress);
        this.bCe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bCc != null) {
                    if ((!(f.this.bCc instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bCc).isDisableGoBack || !((TbWebViewActivity) f.this.bCc).needDealClickGoBack()) && !f.this.bCc.webViewGoBack()) {
                        f.this.bCc.finish();
                    }
                }
            }
        });
        this.bCf = (ImageView) this.bCe.findViewById(R.id.widget_navi_back_button);
        this.bCf.setContentDescription(this.bCc.getResources().getString(R.string.back));
        this.bCg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bCc != null) {
                    f.this.bCc.finish();
                }
            }
        });
        this.bCh = (ImageView) this.bCg.findViewById(R.id.widget_navi_back_button);
        this.bCh.setContentDescription(this.bCc.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bCh.getLayoutParams();
        layoutParams2.leftMargin = l.g(this.bCc.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bCh.setLayoutParams(layoutParams2);
        this.bCo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.abv()) {
                    f.this.abw();
                } else if (f.this.bCj.getVisibility() != 0) {
                    f.this.UL();
                }
            }
        });
        this.bCi = (ImageView) this.bCo.findViewById(R.id.widget_navi_more_button);
        this.bCj = (ImageView) this.bCo.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bCc.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bCp = new MorePopupWindow(this.bCc.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bCc.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abz() {
                f.this.UL();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void abA() {
            }
        });
        this.bCq = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bCq.setOnClickListener(this.bCc);
        if (com.baidu.tbadk.coreExtra.c.f.cJ(this.bCc.getPageContext().getPageActivity())) {
            this.bCq.setVisibility(0);
        } else {
            this.bCq.setVisibility(8);
        }
        this.bCp.refresh();
        this.bCs = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bCs.setOnClickListener(this.bCc);
        this.bCr = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bCr.setOnClickListener(this.bCc);
        abq();
    }

    private void abq() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int g = l.g(this.bCc.getPageContext().getPageActivity(), R.dimen.ds88);
        int i = l.v(this.bCc.getPageContext().getPageActivity()).heightPixels;
        this.bCt = (i - statusBarHeight) - g;
        this.bCu = statusBarHeight + i;
    }

    public void abr() {
        if (this.mNavigationBar != null && this.bCi != null && this.bCj != null) {
            this.mNavigationBar.setVisibility(0);
            this.bCi.setVisibility(8);
            this.bCj.setVisibility(0);
            this.bCj.setOnClickListener(this.bCc);
        }
    }

    public void gr(int i) {
        if (this.mNavigationBar != null && this.bCi != null) {
            this.bCi.setVisibility(i);
        }
    }

    public boolean abs() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void abt() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bCh != null) {
            this.bCh.setVisibility(8);
        }
    }

    public boolean abu() {
        try {
            this.bCk.addView(this.bCc.createWebView(), new LinearLayout.LayoutParams(-1, -1));
            this.bCl.setVisibility(8);
            if (!this.bCv) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bCl.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bCk.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        if (UtilHelper.hasNavBar(this.bCc)) {
            this.bCk.getLayoutParams().height = this.bCu + UtilHelper.getVirtualBarHeight(this.bCc);
        } else {
            this.bCk.getLayoutParams().height = this.bCu;
        }
        this.mNavigationBar.setVisibility(8);
    }

    public void dA(boolean z) {
        if (this.bCq != null) {
            if (z) {
                this.bCq.setVisibility(0);
            } else {
                this.bCq.setVisibility(8);
            }
            this.bCp.refresh();
        }
    }

    public void dB(boolean z) {
        if (this.bCo != null) {
            if (z) {
                this.bCo.setVisibility(0);
            } else {
                this.bCo.setVisibility(8);
            }
        }
    }

    public boolean abv() {
        return this.bCw;
    }

    public void dC(boolean z) {
        this.bCw = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        if (this.bCx == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bCc);
            ArrayList arrayList = new ArrayList();
            a.C0431a c0431a = new a.C0431a(this.bCc.getString(R.string.report_text), aVar);
            c0431a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bCx != null && f.this.bCc != null) {
                        f.this.bCx.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bCc).createNormalCfg(f.this.bCc.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0431a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bCx != null) {
                        f.this.bCx.dismiss();
                    }
                }
            });
            aVar.W(arrayList);
            this.bCx = new com.baidu.tieba.person.e(this.bCc, aVar.ahd());
            this.bCx.an(0.7f);
        }
        this.bCx.show();
    }

    public void UL() {
        this.bCp.showWindowInRightBottomOfHost();
    }

    public void UM() {
        g.a(this.bCp, this.bCc.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bCm.setVisibility(0);
        this.bCm.br();
    }

    public void hideProgressBar() {
        this.bCm.setVisibility(8);
        this.bCm.cancelAnimation();
    }

    public void showCrashTip() {
        this.bCl.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bCl.setVisibility(8);
    }

    public void me(String str) {
        this.bCd = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bCf != null && this.bCf.getVisibility() == 0 && this.bCh != null && this.bCh.getVisibility() == 0) {
            this.bCd.setMaxWidth(l.g(this.bCc.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.e(this.bCd, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.bCc.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an("c10898");
            anVar.bT("obj_url", eVar.linkUrl);
            anVar.P("obj_type", 0);
            TiebaStatic.log(anVar);
            if (eVar.ckH) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.bCc, eVar, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bbD().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, new ShareDialogConfig((Context) this.bCc, eVar, true, abx())));
        }
    }

    private SparseArray<String> abx() {
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
            this.mNavigationBar.onChangeSkinType(this.bCc.getPageContext(), i);
        }
        if (this.bCp != null) {
            this.bCp.onChangeSkinType(this.bCc, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCc.getPageContext(), i);
        }
        am.a(this.bCf, (int) R.drawable.selector_web_topbar_return_black, (int) R.drawable.selector_web_topbar_return_white, i);
        am.a(this.bCh, (int) R.drawable.selector_web_topbar_close_black, (int) R.drawable.selector_web_topbar_close_white, i);
        am.a(this.bCi, (int) R.drawable.selector_web_topbar_more_black, (int) R.drawable.selector_web_topbar_more_white, i);
        am.a(this.bCj, (int) R.drawable.selector_web_topbar_share_black, (int) R.drawable.selector_web_topbar_share_white, i);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bCk.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bCc.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bX(null, this.bCc.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bCc.getResources().getString(R.string.refresh), this.bCn)));
        }
        if (!j.jQ()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bCc.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bCc.getPageContext());
        }
        this.bCk.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void d(View.OnClickListener onClickListener) {
        this.bCn = onClickListener;
    }

    public void release() {
        if (this.bCk != null) {
            this.bCk.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bCp != null) {
            g.a(this.bCp, this.bCc.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bCk.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.k(this.bCf, R.drawable.frs_star_navigation_bg);
        am.k(this.bCh, R.drawable.frs_star_navigation_bg);
        am.k(this.bCi, R.drawable.frs_star_navigation_bg);
        am.k(this.bCj, R.drawable.frs_star_navigation_bg);
        me("");
        this.bCc.getWindow().setFlags(1024, 1024);
    }

    public void aby() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bCk.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bCk.setLayoutParams(layoutParams);
        this.bCf.setBackgroundDrawable(null);
        this.bCh.setBackgroundDrawable(null);
        this.bCi.setBackgroundDrawable(null);
        this.bCj.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bCc.getWindow().clearFlags(1024);
    }

    public void dD(boolean z) {
        this.bCv = z;
    }
}
