package com.baidu.searchbox.player.session;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.SystemEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public class VideoSessionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VideoSessionManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayMap mSessionIdCache;
    public SystemEventTrigger mSystemEventTrigger;

    /* renamed from: com.baidu.searchbox.player.session.VideoSessionManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public final class Holder {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public VideoSessionManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSessionIdCache = new ArrayMap();
    }

    public static VideoSessionManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return Holder.mInstance;
        }
        return (VideoSessionManager) invokeV.objValue;
    }

    private void setupSystemEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            SystemEventTrigger systemEventTrigger = new SystemEventTrigger();
            this.mSystemEventTrigger = systemEventTrigger;
            systemEventTrigger.registerReceiver();
        }
    }

    private void triggerValidCheck() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mSystemEventTrigger == null) {
            setupSystemEventTrigger();
        }
    }

    public VideoSession createVideoSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new VideoSession();
        }
        return (VideoSession) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
            if (systemEventTrigger != null) {
                systemEventTrigger.clear();
                this.mSystemEventTrigger.unregisterReceiver();
                this.mSystemEventTrigger = null;
            }
            this.mSessionIdCache.clear();
        }
    }

    public /* synthetic */ VideoSessionManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void bindPlayer(BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bDVideoPlayer) == null) {
            triggerValidCheck();
            BdVideoLog.d("session manager bind player =>" + bDVideoPlayer);
            this.mSystemEventTrigger.bindMessenger(bDVideoPlayer.getMessenger());
        }
    }

    public void recycle(VideoSession videoSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, videoSession) == null) {
            videoSession.reset();
        }
    }

    public void sendEventToAll(VideoEvent videoEvent) {
        SystemEventTrigger systemEventTrigger;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, videoEvent) == null) && (systemEventTrigger = this.mSystemEventTrigger) != null) {
            systemEventTrigger.triggerEvent(videoEvent);
        }
    }

    public void unbindPlayer(BDVideoPlayer bDVideoPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bDVideoPlayer) == null) {
            BdVideoLog.d("session manager unbind player =>" + bDVideoPlayer);
            SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
            if (systemEventTrigger != null) {
                systemEventTrigger.unbindMessenger(bDVideoPlayer.getMessenger());
            }
        }
    }

    private String generateSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String replace = UUID.randomUUID().toString().toLowerCase(Locale.ROOT).replace("-", "");
            BdVideoLog.d(TAG, "generateSessionId:" + replace);
            return replace;
        }
        return (String) invokeV.objValue;
    }

    public String getSessionId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String str2 = (String) this.mSessionIdCache.remove(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = generateSessionId();
                this.mSessionIdCache.put(str, str2);
            }
            BdVideoLog.d(TAG, "getSessionId:" + str2 + ",key:" + str);
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
