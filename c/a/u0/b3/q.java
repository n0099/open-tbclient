package c.a.u0.b3;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f15597b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f15598c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f15599d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f15600e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f15601f;

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
        this.f15597b = (ImageView) viewGroup.findViewById(c.a.u0.a4.g.auto_video_loading_image);
        this.f15598c = (VideoLoadingProgressView) viewGroup.findViewById(c.a.u0.a4.g.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15599d.cancel();
            this.f15600e.cancel();
            this.f15601f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.f15598c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f15600e.start();
            this.f15601f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15599d = ObjectAnimator.ofFloat(this.f15597b, AnimationProperty.OPACITY, 1.0f, 0.5f);
            this.f15600e = ObjectAnimator.ofFloat(this.f15597b, AnimationProperty.OPACITY, 0.5f, 0.0f);
            this.f15601f = ObjectAnimator.ofFloat(this.f15598c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.f15599d.setDuration(50L);
            this.f15600e.setDuration(50L);
            this.f15601f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f15598c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f15598c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f15597b.setAlpha(1.0f);
            this.f15598c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.f15598c.startLoading();
            this.f15599d.start();
        }
    }
}
