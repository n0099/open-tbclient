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
/* loaded from: classes11.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private ImageView bDA;
    private TextView bDB;
    private RelativeLayout bDC;
    private ProgressBar bDD;
    private TextView bDE;
    private a bDu;
    private RelativeLayout bDw;
    private FrameLayout bDx;
    private ImageView bDy;
    private LinearLayout bDz;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes11.dex */
    public interface a {
        void Se();

        void Sf();
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
        this.bDw = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bDx = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bDy = (ImageView) findViewById(a.f.btn_close);
        this.bDz = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bDA = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bDB = (TextView) findViewById(a.f.beauty_textView);
        this.bDC = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bDD = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bDE = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bDC.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bDw.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bDw.setLayoutParams(layoutParams);
        this.bDw.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bDC.setOnClickListener(onClickListener);
        this.bDy.setOnClickListener(onClickListener);
        this.bDz.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bDx;
    }

    public View getBtnClose() {
        return this.bDy;
    }

    public View getChatOptBtn() {
        return this.bDC;
    }

    public View getBeautyBtn() {
        return this.bDz;
    }

    public void setChatOptBtnBgInIdle() {
        this.bDC.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bDE.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bDE.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bDC.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bDE.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bDE.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AW() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AX() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AY() {
        if (this.bDu != null) {
            this.bDu.Se();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void AZ() {
        if (this.bDu != null) {
            this.bDu.Sf();
        }
    }

    public void Sg() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.bDz.setVisibility(0);
            if (bt.c(com.baidu.live.ae.a.Qj().bAS) && Build.VERSION.SDK_INT >= 11) {
                this.bDA.setAlpha(0.2f);
                this.bDB.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Sa() {
        this.bDE.setVisibility(8);
        this.bDD.setVisibility(0);
        this.bDC.setClickable(false);
    }

    public void Sb() {
        this.bDE.setVisibility(0);
        this.bDD.setVisibility(8);
        this.bDC.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bDu = aVar;
    }
}
