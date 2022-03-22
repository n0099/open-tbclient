package c.a.p0.c3;

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
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f13491b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f13492c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f13493d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f13494e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f13495f;

    public r(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewGroup;
        this.f13491b = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0902e3);
        this.f13492c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0902e4);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f13493d.cancel();
            this.f13494e.cancel();
            this.f13495f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.a.setVisibility(8);
            this.f13492c.h();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f13494e.start();
            this.f13495f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13493d = ObjectAnimator.ofFloat(this.f13491b, AnimationProperty.OPACITY, 1.0f, 0.5f);
            this.f13494e = ObjectAnimator.ofFloat(this.f13491b, AnimationProperty.OPACITY, 0.5f, 0.0f);
            this.f13495f = ObjectAnimator.ofFloat(this.f13492c, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.f13493d.setDuration(50L);
            this.f13494e.setDuration(50L);
            this.f13495f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f13492c.j();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f13492c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f13491b.setAlpha(1.0f);
            this.f13492c.setAlpha(1.0f);
            this.a.setVisibility(0);
            this.f13492c.l();
            this.f13493d.start();
        }
    }
}
