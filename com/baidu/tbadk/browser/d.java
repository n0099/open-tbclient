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
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.c.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    protected ImageView ahO;
    private View.OnClickListener eFA;
    private View eFB;
    private MorePopupWindow eFC;
    protected View eFD;
    private View eFE;
    private View eFF;
    private e eFI;
    private View eFK;
    private BaseWebViewActivity eFq;
    private TextView eFr;
    private View eFs;
    private ImageView eFt;
    private View eFu;
    private ImageView eFv;
    private ImageView eFw;
    private LinearLayout eFx;
    private TextView eFy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ViewGroup aXW = null;
    private ContinuousAnimationView eFz = null;
    private boolean eFG = true;
    private boolean eFH = false;
    public boolean eFJ = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.eFq = baseWebViewActivity;
        initUI();
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.eFq).yS(z).TP(str).aR(this.aXW);
    }

    private void initUI() {
        this.eFq.setContentView(R.layout.base_webview_activity_new);
        this.aXW = (ViewGroup) this.eFq.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eFq.findViewById(R.id.view_navigation_bar);
        this.eFK = this.eFq.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        zm("");
        if (this.eFq.isTranslucent()) {
            ao.setBackgroundColor(this.aXW, this.eFq.getResources().getColor(R.color.black_alpha0));
            this.aXW.setOnClickListener(this.eFq);
            this.mNavigationBar.setVisibility(8);
        }
        this.eFx = (LinearLayout) this.eFq.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eFx.setLayoutParams(layoutParams);
        this.eFy = (TextView) this.eFq.findViewById(R.id.webview_crash_tip);
        this.eFz = (ContinuousAnimationView) this.eFq.findViewById(R.id.webview_progress);
        ao.a(this.eFz, R.raw.lottie_full_screen_refresh);
        this.eFs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eFq != null) {
                    if ((!(d.this.eFq instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.eFq).isDisableGoBack || !((TbWebViewActivity) d.this.eFq).needDealClickGoBack()) && !d.this.eFq.webViewGoBack()) {
                        d.this.eFq.finish();
                    }
                }
            }
        });
        this.eFt = (ImageView) this.eFs.findViewById(R.id.widget_navi_back_button);
        this.eFt.setContentDescription(this.eFq.getResources().getString(R.string.back));
        this.eFu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eFq != null) {
                    d.this.eFq.finish();
                }
            }
        });
        this.eFv = (ImageView) this.eFu.findViewById(R.id.widget_navi_back_button);
        this.eFv.setContentDescription(this.eFq.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eFv.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eFq.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eFv.setLayoutParams(layoutParams2);
        this.eFB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bkl()) {
                    d.this.bkm();
                } else if (d.this.eFw.getVisibility() != 0) {
                    d.this.bay();
                }
            }
        });
        this.ahO = (ImageView) this.eFB.findViewById(R.id.widget_navi_more_button);
        this.eFw = (ImageView) this.eFB.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.eFq.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eFC = new MorePopupWindow(this.eFq.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eFq.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bkr() {
                d.this.bay();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bks() {
            }
        });
        this.eFD = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eFD.setOnClickListener(this.eFq);
        if (g.fg(this.eFq.getPageContext().getPageActivity())) {
            this.eFD.setVisibility(0);
        } else {
            this.eFD.setVisibility(8);
        }
        this.eFC.refresh();
        this.eFF = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eFF.setOnClickListener(this.eFq);
        this.eFE = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eFE.setOnClickListener(this.eFq);
    }

    public void bkh() {
        if (this.mNavigationBar != null && this.ahO != null && this.eFw != null) {
            this.ahO.setVisibility(8);
            this.eFw.setVisibility(0);
            this.eFw.setOnClickListener(this.eFq);
        }
    }

    public void mI(int i) {
        if (this.mNavigationBar != null && this.ahO != null) {
            this.ahO.setVisibility(i);
        }
    }

    public boolean bki() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bkj() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.eFv != null) {
            this.eFv.setVisibility(8);
        }
    }

    public boolean bkk() {
        try {
            this.eFx.addView(this.eFq.createWebView());
            this.eFy.setVisibility(8);
            if (!this.eFG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eFy.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eFx.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eFx.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void ja(boolean z) {
        if (this.eFD != null) {
            if (z) {
                this.eFD.setVisibility(0);
                jb(true);
            } else {
                this.eFD.setVisibility(8);
                jb(false);
            }
            this.eFC.refresh();
        }
    }

    public void jb(boolean z) {
        if (this.eFB != null) {
            if (z) {
                this.eFB.setVisibility(0);
            } else {
                this.eFB.setVisibility(8);
            }
        }
    }

    public boolean bkl() {
        return this.eFH;
    }

    public void jc(boolean z) {
        this.eFH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkm() {
        if (this.eFI == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.eFq);
            ArrayList arrayList = new ArrayList();
            a.C0892a c0892a = new a.C0892a(this.eFq.getString(R.string.report_text), aVar);
            c0892a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.eFI != null && d.this.eFq != null) {
                        d.this.eFI.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.eFq).createNormalCfg(d.this.eFq.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.eFq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0892a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eFI != null) {
                        d.this.eFI.dismiss();
                    }
                }
            });
            aVar.bB(arrayList);
            this.eFI = new e(this.eFq, aVar.bqy());
            this.eFI.ab(0.7f);
        }
        this.eFI.show();
    }

    public void bay() {
        this.eFC.showWindowInRightBottomOfHost();
    }

    public void baz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eFC, this.eFq.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.eFz.setVisibility(0);
            this.eFz.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.eFz.setVisibility(8);
        this.eFz.cancelAnimation();
    }

    public void showCrashTip() {
        this.eFy.setVisibility(0);
    }

    public void hideCrashTip() {
        this.eFy.setVisibility(8);
    }

    public void zm(String str) {
        if (this.mNavigationBar != null) {
            this.eFr = this.mNavigationBar.setCenterTextTitle(str);
            if (this.eFt != null && this.eFt.getVisibility() == 0 && this.eFv != null && this.eFv.getVisibility() == 0) {
                this.eFr.setMaxWidth(l.getDimens(this.eFq.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.eFJ) {
                ao.setNavbarTitleColor(this.eFr, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.eFr.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eFq.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dW(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.an("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.fsz) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.eFq, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.csn().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eFq, shareItem, true, bkn())));
        }
    }

    private SparseArray<String> bkn() {
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
        if (this.eFz != null) {
            ao.a(this.eFz, R.raw.lottie_full_screen_refresh);
        }
        if (this.eFC != null) {
            this.eFC.onChangeSkinType(this.eFq, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eFq.getPageContext(), i);
        }
        if (!this.eFJ) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eFq.getPageContext(), i);
            }
            SvgManager.bsx().a(this.eFt, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.eFv, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.ahO, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.eFw, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.eFK.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eFx.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eFq.getPageContext().getPageActivity(), this.aXW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dX(null, this.eFq.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eFq.getResources().getString(R.string.refresh), this.eFA)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.eFq.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.eFq.getPageContext());
        }
        this.eFx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eFA = onClickListener;
    }

    public void release() {
        if (this.eFx != null) {
            this.eFx.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eFC != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eFC, this.eFq.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eFx.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ao.setBackgroundResource(this.eFt, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eFv, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.ahO, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eFw, R.drawable.frs_star_navigation_bg);
        zm("");
        this.eFq.getWindow().setFlags(1024, 1024);
    }

    public void bko() {
        if (this.eFx != null) {
            this.eFx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.ahO != null && this.eFw != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.ahO.setVisibility(8);
            this.eFw.setVisibility(0);
            this.eFw.setOnClickListener(this.eFq);
            this.eFr.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eFw.getLayoutParams();
            layoutParams.width = l.getDimens(this.eFq, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.eFq, R.dimen.tbds100);
            SvgManager.bsx().a(this.eFv, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.eFt, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsx().a(this.eFw, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bkp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eFx.setLayoutParams(layoutParams);
        if (this.eFt != null) {
            this.eFt.setBackgroundDrawable(null);
        }
        if (this.eFv != null) {
            this.eFv.setBackgroundDrawable(null);
        }
        if (this.ahO != null) {
            this.ahO.setBackgroundDrawable(null);
        }
        if (this.eFw != null) {
            this.eFw.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.eFq != null) {
            this.eFq.getWindow().clearFlags(1024);
        }
    }

    public void jd(boolean z) {
        this.eFG = z;
    }

    public void bkq() {
        this.eFJ = true;
        bko();
    }
}
