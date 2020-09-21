package com.baidu.live.noble.d;

import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.bj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String bhk;
    private com.baidu.live.noble.data.b biv;
    private LinearLayout bja;
    private com.baidu.live.noble.d.a bjb;
    private RelativeLayout bjc;
    private TextView bjd;
    private ImageView bje;
    private CommonEmptyView bjf;
    private com.baidu.live.noble.a.a bjg;
    private a bjh;
    private boolean bji;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Mw();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bji = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bhk = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.bjc = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.bjd = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.bjd.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bje = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bje.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.bjf = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bjg = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bhk, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bjg);
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (bjVar != null && bjVar.aKT != null && (!bjVar.aKT.aNf || !bjVar.aKT.aNg)) {
            this.bji = false;
        }
        MG();
        if (this.bji) {
            this.bje.setVisibility(0);
        } else {
            this.bje.setVisibility(8);
        }
    }

    private void MG() {
        this.bja = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bjb = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bjb != null && this.bjb.getRootView() != null && this.bjb.getRootView().getParent() == null) {
            this.bja.addView(this.bjb.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bja.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bja.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cg(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cg(false);
        } else {
            this.bjg.setList(bVar.list);
            this.mListView.setVisibility(0);
            MH();
        }
        this.biv = bVar;
        this.bjc.setVisibility(0);
        this.bjd.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.biF)));
        if (this.mIsHost) {
            this.bja.setVisibility(8);
        } else if (this.bji) {
            this.bja.setVisibility(0);
            this.bjb.b(bVar);
        } else {
            this.bja.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bje && !UtilHelper.isFastDoubleClick() && this.biv != null && !StringUtils.isNull(this.biv.biG)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.biv.biG});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bja.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bja.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cg(boolean z) {
        if (this.bjf != null) {
            this.bjf.reset();
            if (z) {
                this.bjf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bjh != null) {
                            b.this.bjh.Mw();
                        }
                    }
                });
                this.bjf.setTitle(a.i.sdk_net_no);
                this.bjf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bjf.setTitle(a.i.noble_list_empty_title);
                this.bjf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bjf.setVisibility(0);
        }
        if (z) {
            this.bjc.setVisibility(8);
            this.bja.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void MH() {
        if (this.bjf != null) {
            this.bjf.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bjh = aVar;
    }
}
