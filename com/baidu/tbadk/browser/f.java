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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    protected ImageView KA;
    private BaseWebViewActivity cGA;
    private TextView cGB;
    private View cGC;
    private ImageView cGD;
    private ImageView cGE;
    private ImageView cGF;
    private LinearLayout cGG;
    private TextView cGH;
    private View.OnClickListener cGJ;
    private View cGK;
    private MorePopupWindow cGL;
    protected View cGM;
    private View cGN;
    private View cGO;
    private com.baidu.tieba.person.e cGR;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cGI = null;
    private boolean cGP = true;
    private boolean cGQ = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cGA = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cGA.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cGA.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cGA.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        rV("");
        if (this.cGA.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cGA.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cGA);
            this.mNavigationBar.setVisibility(8);
        }
        this.cGG = (LinearLayout) this.cGA.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGG.setLayoutParams(layoutParams);
        this.cGH = (TextView) this.cGA.findViewById(R.id.webview_crash_tip);
        this.cGI = (ContinuousAnimationView) this.cGA.findViewById(R.id.webview_progress);
        this.cGI.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cGC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cGA != null) {
                    if ((!(f.this.cGA instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cGA).isDisableGoBack || !((TbWebViewActivity) f.this.cGA).needDealClickGoBack()) && !f.this.cGA.webViewGoBack()) {
                        f.this.cGA.finish();
                    }
                }
            }
        });
        this.cGD = (ImageView) this.cGC.findViewById(R.id.widget_navi_back_button);
        this.cGD.setContentDescription(this.cGA.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cGA != null) {
                    f.this.cGA.finish();
                }
            }
        });
        this.cGE = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cGE.setContentDescription(this.cGA.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGE.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cGA.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cGE.setLayoutParams(layoutParams2);
        this.cGK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.awV()) {
                    f.this.awW();
                } else if (f.this.cGF.getVisibility() != 0) {
                    f.this.apl();
                }
            }
        });
        this.KA = (ImageView) this.cGK.findViewById(R.id.widget_navi_more_button);
        this.cGF = (ImageView) this.cGK.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cGA.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cGL = new MorePopupWindow(this.cGA.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cGA.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void awZ() {
                f.this.apl();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void axa() {
            }
        });
        this.cGM = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cGM.setOnClickListener(this.cGA);
        if (com.baidu.tbadk.coreExtra.share.e.dQ(this.cGA.getPageContext().getPageActivity())) {
            this.cGM.setVisibility(0);
        } else {
            this.cGM.setVisibility(8);
        }
        this.cGL.refresh();
        this.cGO = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cGO.setOnClickListener(this.cGA);
        this.cGN = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cGN.setOnClickListener(this.cGA);
    }

    public void awR() {
        if (this.mNavigationBar != null && this.KA != null && this.cGF != null) {
            this.KA.setVisibility(8);
            this.cGF.setVisibility(0);
            this.cGF.setOnClickListener(this.cGA);
        }
    }

    public void iX(int i) {
        if (this.mNavigationBar != null && this.KA != null) {
            this.KA.setVisibility(i);
        }
    }

    public boolean awS() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void awT() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cGE != null) {
            this.cGE.setVisibility(8);
        }
    }

    public boolean awU() {
        try {
            this.cGG.addView(this.cGA.createWebView());
            this.cGH.setVisibility(8);
            if (!this.cGP) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cGH.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cGG.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cGG.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fd(boolean z) {
        if (this.cGM != null) {
            if (z) {
                this.cGM.setVisibility(0);
            } else {
                this.cGM.setVisibility(8);
            }
            this.cGL.refresh();
        }
    }

    public void fe(boolean z) {
        if (this.cGK != null) {
            if (z) {
                this.cGK.setVisibility(0);
            } else {
                this.cGK.setVisibility(8);
            }
        }
    }

    public boolean awV() {
        return this.cGQ;
    }

    public void ff(boolean z) {
        this.cGQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awW() {
        if (this.cGR == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cGA);
            ArrayList arrayList = new ArrayList();
            a.C0616a c0616a = new a.C0616a(this.cGA.getString(R.string.report_text), aVar);
            c0616a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cGR != null && f.this.cGA != null) {
                        f.this.cGR.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cGA).createNormalCfg(f.this.cGA.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cGA.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0616a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cGR != null) {
                        f.this.cGR.dismiss();
                    }
                }
            });
            aVar.aA(arrayList);
            this.cGR = new com.baidu.tieba.person.e(this.cGA, aVar.aCm());
            this.cGR.ag(0.7f);
        }
        this.cGR.show();
    }

    public void apl() {
        this.cGL.showWindowInRightBottomOfHost();
    }

    public void apm() {
        g.dismissPopupWindow(this.cGL, this.cGA.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cGI.setVisibility(0);
        this.cGI.playAnimation();
    }

    public void hideProgressBar() {
        this.cGI.setVisibility(8);
        this.cGI.cancelAnimation();
    }

    public void showCrashTip() {
        this.cGH.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cGH.setVisibility(8);
    }

    public void rV(String str) {
        if (this.mNavigationBar != null) {
            this.cGB = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cGD != null && this.cGD.getVisibility() == 0 && this.cGE != null && this.cGE.getVisibility() == 0) {
                this.cGB.setMaxWidth(l.getDimens(this.cGA.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cGB, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cGA.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.Z("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dly) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cGA, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.btE().a(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cGA, shareItem, true, awX())));
        }
    }

    private SparseArray<String> awX() {
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
            this.mNavigationBar.onChangeSkinType(this.cGA.getPageContext(), i);
        }
        if (this.cGL != null) {
            this.cGL.onChangeSkinType(this.cGA, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cGA.getPageContext(), i);
        }
        SvgManager.aDW().a(this.cGD, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.cGE, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.KA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aDW().a(this.cGF, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cGG.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cGA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cr(null, this.cGA.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cGA.getResources().getString(R.string.refresh), this.cGJ)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cGA.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cGA.getPageContext());
        }
        this.cGG.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.cGJ = onClickListener;
    }

    public void release() {
        if (this.cGG != null) {
            this.cGG.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cGL != null) {
            g.dismissPopupWindow(this.cGL, this.cGA.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cGG.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cGD, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGE, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.KA, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGF, R.drawable.frs_star_navigation_bg);
        rV("");
        this.cGA.getWindow().setFlags(1024, 1024);
    }

    public void awY() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGG.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGG.setLayoutParams(layoutParams);
        if (this.cGD != null) {
            this.cGD.setBackgroundDrawable(null);
        }
        if (this.cGE != null) {
            this.cGE.setBackgroundDrawable(null);
        }
        if (this.KA != null) {
            this.KA.setBackgroundDrawable(null);
        }
        if (this.cGF != null) {
            this.cGF.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cGA != null) {
            this.cGA.getWindow().clearFlags(1024);
        }
    }

    public void fg(boolean z) {
        this.cGP = z;
    }
}
