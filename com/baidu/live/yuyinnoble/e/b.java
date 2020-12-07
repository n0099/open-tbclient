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
    private boolean bXJ;
    private com.baidu.live.yuyinnoble.c.a bXM;
    private com.baidu.live.yuyinnoble.e.a bXW;
    private com.baidu.live.yuyinnoble.a.a bXX;
    private a bXY;
    private LinearLayout bXZ;
    private TextView bYa;
    private String brl;
    private LinearLayout btb;
    private RelativeLayout btd;
    private TextView bte;
    private ImageView btf;
    private CommonEmptyView btg;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Qi();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.bXJ = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.mIsHost = z;
        this.bXJ = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.btd = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bte = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bte.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.btf = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.btf.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bXZ = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.bYa = (TextView) this.bXZ.findViewById(a.f.tv_footer);
        this.mListView.addFooterView(this.bXZ);
        this.bXZ.setVisibility(0);
        this.btg = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bXX = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.brl, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bXX);
        if (this.bXJ) {
            this.btf.setVisibility(0);
        } else {
            this.btf.setVisibility(8);
        }
        Qs();
    }

    private void Qs() {
        this.btb = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bXW = new com.baidu.live.yuyinnoble.e.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bXW != null && this.bXW.getRootView() != null && this.bXW.getRootView().getParent() == null) {
            this.btb.addView(this.bXW.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar == null) {
            cC(true);
            return;
        }
        if (ListUtils.isEmpty(aVar.list)) {
            dG(true);
        } else {
            this.bXX.setList(aVar.list);
            this.mListView.setVisibility(0);
            Qt();
        }
        this.bXM = aVar;
        this.btd.setVisibility(0);
        this.bte.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(aVar.bsF)));
        if (this.mIsHost) {
            this.btb.setVisibility(8);
        } else if (this.bXJ) {
            this.btb.setVisibility(0);
            this.bXW.b(aVar);
        } else {
            this.btb.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btf && !UtilHelper.isFastDoubleClick() && this.bXM != null && !StringUtils.isNull(this.bXM.bsG)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bXM.bsG});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.btb.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.btb.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dG(boolean z) {
        if (z) {
            gV(8);
            this.btg.reset();
            this.btg.setTitle("还没有贵族哦~");
            this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.btg.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.btg.setVisibility(0);
        } else {
            this.btg.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cC(boolean z) {
        gV(8);
        if (this.btg != null) {
            this.btg.reset();
            if (z) {
                this.btg.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.e.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bXY != null) {
                            b.this.bXY.Qi();
                        }
                    }
                });
                this.btg.setTitle("网络加载失败了哦~");
                this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.btg.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.btg.setVisibility(0);
        }
        if (z) {
            this.btd.setVisibility(8);
            this.btb.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Qt() {
        if (this.btg != null) {
            this.btg.setVisibility(8);
        }
        gV(0);
    }

    public void a(a aVar) {
        this.bXY = aVar;
    }

    public void gV(int i) {
        if (this.bXZ != null) {
            this.bXZ.setVisibility(i);
        }
    }
}
