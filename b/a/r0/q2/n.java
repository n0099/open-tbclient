package b.a.r0.q2;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
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
    public ViewGroup f22872a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f22873b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f22874c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f22875d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f22876e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f22877f;

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
        this.f22872a = viewGroup;
        this.f22873b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f22874c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f22875d.cancel();
            this.f22876e.cancel();
            this.f22877f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f22872a.setVisibility(8);
            this.f22874c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f22876e.start();
            this.f22877f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f22875d = ObjectAnimator.ofFloat(this.f22873b, Key.ALPHA, 1.0f, 0.5f);
            this.f22876e = ObjectAnimator.ofFloat(this.f22873b, Key.ALPHA, 0.5f, 0.0f);
            this.f22877f = ObjectAnimator.ofFloat(this.f22874c, Key.ALPHA, 1.0f, 0.0f);
            this.f22875d.setDuration(50L);
            this.f22876e.setDuration(50L);
            this.f22877f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f22874c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f22874c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f22873b.setAlpha(1.0f);
            this.f22874c.setAlpha(1.0f);
            this.f22872a.setVisibility(0);
            this.f22874c.startLoading();
            this.f22875d.start();
        }
    }
}
