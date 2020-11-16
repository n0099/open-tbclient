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
    private ImageView aEA;
    private TextView aEB;
    private AlaAudienceLiveRoomBottomPanelView.a aEC;
    private e aED;
    private FrameLayout aEz;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.aEA && a.this.aEC != null) {
                a.this.aEC.Cz();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.aEC = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.g.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.aEz = (FrameLayout) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_top_layout);
        this.aEA = (ImageView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_back_btn);
        this.aEA.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_title);
        this.aEB = (TextView) this.mRootView.findViewById(a.f.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.aEB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.aED != null && !StringUtils.isNull(a.this.aED.KI())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.aED.KI()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.aa.a.Ph().bms.aKh}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.aED != null && this.aED.getPanelView() != null && this.mRootView.indexOfChild(this.aED.getPanelView()) >= 0) {
            this.mRootView.removeView(this.aED.getPanelView());
        }
        this.aED = null;
    }
}
