package c.a.r0.y.n;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class b implements MediaGestureLayout.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public MediaGestureLayout f12008b;

    /* renamed from: c  reason: collision with root package name */
    public MediaGestureLayout.c f12009c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        e(context);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void a(int i2) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (cVar = this.f12009c) == null) {
            return;
        }
        cVar.a(i2);
    }

    public void b(SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanVideoView) == null) {
            this.f12008b.bindMediaControl(swanVideoView);
        }
    }

    public void c(c.a.r0.y.l.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f12008b.bindGestureProperty(cVar);
        }
    }

    public ViewGroup d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12008b : (ViewGroup) invokeV.objValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = context;
            MediaGestureLayout mediaGestureLayout = new MediaGestureLayout(context);
            this.f12008b = mediaGestureLayout;
            mediaGestureLayout.setMediaGestureListener(this);
        }
    }

    public void f(MediaGestureLayout.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f12009c = cVar;
        }
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void onDoubleTap(MotionEvent motionEvent) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, motionEvent) == null) || (cVar = this.f12009c) == null) {
            return;
        }
        cVar.onDoubleTap(motionEvent);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void onSingleTap(MotionEvent motionEvent) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) || (cVar = this.f12009c) == null) {
            return;
        }
        cVar.onSingleTap(motionEvent);
    }

    @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
    public void onTouchUp(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        MediaGestureLayout.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent, mediaGestureMode) == null) || (cVar = this.f12009c) == null) {
            return;
        }
        cVar.onTouchUp(motionEvent, mediaGestureMode);
    }
}
