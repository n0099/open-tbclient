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
/* loaded from: classes5.dex */
public class LivenessVideoUploadView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f40358a;

    /* renamed from: b  reason: collision with root package name */
    public LivenessCircleProgressView f40359b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f40360c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f40361d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f40362e;

    /* renamed from: f  reason: collision with root package name */
    public a f40363f;

    /* loaded from: classes5.dex */
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
            this.f40363f = aVar;
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
                public final /* synthetic */ int f40366a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f40367b;

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
                    this.f40367b = this;
                    this.f40366a = i2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f40367b.f40361d.clearAnimation();
                        this.f40367b.f40361d.setTranslationX(-this.f40366a);
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
            this.f40361d.startAnimation(translateAnimation);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, i2, 0.0f, 0.0f);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setDuration(600L);
            translateAnimation2.setInterpolator(new BounceInterpolator());
            this.f40362e.startAnimation(translateAnimation2);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener(this, i2) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f40368a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f40369b;

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
                    this.f40369b = this;
                    this.f40368a = i2;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f40369b.f40362e.clearAnimation();
                        this.f40369b.f40362e.setTranslationX(this.f40368a);
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
            this.f40359b.updateProgress(i2);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_liveness_video_upload_view, (ViewGroup) this, true);
            this.f40359b = (LivenessCircleProgressView) inflate.findViewById(R.id.uploading_file_view);
            this.f40360c = (TextView) inflate.findViewById(R.id.uploading_tv);
            this.f40358a = (ImageView) inflate.findViewById(R.id.img_canvas_view);
            this.f40361d = (LinearLayout) inflate.findViewById(R.id.cancle_upload);
            this.f40362e = (LinearLayout) inflate.findViewById(R.id.confirm_upload);
            this.f40361d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f40364a;

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
                    this.f40364a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || this.f40364a.f40363f == null) {
                        return;
                    }
                    this.f40364a.f40363f.a();
                }
            });
            this.f40362e.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f40365a;

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
                    this.f40365a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f40365a.f40363f != null && this.f40365a.f40363f.b()) {
                        this.f40365a.b();
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
            long j2 = 300;
            alphaAnimation.setDuration(j2);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoUploadView.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LivenessVideoUploadView f40370a;

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
                    this.f40370a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                        this.f40370a.f40362e.setVisibility(8);
                        this.f40370a.f40361d.setVisibility(8);
                        if (this.f40370a.f40363f != null) {
                            this.f40370a.f40359b.setVisibility(0);
                            this.f40370a.f40360c.setVisibility(0);
                            this.f40370a.f40363f.c();
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
            float[] fArr = {this.f40359b.getX() + (this.f40359b.getWidth() / 2), this.f40359b.getY() + (this.f40359b.getHeight() / 2)};
            float[] fArr2 = {this.f40361d.getX() + (this.f40361d.getWidth() / 2), this.f40361d.getY() + (this.f40361d.getHeight() / 2)};
            float[] fArr3 = {this.f40362e.getX() + (this.f40362e.getWidth() / 2), this.f40362e.getY() + (this.f40362e.getHeight() / 2)};
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, fArr[0] - fArr2[0], 0.0f, fArr[1] - fArr2[1]);
            translateAnimation.setDuration(j2);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new LinearInterpolator());
            AnimationSet animationSet = new AnimationSet(getContext(), null);
            animationSet.addAnimation(translateAnimation);
            animationSet.addAnimation(alphaAnimation);
            this.f40361d.startAnimation(animationSet);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, fArr[0] - fArr3[0], 0.0f, fArr[1] - fArr3[1]);
            translateAnimation2.setDuration(j2);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setInterpolator(new LinearInterpolator());
            AnimationSet animationSet2 = new AnimationSet(getContext(), null);
            animationSet2.addAnimation(translateAnimation2);
            animationSet2.addAnimation(alphaAnimation);
            this.f40362e.startAnimation(animationSet2);
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
