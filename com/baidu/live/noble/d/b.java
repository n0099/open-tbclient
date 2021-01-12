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
import com.baidu.live.data.bq;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private String bre;
    private com.baidu.live.noble.data.b bsw;
    private LinearLayout bta;
    private com.baidu.live.noble.d.a btb;
    private RelativeLayout btc;
    private TextView btd;
    private ImageView bte;
    private CommonEmptyView btf;
    private com.baidu.live.noble.a.a btg;
    private a bth;
    private boolean bti;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void Nq();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bti = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.btc = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.btd = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.btd.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bte = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bte.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.btf = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.btg = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bre, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.btg);
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (bqVar != null && bqVar.aMR != null && (!bqVar.aMR.aPy || !bqVar.aMR.aPz)) {
            this.bti = false;
        }
        NB();
        if (this.bti) {
            this.bte.setVisibility(0);
        } else {
            this.bte.setVisibility(8);
        }
    }

    private void NB() {
        this.bta = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.btb = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.btb != null && this.btb.getRootView() != null && this.btb.getRootView().getParent() == null) {
            this.bta.addView(this.btb.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bta.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bta.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cB(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cB(false);
        } else {
            this.btg.setList(bVar.list);
            this.mListView.setVisibility(0);
            NC();
        }
        this.bsw = bVar;
        this.btc.setVisibility(0);
        this.btd.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bsC)));
        if (this.mIsHost) {
            this.bta.setVisibility(8);
        } else if (this.bti) {
            this.bta.setVisibility(0);
            this.btb.b(bVar);
        } else {
            this.bta.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bte && !UtilHelper.isFastDoubleClick() && this.bsw != null && !StringUtils.isNull(this.bsw.bsD)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bsw.bsD});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bta.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bta.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cB(boolean z) {
        if (this.btf != null) {
            this.btf.reset();
            if (z) {
                this.btf.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bth != null) {
                            b.this.bth.Nq();
                        }
                    }
                });
                this.btf.setTitle(a.h.sdk_net_no);
                this.btf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.btf.setTitle(a.h.noble_list_empty_title);
                this.btf.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.btf.setVisibility(0);
        }
        if (z) {
            this.btc.setVisibility(8);
            this.bta.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void NC() {
        if (this.btf != null) {
            this.btf.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bth = aVar;
    }
}
