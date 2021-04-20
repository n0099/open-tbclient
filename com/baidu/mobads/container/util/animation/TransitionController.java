package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.Transition;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.components.utils.XAdRemoteClickEvent;
import com.baidu.mobads.container.splash.BDSplashIconView;
import com.baidu.mobads.container.splash.SplashAdContainer;
import com.baidu.mobads.container.template.splash.XSplashTemplateAdContainer;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ViewCommonUtils;
import com.baidu.sdk.container.widget.AdView;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(21)
/* loaded from: classes2.dex */
public class TransitionController {
    public static final String FROM_RADIUS = "from_r";
    public static final String SOURCE_RECT = "union_transition_src_rect";
    public static final String TAG = "TransitionController";
    public static final String TO_RADIUS = "to_r";
    public static final String TRANSITION_NAME = "union_transition_unit";
    public static final int TRANSITION_TIME = 1000;
    public static volatile TransitionController mInstance;
    public OnTransitionListener mOnTransitionListener;
    public Bundle mTransitionBundle = new Bundle();
    public TransitionCache mTransitionCache;
    public BDSplashIconView splashIconView;

    /* loaded from: classes2.dex */
    public static class TransitionCache {
        public XBaseAdContainer adContainer;
        public Bitmap firstViewCache;
        public Intent intent;

        public TransitionCache() {
        }

        public boolean isComplete() {
            return (this.firstViewCache == null || this.adContainer == null || this.intent == null) ? false : true;
        }

        public void recycleContainer() {
            XBaseAdContainer xBaseAdContainer = this.adContainer;
            if (xBaseAdContainer != null) {
                xBaseAdContainer.destroy();
            }
        }

        public void release() {
            Bitmap bitmap = this.firstViewCache;
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.firstViewCache.recycle();
                }
                this.firstViewCache = null;
            }
            this.intent = null;
            this.adContainer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAndClearListener() {
        OnTransitionListener onTransitionListener = this.mOnTransitionListener;
        if (onTransitionListener != null) {
            onTransitionListener.onFinishActivity();
            this.mOnTransitionListener = null;
        }
    }

