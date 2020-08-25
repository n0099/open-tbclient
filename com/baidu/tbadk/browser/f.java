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
/* loaded from: classes2.dex */
public class f {
    protected ImageView agf;
    private View dSA;
    private ImageView dSB;
    private View dSC;
    private ImageView dSD;
    private ImageView dSE;
    private LinearLayout dSF;
    private TextView dSG;
    private View.OnClickListener dSI;
    private View dSJ;
    private MorePopupWindow dSK;
    protected View dSL;
    private View dSM;
    private View dSN;
    private com.baidu.tieba.person.e dSQ;
    private View dSS;
    private BaseWebViewActivity dSy;
    private TextView dSz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dSH = null;
    private boolean dSO = true;
    private boolean dSP = false;
    public boolean dSR = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dSy = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dSy.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dSy.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dSy.findViewById(R.id.view_navigation_bar);
        this.dSS = this.dSy.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        yI("");
        if (this.dSy.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.dSy.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dSy);
            this.mNavigationBar.setVisibility(8);
        }
        this.dSF = (LinearLayout) this.dSy.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        this.dSG = (TextView) this.dSy.findViewById(R.id.webview_crash_tip);
        this.dSH = (ContinuousAnimationView) this.dSy.findViewById(R.id.webview_progress);
        ap.a(this.dSH, R.raw.lottie_full_screen_refresh);
        this.dSA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dSy != null) {
                    if ((!(f.this.dSy instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dSy).isDisableGoBack || !((TbWebViewActivity) f.this.dSy).needDealClickGoBack()) && !f.this.dSy.webViewGoBack()) {
                        f.this.dSy.finish();
                    }
                }
            }
        });
        this.dSB = (ImageView) this.dSA.findViewById(R.id.widget_navi_back_button);
        this.dSB.setContentDescription(this.dSy.getResources().getString(R.string.back));
        this.dSC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dSy != null) {
                    f.this.dSy.finish();
                }
            }
        });
        this.dSD = (ImageView) this.dSC.findViewById(R.id.widget_navi_back_button);
        this.dSD.setContentDescription(this.dSy.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSD.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dSy.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dSD.setLayoutParams(layoutParams2);
        this.dSJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bbw()) {
                    f.this.bbx();
                } else if (f.this.dSE.getVisibility() != 0) {
                    f.this.aRM();
                }
            }
        });
        this.agf = (ImageView) this.dSJ.findViewById(R.id.widget_navi_more_button);
        this.dSE = (ImageView) this.dSJ.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dSy.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dSK = new MorePopupWindow(this.dSy.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dSy.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbC() {
                f.this.aRM();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bbD() {
            }
        });
        this.dSL = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dSL.setOnClickListener(this.dSy);
        if (g.eb(this.dSy.getPageContext().getPageActivity())) {
            this.dSL.setVisibility(0);
        } else {
            this.dSL.setVisibility(8);
        }
        this.dSK.refresh();
        this.dSN = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dSN.setOnClickListener(this.dSy);
        this.dSM = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dSM.setOnClickListener(this.dSy);
    }

    public void bbs() {
        if (this.mNavigationBar != null && this.agf != null && this.dSE != null) {
            this.agf.setVisibility(8);
            this.dSE.setVisibility(0);
            this.dSE.setOnClickListener(this.dSy);
        }
    }

    public void mH(int i) {
        if (this.mNavigationBar != null && this.agf != null) {
            this.agf.setVisibility(i);
        }
    }

    public boolean bbt() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bbu() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dSD != null) {
            this.dSD.setVisibility(8);
        }
    }

    public boolean bbv() {
        try {
            this.dSF.addView(this.dSy.createWebView());
            this.dSG.setVisibility(8);
            if (!this.dSO) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dSG.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dSF.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dSF.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void hD(boolean z) {
        if (this.dSL != null) {
            if (z) {
                this.dSL.setVisibility(0);
            } else {
                this.dSL.setVisibility(8);
            }
            this.dSK.refresh();
        }
    }

    public void hE(boolean z) {
        if (this.dSJ != null) {
            if (z) {
                this.dSJ.setVisibility(0);
            } else {
                this.dSJ.setVisibility(8);
            }
        }
    }

    public boolean bbw() {
        return this.dSP;
    }

    public void hF(boolean z) {
        this.dSP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbx() {
        if (this.dSQ == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dSy);
            ArrayList arrayList = new ArrayList();
            a.C0825a c0825a = new a.C0825a(this.dSy.getString(R.string.report_text), aVar);
            c0825a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dSQ != null && f.this.dSy != null) {
                        f.this.dSQ.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dSy).createNormalCfg(f.this.dSy.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dSy.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0825a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dSQ != null) {
                        f.this.dSQ.dismiss();
                    }
                }
            });
            aVar.aT(arrayList);
            this.dSQ = new com.baidu.tieba.person.e(this.dSy, aVar.bhw());
            this.dSQ.U(0.7f);
        }
        this.dSQ.show();
    }

    public void aRM() {
        this.dSK.showWindowInRightBottomOfHost();
    }

    public void aRN() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSK, this.dSy.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.dSH.setVisibility(0);
            this.dSH.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.dSH.setVisibility(8);
        this.dSH.cancelAnimation();
    }

    public void showCrashTip() {
        this.dSG.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dSG.setVisibility(8);
    }

    public void yI(String str) {
        if (this.mNavigationBar != null) {
            this.dSz = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dSB != null && this.dSB.getVisibility() == 0 && this.dSD != null && this.dSD.getVisibility() == 0) {
                this.dSz.setMaxWidth(l.getDimens(this.dSy.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.dSR) {
                ap.setNavbarTitleColor(this.dSz, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.dSz.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dSy.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dD(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.eEm) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dSy, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cdb().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dSy, shareItem, true, bby())));
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
        if (this.dSH != null) {
            ap.a(this.dSH, R.raw.lottie_full_screen_refresh);
        }
        if (this.dSK != null) {
            this.dSK.onChangeSkinType(this.dSy, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dSy.getPageContext(), i);
        }
        if (!this.dSR) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dSy.getPageContext(), i);
            }
            SvgManager.bjq().a(this.dSB, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSD, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.agf, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSE, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.dSS.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dSF.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dSy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.dE(null, this.dSy.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dSy.getResources().getString(R.string.refresh), this.dSI)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dSy.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dSy.getPageContext());
        }
        this.dSF.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dSI = onClickListener;
    }

    public void release() {
        if (this.dSF != null) {
            this.dSF.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dSK != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dSK, this.dSy.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dSF.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.dSB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSD, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agf, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dSE, R.drawable.frs_star_navigation_bg);
        yI("");
        this.dSy.getWindow().setFlags(1024, 1024);
    }

    public void bbz() {
        if (this.dSF != null) {
            this.dSF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agf != null && this.dSE != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agf.setVisibility(8);
            this.dSE.setVisibility(0);
            this.dSE.setOnClickListener(this.dSy);
            this.dSz.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSE.getLayoutParams();
            layoutParams.width = l.getDimens(this.dSy, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.dSy, R.dimen.tbds100);
            SvgManager.bjq().a(this.dSD, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSB, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bjq().a(this.dSE, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bbA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSF.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dSF.setLayoutParams(layoutParams);
        if (this.dSB != null) {
            this.dSB.setBackgroundDrawable(null);
        }
        if (this.dSD != null) {
            this.dSD.setBackgroundDrawable(null);
        }
        if (this.agf != null) {
            this.agf.setBackgroundDrawable(null);
        }
        if (this.dSE != null) {
            this.dSE.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dSy != null) {
            this.dSy.getWindow().clearFlags(1024);
        }
    }

    public void hG(boolean z) {
        this.dSO = z;
    }

    public void bbB() {
        this.dSR = true;
        bbz();
    }
}
