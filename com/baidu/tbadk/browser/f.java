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
    protected ImageView agA;
    private BaseWebViewActivity dUM;
    private TextView dUN;
    private View dUO;
    private ImageView dUP;
    private View dUQ;
    private ImageView dUR;
    private ImageView dUS;
    private LinearLayout dUT;
    private TextView dUU;
    private View.OnClickListener dUW;
    private View dUX;
    private MorePopupWindow dUY;
    protected View dUZ;
    private View dVa;
    private View dVb;
    private com.baidu.tieba.person.e dVe;
    private View dVg;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView dUV = null;
    private boolean dVc = true;
    private boolean dVd = false;
    public boolean dVf = false;

    public f(BaseWebViewActivity baseWebViewActivity) {
        this.dUM = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.dUM.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.dUM.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.dUM.findViewById(R.id.view_navigation_bar);
        this.dVg = this.dUM.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        ze("");
        if (this.dUM.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.dUM.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.dUM);
            this.mNavigationBar.setVisibility(8);
        }
        this.dUT = (LinearLayout) this.dUM.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        this.dUU = (TextView) this.dUM.findViewById(R.id.webview_crash_tip);
        this.dUV = (ContinuousAnimationView) this.dUM.findViewById(R.id.webview_progress);
        ap.a(this.dUV, R.raw.lottie_full_screen_refresh);
        this.dUO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dUM != null) {
                    if ((!(f.this.dUM instanceof TbWebViewActivity) || !((TbWebViewActivity) f.this.dUM).isDisableGoBack || !((TbWebViewActivity) f.this.dUM).needDealClickGoBack()) && !f.this.dUM.webViewGoBack()) {
                        f.this.dUM.finish();
                    }
                }
            }
        });
        this.dUP = (ImageView) this.dUO.findViewById(R.id.widget_navi_back_button);
        this.dUP.setContentDescription(this.dUM.getResources().getString(R.string.back));
        this.dUQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.dUM != null) {
                    f.this.dUM.finish();
                }
            }
        });
        this.dUR = (ImageView) this.dUQ.findViewById(R.id.widget_navi_back_button);
        this.dUR.setContentDescription(this.dUM.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUR.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.dUM.getPageContext().getPageActivity(), R.dimen.ds4);
        this.dUR.setLayoutParams(layoutParams2);
        this.dUX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.bcq()) {
                    f.this.bcr();
                } else if (f.this.dUS.getVisibility() != 0) {
                    f.this.aSy();
                }
            }
        });
        this.agA = (ImageView) this.dUX.findViewById(R.id.widget_navi_more_button);
        this.dUS = (ImageView) this.dUX.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.dUM.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.dUY = new MorePopupWindow(this.dUM.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.dUM.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.f.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bcw() {
                f.this.aSy();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bcx() {
            }
        });
        this.dUZ = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.dUZ.setOnClickListener(this.dUM);
        if (g.ea(this.dUM.getPageContext().getPageActivity())) {
            this.dUZ.setVisibility(0);
        } else {
            this.dUZ.setVisibility(8);
        }
        this.dUY.refresh();
        this.dVb = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.dVb.setOnClickListener(this.dUM);
        this.dVa = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.dVa.setOnClickListener(this.dUM);
    }

    public void bcm() {
        if (this.mNavigationBar != null && this.agA != null && this.dUS != null) {
            this.agA.setVisibility(8);
            this.dUS.setVisibility(0);
            this.dUS.setOnClickListener(this.dUM);
        }
    }

    public void mS(int i) {
        if (this.mNavigationBar != null && this.agA != null) {
            this.agA.setVisibility(i);
        }
    }

    public boolean bcn() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bco() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.dUR != null) {
            this.dUR.setVisibility(8);
        }
    }

    public boolean bcp() {
        try {
            this.dUT.addView(this.dUM.createWebView());
            this.dUU.setVisibility(8);
            if (!this.dVc) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.dUU.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.dUT.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.dUT.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void hB(boolean z) {
        if (this.dUZ != null) {
            if (z) {
                this.dUZ.setVisibility(0);
            } else {
                this.dUZ.setVisibility(8);
            }
            this.dUY.refresh();
        }
    }

    public void hC(boolean z) {
        if (this.dUX != null) {
            if (z) {
                this.dUX.setVisibility(0);
            } else {
                this.dUX.setVisibility(8);
            }
        }
    }

    public boolean bcq() {
        return this.dVd;
    }

    public void hD(boolean z) {
        this.dVd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcr() {
        if (this.dVe == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.dUM);
            ArrayList arrayList = new ArrayList();
            a.C0822a c0822a = new a.C0822a(this.dUM.getString(R.string.report_text), aVar);
            c0822a.a(new a.c() { // from class: com.baidu.tbadk.browser.f.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (f.this.dVe != null && f.this.dUM != null) {
                        f.this.dVe.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(f.this.dUM).createNormalCfg(f.this.dUM.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        f.this.dUM.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0822a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.f.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (f.this.dVe != null) {
                        f.this.dVe.dismiss();
                    }
                }
            });
            aVar.aX(arrayList);
            this.dVe = new com.baidu.tieba.person.e(this.dUM, aVar.biq());
            this.dVe.U(0.7f);
        }
        this.dVe.show();
    }

    public void aSy() {
        this.dUY.showWindowInRightBottomOfHost();
    }

    public void aSz() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.dUY, this.dUM.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.dUV.setVisibility(0);
            this.dUV.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.dUV.setVisibility(8);
        this.dUV.cancelAnimation();
    }

    public void showCrashTip() {
        this.dUU.setVisibility(0);
    }

    public void hideCrashTip() {
        this.dUU.setVisibility(8);
    }

    public void ze(String str) {
        if (this.mNavigationBar != null) {
            this.dUN = this.mNavigationBar.setCenterTextTitle(str);
            if (this.dUP != null && this.dUP.getVisibility() == 0 && this.dUR != null && this.dUR.getVisibility() == 0) {
                this.dUN.setMaxWidth(l.getDimens(this.dUM.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.dVf) {
                ap.setNavbarTitleColor(this.dUN, R.color.cp_cont_b, R.color.s_navbar_title_color);
            } else {
                this.dUN.setTextColor(-1);
            }
        }
    }

    public void a(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.dUM.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dF(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.ai("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.eGw) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.dUM, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                com.baidu.tieba.c.f.cgr().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.dUM, shareItem, true, bcs())));
        }
    }

    private SparseArray<String> bcs() {
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
        if (this.dUV != null) {
            ap.a(this.dUV, R.raw.lottie_full_screen_refresh);
        }
        if (this.dUY != null) {
            this.dUY.onChangeSkinType(this.dUM, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dUM.getPageContext(), i);
        }
        if (!this.dVf) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.dUM.getPageContext(), i);
            }
            SvgManager.bkl().a(this.dUP, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.dUR, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.agA, R.drawable.icon_pure_topbar_more44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.dUS, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.dVg.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.dUT.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.dUM.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), NoDataViewFactory.d.dG(null, this.dUM.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dUM.getResources().getString(R.string.refresh), this.dUW)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a), this.dUM.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a), this.dUM.getPageContext());
        }
        this.dUT.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void f(View.OnClickListener onClickListener) {
        this.dUW = onClickListener;
    }

    public void release() {
        if (this.dUT != null) {
            this.dUT.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.dUY != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.dUY, this.dUM.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.dUT.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.dUP, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dUR, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agA, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.dUS, R.drawable.frs_star_navigation_bg);
        ze("");
        this.dUM.getWindow().setFlags(1024, 1024);
    }

    public void bct() {
        if (this.dUT != null) {
            this.dUT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agA != null && this.dUS != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agA.setVisibility(8);
            this.dUS.setVisibility(0);
            this.dUS.setOnClickListener(this.dUM);
            this.dUN.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUS.getLayoutParams();
            layoutParams.width = l.getDimens(this.dUM, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.dUM, R.dimen.tbds100);
            SvgManager.bkl().a(this.dUR, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.dUP, R.drawable.icon_pure_topbar_return44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bkl().a(this.dUS, R.drawable.icon_pure_topbar_share44_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bcu() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUT.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.dUT.setLayoutParams(layoutParams);
        if (this.dUP != null) {
            this.dUP.setBackgroundDrawable(null);
        }
        if (this.dUR != null) {
            this.dUR.setBackgroundDrawable(null);
        }
        if (this.agA != null) {
            this.agA.setBackgroundDrawable(null);
        }
        if (this.dUS != null) {
            this.dUS.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.dUM != null) {
            this.dUM.getWindow().clearFlags(1024);
        }
    }

    public void hE(boolean z) {
        this.dVc = z;
    }

    public void bcv() {
        this.dVf = true;
        bct();
    }
}
