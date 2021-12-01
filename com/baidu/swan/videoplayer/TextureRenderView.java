package com.baidu.swan.videoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.y.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes9.dex */
public class TextureRenderView extends TextureView implements c.a.p0.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.y.b f40731e;

    /* renamed from: f  reason: collision with root package name */
    public int f40732f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f40733g;
    public b mSurfaceCallback;

    /* loaded from: classes9.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextureRenderView a;

        public a(TextureRenderView textureRenderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureRenderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textureRenderView;
        }

        @Override // c.a.p0.y.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || mediaPlayer == null || this.a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.a.getLastSurfaceTexture().equals(this.a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // c.a.p0.y.a.b
        public c.a.p0.y.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.p0.y.a) invokeV.objValue;
        }

        public Surface c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Surface(this.a.getSurfaceTexture()) : (Surface) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f40734e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f40735f;

        /* renamed from: g  reason: collision with root package name */
        public int f40736g;

        /* renamed from: h  reason: collision with root package name */
        public int f40737h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f40738i;

        /* renamed from: j  reason: collision with root package name */
        public WeakReference<TextureRenderView> f40739j;

        /* renamed from: k  reason: collision with root package name */
        public Map<a.InterfaceC0715a, Object> f40740k;

        public b(TextureRenderView textureRenderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureRenderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40738i = false;
            this.f40740k = new ConcurrentHashMap();
            this.f40739j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC0715a interfaceC0715a) {
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0715a) == null) {
                this.f40740k.put(interfaceC0715a, interfaceC0715a);
                if (this.f40734e != null) {
                    aVar = new a(this.f40739j.get());
                    interfaceC0715a.b(aVar, this.f40736g, this.f40737h);
                } else {
                    aVar = null;
                }
                if (this.f40735f) {
                    if (aVar == null) {
                        aVar = new a(this.f40739j.get());
                    }
                    interfaceC0715a.c(aVar, 0, this.f40736g, this.f40737h);
                }
            }
        }

        public void b(a.InterfaceC0715a interfaceC0715a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0715a) == null) {
                this.f40740k.remove(interfaceC0715a);
            }
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f40738i = z;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i2, i3) == null) {
                this.f40734e = surfaceTexture;
                if (this.f40739j.get() != null && this.f40739j.get().getLastSurfaceTexture() == null) {
                    this.f40739j.get().setLastSurfaceTexture(surfaceTexture);
                }
                this.f40735f = false;
                this.f40736g = 0;
                this.f40737h = 0;
                a aVar = new a(this.f40739j.get());
                for (a.InterfaceC0715a interfaceC0715a : this.f40740k.keySet()) {
                    interfaceC0715a.b(aVar, 0, 0);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
                this.f40734e = surfaceTexture;
                this.f40735f = false;
                this.f40736g = 0;
                this.f40737h = 0;
                a aVar = new a(this.f40739j.get());
                for (a.InterfaceC0715a interfaceC0715a : this.f40740k.keySet()) {
                    interfaceC0715a.a(aVar);
                }
                return this.f40738i;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i2, i3) == null) {
                this.f40734e = surfaceTexture;
                this.f40735f = true;
                this.f40736g = i2;
                this.f40737h = i3;
                a aVar = new a(this.f40739j.get());
                for (a.InterfaceC0715a interfaceC0715a : this.f40740k.keySet()) {
                    interfaceC0715a.c(aVar, 0, i2, i3);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, surfaceTexture) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40732f = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f40731e = new c.a.p0.y.b(this);
            b bVar = new b(this);
            this.mSurfaceCallback = bVar;
            setSurfaceTextureListener(bVar);
        }
    }

    @Override // c.a.p0.y.a
    public void addRenderCallback(a.InterfaceC0715a interfaceC0715a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0715a) == null) {
            this.mSurfaceCallback.a(interfaceC0715a);
        }
    }

    public int getCurrentMediaPlayerCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40732f : invokeV.intValue;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40733g : (SurfaceTexture) invokeV.objValue;
    }

    public a.b getSurfaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a.b) invokeV.objValue;
    }

    @Override // c.a.p0.y.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(TextureRenderView.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            this.f40731e.a(i2, i3);
            setMeasuredDimension(this.f40731e.c(), this.f40731e.b());
        }
    }

    @Override // c.a.p0.y.a
    @TargetApi(16)
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f40733g == null) {
            return;
        }
        if (isAvailable()) {
            this.mSurfaceCallback.c(true);
            return;
        }
        this.f40733g.release();
        this.f40733g = null;
    }

    @Override // c.a.p0.y.a
    public void removeRenderCallback(a.InterfaceC0715a interfaceC0715a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0715a) == null) {
            this.mSurfaceCallback.b(interfaceC0715a);
        }
    }

    @Override // c.a.p0.y.a
    public void setAspectRatio(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f40731e.d(i2);
            requestLayout();
        }
    }

    public void setCurrentMediaPlayerCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f40732f = i2;
        }
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceTexture) == null) {
            this.f40733g = surfaceTexture;
        }
    }

    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f40731e.e(i2);
            setRotation(i2);
        }
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f40731e.f(i2, i3);
        requestLayout();
    }

    @Override // c.a.p0.y.a
    public void setVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f40731e.g(i2, i3);
        requestLayout();
    }

    public boolean shouldWaitForResize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40732f = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f40732f = 0;
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public TextureRenderView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f40732f = 0;
        a(context);
    }
}
