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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private BaseWebViewActivity bUe;
    private TextView bUf;
    private View bUg;
    private ImageView bUh;
    private View bUi;
    private ImageView bUj;
    protected ImageView bUk;
    private ImageView bUl;
    private LinearLayout bUm;
    private TextView bUn;
    private View.OnClickListener bUp;
    private View bUq;
    private MorePopupWindow bUr;
    protected View bUs;
    private View bUt;
    private View bUu;
    private int bUv;
    private int bUw;
    private com.baidu.tieba.person.e bUz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView bUo = null;
    private boolean bUx = true;
    private boolean bUy = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bUe = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bUe.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.bUe.findViewById(R.id.root_view);
        if (this.bUe.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.bUe.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.bUe);
        }
        this.mNavigationBar = (NavigationBar) this.bUe.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        mH("");
        this.bUm = (LinearLayout) this.bUe.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bUm.setLayoutParams(layoutParams);
        this.bUn = (TextView) this.bUe.findViewById(R.id.webview_crash_tip);
        this.bUo = (ContinuousAnimationView) this.bUe.findViewById(R.id.webview_progress);
        this.bUg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bUe != null) {
                    if ((!(f.this.bUe instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bUe).isDisableGoBack || !((TbWebViewActivity) f.this.bUe).needDealClickGoBack()) && !f.this.bUe.webViewGoBack()) {
                        f.this.bUe.finish();
                    }
                }
            }
        });
        this.bUh = (ImageView) this.bUg.findViewById(R.id.widget_navi_back_button);
        this.bUh.setContentDescription(this.bUe.getResources().getString(R.string.back));
        this.bUi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bUe != null) {
                    f.this.bUe.finish();
                }
            }
        });
        this.bUj = (ImageView) this.bUi.findViewById(R.id.widget_navi_back_button);
        this.bUj.setContentDescription(this.bUe.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bUj.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.bUe.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bUj.setLayoutParams(layoutParams2);
        this.bUq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.agd()) {
                    f.this.age();
                } else if (f.this.bUl.getVisibility() != 0) {
                    f.this.ZC();
                }
            }
        });
        this.bUk = (ImageView) this.bUq.findViewById(R.id.widget_navi_more_button);
        this.bUl = (ImageView) this.bUq.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bUe.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bUr = new MorePopupWindow(this.bUe.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bUe.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agh() {
                f.this.ZC();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agi() {
            }
        });
        this.bUs = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bUs.setOnClickListener(this.bUe);
        if (com.baidu.tbadk.coreExtra.c.f.cv(this.bUe.getPageContext().getPageActivity())) {
            this.bUs.setVisibility(0);
        } else {
            this.bUs.setVisibility(8);
        }
        this.bUr.refresh();
        this.bUu = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bUu.setOnClickListener(this.bUe);
        this.bUt = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bUt.setOnClickListener(this.bUe);
        afY();
    }

    private void afY() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.bUe.getPageContext().getPageActivity(), R.dimen.ds88);
        int i = l.getScreenSize(this.bUe.getPageContext().getPageActivity()).heightPixels;
        this.bUv = (i - statusBarHeight) - dimens;
        this.bUw = statusBarHeight + i;
    }

    public void afZ() {
        if (this.mNavigationBar != null && this.bUk != null && this.bUl != null) {
            this.mNavigationBar.setVisibility(0);
            this.bUk.setVisibility(8);
            this.bUl.setVisibility(0);
            this.bUl.setOnClickListener(this.bUe);
        }
    }

    public void hm(int i) {
        if (this.mNavigationBar != null && this.bUk != null) {
            this.bUk.setVisibility(i);
        }
    }

    public boolean aga() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void agb() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bUj != null) {
            this.bUj.setVisibility(8);
        }
    }

    public boolean agc() {
        try {
            this.bUm.addView(this.bUe.createWebView(), new LinearLayout.LayoutParams(-1, -1));
            this.bUn.setVisibility(8);
            if (!this.bUx) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bUn.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bUm.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        if (UtilHelper.hasNavBar(this.bUe)) {
            this.bUm.getLayoutParams().height = this.bUw + UtilHelper.getVirtualBarHeight(this.bUe);
        } else {
            this.bUm.getLayoutParams().height = this.bUw;
        }
        this.mNavigationBar.setVisibility(8);
    }

    public void dR(boolean z) {
        if (this.bUs != null) {
            if (z) {
                this.bUs.setVisibility(0);
            } else {
                this.bUs.setVisibility(8);
            }
            this.bUr.refresh();
        }
    }

    public void dS(boolean z) {
        if (this.bUq != null) {
            if (z) {
                this.bUq.setVisibility(0);
            } else {
                this.bUq.setVisibility(8);
            }
        }
    }

    public boolean agd() {
        return this.bUy;
    }

    public void dT(boolean z) {
        this.bUy = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void age() {
        if (this.bUz == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bUe);
            ArrayList arrayList = new ArrayList();
            a.C0532a c0532a = new a.C0532a(this.bUe.getString(R.string.report_text), aVar);
            c0532a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bUz != null && f.this.bUe != null) {
                        f.this.bUz.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bUe).createNormalCfg(f.this.bUe.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0532a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bUz != null) {
                        f.this.bUz.dismiss();
                    }
                }
            });
            aVar.at(arrayList);
            this.bUz = new com.baidu.tieba.person.e(this.bUe, aVar.alc());
            this.bUz.ab(0.7f);
        }
        this.bUz.show();
    }

    public void ZC() {
        this.bUr.showWindowInRightBottomOfHost();
    }

    public void ZD() {
        g.dismissPopupWindow(this.bUr, this.bUe.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bUo.setVisibility(0);
        this.bUo.playAnimation();
    }

    public void hideProgressBar() {
        this.bUo.setVisibility(8);
        this.bUo.cancelAnimation();
    }

    public void showCrashTip() {
        this.bUn.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bUn.setVisibility(8);
    }

    public void mH(String str) {
        this.bUf = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bUh != null && this.bUh.getVisibility() == 0 && this.bUj != null && this.bUj.getVisibility() == 0) {
            this.bUf.setMaxWidth(l.getDimens(this.bUe.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.bUf, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.bUe.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
            anVar.O("obj_type", 0);
            TiebaStatic.log(anVar);
            if (eVar.cxL) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.bUe, eVar, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bch().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.bUe, eVar, true, agf())));
        }
    }

    private SparseArray<String> agf() {
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
            this.mNavigationBar.onChangeSkinType(this.bUe.getPageContext(), i);
        }
        if (this.bUr != null) {
            this.bUr.onChangeSkinType(this.bUe, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bUe.getPageContext(), i);
        }
        SvgManager.amL().a(this.bUh, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.bUj, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.bUk, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amL().a(this.bUl, R.drawable.icon_pure_topbar_share_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bUm.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bUe.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bU(null, this.bUe.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bUe.getResources().getString(R.string.refresh), this.bUp)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bUe.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bUe.getPageContext());
        }
        this.bUm.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bUp = onClickListener;
    }

    public void release() {
        if (this.bUm != null) {
            this.bUm.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bUr != null) {
            g.dismissPopupWindow(this.bUr, this.bUe.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bUm.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.bUh, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bUj, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bUk, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bUl, R.drawable.frs_star_navigation_bg);
        mH("");
        this.bUe.getWindow().setFlags(1024, 1024);
    }

    public void agg() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUm.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bUm.setLayoutParams(layoutParams);
        this.bUh.setBackgroundDrawable(null);
        this.bUj.setBackgroundDrawable(null);
        this.bUk.setBackgroundDrawable(null);
        this.bUl.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bUe.getWindow().clearFlags(1024);
    }

    public void dU(boolean z) {
        this.bUx = z;
    }
}
