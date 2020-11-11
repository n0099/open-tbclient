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
    private a bwo;
    private RelativeLayout bwq;
    private FrameLayout bwr;
    private ImageView bws;
    private LinearLayout bwt;
    private ImageView bwu;
    private TextView bwv;
    private RelativeLayout bww;
    private ProgressBar bwx;
    private TextView bwy;
    private Context mContext;
    private RelativeLayout mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void Rv();

        void Rw();
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
        this.bwq = (RelativeLayout) findViewById(a.f.chat_live_parent);
        this.bwr = (FrameLayout) findViewById(a.f.chat_live_render_view);
        this.bws = (ImageView) findViewById(a.f.btn_close);
        this.bwt = (LinearLayout) findViewById(a.f.beauty_layout);
        this.bwu = (ImageView) findViewById(a.f.ala_prepare_beauty);
        this.bwv = (TextView) findViewById(a.f.beauty_textView);
        this.bww = (RelativeLayout) findViewById(a.f.live_video_chat_preview_bottom_bar);
        this.bwx = (ProgressBar) findViewById(a.f.live_video_chat_preview_opt_progress_bar);
        this.bwy = (TextView) findViewById(a.f.live_video_chat_preview_opt_btn);
        this.bww.setClickable(false);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.mContext) - BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds160);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bwq.getLayoutParams();
        layoutParams.width = equipmentWidth;
        layoutParams.height = (equipmentWidth * 4) / 3;
        this.bwq.setLayoutParams(layoutParams);
        this.bwq.setBackgroundResource(a.e.video_chat_preview_bg);
        setChatOptBtnBgInIdle();
    }

    public void setOutOnClickListener(View.OnClickListener onClickListener) {
        this.bww.setOnClickListener(onClickListener);
        this.bws.setOnClickListener(onClickListener);
        this.bwt.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public ViewGroup getRootView() {
        return this.mRootView;
    }

    public ViewGroup getRenderViewParent() {
        return this.bwr;
    }

    public View getBtnClose() {
        return this.bws;
    }

    public View getChatOptBtn() {
        return this.bww;
    }

    public View getBeautyBtn() {
        return this.bwt;
    }

    public void setChatOptBtnBgInIdle() {
        this.bww.setBackgroundResource(a.e.video_chat_preview_btn_bg_selector);
        this.bwy.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bwy.setText(a.h.live_chat_join_queue);
    }

    public void setChatOptBtnBgInWait() {
        this.bww.setBackgroundResource(a.e.video_chat_preview_cancel_btn_bg_selector);
        this.bwy.setTextColor(getResources().getColor(a.c.sdk_white_alpha100));
        this.bwy.setText(a.h.live_chat_cancel_queue);
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DR() {
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DS() {
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_transparent));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DT() {
        if (this.bwo != null) {
            this.bwo.Rv();
        }
        this.mRootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.sdk_black_alpha50));
    }

    @Override // com.baidu.live.core.layer.LayerChildView
    public void DU() {
        if (this.bwo != null) {
            this.bwo.Rw();
        }
    }

    public void Rx() {
        if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            this.bwt.setVisibility(0);
            if (bl.c(com.baidu.live.aa.a.PQ().btT) && Build.VERSION.SDK_INT >= 11) {
                this.bwu.setAlpha(0.2f);
                this.bwv.setAlpha(0.2f);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void Rr() {
        this.bwy.setVisibility(8);
        this.bwx.setVisibility(0);
        this.bww.setClickable(false);
    }

    public void Rs() {
        this.bwy.setVisibility(0);
        this.bwx.setVisibility(8);
        this.bww.setClickable(true);
    }

    public void setLayerVisibleListener(a aVar) {
        this.bwo = aVar;
    }
}
