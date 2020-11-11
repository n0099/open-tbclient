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
    private FrameLayout aGk;
    private ImageView aGl;
    private TextView aGm;
    private AlaAudienceLiveRoomBottomPanelView.a aGn;
    private e aGo;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aGl && a.this.aGn != null) {
                a.this.aGn.Di();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.aGn = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.aGk = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_top_layout);
        this.aGl = (ImageView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_back_btn);
        this.aGl.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_title);
        this.aGm = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.aGm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aGo != null && !StringUtils.isNull(a.this.aGo.Lr())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.aGo.Lr()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.aa.a.PQ().bod.aLS}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.aGo != null && this.aGo.getPanelView() != null && this.mRootView.indexOfChild(this.aGo.getPanelView()) >= 0) {
            this.mRootView.removeView(this.aGo.getPanelView());
        }
        this.aGo = null;
    }
}