    public static int getActionBarHeight(Activity activity) {
        if (activity.getActionBar() == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static TransitionController getInstance() {
        if (mInstance == null) {
            synchronized (TransitionController.class) {
                mInstance = new TransitionController();
            }
        }
        return mInstance;
    }

    public static int getStatusBarHeight(Activity activity) {
        int identifier;
        if (!((activity.getWindow().getAttributes().flags & 1024) != 1024) || (identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return activity.getResources().getDimensionPixelSize(identifier);
    }

    private ImageView loadFullSizeImage(Activity activity, Rect rect) {
        Bitmap bitmap;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.right - rect.left, rect.bottom - rect.top);
        layoutParams.setMargins(rect.left, (rect.top - getActionBarHeight(activity)) - getStatusBarHeight(activity), rect.right, rect.bottom);
        ImageView imageView = new ImageView(activity);
        TransitionCache transitionCache = this.mTransitionCache;
        if (transitionCache != null && (bitmap = transitionCache.firstViewCache) != null) {
            imageView.setImageBitmap(bitmap);
        }
        activity.addContentView(imageView, layoutParams);
        imageView.requestFocus();
        return imageView;
    }

    public static void registerSceneTransition(Activity activity, JSONObject jSONObject) {
        getInstance().registerActivityTransition(activity, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCache() {
        TransitionCache transitionCache = this.mTransitionCache;
        if (transitionCache != null) {
            transitionCache.release();
            this.mTransitionCache = null;
        }
        if (this.splashIconView != null) {
            this.splashIconView = null;
        }
    }

    private void saveBundleInfo(int i, int i2) {
        this.mTransitionBundle.putInt(FROM_RADIUS, i);
        this.mTransitionBundle.putInt(TO_RADIUS, i2);
    }

    private ImageView showTransitionView(Activity activity) {
        Rect rect = (Rect) activity.getIntent().getParcelableExtra(SOURCE_RECT);
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        saveBundleInfo(i, i2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.setMargins(rect.left, (rect.top - getActionBarHeight(activity)) - getStatusBarHeight(activity), rect.right, rect.bottom);
        ImageView imageView = new ImageView(activity);
        imageView.setImageBitmap(this.mTransitionCache.firstViewCache);
        imageView.setLayoutParams(layoutParams);
        activity.addContentView(imageView, layoutParams);
        return imageView;
    }

    public static void startActivity(Intent intent, final XBaseAdContainer xBaseAdContainer) {
        int i;
        JSONObject originJsonObject;
        RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
        int i2 = 0;
        if (xBaseAdContainer != null) {
            try {
                originJsonObject = xBaseAdContainer.getAdContainerContext().getAdInstanceInfo().getOriginJsonObject();
            } catch (JSONException unused) {
            } catch (Throwable th) {
                remoteXAdLogger.e(TAG, "finishAndJumpError:", th);
            }
            if (originJsonObject != null) {
                String optString = originJsonObject.optString("control_flags");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString("innovate");
                    if (!TextUtils.isEmpty(optString2)) {
                        i = new JSONObject(optString2).optInt("kpdj");
                        if (Build.VERSION.SDK_INT >= 21 && !(xBaseAdContainer instanceof XSplashTemplateAdContainer) && (!(xBaseAdContainer instanceof SplashAdContainer) || !((SplashAdContainer) xBaseAdContainer).isVideoType() || xBaseAdContainer.windowFocusState == -1)) {
                            i2 = i;
                        }
                    }
                }
            }
            i = 0;
            if (Build.VERSION.SDK_INT >= 21) {
                i2 = i;
            }
        }
        if (xBaseAdContainer == null || xBaseAdContainer.getAdContainerContext() == null || xBaseAdContainer.getAdContainerContext().getActivity() == null) {
            return;
        }
        Activity activity = xBaseAdContainer.getAdContainerContext().getActivity();
        if (i2 != 1) {
            activity.startActivity(intent);
            xBaseAdContainer.getAdContainerContext().getEventDispatcher().dispatchEvent(new XAdRemoteClickEvent("AdFinishActivity"));
            return;
        }
        getInstance().setEnterListener(new OnTransitionListener() { // from class: com.baidu.mobads.container.util.animation.TransitionController.1
            @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
            public void onFinishActivity() {
                XBaseAdContainer.this.getAdContainerContext().getEventDispatcher().dispatchEvent(new XAdRemoteClickEvent("AdFinishActivity"));
            }

            @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
            public void onTransitionEnd() {
            }

            @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
            public void onTransitionStart() {
            }
        });
        getInstance().startActivity(activity, intent, xBaseAdContainer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTransitionAnimation(final View view, final View view2) {
        view.getLocationOnScreen(r1);
        int[] iArr = {iArr[0] + (view.getMeasuredWidth() / 2), iArr[1] + (view.getMeasuredHeight() / 2)};
        int i = this.mTransitionBundle.getInt(FROM_RADIUS);
        int i2 = this.mTransitionBundle.getInt(TO_RADIUS);
        int max = Math.max(iArr[0], i - iArr[0]);
        int max2 = Math.max(iArr[1], i2 - iArr[1]);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, iArr[0], iArr[1], (int) Math.sqrt((max * max) + (max2 * max2)), 0.0f);
        createCircularReveal.setDuration(1000L);
        createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.mobads.container.util.animation.TransitionController.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view2.setVisibility(8);
                view.setVisibility(0);
                if (TransitionController.this.mOnTransitionListener != null) {
                    TransitionController.this.mOnTransitionListener.onTransitionEnd();
                    TransitionController.this.mOnTransitionListener = null;
                }
                TransitionController.this.splashIconView.startAnimation();
                TransitionController.this.releaseCache();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(4);
            }
        });
        createCircularReveal.start();
    }

    private void transitWithSceneTransition(final Activity activity, final View view, final View view2) {
        view2.setTransitionName(TRANSITION_NAME);
        CustomImageTransform customImageTransform = new CustomImageTransform();
        activity.getWindow().setSharedElementEnterTransition(customImageTransform);
        customImageTransform.addListener(new Transition.TransitionListener() { // from class: com.baidu.mobads.container.util.animation.TransitionController.2
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                TransitionController.this.releaseCache();
                TransitionController.this.finishAndClearListener();
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                activity.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.util.animation.TransitionController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TransitionController.this.mTransitionCache.recycleContainer();
                        if (TransitionController.this.mOnTransitionListener != null) {
                            TransitionController.this.mOnTransitionListener.onFinishActivity();
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        TransitionController.this.startTransitionAnimation(view, view2);
                    }
                });
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                if (TransitionController.this.mOnTransitionListener != null) {
                    TransitionController.this.mOnTransitionListener.onTransitionStart();
                }
            }
        });
    }

