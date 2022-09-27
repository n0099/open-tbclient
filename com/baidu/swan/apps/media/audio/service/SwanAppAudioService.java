package com.baidu.swan.apps.media.audio.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.IAudioListener;
import com.baidu.swan.apps.IAudioService;
import com.baidu.tieba.oq2;
import com.baidu.tieba.ra3;
import com.baidu.tieba.sm2;
import com.baidu.tieba.sq2;
import com.baidu.tieba.vj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class SwanAppAudioService extends Service implements sq2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int INVALID_DURATION = -1;
    public static final int INVALID_ERROR_CODE = -1;
    public static final String TAG = "SwanAppAudioService";
    public transient /* synthetic */ FieldHolder $fh;
    public Binder mBinder;
    public v<IAudioListener> mCallback;
    public Handler mMainHandler;

    /* loaded from: classes2.dex */
    public static class AudioServiceStub extends IAudioService.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<SwanAppAudioService> mAudioService;

        public AudioServiceStub(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAudioService = new WeakReference<>(swanAppAudioService);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public int getDuration() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mAudioService.get() != null) {
                    return this.mAudioService.get().getDuration();
                }
                return -1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.swan.apps.IAudioService
        public boolean isPlaying() throws RemoteException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mAudioService.get() != null) {
                    return this.mAudioService.get().isPlaying();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void pause() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().pause();
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void play() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().play();
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void registerListener(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, iAudioListener) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().mCallback.register(iAudioListener);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void release() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().release();
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void seek(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().seek(i);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void setParams(String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().setParams(str);
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void stop() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mAudioService.get() == null) {
                return;
            }
            this.mAudioService.get().stop();
        }

        @Override // com.baidu.swan.apps.IAudioService
        public void unregisterListener(IAudioListener iAudioListener) throws RemoteException {
            WeakReference<SwanAppAudioService> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, iAudioListener) == null) || (weakReference = this.mAudioService) == null) {
                return;
            }
            weakReference.get().mCallback.unregister(iAudioListener);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public a(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onStop();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SwanAppAudioService b;

        public b(SwanAppAudioService swanAppAudioService, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = str;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onChangeSrc(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public c(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onEnded();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ SwanAppAudioService b;

        public d(SwanAppAudioService swanAppAudioService, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onError(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SwanAppAudioService c;

        public e(SwanAppAudioService swanAppAudioService, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = swanAppAudioService;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onTimeUpdate(this.a, this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ SwanAppAudioService b;

        public f(SwanAppAudioService swanAppAudioService, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = i;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onDownloadProgress(this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public g(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onPrev();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public h(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onNext();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public i(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onSeeking();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public j(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onSeekEnd();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ SwanAppAudioService c;

        public k(SwanAppAudioService swanAppAudioService, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = swanAppAudioService;
            this.a = j;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#setParams id=" + this.a + " params=" + this.b);
                sm2.f().a(this.b, this.c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class l {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1802972623, "Lcom/baidu/swan/apps/media/audio/service/SwanAppAudioService$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1802972623, "Lcom/baidu/swan/apps/media/audio/service/SwanAppAudioService$l;");
                    return;
                }
            }
            int[] iArr = new int[BgMusicPlayState.values().length];
            a = iArr;
            try {
                iArr[BgMusicPlayState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BgMusicPlayState.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BgMusicPlayState.REPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BgMusicPlayState.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[BgMusicPlayState.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[BgMusicPlayState.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[BgMusicPlayState.INTERRUPT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[BgMusicPlayState.LOADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SwanAppAudioService b;

        public m(SwanAppAudioService swanAppAudioService, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#play  id=" + this.a);
                sm2.f().play();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SwanAppAudioService b;

        public n(SwanAppAudioService swanAppAudioService, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#pause  id=" + this.a);
                sm2.f().pause();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SwanAppAudioService b;

        public o(SwanAppAudioService swanAppAudioService, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#stop id=" + this.a);
                sm2.f().stop();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ SwanAppAudioService c;

        public p(SwanAppAudioService swanAppAudioService, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = swanAppAudioService;
            this.a = j;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#seek id=" + this.a + " position=" + this.b);
                sm2.f().seek(this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ SwanAppAudioService b;

        public q(SwanAppAudioService swanAppAudioService, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = swanAppAudioService;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oq2.b(SwanAppAudioService.TAG, "post#release id=" + this.a);
                this.b.notifyEventOnStop();
                this.b.stopSelf();
                sm2.f().onRelease();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class r implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public r(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onCanPlay();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class s implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public s(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onPlay();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class t implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public t(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        @Override // com.baidu.swan.apps.media.audio.service.SwanAppAudioService.u
        public void a(IAudioListener iAudioListener) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                iAudioListener.onPause();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface u<E extends IAudioListener> {
        void a(E e) throws RemoteException;
    }

    /* loaded from: classes2.dex */
    public class v<E extends IAudioListener> extends RemoteCallbackList<IAudioListener> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppAudioService a;

        public v(SwanAppAudioService swanAppAudioService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppAudioService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppAudioService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(IAudioListener iAudioListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iAudioListener) == null) {
                oq2.b(SwanAppAudioService.TAG, "AudioRemoteCallbackList#onCallbackDied");
                this.a.stop();
            }
        }

        public /* synthetic */ v(SwanAppAudioService swanAppAudioService, k kVar) {
            this(swanAppAudioService);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1204109463, "Lcom/baidu/swan/apps/media/audio/service/SwanAppAudioService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1204109463, "Lcom/baidu/swan/apps/media/audio/service/SwanAppAudioService;");
                return;
            }
        }
        DEBUG = vj1.a;
    }

    public SwanAppAudioService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCallback = new v<>(this, null);
        this.mBinder = new AudioServiceStub(this);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void handleAudioEvent(@NonNull u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uVar) == null) {
            try {
                try {
                    int beginBroadcast = this.mCallback.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        uVar.a(this.mCallback.getBroadcastItem(i2));
                    }
                } catch (RemoteException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                this.mCallback.finishBroadcast();
            }
        }
    }

    private void handleStateChanged(BgMusicPlayState bgMusicPlayState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bgMusicPlayState) == null) {
            int i2 = l.a[bgMusicPlayState.ordinal()];
            if (i2 == 1) {
                notifyEventOnCanPlay();
            } else if (i2 == 2) {
                notifyEventOnPlay();
            } else if (i2 == 4) {
                notifyEventOnPause();
            } else if (i2 == 5) {
                notifyEventOnStop();
            } else if (i2 != 6) {
            } else {
                notifyEventOnEnded();
            }
        }
    }

    private void notifyEventOnCanPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            handleAudioEvent(new r(this));
        }
    }

    private void notifyEventOnEnded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            handleAudioEvent(new c(this));
        }
    }

    private void notifyEventOnError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            handleAudioEvent(new d(this, i2));
        }
    }

    private void notifyEventOnPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            handleAudioEvent(new t(this));
        }
    }

    private void notifyEventOnPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            handleAudioEvent(new s(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventOnStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            handleAudioEvent(new a(this));
        }
    }

    private void notifyOnChangeSrc(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            handleAudioEvent(new b(this, str));
        }
    }

    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? sm2.f().getDuration() : invokeV.intValue;
    }

    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? sm2.f().isPlaying() : invokeV.booleanValue;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
            oq2.b(TAG, "#onBind");
            return this.mBinder;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCreate();
            oq2.b(TAG, "#onCreate");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            oq2.b(TAG, "#onDestroy");
            this.mCallback.kill();
            this.mMainHandler.removeCallbacksAndMessages(null);
            release();
            super.onDestroy();
        }
    }

    public void onError(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            ra3.b("audio", 2008, "error code is" + i2, -1, "");
            notifyEventOnError(i2);
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onGetCurrentSong(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            notifyOnChangeSrc(str);
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onGetDownloadProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            handleAudioEvent(new f(this, i2));
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onGetDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onGetPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            handleAudioEvent(new e(this, i2, i3));
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onInvokeFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ra3.b("audio", 2001, "invoke fail", -1, "");
            notifyEventOnError(-1);
        }
    }

    public void onNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            handleAudioEvent(new h(this));
        }
    }

    public void onPlayModeChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    public void onPrev() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            handleAudioEvent(new g(this));
        }
    }

    public void onSeekEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            handleAudioEvent(new j(this));
        }
    }

    public void onSeeking() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            handleAudioEvent(new i(this));
        }
    }

    @Override // com.baidu.tieba.sq2
    public void onStateChanged(BgMusicPlayState bgMusicPlayState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bgMusicPlayState) == null) {
            oq2.c(TAG, "#onStateChanged state=" + bgMusicPlayState, new Exception("stack"));
            handleStateChanged(bgMusicPlayState);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, intent)) == null) {
            oq2.b(TAG, "#onUnbind");
            return false;
        }
        return invokeL.booleanValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#pause id=" + nanoTime);
            this.mMainHandler.post(new n(this, nanoTime));
        }
    }

    public void play() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#play id=" + nanoTime);
            this.mMainHandler.post(new m(this, nanoTime));
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#release id=" + nanoTime);
            this.mMainHandler.post(new q(this, nanoTime));
        }
    }

    public void seek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#seek id=" + nanoTime);
            this.mMainHandler.post(new p(this, nanoTime, i2));
        }
    }

    public void setParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#setParams id=" + nanoTime);
            this.mMainHandler.post(new k(this, nanoTime, str));
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            long nanoTime = System.nanoTime();
            oq2.b(TAG, "#stop id=" + nanoTime);
            this.mMainHandler.post(new o(this, nanoTime));
        }
    }
}
