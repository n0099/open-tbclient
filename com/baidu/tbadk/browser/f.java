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
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    protected ImageView agh;
    private BaseWebViewActivity dSC;
    private TextView dSD;
    private View dSE;
    private ImageView dSF;
    private View dSG;
    private ImageView dSH;
    private ImageView dSI;
    private LinearLayout dSJ;
    private TextView dSK;
    private View.OnClickListener dSM;
    private View dSN;
    private MorePopupWindow dSO;
    protected View dSP;
    private View dSQ;
    private View dSR;
    private com.baidu.tieba.person.e dSU;
    private View dSW;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dSL = null;
    private boolean dSS = true;
    private boolean dST = false;
    public boolean dSV = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dSC = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dSC.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dSC.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dSC.findViewById(R.id.view_navigation_bar);
        this.dSW = this.dSC.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        yJ("");
        if (this.dSC.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.dSC.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dSC);
            this.mNavigationBar.setVisibility(8);
        }
        this.dSJ = (LinearLayout) this.dSC.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSJ.setLayoutParams(layoutParams);
        this.dSK = (TextView) this.dSC.findViewById(R.id.webview_crash_tip);
        this.dSL = (ContinuousAnimationView) this.dSC.findViewById(R.id.webview_progress);
        ap.a(this.dSL, R.raw.lottie_full_screen_refresh);
        this.dSE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dSC != null) {
                    if ((!(f.this.dSC instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dSC).isDisableGoBack || !((TbWebViewActivity) f.this.dSC).needDealClickGoBack()) && !f.this.dSC.webViewGoBack()) {
                        f.this.dSC.finish();
                    }
                }
            }
        });
        this.dSF = (ImageView) this.dSE.findViewById(R.id.widget_navi_back_button);
        this.dSF.setContentDescription(this.dSC.getResources().getString(R.string.back));
        this.dSG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dSC != null) {
                    f.this.dSC.finish();
                }
            }
        });
        this.dSH = (ImageView) this.dSG.findViewById(R.id.widget_navi_back_button);
        this.dSH.setContentDescription(this.dSC.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSH.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dSC.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dSH.setLayoutParams(layoutParams2);
        this.dSN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bbw()) {
                    f.this.bbx();
                } else if (f.this.dSI.getVisibility() != 0) {
                    f.this.aRM();
                }
            }
        });
        this.agh = (ImageView) this.dSN.findViewById(R.id.widget_navi_more_button);
        this.dSI = (ImageView) this.dSN.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dSC.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dSO = new MorePopupWindow(this.dSC.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dSC.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbC() {
                f.this.aRM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbD() {
            }
        });
        this.dSP = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dSP.setOnClickListener(this.dSC);
        if (g.eb(this.dSC.getPageContext().getPageActivity())) {
            this.dSP.setVisibility(0);
        } else {
            this.dSP.setVisibility(8);
        }
        this.dSO.refresh();
        this.dSR = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dSR.setOnClickListener(this.dSC);
        this.dSQ = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dSQ.setOnClickListener(this.dSC);
    }

    public void bbs() {
        if (this.mNavigationBar != null && this.agh != null && this.dSI != null) {
            this.agh.setVisibility(8);
            this.dSI.setVisibility(0);
            this.dSI.setOnClickListener(this.dSC);
        }
    }

    public void mH(int i) {
        if (this.mNavigationBar != null && this.agh != null) {
            this.agh.setVisibility(i);
        }
    }

    public boolean bbt() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bbu() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dSH != null) {
            this.dSH.setVisibility(8);
        }
    }

    public boolean bbv() {
        try {
            this.dSJ.addView(this.dSC.createWebView());
            this.dSK.setVisibility(8);
            if (!this.dSS) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dSK.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dSJ.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dSJ.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void hE(boolean z) {
        if (this.dSP != null) {
            if (z) {
                this.dSP.setVisibility(0);
            } else {
                this.dSP.setVisibility(8);
            }
            this.dSO.refresh();
        }
    }

    public void hF(boolean z) {
        if (this.dSN != null) {
            if (z) {
                this.dSN.setVisibility(0);
            } else {
                this.dSN.setVisibility(8);
            }
        }
    }

    public boolean bbw() {
        return this.dST;
    }

    public void hG(boolean z) {
        this.dST = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        if (this.dSU == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dSC);
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.dSC.getString(R.string.report_text), aVar);
            c0825a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dSU != null && f.this.dSC != null) {
                        f.this.dSU.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dSC).createNormalCfg(f.this.dSC.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dSC.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0825a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dSU != null) {
                        f.this.dSU.dismiss();
                    }
                }
            });
            aVar.aT(arrayList);
            this.dSU = new com.baidu.tieba.person.e(this.dSC, aVar.bhw());
            this.dSU.U(0.7f);
        }
        this.dSU.show();
    }

    public void aRM() {
        this.dSO.showWindowInRightBottomOfHost();
    }

    public void aRN() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSO, this.dSC.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.dSL.setVisibility(0);
            this.dSL.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.dSL.setVisibility(8);
        this.dSL.cancelAnimation();
    }

    public void showCrashTip() {
        this.dSK.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dSK.setVisibility(8);
    }

    public void yJ(String str) {
        if (this.mNavigationBar != null) {
            this.dSD = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dSF != null && this.dSF.getVisibility() == 0 && this.dSH != null && this.dSH.getVisibility() == 0) {
                this.dSD.setMaxWidth(l.getDimens(this.dSC.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.dSV) {
                ap.setNavbarTitleColor(this.dSD, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.dSD.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dSC.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.eEq) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dSC, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cdc().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dSC, shareItem, true, bby())));
        }
    }

    private SparseArray<String> bby() {
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
        if (this.dSL != null) {
            ap.a(this.dSL, R.raw.lottie_full_screen_refresh);
        }
        if (this.dSO != null) {
            this.dSO.onChangeSkinType(this.dSC, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dSC.getPageContext(), i);
        }
        if (!this.dSV) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dSC.getPageContext(), i);
            }
            SvgManager.bjq().a(this.dSF, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSH, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.agh, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSI, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.dSW.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dSJ.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dSC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.dE(null, this.dSC.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dSC.getResources().getString(R.string.refresh), this.dSM)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dSC.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dSC.getPageContext());
        }
        this.dSJ.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSM = onClickListener;
    }

    public void release() {
        if (this.dSJ != null) {
            this.dSJ.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dSO != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSO, this.dSC.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dSJ.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.dSF, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSH, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agh, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSI, R.drawable.frs_star_navigation_bg);
        yJ("");
        this.dSC.getWindow().setFlags(1024, 1024);
    }

    public void bbz() {
        if (this.dSJ != null) {
            this.dSJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agh != null && this.dSI != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agh.setVisibility(8);
            this.dSI.setVisibility(0);
            this.dSI.setOnClickListener(this.dSC);
            this.dSD.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSI.getLayoutParams();
            layoutParams.width = l.getDimens(this.dSC, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.dSC, R.dimen.tbds100);
            SvgManager.bjq().a(this.dSH, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSF, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSI, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bbA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSJ.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSJ.setLayoutParams(layoutParams);
        if (this.dSF != null) {
            this.dSF.setBackgroundDrawable(null);
        }
        if (this.dSH != null) {
            this.dSH.setBackgroundDrawable(null);
        }
        if (this.agh != null) {
            this.agh.setBackgroundDrawable(null);
        }
        if (this.dSI != null) {
            this.dSI.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dSC != null) {
            this.dSC.getWindow().clearFlags(1024);
        }
    }

    public void hH(boolean z) {
        this.dSS = z;
    }

    public void bbB() {
        this.dSV = true;
        bbz();
    }
}
