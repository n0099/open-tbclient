package com.baidu.searchbox.picture.component.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.lib_atlas_base.R;
import com.baidu.searchbox.picture.model.PictureInfo;
import com.facebook.common.b.i;
import com.facebook.datasource.a;
import com.facebook.datasource.b;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import java.util.Locale;
/* loaded from: classes13.dex */
public class PictureOriginButton extends RelativeLayout implements Handler.Callback {
    public static final int LOADING_ORIGIN = 101;
    public static final int LOAD_COMPLETE_ORIGIN = 102;
    public static final int LOAD_ORIGIN_BTN_GRADUALLY_GONE = 104;
    public static final int LOAD_ORIGIN_BTN_JUST_GONE = 105;
    public static final int LOAD_ORIGIN_BTN_JUST_VISIBLE = 106;
    public static final int LOAD_ORIGIN_CANCEL = 103;
    public static final int START_LOAD_ORIGIN = 100;
    private static final int TRANSLATE_ANIM_DURATION = 50;
    private HandlerHolder handlerHolder;
    private boolean isDownLoading;
    private LoadOriginImageListener mImageListener;
    private ImageView mLoadOriginCancelImg;
    private RelativeLayout mLoadOriginContainer;
    private ValueAnimator mLoadOriginGoneAnimator;
    protected OnLoadOriginPhotoListener mLoadOriginPhotoListener;
    private TextView mLoadOriginTV;
    private b mOriginLoadDataSource;
    private PictureInfo mPicInfo;
    private String mStrLoadOriginInit;
    private boolean mSuccess;

    /* loaded from: classes13.dex */
    public interface LoadOriginImageListener {
        void success(String str);
    }

    /* loaded from: classes13.dex */
    public interface OnLoadOriginPhotoListener {
        void onCancel();

        void onStart();
    }

    public PictureOriginButton(Context context) {
        super(context);
        this.mStrLoadOriginInit = "";
        initLoadOriginView(context);
    }

