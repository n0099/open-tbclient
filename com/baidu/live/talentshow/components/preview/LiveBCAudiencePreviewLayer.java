package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.data.bo;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private a bzO;
    private RelativeLayout bzQ;
    private FrameLayout bzR;
    private ImageView bzS;
    private LinearLayout bzT;
    private ImageView bzU;
    private TextView bzV;
    private RelativeLayout bzW;
    private ProgressBar bzX;
    private TextView bzY;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void Qu();

        void Qv();
    }

    public LiveBCAudiencePreviewLayer(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LiveBCAudiencePreviewLayer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LiveBCAudiencePreviewLayer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.g.live_audience_video_chat_preview, this);
        this.mRootView = (RelativeLayout) findViewById(a.f.root_view);
        this.bzQ = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bzR = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bzS = (ImageView) findViewById(a.f.btn_close);
        this.bzT = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bzU = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bzV = (TextView) findViewById(a.f.beauty_textView);
        this.bzW = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bzX = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bzY = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bzW.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bzQ.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bzQ.setLayoutParams(layoutParams);
        this.bzQ.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bzW.setOnClickListener(onClickListener);
        this.bzS.setOnClickListener(onClickListener);
        this.bzT.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bzR;
    }

    public View getBtnClose() {
        return this.bzS;
    }

    public View getChatOptBtn() {
        return this.bzW;
    }

    public View getBeautyBtn() {
        return this.bzT;
    }

    public void setChatOptBtnBgInIdle() {
        this.bzW.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bzY.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bzY.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bzW.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bzY.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bzY.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Am() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void An() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ao() {
        if (this.bzO != null) {
            this.bzO.Qu();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ap() {
        if (this.bzO != null) {
            this.bzO.Qv();
        }
    }

    public void Qw() {
        if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            this.bzT.setVisibility(0);
            if (bo.c(com.baidu.live.af.a.OJ().bxp) && Build.VERSION.SDK_INT >= 11) {
                this.bzU.setAlpha(0.2f);
                this.bzV.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Qq() {
        this.bzY.setVisibility(8);
        this.bzX.setVisibility(0);
        this.bzW.setClickable(false);
    }

    public void Qr() {
        this.bzY.setVisibility(0);
        this.bzX.setVisibility(8);
        this.bzW.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bzO = aVar;
    }
}
