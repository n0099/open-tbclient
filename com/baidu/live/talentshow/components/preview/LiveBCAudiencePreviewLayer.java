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
import com.baidu.live.data.bl;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private a buD;
    private RelativeLayout buF;
    private FrameLayout buG;
    private ImageView buH;
    private LinearLayout buI;
    private ImageView buJ;
    private TextView buK;
    private RelativeLayout buL;
    private ProgressBar buM;
    private TextView buN;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void QM();

        void QN();
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
        this.buF = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.buG = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.buH = (ImageView) findViewById(a.f.btn_close);
        this.buI = (LinearLayout) findViewById(a.f.beauty_layout);
        this.buJ = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.buK = (TextView) findViewById(a.f.beauty_textView);
        this.buL = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.buM = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.buN = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.buL.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buF.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.buF.setLayoutParams(layoutParams);
        this.buF.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.buL.setOnClickListener(onClickListener);
        this.buH.setOnClickListener(onClickListener);
        this.buI.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.buG;
    }

    public View getBtnClose() {
        return this.buH;
    }

    public View getChatOptBtn() {
        return this.buL;
    }

    public View getBeautyBtn() {
        return this.buI;
    }

    public void setChatOptBtnBgInIdle() {
        this.buL.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.buN.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.buN.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.buL.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.buN.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.buN.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Di() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dj() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dk() {
        if (this.buD != null) {
            this.buD.QM();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Dl() {
        if (this.buD != null) {
            this.buD.QN();
        }
    }

    public void QO() {
        if (bl.c(com.baidu.live.aa.a.Ph().bsh)) {
            this.buI.setVisibility(0);
            if (bl.c(com.baidu.live.aa.a.Ph().bsh) && Build.VERSION.SDK_INT >= 11) {
                this.buJ.setAlpha(0.2f);
                this.buK.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void QI() {
        this.buN.setVisibility(8);
        this.buM.setVisibility(0);
        this.buL.setClickable(false);
    }

    public void QJ() {
        this.buN.setVisibility(0);
        this.buM.setVisibility(8);
        this.buL.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.buD = aVar;
    }
}
