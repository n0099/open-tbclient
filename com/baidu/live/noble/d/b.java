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
    private String bla;
    private LinearLayout bmN;
    private com.baidu.live.noble.d.a bmO;
    private RelativeLayout bmP;
    private TextView bmQ;
    private ImageView bmR;
    private CommonEmptyView bmS;
    private com.baidu.live.noble.a.a bmT;
    private a bmU;
    private boolean bmV;
    private com.baidu.live.noble.data.b bmi;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void NB();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bmV = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bla = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.bmP = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.bmQ = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.bmQ.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bmR = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bmR.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bmT = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bla, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bmT);
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (bjVar != null && bjVar.aNY != null && (!bjVar.aNY.aQk || !bjVar.aNY.aQl)) {
            this.bmV = false;
        }
        NL();
        if (this.bmV) {
            this.bmR.setVisibility(0);
        } else {
            this.bmR.setVisibility(8);
        }
    }

    private void NL() {
        this.bmN = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bmO = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bmO != null && this.bmO.getRootView() != null && this.bmO.getRootView().getParent() == null) {
            this.bmN.addView(this.bmO.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bmN.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bmN.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cj(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cj(false);
        } else {
            this.bmT.setList(bVar.list);
            this.mListView.setVisibility(0);
            NM();
        }
        this.bmi = bVar;
        this.bmP.setVisibility(0);
        this.bmQ.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bms)));
        if (this.mIsHost) {
            this.bmN.setVisibility(8);
        } else if (this.bmV) {
            this.bmN.setVisibility(0);
            this.bmO.b(bVar);
        } else {
            this.bmN.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bmR && !UtilHelper.isFastDoubleClick() && this.bmi != null && !StringUtils.isNull(this.bmi.bmt)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bmi.bmt});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bmN.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bmN.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cj(boolean z) {
        if (this.bmS != null) {
            this.bmS.reset();
            if (z) {
                this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bmU != null) {
                            b.this.bmU.NB();
                        }
                    }
                });
                this.bmS.setTitle(a.i.sdk_net_no);
                this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bmS.setTitle(a.i.noble_list_empty_title);
                this.bmS.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bmS.setVisibility(0);
        }
        if (z) {
            this.bmP.setVisibility(8);
            this.bmN.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void NM() {
        if (this.bmS != null) {
            this.bmS.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bmU = aVar;
    }
}
