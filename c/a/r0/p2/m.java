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
    public ViewGroup f23812a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f23813b;

    /* renamed from: c  reason: collision with root package name */
    public VideoLoadingProgressView f23814c;

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f23815d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f23816e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f23817f;

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
        this.f23812a = viewGroup;
        this.f23813b = (ImageView) viewGroup.findViewById(R.id.auto_video_loading_image);
        this.f23814c = (VideoLoadingProgressView) viewGroup.findViewById(R.id.auto_video_loading_progress);
        d();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f23815d.cancel();
            this.f23816e.cancel();
            this.f23817f.cancel();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a();
            this.f23812a.setVisibility(8);
            this.f23814c.endLoading();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            this.f23816e.start();
            this.f23817f.start();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f23815d = ObjectAnimator.ofFloat(this.f23813b, "alpha", 1.0f, 0.5f);
            this.f23816e = ObjectAnimator.ofFloat(this.f23813b, "alpha", 0.5f, 0.0f);
            this.f23817f = ObjectAnimator.ofFloat(this.f23814c, "alpha", 1.0f, 0.0f);
            this.f23815d.setDuration(50L);
            this.f23816e.setDuration(50L);
            this.f23817f.setDuration(50L);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            this.f23814c.loadingSuccess();
        }
    }

    public void f(VideoLoadingProgressView.c cVar) {
        VideoLoadingProgressView videoLoadingProgressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || (videoLoadingProgressView = this.f23814c) == null) {
            return;
        }
        videoLoadingProgressView.setLoadingAnimationListener(cVar);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            a();
            this.f23813b.setAlpha(1.0f);
            this.f23814c.setAlpha(1.0f);
            this.f23812a.setVisibility(0);
            this.f23814c.startLoading();
            this.f23815d.start();
        }
    }
}
