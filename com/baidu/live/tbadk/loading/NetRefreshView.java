package com.baidu.live.tbadk.loading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class NetRefreshView extends AbsAttachView {
    protected TbImageView emotionView;
    protected TextView refreshButton;
    protected TextView subTextView;

    public TextView getRefreshButton() {
        return this.refreshButton;
    }

    public NetRefreshView(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_net_refresh_view_layout, (ViewGroup) null));
        this.emotionView = (TbImageView) this.attachedView.findViewById(a.g.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(a.g.net_refresh_desc);
        this.refreshButton = (TextView) this.attachedView.findViewById(a.g.net_refresh_button);
        this.refreshButton.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setTitle(String str) {
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.refreshButton.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.loading.AbsAttachView
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.loading.AbsAttachView
    public void onViewDettached() {
        super.onViewDettached();
        this.emotionView.setImageResource(0);
    }

    public void setLayoutMargin(int i) {
        ViewGroup.LayoutParams layoutParams = this.emotionView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = i;
            this.emotionView.setLayoutParams(marginLayoutParams);
        }
    }

    public void showRefreshButton() {
        this.refreshButton.setVisibility(0);
        SkinManager.setViewTextColor(this.subTextView, a.d.sdk_cp_cont_d, 1);
    }

    public void hideRefreshButton() {
        this.refreshButton.setVisibility(8);
        SkinManager.setViewTextColor(this.subTextView, a.d.sdk_cp_cont_b, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (TbadkCoreApplication.getInst().isHaokan()) {
            SkinManager.setImageResource(this.emotionView, a.f.sdk_pic_live_empty03_hk);
        } else {
            SkinManager.setImageResource(this.emotionView, a.f.sdk_pic_live_empty03_qm);
        }
        SkinManager.setViewTextColor(this.subTextView, a.d.sdk_cp_cont_j, 1, skinType);
        SkinManager.setViewTextColor(this.refreshButton, a.f.sdk_net_refresh_btn_text_seletor, 1, skinType);
        SkinManager.setBackgroundResource(this.refreshButton, a.f.sdk_net_refresh_btn_bg_selector, skinType);
        SkinManager.setBackgroundColor(this.attachedView, a.d.sdk_cp_bg_line_d);
    }

    public View getAttachedView() {
        return this.attachedView;
    }
}
