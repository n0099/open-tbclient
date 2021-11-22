package b.a.r0.q2;

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
/* loaded from: classes5.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f24393a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f24394b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f24395c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f24396d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f24397e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f24398f;

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
        this.f24393a = viewGroup;
        this.f24394b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f24395c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f24396d.cancel();
            this.f24397e.cancel();
            this.f24398f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f24393a.setVisibility(8);
            this.f24395c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f24397e.start();
            this.f24398f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f24396d = ObjectAnimator.ofFloat(this.f24394b, "alpha", 1.0f, 0.5f);
            this.f24397e = ObjectAnimator.ofFloat(this.f24394b, "alpha", 0.5f, 0.0f);
            this.f24398f = ObjectAnimator.ofFloat(this.f24395c, "alpha", 1.0f, 0.0f);
            this.f24396d.setDuration(50L);
            this.f24397e.setDuration(50L);
            this.f24398f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f24395c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f24395c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f24394b.setAlpha(1.0f);
            this.f24395c.setAlpha(1.0f);
            this.f24393a.setVisibility(0);
            this.f24395c.startLoading();
            this.f24396d.start();
        }
    }
}
