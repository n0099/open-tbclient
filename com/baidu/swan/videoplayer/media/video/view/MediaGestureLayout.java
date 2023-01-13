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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.videoplayer.SwanVideoView;
import com.baidu.tieba.R;
import com.baidu.tieba.wl4;
import com.baidu.tieba.xl4;
import com.baidu.tieba.yl4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class MediaGestureLayout extends FrameLayout implements xl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wl4 a;
    public b b;
    public MediaVolume c;
    public MediaBrightness d;
    public MediaFastForward e;
    public SwanVideoView f;
    public yl4 g;

    /* loaded from: classes3.dex */
    public interface b {
        void a(MotionEvent motionEvent);

        void b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);

        void c(int i);

        void onDoubleTap(MotionEvent motionEvent);
    }

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return this.a.a.a(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            MediaVolume mediaVolume = new MediaVolume(context);
            this.c = mediaVolume;
            mediaVolume.setVisibility(8);
            addView(this.c);
            MediaBrightness mediaBrightness = new MediaBrightness(context);
            this.d = mediaBrightness;
            mediaBrightness.setVisibility(8);
            addView(this.d);
            MediaFastForward mediaFastForward = new MediaFastForward(context);
            this.e = mediaFastForward;
            mediaFastForward.setVisibility(8);
            addView(this.e);
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

    @Override // com.baidu.tieba.xl4
    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            b bVar = this.b;
            if (bVar != null) {
                bVar.a(motionEvent);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void g(@NonNull yl4 yl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yl4Var) == null) {
            this.g = yl4Var;
        }
    }

    public void h(@NonNull SwanVideoView swanVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanVideoView) == null) {
            this.f = swanVideoView;
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            wl4 wl4Var = new wl4(context);
            this.a = wl4Var;
            wl4Var.d(this);
            this.g = new yl4.b().f();
            setOnTouchListener(new a(this));
        }
    }

    @Override // com.baidu.tieba.xl4
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (this.g.a() && (bVar = this.b) != null) {
                bVar.onDoubleTap(motionEvent);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setMediaGestureListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @Override // com.baidu.tieba.xl4
    public boolean b(MotionEvent motionEvent, MediaGestureMode mediaGestureMode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, mediaGestureMode)) == null) {
            this.e.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            if (this.b != null && mediaGestureMode == MediaGestureMode.FAST_FORWARD && this.g.d()) {
                this.b.c(this.e.a());
            }
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(motionEvent, mediaGestureMode);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.xl4
    public boolean c(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if ((this.g.f() && this.g.b()) || (!this.g.f() && this.g.e())) {
                float b2 = this.c.b() + (((motionEvent.getY() - motionEvent2.getY()) * this.c.c()) / (getHeight() * 0.8f));
                this.c.g(R.drawable.obfuscated_res_0x7f081262);
                this.c.h(b2);
                this.c.f();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.xl4
    public boolean d(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.g.d()) {
                float x = motionEvent2.getX() - motionEvent.getX();
                this.e.h((int) (this.e.b() + ((this.e.c() * x) / (getWidth() * 0.8f))));
                MediaFastForward mediaFastForward = this.e;
                if (x > 0.0f) {
                    i = R.drawable.obfuscated_res_0x7f08125e;
                } else {
                    i = R.drawable.obfuscated_res_0x7f08125f;
                }
                mediaFastForward.g(i);
                this.e.f();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.xl4
    public boolean e(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if ((this.g.f() && this.g.b()) || (!this.g.f() && this.g.e())) {
                float a2 = this.d.a() + (((motionEvent.getY() - motionEvent2.getY()) * this.d.b()) / (getHeight() * 0.8f));
                this.d.f(a2);
                this.d.g(R.drawable.obfuscated_res_0x7f081250);
                this.d.h((int) ((a2 / this.d.b()) * 100.0f));
                this.d.e();
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.xl4
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            SwanVideoView swanVideoView = this.f;
            if (swanVideoView == null) {
                return true;
            }
            this.g.i(swanVideoView.w());
            this.g.j(this.f.getTipState());
            if (this.g.c()) {
                this.e.e(this.f.getCurrentPosition(), this.f.getDuration());
                this.c.e();
                this.d.d();
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
}