    public PictureOriginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStrLoadOriginInit = "";
        initLoadOriginView(context);
    }

    public PictureOriginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStrLoadOriginInit = "";
        initLoadOriginView(context);
    }

    public void setData(PictureInfo pictureInfo) {
        this.mPicInfo = pictureInfo;
        this.mStrLoadOriginInit = getResources().getString(R.string.light_picture_load_origin_init);
        if (this.mPicInfo.getOriginSize() > 0) {
            this.mStrLoadOriginInit += String.format(Locale.getDefault(), "(%s)", FileUtils.generateFileSizeText(this.mPicInfo.getOriginSize()));
        }
        this.mLoadOriginTV.setText(this.mStrLoadOriginInit);
        setVisibility(0);
    }

    private void initialize() {
        this.handlerHolder = new HandlerHolder(this);
        this.mLoadOriginGoneAnimator = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mLoadOriginGoneAnimator.setDuration(50L);
        this.mLoadOriginGoneAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mLoadOriginGoneAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.picture.component.view.PictureOriginButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (PictureOriginButton.this.mLoadOriginContainer != null) {
                    PictureOriginButton.this.mLoadOriginContainer.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mLoadOriginGoneAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.searchbox.picture.component.view.PictureOriginButton.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PictureOriginButton.this.mLoadOriginContainer.setVisibility(8);
            }
        });
    }

    public void initLoadOriginView(Context context) {
        initialize();
        LayoutInflater.from(context).inflate(R.layout.light_picture_browse_load_origin_view, this);
        this.mLoadOriginContainer = (RelativeLayout) findViewById(R.id.load_origin_container);
        this.mLoadOriginTV = (TextView) this.mLoadOriginContainer.findViewById(R.id.tv_load_origin);
        this.mLoadOriginCancelImg = (ImageView) this.mLoadOriginContainer.findViewById(R.id.cancel_load_origin);
        this.mLoadOriginTV.setTextColor(getResources().getColor(R.color.picture_simple_desc_text_color));
        this.mLoadOriginCancelImg.setImageDrawable(getResources().getDrawable(R.drawable.bottom_button_close));
        this.mLoadOriginCancelImg.setVisibility(8);
        ((RelativeLayout) findViewById(R.id.real_load_origin_container)).setBackground(getResources().getDrawable(R.drawable.light_picture_load_origin_bg));
        this.mLoadOriginContainer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.picture.component.view.PictureOriginButton.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PictureOriginButton.this.mSuccess && PictureOriginButton.this.handlerHolder != null) {
                    if (PictureOriginButton.this.isDownLoading) {
                        PictureOriginButton.this.handlerHolder.sendEmptyMessage(103);
                    } else {
                        PictureOriginButton.this.handlerHolder.sendEmptyMessage(100);
                    }
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    @SuppressLint({"SetTextI18n"})
    public boolean handleMessage(Message message) {
        if (this.mPicInfo != null && this.mLoadOriginContainer != null && this.mLoadOriginTV != null && this.mLoadOriginCancelImg != null) {
            switch (message.what) {
                case 100:
                    this.mLoadOriginTV.setText("0 %");
                    this.mLoadOriginCancelImg.setVisibility(0);
                    this.isDownLoading = true;
                    loadOriginImage(this.mPicInfo.getOriginUrl());
                    if (this.mLoadOriginPhotoListener != null) {
                        this.mLoadOriginPhotoListener.onStart();
                        break;
                    }
                    break;
                case 101:
                    Bundle bundle = (Bundle) message.obj;
                    if (bundle != null) {
                        this.mLoadOriginTV.setText(bundle.getInt("progress") + " %");
                        this.mLoadOriginCancelImg.setVisibility(0);
                        break;
                    }
                    break;
                case 102:
                    this.mLoadOriginTV.setText(R.string.light_picture_load_origin_success);
                    this.mLoadOriginCancelImg.setVisibility(8);
                    this.handlerHolder.sendEmptyMessageDelayed(104, 250L);
                    break;
                case 103:
                    if (this.mOriginLoadDataSource != null) {
                        this.isDownLoading = false;
                        this.mOriginLoadDataSource.OG();
                        this.mLoadOriginTV.setText(this.mStrLoadOriginInit);
                        this.mLoadOriginCancelImg.setVisibility(8);
                    }
                    if (this.mLoadOriginPhotoListener != null) {
                        this.mLoadOriginPhotoListener.onCancel();
                        break;
                    }
                    break;
                case 104:
                    if (!this.mLoadOriginGoneAnimator.isRunning()) {
                        this.mLoadOriginGoneAnimator.start();
                        break;
                    }
                    break;
                case 105:
                    this.mLoadOriginContainer.setVisibility(8);
                    break;
                case 106:
                    this.mLoadOriginContainer.setVisibility(0);
                    break;
            }
        }
        return true;
    }

    private void loadOriginImage(final String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mOriginLoadDataSource = c.dlY().e(ImageRequestBuilder.Y(Uri.parse(str)).dta(), getContext().getApplicationContext());
            this.mOriginLoadDataSource.a(new a<com.facebook.common.references.a<com.facebook.imagepipeline.g.b>>() { // from class: com.baidu.searchbox.picture.component.view.PictureOriginButton.4
                @Override // com.facebook.datasource.a
                protected void onNewResultImpl(b<com.facebook.common.references.a<com.facebook.imagepipeline.g.b>> bVar) {
                    PictureOriginButton.this.handlerHolder.sendEmptyMessage(102);
                    if (bVar.isFinished()) {
                        com.facebook.common.references.a<com.facebook.imagepipeline.g.b> result = bVar.getResult();
                        try {
                            if (result != null) {
                                Bitmap dqP = result.get().dqP();
                                if (dqP != null && !dqP.isRecycled() && PictureOriginButton.this.mImageListener != null) {
                                    PictureOriginButton.this.mSuccess = true;
                                    PictureOriginButton.this.mImageListener.success(str);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            result.close();
                        }
                    }
                }

                @Override // com.facebook.datasource.a
                protected void onFailureImpl(b<com.facebook.common.references.a<com.facebook.imagepipeline.g.b>> bVar) {
                    PictureOriginButton.this.handlerHolder.sendEmptyMessageDelayed(103, 10L);
                    if (NetWorkUtils.isNetworkConnected(PictureOriginButton.this.getContext().getApplicationContext())) {
                        UniversalToast.makeText(PictureOriginButton.this.getContext(), R.string.light_picture_load_origin_error_but_has_net).showToast();
                    } else {
                        UniversalToast.makeText(PictureOriginButton.this.getContext(), R.string.light_picture_load_origin_no_net).showToast();
                    }
                }

                @Override // com.facebook.datasource.a, com.facebook.datasource.d
                public void onProgressUpdate(b<com.facebook.common.references.a<com.facebook.imagepipeline.g.b>> bVar) {
                    Message obtainMessage = PictureOriginButton.this.handlerHolder.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("progress", (int) (bVar.getProgress() * 100.0f));
                    obtainMessage.what = 101;
                    obtainMessage.obj = bundle;
                    PictureOriginButton.this.handlerHolder.sendMessage(obtainMessage);
                }
            }, i.dld());
        }
    }

    public void quit() {
        this.handlerHolder.sendEmptyMessage(105);
        this.mLoadOriginContainer.setVisibility(8);
        resetLoadOriginAnimator(this.mLoadOriginGoneAnimator);
    }

    public void graduallyGone() {
        if (this.handlerHolder != null) {
            this.handlerHolder.sendEmptyMessage(104);
        }
    }

    public void immediatelyShow() {
        if (this.handlerHolder != null) {
            this.handlerHolder.sendEmptyMessage(106);
        }
    }

    public void immediatelyGone() {
        if (this.handlerHolder != null) {
            this.handlerHolder.sendEmptyMessage(105);
        }
    }

    private void resetLoadOriginAnimator(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    public void setLoadOriginListener(LoadOriginImageListener loadOriginImageListener) {
        this.mImageListener = loadOriginImageListener;
    }

    /* loaded from: classes13.dex */
    public static class HandlerHolder extends Handler {
        WeakReference<Handler.Callback> mListenerWeakReference;

        HandlerHolder(Handler.Callback callback) {
            this.mListenerWeakReference = new WeakReference<>(callback);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mListenerWeakReference != null && this.mListenerWeakReference.get() != null) {
                this.mListenerWeakReference.get().handleMessage(message);
            }
        }
    }

    public void setLoadOriginPhotoListener(OnLoadOriginPhotoListener onLoadOriginPhotoListener) {
        this.mLoadOriginPhotoListener = onLoadOriginPhotoListener;
    }
}
