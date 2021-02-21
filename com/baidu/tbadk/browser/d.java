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
import com.baidu.tieba.c.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    protected ImageView ahC;
    private View eHA;
    private ImageView eHB;
    private ImageView eHC;
    private LinearLayout eHD;
    private TextView eHE;
    private View.OnClickListener eHG;
    private View eHH;
    private MorePopupWindow eHI;
    protected View eHJ;
    private View eHK;
    private View eHL;
    private e eHO;
    private View eHQ;
    private BaseWebViewActivity eHw;
    private TextView eHx;
    private View eHy;
    private ImageView eHz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ViewGroup bbd = null;
    private ContinuousAnimationView eHF = null;
    private boolean eHM = true;
    private boolean eHN = false;
    public boolean eHP = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.eHw = baseWebViewActivity;
        initUI();
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.eHw).zn(z).UZ(str).aR(this.bbd);
    }

    private void initUI() {
        this.eHw.setContentView(R.layout.base_webview_activity_new);
        this.bbd = (ViewGroup) this.eHw.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eHw.findViewById(R.id.view_navigation_bar);
        this.eHQ = this.eHw.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        zD("");
        if (this.eHw.isTranslucent()) {
            ap.setBackgroundColor(this.bbd, this.eHw.getResources().getColor(R.color.black_alpha0));
            this.bbd.setOnClickListener(this.eHw);
            this.mNavigationBar.setVisibility(8);
        }
        this.eHD = (LinearLayout) this.eHw.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eHD.setLayoutParams(layoutParams);
        this.eHE = (TextView) this.eHw.findViewById(R.id.webview_crash_tip);
        this.eHF = (ContinuousAnimationView) this.eHw.findViewById(R.id.webview_progress);
        ap.a(this.eHF, R.raw.lottie_full_screen_refresh);
        this.eHy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eHw != null) {
                    if ((!(d.this.eHw instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.eHw).isDisableGoBack || !((TbWebViewActivity) d.this.eHw).needDealClickGoBack()) && !d.this.eHw.webViewGoBack()) {
                        d.this.eHw.finish();
                    }
                }
            }
        });
        this.eHz = (ImageView) this.eHy.findViewById(R.id.widget_navi_back_button);
        this.eHz.setContentDescription(this.eHw.getResources().getString(R.string.back));
        this.eHA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eHw != null) {
                    d.this.eHw.finish();
                }
            }
        });
        this.eHB = (ImageView) this.eHA.findViewById(R.id.widget_navi_back_button);
        this.eHB.setContentDescription(this.eHw.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eHB.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eHw.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eHB.setLayoutParams(layoutParams2);
        this.eHH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bkD()) {
                    d.this.bkE();
                } else if (d.this.eHC.getVisibility() != 0) {
                    d.this.baL();
                }
            }
        });
        this.ahC = (ImageView) this.eHH.findViewById(R.id.widget_navi_more_button);
        this.eHC = (ImageView) this.eHH.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.eHw.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eHI = new MorePopupWindow(this.eHw.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eHw.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bkJ() {
                d.this.baL();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bkK() {
            }
        });
        this.eHJ = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eHJ.setOnClickListener(this.eHw);
        if (g.ff(this.eHw.getPageContext().getPageActivity())) {
            this.eHJ.setVisibility(0);
        } else {
            this.eHJ.setVisibility(8);
        }
        this.eHI.refresh();
        this.eHL = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eHL.setOnClickListener(this.eHw);
        this.eHK = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eHK.setOnClickListener(this.eHw);
    }

    public void bkz() {
        if (this.mNavigationBar != null && this.ahC != null && this.eHC != null) {
            this.ahC.setVisibility(8);
            this.eHC.setVisibility(0);
            this.eHC.setOnClickListener(this.eHw);
        }
    }

    public void mL(int i) {
        if (this.mNavigationBar != null && this.ahC != null) {
            this.ahC.setVisibility(i);
        }
    }

    public boolean bkA() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bkB() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.eHB != null) {
            this.eHB.setVisibility(8);
        }
    }

    public boolean bkC() {
        try {
            this.eHD.addView(this.eHw.createWebView());
            this.eHE.setVisibility(8);
            if (!this.eHM) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eHE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eHD.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eHD.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.eHJ != null) {
            if (z) {
                this.eHJ.setVisibility(0);
                jd(true);
            } else {
                this.eHJ.setVisibility(8);
                jd(false);
            }
            this.eHI.refresh();
        }
    }

    public void jd(boolean z) {
        if (this.eHH != null) {
            if (z) {
                this.eHH.setVisibility(0);
            } else {
                this.eHH.setVisibility(8);
            }
        }
    }

    public boolean bkD() {
        return this.eHN;
    }

    public void je(boolean z) {
        this.eHN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkE() {
        if (this.eHO == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.eHw);
            ArrayList arrayList = new ArrayList();
            a.C0897a c0897a = new a.C0897a(this.eHw.getString(R.string.report_text), aVar);
            c0897a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.eHO != null && d.this.eHw != null) {
                        d.this.eHO.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.eHw).createNormalCfg(d.this.eHw.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.eHw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0897a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eHO != null) {
                        d.this.eHO.dismiss();
                    }
                }
            });
            aVar.bw(arrayList);
            this.eHO = new e(this.eHw, aVar.bqR());
            this.eHO.ac(0.7f);
        }
        this.eHO.show();
    }

    public void baL() {
        this.eHI.showWindowInRightBottomOfHost();
    }

    public void baM() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eHI, this.eHw.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.eHF.setVisibility(0);
            this.eHF.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.eHF.setVisibility(8);
        this.eHF.cancelAnimation();
    }

    public void showCrashTip() {
        this.eHE.setVisibility(0);
    }

    public void hideCrashTip() {
        this.eHE.setVisibility(8);
    }

    public void zD(String str) {
        if (this.mNavigationBar != null) {
            this.eHx = this.mNavigationBar.setCenterTextTitle(str);
            if (this.eHz != null && this.eHz.getVisibility() == 0 && this.eHB != null && this.eHB.getVisibility() == 0) {
                this.eHx.setMaxWidth(l.getDimens(this.eHw.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.eHP) {
                ap.setNavbarTitleColor(this.eHx, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.eHx.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eHw.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.ap("obj_type", 0);
            TiebaStatic.log(arVar);
            if (shareItem.fuR) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.eHw, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.ctG().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eHw, shareItem, true, bkF())));
        }
    }

    private SparseArray<String> bkF() {
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
        if (this.eHF != null) {
            ap.a(this.eHF, R.raw.lottie_full_screen_refresh);
        }
        if (this.eHI != null) {
            this.eHI.onChangeSkinType(this.eHw, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eHw.getPageContext(), i);
        }
        if (!this.eHP) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eHw.getPageContext(), i);
            }
            SvgManager.bsR().a(this.eHz, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.eHB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.eHC, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.eHQ.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eHD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eHw.getPageContext().getPageActivity(), this.bbd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dS(null, this.eHw.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eHw.getResources().getString(R.string.refresh), this.eHG)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.eHw.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.eHw.getPageContext());
        }
        this.eHD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eHG = onClickListener;
    }

    public void release() {
        if (this.eHD != null) {
            this.eHD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eHI != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eHI, this.eHw.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eHD.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.eHz, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eHB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.ahC, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eHC, R.drawable.frs_star_navigation_bg);
        zD("");
        this.eHw.getWindow().setFlags(1024, 1024);
    }

    public void bkG() {
        if (this.eHD != null) {
            this.eHD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.ahC != null && this.eHC != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.ahC.setVisibility(8);
            this.eHC.setVisibility(0);
            this.eHC.setOnClickListener(this.eHw);
            this.eHx.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eHC.getLayoutParams();
            layoutParams.width = l.getDimens(this.eHw, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.eHw, R.dimen.tbds100);
            SvgManager.bsR().a(this.eHB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.eHz, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsR().a(this.eHC, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bkH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eHD.setLayoutParams(layoutParams);
        if (this.eHz != null) {
            this.eHz.setBackgroundDrawable(null);
        }
        if (this.eHB != null) {
            this.eHB.setBackgroundDrawable(null);
        }
        if (this.ahC != null) {
            this.ahC.setBackgroundDrawable(null);
        }
        if (this.eHC != null) {
            this.eHC.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.eHw != null) {
            this.eHw.getWindow().clearFlags(1024);
        }
    }

    public void jf(boolean z) {
        this.eHM = z;
    }

    public void bkI() {
        this.eHP = true;
        bkG();
    }
}
