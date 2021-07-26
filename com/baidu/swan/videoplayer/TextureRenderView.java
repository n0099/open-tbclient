package com.baidu.swan.videoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.v.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes3.dex */
public class TextureRenderView extends TextureView implements d.a.o0.v.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.v.b f12124e;

    /* renamed from: f  reason: collision with root package name */
    public int f12125f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f12126g;

    /* renamed from: h  reason: collision with root package name */
    public b f12127h;

    /* loaded from: classes3.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f12128a;

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
            this.f12128a = textureRenderView;
        }

        @Override // d.a.o0.v.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || mediaPlayer == null || this.f12128a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f12128a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f12128a.getLastSurfaceTexture().equals(this.f12128a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f12128a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f12128a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // d.a.o0.v.a.b
        public d.a.o0.v.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12128a : (d.a.o0.v.a) invokeV.objValue;
        }

        public Surface c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Surface(this.f12128a.getSurfaceTexture()) : (Surface) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f12129e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12130f;

        /* renamed from: g  reason: collision with root package name */
        public int f12131g;

        /* renamed from: h  reason: collision with root package name */
        public int f12132h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f12133i;
        public WeakReference<TextureRenderView> j;
        public Map<a.InterfaceC1164a, Object> k;

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
            this.f12133i = false;
            this.k = new ConcurrentHashMap();
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC1164a interfaceC1164a) {
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1164a) == null) {
                this.k.put(interfaceC1164a, interfaceC1164a);
                if (this.f12129e != null) {
                    aVar = new a(this.j.get());
                    interfaceC1164a.b(aVar, this.f12131g, this.f12132h);
                } else {
                    aVar = null;
                }
                if (this.f12130f) {
                    if (aVar == null) {
                        aVar = new a(this.j.get());
                    }
                    interfaceC1164a.c(aVar, 0, this.f12131g, this.f12132h);
                }
            }
        }

        public void b(a.InterfaceC1164a interfaceC1164a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1164a) == null) {
                this.k.remove(interfaceC1164a);
            }
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f12133i = z;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i2, i3) == null) {
                this.f12129e = surfaceTexture;
                if (this.j.get() == null) {
                    Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
                } else if (this.j.get().getLastSurfaceTexture() == null) {
                    this.j.get().setLastSurfaceTexture(surfaceTexture);
                }
                this.f12130f = false;
                this.f12131g = 0;
                this.f12132h = 0;
                a aVar = new a(this.j.get());
                for (a.InterfaceC1164a interfaceC1164a : this.k.keySet()) {
                    interfaceC1164a.b(aVar, 0, 0);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
                this.f12129e = surfaceTexture;
                this.f12130f = false;
                this.f12131g = 0;
                this.f12132h = 0;
                a aVar = new a(this.j.get());
                for (a.InterfaceC1164a interfaceC1164a : this.k.keySet()) {
                    interfaceC1164a.a(aVar);
                }
                return this.f12133i;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i2, i3) == null) {
                this.f12129e = surfaceTexture;
                this.f12130f = true;
                this.f12131g = i2;
                this.f12132h = i3;
                a aVar = new a(this.j.get());
                for (a.InterfaceC1164a interfaceC1164a : this.k.keySet()) {
                    interfaceC1164a.c(aVar, 0, i2, i3);
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
        this.f12125f = 0;
        c(context);
    }

    @Override // d.a.o0.v.a
    public void a(a.InterfaceC1164a interfaceC1164a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC1164a) == null) {
            this.f12127h.b(interfaceC1164a);
        }
    }

    @Override // d.a.o0.v.a
    public void b(a.InterfaceC1164a interfaceC1164a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1164a) == null) {
            this.f12127h.a(interfaceC1164a);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f12124e = new d.a.o0.v.b(this);
            b bVar = new b(this);
            this.f12127h = bVar;
            setSurfaceTextureListener(bVar);
        }
    }

    public int getCurrentMediaPlayerCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f12125f : invokeV.intValue;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12126g : (SurfaceTexture) invokeV.objValue;
    }

    public a.b getSurfaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new a(this) : (a.b) invokeV.objValue;
    }

    @Override // d.a.o0.v.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            Log.d("TextureRenderView", "onDetachedFromWindow");
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(TextureRenderView.class.getName());
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            this.f12124e.a(i2, i3);
            setMeasuredDimension(this.f12124e.c(), this.f12124e.b());
        }
    }

    @Override // d.a.o0.v.a
    @TargetApi(16)
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f12126g == null) {
            return;
        }
        if (isAvailable()) {
            this.f12127h.c(true);
            return;
        }
        this.f12126g.release();
        this.f12126g = null;
    }

    @Override // d.a.o0.v.a
    public void setAspectRatio(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f12124e.d(i2);
            requestLayout();
        }
    }

    public void setCurrentMediaPlayerCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f12125f = i2;
        }
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceTexture) == null) {
            this.f12126g = surfaceTexture;
        }
    }

    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f12124e.e(i2);
            setRotation(i2);
        }
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12124e.f(i2, i3);
        requestLayout();
    }

    @Override // d.a.o0.v.a
    public void setVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f12124e.g(i2, i3);
        requestLayout();
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
        this.f12125f = 0;
        c(context);
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
        this.f12125f = 0;
        c(context);
    }
}
