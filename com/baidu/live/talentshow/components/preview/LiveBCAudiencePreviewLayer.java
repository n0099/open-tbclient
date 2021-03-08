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
import com.baidu.live.data.bt;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private a bEU;
    private RelativeLayout bEW;
    private FrameLayout bEX;
    private ImageView bEY;
    private LinearLayout bEZ;
    private ImageView bFa;
    private TextView bFb;
    private RelativeLayout bFc;
    private ProgressBar bFd;
    private TextView bFe;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes10.dex */
    public interface a {
        void Sh();

        void Si();
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
        this.bEW = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bEX = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bEY = (ImageView) findViewById(a.f.btn_close);
        this.bEZ = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bFa = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bFb = (TextView) findViewById(a.f.beauty_textView);
        this.bFc = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bFd = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bFe = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bFc.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bEW.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bEW.setLayoutParams(layoutParams);
        this.bEW.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bFc.setOnClickListener(onClickListener);
        this.bEY.setOnClickListener(onClickListener);
        this.bEZ.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bEX;
    }

    public View getBtnClose() {
        return this.bEY;
    }

    public View getChatOptBtn() {
        return this.bFc;
    }

    public View getBeautyBtn() {
        return this.bEZ;
    }

    public void setChatOptBtnBgInIdle() {
        this.bFc.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bFe.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bFe.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bFc.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bFe.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bFe.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ba() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bb() {
        if (this.bEU != null) {
            this.bEU.Sh();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Bc() {
        if (this.bEU != null) {
            this.bEU.Si();
        }
    }

    public void Sj() {
        if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            this.bEZ.setVisibility(0);
            if (bt.c(com.baidu.live.ae.a.Qm().bCs) && Build.VERSION.SDK_INT >= 11) {
                this.bFa.setAlpha(0.2f);
                this.bFb.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Sd() {
        this.bFe.setVisibility(8);
        this.bFd.setVisibility(0);
        this.bFc.setClickable(false);
    }

    public void Se() {
        this.bFe.setVisibility(0);
        this.bFd.setVisibility(8);
        this.bFc.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bEU = aVar;
    }
}
