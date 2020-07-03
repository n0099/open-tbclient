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
/* loaded from: classes3.dex */
public class a {
    private FrameLayout avs;
    private ImageView avt;
    private TextView avu;
    private AlaAudienceLiveRoomBottomPanelView.a avv;
    private e avw;
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.avt && a.this.avv != null) {
                a.this.avv.vD();
            }
        }
    };
    private Context mContext;
    private ViewGroup mRootView;
    private TextView mTitleView;

    public a(Context context, AlaAudienceLiveRoomBottomPanelView.a aVar) {
        this.mContext = context;
        this.avv = aVar;
        createView();
    }

    private void createView() {
        if (this.mRootView == null) {
            this.mRootView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(a.h.sdk_live_room_bottom_panel_shell_layout, (ViewGroup) null);
        }
        this.avs = (FrameLayout) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_top_layout);
        this.avt = (ImageView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_back_btn);
        this.avt.setOnClickListener(this.mClickListener);
        this.mTitleView = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_title);
        this.avu = (TextView) this.mRootView.findViewById(a.g.ala_live_room_bottom_panel_entry);
        if (this.mRootView.getParent() != null) {
            ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
        }
        this.avu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.bottompanel.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.avw != null && !StringUtils.isNull(a.this.avw.CI())) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{a.this.avw.CI()}, true);
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(a.this.mContext), new String[]{com.baidu.live.v.a.Hm().aZp.azy}, true);
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void reset() {
        if (this.avw != null && this.avw.getPanelView() != null && this.mRootView.indexOfChild(this.avw.getPanelView()) >= 0) {
            this.mRootView.removeView(this.avw.getPanelView());
        }
        this.avw = null;
    }
}
