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
/* loaded from: classes11.dex */
public class a {
    private e aHA;
    private FrameLayout aHw;
    private ImageView aHx;
    private TextView aHy;
    private AlaAudienceLiveRoomBottomPanelView.a aHz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aHx && a.this.aHz != null) {
                a.this.aHz.Dy();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.aHz = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.aHw = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_top_layout);
        this.aHx = (ImageView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_back_btn);
        this.aHx.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_title);
        this.aHy = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.aHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aHA != null && !StringUtils.isNull(a.this.aHA.Mh())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.aHA.Mh()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.af.a.SE().bwi.aNG}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.aHA != null && this.aHA.getPanelView() != null && this.mRootView.indexOfChild(this.aHA.getPanelView()) >= 0) {
            this.mRootView.removeView(this.aHA.getPanelView());
        }
        this.aHA = null;
    }
}
