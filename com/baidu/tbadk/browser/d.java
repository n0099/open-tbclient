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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.KeyEventDealContainerView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.d.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    protected ImageView ahT;
    private View eAA;
    private ImageView eAB;
    private View eAC;
    private ImageView eAD;
    private ImageView eAE;
    private LinearLayout eAF;
    private TextView eAG;
    private View.OnClickListener eAI;
    private View eAJ;
    private MorePopupWindow eAK;
    protected View eAL;
    private View eAM;
    private View eAN;
    private e eAQ;
    private View eAS;
    private BaseWebViewActivity eAy;
    private TextView eAz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView eAH = null;
    private boolean eAO = true;
    private boolean eAP = false;
    public boolean eAR = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.eAy = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.eAy.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.eAy.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eAy.findViewById(R.id.view_navigation_bar);
        this.eAS = this.eAy.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        Az("");
        if (this.eAy.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.eAy.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.eAy);
            this.mNavigationBar.setVisibility(8);
        }
        this.eAF = (LinearLayout) this.eAy.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eAF.setLayoutParams(layoutParams);
        this.eAG = (TextView) this.eAy.findViewById(R.id.webview_crash_tip);
        this.eAH = (ContinuousAnimationView) this.eAy.findViewById(R.id.webview_progress);
        ap.a(this.eAH, R.raw.lottie_full_screen_refresh);
        this.eAA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eAy != null) {
                    if ((!(d.this.eAy instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.eAy).isDisableGoBack || !((TbWebViewActivity) d.this.eAy).needDealClickGoBack()) && !d.this.eAy.webViewGoBack()) {
                        d.this.eAy.finish();
                    }
                }
            }
        });
        this.eAB = (ImageView) this.eAA.findViewById(R.id.widget_navi_back_button);
        this.eAB.setContentDescription(this.eAy.getResources().getString(R.string.back));
        this.eAC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eAy != null) {
                    d.this.eAy.finish();
                }
            }
        });
        this.eAD = (ImageView) this.eAC.findViewById(R.id.widget_navi_back_button);
        this.eAD.setContentDescription(this.eAy.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eAD.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eAy.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eAD.setLayoutParams(layoutParams2);
        this.eAJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.blF()) {
                    d.this.blG();
                } else if (d.this.eAE.getVisibility() != 0) {
                    d.this.bbZ();
                }
            }
        });
        this.ahT = (ImageView) this.eAJ.findViewById(R.id.widget_navi_more_button);
        this.eAE = (ImageView) this.eAJ.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.eAy.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eAK = new MorePopupWindow(this.eAy.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eAy.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void blL() {
                d.this.bbZ();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void blM() {
            }
        });
        this.eAL = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eAL.setOnClickListener(this.eAy);
        if (g.eM(this.eAy.getPageContext().getPageActivity())) {
            this.eAL.setVisibility(0);
        } else {
            this.eAL.setVisibility(8);
        }
        this.eAK.refresh();
        this.eAN = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eAN.setOnClickListener(this.eAy);
        this.eAM = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eAM.setOnClickListener(this.eAy);
    }

    public void blB() {
        if (this.mNavigationBar != null && this.ahT != null && this.eAE != null) {
            this.ahT.setVisibility(8);
            this.eAE.setVisibility(0);
            this.eAE.setOnClickListener(this.eAy);
        }
    }

    public void oe(int i) {
        if (this.mNavigationBar != null && this.ahT != null) {
            this.ahT.setVisibility(i);
        }
    }

    public boolean blC() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void blD() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.eAD != null) {
            this.eAD.setVisibility(8);
        }
    }

    public boolean blE() {
        try {
            this.eAF.addView(this.eAy.createWebView());
            this.eAG.setVisibility(8);
            if (!this.eAO) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eAG.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eAF.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eAF.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void iJ(boolean z) {
        if (this.eAL != null) {
            if (z) {
                this.eAL.setVisibility(0);
            } else {
                this.eAL.setVisibility(8);
            }
            this.eAK.refresh();
        }
    }

    public void iK(boolean z) {
        if (this.eAJ != null) {
            if (z) {
                this.eAJ.setVisibility(0);
            } else {
                this.eAJ.setVisibility(8);
            }
        }
    }

    public boolean blF() {
        return this.eAP;
    }

    public void iL(boolean z) {
        this.eAP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blG() {
        if (this.eAQ == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.eAy);
            ArrayList arrayList = new ArrayList();
            a.C0889a c0889a = new a.C0889a(this.eAy.getString(R.string.report_text), aVar);
            c0889a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.eAQ != null && d.this.eAy != null) {
                        d.this.eAQ.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.eAy).createNormalCfg(d.this.eAy.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.eAy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0889a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eAQ != null) {
                        d.this.eAQ.dismiss();
                    }
                }
            });
            aVar.bu(arrayList);
            this.eAQ = new e(this.eAy, aVar.brP());
            this.eAQ.Z(0.7f);
        }
        this.eAQ.show();
    }

    public void bbZ() {
        this.eAK.showWindowInRightBottomOfHost();
    }

    public void bca() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eAK, this.eAy.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.eAH.setVisibility(0);
            this.eAH.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.eAH.setVisibility(8);
        this.eAH.cancelAnimation();
    }

    public void showCrashTip() {
        this.eAG.setVisibility(0);
    }

    public void hideCrashTip() {
        this.eAG.setVisibility(8);
    }

    public void Az(String str) {
        if (this.mNavigationBar != null) {
            this.eAz = this.mNavigationBar.setCenterTextTitle(str);
            if (this.eAB != null && this.eAB.getVisibility() == 0 && this.eAD != null && this.eAD.getVisibility() == 0) {
                this.eAz.setMaxWidth(l.getDimens(this.eAy.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.eAR) {
                ap.setNavbarTitleColor(this.eAz, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.eAz.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eAy.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dY(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.al("obj_type", 0);
            TiebaStatic.log(arVar);
            if (shareItem.fny) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.eAy, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.ctk().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eAy, shareItem, true, blH())));
        }
    }

    private SparseArray<String> blH() {
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
        if (this.eAH != null) {
            ap.a(this.eAH, R.raw.lottie_full_screen_refresh);
        }
        if (this.eAK != null) {
            this.eAK.onChangeSkinType(this.eAy, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eAy.getPageContext(), i);
        }
        if (!this.eAR) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eAy.getPageContext(), i);
            }
            SvgManager.btW().a(this.eAB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.eAD, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.eAE, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.eAS.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eAF.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eAy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dZ(null, this.eAy.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eAy.getResources().getString(R.string.refresh), this.eAI)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.eAy.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.eAy.getPageContext());
        }
        this.eAF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.eAI = onClickListener;
    }

    public void release() {
        if (this.eAF != null) {
            this.eAF.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eAK != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eAK, this.eAy.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eAF.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.eAB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eAD, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.ahT, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eAE, R.drawable.frs_star_navigation_bg);
        Az("");
        this.eAy.getWindow().setFlags(1024, 1024);
    }

    public void blI() {
        if (this.eAF != null) {
            this.eAF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.ahT != null && this.eAE != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.ahT.setVisibility(8);
            this.eAE.setVisibility(0);
            this.eAE.setOnClickListener(this.eAy);
            this.eAz.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAE.getLayoutParams();
            layoutParams.width = l.getDimens(this.eAy, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.eAy, R.dimen.tbds100);
            SvgManager.btW().a(this.eAD, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.eAB, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.btW().a(this.eAE, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void blJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eAF.setLayoutParams(layoutParams);
        if (this.eAB != null) {
            this.eAB.setBackgroundDrawable(null);
        }
        if (this.eAD != null) {
            this.eAD.setBackgroundDrawable(null);
        }
        if (this.ahT != null) {
            this.ahT.setBackgroundDrawable(null);
        }
        if (this.eAE != null) {
            this.eAE.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.eAy != null) {
            this.eAy.getWindow().clearFlags(1024);
        }
    }

    public void iM(boolean z) {
        this.eAO = z;
    }

    public void blK() {
        this.eAR = true;
        blI();
    }
}
