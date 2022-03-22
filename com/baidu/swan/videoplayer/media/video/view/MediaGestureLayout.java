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
import c.a.n0.y.f.b.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class MediaGestureLayout extends FrameLayout implements c.a.n0.y.f.b.c.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.y.f.b.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public b f29737b;

    /* renamed from: c  reason: collision with root package name */
    public MediaVolume f29738c;

    /* renamed from: d  reason: collision with root package name */
    public MediaBrightness f29739d;

    /* renamed from: e  reason: collision with root package name */
    public MediaFastForward f29740e;

    /* renamed from: f  reason: collision with root package name */
    public SwanVideoView f29741f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.y.f.b.c.c f29742g;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaGestureLayout a;

        public a(MediaGestureLayout mediaGestureLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaGestureLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mediaGestureLayout;
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.a.a.a(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);

        void c(int i);

        void onDoubleTap(MotionEvent motionEvent);
    }

    /* loaded from: classes4.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void a(MotionEvent motionEvent);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, mediaGestureMode) == null) {
            }
        }

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void c(int i);

        @Override // com.baidu.swan.videoplayer.media.video.view.MediaGestureLayout.b
        public abstract void onDoubleTap(MotionEvent motionEvent);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            b bVar = this.f29737b;
            if (bVar != null) {
                bVar.a(motionEvent);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, mediaGestureMode)) == null) {
            this.f29740e.setVisibility(8);
            this.f29738c.setVisibility(8);
            this.f29739d.setVisibility(8);
            if (this.f29737b != null && mediaGestureMode == MediaGestureMode.FAST_FORWARD && this.f29742g.d()) {
                this.f29737b.c(this.f29740e.a());
            }
            b bVar = this.f29737b;
            if (bVar != null) {
                bVar.b(motionEvent, mediaGestureMode);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean c(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!(this.f29742g.f() && this.f29742g.b()) && (this.f29742g.f() || !this.f29742g.e())) {
                return false;
            }
            float b2 = this.f29738c.b() + (((motionEvent.getY() - motionEvent2.getY()) * this.f29738c.c()) / (getHeight() * 0.8f));
            this.f29738c.g(R.drawable.obfuscated_res_0x7f0811a6);
            this.f29738c.h(b2);
            this.f29738c.f();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean d(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f29742g.d()) {
                float x = motionEvent2.getX() - motionEvent.getX();
                this.f29740e.h((int) (this.f29740e.b() + ((this.f29740e.c() * x) / (getWidth() * 0.8f))));
                this.f29740e.g(x > 0.0f ? R.drawable.obfuscated_res_0x7f0811a2 : R.drawable.obfuscated_res_0x7f0811a3);
                this.f29740e.f();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean e(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (!(this.f29742g.f() && this.f29742g.b()) && (this.f29742g.f() || !this.f29742g.e())) {
                return false;
            }
            float a2 = this.f29739d.a() + (((motionEvent.getY() - motionEvent2.getY()) * this.f29739d.b()) / (getHeight() * 0.8f));
            this.f29739d.f(a2);
            this.f29739d.g(R.drawable.obfuscated_res_0x7f081194);
            this.f29739d.h((int) ((a2 / this.f29739d.b()) * 100.0f));
            this.f29739d.e();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void g(@NonNull c.a.n0.y.f.b.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f29742g = cVar;
        }
    }

    public void h(@NonNull SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanVideoView) == null) {
            this.f29741f = swanVideoView;
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            c.a.n0.y.f.b.c.a aVar = new c.a.n0.y.f.b.c.a(context);
            this.a = aVar;
            aVar.d(this);
            this.f29742g = new c.b().f();
            setOnTouchListener(new a(this));
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            MediaVolume mediaVolume = new MediaVolume(context);
            this.f29738c = mediaVolume;
            mediaVolume.setVisibility(8);
            addView(this.f29738c);
            MediaBrightness mediaBrightness = new MediaBrightness(context);
            this.f29739d = mediaBrightness;
            mediaBrightness.setVisibility(8);
            addView(this.f29739d);
            MediaFastForward mediaFastForward = new MediaFastForward(context);
            this.f29740e = mediaFastForward;
            mediaFastForward.setVisibility(8);
            addView(this.f29740e);
        }
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (!this.f29742g.a() || (bVar = this.f29737b) == null) {
                return true;
            }
            bVar.onDoubleTap(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.y.f.b.c.b
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            SwanVideoView swanVideoView = this.f29741f;
            if (swanVideoView == null) {
                return true;
            }
            this.f29742g.i(swanVideoView.w());
            this.f29742g.j(this.f29741f.getTipState());
            if (this.f29742g.c()) {
                this.f29740e.e(this.f29741f.getCurrentPosition(), this.f29741f.getDuration());
                this.f29738c.e();
                this.f29739d.d();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048587, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a.c(getWidth());
        }
    }

    public void setMediaGestureListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f29737b = bVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaGestureLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        j(context);
        i(context);
    }
}
