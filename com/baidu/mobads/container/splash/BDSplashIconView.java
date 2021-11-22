package com.baidu.mobads.container.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.mobads.container.widget.CornerImageType;
import com.baidu.mobads.container.widget.RemoteRoundCornerImageView;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BDSplashIconView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BDSplashIconView";
    public static final String starBase64Str = "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";
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatorSet animatorSet;
    public XBaseAdContainer mAdContainer;
    public int mBottomMargin;
    public TextView mCloseView;
    public TextView mDownLoadDesc;
    public RemoteRoundCornerImageView mIconPic;
    public IXAdInstanceInfo mInfo;
    public int mRightMargin;
    public RelativeLayout mViewContainer;
    public Activity mViewContext;
    public BaseTask task;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(234181515, "Lcom/baidu/mobads/container/splash/BDSplashIconView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(234181515, "Lcom/baidu/mobads/container/splash/BDSplashIconView;");
        }
    }

    public BDSplashIconView(Context context, XBaseAdContainer xBaseAdContainer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, xBaseAdContainer, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (xBaseAdContainer == null || !(context instanceof Activity)) {
            return;
        }
        this.mViewContext = (Activity) context;
        this.mAdContainer = xBaseAdContainer;
        this.mInfo = xBaseAdContainer.getAdContainerContext().getAdInstanceInfo();
        this.mBottomMargin = i2;
        this.mRightMargin = i3;
        initView();
    }

    private int dp2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.AD_TEXT_ID, this, f2)) == null) ? (int) ((f2 * this.mViewContext.getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    public static void removeFromParent(View view) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, view) == null) || view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFinishingTouchLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            try {
                SendLogUtil.Builder.create(this.mViewContext.getApplicationContext()).appendType(802).appendApId(this.mAdContainer.getAdContainerContext().getAdPlacementId()).appendAdInfo(this.mInfo).append("reason", str).append("materialtype", this.mInfo.getMaterialType()).sendWithVd();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    private void setViewVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            this.mIconPic.setVisibility(i2);
            this.mCloseView.setVisibility(i2);
            TextView textView = this.mDownLoadDesc;
            if (textView != null) {
                textView.setVisibility(i2);
            }
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BaseTask baseTask = this.task;
            if (baseTask != null && !baseTask.isCanceled()) {
                this.task.cancel();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("splash_close_reason", "splash_icon");
            this.mAdContainer.getAdContainerContext().getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStopped", hashMap));
            this.mViewContainer.removeAllViews();
            this.mViewContainer.setVisibility(8);
            removeFromParent(this.mViewContainer);
            this.mViewContext = null;
            this.mInfo = null;
            this.mAdContainer = null;
            this.animatorSet.cancel();
            this.animatorSet = null;
        }
    }

    public View getIconView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mIconPic : (View) invokeV.objValue;
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.mViewContainer == null) {
                    RelativeLayout relativeLayout = new RelativeLayout(this.mViewContext);
                    this.mViewContainer = relativeLayout;
                    relativeLayout.setId(100);
                    this.mViewContext.addContentView(this.mViewContainer, new RelativeLayout.LayoutParams(-1, -1));
                }
                if (this.mIconPic == null) {
                    RemoteRoundCornerImageView remoteRoundCornerImageView = new RemoteRoundCornerImageView(this.mViewContext);
                    this.mIconPic = remoteRoundCornerImageView;
                    remoteRoundCornerImageView.type = CornerImageType.RoundRect;
                    remoteRoundCornerImageView.cornerRadius = dp2px(10.0f);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp2px(44.0f), dp2px(44.0f));
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    layoutParams.bottomMargin = dp2px(this.mBottomMargin);
                    layoutParams.rightMargin = dp2px(this.mRightMargin);
                    this.mIconPic.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    this.mIconPic.setId(101);
                    this.mIconPic.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.splash.BDSplashIconView.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BDSplashIconView this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mInfo == null) {
                                return;
                            }
                            new XAdRemoteClickHandler().onAdClicked(this.this$0.mAdContainer, this.this$0.mInfo, Boolean.TRUE, null);
                            this.this$0.sendFinishingTouchLog(PrefetchEvent.STATE_CLICK);
                            this.this$0.close();
                        }
                    });
                    if (!TextUtils.isEmpty(this.mInfo.getIconUrl())) {
                        MaterialLoader.getInstance(this.mViewContext).loadImageForURLString(this.mIconPic, this.mInfo.getIconUrl());
                    } else {
                        this.mIconPic.setImageBitmap(ConvertUtils.string2bitmap(starBase64Str));
                    }
                    this.mViewContainer.addView(this.mIconPic, layoutParams);
                }
                if (this.mCloseView == null) {
                    this.mCloseView = new TextView(this.mViewContext);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dp2px(14.0f), dp2px(14.0f));
                    layoutParams2.addRule(2, this.mIconPic.getId());
                    layoutParams2.addRule(11);
                    layoutParams2.bottomMargin = dp2px(5.0f);
                    layoutParams2.rightMargin = dp2px(this.mRightMargin);
                    this.mCloseView.setId(102);
                    this.mCloseView.setText("x");
                    this.mCloseView.setTextColor(-1);
                    this.mCloseView.setTextSize(0, dp2px(8.0f));
                    this.mCloseView.setGravity(17);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(dp2px(7.0f));
                    gradientDrawable.setColor(Color.parseColor("#999999"));
                    if (Build.VERSION.SDK_INT < 16) {
                        this.mCloseView.setBackgroundDrawable(gradientDrawable);
                    } else {
                        this.mCloseView.setBackground(gradientDrawable);
                    }
                    this.mCloseView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.splash.BDSplashIconView.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BDSplashIconView this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                this.this$0.sendFinishingTouchLog(IntentConfig.CLOSE);
                                this.this$0.close();
                            }
                        }
                    });
                    this.mViewContainer.addView(this.mCloseView, layoutParams2);
                }
                boolean z = (!AdDownloadApkUtils.isInstalled(this.mViewContext, this.mInfo.getAppPackageName()) && this.mInfo.getActionType() == 512 && (!TextUtils.isEmpty(this.mInfo.getAppOpenStrs()) ? new JSONObject(this.mInfo.getAppOpenStrs()).optInt("fb_act", 0) : 0) == 2) || this.mInfo.getActionType() == 2;
                if (this.mDownLoadDesc == null && z) {
                    this.mDownLoadDesc = new TextView(this.mViewContext);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dp2px(60.0f), dp2px(22.0f));
                    layoutParams3.topMargin = dp2px(50.0f);
                    layoutParams3.rightMargin = dp2px(this.mRightMargin - 8);
                    layoutParams3.addRule(3, this.mCloseView.getId());
                    layoutParams3.addRule(11);
                    this.mDownLoadDesc.setText("立即下载");
                    this.mDownLoadDesc.setTextColor(-1);
                    this.mDownLoadDesc.setTextSize(0, dp2px(12.0f));
                    this.mDownLoadDesc.setGravity(17);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(dp2px(11.0f));
                    gradientDrawable2.setColor(Color.parseColor("#444444"));
                    if (Build.VERSION.SDK_INT < 16) {
                        this.mDownLoadDesc.setBackgroundDrawable(gradientDrawable2);
                    } else {
                        this.mDownLoadDesc.setBackground(gradientDrawable2);
                    }
                    this.mDownLoadDesc.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.splash.BDSplashIconView.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BDSplashIconView this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
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
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.this$0.mInfo == null) {
                                return;
                            }
                            new XAdRemoteClickHandler().onAdClicked(this.this$0.mAdContainer, this.this$0.mInfo, Boolean.TRUE, null);
                            this.this$0.sendFinishingTouchLog(PrefetchEvent.STATE_CLICK);
                            this.this$0.close();
                        }
                    });
                    this.mViewContainer.addView(this.mDownLoadDesc, layoutParams3);
                }
                setViewVisible(4);
            } catch (Throwable unused) {
            }
        }
    }

    public void startAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setViewVisible(4);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mIconPic, "scaleX", 0.1f, 1.0f);
            ofFloat.setDuration(400L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mIconPic, "scaleY", 0.1f, 1.0f);
            ofFloat2.setDuration(400L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mIconPic, "rotation", 0.0f, -15.0f, 5.0f, 0.0f);
            ofFloat3.setDuration(600L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mCloseView, "alpha", 0.0f, 0.8f);
            ofFloat4.setDuration(300L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.animatorSet = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat4).before(ofFloat3);
            TextView textView = this.mDownLoadDesc;
            if (textView != null) {
                ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(textView, "alpha", 0.0f, 0.7f);
                ofFloat5.setDuration(600L);
                this.animatorSet.play(ofFloat).with(ofFloat5);
            }
            this.animatorSet.start();
            setViewVisible(0);
            sendFinishingTouchLog("show");
            this.task = new BaseTask(this) { // from class: com.baidu.mobads.container.splash.BDSplashIconView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDSplashIconView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // com.baidu.mobads.container.executor.BaseTask
                public Object doInBackground() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.splash.BDSplashIconView.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 this$1;

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
                                    this.this$1.this$0.close();
                                }
                            }
                        });
                        return null;
                    }
                    return invokeV.objValue;
                }
            };
            TaskScheduler.getInstance().submitWithDelay(this.task, 10L, TimeUnit.SECONDS);
        }
    }
}
