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
    protected ImageView KG;
    private BaseWebViewActivity cGM;
    private TextView cGN;
    private View cGO;
    private ImageView cGP;
    private ImageView cGQ;
    private ImageView cGR;
    private LinearLayout cGS;
    private TextView cGT;
    private View.OnClickListener cGV;
    private View cGW;
    private MorePopupWindow cGX;
    protected View cGY;
    private View cGZ;
    private View cHa;
    private com.baidu.tieba.person.e cHd;
    private View mCloseView;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView cGU = null;
    private boolean cHb = true;
    private boolean cHc = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.cGM = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.cGM.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.cGM.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.cGM.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        rY("");
        if (this.cGM.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.cGM.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.cGM);
            this.mNavigationBar.setVisibility(8);
        }
        this.cGS = (LinearLayout) this.cGM.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        this.cGT = (TextView) this.cGM.findViewById(R.id.webview_crash_tip);
        this.cGU = (ContinuousAnimationView) this.cGM.findViewById(R.id.webview_progress);
        this.cGU.setAnimation(R.raw.lottie_full_screen_refresh);
        this.cGO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cGM != null) {
                    if ((!(f.this.cGM instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.cGM).isDisableGoBack || !((TbWebViewActivity) f.this.cGM).needDealClickGoBack()) && !f.this.cGM.webViewGoBack()) {
                        f.this.cGM.finish();
                    }
                }
            }
        });
        this.cGP = (ImageView) this.cGO.findViewById(R.id.widget_navi_back_button);
        this.cGP.setContentDescription(this.cGM.getResources().getString(R.string.back));
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.cGM != null) {
                    f.this.cGM.finish();
                }
            }
        });
        this.cGQ = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cGQ.setContentDescription(this.cGM.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cGQ.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.cGM.getPageContext().getPageActivity(), R.dimen.ds4);
        this.cGQ.setLayoutParams(layoutParams2);
        this.cGW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.axo()) {
                    f.this.axp();
                } else if (f.this.cGR.getVisibility() != 0) {
                    f.this.apE();
                }
            }
        });
        this.KG = (ImageView) this.cGW.findViewById(R.id.widget_navi_more_button);
        this.cGR = (ImageView) this.cGW.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.cGM.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.cGX = new MorePopupWindow(this.cGM.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.cGM.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void axs() {
                f.this.apE();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void axt() {
            }
        });
        this.cGY = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.cGY.setOnClickListener(this.cGM);
        if (com.baidu.tbadk.coreExtra.share.e.dQ(this.cGM.getPageContext().getPageActivity())) {
            this.cGY.setVisibility(0);
        } else {
            this.cGY.setVisibility(8);
        }
        this.cGX.refresh();
        this.cHa = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.cHa.setOnClickListener(this.cGM);
        this.cGZ = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.cGZ.setOnClickListener(this.cGM);
    }

    public void axk() {
        if (this.mNavigationBar != null && this.KG != null && this.cGR != null) {
            this.KG.setVisibility(8);
            this.cGR.setVisibility(0);
            this.cGR.setOnClickListener(this.cGM);
        }
    }

    public void iX(int i) {
        if (this.mNavigationBar != null && this.KG != null) {
            this.KG.setVisibility(i);
        }
    }

    public boolean axl() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void axm() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.cGQ != null) {
            this.cGQ.setVisibility(8);
        }
    }

    public boolean axn() {
        try {
            this.cGS.addView(this.cGM.createWebView());
            this.cGT.setVisibility(8);
            if (!this.cHb) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.cGT.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.cGS.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.cGS.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void fi(boolean z) {
        if (this.cGY != null) {
            if (z) {
                this.cGY.setVisibility(0);
            } else {
                this.cGY.setVisibility(8);
            }
            this.cGX.refresh();
        }
    }

    public void fj(boolean z) {
        if (this.cGW != null) {
            if (z) {
                this.cGW.setVisibility(0);
            } else {
                this.cGW.setVisibility(8);
            }
        }
    }

    public boolean axo() {
        return this.cHc;
    }

    public void fk(boolean z) {
        this.cHc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axp() {
        if (this.cHd == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.cGM);
            ArrayList arrayList = new ArrayList();
            a.C0621a c0621a = new a.C0621a(this.cGM.getString(R.string.report_text), aVar);
            c0621a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.cHd != null && f.this.cGM != null) {
                        f.this.cHd.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.cGM).createNormalCfg(f.this.cGM.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.cGM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0621a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.cHd != null) {
                        f.this.cHd.dismiss();
                    }
                }
            });
            aVar.az(arrayList);
            this.cHd = new com.baidu.tieba.person.e(this.cGM, aVar.aCF());
            this.cHd.af(0.7f);
        }
        this.cHd.show();
    }

    public void apE() {
        this.cGX.showWindowInRightBottomOfHost();
    }

    public void apF() {
        g.dismissPopupWindow(this.cGX, this.cGM.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.cGU.setVisibility(0);
        this.cGU.playAnimation();
    }

    public void hideProgressBar() {
        this.cGU.setVisibility(8);
        this.cGU.cancelAnimation();
    }

    public void showCrashTip() {
        this.cGT.setVisibility(0);
    }

    public void hideCrashTip() {
        this.cGT.setVisibility(8);
    }

    public void rY(String str) {
        if (this.mNavigationBar != null) {
            this.cGN = this.mNavigationBar.setCenterTextTitle(str);
            if (this.cGP != null && this.cGP.getVisibility() == 0 && this.cGQ != null && this.cGQ.getVisibility() == 0) {
                this.cGN.setMaxWidth(l.getDimens(this.cGM.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.cGN, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.cGM.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.cp(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.Z("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.dlO) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.cGM, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.buG().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.cGM, shareItem, true, axq())));
        }
    }

    private SparseArray<String> axq() {
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
            this.mNavigationBar.onChangeSkinType(this.cGM.getPageContext(), i);
        }
        if (this.cGX != null) {
            this.cGX.onChangeSkinType(this.cGM, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cGM.getPageContext(), i);
        }
        SvgManager.aEp().a(this.cGP, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.cGQ, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.KG, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aEp().a(this.cGR, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.cGS.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cGM.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.cr(null, this.cGM.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cGM.getResources().getString(R.string.refresh), this.cGV)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.cGM.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.cGM.getPageContext());
        }
        this.cGS.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    public void release() {
        if (this.cGS != null) {
            this.cGS.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.cGX != null) {
            g.dismissPopupWindow(this.cGX, this.cGM.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.cGS.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.cGP, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGQ, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.KG, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.cGR, R.drawable.frs_star_navigation_bg);
        rY("");
        this.cGM.getWindow().setFlags(1024, 1024);
    }

    public void axr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cGS.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.cGS.setLayoutParams(layoutParams);
        if (this.cGP != null) {
            this.cGP.setBackgroundDrawable(null);
        }
        if (this.cGQ != null) {
            this.cGQ.setBackgroundDrawable(null);
        }
        if (this.KG != null) {
            this.KG.setBackgroundDrawable(null);
        }
        if (this.cGR != null) {
            this.cGR.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.cGM != null) {
            this.cGM.getWindow().clearFlags(1024);
        }
    }

    public void fl(boolean z) {
        this.cHb = z;
    }
}
