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
import com.baidu.live.data.bn;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String bme;
    private LinearLayout bnT;
    private com.baidu.live.noble.d.a bnU;
    private RelativeLayout bnV;
    private TextView bnW;
    private ImageView bnX;
    private CommonEmptyView bnY;
    private com.baidu.live.noble.a.a bnZ;
    private com.baidu.live.noble.data.b bnr;
    private a boa;
    private boolean bob;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void NP();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bob = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bme = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.bnV = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bnW = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bnW.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bnX = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bnX.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bnZ = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bme, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bnZ);
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (bnVar != null && bnVar.aNP != null && (!bnVar.aNP.aQl || !bnVar.aNP.aQm)) {
            this.bob = false;
        }
        NZ();
        if (this.bob) {
            this.bnX.setVisibility(0);
        } else {
            this.bnX.setVisibility(8);
        }
    }

    private void NZ() {
        this.bnT = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bnU = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bnU != null && this.bnU.getRootView() != null && this.bnU.getRootView().getParent() == null) {
            this.bnT.addView(this.bnU.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bnT.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bnT.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            co(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            co(false);
        } else {
            this.bnZ.setList(bVar.list);
            this.mListView.setVisibility(0);
            Oa();
        }
        this.bnr = bVar;
        this.bnV.setVisibility(0);
        this.bnW.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bnx)));
        if (this.mIsHost) {
            this.bnT.setVisibility(8);
        } else if (this.bob) {
            this.bnT.setVisibility(0);
            this.bnU.b(bVar);
        } else {
            this.bnT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bnX && !UtilHelper.isFastDoubleClick() && this.bnr != null && !StringUtils.isNull(this.bnr.bny)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bnr.bny});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bnT.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bnT.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void co(boolean z) {
        if (this.bnY != null) {
            this.bnY.reset();
            if (z) {
                this.bnY.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.boa != null) {
                            b.this.boa.NP();
                        }
                    }
                });
                this.bnY.setTitle(a.h.sdk_net_no);
                this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bnY.setTitle(a.h.noble_list_empty_title);
                this.bnY.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bnY.setVisibility(0);
        }
        if (z) {
            this.bnV.setVisibility(8);
            this.bnT.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Oa() {
        if (this.bnY != null) {
            this.bnY.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.boa = aVar;
    }
}
