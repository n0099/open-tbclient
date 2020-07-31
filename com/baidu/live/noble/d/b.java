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
import com.baidu.live.data.bc;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes4.dex */
public class b implements View.OnClickListener {
    private String aYY;
    private LinearLayout baL;
    private com.baidu.live.noble.d.a baM;
    private RelativeLayout baN;
    private TextView baO;
    private ImageView baP;
    private CommonEmptyView baQ;
    private com.baidu.live.noble.a.a baR;
    private a baS;
    private boolean baT;
    private com.baidu.live.noble.data.b baf;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void Gf();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.baT = true;
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aYY = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.baN = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.baO = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.baO.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.baP = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.baP.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.baQ = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.baR = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.aYY, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.baR);
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (bcVar != null && bcVar.aEr != null && (!bcVar.aEr.aGl || !bcVar.aEr.aGm)) {
            this.baT = false;
        }
        Gp();
        if (this.baT) {
            this.baP.setVisibility(0);
        } else {
            this.baP.setVisibility(8);
        }
    }

    private void Gp() {
        this.baL = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.baM = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.baM != null && this.baM.getRootView() != null && this.baM.getRootView().getParent() == null) {
            this.baL.addView(this.baM.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.baL.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.baL.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            bX(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            bX(false);
        } else {
            this.baR.setList(bVar.list);
            this.mListView.setVisibility(0);
            Gq();
        }
        this.baf = bVar;
        this.baN.setVisibility(0);
        this.baO.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bap)));
        if (this.mIsHost) {
            this.baL.setVisibility(8);
        } else if (this.baT) {
            this.baL.setVisibility(0);
            this.baM.b(bVar);
        } else {
            this.baL.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baP && !UtilHelper.isFastDoubleClick() && this.baf != null && !StringUtils.isNull(this.baf.baq)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.baf.baq});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.baL.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.baL.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void bX(boolean z) {
        if (this.baQ != null) {
            this.baQ.reset();
            if (z) {
                this.baQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.baS != null) {
                            b.this.baS.Gf();
                        }
                    }
                });
                this.baQ.setTitle(a.i.sdk_net_no);
                this.baQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.baQ.setTitle(a.i.noble_list_empty_title);
                this.baQ.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.baQ.setVisibility(0);
        }
        if (z) {
            this.baN.setVisibility(8);
            this.baL.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Gq() {
        if (this.baQ != null) {
            this.baQ.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.baS = aVar;
    }
}
