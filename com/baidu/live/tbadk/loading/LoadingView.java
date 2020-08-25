package com.baidu.live.tbadk.loading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
/* loaded from: classes7.dex */
public class LoadingView extends AbsAttachView {
    private static final long DELAY_TIME = 200;
    private final int arrayLength;
    private int currentIndex;
    private ImageView imgView;
    private TextView loadingTextView;
    private int mSkinType;
    private Runnable runnable;
    private String[] textArray;
    private TextView textView;

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextIndex() {
        this.currentIndex++;
        if (this.currentIndex >= this.arrayLength) {
            this.currentIndex = 0;
        }
        return this.currentIndex;
    }

    public LoadingView(Context context) {
        this(context, context.getResources().getDimensionPixelSize(a.e.sdk_ds484));
    }

    public LoadingView(Context context, int i) {
        super(LayoutInflater.from(context).inflate(a.h.sdk_loading_view_layout, (ViewGroup) null));
        this.currentIndex = 0;
        this.mSkinType = -1;
        this.runnable = new Runnable() { // from class: com.baidu.live.tbadk.loading.LoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!LoadingView.this.isViewAttached()) {
                    TbadkCoreApplication.getInst().handler.removeCallbacks(LoadingView.this.runnable);
                    return;
                }
                LoadingView.this.textView.setText(LoadingView.this.textArray[LoadingView.this.getNextIndex()]);
                TbadkCoreApplication.getInst().handler.postDelayed(LoadingView.this.runnable, LoadingView.DELAY_TIME);
            }
        };
        this.imgView = (ImageView) this.attachedView.findViewById(a.g.loading_animate_view);
        if (i > 0) {
            ViewGroup.LayoutParams layoutParams = this.imgView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.imgView.setLayoutParams(marginLayoutParams);
            }
        }
        this.textView = (TextView) this.attachedView.findViewById(a.g.loading_anim_ellipsis);
        this.loadingTextView = (TextView) this.attachedView.findViewById(a.g.loading_text);
        this.textArray = context.getResources().getStringArray(a.b.sdk_loading_anim_text_array);
        this.arrayLength = this.textArray.length;
    }

    private void startLoadingAnimation() {
        if (this.imgView != null && (this.imgView.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.imgView.getBackground()).start();
        }
    }

    private void stopLoadingAnimation() {
        if (this.imgView != null && (this.imgView.getBackground() instanceof AnimationDrawable)) {
            ((AnimationDrawable) this.imgView.getBackground()).stop();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.loading.AbsAttachView
    public void onViewAttached() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        SkinManager.setBackgroundResource(this.imgView, a.f.sdk_loading_animation, this.mSkinType);
        startLoadingAnimation();
        SkinManager.setViewTextColor(this.textView, a.d.sdk_cp_cont_c, 1, this.mSkinType);
        SkinManager.setViewTextColor(this.loadingTextView, a.d.sdk_cp_cont_c, 1, this.mSkinType);
        SkinManager.setBackgroundColor(this.attachedView, a.d.sdk_cp_bg_line_d, this.mSkinType);
        this.textView.setText(this.textArray[0]);
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        TbadkCoreApplication.getInst().handler.postDelayed(this.runnable, DELAY_TIME);
        this.attachedView.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.loading.AbsAttachView
    public void onViewDettached() {
        release();
    }

    public void release() {
        stopLoadingAnimation();
        TbadkCoreApplication.getInst().handler.removeCallbacks(this.runnable);
        this.imgView.setBackgroundResource(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType() {
        if (this.mSkinType == -1) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
        if (isViewAttached()) {
            SkinManager.setBackgroundResource(this.imgView, a.f.sdk_loading_animation, this.mSkinType);
            startLoadingAnimation();
            SkinManager.setViewTextColor(this.textView, a.d.sdk_cp_cont_c, 1, this.mSkinType);
            SkinManager.setViewTextColor(this.loadingTextView, a.d.sdk_cp_cont_c, 1, this.mSkinType);
            SkinManager.setBackgroundColor(this.attachedView, a.d.sdk_cp_bg_line_d, this.mSkinType);
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
        this.loadingTextView.setTextColor(i);
    }

    public TextView getLoadingTextView() {
        return this.loadingTextView;
    }

    @Override // com.baidu.live.tbadk.loading.AbsAttachView
    public void dettachView(View view) {
        if (this.imgView != null && this.imgView.getAnimation() != null) {
            this.imgView.getAnimation().cancel();
            this.imgView.clearAnimation();
        }
        super.dettachView(view);
    }

    public void setBackground(int i) {
        if (this.attachedView != null) {
            this.attachedView.setBackgroundColor(i);
        }
    }

    public void setTopMargin(int i) {
        if (this.imgView != null) {
            ViewGroup.LayoutParams layoutParams = this.imgView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.imgView.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
