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
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private String bvS;
    private LinearLayout bxO;
    private com.baidu.live.noble.d.a bxP;
    private RelativeLayout bxQ;
    private TextView bxR;
    private ImageView bxS;
    private CommonEmptyView bxT;
    private com.baidu.live.noble.a.a bxU;
    private a bxV;
    private boolean bxW;
    private com.baidu.live.noble.data.b bxk;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void Rl();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bxW = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.bxQ = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bxR = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bxR.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bxS = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bxS.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bxU = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bvS, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bxU);
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (bqVar != null && bqVar.aRE != null && (!bqVar.aRE.aUl || !bqVar.aRE.aUm)) {
            this.bxW = false;
        }
        Rw();
        if (this.bxW) {
            this.bxS.setVisibility(0);
        } else {
            this.bxS.setVisibility(8);
        }
    }

    private void Rw() {
        this.bxO = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bxP = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bxP != null && this.bxP.getRootView() != null && this.bxP.getRootView().getParent() == null) {
            this.bxO.addView(this.bxP.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bxO.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bxO.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cF(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cF(false);
        } else {
            this.bxU.setList(bVar.list);
            this.mListView.setVisibility(0);
            Rx();
        }
        this.bxk = bVar;
        this.bxQ.setVisibility(0);
        this.bxR.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bxq)));
        if (this.mIsHost) {
            this.bxO.setVisibility(8);
        } else if (this.bxW) {
            this.bxO.setVisibility(0);
            this.bxP.b(bVar);
        } else {
            this.bxO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bxS && !UtilHelper.isFastDoubleClick() && this.bxk != null && !StringUtils.isNull(this.bxk.bxr)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bxk.bxr});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bxO.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bxO.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cF(boolean z) {
        if (this.bxT != null) {
            this.bxT.reset();
            if (z) {
                this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bxV != null) {
                            b.this.bxV.Rl();
                        }
                    }
                });
                this.bxT.setTitle(a.h.sdk_net_no);
                this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bxT.setTitle(a.h.noble_list_empty_title);
                this.bxT.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bxT.setVisibility(0);
        }
        if (z) {
            this.bxQ.setVisibility(8);
            this.bxO.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Rx() {
        if (this.bxT != null) {
            this.bxT.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bxV = aVar;
    }
}
