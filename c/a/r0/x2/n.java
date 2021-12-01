package c.a.r0.x2;

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
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f25418b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f25419c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f25420d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f25421e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f25422f;

    public n(ViewGroup viewGroup) {
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
        this.f25418b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f25419c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f25420d.cancel();
            this.f25421e.cancel();
            this.f25422f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.f25419c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f25421e.start();
            this.f25422f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f25420d = ObjectAnimator.ofFloat(this.f25418b, AnimationProperty.OPACITY, 1.0f, 0.5f);
            this.f25421e = ObjectAnimator.ofFloat(this.f25418b, AnimationProperty.OPACITY, 0.5f, 0.0f);
            this.f25422f = ObjectAnimator.ofFloat(this.f25419c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.f25420d.setDuration(50L);
            this.f25421e.setDuration(50L);
            this.f25422f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f25419c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f25419c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f25418b.setAlpha(1.0f);
            this.f25419c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.f25419c.startLoading();
            this.f25420d.start();
        }
    }
}
