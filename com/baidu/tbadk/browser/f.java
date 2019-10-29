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
    private BaseWebViewActivity bUV;
    private TextView bUW;
    private View bUX;
    private ImageView bUY;
    private View bUZ;
    private ImageView bVa;
    protected ImageView bVb;
    private ImageView bVc;
    private LinearLayout bVd;
    private TextView bVe;
    private View.OnClickListener bVg;
    private View bVh;
    private MorePopupWindow bVi;
    protected View bVj;
    private View bVk;
    private View bVl;
    private int bVm;
    private int bVn;
    private com.baidu.tieba.person.e bVq;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView bVf = null;
    private boolean bVo = true;
    private boolean bVp = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.bUV = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.bUV.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.bUV.findViewById(R.id.root_view);
        if (this.bUV.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.bUV.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.bUV);
        }
        this.mNavigationBar = (NavigationBar) this.bUV.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        mH("");
        this.bVd = (LinearLayout) this.bUV.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bVd.setLayoutParams(layoutParams);
        this.bVe = (TextView) this.bUV.findViewById(R.id.webview_crash_tip);
        this.bVf = (ContinuousAnimationView) this.bUV.findViewById(R.id.webview_progress);
        this.bUX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bUV != null) {
                    if ((!(f.this.bUV instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.bUV).isDisableGoBack || !((TbWebViewActivity) f.this.bUV).needDealClickGoBack()) && !f.this.bUV.webViewGoBack()) {
                        f.this.bUV.finish();
                    }
                }
            }
        });
        this.bUY = (ImageView) this.bUX.findViewById(R.id.widget_navi_back_button);
        this.bUY.setContentDescription(this.bUV.getResources().getString(R.string.back));
        this.bUZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bUV != null) {
                    f.this.bUV.finish();
                }
            }
        });
        this.bVa = (ImageView) this.bUZ.findViewById(R.id.widget_navi_back_button);
        this.bVa.setContentDescription(this.bUV.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bVa.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.bUV.getPageContext().getPageActivity(), R.dimen.ds4);
        this.bVa.setLayoutParams(layoutParams2);
        this.bVh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.agf()) {
                    f.this.agg();
                } else if (f.this.bVc.getVisibility() != 0) {
                    f.this.ZE();
                }
            }
        });
        this.bVb = (ImageView) this.bVh.findViewById(R.id.widget_navi_more_button);
        this.bVc = (ImageView) this.bVh.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.bUV.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.bVi = new MorePopupWindow(this.bUV.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.bUV.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agj() {
                f.this.ZE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void agk() {
            }
        });
        this.bVj = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.bVj.setOnClickListener(this.bUV);
        if (com.baidu.tbadk.coreExtra.c.f.cv(this.bUV.getPageContext().getPageActivity())) {
            this.bVj.setVisibility(0);
        } else {
            this.bVj.setVisibility(8);
        }
        this.bVi.refresh();
        this.bVl = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.bVl.setOnClickListener(this.bUV);
        this.bVk = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.bVk.setOnClickListener(this.bUV);
        aga();
    }

    private void aga() {
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dimens = l.getDimens(this.bUV.getPageContext().getPageActivity(), R.dimen.ds88);
        int i = l.getScreenSize(this.bUV.getPageContext().getPageActivity()).heightPixels;
        this.bVm = (i - statusBarHeight) - dimens;
        this.bVn = statusBarHeight + i;
    }

    public void agb() {
        if (this.mNavigationBar != null && this.bVb != null && this.bVc != null) {
            this.mNavigationBar.setVisibility(0);
            this.bVb.setVisibility(8);
            this.bVc.setVisibility(0);
            this.bVc.setOnClickListener(this.bUV);
        }
    }

    public void hn(int i) {
        if (this.mNavigationBar != null && this.bVb != null) {
            this.bVb.setVisibility(i);
        }
    }

    public boolean agc() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void agd() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.bVa != null) {
            this.bVa.setVisibility(8);
        }
    }

    public boolean age() {
        try {
            this.bVd.addView(this.bUV.createWebView(), new LinearLayout.LayoutParams(-1, -1));
            this.bVe.setVisibility(8);
            if (!this.bVo) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.bVe.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.bVd.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        if (UtilHelper.hasNavBar(this.bUV)) {
            this.bVd.getLayoutParams().height = this.bVn + UtilHelper.getVirtualBarHeight(this.bUV);
        } else {
            this.bVd.getLayoutParams().height = this.bVn;
        }
        this.mNavigationBar.setVisibility(8);
    }

    public void dR(boolean z) {
        if (this.bVj != null) {
            if (z) {
                this.bVj.setVisibility(0);
            } else {
                this.bVj.setVisibility(8);
            }
            this.bVi.refresh();
        }
    }

    public void dS(boolean z) {
        if (this.bVh != null) {
            if (z) {
                this.bVh.setVisibility(0);
            } else {
                this.bVh.setVisibility(8);
            }
        }
    }

    public boolean agf() {
        return this.bVp;
    }

    public void dT(boolean z) {
        this.bVp = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        if (this.bVq == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.bUV);
            ArrayList arrayList = new ArrayList();
            a.C0537a c0537a = new a.C0537a(this.bUV.getString(R.string.report_text), aVar);
            c0537a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.bVq != null && f.this.bUV != null) {
                        f.this.bVq.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.bUV).createNormalCfg(f.this.bUV.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0537a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.bVq != null) {
                        f.this.bVq.dismiss();
                    }
                }
            });
            aVar.at(arrayList);
            this.bVq = new com.baidu.tieba.person.e(this.bUV, aVar.ale());
            this.bVq.ab(0.7f);
        }
        this.bVq.show();
    }

    public void ZE() {
        this.bVi.showWindowInRightBottomOfHost();
    }

    public void ZF() {
        g.dismissPopupWindow(this.bVi, this.bUV.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.bVf.setVisibility(0);
        this.bVf.playAnimation();
    }

    public void hideProgressBar() {
        this.bVf.setVisibility(8);
        this.bVf.cancelAnimation();
    }

    public void showCrashTip() {
        this.bVe.setVisibility(0);
    }

    public void hideCrashTip() {
        this.bVe.setVisibility(8);
    }

    public void mH(String str) {
        this.bUW = this.mNavigationBar.setCenterTextTitle(str);
        if (this.bUY != null && this.bUY.getVisibility() == 0 && this.bVa != null && this.bVa.getVisibility() == 0) {
            this.bUW.setMaxWidth(l.getDimens(this.bUV.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
        }
        am.setNavbarTitleColor(this.bUW, R.color.cp_cont_b, R.color.s_navbar_title_color);
    }

    public void a(com.baidu.tbadk.coreExtra.c.e eVar) {
        if (eVar != null) {
            TiebaStatic.eventStat(this.bUV.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.bS(TiebaInitialize.Params.OBJ_URL, eVar.linkUrl);
            anVar.O("obj_type", 0);
            TiebaStatic.log(anVar);
            if (eVar.cyC) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.bUV, eVar, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bcj().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.bUV, eVar, true, agh())));
        }
    }

    private SparseArray<String> agh() {
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
            this.mNavigationBar.onChangeSkinType(this.bUV.getPageContext(), i);
        }
        if (this.bVi != null) {
            this.bVi.onChangeSkinType(this.bUV, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bUV.getPageContext(), i);
        }
        SvgManager.amN().a(this.bUY, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.bVa, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.bVb, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.amN().a(this.bVc, R.drawable.icon_pure_topbar_share_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.bVd.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.bUV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.bU(null, this.bUV.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.bUV.getResources().getString(R.string.refresh), this.bVg)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.bUV.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.bUV.getPageContext());
        }
        this.bVd.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void e(View.OnClickListener onClickListener) {
        this.bVg = onClickListener;
    }

    public void release() {
        if (this.bVd != null) {
            this.bVd.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.bVi != null) {
            g.dismissPopupWindow(this.bVi, this.bUV.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.bVd.setLayoutParams(layoutParams);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.showBottomLine(false);
        am.setBackgroundResource(this.bUY, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bVa, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bVb, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.bVc, R.drawable.frs_star_navigation_bg);
        mH("");
        this.bUV.getWindow().setFlags(1024, 1024);
    }

    public void agi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bVd.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.bVd.setLayoutParams(layoutParams);
        this.bUY.setBackgroundDrawable(null);
        this.bVa.setBackgroundDrawable(null);
        this.bVb.setBackgroundDrawable(null);
        this.bVc.setBackgroundDrawable(null);
        this.mNavigationBar.showBottomLine(true);
        this.bUV.getWindow().clearFlags(1024);
    }

    public void dU(boolean z) {
        this.bVo = z;
    }
}
