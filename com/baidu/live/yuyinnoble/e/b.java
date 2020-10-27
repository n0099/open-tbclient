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
    private com.baidu.live.yuyinnoble.e.a bOG;
    private com.baidu.live.yuyinnoble.a.a bOH;
    private a bOI;
    private LinearLayout bOJ;
    private TextView bOK;
    private boolean bOt;
    private com.baidu.live.yuyinnoble.c.a bOw;
    private String bmv;
    private LinearLayout bol;
    private RelativeLayout bon;
    private TextView boo;
    private ImageView bop;
    private CommonEmptyView boq;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void NY();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z, boolean z2) {
        this.bOt = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bmv = str2;
        this.mIsHost = z;
        this.bOt = z2;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.yuyin_ala_noble_list_main_layout, (ViewGroup) null);
        this.bon = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.boo = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.boo.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bop = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bop.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.bOJ = (LinearLayout) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.yuyin_noble_list_footer_view, (ViewGroup) null);
        this.bOK = (TextView) this.bOJ.findViewById(a.g.tv_footer);
        this.mListView.addFooterView(this.bOJ);
        this.bOJ.setVisibility(0);
        this.boq = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bOH = new com.baidu.live.yuyinnoble.a.a(this.mTbPageContext, this.mLiveId, this.bmv, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bOH);
        if (this.bOt) {
            this.bop.setVisibility(0);
        } else {
            this.bop.setVisibility(8);
        }
        Oi();
    }

    private void Oi() {
        this.bol = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bOG = new com.baidu.live.yuyinnoble.e.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bOG != null && this.bOG.getRootView() != null && this.bOG.getRootView().getParent() == null) {
            this.bol.addView(this.bOG.getRootView(), layoutParams);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.yuyinnoble.c.a aVar) {
        if (aVar == null) {
            cl(true);
            return;
        }
        if (ListUtils.isEmpty(aVar.list)) {
            dj(true);
        } else {
            this.bOH.setList(aVar.list);
            this.mListView.setVisibility(0);
            Oj();
        }
        this.bOw = aVar;
        this.bon.setVisibility(0);
        this.boo.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(aVar.bnP)));
        if (this.mIsHost) {
            this.bol.setVisibility(8);
        } else if (this.bOt) {
            this.bol.setVisibility(0);
            this.bOG.b(aVar);
        } else {
            this.bol.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bop && !UtilHelper.isFastDoubleClick() && this.bOw != null && !StringUtils.isNull(this.bOw.bnQ)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bOw.bnQ});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bol.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bol.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void dj(boolean z) {
        if (z) {
            gr(8);
            this.boq.reset();
            this.boq.setTitle("还没有贵族哦~");
            this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            this.boq.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_color_525252));
            this.boq.setVisibility(0);
        } else {
            this.boq.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void cl(boolean z) {
        gr(8);
        if (this.boq != null) {
            this.boq.reset();
            if (z) {
                this.boq.setRefreshButton("点击重试", new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.e.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bOI != null) {
                            b.this.bOI.NY();
                        }
                    }
                });
                this.boq.setTitle("网络加载失败了哦~");
                this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
                this.boq.setTextColor(this.mTbPageContext.getResources().getColor(a.d.sdk_color_525252));
            }
            this.boq.setVisibility(0);
        }
        if (z) {
            this.bon.setVisibility(8);
            this.bol.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Oj() {
        if (this.boq != null) {
            this.boq.setVisibility(8);
        }
        gr(0);
    }

    public void a(a aVar) {
        this.bOI = aVar;
    }

    public void gr(int i) {
        if (this.bOJ != null) {
            this.bOJ.setVisibility(i);
        }
    }
}
