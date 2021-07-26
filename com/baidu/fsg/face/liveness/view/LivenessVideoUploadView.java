package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.biometrics.liveness.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class LivenessVideoUploadView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f6173a;

    /* renamed from: b  reason: collision with root package name */
    public LivenessCircleProgressView f6174b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f6175c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f6176d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f6177e;

    /* renamed from: f  reason: collision with root package name */
    public a f6178f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        boolean b();

        void c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessVideoUploadView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    public void setUploadListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f6178f = aVar;
        }
    }

    public void showBackgroundBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = (int) ((getContext().getResources().getDisplayMetrics().widthPixels * 7) / 24.0f);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -i2, 0.0f, 0.0f);
            translateAnimation.setFillAfter(true);
            translateAnimation.setDuration(600L);
            translateAnimation.setInterpolator(new BounceInterpolator());
            translateAnimation.setAnimationListener(new Animation.AnimationListener(this, i2) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f6181a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f6182b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6182b = this;
                    this.f6181a = i2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f6182b.f6176d.clearAnimation();
                        this.f6182b.f6176d.setTranslationX(-this.f6181a);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
            this.f6176d.startAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, i2, 0.0f, 0.0f);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setDuration(600L);
            translateAnimation2.setInterpolator(new BounceInterpolator());
            this.f6177e.startAnimation(translateAnimation2);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener(this, i2) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f6183a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f6184b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f6184b = this;
                    this.f6183a = i2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f6184b.f6177e.clearAnimation();
                        this.f6184b.f6177e.setTranslationX(this.f6183a);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
        }
    }

    public void updateProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f6174b.updateProgress(i2);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_liveness_video_upload_view, (ViewGroup) this, true);
            this.f6174b = (LivenessCircleProgressView) inflate.findViewById(R.id.uploading_file_view);
            this.f6175c = (TextView) inflate.findViewById(R.id.uploading_tv);
            this.f6173a = (ImageView) inflate.findViewById(R.id.img_canvas_view);
            this.f6176d = (LinearLayout) inflate.findViewById(R.id.cancle_upload);
            this.f6177e = (LinearLayout) inflate.findViewById(R.id.confirm_upload);
            this.f6176d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f6179a;

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
                    this.f6179a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f6179a.f6178f == null) {
                        return;
                    }
                    this.f6179a.f6178f.a();
                }
            });
            this.f6177e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f6180a;

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
                    this.f6180a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f6180a.f6178f != null && this.f6180a.f6178f.b()) {
                        this.f6180a.b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            long j = 300;
            alphaAnimation.setDuration(j);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f6185a;

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
                    this.f6185a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f6185a.f6177e.setVisibility(8);
                        this.f6185a.f6176d.setVisibility(8);
                        if (this.f6185a.f6178f != null) {
                            this.f6185a.f6174b.setVisibility(0);
                            this.f6185a.f6175c.setVisibility(0);
                            this.f6185a.f6178f.c();
                        }
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                    }
                }
            });
            float[] fArr = {this.f6174b.getX() + (this.f6174b.getWidth() / 2), this.f6174b.getY() + (this.f6174b.getHeight() / 2)};
            float[] fArr2 = {this.f6176d.getX() + (this.f6176d.getWidth() / 2), this.f6176d.getY() + (this.f6176d.getHeight() / 2)};
            float[] fArr3 = {this.f6177e.getX() + (this.f6177e.getWidth() / 2), this.f6177e.getY() + (this.f6177e.getHeight() / 2)};
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, fArr[0] - fArr2[0], 0.0f, fArr[1] - fArr2[1]);
            translateAnimation.setDuration(j);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new LinearInterpolator());
            AnimationSet animationSet = new AnimationSet(getContext(), null);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            this.f6176d.startAnimation(animationSet);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, fArr[0] - fArr3[0], 0.0f, fArr[1] - fArr3[1]);
            translateAnimation2.setDuration(j);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setInterpolator(new LinearInterpolator());
            AnimationSet animationSet2 = new AnimationSet(getContext(), null);
            animationSet2.addAnimation(translateAnimation2);
            animationSet2.addAnimation(alphaAnimation);
            this.f6177e.startAnimation(animationSet2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivenessVideoUploadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a();
    }
}
