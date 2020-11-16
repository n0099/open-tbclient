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
import com.baidu.tieba.d.f;
import com.baidu.tieba.person.e;
import com.baidu.tieba.view.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d {
    protected ImageView agU;
    private View etA;
    private ImageView etB;
    private ImageView etC;
    private LinearLayout etD;
    private TextView etE;
    private View.OnClickListener etG;
    private View etH;
    private MorePopupWindow etI;
    protected View etJ;
    private View etK;
    private View etL;
    private e etO;
    private View etQ;
    private BaseWebViewActivity etw;
    private TextView etx;
    private View ety;
    private ImageView etz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    protected View mRoot = null;
    private ContinuousAnimationView etF = null;
    private boolean etM = true;
    private boolean etN = false;
    public boolean etP = false;

    public d(BaseWebViewActivity baseWebViewActivity) {
        this.etw = baseWebViewActivity;
        initUI();
    }

    private void initUI() {
        this.etw.setContentView(R.layout.base_webview_activity_new);
        this.mRoot = this.etw.findViewById(R.id.root_view);
        this.mNavigationBar = (NavigationBar) this.etw.findViewById(R.id.view_navigation_bar);
        this.etQ = this.etw.findViewById(R.id.night_mode_overlay);
        this.mNavigationBar.showBottomLine();
        zS("");
        if (this.etw.isTranslucent()) {
            ap.setBackgroundColor(this.mRoot, this.etw.getResources().getColor(R.color.black_alpha0));
            this.mRoot.setOnClickListener(this.etw);
            this.mNavigationBar.setVisibility(8);
        }
        this.etD = (LinearLayout) this.etw.findViewById(R.id.webview_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.etD.setLayoutParams(layoutParams);
        this.etE = (TextView) this.etw.findViewById(R.id.webview_crash_tip);
        this.etF = (ContinuousAnimationView) this.etw.findViewById(R.id.webview_progress);
        ap.a(this.etF, R.raw.lottie_full_screen_refresh);
        this.ety = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_back, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.etw != null) {
                    if ((!(d.this.etw instanceof TbWebViewActivity) || !((TbWebViewActivity) d.this.etw).isDisableGoBack || !((TbWebViewActivity) d.this.etw).needDealClickGoBack()) && !d.this.etw.webViewGoBack()) {
                        d.this.etw.finish();
                    }
                }
            }
        });
        this.etz = (ImageView) this.ety.findViewById(R.id.widget_navi_back_button);
        this.etz.setContentDescription(this.etw.getResources().getString(R.string.back));
        this.etA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.etw != null) {
                    d.this.etw.finish();
                }
            }
        });
        this.etB = (ImageView) this.etA.findViewById(R.id.widget_navi_back_button);
        this.etB.setContentDescription(this.etw.getResources().getString(R.string.close));
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etB.getLayoutParams();
        layoutParams2.leftMargin = l.getDimens(this.etw.getPageContext().getPageActivity(), R.dimen.ds4);
        this.etB.setLayoutParams(layoutParams2);
        this.etH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_more, new View.OnClickListener() { // from class: com.baidu.tbadk.browser.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.biv()) {
                    d.this.biw();
                } else if (d.this.etC.getVisibility() != 0) {
                    d.this.aYU();
                }
            }
        });
        this.agU = (ImageView) this.etH.findViewById(R.id.widget_navi_more_button);
        this.etC = (ImageView) this.etH.findViewById(R.id.widget_navi_share_button);
        View inflate = LayoutInflater.from(this.etw.getPageContext().getPageActivity()).inflate(R.layout.tb_webview_pop_more, (ViewGroup) null);
        this.etI = new MorePopupWindow(this.etw.getPageContext().getPageActivity(), inflate, this.mNavigationBar, this.etw.getPageContext().getResources().getDrawable(R.drawable.bg_pull_down_right_n), new KeyEventDealContainerView.a() { // from class: com.baidu.tbadk.browser.d.4
            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void biB() {
                d.this.aYU();
            }

            @Override // com.baidu.tbadk.core.view.KeyEventDealContainerView.a
            public void biC() {
            }
        });
        this.etJ = inflate.findViewById(R.id.webview_more_pop_item_share_friend_layout);
        this.etJ.setOnClickListener(this.etw);
        if (g.eh(this.etw.getPageContext().getPageActivity())) {
            this.etJ.setVisibility(0);
        } else {
            this.etJ.setVisibility(8);
        }
        this.etI.refresh();
        this.etL = inflate.findViewById(R.id.webview_more_pop_item_open_browser_layout);
        this.etL.setOnClickListener(this.etw);
        this.etK = inflate.findViewById(R.id.webview_more_pop_item_copy_link_layout);
        this.etK.setOnClickListener(this.etw);
    }

    public void bir() {
        if (this.mNavigationBar != null && this.agU != null && this.etC != null) {
            this.agU.setVisibility(8);
            this.etC.setVisibility(0);
            this.etC.setOnClickListener(this.etw);
        }
    }

    public void nG(int i) {
        if (this.mNavigationBar != null && this.agU != null) {
            this.agU.setVisibility(i);
        }
    }

    public boolean bis() {
        return this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0;
    }

    public void bit() {
        if (this.mNavigationBar != null && this.mNavigationBar.getVisibility() == 0 && this.etB != null) {
            this.etB.setVisibility(8);
        }
    }

    public boolean biu() {
        try {
            this.etD.addView(this.etw.createWebView());
            this.etE.setVisibility(8);
            if (!this.etM) {
                this.mNavigationBar.setStatusBarVisibility(8);
            }
            return true;
        } catch (Exception e) {
            this.etE.setVisibility(0);
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public void setNavBarVisibility(boolean z) {
        if (z) {
            this.etD.getLayoutParams().height = -1;
            this.mNavigationBar.setVisibility(0);
            return;
        }
        this.etD.getLayoutParams().height = -1;
        this.mNavigationBar.setVisibility(8);
    }

    public void iu(boolean z) {
        if (this.etJ != null) {
            if (z) {
                this.etJ.setVisibility(0);
            } else {
                this.etJ.setVisibility(8);
            }
            this.etI.refresh();
        }
    }

    public void iv(boolean z) {
        if (this.etH != null) {
            if (z) {
                this.etH.setVisibility(0);
            } else {
                this.etH.setVisibility(8);
            }
        }
    }

    public boolean biv() {
        return this.etN;
    }

    public void iw(boolean z) {
        this.etN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biw() {
        if (this.etO == null) {
            com.baidu.tieba.view.a aVar = new com.baidu.tieba.view.a(this.etw);
            ArrayList arrayList = new ArrayList();
            a.C0873a c0873a = new a.C0873a(this.etw.getString(R.string.report_text), aVar);
            c0873a.a(new a.c() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tieba.view.a.c
                public void onClick() {
                    if (d.this.etO != null && d.this.etw != null) {
                        d.this.etO.dismiss();
                        FrsActivityConfig createNormalCfg = new FrsActivityConfig(d.this.etw).createNormalCfg(d.this.etw.getResources().getString(R.string.user_feedback), null);
                        createNormalCfg.setCallFrom(12);
                        d.this.etw.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
                    }
                }
            });
            arrayList.add(c0873a);
            aVar.a(new a.b() { // from class: com.baidu.tbadk.browser.d.6
                @Override // com.baidu.tieba.view.a.b
                public void onClick() {
                    if (d.this.etO != null) {
                        d.this.etO.dismiss();
                    }
                }
            });
            aVar.br(arrayList);
            this.etO = new e(this.etw, aVar.bow());
            this.etO.Z(0.7f);
        }
        this.etO.show();
    }

    public void aYU() {
        this.etI.showWindowInRightBottomOfHost();
    }

    public void aYV() {
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.etI, this.etw.getPageContext().getPageActivity());
    }

    public void showProgressBar() {
        if (TbSingleton.getInstance().isCanWebViewActivityShowProgress()) {
            this.etF.setVisibility(0);
            this.etF.playAnimation();
        }
    }

    public void hideProgressBar() {
        this.etF.setVisibility(8);
        this.etF.cancelAnimation();
    }

    public void showCrashTip() {
        this.etE.setVisibility(0);
    }

    public void hideCrashTip() {
        this.etE.setVisibility(8);
    }

    public void zS(String str) {
        if (this.mNavigationBar != null) {
            this.etx = this.mNavigationBar.setCenterTextTitle(str);
            if (this.etz != null && this.etz.getVisibility() == 0 && this.etB != null && this.etB.getVisibility() == 0) {
                this.etx.setMaxWidth(l.getDimens(this.etw.getPageContext().getPageActivity(), R.dimen.ds152) * 2);
            }
            if (!this.etP) {
                ap.setNavbarTitleColor(this.etx, R.color.CAM_X0105, R.color.s_navbar_title_color);
            } else {
                this.etx.setTextColor(-1);
            }
        }
    }

    public void showShareDialog(ShareItem shareItem) {
        if (shareItem != null) {
            TiebaStatic.eventStat(this.etw.getPageContext().getPageActivity(), TbConfig.TMP_SHARE_DIR_NAME, "click", 1, new Object[0]);
            ar arVar = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar.dR(TiebaInitialize.Params.OBJ_URL, shareItem.linkUrl);
            arVar.ak("obj_type", 0);
            TiebaStatic.log(arVar);
            if (shareItem.ffY) {
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.etw, shareItem, true, (SparseArray<String>) null);
                shareDialogConfig.mShowMoreForumShare = true;
                f.coW().b(shareDialogConfig);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, new ShareDialogConfig((Context) this.etw, shareItem, true, bix())));
        }
    }

    private SparseArray<String> bix() {
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
        if (this.etF != null) {
            ap.a(this.etF, R.raw.lottie_full_screen_refresh);
        }
        if (this.etI != null) {
            this.etI.onChangeSkinType(this.etw, i, ap.getDrawable(R.drawable.bg_pull_down_right_n));
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.etw.getPageContext(), i);
        }
        if (!this.etP) {
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.etw.getPageContext(), i);
            }
            SvgManager.bqB().a(this.etz, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.etB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.agU, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.etC, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else if (i == 1) {
            this.etQ.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.etD.setVisibility(0);
        }
    }

    public void showNoDataView() {
        int a2 = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.etw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), NoDataViewFactory.d.dS(null, this.etw.getPageContext().getString(R.string.url_not_found)), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.etw.getResources().getString(R.string.refresh), this.etG)));
        }
        if (!j.isNetworkAvailableForImmediately()) {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, a2), this.etw.getPageContext());
        } else {
            this.mNoDataView.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.WEBVIEW, a2), this.etw.getPageContext());
        }
        this.etD.setVisibility(8);
        this.mNoDataView.setVisibility(0);
    }

    public void g(View.OnClickListener onClickListener) {
        this.etG = onClickListener;
    }

    public void release() {
        if (this.etD != null) {
            this.etD.removeAllViews();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.etI != null) {
            com.baidu.adp.lib.f.g.dismissPopupWindow(this.etI, this.etw.getPageContext().getPageActivity());
        }
    }

    public void setFullScreen() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, 0);
        layoutParams.height = -1;
        this.etD.setLayoutParams(layoutParams);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.showBottomLine(false);
        }
        ap.setBackgroundResource(this.etz, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.etB, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.agU, R.drawable.frs_star_navigation_bg);
        ap.setBackgroundResource(this.etC, R.drawable.frs_star_navigation_bg);
        zS("");
        this.etw.getWindow().setFlags(1024, 1024);
    }

    public void biy() {
        if (this.etD != null) {
            this.etD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.mNavigationBar != null && this.agU != null && this.etC != null) {
            this.mNavigationBar.setBackgroundDrawable(null);
            this.mNavigationBar.setBackgroundColor(R.color.transparent);
            this.mNavigationBar.setBackgroundResource(R.drawable.transparent_bg);
            this.agU.setVisibility(8);
            this.etC.setVisibility(0);
            this.etC.setOnClickListener(this.etw);
            this.etx.setTextColor(-1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etC.getLayoutParams();
            layoutParams.width = l.getDimens(this.etw, R.dimen.tbds100);
            layoutParams.height = l.getDimens(this.etw, R.dimen.tbds100);
            SvgManager.bqB().a(this.etB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.etz, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.bqB().a(this.etC, R.drawable.icon_pure_topbar_share44_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void biz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etD.getLayoutParams();
        layoutParams.addRule(3, R.id.view_navigation_bar);
        this.etD.setLayoutParams(layoutParams);
        if (this.etz != null) {
            this.etz.setBackgroundDrawable(null);
        }
        if (this.etB != null) {
            this.etB.setBackgroundDrawable(null);
        }
        if (this.agU != null) {
            this.agU.setBackgroundDrawable(null);
        }
        if (this.etC != null) {
            this.etC.setBackgroundDrawable(null);
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.showBottomLine(true);
        }
        if (this.etw != null) {
            this.etw.getWindow().clearFlags(1024);
        }
    }

    public void ix(boolean z) {
        this.etM = z;
    }

    public void biA() {
        this.etP = true;
        biy();
    }
}
