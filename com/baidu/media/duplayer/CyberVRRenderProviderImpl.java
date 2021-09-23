package com.baidu.media.duplayer;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberVRRenderProvider;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Keep
/* loaded from: classes5.dex */
public class CyberVRRenderProviderImpl extends CyberVRRenderProvider {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BDVRRenderDelegate";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f42658a;

    /* renamed from: b  reason: collision with root package name */
    public Method f42659b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f42660c;

    /* renamed from: d  reason: collision with root package name */
    public Method f42661d;

    /* renamed from: e  reason: collision with root package name */
    public Method f42662e;

    /* renamed from: f  reason: collision with root package name */
    public Method f42663f;

    /* renamed from: g  reason: collision with root package name */
    public Method f42664g;

    /* renamed from: h  reason: collision with root package name */
    public Method f42665h;

    /* renamed from: i  reason: collision with root package name */
    public Method f42666i;

    /* renamed from: j  reason: collision with root package name */
    public Method f42667j;
    public Method k;
    public Method l;
    public Method m;
    public Method n;
    public Method o;
    public Method p;
    public Method q;
    public Method r;
    public Method s;
    public final Object t;

    /* loaded from: classes5.dex */
    public class a implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public CyberVRRenderProvider.IOnSurfaceReadyCallback f42668e;

        /* renamed from: f  reason: collision with root package name */
        public CyberVRRenderProvider.INotSupportCallback f42669f;