    public final void registerActivityTransition(Activity activity, JSONObject jSONObject) {
        TransitionCache transitionCache;
        if (activity != null && jSONObject != null && (transitionCache = this.mTransitionCache) != null && transitionCache.isComplete() && Build.VERSION.SDK_INT >= 21) {
            if (activity.getWindow().hasFeature(13) && this.mTransitionCache.intent.filterEquals(activity.getIntent())) {
                this.mTransitionCache.adContainer.switchContext(activity);
                BDSplashIconView bDSplashIconView = new BDSplashIconView(activity, this.mTransitionCache.adContainer, jSONObject.optInt("bottom_margin"), jSONObject.optInt("right_margin"));
                this.splashIconView = bDSplashIconView;
                transitWithSceneTransition(activity, bDSplashIconView.getIconView(), showTransitionView(activity));
                return;
            }
            releaseCache();
            finishAndClearListener();
            return;
        }
        releaseCache();
        finishAndClearListener();
    }

    public void setEnterListener(OnTransitionListener onTransitionListener) {
        this.mOnTransitionListener = onTransitionListener;
    }

    public final void startActivity(Activity activity, Intent intent, XBaseAdContainer xBaseAdContainer) {
        if (activity == null || intent == null || xBaseAdContainer == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21 || !activity.getWindow().hasFeature(13)) {
            activity.startActivity(intent);
            finishAndClearListener();
        }
        View decorView = activity.getWindow().getDecorView();
        if (this.mTransitionCache == null) {
            this.mTransitionCache = new TransitionCache();
        }
        TransitionCache transitionCache = this.mTransitionCache;
        transitionCache.adContainer = xBaseAdContainer;
        transitionCache.firstViewCache = ViewCommonUtils.getCacheBitmapFromView(decorView);
        TransitionCache transitionCache2 = this.mTransitionCache;
        transitionCache2.intent = intent;
        if (!transitionCache2.isComplete()) {
            releaseCache();
            activity.startActivity(intent);
            finishAndClearListener();
            return;
        }
        if (xBaseAdContainer instanceof SplashAdContainer) {
            SplashAdContainer splashAdContainer = (SplashAdContainer) xBaseAdContainer;
            if (splashAdContainer.isVideoType()) {
                View adView = xBaseAdContainer.getAdView();
                Rect rect = new Rect();
                if (adView instanceof AdView) {
                    adView.getGlobalVisibleRect(rect);
                }
                Bitmap closeBitmap = splashAdContainer.getCloseBitmap();
                if (closeBitmap != null) {
                    new Canvas(this.mTransitionCache.firstViewCache).drawBitmap(closeBitmap, (Rect) null, rect, (Paint) null);
                } else {
                    releaseCache();
                    activity.startActivity(intent);
                    finishAndClearListener();
                }
            }
        }
        Rect rect2 = new Rect();
        decorView.getGlobalVisibleRect(rect2);
        intent.putExtra(SOURCE_RECT, rect2);
        ImageView loadFullSizeImage = loadFullSizeImage(activity, rect2);
        loadFullSizeImage.setTransitionName(TRANSITION_NAME);
        activity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(activity, loadFullSizeImage, TRANSITION_NAME).toBundle());
    }
}
