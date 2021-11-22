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
import b.a.p0.y.a;
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
/* loaded from: classes8.dex */
public class TextureRenderView extends TextureView implements b.a.p0.y.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b.a.p0.y.b f45695e;

    /* renamed from: f  reason: collision with root package name */
    public int f45696f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f45697g;
    public b mSurfaceCallback;

    /* loaded from: classes8.dex */
    public static final class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextureRenderView f45698a;

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
            this.f45698a = textureRenderView;
        }

        @Override // b.a.p0.y.a.b
        @TargetApi(16)
        public void a(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) || mediaPlayer == null || this.f45698a.getSurfaceTexture() == null) {
                return;
            }
            if (mediaPlayer.hashCode() != this.f45698a.getCurrentMediaPlayerCode()) {
                mediaPlayer.setSurface(c());
            } else if (!this.f45698a.getLastSurfaceTexture().equals(this.f45698a.getSurfaceTexture())) {
                TextureRenderView textureRenderView = this.f45698a;
                textureRenderView.setSurfaceTexture(textureRenderView.getLastSurfaceTexture());
            }
            this.f45698a.setCurrentMediaPlayerCode(mediaPlayer.hashCode());
        }

        @Override // b.a.p0.y.a.b
        public b.a.p0.y.a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45698a : (b.a.p0.y.a) invokeV.objValue;
        }

        public Surface c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new Surface(this.f45698a.getSurfaceTexture()) : (Surface) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public SurfaceTexture f45699e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f45700f;

        /* renamed from: g  reason: collision with root package name */
        public int f45701g;

        /* renamed from: h  reason: collision with root package name */
        public int f45702h;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f45703i;
        public WeakReference<TextureRenderView> j;
        public Map<a.InterfaceC0659a, Object> k;

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
            this.f45703i = false;
            this.k = new ConcurrentHashMap();
            this.j = new WeakReference<>(textureRenderView);
        }

        public void a(a.InterfaceC0659a interfaceC0659a) {
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0659a) == null) {
                this.k.put(interfaceC0659a, interfaceC0659a);
                if (this.f45699e != null) {
                    aVar = new a(this.j.get());
                    interfaceC0659a.b(aVar, this.f45701g, this.f45702h);
                } else {
                    aVar = null;
                }
                if (this.f45700f) {
                    if (aVar == null) {
                        aVar = new a(this.j.get());
                    }
                    interfaceC0659a.c(aVar, 0, this.f45701g, this.f45702h);
                }
            }
        }

        public void b(a.InterfaceC0659a interfaceC0659a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0659a) == null) {
                this.k.remove(interfaceC0659a);
            }
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f45703i = z;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, surfaceTexture, i2, i3) == null) {
                this.f45699e = surfaceTexture;
                if (this.j.get() != null && this.j.get().getLastSurfaceTexture() == null) {
                    this.j.get().setLastSurfaceTexture(surfaceTexture);
                }
                this.f45700f = false;
                this.f45701g = 0;
                this.f45702h = 0;
                a aVar = new a(this.j.get());
                for (a.InterfaceC0659a interfaceC0659a : this.k.keySet()) {
                    interfaceC0659a.b(aVar, 0, 0);
                }
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, surfaceTexture)) == null) {
                this.f45699e = surfaceTexture;
                this.f45700f = false;
                this.f45701g = 0;
                this.f45702h = 0;
                a aVar = new a(this.j.get());
                for (a.InterfaceC0659a interfaceC0659a : this.k.keySet()) {
                    interfaceC0659a.a(aVar);
                }
                return this.f45703i;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, surfaceTexture, i2, i3) == null) {
                this.f45699e = surfaceTexture;
                this.f45700f = true;
                this.f45701g = i2;
                this.f45702h = i3;
                a aVar = new a(this.j.get());
                for (a.InterfaceC0659a interfaceC0659a : this.k.keySet()) {
                    interfaceC0659a.c(aVar, 0, i2, i3);
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
        this.f45696f = 0;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f45695e = new b.a.p0.y.b(this);
            b bVar = new b(this);
            this.mSurfaceCallback = bVar;
            setSurfaceTextureListener(bVar);
        }
    }

    @Override // b.a.p0.y.a
    public void addRenderCallback(a.InterfaceC0659a interfaceC0659a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0659a) == null) {
            this.mSurfaceCallback.a(interfaceC0659a);
        }
    }

    public int getCurrentMediaPlayerCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45696f : invokeV.intValue;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45697g : (SurfaceTexture) invokeV.objValue;
    }

    public a.b getSurfaceHolder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new a(this) : (a.b) invokeV.objValue;
    }

    @Override // b.a.p0.y.a
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
            this.f45695e.a(i2, i3);
            setMeasuredDimension(this.f45695e.c(), this.f45695e.b());
        }
    }

    @Override // b.a.p0.y.a
    @TargetApi(16)
    public void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f45697g == null) {
            return;
        }
        if (isAvailable()) {
            this.mSurfaceCallback.c(true);
            return;
        }
        this.f45697g.release();
        this.f45697g = null;
    }

    @Override // b.a.p0.y.a
    public void removeRenderCallback(a.InterfaceC0659a interfaceC0659a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC0659a) == null) {
            this.mSurfaceCallback.b(interfaceC0659a);
        }
    }

    @Override // b.a.p0.y.a
    public void setAspectRatio(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f45695e.d(i2);
            requestLayout();
        }
    }

    public void setCurrentMediaPlayerCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f45696f = i2;
        }
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, surfaceTexture) == null) {
            this.f45697g = surfaceTexture;
        }
    }

    public void setVideoRotation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f45695e.e(i2);
            setRotation(i2);
        }
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f45695e.f(i2, i3);
        requestLayout();
    }

    @Override // b.a.p0.y.a
    public void setVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || i2 <= 0 || i3 <= 0) {
            return;
        }
        this.f45695e.g(i2, i3);
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
        this.f45696f = 0;
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
        this.f45696f = 0;
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
        this.f45696f = 0;
        a(context);
    }
}