        public a(CyberVRRenderProviderImpl cyberVRRenderProviderImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cyberVRRenderProviderImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iNotSupportCallback) == null) {
                this.f42669f = iNotSupportCallback;
            }
        }

        public void b(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOnSurfaceReadyCallback) == null) {
                this.f42668e = iOnSurfaceReadyCallback;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            InterceptResult invokeLLL;
            CyberVRRenderProvider.INotSupportCallback iNotSupportCallback;
            CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, method, objArr)) == null) {
                if (method.getName().startsWith("onS") && (iOnSurfaceReadyCallback = this.f42668e) != null) {
                    iOnSurfaceReadyCallback.onSurfaceReady((Surface) objArr[0]);
                    return null;
                } else if (!method.getName().startsWith("onN") || (iNotSupportCallback = this.f42669f) == null) {
                    return null;
                } else {
                    iNotSupportCallback.onNotSupport(((Integer) objArr[0]).intValue());
                    return null;
                }
            }
            return invokeLLL.objValue;
        }
    }

    public CyberVRRenderProviderImpl(Context context) {
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
        this.f42660c = Class.forName("com.baidu.vr.BDVRRender").getConstructor(Context.class).newInstance(context);
        Class<?> cls = Class.forName("com.baidu.vr.BDVRRender");
        Class<?> cls2 = Class.forName("com.baidu.vr.BDVRRender$IOnSurfaceReadyCallback");
        Class<?> cls3 = Class.forName("com.baidu.vr.BDVRRender$INotSupportCallback");
        this.f42661d = c.a.z.a.a.a.a(cls, "init", SurfaceView.class);
        this.f42662e = c.a.z.a.a.a.a(cls, "init", TextureView.class);
        Class cls4 = Float.TYPE;
        this.f42663f = c.a.z.a.a.a.a(cls, "onTextureResize", cls4, cls4);
        this.f42664g = c.a.z.a.a.a.a(cls, "switchInteractiveMode", Integer.TYPE);
        this.f42665h = c.a.z.a.a.a.a(cls, "switchDisplayMode", Integer.TYPE);
        this.f42666i = c.a.z.a.a.a.a(cls, "switchProjectionMode", Integer.TYPE);
        this.f42667j = c.a.z.a.a.a.a(cls, "onResume", new Class[0]);
        this.f42659b = c.a.z.a.a.a.a(cls, MissionEvent.MESSAGE_PAUSE, new Class[0]);
        this.k = c.a.z.a.a.a.a(cls, MissionEvent.MESSAGE_DESTROY, new Class[0]);
        this.l = c.a.z.a.a.a.a(cls, "onOrientationChanged", new Class[0]);
        this.m = c.a.z.a.a.a.a(cls, "displayMode", Integer.TYPE);
        this.n = c.a.z.a.a.a.a(cls, "interactiveMode", Integer.TYPE);
        this.o = c.a.z.a.a.a.a(cls, "projectionMode", Integer.TYPE);
        this.p = c.a.z.a.a.a.a(cls, "pinchEnabled", Boolean.TYPE);
        this.q = c.a.z.a.a.a.a(cls, "asVideo", cls2);
        this.r = c.a.z.a.a.a.a(cls, "ifNotSupport", cls3);
        Class cls5 = Float.TYPE;
        this.s = c.a.z.a.a.a.a(cls, "setFov", cls5, cls5, cls5);
        this.f42658a = new a(this);
        this.t = Proxy.newProxyInstance(CyberVRRenderProviderImpl.class.getClassLoader(), new Class[]{cls2, cls3}, this.f42658a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl asVideo(CyberVRRenderProvider.IOnSurfaceReadyCallback iOnSurfaceReadyCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOnSurfaceReadyCallback)) == null) {
            if (this.f42660c == null || this.q == null) {
                CyberLog.e(TAG, "can not call asVideo method. mBdVRRender = " + this.f42660c + ", mAsVideoMethod = " + this.q);
                return this;
            }
            this.f42658a.b(iOnSurfaceReadyCallback);
            try {
                this.q.invoke(this.f42660c, this.t);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl displayMode(int i2) {
        InterceptResult invokeI;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Object obj = this.f42660c;
            if (obj != null && (method = this.m) != null) {
                try {
                    method.invoke(obj, Integer.valueOf(i2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                return this;
            }
            CyberLog.e(TAG, "can not call displayMode method. mBdVRRender = " + this.f42660c + ", mDisplayModeMethod = " + this.m);
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl ifNotSupport(CyberVRRenderProvider.INotSupportCallback iNotSupportCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iNotSupportCallback)) == null) {
            if (this.f42660c == null || this.r == null) {
                CyberLog.e(TAG, "can not call ifNotSupport method. mBdVRRender = " + this.f42660c + ", mIfNotSupportMethod = " + this.r);
                return this;
            }
            this.f42658a.a(iNotSupportCallback);
            try {
                this.r.invoke(this.f42660c, this.t);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeL.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(SurfaceView surfaceView) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, surfaceView) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42661d) == null) {
                CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f42660c + ", mInitMethod1 = " + this.f42661d);
                return;
            }
            try {
                method.invoke(obj, surfaceView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void init(TextureView textureView) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textureView) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42662e) == null) {
                CyberLog.e(TAG, "can not call init method. mBdVRRender = " + this.f42660c + ", mInitMethod1 = " + this.f42662e);
                return;
            }
            try {
                method.invoke(obj, textureView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl interactiveMode(int i2) {
        InterceptResult invokeI;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            Object obj = this.f42660c;
            if (obj != null && (method = this.n) != null) {
                try {
                    method.invoke(obj, Integer.valueOf(i2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                return this;
            }
            CyberLog.e(TAG, "can not call interactiveMode method. mBdVRRender = " + this.f42660c + ", mInteractiveModeMethod = " + this.n);
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeI.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onDestroy() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.k) == null) {
                CyberLog.e(TAG, "can not call onDestroy method. mBdVRRender = " + this.f42660c + ", mOnDestroyMethod = " + this.k);
                return;
            }
            try {
                method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onOrientationChanged() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.l) == null) {
                CyberLog.e(TAG, "can not call onOrientationChanged method. mBdVRRender = " + this.f42660c + ", mOnOrientationChanged = " + this.l);
                return;
            }
            try {
                method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onPause() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42659b) == null) {
                CyberLog.e(TAG, "can not call onPause method. mBdVRRender = " + this.f42660c + ", mOnPause = " + this.f42659b);
                return;
            }
            try {
                method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onResume() {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42667j) == null) {
                CyberLog.e(TAG, "can not call onResume method. mBdVRRender = " + this.f42660c + ", mOnResume = " + this.f42667j);
                return;
            }
            try {
                method.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void onTextureResize(float f2, float f3) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42663f) == null) {
                CyberLog.e(TAG, "can not call onTextureResize method. mBdVRRender = " + this.f42660c + ", mOnTextureResizeMethod = " + this.f42663f);
                return;
            }
            try {
                method.invoke(obj, Float.valueOf(f2), Float.valueOf(f3));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl pinchEnabled(boolean z) {
        InterceptResult invokeZ;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            Object obj = this.f42660c;
            if (obj != null && (method = this.p) != null) {
                try {
                    method.invoke(obj, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                return this;
            }
            CyberLog.e(TAG, "can not call pinchEnabled method. mBdVRRender = " + this.f42660c + ", mPinchEnabledMethod = " + this.p);
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeZ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl projectionMode(int i2) {
        InterceptResult invokeI;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            Object obj = this.f42660c;
            if (obj != null && (method = this.o) != null) {
                try {
                    method.invoke(obj, Integer.valueOf(i2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                return this;
            }
            CyberLog.e(TAG, "can not call projectionMode method. mBdVRRender = " + this.f42660c + ", mProjectionModeMethod = " + this.o);
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public CyberVRRenderProviderImpl setFov(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            Object obj = this.f42660c;
            if (obj != null && (method = this.s) != null) {
                try {
                    method.invoke(obj, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
                return this;
            }
            CyberLog.e(TAG, "can not call setFov method. mBdVRRender = " + this.f42660c + ", mSetFovMethod = " + this.s);
            return this;
        }
        return (CyberVRRenderProviderImpl) invokeCommon.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchDisplayMode(int i2) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42665h) == null) {
                CyberLog.e(TAG, "can not call switchDisplayMode method. mBdVRRender = " + this.f42660c + ", mSwitchDisplayModeMethod = " + this.f42665h);
                return;
            }
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchInteractiveMode(int i2) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42664g) == null) {
                CyberLog.e(TAG, "can not call switchInteractiveMode method. mBdVRRender = " + this.f42660c + ", mSwitchInteractiveModeMethod = " + this.f42664g);
                return;
            }
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVRRenderProvider
    public void switchProjectionMode(int i2) {
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            Object obj = this.f42660c;
            if (obj == null || (method = this.f42666i) == null) {
                CyberLog.e(TAG, "can not call switchProjectionMode method. mBdVRRender = " + this.f42660c + ", mSwitchProjectionMode = " + this.f42666i);
                return;
            }
            try {
                method.invoke(obj, Integer.valueOf(i2));
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }
}
