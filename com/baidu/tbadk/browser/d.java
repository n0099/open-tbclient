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
    protected ImageView aiG;
    private BaseWebViewActivity eKb;
    private TextView eKc;
    private View eKd;
    private ImageView eKe;
    private View eKf;
    private ImageView eKg;
    private ImageView eKh;
    private LinearLayout eKi;
    private TextView eKj;
    private View.OnClickListener eKl;
    private View eKm;
    private MorePopupWindow eKn;
    protected View eKo;
    private View eKp;
    private View eKq;
    private e eKt;
    private View eKv;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected ViewGroup bcK = null;
    private ContinuousAnimationView eKk = null;
    private boolean eKr = true;
    private boolean eKs = false;
    public boolean eKu = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.eKb = baseWebViewActivity;
        initUI();
    }

    public void showTipToast(boolean z, String str) {
        new BdTopToast(this.eKb).yW(z).UY(str).aR(this.bcK);
    }

    private void initUI() {
        this.eKb.setContentView(R.layout.base_webview_activity_new);
        this.bcK = (ViewGroup) this.eKb.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.eKb.findViewById(R.id.view_navigation_bar);
        this.eKv = this.eKb.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        Ax("");
        if (this.eKb.isTranslucent()) {
            ao.setBackgroundColor(this.bcK, this.eKb.getResources().getColor(R.color.black_alpha0));
            this.bcK.setOnClickListener(this.eKb);
            this.mNavigationBar.setVisibility(8);
        }
        this.eKi = (LinearLayout) this.eKb.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eKi.setLayoutParams(layoutParams);
        this.eKj = (TextView) this.eKb.findViewById(R.id.webview_crash_tip);
        this.eKk = (ContinuousAnimationView) this.eKb.findViewById(R.id.webview_progress);
        ao.a(this.eKk, R.raw.lottie_full_screen_refresh);
        this.eKd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eKb != null) {
                    if ((!(d.this.eKb instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.eKb).isDisableGoBack || !((TbWebViewActivity) d.this.eKb).needDealClickGoBack()) && !d.this.eKb.webViewGoBack()) {
                        d.this.eKb.finish();
                    }
                }
            }
        });
        this.eKe = (ImageView) this.eKd.findViewById(R.id.widget_navi_back_button);
        this.eKe.setContentDescription(this.eKb.getResources().getString(R.string.back));
        this.eKf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eKb != null) {
                    d.this.eKb.finish();
                }
            }
        });
        this.eKg = (ImageView) this.eKf.findViewById(R.id.widget_navi_back_button);
        this.eKg.setContentDescription(this.eKb.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eKg.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.eKb.getPageContext().getPageActivity(), R.dimen.ds4);
        this.eKg.setLayoutParams(layoutParams2);
        this.eKm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.boe()) {
                    d.this.bof();
                } else if (d.this.eKh.getVisibility() != 0) {
                    d.this.ber();
                }
            }
        });
        this.aiG = (ImageView) this.eKm.findViewById(R.id.widget_navi_more_button);
        this.eKh = (ImageView) this.eKm.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.eKb.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.eKn = new MorePopupWindow(this.eKb.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.eKb.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bok() {
                d.this.ber();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void bol() {
            }
        });
        this.eKo = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.eKo.setOnClickListener(this.eKb);
        if (g.fi(this.eKb.getPageContext().getPageActivity())) {
            this.eKo.setVisibility(0);
        } else {
            this.eKo.setVisibility(8);
        }
        this.eKn.refresh();
        this.eKq = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.eKq.setOnClickListener(this.eKb);
        this.eKp = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.eKp.setOnClickListener(this.eKb);
    }

    public void boa() {
        if (this.mNavigationBar != null && this.aiG != null && this.eKh != null) {
            this.aiG.setVisibility(8);
            this.eKh.setVisibility(0);
            this.eKh.setOnClickListener(this.eKb);
        }
    }

    public void oo(int i) {
        if (this.mNavigationBar != null && this.aiG != null) {
            this.aiG.setVisibility(i);
        }
    }

    public boolean bob() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void boc() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.eKg != null) {
            this.eKg.setVisibility(8);
        }
    }

    public boolean bod() {
        try {
            this.eKi.addView(this.eKb.createWebView());
            this.eKj.setVisibility(8);
            if (!this.eKr) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.eKj.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.eKi.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.eKi.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void je(boolean z) {
        if (this.eKo != null) {
            if (z) {
                this.eKo.setVisibility(0);
                jf(true);
            } else {
                this.eKo.setVisibility(8);
                jf(false);
            }
            this.eKn.refresh();
        }
    }

    public void jf(boolean z) {
        if (this.eKm != null) {
            if (z) {
                this.eKm.setVisibility(0);
            } else {
                this.eKm.setVisibility(8);
            }
        }
    }

    public boolean boe() {
        return this.eKs;
    }

    public void jg(boolean z) {
        this.eKs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bof() {
        if (this.eKt == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.eKb);
            ArrayList arrayList = new ArrayList();
            a.C0871a c0871a = new a.C0871a(this.eKb.getString(R.string.report_text), aVar);
            c0871a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.eKt != null && d.this.eKb != null) {
                        d.this.eKt.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.eKb).createNormalCfg(d.this.eKb.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.eKb.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0871a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.eKt != null) {
                        d.this.eKt.dismiss();
                    }
                }
            });
            aVar.bB(arrayList);
            this.eKt = new e(this.eKb, aVar.bur());
            this.eKt.ab(0.7f);
        }
        this.eKt.show();
    }

    public void ber() {
        this.eKn.showWindowInRightBottomOfHost();
    }

    public void bes() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.eKn, this.eKb.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.eKk.setVisibility(0);
            this.eKk.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.eKk.setVisibility(8);
        this.eKk.cancelAnimation();
    }

    public void showCrashTip() {
        this.eKj.setVisibility(0);
    }

    public void hideCrashTip() {
        this.eKj.setVisibility(8);
    }

    public void Ax(String str) {
        if (this.mNavigationBar != null) {
            this.eKc = this.mNavigationBar.setCenterTextTitle(str);
            if (this.eKe != null && this.eKe.getVisibility() == 0 && this.eKg != null && this.eKg.getVisibility() == 0) {
                this.eKc.setMaxWidth(l.getDimens(this.eKb.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.eKu) {
                ao.setNavbarTitleColor(this.eKc, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.eKc.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.eKb.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            aq aqVar = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar.dX(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            aqVar.an("obj_type", 0);
            TiebaStatic.log(aqVar);
            if (shareItem.fxi) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.eKb, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.cwe().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.eKb, shareItem, true, bog())));
        }
    }

    private SparseArray<String> bog() {
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
        if (this.eKk != null) {
            ao.a(this.eKk, R.raw.lottie_full_screen_refresh);
        }
        if (this.eKn != null) {
            this.eKn.onChangeSkinType(this.eKb, i, ao.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eKb.getPageContext(), i);
        }
        if (!this.eKu) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.eKb.getPageContext(), i);
            }
            SvgManager.bwq().a(this.eKe, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.eKg, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.aiG, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.eKh, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.eKv.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eKi.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.eKb.getPageContext().getPageActivity(), this.bcK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dY(null, this.eKb.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.eKb.getResources().getString(R.string.refresh), this.eKl)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.eKb.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.eKb.getPageContext());
        }
        this.eKi.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void h(View.OnClickListener onClickListener) {
        this.eKl = onClickListener;
    }

    public void release() {
        if (this.eKi != null) {
            this.eKi.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.eKn != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.eKn, this.eKb.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.eKi.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ao.setBackgroundResource(this.eKe, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eKg, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.aiG, R.drawable.frs_star_navigation_bg);
        ao.setBackgroundResource(this.eKh, R.drawable.frs_star_navigation_bg);
        Ax("");
        this.eKb.getWindow().setFlags(1024, 1024);
    }

    public void boh() {
        if (this.eKi != null) {
            this.eKi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.aiG != null && this.eKh != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.aiG.setVisibility(8);
            this.eKh.setVisibility(0);
            this.eKh.setOnClickListener(this.eKb);
            this.eKc.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKh.getLayoutParams();
            layoutParams.width = l.getDimens(this.eKb, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.eKb, R.dimen.tbds100);
            SvgManager.bwq().a(this.eKg, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.eKe, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bwq().a(this.eKh, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void boi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKi.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.eKi.setLayoutParams(layoutParams);
        if (this.eKe != null) {
            this.eKe.setBackgroundDrawable(null);
        }
        if (this.eKg != null) {
            this.eKg.setBackgroundDrawable(null);
        }
        if (this.aiG != null) {
            this.aiG.setBackgroundDrawable(null);
        }
        if (this.eKh != null) {
            this.eKh.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.eKb != null) {
            this.eKb.getWindow().clearFlags(1024);
        }
    }

    public void jh(boolean z) {
        this.eKr = z;
    }

    public void boj() {
        this.eKu = true;
        boh();
    }
}
