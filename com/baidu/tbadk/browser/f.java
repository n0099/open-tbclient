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
    protected ImageView agS;
    private View epA;
    private View epB;
    private com.baidu.tieba.person.e epE;
    private View epG;
    private BaseWebViewActivity epm;
    private TextView epn;
    private View epo;
    private ImageView epp;
    private View epq;
    private ImageView epr;
    private ImageView eps;
    private LinearLayout ept;
    private TextView epu;
    private View.OnClickListener epw;
    private View epx;
    private MorePopupWindow epy;
    protected View epz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView epv = null;
    private boolean epC = true;
    private boolean epD = false;
    public boolean epF = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.epm = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.epm.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.epm.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.epm.findViewById(R.id.view_navigation_bar);
        this.epG = this.epm.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        Aj("");
        if (this.epm.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.epm.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.epm);
            this.mNavigationBar.setVisibility(8);
        }
        this.ept = (LinearLayout) this.epm.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.ept.setLayoutParams(layoutParams);
        this.epu = (TextView) this.epm.findViewById(R.id.webview_crash_tip);
        this.epv = (ContinuousAnimationView) this.epm.findViewById(R.id.webview_progress);
        ap.a(this.epv, R.raw.lottie_full_screen_refresh);
        this.epo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epm != null) {
                    if ((!(f.this.epm instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.epm).isDisableGoBack || !((TbWebViewActivity) f.this.epm).needDealClickGoBack()) && !f.this.epm.webViewGoBack()) {
                        f.this.epm.finish();
                    }
                }
            }
        });
        this.epp = (ImageView) this.epo.findViewById(R.id.widget_navi_back_button);
        this.epp.setContentDescription(this.epm.getResources().getString(R.string.back));
        this.epq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.epm != null) {
                    f.this.epm.finish();
                }
            }
        });
        this.epr = (ImageView) this.epq.findViewById(R.id.widget_navi_back_button);
        this.epr.setContentDescription(this.epm.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.epr.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.epm.getPageContext().getPageActivity(), R.dimen.ds4);
        this.epr.setLayoutParams(layoutParams2);
        this.epx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bgR()) {
                    f.this.bgS();
                } else if (f.this.eps.getVisibility() != 0) {
                    f.this.aXb();
                }
            }
        });
        this.agS = (ImageView) this.epx.findViewById(R.id.widget_navi_more_button);
        this.eps = (ImageView) this.epx.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.epm.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.epy = new MorePopupWindow(this.epm.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.epm.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bgX() {
                f.this.aXb();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bgY() {
            }
        });
        this.epz = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.epz.setOnClickListener(this.epm);
        if (g.eh(this.epm.getPageContext().getPageActivity())) {
            this.epz.setVisibility(0);
        } else {
            this.epz.setVisibility(8);
        }
        this.epy.refresh();
        this.epB = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.epB.setOnClickListener(this.epm);
        this.epA = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.epA.setOnClickListener(this.epm);
    }

    public void bgN() {
        if (this.mNavigationBar != null && this.agS != null && this.eps != null) {
            this.agS.setVisibility(8);
            this.eps.setVisibility(0);
            this.eps.setOnClickListener(this.epm);
        }
    }

    public void nA(int i) {
        if (this.mNavigationBar != null && this.agS != null) {
            this.agS.setVisibility(i);
        }
    }

    public boolean bgO() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bgP() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.epr != null) {
            this.epr.setVisibility(8);
        }
    }

    public boolean bgQ() {
        try {
            this.ept.addView(this.epm.createWebView());
            this.epu.setVisibility(8);
            if (!this.epC) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.epu.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.ept.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.ept.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void ik(boolean z) {
        if (this.epz != null) {
            if (z) {
                this.epz.setVisibility(0);
            } else {
                this.epz.setVisibility(8);
            }
            this.epy.refresh();
        }
    }

    public void il(boolean z) {
        if (this.epx != null) {
            if (z) {
                this.epx.setVisibility(0);
            } else {
                this.epx.setVisibility(8);
            }
        }
    }

    public boolean bgR() {
        return this.epD;
    }

    public void im(boolean z) {
        this.epD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgS() {
        if (this.epE == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.epm);
            ArrayList arrayList = new ArrayList();
            a.C0855a c0855a = new a.C0855a(this.epm.getString(R.string.report_text), aVar);
            c0855a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.epE != null && f.this.epm != null) {
                        f.this.epE.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.epm).createNormalCfg(f.this.epm.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.epm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0855a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.epE != null) {
                        f.this.epE.dismiss();
                    }
                }
            });
            aVar.bk(arrayList);
            this.epE = new com.baidu.tieba.person.e(this.epm, aVar.bmS());
            this.epE.Y(0.7f);
        }
        this.epE.show();
    }

    public void aXb() {
        this.epy.showWindowInRightBottomOfHost();
    }

    public void aXc() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.epy, this.epm.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.epv.setVisibility(0);
            this.epv.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.epv.setVisibility(8);
        this.epv.cancelAnimation();
    }

    public void showCrashTip() {
        this.epu.setVisibility(0);
    }

    public void hideCrashTip() {
        this.epu.setVisibility(8);
    }

    public void Aj(String str) {
        if (this.mNavigationBar != null) {
            this.epn = this.mNavigationBar.setCenterTextTitle(str);
            if (this.epp != null && this.epp.getVisibility() == 0 && this.epr != null && this.epr.getVisibility() == 0) {
                this.epn.setMaxWidth(l.getDimens(this.epm.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.epF) {
                ap.setNavbarTitleColor(this.epn, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.epn.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.epm.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.aj("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.faZ) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.epm, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cmU().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.epm, shareItem, true, bgT())));
        }
    }

    private SparseArray<String> bgT() {
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
        if (this.epv != null) {
            ap.a(this.epv, R.raw.lottie_full_screen_refresh);
        }
        if (this.epy != null) {
            this.epy.onChangeSkinType(this.epm, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.epm.getPageContext(), i);
        }
        if (!this.epF) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.epm.getPageContext(), i);
            }
            SvgManager.boN().a(this.epp, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.epr, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.agS, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.eps, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.epG.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ept.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.epm.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dS(null, this.epm.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.epm.getResources().getString(R.string.refresh), this.epw)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.epm.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.epm.getPageContext());
        }
        this.ept.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.epw = onClickListener;
    }

    public void release() {
        if (this.ept != null) {
            this.ept.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.epy != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.epy, this.epm.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.ept.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.epp, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.epr, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agS, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eps, R.drawable.frs_star_navigation_bg);
        Aj("");
        this.epm.getWindow().setFlags(1024, 1024);
    }

    public void bgU() {
        if (this.ept != null) {
            this.ept.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agS != null && this.eps != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agS.setVisibility(8);
            this.eps.setVisibility(0);
            this.eps.setOnClickListener(this.epm);
            this.epn.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eps.getLayoutParams();
            layoutParams.width = l.getDimens(this.epm, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.epm, R.dimen.tbds100);
            SvgManager.boN().a(this.epr, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.epp, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.boN().a(this.eps, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bgV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ept.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.ept.setLayoutParams(layoutParams);
        if (this.epp != null) {
            this.epp.setBackgroundDrawable(null);
        }
        if (this.epr != null) {
            this.epr.setBackgroundDrawable(null);
        }
        if (this.agS != null) {
            this.agS.setBackgroundDrawable(null);
        }
        if (this.eps != null) {
            this.eps.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.epm != null) {
            this.epm.getWindow().clearFlags(1024);
        }
    }

    public void in(boolean z) {
        this.epC = z;
    }

    public void bgW() {
        this.epF = true;
        bgU();
    }
}
