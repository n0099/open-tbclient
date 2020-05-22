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
    protected ImageView aex;
    protected View dyA;
    private View dyB;
    private View dyC;
    private com.baidu.tieba.person.e dyF;
    private BaseWebViewActivity dyn;
    private TextView dyo;
    private View dyp;
    private ImageView dyq;
    private View dyr;
    private ImageView dys;
    private ImageView dyt;
    private LinearLayout dyu;
    private TextView dyv;
    private View.OnClickListener dyx;
    private View dyy;
    private MorePopupWindow dyz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dyw = null;
    private boolean dyD = true;
    private boolean dyE = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dyn = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dyn.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dyn.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dyn.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        vl("");
        if (this.dyn.isTranslucent()) {
            am.setBackgroundColor(this.mRoot, this.dyn.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dyn);
            this.mNavigationBar.setVisibility(8);
        }
        this.dyu = (LinearLayout) this.dyn.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dyu.setLayoutParams(layoutParams);
        this.dyv = (TextView) this.dyn.findViewById(R.id.webview_crash_tip);
        this.dyw = (ContinuousAnimationView) this.dyn.findViewById(R.id.webview_progress);
        am.a(this.dyw, (int) R.raw.lottie_full_screen_refresh);
        this.dyp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dyn != null) {
                    if ((!(f.this.dyn instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dyn).isDisableGoBack || !((TbWebViewActivity) f.this.dyn).needDealClickGoBack()) && !f.this.dyn.webViewGoBack()) {
                        f.this.dyn.finish();
                    }
                }
            }
        });
        this.dyq = (ImageView) this.dyp.findViewById(R.id.widget_navi_back_button);
        this.dyq.setContentDescription(this.dyn.getResources().getString(R.string.back));
        this.dyr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dyn != null) {
                    f.this.dyn.finish();
                }
            }
        });
        this.dys = (ImageView) this.dyr.findViewById(R.id.widget_navi_back_button);
        this.dys.setContentDescription(this.dyn.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dys.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dyn.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dys.setLayoutParams(layoutParams2);
        this.dyy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aNG()) {
                    f.this.aNH();
                } else if (f.this.dyt.getVisibility() != 0) {
                    f.this.aDZ();
                }
            }
        });
        this.aex = (ImageView) this.dyy.findViewById(R.id.widget_navi_more_button);
        this.dyt = (ImageView) this.dyy.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dyn.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dyz = new MorePopupWindow(this.dyn.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dyn.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aNK() {
                f.this.aDZ();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void aNL() {
            }
        });
        this.dyA = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dyA.setOnClickListener(this.dyn);
        if (com.baidu.tbadk.coreExtra.share.f.dM(this.dyn.getPageContext().getPageActivity())) {
            this.dyA.setVisibility(0);
        } else {
            this.dyA.setVisibility(8);
        }
        this.dyz.refresh();
        this.dyC = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dyC.setOnClickListener(this.dyn);
        this.dyB = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dyB.setOnClickListener(this.dyn);
    }

    public void aNC() {
        if (this.mNavigationBar != null && this.aex != null && this.dyt != null) {
            this.aex.setVisibility(8);
            this.dyt.setVisibility(0);
            this.dyt.setOnClickListener(this.dyn);
        }
    }

    public void jV(int i) {
        if (this.mNavigationBar != null && this.aex != null) {
            this.aex.setVisibility(i);
        }
    }

    public boolean aND() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void aNE() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dys != null) {
            this.dys.setVisibility(8);
        }
    }

    public boolean aNF() {
        try {
            this.dyu.addView(this.dyn.createWebView());
            this.dyv.setVisibility(8);
            if (!this.dyD) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dyv.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dyu.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dyu.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void gF(boolean z) {
        if (this.dyA != null) {
            if (z) {
                this.dyA.setVisibility(0);
            } else {
                this.dyA.setVisibility(8);
            }
            this.dyz.refresh();
        }
    }

    public void gG(boolean z) {
        if (this.dyy != null) {
            if (z) {
                this.dyy.setVisibility(0);
            } else {
                this.dyy.setVisibility(8);
            }
        }
    }

    public boolean aNG() {
        return this.dyE;
    }

    public void gH(boolean z) {
        this.dyE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNH() {
        if (this.dyF == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dyn);
            ArrayList arrayList = new ArrayList();
            a.C0745a c0745a = new a.C0745a(this.dyn.getString(R.string.report_text), aVar);
            c0745a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dyF != null && f.this.dyn != null) {
                        f.this.dyF.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dyn).createNormalCfg(f.this.dyn.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dyn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0745a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dyF != null) {
                        f.this.dyF.dismiss();
                    }
                }
            });
            aVar.aD(arrayList);
            this.dyF = new com.baidu.tieba.person.e(this.dyn, aVar.aTh());
            this.dyF.N(0.7f);
        }
        this.dyF.show();
    }

    public void aDZ() {
        this.dyz.showWindowInRightBottomOfHost();
    }

    public void aEa() {
        g.dismissPopupWindow(this.dyz, this.dyn.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        this.dyw.setVisibility(0);
        this.dyw.playAnimation();
    }

    public void hideProgressBar() {
        this.dyw.setVisibility(8);
        this.dyw.cancelAnimation();
    }

    public void showCrashTip() {
        this.dyv.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dyv.setVisibility(8);
    }

    public void vl(String str) {
        if (this.mNavigationBar != null) {
            this.dyo = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dyq != null && this.dyq.getVisibility() == 0 && this.dys != null && this.dys.getVisibility() == 0) {
                this.dyo.setMaxWidth(l.getDimens(this.dyn.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            am.setNavbarTitleColor(this.dyo, R.color.cp_cont_b, R.color.s_navbar_title_color);
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dyn.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            an anVar = new an(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            anVar.dh(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            anVar.ag("obj_type", 0);
            TiebaStatic.log(anVar);
            if (shareItem.eeP) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dyn, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.e.bMw().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dyn, shareItem, true, aNI())));
        }
    }

    private SparseArray<String> aNI() {
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
        if (this.dyw != null) {
            am.a(this.dyw, (int) R.raw.lottie_full_screen_refresh);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dyn.getPageContext(), i);
        }
        if (this.dyz != null) {
            this.dyz.onChangeSkinType(this.dyn, i, am.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dyn.getPageContext(), i);
        }
        SvgManager.aUV().a(this.dyq, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.dys, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.aex, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.aUV().a(this.dyt, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dyu.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dyn.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.dj(null, this.dyn.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dyn.getResources().getString(R.string.refresh), this.dyx)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dyn.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dyn.getPageContext());
        }
        this.dyu.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
    }

    public void release() {
        if (this.dyu != null) {
            this.dyu.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dyz != null) {
            g.dismissPopupWindow(this.dyz, this.dyn.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dyu.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        am.setBackgroundResource(this.dyq, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dys, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.aex, R.drawable.frs_star_navigation_bg);
        am.setBackgroundResource(this.dyt, R.drawable.frs_star_navigation_bg);
        vl("");
        this.dyn.getWindow().setFlags(1024, 1024);
    }

    public void aNJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dyu.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dyu.setLayoutParams(layoutParams);
        if (this.dyq != null) {
            this.dyq.setBackgroundDrawable(null);
        }
        if (this.dys != null) {
            this.dys.setBackgroundDrawable(null);
        }
        if (this.aex != null) {
            this.aex.setBackgroundDrawable(null);
        }
        if (this.dyt != null) {
            this.dyt.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dyn != null) {
            this.dyn.getWindow().clearFlags(1024);
        }
    }

    public void gI(boolean z) {
        this.dyD = z;
    }
}
