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
    protected ImageView agR;
    private BaseWebViewActivity egO;
    private TextView egP;
    private View egQ;
    private ImageView egR;
    private View egS;
    private ImageView egT;
    private ImageView egU;
    private LinearLayout egV;
    private TextView egW;
    private View.OnClickListener egY;
    private View egZ;
    private MorePopupWindow eha;
    protected View ehb;
    private View ehc;
    private View ehd;
    private com.baidu.tieba.person.e ehg;
    private View ehi;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView egX = null;
    private boolean ehe = true;
    private boolean ehf = false;
    public boolean ehh = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.egO = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.egO.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.egO.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.egO.findViewById(R.id.view_navigation_bar);
        this.ehi = this.egO.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        zQ("");
        if (this.egO.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.egO.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.egO);
            this.mNavigationBar.setVisibility(8);
        }
        this.egV = (LinearLayout) this.egO.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.egV.setLayoutParams(layoutParams);
        this.egW = (TextView) this.egO.findViewById(R.id.webview_crash_tip);
        this.egX = (ContinuousAnimationView) this.egO.findViewById(R.id.webview_progress);
        ap.a(this.egX, R.raw.lottie_full_screen_refresh);
        this.egQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.egO != null) {
                    if ((!(f.this.egO instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.egO).isDisableGoBack || !((TbWebViewActivity) f.this.egO).needDealClickGoBack()) && !f.this.egO.webViewGoBack()) {
                        f.this.egO.finish();
                    }
                }
            }
        });
        this.egR = (ImageView) this.egQ.findViewById(R.id.widget_navi_back_button);
        this.egR.setContentDescription(this.egO.getResources().getString(R.string.back));
        this.egS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.egO != null) {
                    f.this.egO.finish();
                }
            }
        });
        this.egT = (ImageView) this.egS.findViewById(R.id.widget_navi_back_button);
        this.egT.setContentDescription(this.egO.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.egT.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.egO.getPageContext().getPageActivity(), R.dimen.ds4);
        this.egT.setLayoutParams(layoutParams2);
        this.egZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.beY()) {
                    f.this.beZ();
                } else if (f.this.egU.getVisibility() != 0) {
                    f.this.aVh();
                }
            }
        });
        this.agR = (ImageView) this.egZ.findViewById(R.id.widget_navi_more_button);
        this.egU = (ImageView) this.egZ.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.egO.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eha = new MorePopupWindow(this.egO.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.egO.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bfe() {
                f.this.aVh();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bff() {
            }
        });
        this.ehb = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.ehb.setOnClickListener(this.egO);
        if (g.eh(this.egO.getPageContext().getPageActivity())) {
            this.ehb.setVisibility(0);
        } else {
            this.ehb.setVisibility(8);
        }
        this.eha.refresh();
        this.ehd = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.ehd.setOnClickListener(this.egO);
        this.ehc = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.ehc.setOnClickListener(this.egO);
    }

    public void beU() {
        if (this.mNavigationBar != null && this.agR != null && this.egU != null) {
            this.agR.setVisibility(8);
            this.egU.setVisibility(0);
            this.egU.setOnClickListener(this.egO);
        }
    }

    public void np(int i) {
        if (this.mNavigationBar != null && this.agR != null) {
            this.agR.setVisibility(i);
        }
    }

    public boolean beV() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void beW() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.egT != null) {
            this.egT.setVisibility(8);
        }
    }

    public boolean beX() {
        try {
            this.egV.addView(this.egO.createWebView());
            this.egW.setVisibility(8);
            if (!this.ehe) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.egW.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.egV.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.egV.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void hX(boolean z) {
        if (this.ehb != null) {
            if (z) {
                this.ehb.setVisibility(0);
            } else {
                this.ehb.setVisibility(8);
            }
            this.eha.refresh();
        }
    }

    public void hY(boolean z) {
        if (this.egZ != null) {
            if (z) {
                this.egZ.setVisibility(0);
            } else {
                this.egZ.setVisibility(8);
            }
        }
    }

    public boolean beY() {
        return this.ehf;
    }

    public void hZ(boolean z) {
        this.ehf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beZ() {
        if (this.ehg == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.egO);
            ArrayList arrayList = new ArrayList();
            a.C0840a c0840a = new a.C0840a(this.egO.getString(R.string.report_text), aVar);
            c0840a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.ehg != null && f.this.egO != null) {
                        f.this.ehg.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.egO).createNormalCfg(f.this.egO.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.egO.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0840a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.ehg != null) {
                        f.this.ehg.dismiss();
                    }
                }
            });
            aVar.ba(arrayList);
            this.ehg = new com.baidu.tieba.person.e(this.egO, aVar.bkZ());
            this.ehg.W(0.7f);
        }
        this.ehg.show();
    }

    public void aVh() {
        this.eha.showWindowInRightBottomOfHost();
    }

    public void aVi() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eha, this.egO.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.egX.setVisibility(0);
            this.egX.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.egX.setVisibility(8);
        this.egX.cancelAnimation();
    }

    public void showCrashTip() {
        this.egW.setVisibility(0);
    }

    public void hideCrashTip() {
        this.egW.setVisibility(8);
    }

    public void zQ(String str) {
        if (this.mNavigationBar != null) {
            this.egP = this.mNavigationBar.setCenterTextTitle(str);
            if (this.egR != null && this.egR.getVisibility() == 0 && this.egT != null && this.egT.getVisibility() == 0) {
                this.egP.setMaxWidth(l.getDimens(this.egO.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.ehh) {
                ap.setNavbarTitleColor(this.egP, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.egP.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.egO.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dK(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.aj("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.eSD) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.egO, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cjN().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.egO, shareItem, true, bfa())));
        }
    }

    private SparseArray<String> bfa() {
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
        if (this.egX != null) {
            ap.a(this.egX, R.raw.lottie_full_screen_refresh);
        }
        if (this.eha != null) {
            this.eha.onChangeSkinType(this.egO, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.egO.getPageContext(), i);
        }
        if (!this.ehh) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.egO.getPageContext(), i);
            }
            SvgManager.bmU().a(this.egR, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.egT, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.agR, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.egU, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.ehi.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.egV.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.egO.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dL(null, this.egO.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.egO.getResources().getString(R.string.refresh), this.egY)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.egO.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.egO.getPageContext());
        }
        this.egV.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.egY = onClickListener;
    }

    public void release() {
        if (this.egV != null) {
            this.egV.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eha != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eha, this.egO.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.egV.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.egR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.egT, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.egU, R.drawable.frs_star_navigation_bg);
        zQ("");
        this.egO.getWindow().setFlags(1024, 1024);
    }

    public void bfb() {
        if (this.egV != null) {
            this.egV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agR != null && this.egU != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agR.setVisibility(8);
            this.egU.setVisibility(0);
            this.egU.setOnClickListener(this.egO);
            this.egP.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.egU.getLayoutParams();
            layoutParams.width = l.getDimens(this.egO, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.egO, R.dimen.tbds100);
            SvgManager.bmU().a(this.egT, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.egR, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bmU().a(this.egU, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bfc() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egV.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.egV.setLayoutParams(layoutParams);
        if (this.egR != null) {
            this.egR.setBackgroundDrawable(null);
        }
        if (this.egT != null) {
            this.egT.setBackgroundDrawable(null);
        }
        if (this.agR != null) {
            this.agR.setBackgroundDrawable(null);
        }
        if (this.egU != null) {
            this.egU.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.egO != null) {
            this.egO.getWindow().clearFlags(1024);
        }
    }

    public void ia(boolean z) {
        this.ehe = z;
    }

    public void bfd() {
        this.ehh = true;
        bfb();
    }
}
