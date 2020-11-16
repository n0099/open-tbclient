package com.baidu.live.yuyinnoble.e;

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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private com.baidu.live.yuyinnoble.e.a bSG;
    private com.baidu.live.yuyinnoble.a.a bSH;
    private a bSI;
    private LinearLayout bSJ;
    private TextView bSK;
    private boolean bSt;
    private com.baidu.live.yuyinnoble.c.a bSw;
    private String bme;
    private LinearLayout bnT;
    private RelativeLayout bnV;
    private TextView bnW;
    private ImageView bnX;
    private CommonEmptyView bnY;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void NP();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.bSt = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bme = str2;
        this.mIsHost = z;
        this.bSt = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.bnV = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bnW = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bnW.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bnX = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bnX.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bSJ = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.bSK = (TextView) this.bSJ.findViewById(a.f.tv_footer);
        this.mListView.addFooterView(this.bSJ);
        this.bSJ.setVisibility(0);
        this.bnY = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bSH = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bme, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bSH);
        if (this.bSt) {
            this.bnX.setVisibility(0);
        } else {
            this.bnX.setVisibility(8);
        }
        NZ();
    }

    private void NZ() {
        this.bnT = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bSG = new com.baidu.live.yuyinnoble.e.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bSG != null && this.bSG.getRootView() != null && this.bSG.getRootView().getParent() == null) {
            this.bnT.addView(this.bSG.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar == null) {
            co(true);
            return;
        }
        if (ListUtils.isEmpty(aVar.list)) {
            ds(true);
        } else {
            this.bSH.setList(aVar.list);
            this.mListView.setVisibility(0);
            Oa();
        }
        this.bSw = aVar;
        this.bnV.setVisibility(0);
        this.bnW.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(aVar.bnx)));
        if (this.mIsHost) {
            this.bnT.setVisibility(8);
        } else if (this.bSt) {
            this.bnT.setVisibility(0);
            this.bSG.b(aVar);
        } else {
            this.bnT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bnX && !UtilHelper.isFastDoubleClick() && this.bSw != null && !StringUtils.isNull(this.bSw.bny)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bSw.bny});
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

    public void ds(boolean z) {
        if (z) {
            gx(8);
            this.bnY.reset();
            this.bnY.setTitle("还没有贵族哦~");
            this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bnY.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.bnY.setVisibility(0);
        } else {
            this.bnY.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void co(boolean z) {
        gx(8);
        if (this.bnY != null) {
            this.bnY.reset();
            if (z) {
                this.bnY.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.e.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bSI != null) {
                            b.this.bSI.NP();
                        }
                    }
                });
                this.bnY.setTitle("网络加载失败了哦~");
                this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.bnY.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
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
        gx(0);
    }

    public void a(a aVar) {
        this.bSI = aVar;
    }

    public void gx(int i) {
        if (this.bSJ != null) {
            this.bSJ.setVisibility(i);
        }
    }
}
