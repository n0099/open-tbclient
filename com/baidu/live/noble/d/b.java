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
import com.baidu.live.data.be;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes7.dex */
public class b implements View.OnClickListener {
    private String beu;
    private com.baidu.live.noble.data.b bfD;
    private LinearLayout bgi;
    private com.baidu.live.noble.d.a bgj;
    private RelativeLayout bgk;
    private TextView bgl;
    private ImageView bgm;
    private CommonEmptyView bgn;
    private com.baidu.live.noble.a.a bgo;
    private a bgp;
    private boolean bgq;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes7.dex */
    public interface a {
        void LT();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bgq = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.beu = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.bgk = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.bgl = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.bgl.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bgm = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bgm.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.bgn = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bgo = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.beu, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bgo);
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (beVar != null && beVar.aJD != null && (!beVar.aJD.aLx || !beVar.aJD.aLy)) {
            this.bgq = false;
        }
        Md();
        if (this.bgq) {
            this.bgm.setVisibility(0);
        } else {
            this.bgm.setVisibility(8);
        }
    }

    private void Md() {
        this.bgi = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bgj = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bgj != null && this.bgj.getRootView() != null && this.bgj.getRootView().getParent() == null) {
            this.bgi.addView(this.bgj.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bgi.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bgi.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cf(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cf(false);
        } else {
            this.bgo.setList(bVar.list);
            this.mListView.setVisibility(0);
            Me();
        }
        this.bfD = bVar;
        this.bgk.setVisibility(0);
        this.bgl.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bfN)));
        if (this.mIsHost) {
            this.bgi.setVisibility(8);
        } else if (this.bgq) {
            this.bgi.setVisibility(0);
            this.bgj.b(bVar);
        } else {
            this.bgi.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgm && !UtilHelper.isFastDoubleClick() && this.bfD != null && !StringUtils.isNull(this.bfD.bfO)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bfD.bfO});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bgi.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bgi.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cf(boolean z) {
        if (this.bgn != null) {
            this.bgn.reset();
            if (z) {
                this.bgn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bgp != null) {
                            b.this.bgp.LT();
                        }
                    }
                });
                this.bgn.setTitle(a.i.sdk_net_no);
                this.bgn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bgn.setTitle(a.i.noble_list_empty_title);
                this.bgn.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bgn.setVisibility(0);
        }
        if (z) {
            this.bgk.setVisibility(8);
            this.bgi.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Me() {
        if (this.bgn != null) {
            this.bgn.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bgp = aVar;
    }
}
