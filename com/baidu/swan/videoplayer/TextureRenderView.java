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
import c.a.n0.y.a;
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
/* loaded from: classes4.dex */
public class TextureRenderView extends TextureView implements c.a.n0.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.y.b a;

    /* renamed from: b  reason: collision with root package name */
    public int f29713b;

    /* renamed from: c  reason: collision with root package name */
    public SurfaceTexture f29714c;

    /* renamed from: d  reason: collision with root package name */
    public b f29715d;

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textureRenderView;
        }

        @Override // c.a.n0.y.a.b
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

        @Override // c.a.n0.y.a.b
        public c.a.n0.y.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (c.a.n0.y.a) invokeV.objValue;
        }

        public Surface c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Surface(this.a.getSurfaceTexture()) : (Surface) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SurfaceTexture a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29716b;

        /* renamed from: c  reason: collision with root package name */
        public int f29717c;

        /* renamed from: d  reason: collision with root package name */
        public int f29718d;

        /* renamed from: e  reason: collision with root package name */
        public volatile boolean f29719e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<TextureRenderView> f29720f;

        /* renamed from: g  reason: collision with root package name */
        public Map<a.InterfaceC0769a, Object> f29721g;

        public b(TextureRenderView textureRenderView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {textureRenderView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29719e = false;
            this.f29721g = new ConcurrentHashMap();
            this.f29720f = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC0769a interfaceC0769a) {
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0769a) == null) {
                this.f29721g.put(interfaceC0769a, interfaceC0769a);
                if (this.a != null) {
                    aVar = new a(this.f29720f.get());
                    interfaceC0769a.b(aVar, this.f29717c, this.f29718d);
                } else {
                    aVar = null;
                }
                if (this.f29716b) {
                    if (aVar == null) {
                        aVar = new a(this.f29720f.get());
                    }
                    interfaceC0769a.c(aVar, 0, this.f29717c, this.f29718d);
                }
            }
        }

        public void b(a.InterfaceC0769a interfaceC0769a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0769a) == null) {
                this.f29721g.remove(interfaceC0769a);
            }
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f29719e = z;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i, i2) == null) {
                this.a = surfaceTexture;
                if (this.f29720f.get() == null) {
                    Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
                } else if (this.f29720f.get().getLastSurfaceTexture() == null) {
                    this.f29720f.get().setLastSurfaceTexture(surfaceTexture);
                }
                this.f29716b = false;
                this.f29717c = 0;
                this.f29718d = 0;
                a aVar = new a(this.f29720f.get());
                for (a.InterfaceC0769a interfaceC0769a : this.f29721g.keySet()) {
                    interfaceC0769a.b(aVar, 0, 0);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
                this.a = surfaceTexture;
                this.f29716b = false;
                this.f29717c = 0;
                this.f29718d = 0;
                a aVar = new a(this.f29720f.get());
                for (a.InterfaceC0769a interfaceC0769a : this.f29721g.keySet()) {
                    interfaceC0769a.a(aVar);
                }
                return this.f29719e;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i, i2) == null) {
                this.a = surfaceTexture;
                this.f29716b = true;
                this.f29717c = i;
                this.f29718d = i2;
                a aVar = new a(this.f29720f.get());
                for (a.InterfaceC0769a interfaceC0769a : this.f29721g.keySet()) {
                    interfaceC0769a.c(aVar, 0, i, i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29713b = 0;
        c(context);
    }

    @Override // c.a.n0.y.a
    public void a(a.InterfaceC0769a interfaceC0769a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0769a) == null) {
            this.f29715d.b(interfaceC0769a);
        }
    }

    @Override // c.a.n0.y.a
    public void b(a.InterfaceC0769a interfaceC0769a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0769a) == null) {
            this.f29715d.a(interfaceC0769a);
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = new c.a.n0.y.b(this);
            b bVar = new b(this);
            this.f29715d = bVar;
            setSurfaceTextureListener(bVar);
        }
    }

    public int getCurrentMediaPlayerCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29713b : invokeV.intValue;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29714c : (SurfaceTexture) invokeV.objValue;
    }

    public a.b getSurfaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new a(this) : (a.b) invokeV.objValue;
    }

    @Override // c.a.n0.y.a
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
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            this.a.a(i, i2);
            setMeasuredDimension(this.a.c(), this.a.b());
        }
    }

    @Override // c.a.n0.y.a
    @TargetApi(16)
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f29714c == null) {
            return;
        }
        if (isAvailable()) {
            this.f29715d.c(true);
            return;
        }
        this.f29714c.release();
        this.f29714c = null;
    }

    @Override // c.a.n0.y.a
    public void setAspectRatio(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.a.d(i);
            requestLayout();
        }
    }

    public void setCurrentMediaPlayerCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f29713b = i;
        }
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceTexture) == null) {
            this.f29714c = surfaceTexture;
        }
    }

    public void setVideoRotation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.a.e(i);
            setRotation(i);
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        this.a.f(i, i2);
        requestLayout();
    }

    @Override // c.a.n0.y.a
    public void setVideoSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) || i <= 0 || i2 <= 0) {
            return;
        }
        this.a.g(i, i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29713b = 0;
        c(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
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
        this.f29713b = 0;
        c(context);
    }
}
