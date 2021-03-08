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
    protected ImageView aiV;
    private BaseWebViewActivity eIX;
    private TextView eIY;
    private View eIZ;
    private ImageView eJa;
    private View eJb;
    private ImageView eJc;
    private ImageView eJd;
    private LinearLayout eJe;
    private TextView eJf;
    private View.OnClickListener eJh;
    private View eJi;
    private MorePopupWindow eJj;
    protected View eJk;
    private View eJl;
    private View eJm;
    private e eJp;
    private View eJr;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ViewGroup bcD = null;
    private ContinuousAnimationView eJg = null;
    private boolean eJn = true;
    private boolean eJo = false;
    public boolean eJq = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.eIX = baseWebViewActivity;
        initUI();
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.eIX).zm(z).Vg(str).aR(this.bcD);
    }

    private void initUI() {
        this.eIX.setContentView(R.layout.base_webview_activity_new);
        this.bcD = (ViewGroup) this.eIX.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eIX.findViewById(R.id.view_navigation_bar);
        this.eJr = this.eIX.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        zK("");
        if (this.eIX.isTranslucent()) {
            ap.setBackgroundColor(this.bcD, this.eIX.getResources().getColor(R.color.black_alpha0));
            this.bcD.setOnClickListener(this.eIX);
            this.mNavigationBar.setVisibility(8);
        }
        this.eJe = (LinearLayout) this.eIX.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eJe.setLayoutParams(layoutParams);
        this.eJf = (TextView) this.eIX.findViewById(R.id.webview_crash_tip);
        this.eJg = (ContinuousAnimationView) this.eIX.findViewById(R.id.webview_progress);
        ap.a(this.eJg, R.raw.lottie_full_screen_refresh);
        this.eIZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eIX != null) {
                    if ((!(d.this.eIX instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.eIX).isDisableGoBack || !((TbWebViewActivity) d.this.eIX).needDealClickGoBack()) && !d.this.eIX.webViewGoBack()) {
                        d.this.eIX.finish();
                    }
                }
            }
        });
        this.eJa = (ImageView) this.eIZ.findViewById(R.id.widget_navi_back_button);
        this.eJa.setContentDescription(this.eIX.getResources().getString(R.string.back));
        this.eJb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eIX != null) {
                    d.this.eIX.finish();
                }
            }
        });
        this.eJc = (ImageView) this.eJb.findViewById(R.id.widget_navi_back_button);
        this.eJc.setContentDescription(this.eIX.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJc.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eIX.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eJc.setLayoutParams(layoutParams2);
        this.eJi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.bkF()) {
                    d.this.bkG();
                } else if (d.this.eJd.getVisibility() != 0) {
                    d.this.baO();
                }
            }
        });
        this.aiV = (ImageView) this.eJi.findViewById(R.id.widget_navi_more_button);
        this.eJd = (ImageView) this.eJi.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.eIX.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eJj = new MorePopupWindow(this.eIX.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eIX.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bkL() {
                d.this.baO();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bkM() {
            }
        });
        this.eJk = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eJk.setOnClickListener(this.eIX);
        if (g.fe(this.eIX.getPageContext().getPageActivity())) {
            this.eJk.setVisibility(0);
        } else {
            this.eJk.setVisibility(8);
        }
        this.eJj.refresh();
        this.eJm = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eJm.setOnClickListener(this.eIX);
        this.eJl = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eJl.setOnClickListener(this.eIX);
    }

    public void bkB() {
        if (this.mNavigationBar != null && this.aiV != null && this.eJd != null) {
            this.aiV.setVisibility(8);
            this.eJd.setVisibility(0);
            this.eJd.setOnClickListener(this.eIX);
        }
    }

    public void mM(int i) {
        if (this.mNavigationBar != null && this.aiV != null) {
            this.aiV.setVisibility(i);
        }
    }

    public boolean bkC() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bkD() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.eJc != null) {
            this.eJc.setVisibility(8);
        }
    }

    public boolean bkE() {
        try {
            this.eJe.addView(this.eIX.createWebView());
            this.eJf.setVisibility(8);
            if (!this.eJn) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eJf.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eJe.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eJe.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void jc(boolean z) {
        if (this.eJk != null) {
            if (z) {
                this.eJk.setVisibility(0);
                jd(true);
            } else {
                this.eJk.setVisibility(8);
                jd(false);
            }
            this.eJj.refresh();
        }
    }

    public void jd(boolean z) {
        if (this.eJi != null) {
            if (z) {
                this.eJi.setVisibility(0);
            } else {
                this.eJi.setVisibility(8);
            }
        }
    }

    public boolean bkF() {
        return this.eJo;
    }

    public void je(boolean z) {
        this.eJo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        if (this.eJp == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.eIX);
            ArrayList arrayList = new ArrayList();
            a.C0903a c0903a = new a.C0903a(this.eIX.getString(R.string.report_text), aVar);
            c0903a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.eJp != null && d.this.eIX != null) {
                        d.this.eJp.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.eIX).createNormalCfg(d.this.eIX.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.eIX.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0903a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eJp != null) {
                        d.this.eJp.dismiss();
                    }
                }
            });
            aVar.bw(arrayList);
            this.eJp = new e(this.eIX, aVar.bqS());
            this.eJp.ag(0.7f);
        }
        this.eJp.show();
    }

    public void baO() {
        this.eJj.showWindowInRightBottomOfHost();
    }

    public void baP() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eJj, this.eIX.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.eJg.setVisibility(0);
            this.eJg.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.eJg.setVisibility(8);
        this.eJg.cancelAnimation();
    }

    public void showCrashTip() {
        this.eJf.setVisibility(0);
    }

    public void hideCrashTip() {
        this.eJf.setVisibility(8);
    }

    public void zK(String str) {
        if (this.mNavigationBar != null) {
            this.eIY = this.mNavigationBar.setCenterTextTitle(str);
            if (this.eJa != null && this.eJa.getVisibility() == 0 && this.eJc != null && this.eJc.getVisibility() == 0) {
                this.eIY.setMaxWidth(l.getDimens(this.eIX.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.eJq) {
                ap.setNavbarTitleColor(this.eIY, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.eIY.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eIX.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.aq("obj_type", 0);
            TiebaStatic.log(arVar);
            if (shareItem.fwq) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.eIX, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.ctM().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eIX, shareItem, true, bkH())));
        }
    }

    private SparseArray<String> bkH() {
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
        if (this.eJg != null) {
            ap.a(this.eJg, R.raw.lottie_full_screen_refresh);
        }
        if (this.eJj != null) {
            this.eJj.onChangeSkinType(this.eIX, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eIX.getPageContext(), i);
        }
        if (!this.eJq) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eIX.getPageContext(), i);
            }
            SvgManager.bsU().a(this.eJa, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.eJc, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.aiV, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.eJd, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.eJr.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eJe.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eIX.getPageContext().getPageActivity(), this.bcD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dS(null, this.eIX.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eIX.getResources().getString(R.string.refresh), this.eJh)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.eIX.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.eIX.getPageContext());
        }
        this.eJe.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eJh = onClickListener;
    }

    public void release() {
        if (this.eJe != null) {
            this.eJe.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eJj != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eJj, this.eIX.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eJe.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.eJa, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eJc, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.aiV, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.eJd, R.drawable.frs_star_navigation_bg);
        zK("");
        this.eIX.getWindow().setFlags(1024, 1024);
    }

    public void bkI() {
        if (this.eJe != null) {
            this.eJe.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.aiV != null && this.eJd != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.aiV.setVisibility(8);
            this.eJd.setVisibility(0);
            this.eJd.setOnClickListener(this.eIX);
            this.eIY.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJd.getLayoutParams();
            layoutParams.width = l.getDimens(this.eIX, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.eIX, R.dimen.tbds100);
            SvgManager.bsU().a(this.eJc, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.eJa, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bsU().a(this.eJd, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void bkJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJe.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eJe.setLayoutParams(layoutParams);
        if (this.eJa != null) {
            this.eJa.setBackgroundDrawable(null);
        }
        if (this.eJc != null) {
            this.eJc.setBackgroundDrawable(null);
        }
        if (this.aiV != null) {
            this.aiV.setBackgroundDrawable(null);
        }
        if (this.eJd != null) {
            this.eJd.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.eIX != null) {
            this.eIX.getWindow().clearFlags(1024);
        }
    }

    public void jf(boolean z) {
        this.eJn = z;
    }

    public void bkK() {
        this.eJq = true;
        bkI();
    }
}
