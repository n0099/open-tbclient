package c.a.r0.p2;

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
    public ViewGroup f23796a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f23797b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f23798c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f23799d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f23800e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f23801f;

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
        this.f23796a = viewGroup;
        this.f23797b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f23798c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23799d.cancel();
            this.f23800e.cancel();
            this.f23801f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f23796a.setVisibility(8);
            this.f23798c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f23800e.start();
            this.f23801f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23799d = ObjectAnimator.ofFloat(this.f23797b, "alpha", 1.0f, 0.5f);
            this.f23800e = ObjectAnimator.ofFloat(this.f23797b, "alpha", 0.5f, 0.0f);
            this.f23801f = ObjectAnimator.ofFloat(this.f23798c, "alpha", 1.0f, 0.0f);
            this.f23799d.setDuration(50L);
            this.f23800e.setDuration(50L);
            this.f23801f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f23798c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f23798c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f23797b.setAlpha(1.0f);
            this.f23798c.setAlpha(1.0f);
            this.f23796a.setVisibility(0);
            this.f23798c.startLoading();
            this.f23799d.start();
        }
    }
}
