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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
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
    protected ImageView afe;
    private LinearLayout dDA;
    private TextView dDB;
    private View.OnClickListener dDD;
    private View dDE;
    private MorePopupWindow dDF;
    protected View dDG;
    private View dDH;
    private View dDI;
    private com.baidu.tieba.person.e dDL;
    private View dDN;
    private BaseWebViewActivity dDt;
    private TextView dDu;
    private View dDv;
    private ImageView dDw;
    private View dDx;
    private ImageView dDy;
    private ImageView dDz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dDC = null;
    private boolean dDJ = true;
    private boolean dDK = false;
    public boolean dDM = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dDt = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dDt.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dDt.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dDt.findViewById(R.id.view_navigation_bar);
        this.dDN = this.dDt.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        vv("");
        if (this.dDt.isTranslucent()) {
            an.setBackgroundColor(this.mRoot, this.dDt.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dDt);
            this.mNavigationBar.setVisibility(8);
        }
        this.dDA = (LinearLayout) this.dDt.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        this.dDB = (TextView) this.dDt.findViewById(R.id.webview_crash_tip);
        this.dDC = (ContinuousAnimationView) this.dDt.findViewById(R.id.webview_progress);
        an.a(this.dDC, (int) R.raw.lottie_full_screen_refresh);
        this.dDv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dDt != null) {
                    if ((!(f.this.dDt instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dDt).isDisableGoBack || !((TbWebViewActivity) f.this.dDt).needDealClickGoBack()) && !f.this.dDt.webViewGoBack()) {
                        f.this.dDt.finish();
                    }
                }
            }
        });
        this.dDw = (ImageView) this.dDv.findViewById(R.id.widget_navi_back_button);
        this.dDw.setContentDescription(this.dDt.getResources().getString(R.string.back));
        this.dDx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dDt != null) {
                    f.this.dDt.finish();
                }
            }
        });
        this.dDy = (ImageView) this.dDx.findViewById(R.id.widget_navi_back_button);
        this.dDy.setContentDescription(this.dDt.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dDy.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dDt.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dDy.setLayoutParams(layoutParams2);
        this.dDE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aPk()) {
                    f.this.aPl();
                } else if (f.this.dDz.getVisibility() != 0) {
                    f.this.aFf();
                }
            }
        });
        this.afe = (ImageView) this.dDE.findViewById(R.id.widget_navi_more_button);
        this.dDz = (ImageView) this.dDE.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dDt.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dDF = new MorePopupWindow(this.dDt.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dDt.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aPq() {
                f.this.aFf();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aPr() {
            }
        });
        this.dDG = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dDG.setOnClickListener(this.dDt);
        if (com.baidu.tbadk.coreExtra.share.f.dN(this.dDt.getPageContext().getPageActivity())) {
            this.dDG.setVisibility(0);
        } else {
            this.dDG.setVisibility(8);
        }
        this.dDF.refresh();
        this.dDI = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dDI.setOnClickListener(this.dDt);
        this.dDH = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dDH.setOnClickListener(this.dDt);
    }

    public void aPg() {
        if (this.mNavigationBar != null && this.afe != null && this.dDz != null) {
            this.afe.setVisibility(8);
            this.dDz.setVisibility(0);
            this.dDz.setOnClickListener(this.dDt);
        }
    }

    public void ki(int i) {
        if (this.mNavigationBar != null && this.afe != null) {
            this.afe.setVisibility(i);
        }
    }

    public boolean aPh() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aPi() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dDy != null) {
            this.dDy.setVisibility(8);
        }
    }

    public boolean aPj() {
        try {
            this.dDA.addView(this.dDt.createWebView());
            this.dDB.setVisibility(8);
            if (!this.dDJ) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dDB.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dDA.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dDA.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void gM(boolean z) {
        if (this.dDG != null) {
            if (z) {
                this.dDG.setVisibility(0);
            } else {
                this.dDG.setVisibility(8);
            }
            this.dDF.refresh();
        }
    }

    public void gN(boolean z) {
        if (this.dDE != null) {
            if (z) {
                this.dDE.setVisibility(0);
            } else {
                this.dDE.setVisibility(8);
            }
        }
    }

    public boolean aPk() {
        return this.dDK;
    }

    public void gO(boolean z) {
        this.dDK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPl() {
        if (this.dDL == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dDt);
            ArrayList arrayList = new ArrayList();
            a.C0761a c0761a = new a.C0761a(this.dDt.getString(R.string.report_text), aVar);
            c0761a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dDL != null && f.this.dDt != null) {
                        f.this.dDL.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dDt).createNormalCfg(f.this.dDt.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dDt.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0761a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dDL != null) {
                        f.this.dDL.dismiss();
                    }
                }
            });
            aVar.aL(arrayList);
            this.dDL = new com.baidu.tieba.person.e(this.dDt, aVar.aVb());
            this.dDL.P(0.7f);
        }
        this.dDL.show();
    }

    public void aFf() {
        this.dDF.showWindowInRightBottomOfHost();
    }

    public void aFg() {
        g.dismissPopupWindow(this.dDF, this.dDt.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.dDC.setVisibility(0);
        this.dDC.playAnimation();
    }

    public void hideProgressBar() {
        this.dDC.setVisibility(8);
        this.dDC.cancelAnimation();
    }

    public void showCrashTip() {
        this.dDB.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dDB.setVisibility(8);
    }

    public void vv(String str) {
        if (this.mNavigationBar != null) {
            this.dDu = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dDw != null && this.dDw.getVisibility() == 0 && this.dDy != null && this.dDy.getVisibility() == 0) {
                this.dDu.setMaxWidth(l.getDimens(this.dDt.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.dDM) {
                an.setNavbarTitleColor(this.dDu, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.dDu.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dDt.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ao aoVar = new ao(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aoVar.dk(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aoVar.ag("obj_type", 0);
            TiebaStatic.log(aoVar);
            if (shareItem.enA) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dDt, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.bPD().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dDt, shareItem, true, aPm())));
        }
    }

    private SparseArray<String> aPm() {
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
        if (this.dDC != null) {
            an.a(this.dDC, (int) R.raw.lottie_full_screen_refresh);
        }
        if (this.dDF != null) {
            this.dDF.onChangeSkinType(this.dDt, i, an.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dDt.getPageContext(), i);
        }
        if (!this.dDM) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dDt.getPageContext(), i);
            }
            SvgManager.aWQ().a(this.dDw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.dDy, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.afe, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.dDz, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.dDN.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dDA.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dDt.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.dm(null, this.dDt.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dDt.getResources().getString(R.string.refresh), this.dDD)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dDt.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dDt.getPageContext());
        }
        this.dDA.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dDD = onClickListener;
    }

    public void release() {
        if (this.dDA != null) {
            this.dDA.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dDF != null) {
            g.dismissPopupWindow(this.dDF, this.dDt.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dDA.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        an.setBackgroundResource(this.dDw, R.drawable.frs_star_navigation_bg);
        an.setBackgroundResource(this.dDy, R.drawable.frs_star_navigation_bg);
        an.setBackgroundResource(this.afe, R.drawable.frs_star_navigation_bg);
        an.setBackgroundResource(this.dDz, R.drawable.frs_star_navigation_bg);
        vv("");
        this.dDt.getWindow().setFlags(1024, 1024);
    }

    public void aPn() {
        if (this.dDA != null) {
            this.dDA.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.afe != null && this.dDz != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.afe.setVisibility(8);
            this.dDz.setVisibility(0);
            this.dDz.setOnClickListener(this.dDt);
            this.dDu.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dDz.getLayoutParams();
            layoutParams.width = l.getDimens(this.dDt, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.dDt, R.dimen.tbds100);
            SvgManager.aWQ().a(this.dDy, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.dDw, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.aWQ().a(this.dDz, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aPo() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDA.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dDA.setLayoutParams(layoutParams);
        if (this.dDw != null) {
            this.dDw.setBackgroundDrawable(null);
        }
        if (this.dDy != null) {
            this.dDy.setBackgroundDrawable(null);
        }
        if (this.afe != null) {
            this.afe.setBackgroundDrawable(null);
        }
        if (this.dDz != null) {
            this.dDz.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dDt != null) {
            this.dDt.getWindow().clearFlags(1024);
        }
    }

    public void gP(boolean z) {
        this.dDJ = z;
    }

    public void aPp() {
        this.dDM = true;
        aPn();
    }
}
