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
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private String buH;
    private LinearLayout bwE;
    private com.baidu.live.noble.d.a bwF;
    private RelativeLayout bwG;
    private TextView bwH;
    private ImageView bwI;
    private CommonEmptyView bwJ;
    private com.baidu.live.noble.a.a bwK;
    private a bwL;
    private boolean bwM;
    private com.baidu.live.noble.data.b bwa;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void OP();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.bwM = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_list_main_layout, (ViewGroup) null);
        this.bwG = (RelativeLayout) this.mRootView.findViewById(a.f.ala_noble_user_list_num_layout);
        this.bwH = (TextView) this.mRootView.findViewById(a.f.tv_noble_online_num);
        this.bwH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), 0));
        this.bwI = (ImageView) this.mRootView.findViewById(a.f.iv_regulation);
        this.bwI.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.f.noble_list_view);
        this.bwJ = (CommonEmptyView) this.mRootView.findViewById(a.f.noble_list_empty_view);
        this.bwK = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.buH, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.bwK);
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (bvVar != null && bvVar.aPP != null && (!bvVar.aPP.aSA || !bvVar.aPP.aSB)) {
            this.bwM = false;
        }
        Pa();
        if (this.bwM) {
            this.bwI.setVisibility(0);
        } else {
            this.bwI.setVisibility(8);
        }
    }

    private void Pa() {
        this.bwE = (LinearLayout) this.mRootView.findViewById(a.f.noble_list_bottom_container);
        this.bwF = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.bwF != null && this.bwF.getRootView() != null && this.bwF.getRootView().getParent() == null) {
            this.bwE.addView(this.bwF.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.bwE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
        } else {
            this.bwE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
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
            this.bwK.setList(bVar.list);
            this.mListView.setVisibility(0);
            Pb();
        }
        this.bwa = bVar;
        this.bwG.setVisibility(0);
        this.bwH.setText(String.format(this.mTbPageContext.getResources().getString(a.h.noble_online_num), Integer.valueOf(bVar.bwg)));
        if (this.mIsHost) {
            this.bwE.setVisibility(8);
        } else if (this.bwM) {
            this.bwE.setVisibility(0);
            this.bwF.b(bVar);
        } else {
            this.bwE.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwI && !UtilHelper.isFastDoubleClick() && this.bwa != null && !StringUtils.isNull(this.bwa.bwh)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bwa.bwh});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.bwE.setBackgroundResource(a.e.ala_noble_ulist_land_bottom_bg);
            } else {
                this.bwE.setBackgroundResource(a.e.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void cK(boolean z) {
        if (this.bwJ != null) {
            this.bwJ.reset();
            if (z) {
                this.bwJ.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.bwL != null) {
                            b.this.bwL.OP();
                        }
                    }
                });
                this.bwJ.setTitle(a.h.sdk_net_no);
                this.bwJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.bwJ.setTitle(a.h.noble_list_empty_title);
                this.bwJ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.bwJ.setVisibility(0);
        }
        if (z) {
            this.bwG.setVisibility(8);
            this.bwE.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Pb() {
        if (this.bwJ != null) {
            this.bwJ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.bwL = aVar;
    }
}
