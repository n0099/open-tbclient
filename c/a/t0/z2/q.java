package c.a.t0.z2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f26061b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f26062c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f26063d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f26064e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f26065f;

    public q(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewGroup;
        this.f26061b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f26062c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26063d.cancel();
            this.f26064e.cancel();
            this.f26065f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.f26062c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f26064e.start();
            this.f26065f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26063d = ObjectAnimator.ofFloat(this.f26061b, AnimationProperty.OPACITY, 1.0f, 0.5f);
            this.f26064e = ObjectAnimator.ofFloat(this.f26061b, AnimationProperty.OPACITY, 0.5f, 0.0f);
            this.f26065f = ObjectAnimator.ofFloat(this.f26062c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.f26063d.setDuration(50L);
            this.f26064e.setDuration(50L);
            this.f26065f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f26062c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f26062c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f26061b.setAlpha(1.0f);
            this.f26062c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.f26062c.startLoading();
            this.f26063d.start();
        }
    }
}
