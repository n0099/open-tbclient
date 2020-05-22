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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private String aWr;
    private com.baidu.live.noble.data.b aXz;
    private LinearLayout aYe;
    private com.baidu.live.noble.d.a aYf;
    private RelativeLayout aYg;
    private TextView aYh;
    private ImageView aYi;
    private CommonEmptyView aYj;
    private com.baidu.live.noble.a.a aYk;
    private a aYl;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void FC();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aWr = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.aYg = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.aYh = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.aYh.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.aYi = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.aYi.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.aYj = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.aYk = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.aWr, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.aYk);
        FM();
    }

    private void FM() {
        this.aYe = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.aYf = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.aYf != null && this.aYf.getRootView() != null && this.aYf.getRootView().getParent() == null) {
            this.aYe.addView(this.aYf.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.aYe.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.aYe.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            bU(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            bU(false);
        } else {
            this.aYk.setList(bVar.list);
            this.mListView.setVisibility(0);
            FN();
        }
        this.aXz = bVar;
        this.aYg.setVisibility(0);
        this.aYh.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.aXJ)));
        if (this.mIsHost) {
            this.aYe.setVisibility(8);
            return;
        }
        this.aYe.setVisibility(0);
        this.aYf.b(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aYi && !UtilHelper.isFastDoubleClick() && this.aXz != null && !StringUtils.isNull(this.aXz.aXK)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.aXz.aXK});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aYe.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.aYe.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void bU(boolean z) {
        if (this.aYj != null) {
            this.aYj.reset();
            if (z) {
                this.aYj.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.aYl != null) {
                            b.this.aYl.FC();
                        }
                    }
                });
                this.aYj.setTitle(a.i.sdk_net_no);
                this.aYj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.aYj.setTitle(a.i.noble_list_empty_title);
                this.aYj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.aYj.setVisibility(0);
        }
        if (z) {
            this.aYg.setVisibility(8);
            this.aYe.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void FN() {
        if (this.aYj != null) {
            this.aYj.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.aYl = aVar;
    }
}
