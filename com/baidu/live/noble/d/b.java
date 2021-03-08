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
import com.baidu.live.data.bv;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes10.dex */
public class b implements View.OnClickListener {
    private String bwh;
    private com.baidu.live.noble.data.b bxA;
    private LinearLayout bye;
    private com.baidu.live.noble.d.a byf;
    private RelativeLayout byg;
    private TextView byh;
    private ImageView byi;
    private CommonEmptyView byj;
    private com.baidu.live.noble.a.a byk;
    private a byl;
    private boolean bym;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void OS();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bym = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.byg = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.byh = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.byh.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.byi = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.byi.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.byj = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.byk = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.bwh, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.byk);
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar != null && bvVar.aRp != null && (!bvVar.aRp.aUa || !bvVar.aRp.aUb)) {
            this.bym = false;
        }
        Pd();
        if (this.bym) {
            this.byi.setVisibility(0);
        } else {
            this.byi.setVisibility(8);
        }
    }

    private void Pd() {
        this.bye = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.byf = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.byf != null && this.byf.getRootView() != null && this.byf.getRootView().getParent() == null) {
            this.bye.addView(this.byf.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bye.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bye.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            cK(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            cK(false);
        } else {
            this.byk.setList(bVar.list);
            this.mListView.setVisibility(0);
            Pe();
        }
        this.bxA = bVar;
        this.byg.setVisibility(0);
        this.byh.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bxG)));
        if (this.mIsHost) {
            this.bye.setVisibility(8);
        } else if (this.bym) {
            this.bye.setVisibility(0);
            this.byf.b(bVar);
        } else {
            this.bye.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.byi && !UtilHelper.isFastDoubleClick() && this.bxA != null && !StringUtils.isNull(this.bxA.bxH)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bxA.bxH});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bye.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bye.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cK(boolean z) {
        if (this.byj != null) {
            this.byj.reset();
            if (z) {
                this.byj.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.byl != null) {
                            b.this.byl.OS();
                        }
                    }
                });
                this.byj.setTitle(a.h.sdk_net_no);
                this.byj.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.byj.setTitle(a.h.noble_list_empty_title);
                this.byj.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.byj.setVisibility(0);
        }
        if (z) {
            this.byg.setVisibility(8);
            this.bye.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Pe() {
        if (this.byj != null) {
            this.byj.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.byl = aVar;
    }
}
