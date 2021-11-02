package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.SystemEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.pool.SynchronizedFIFOPool;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoSessionManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SynchronizedFIFOPool<VideoSession> mSessionCache;
    public SystemEventTrigger mSystemEventTrigger;

    /* renamed from: com.baidu.searchbox.player.session.VideoSessionManager$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final VideoSessionManager mInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1188755728, "Lcom/baidu/searchbox/player/session/VideoSessionManager$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1188755728, "Lcom/baidu/searchbox/player/session/VideoSessionManager$Holder;");
                    return;
                }
            }
            mInstance = new VideoSessionManager(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ VideoSessionManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    @PublicMethod
    public static VideoSessionManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Holder.mInstance : (VideoSessionManager) invokeV.objValue;
    }

    private void setupSystemEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            SystemEventTrigger systemEventTrigger = new SystemEventTrigger();
            this.mSystemEventTrigger = systemEventTrigger;
            systemEventTrigger.registerReceiver();
        }
    }

    private void triggerValidCheck() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mSystemEventTrigger == null) {
            setupSystemEventTrigger();
        }
    }

    @PublicMethod
    public VideoSession getVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            triggerValidCheck();
            VideoSession acquire = this.mSessionCache.acquire();
            if (acquire == null) {
                acquire = new VideoSession();
            }
            this.mSystemEventTrigger.register(acquire.getMessenger());
            return acquire;
        }
        return (VideoSession) invokeV.objValue;
    }

    @PublicMethod
    public void recycle(@NonNull VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoSession) == null) {
            SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
            if (systemEventTrigger != null) {
                systemEventTrigger.unregister(videoSession.getMessenger());
            }
            this.mSessionCache.release((SynchronizedFIFOPool<VideoSession>) videoSession);
        }
    }

    @PublicMethod
    public void release() {
        SystemEventTrigger systemEventTrigger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (systemEventTrigger = this.mSystemEventTrigger) == null) {
            return;
        }
        systemEventTrigger.clear();
        this.mSystemEventTrigger.unregisterReceiver();
        this.mSystemEventTrigger = null;
    }

    @PublicMethod
    public void sendEventToAll(@NonNull VideoEvent videoEvent) {
        SystemEventTrigger systemEventTrigger;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoEvent) == null) || (systemEventTrigger = this.mSystemEventTrigger) == null) {
            return;
        }
        systemEventTrigger.triggerEvent(videoEvent);
    }

    public VideoSessionManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSessionCache = new SynchronizedFIFOPool<>(10);
    }
}
