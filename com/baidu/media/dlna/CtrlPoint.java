package com.baidu.media.dlna;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider;
import com.baidu.media.duplayer.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CtrlPoint extends CtrlPointProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f8051a;

    /* renamed from: b  reason: collision with root package name */
    public int f8052b;

    /* renamed from: c  reason: collision with root package name */
    public CtrlPointProvider.CtrlPointListener f8053c;

    /* renamed from: d  reason: collision with root package name */
    public String f8054d;

    /* renamed from: e  reason: collision with root package name */
    public String f8055e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f8056f;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CtrlPoint f8057a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CtrlPoint ctrlPoint, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ctrlPoint, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8057a = ctrlPoint;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CtrlPointProvider.CtrlPointListener ctrlPointListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 1) {
                    CtrlPointProvider.CtrlPointListener ctrlPointListener2 = this.f8057a.f8053c;
                    if (ctrlPointListener2 != null) {
                        ctrlPointListener2.onPrepared();
                    }
                } else if (i2 == 2) {
                    CtrlPointProvider.CtrlPointListener ctrlPointListener3 = this.f8057a.f8053c;
                    if (ctrlPointListener3 != null) {
                        ctrlPointListener3.onComplete();
                    }
                } else if (i2 == 3) {
                    CtrlPointProvider.CtrlPointListener ctrlPointListener4 = this.f8057a.f8053c;
                    if (ctrlPointListener4 != null) {
                        ctrlPointListener4.onError(message.arg1, message.arg2);
                    }
                } else if (i2 == 4) {
                    this.f8057a.f8052b = message.arg2;
                    if (this.f8057a.f8053c != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", this.f8057a.f8054d);
                        hashMap.put("uuid", this.f8057a.f8055e);
                        this.f8057a.f8053c.onInfo(message.arg1, message.arg2, hashMap);
                    }
                } else if (i2 == 5 && (ctrlPointListener = this.f8057a.f8053c) != null) {
                    ctrlPointListener.onSeekCompleted(message.arg1, message.arg2);
                }
                super.handleMessage(message);
            }
        }
    }

    public CtrlPoint(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f8051a = 0L;
        this.f8052b = -1;
        this.f8054d = null;
        this.f8055e = null;
        this.f8056f = new a(this, Looper.getMainLooper());
        this.f8051a = j;
        this.f8055e = str;
        if (j != 0) {
            nativeCtrlPointSetListener(j, new WeakReference(this));
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    return packageManager.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, context.getPackageName()) == 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static native long nativeCtrlPointDuration(long j);

    public static native long nativeCtrlPointGetCurrentPos(long j);

    public static native int nativeCtrlPointGetPlaybackVolume(long j);

    public static native void nativeCtrlPointPause(long j);

    public static native void nativeCtrlPointPlay(long j);

    public static native void nativeCtrlPointSeek(long j, long j2);

    public static native void nativeCtrlPointSetAVTransportURI(long j, String str);

    public static native void nativeCtrlPointSetListener(long j, Object obj);

    public static native void nativeCtrlPointSetMute(long j, int i2);

    public static native void nativeCtrlPointSetPlaybackVolume(long j, int i2);

    public static native void nativeCtrlPointShutdown(long j, boolean z);

    public static native void nativeCtrlPointStop(long j);

    @Keep
    public static void onComplete(Object obj) {
        CtrlPoint ctrlPoint;
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, obj) == null) || obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f8056f) == null) {
            return;
        }
        Message.obtain(handler, 2).sendToTarget();
    }

    @Keep
    public static void onError(Object obj, int i2, int i3) {
        CtrlPoint ctrlPoint;
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65552, null, obj, i2, i3) == null) || obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f8056f) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 3);
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.sendToTarget();
    }

    @Keep
    public static void onInfo(Object obj, int i2, int i3) {
        CtrlPoint ctrlPoint;
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65553, null, obj, i2, i3) == null) || obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f8056f) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 4);
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.sendToTarget();
    }

    @Keep
    public static int onNetworkStatus(Object obj) {
        InterceptResult invokeL;
        Context applicationContext;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, obj)) == null) {
            if (obj == null || (applicationContext = CyberPlayerManager.getApplicationContext()) == null || !b(applicationContext) || (activeNetworkInfo = ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 1;
            }
            return activeNetworkInfo.getType() == 1 ? 2 : 0;
        }
        return invokeL.intValue;
    }

    @Keep
    public static void onPrepared(Object obj) {
        CtrlPoint ctrlPoint;
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, obj) == null) || obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f8056f) == null) {
            return;
        }
        Message.obtain(handler, 1).sendToTarget();
    }

    @Keep
    public static void onSeekCompleted(Object obj, int i2, int i3) {
        CtrlPoint ctrlPoint;
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65556, null, obj, i2, i3) == null) || obj == null || (ctrlPoint = (CtrlPoint) ((WeakReference) obj).get()) == null || (handler = ctrlPoint.f8056f) == null) {
            return;
        }
        Message obtain = Message.obtain(handler, 5);
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.sendToTarget();
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getCurrentTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long j = this.f8051a;
            if (j != 0) {
                return nativeCtrlPointGetCurrentPos(j);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.f8051a;
            if (j != 0) {
                return nativeCtrlPointDuration(j);
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getPlaybackVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = this.f8051a;
            if (j != 0) {
                return nativeCtrlPointGetPlaybackVolume(j);
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public int getUrlPlayStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (this.f8051a != 0 && str.equals(this.f8054d)) {
                return this.f8052b;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointPause(j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointPlay(j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void seek(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            long j2 = this.f8051a;
            if (j2 != 0) {
                nativeCtrlPointSeek(j2, j);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setAVTransportUrl(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.f8051a == 0 || str == null || str.length() <= 0) {
            return;
        }
        nativeCtrlPointSetAVTransportURI(this.f8051a, str);
        this.f8054d = str;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setListener(CtrlPointProvider.CtrlPointListener ctrlPointListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ctrlPointListener) == null) || this.f8051a == 0) {
            return;
        }
        this.f8053c = ctrlPointListener;
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setMute(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointSetMute(j, i2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void setPlaybackVolume(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointSetPlaybackVolume(j, i2);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointShutdown(j, false);
                this.f8051a = 0L;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void shutdown(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointShutdown(j, z);
                this.f8051a = 0L;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.dlna.CtrlPointProvider
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            long j = this.f8051a;
            if (j != 0) {
                nativeCtrlPointStop(j);
            }
        }
    }
}
