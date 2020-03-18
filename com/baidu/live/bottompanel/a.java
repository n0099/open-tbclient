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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a {
    private FrameLayout Wp;
    private ImageView Wq;
    private TextView Wr;
    private AlaAudienceLiveRoomBottomPanelView.a Ws;
    private e Wt;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.Wq && a.this.Ws != null) {
                a.this.Ws.pL();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.Ws = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.Wp = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_top_layout);
        this.Wq = (ImageView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_back_btn);
        this.Wq.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_title);
        this.Wr = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.Wr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.Wt != null && !StringUtils.isNull(a.this.Wt.wk())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.Wt.wk()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.v.a.zs().awM.ZT}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.Wt != null && this.Wt.wj() != null && this.mRootView.indexOfChild(this.Wt.wj()) >= 0) {
            this.mRootView.removeView(this.Wt.wj());
        }
        this.Wt = null;
    }
}
