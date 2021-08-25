package c.a.q0.o2;

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
/* loaded from: classes3.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f23206a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f23207b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f23208c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f23209d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f23210e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f23211f;

    public m(ViewGroup viewGroup) {
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
        this.f23206a = viewGroup;
        this.f23207b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f23208c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23209d.cancel();
            this.f23210e.cancel();
            this.f23211f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f23206a.setVisibility(8);
            this.f23208c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f23210e.start();
            this.f23211f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23209d = ObjectAnimator.ofFloat(this.f23207b, "alpha", 1.0f, 0.5f);
            this.f23210e = ObjectAnimator.ofFloat(this.f23207b, "alpha", 0.5f, 0.0f);
            this.f23211f = ObjectAnimator.ofFloat(this.f23208c, "alpha", 1.0f, 0.0f);
            this.f23209d.setDuration(50L);
            this.f23210e.setDuration(50L);
            this.f23211f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f23208c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f23208c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f23207b.setAlpha(1.0f);
            this.f23208c.setAlpha(1.0f);
            this.f23206a.setVisibility(0);
            this.f23208c.startLoading();
            this.f23209d.start();
        }
    }
}
