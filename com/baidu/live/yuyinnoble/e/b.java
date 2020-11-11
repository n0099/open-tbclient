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
    private boolean bUd;
    private com.baidu.live.yuyinnoble.c.a bUg;
    private com.baidu.live.yuyinnoble.e.a bUq;
    private com.baidu.live.yuyinnoble.a.a bUr;
    private a bUs;
    private LinearLayout bUt;
    private TextView bUu;
    private String bnP;
    private LinearLayout bpE;
    private RelativeLayout bpG;
    private TextView bpH;
    private ImageView bpI;
    private CommonEmptyView bpJ;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Oy();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.bUd = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bnP = str2;
        this.mIsHost = z;
        this.bUd = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.bpG = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bpH = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bpH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bpI = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bpI.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bUt = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.bUu = (TextView) this.bUt.findViewById(a.f.tv_footer);
        this.mListView.addFooterView(this.bUt);
        this.bUt.setVisibility(0);
        this.bpJ = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bUr = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bnP, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bUr);
        if (this.bUd) {
            this.bpI.setVisibility(0);
        } else {
            this.bpI.setVisibility(8);
        }
        OI();
    }

    private void OI() {
        this.bpE = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bUq = new com.baidu.live.yuyinnoble.e.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bUq != null && this.bUq.getRootView() != null && this.bUq.getRootView().getParent() == null) {
            this.bpE.addView(this.bUq.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar == null) {
            cm(true);
            return;
        }
        if (ListUtils.isEmpty(aVar.list)) {
            dq(true);
        } else {
            this.bUr.setList(aVar.list);
            this.mListView.setVisibility(0);
            OJ();
        }
        this.bUg = aVar;
        this.bpG.setVisibility(0);
        this.bpH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(aVar.bpi)));
        if (this.mIsHost) {
            this.bpE.setVisibility(8);
        } else if (this.bUd) {
            this.bpE.setVisibility(0);
            this.bUq.b(aVar);
        } else {
            this.bpE.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpI && !UtilHelper.isFastDoubleClick() && this.bUg != null && !StringUtils.isNull(this.bUg.bpj)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bUg.bpj});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bpE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bpE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dq(boolean z) {
        if (z) {
            gB(8);
            this.bpJ.reset();
            this.bpJ.setTitle("还没有贵族哦~");
            this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.bpJ.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            this.bpJ.setVisibility(0);
        } else {
            this.bpJ.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cm(boolean z) {
        gB(8);
        if (this.bpJ != null) {
            this.bpJ.reset();
            if (z) {
                this.bpJ.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.e.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bUs != null) {
                            b.this.bUs.Oy();
                        }
                    }
                });
                this.bpJ.setTitle("网络加载失败了哦~");
                this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.bpJ.setTextColor(this.mTbPageContext.getResources().getColor(a.c.sdk_color_525252));
            }
            this.bpJ.setVisibility(0);
        }
        if (z) {
            this.bpG.setVisibility(8);
            this.bpE.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void OJ() {
        if (this.bpJ != null) {
            this.bpJ.setVisibility(8);
        }
        gB(0);
    }

    public void a(a aVar) {
        this.bUs = aVar;
    }

    public void gB(int i) {
        if (this.bUt != null) {
            this.bUt.setVisibility(i);
        }
    }
}
