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
/* loaded from: classes11.dex */
public class LiveBCAudiencePreviewLayer extends LayerChildView {
    private a bEA;
    private RelativeLayout bEC;
    private FrameLayout bED;
    private ImageView bEE;
    private LinearLayout bEF;
    private ImageView bEG;
    private TextView bEH;
    private RelativeLayout bEI;
    private ProgressBar bEJ;
    private TextView bEK;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes11.dex */
    public interface a {
        void Up();

        void Uq();
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
        this.bEC = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bED = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bEE = (ImageView) findViewById(a.f.btn_close);
        this.bEF = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bEG = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bEH = (TextView) findViewById(a.f.beauty_textView);
        this.bEI = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bEJ = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bEK = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bEI.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bEC.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bEC.setLayoutParams(layoutParams);
        this.bEC.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bEI.setOnClickListener(onClickListener);
        this.bEE.setOnClickListener(onClickListener);
        this.bEF.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bED;
    }

    public View getBtnClose() {
        return this.bEE;
    }

    public View getChatOptBtn() {
        return this.bEI;
    }

    public View getBeautyBtn() {
        return this.bEF;
    }

    public void setChatOptBtnBgInIdle() {
        this.bEI.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bEK.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bEK.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bEI.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bEK.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bEK.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Eh() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ei() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ej() {
        if (this.bEA != null) {
            this.bEA.Up();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void Ek() {
        if (this.bEA != null) {
            this.bEA.Uq();
        }
    }

    public void Ur() {
        if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            this.bEF.setVisibility(0);
            if (bo.c(com.baidu.live.af.a.SE().bCb) && Build.VERSION.SDK_INT >= 11) {
                this.bEG.setAlpha(0.2f);
                this.bEH.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Ul() {
        this.bEK.setVisibility(8);
        this.bEJ.setVisibility(0);
        this.bEI.setClickable(false);
    }

    public void Um() {
        this.bEK.setVisibility(0);
        this.bEJ.setVisibility(8);
        this.bEI.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bEA = aVar;
    }
}
