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
import com.baidu.live.liveroom.c.e;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
/* loaded from: classes2.dex */
public class a {
    private FrameLayout Uv;
    private ImageView Uw;
    private TextView Ux;
    private AlaAudienceLiveRoomBottomPanelView.a Uy;
    private e Uz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.Uw && a.this.Uy != null) {
                a.this.Uy.oV();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.Uy = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.Uv = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_top_layout);
        this.Uw = (ImageView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_back_btn);
        this.Uw.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_title);
        this.Ux = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.Ux.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Uz != null && !StringUtils.isNull(a.this.Uz.uB())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.Uz.uB()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.s.a.wR().asq.XS}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.Uz != null && this.Uz.uA() != null && this.mRootView.indexOfChild(this.Uz.uA()) >= 0) {
            this.mRootView.removeView(this.Uz.uA());
        }
        this.Uz = null;
    }
}
