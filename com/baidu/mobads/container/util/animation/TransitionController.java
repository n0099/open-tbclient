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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.components.utils.XAdRemoteClickEvent;
import com.baidu.mobads.container.splash.BDSplashIconView;
import com.baidu.mobads.container.splash.SplashAdContainer;
import com.baidu.mobads.container.template.splash.XSplashTemplateAdContainer;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ViewCommonUtils;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(21)
/* loaded from: classes2.dex */
public class TransitionController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_RADIUS = "from_r";
    public static final String SOURCE_RECT = "union_transition_src_rect";
    public static final String TAG = "TransitionController";
    public static final String TO_RADIUS = "to_r";
    public static final String TRANSITION_NAME = "union_transition_unit";
    public static final int TRANSITION_TIME = 1000;
    public static volatile TransitionController mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public OnTransitionListener mOnTransitionListener;
    public Bundle mTransitionBundle;
    public TransitionCache mTransitionCache;
    public BDSplashIconView splashIconView;

    /* loaded from: classes2.dex */
    public static class TransitionCache {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public XBaseAdContainer adContainer;
        public Bitmap firstViewCache;
        public Intent intent;

        public TransitionCache() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean isComplete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.firstViewCache == null || this.adContainer == null || this.intent == null) ? false : true : invokeV.booleanValue;
        }

        public void recycleContainer() {
            XBaseAdContainer xBaseAdContainer;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (xBaseAdContainer = this.adContainer) == null) {
                return;
            }
            xBaseAdContainer.destroy();
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
    }

    public TransitionController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTransitionBundle = new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAndClearListener() {
        OnTransitionListener onTransitionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (onTransitionListener = this.mOnTransitionListener) == null) {
            return;
        }
        onTransitionListener.onFinishActivity();
        this.mOnTransitionListener = null;
    }

    public static int getActionBarHeight(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, activity)) == null) {
            if (activity.getActionBar() == null) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            if (activity.getTheme().resolveAttribute(16843499, typedValue, true)) {
                return TypedValue.complexToDimensionPixelSize(typedValue.data, activity.getResources().getDisplayMetrics());
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static TransitionController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (mInstance == null) {
                synchronized (TransitionController.class) {
                    mInstance = new TransitionController();
                }
            }
            return mInstance;
        }
        return (TransitionController) invokeV.objValue;
    }

    public static int getStatusBarHeight(Activity activity) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, activity)) == null) {
            if (!((activity.getWindow().getAttributes().flags & 1024) != 1024) || (identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
                return 0;
            }
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    private ImageView loadFullSizeImage(Activity activity, Rect rect) {
        InterceptResult invokeLL;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, activity, rect)) == null) {
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
        return (ImageView) invokeLL.objValue;
    }

    public static void registerSceneTransition(Activity activity, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, activity, jSONObject) == null) {
            getInstance().registerActivityTransition(activity, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            TransitionCache transitionCache = this.mTransitionCache;
            if (transitionCache != null) {
                transitionCache.release();
                this.mTransitionCache = null;
            }
            if (this.splashIconView != null) {
                this.splashIconView = null;
            }
        }
    }

    private void saveBundleInfo(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i2, i3) == null) {
            this.mTransitionBundle.putInt(FROM_RADIUS, i2);
            this.mTransitionBundle.putInt(TO_RADIUS, i3);
        }
    }

    private ImageView showTransitionView(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, activity)) == null) {
            Rect rect = (Rect) activity.getIntent().getParcelableExtra(SOURCE_RECT);
            int i2 = rect.right - rect.left;
            int i3 = rect.bottom - rect.top;
            saveBundleInfo(i2, i3);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3);
            layoutParams.setMargins(rect.left, (rect.top - getActionBarHeight(activity)) - getStatusBarHeight(activity), rect.right, rect.bottom);
            ImageView imageView = new ImageView(activity);
            imageView.setImageBitmap(this.mTransitionCache.firstViewCache);
            imageView.setLayoutParams(layoutParams);
            activity.addContentView(imageView, layoutParams);
            return imageView;
        }
        return (ImageView) invokeL.objValue;
    }

    public static void startActivity(Intent intent, XBaseAdContainer xBaseAdContainer) {
        int i2;
        JSONObject originJsonObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, intent, xBaseAdContainer) == null) {
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            int i3 = 0;
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
                            i2 = new JSONObject(optString2).optInt("kpdj");
                            if (Build.VERSION.SDK_INT >= 21 && !(xBaseAdContainer instanceof XSplashTemplateAdContainer) && (!(xBaseAdContainer instanceof SplashAdContainer) || !((SplashAdContainer) xBaseAdContainer).isVideoType() || xBaseAdContainer.windowFocusState == -1)) {
                                i3 = i2;
                            }
                        }
                    }
                }
                i2 = 0;
                if (Build.VERSION.SDK_INT >= 21) {
                    i3 = i2;
                }
            }
            if (xBaseAdContainer == null || xBaseAdContainer.getAdContainerContext() == null || xBaseAdContainer.getAdContainerContext().getActivity() == null) {
                return;
            }
            Activity activity = xBaseAdContainer.getAdContainerContext().getActivity();
            if (i3 != 1) {
                activity.startActivity(intent);
                xBaseAdContainer.getAdContainerContext().getEventDispatcher().dispatchEvent(new XAdRemoteClickEvent("AdFinishActivity"));
                return;
            }
            getInstance().setEnterListener(new OnTransitionListener(xBaseAdContainer) { // from class: com.baidu.mobads.container.util.animation.TransitionController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer val$adContainer;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xBaseAdContainer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$adContainer = xBaseAdContainer;
                }

                @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
                public void onFinishActivity() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$adContainer.getAdContainerContext().getEventDispatcher().dispatchEvent(new XAdRemoteClickEvent("AdFinishActivity"));
                    }
                }

                @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
                public void onTransitionEnd() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                @Override // com.baidu.mobads.container.util.animation.OnTransitionListener
                public void onTransitionStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }
            });
            getInstance().startActivity(activity, intent, xBaseAdContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTransitionAnimation(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, view, view2) == null) {
            view.getLocationOnScreen(r1);
            int[] iArr = {iArr[0] + (view.getMeasuredWidth() / 2), iArr[1] + (view.getMeasuredHeight() / 2)};
            int i2 = this.mTransitionBundle.getInt(FROM_RADIUS);
            int i3 = this.mTransitionBundle.getInt(TO_RADIUS);
            int max = Math.max(iArr[0], i2 - iArr[0]);
            int max2 = Math.max(iArr[1], i3 - iArr[1]);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, iArr[0], iArr[1], (int) Math.sqrt((max * max) + (max2 * max2)), 0.0f);
            createCircularReveal.setDuration(1000L);
            createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
            createCircularReveal.addListener(new AnimatorListenerAdapter(this, view2, view) { // from class: com.baidu.mobads.container.util.animation.TransitionController.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TransitionController this$0;
                public final /* synthetic */ View val$targetView;
                public final /* synthetic */ View val$transitionView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view2, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$transitionView = view2;
                    this.val$targetView = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.val$transitionView.setVisibility(8);
                        this.val$targetView.setVisibility(0);
                        if (this.this$0.mOnTransitionListener != null) {
                            this.this$0.mOnTransitionListener.onTransitionEnd();
                            this.this$0.mOnTransitionListener = null;
                        }
                        this.this$0.splashIconView.startAnimation();
                        this.this$0.releaseCache();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.val$targetView.setVisibility(4);
                    }
                }
            });
            createCircularReveal.start();
        }
    }

    private void transitWithSceneTransition(Activity activity, View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, this, activity, view, view2) == null) {
            view2.setTransitionName(TRANSITION_NAME);
            CustomImageTransform customImageTransform = new CustomImageTransform();
            activity.getWindow().setSharedElementEnterTransition(customImageTransform);
            customImageTransform.addListener(new Transition.TransitionListener(this, activity, view, view2) { // from class: com.baidu.mobads.container.util.animation.TransitionController.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TransitionController this$0;
                public final /* synthetic */ Activity val$activity;
                public final /* synthetic */ View val$targetView;
                public final /* synthetic */ View val$transitionView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, activity, view, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$activity = activity;
                    this.val$targetView = view;
                    this.val$transitionView = view2;
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionCancel(Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, transition) == null) {
                        this.this$0.releaseCache();
                        this.this$0.finishAndClearListener();
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, transition) == null) {
                        this.val$activity.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.util.animation.TransitionController.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.this$0.mTransitionCache.recycleContainer();
                                    if (this.this$1.this$0.mOnTransitionListener != null) {
                                        this.this$1.this$0.mOnTransitionListener.onFinishActivity();
                                    }
                                    AnonymousClass2 anonymousClass2 = this.this$1;
                                    anonymousClass2.this$0.startTransitionAnimation(anonymousClass2.val$targetView, anonymousClass2.val$transitionView);
                                }
                            }
                        });
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionPause(Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, transition) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionResume(Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, transition) == null) {
                    }
                }

                @Override // android.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048580, this, transition) == null) || this.this$0.mOnTransitionListener == null) {
                        return;
                    }
                    this.this$0.mOnTransitionListener.onTransitionStart();
                }
            });
        }
    }

    public final void registerActivityTransition(Activity activity, JSONObject jSONObject) {
        TransitionCache transitionCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, activity, jSONObject) == null) {
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
    }

    public void setEnterListener(OnTransitionListener onTransitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onTransitionListener) == null) {
            this.mOnTransitionListener = onTransitionListener;
        }
    }

    public final void startActivity(Activity activity, Intent intent, XBaseAdContainer xBaseAdContainer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, intent, xBaseAdContainer) == null) || activity == null || intent == null || xBaseAdContainer == null) {
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
