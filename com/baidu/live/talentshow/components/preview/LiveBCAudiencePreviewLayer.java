package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.core.layer.LayerChildView;
import com.baidu.live.data.bm;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private a bzN;
    private RelativeLayout bzP;
    private FrameLayout bzQ;
    private ImageView bzR;
    private LinearLayout bzS;
    private ImageView bzT;
    private TextView bzU;
    private RelativeLayout bzV;
    private ProgressBar bzW;
    private TextView bzX;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void Tk();

        void Tl();
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
        this.bzP = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bzQ = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bzR = (ImageView) findViewById(a.f.btn_close);
        this.bzS = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bzT = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bzU = (TextView) findViewById(a.f.beauty_textView);
        this.bzV = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bzW = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bzX = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bzV.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bzP.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bzP.setLayoutParams(layoutParams);
        this.bzP.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bzV.setOnClickListener(onClickListener);
        this.bzR.setOnClickListener(onClickListener);
        this.bzS.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bzQ;
    }

    public View getBtnClose() {
        return this.bzR;
    }

    public View getChatOptBtn() {
        return this.bzV;
    }

    public View getBeautyBtn() {
        return this.bzS;
    }

    public void setChatOptBtnBgInIdle() {
        this.bzV.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bzX.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bzX.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bzV.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bzX.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bzX.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ES() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void ET() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EU() {
        if (this.bzN != null) {
            this.bzN.Tk();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void EV() {
        if (this.bzN != null) {
            this.bzN.Tl();
        }
    }

    public void Tm() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.bzS.setVisibility(0);
            if (bm.c(com.baidu.live.ae.a.RB().bxq) && Build.VERSION.SDK_INT >= 11) {
                this.bzT.setAlpha(0.2f);
                this.bzU.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Tg() {
        this.bzX.setVisibility(8);
        this.bzW.setVisibility(0);
        this.bzV.setClickable(false);
    }

    public void Th() {
        this.bzX.setVisibility(0);
        this.bzW.setVisibility(8);
        this.bzV.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bzN = aVar;
    }
}
