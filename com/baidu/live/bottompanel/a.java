package com.baidu.live.bottompanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.bottompanel.AlaAudienceLiveRoomBottomPanelView;
import com.baidu.live.liveroom.d.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes7.dex */
public class a {
    private ImageView aBA;
    private TextView aBB;
    private AlaAudienceLiveRoomBottomPanelView.a aBC;
    private e aBD;
    private FrameLayout aBz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aBA && a.this.aBC != null) {
                a.this.aBC.Bx();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.aBC = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.aBz = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_top_layout);
        this.aBA = (ImageView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_back_btn);
        this.aBA.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_title);
        this.aBB = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.aBB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aBD != null && !StringUtils.isNull(a.this.aBD.IM())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.aBD.IM()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.w.a.Nk().beH.aFV}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.aBD != null && this.aBD.getPanelView() != null && this.mRootView.indexOfChild(this.aBD.getPanelView()) >= 0) {
            this.mRootView.removeView(this.aBD.getPanelView());
        }
        this.aBD = null;
    }
}
