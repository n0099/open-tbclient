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
/* loaded from: classes4.dex */
public class a {
    private AlaAudienceLiveRoomBottomPanelView.a awA;
    private e awB;
    private FrameLayout awx;
    private ImageView awy;
    private TextView awz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.awy && a.this.awA != null) {
                a.this.awA.vZ();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.awA = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.awx = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_top_layout);
        this.awy = (ImageView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_back_btn);
        this.awy.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_title);
        this.awz = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.awz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.awB != null && !StringUtils.isNull(a.this.awB.Dj())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.awB.Dj()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.v.a.Hs().aZn.aAL}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.awB != null && this.awB.getPanelView() != null && this.mRootView.indexOfChild(this.awB.getPanelView()) >= 0) {
            this.mRootView.removeView(this.awB.getPanelView());
        }
        this.awB = null;
    }
}
