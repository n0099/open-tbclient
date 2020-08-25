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
    private String ber;
    private com.baidu.live.noble.data.b bfB;
    private LinearLayout bgg;
    private com.baidu.live.noble.d.a bgh;
    private RelativeLayout bgi;
    private TextView bgj;
    private ImageView bgk;
    private CommonEmptyView bgl;
    private com.baidu.live.noble.a.a bgm;
    private a bgn;
    private boolean bgo;
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
        this.bgo = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.ber = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.bgi = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.bgj = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.bgj.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.bgk = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.bgk.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.bgl = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.bgm = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.ber, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bgm);
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (beVar != null && beVar.aJB != null && (!beVar.aJB.aLv || !beVar.aJB.aLw)) {
            this.bgo = false;
        }
        Md();
        if (this.bgo) {
            this.bgk.setVisibility(0);
        } else {
            this.bgk.setVisibility(8);
        }
    }

    private void Md() {
        this.bgg = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.bgh = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bgh != null && this.bgh.getRootView() != null && this.bgh.getRootView().getParent() == null) {
            this.bgg.addView(this.bgh.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bgg.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bgg.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
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
            this.bgm.setList(bVar.list);
            this.mListView.setVisibility(0);
            Me();
        }
        this.bfB = bVar;
        this.bgi.setVisibility(0);
        this.bgj.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bfL)));
        if (this.mIsHost) {
            this.bgg.setVisibility(8);
        } else if (this.bgo) {
            this.bgg.setVisibility(0);
            this.bgh.b(bVar);
        } else {
            this.bgg.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bgk && !UtilHelper.isFastDoubleClick() && this.bfB != null && !StringUtils.isNull(this.bfB.bfM)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bfB.bfM});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bgg.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bgg.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cf(boolean z) {
        if (this.bgl != null) {
            this.bgl.reset();
            if (z) {
                this.bgl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bgn != null) {
                            b.this.bgn.LT();
                        }
                    }
                });
                this.bgl.setTitle(a.i.sdk_net_no);
                this.bgl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bgl.setTitle(a.i.noble_list_empty_title);
                this.bgl.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bgl.setVisibility(0);
        }
        if (z) {
            this.bgi.setVisibility(8);
            this.bgg.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Me() {
        if (this.bgl != null) {
            this.bgl.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bgn = aVar;
    }
}
