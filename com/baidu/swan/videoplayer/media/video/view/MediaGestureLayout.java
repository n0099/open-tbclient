package com.baidu.swan.videoplayer.media.video.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.y.f.b.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class MediaGestureLayout extends FrameLayout implements c.a.p0.y.f.b.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.y.f.b.c.a f38661e;

    /* renamed from: f  reason: collision with root package name */
    public b f38662f;

    /* renamed from: g  reason: collision with root package name */
    public MediaVolume f38663g;

    /* renamed from: h  reason: collision with root package name */
    public MediaBrightness f38664h;

    /* renamed from: i  reason: collision with root package name */
    public MediaFastForward f38665i;

    /* renamed from: j  reason: collision with root package name */
    public SwanVideoView f38666j;
    public c.a.p0.y.f.b.c.c k;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaGestureLayout f38667e;

        public a(MediaGestureLayout mediaGestureLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaGestureLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38667e = mediaGestureLayout;
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f38667e.f38661e.a(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2);

        void onDoubleTap(MotionEvent motionEvent);

        void onSingleTap(MotionEvent motionEvent);

        void onTouchUp(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);
    }

    /* loaded from: classes5.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void a(int i2);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void onDoubleTap(MotionEvent motionEvent);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void onSingleTap(MotionEvent motionEvent);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void onTouchUp(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, motionEvent, mediaGestureMode) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaGestureLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            c.a.p0.y.f.b.c.a aVar = new c.a.p0.y.f.b.c.a(context);
            this.f38661e = aVar;
            aVar.d(this);
            this.k = new c.b().f();
            setOnTouchListener(new a(this));
        }
    }

    public void bindGestureProperty(@NonNull c.a.p0.y.f.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void bindMediaControl(@NonNull SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanVideoView) == null) {
            this.f38666j = swanVideoView;
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            MediaVolume mediaVolume = new MediaVolume(context);
            this.f38663g = mediaVolume;
            mediaVolume.setVisibility(8);
            addView(this.f38663g);
            MediaBrightness mediaBrightness = new MediaBrightness(context);
            this.f38664h = mediaBrightness;
            mediaBrightness.setVisibility(8);
            addView(this.f38664h);
            MediaFastForward mediaFastForward = new MediaFastForward(context);
            this.f38665i = mediaFastForward;
            mediaFastForward.setVisibility(8);
            addView(this.f38665i);
        }
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onBrightnessChange(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!(this.k.f() && this.k.b()) && (this.k.f() || !this.k.e())) {
                return false;
            }
            float a2 = this.f38664h.a() + (((motionEvent.getY() - motionEvent2.getY()) * this.f38664h.b()) / (getHeight() * 0.8f));
            this.f38664h.f(a2);
            this.f38664h.g(R.drawable.swanapp_video_brightness_high);
            this.f38664h.h((int) ((a2 / this.f38664h.b()) * 100.0f));
            this.f38664h.e();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (!this.k.a() || (bVar = this.f38662f) == null) {
                return true;
            }
            bVar.onDoubleTap(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            SwanVideoView swanVideoView = this.f38666j;
            if (swanVideoView == null) {
                return true;
            }
            this.k.i(swanVideoView.isInPlaybackState());
            this.k.j(this.f38666j.getTipState());
            if (this.k.c()) {
                this.f38665i.e(this.f38666j.getCurrentPosition(), this.f38666j.getDuration());
                this.f38663g.e();
                this.f38664h.d();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onFastForward(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.k.d()) {
                float x = motionEvent2.getX() - motionEvent.getX();
                this.f38665i.h((int) (this.f38665i.b() + ((this.f38665i.c() * x) / (getWidth() * 0.8f))));
                this.f38665i.g(x > 0.0f ? R.drawable.swanapp_video_fast_forward : R.drawable.swanapp_video_fast_rewind);
                this.f38665i.f();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onSingleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            b bVar = this.f38662f;
            if (bVar != null) {
                bVar.onSingleTap(motionEvent);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f38661e.c(getWidth());
        }
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onTouchUp(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, motionEvent, mediaGestureMode)) == null) {
            this.f38665i.setVisibility(8);
            this.f38663g.setVisibility(8);
            this.f38664h.setVisibility(8);
            if (this.f38662f != null && mediaGestureMode == MediaGestureMode.FAST_FORWARD && this.k.d()) {
                this.f38662f.a(this.f38665i.a());
            }
            b bVar = this.f38662f;
            if (bVar != null) {
                bVar.onTouchUp(motionEvent, mediaGestureMode);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.y.f.b.c.b
    public boolean onVolumeChange(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!(this.k.f() && this.k.b()) && (this.k.f() || !this.k.e())) {
                return false;
            }
            float b2 = this.f38663g.b() + (((motionEvent.getY() - motionEvent2.getY()) * this.f38663g.c()) / (getHeight() * 0.8f));
            this.f38663g.g(R.drawable.swanapp_video_mute_off);
            this.f38663g.h(b2);
            this.f38663g.f();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void setMediaGestureListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f38662f = bVar;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MediaGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c(context);
        b(context);
    }
}
