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
    public ImageView f26858b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f26859c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f26860d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f26861e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f26862f;

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
        this.f26858b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f26859c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26860d.cancel();
            this.f26861e.cancel();
            this.f26862f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.f26859c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f26861e.start();
            this.f26862f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26860d = ObjectAnimator.ofFloat(this.f26858b, AnimationProperty.OPACITY, 1.0f, 0.5f);
            this.f26861e = ObjectAnimator.ofFloat(this.f26858b, AnimationProperty.OPACITY, 0.5f, 0.0f);
            this.f26862f = ObjectAnimator.ofFloat(this.f26859c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.f26860d.setDuration(50L);
            this.f26861e.setDuration(50L);
            this.f26862f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f26859c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f26859c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f26858b.setAlpha(1.0f);
            this.f26859c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.f26859c.startLoading();
            this.f26860d.start();
        }
    }
}
