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
    private FrameLayout aHf;
    private ImageView aHg;
    private TextView aHh;
    private AlaAudienceLiveRoomBottomPanelView.a aHi;
    private e aHj;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aHg && a.this.aHi != null) {
                a.this.aHi.Ej();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.aHi = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.aHf = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_top_layout);
        this.aHg = (ImageView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_back_btn);
        this.aHg.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_title);
        this.aHh = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.aHh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aHj != null && !StringUtils.isNull(a.this.aHj.MK())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.aHj.MK()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.ae.a.RB().brA.aNc}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.aHj != null && this.aHj.getPanelView() != null && this.mRootView.indexOfChild(this.aHj.getPanelView()) >= 0) {
            this.mRootView.removeView(this.aHj.getPanelView());
        }
        this.aHj = null;
    }
}
