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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
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
    protected ImageView aeV;
    private View.OnClickListener dJA;
    private View dJB;
    private MorePopupWindow dJC;
    protected View dJD;
    private View dJE;
    private View dJF;
    private com.baidu.tieba.person.e dJI;
    private View dJK;
    private BaseWebViewActivity dJq;
    private TextView dJr;
    private View dJs;
    private ImageView dJt;
    private View dJu;
    private ImageView dJv;
    private ImageView dJw;
    private LinearLayout dJx;
    private TextView dJy;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dJz = null;
    private boolean dJG = true;
    private boolean dJH = false;
    public boolean dJJ = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dJq = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dJq.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dJq.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dJq.findViewById(R.id.view_navigation_bar);
        this.dJK = this.dJq.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        wx("");
        if (this.dJq.isTranslucent()) {
            ao.setBackgroundColor(this.mRoot, this.dJq.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dJq);
            this.mNavigationBar.setVisibility(8);
        }
        this.dJx = (LinearLayout) this.dJq.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dJx.setLayoutParams(layoutParams);
        this.dJy = (TextView) this.dJq.findViewById(R.id.webview_crash_tip);
        this.dJz = (ContinuousAnimationView) this.dJq.findViewById(R.id.webview_progress);
        ao.a(this.dJz, R.raw.lottie_full_screen_refresh);
        this.dJs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dJq != null) {
                    if ((!(f.this.dJq instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dJq).isDisableGoBack || !((TbWebViewActivity) f.this.dJq).needDealClickGoBack()) && !f.this.dJq.webViewGoBack()) {
                        f.this.dJq.finish();
                    }
                }
            }
        });
        this.dJt = (ImageView) this.dJs.findViewById(R.id.widget_navi_back_button);
        this.dJt.setContentDescription(this.dJq.getResources().getString(R.string.back));
        this.dJu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dJq != null) {
                    f.this.dJq.finish();
                }
            }
        });
        this.dJv = (ImageView) this.dJu.findViewById(R.id.widget_navi_back_button);
        this.dJv.setContentDescription(this.dJq.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dJv.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dJq.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dJv.setLayoutParams(layoutParams2);
        this.dJB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aTf()) {
                    f.this.aTg();
                } else if (f.this.dJw.getVisibility() != 0) {
                    f.this.aIW();
                }
            }
        });
        this.aeV = (ImageView) this.dJB.findViewById(R.id.widget_navi_more_button);
        this.dJw = (ImageView) this.dJB.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dJq.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dJC = new MorePopupWindow(this.dJq.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dJq.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aTl() {
                f.this.aIW();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aTm() {
            }
        });
        this.dJD = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dJD.setOnClickListener(this.dJq);
        if (g.dS(this.dJq.getPageContext().getPageActivity())) {
            this.dJD.setVisibility(0);
        } else {
            this.dJD.setVisibility(8);
        }
        this.dJC.refresh();
        this.dJF = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dJF.setOnClickListener(this.dJq);
        this.dJE = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dJE.setOnClickListener(this.dJq);
    }

    public void aTb() {
        if (this.mNavigationBar != null && this.aeV != null && this.dJw != null) {
            this.aeV.setVisibility(8);
            this.dJw.setVisibility(0);
            this.dJw.setOnClickListener(this.dJq);
        }
    }

    public void kB(int i) {
        if (this.mNavigationBar != null && this.aeV != null) {
            this.aeV.setVisibility(i);
        }
    }

    public boolean aTc() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aTd() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dJv != null) {
            this.dJv.setVisibility(8);
        }
    }

    public boolean aTe() {
        try {
            this.dJx.addView(this.dJq.createWebView());
            this.dJy.setVisibility(8);
            if (!this.dJG) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dJy.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dJx.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dJx.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void hh(boolean z) {
        if (this.dJD != null) {
            if (z) {
                this.dJD.setVisibility(0);
            } else {
                this.dJD.setVisibility(8);
            }
            this.dJC.refresh();
        }
    }

    public void hi(boolean z) {
        if (this.dJB != null) {
            if (z) {
                this.dJB.setVisibility(0);
            } else {
                this.dJB.setVisibility(8);
            }
        }
    }

    public boolean aTf() {
        return this.dJH;
    }

    public void hj(boolean z) {
        this.dJH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTg() {
        if (this.dJI == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dJq);
            ArrayList arrayList = new ArrayList();
            a.C0772a c0772a = new a.C0772a(this.dJq.getString(R.string.report_text), aVar);
            c0772a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dJI != null && f.this.dJq != null) {
                        f.this.dJI.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dJq).createNormalCfg(f.this.dJq.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dJq.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0772a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dJI != null) {
                        f.this.dJI.dismiss();
                    }
                }
            });
            aVar.aS(arrayList);
            this.dJI = new com.baidu.tieba.person.e(this.dJq, aVar.aZb());
            this.dJI.P(0.7f);
        }
        this.dJI.show();
    }

    public void aIW() {
        this.dJC.showWindowInRightBottomOfHost();
    }

    public void aIX() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dJC, this.dJq.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.dJz.setVisibility(0);
        this.dJz.playAnimation();
    }

    public void hideProgressBar() {
        this.dJz.setVisibility(8);
        this.dJz.cancelAnimation();
    }

    public void showCrashTip() {
        this.dJy.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dJy.setVisibility(8);
    }

    public void wx(String str) {
        if (this.mNavigationBar != null) {
            this.dJr = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dJt != null && this.dJt.getVisibility() == 0 && this.dJv != null && this.dJv.getVisibility() == 0) {
                this.dJr.setMaxWidth(l.getDimens(this.dJq.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.dJJ) {
                ao.setNavbarTitleColor(this.dJr, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.dJr.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dJq.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ap apVar = new ap(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            apVar.dn(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            apVar.ah("obj_type", 0);
            TiebaStatic.log(apVar);
            if (shareItem.etM) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dJq, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.bSP().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dJq, shareItem, true, aTh())));
        }
    }

    private SparseArray<String> aTh() {
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
        if (this.dJz != null) {
            ao.a(this.dJz, R.raw.lottie_full_screen_refresh);
        }
        if (this.dJC != null) {
            this.dJC.onChangeSkinType(this.dJq, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dJq.getPageContext(), i);
        }
        if (!this.dJJ) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dJq.getPageContext(), i);
            }
            SvgManager.baR().a(this.dJt, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.dJv, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.aeV, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.dJw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.dJK.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dJx.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dJq.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.m31do(null, this.dJq.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dJq.getResources().getString(R.string.refresh), this.dJA)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dJq.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dJq.getPageContext());
        }
        this.dJx.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
    }

    public void release() {
        if (this.dJx != null) {
            this.dJx.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dJC != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dJC, this.dJq.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dJx.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ao.setBackgroundResource(this.dJt, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.dJv, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.aeV, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.dJw, R.drawable.frs_star_navigation_bg);
        wx("");
        this.dJq.getWindow().setFlags(1024, 1024);
    }

    public void aTi() {
        if (this.dJx != null) {
            this.dJx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.aeV != null && this.dJw != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.aeV.setVisibility(8);
            this.dJw.setVisibility(0);
            this.dJw.setOnClickListener(this.dJq);
            this.dJr.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dJw.getLayoutParams();
            layoutParams.width = l.getDimens(this.dJq, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.dJq, R.dimen.tbds100);
            SvgManager.baR().a(this.dJv, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.dJt, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.baR().a(this.dJw, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void aTj() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJx.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dJx.setLayoutParams(layoutParams);
        if (this.dJt != null) {
            this.dJt.setBackgroundDrawable(null);
        }
        if (this.dJv != null) {
            this.dJv.setBackgroundDrawable(null);
        }
        if (this.aeV != null) {
            this.aeV.setBackgroundDrawable(null);
        }
        if (this.dJw != null) {
            this.dJw.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dJq != null) {
            this.dJq.getWindow().clearFlags(1024);
        }
    }

    public void hk(boolean z) {
        this.dJG = z;
    }

    public void aTk() {
        this.dJJ = true;
        aTi();
    }
}
