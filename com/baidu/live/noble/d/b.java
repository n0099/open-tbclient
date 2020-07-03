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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private String aZa;
    private LinearLayout baM;
    private com.baidu.live.noble.d.a baN;
    private RelativeLayout baO;
    private TextView baP;
    private ImageView baQ;
    private CommonEmptyView baR;
    private com.baidu.live.noble.a.a baS;
    private a baT;
    private com.baidu.live.noble.data.b bah;
    private boolean mIsHost;
    private BdListView mListView;
    private String mLiveId;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void Gl();
    }

    public b(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.aZa = str2;
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_list_main_layout, (ViewGroup) null);
        this.baO = (RelativeLayout) this.mRootView.findViewById(a.g.ala_noble_user_list_num_layout);
        this.baP = (TextView) this.mRootView.findViewById(a.g.tv_noble_online_num);
        this.baP.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), 0));
        this.baQ = (ImageView) this.mRootView.findViewById(a.g.iv_regulation);
        this.baQ.setOnClickListener(this);
        this.mListView = (BdListView) this.mRootView.findViewById(a.g.noble_list_view);
        this.baR = (CommonEmptyView) this.mRootView.findViewById(a.g.noble_list_empty_view);
        this.baS = new com.baidu.live.noble.a.a(this.mTbPageContext, this.mLiveId, this.aZa, this.mIsHost);
        this.mListView.setAdapter((ListAdapter) this.baS);
        Gv();
    }

    private void Gv() {
        this.baM = (LinearLayout) this.mRootView.findViewById(a.g.noble_list_bottom_container);
        this.baN = new com.baidu.live.noble.d.a(this.mTbPageContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        if (this.baN != null && this.baN.getRootView() != null && this.baN.getRootView().getParent() == null) {
            this.baM.addView(this.baN.getRootView(), layoutParams);
        }
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            this.baM.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
        } else {
            this.baM.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void b(com.baidu.live.noble.data.b bVar) {
        if (bVar == null) {
            bW(true);
            return;
        }
        if (ListUtils.isEmpty(bVar.list)) {
            bW(false);
        } else {
            this.baS.setList(bVar.list);
            this.mListView.setVisibility(0);
            Gw();
        }
        this.bah = bVar;
        this.baO.setVisibility(0);
        this.baP.setText(String.format(this.mTbPageContext.getResources().getString(a.i.noble_online_num), Integer.valueOf(bVar.bar)));
        if (this.mIsHost) {
            this.baM.setVisibility(8);
            return;
        }
        this.baM.setVisibility(0);
        this.baN.b(bVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baQ && !UtilHelper.isFastDoubleClick() && this.bah != null && !StringUtils.isNull(this.bah.bas)) {
            UrlManager.getInstance().dealOneLink(this.mTbPageContext, new String[]{this.bah.bas});
        }
    }

    public void a(Configuration configuration) {
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.baM.setBackgroundResource(a.f.ala_noble_ulist_land_bottom_bg);
            } else {
                this.baM.setBackgroundResource(a.f.ala_noble_ulist_portrait_bottom_bg);
            }
        }
    }

    public void bW(boolean z) {
        if (this.baR != null) {
            this.baR.reset();
            if (z) {
                this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.noble.d.b.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (b.this.baT != null) {
                            b.this.baT.Gl();
                        }
                    }
                });
                this.baR.setTitle(a.i.sdk_net_no);
                this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            } else {
                this.baR.setTitle(a.i.noble_list_empty_title);
                this.baR.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            }
            this.baR.setVisibility(0);
        }
        if (z) {
            this.baO.setVisibility(8);
            this.baM.setVisibility(8);
        }
        this.mListView.setVisibility(8);
    }

    public void Gw() {
        if (this.baR != null) {
            this.baR.setVisibility(8);
        }
    }

    public void a(a aVar) {
        this.baT = aVar;
    }
}
