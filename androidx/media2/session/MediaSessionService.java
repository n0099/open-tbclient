package androidx.media2.session;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.MediaSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MediaSessionService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SERVICE_INTERFACE = "androidx.media2.session.MediaSessionService";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaSessionServiceImpl mImpl;

    /* loaded from: classes.dex */
    public interface MediaSessionServiceImpl {
        void addSession(MediaSession mediaSession);

        List getSessions();

        IBinder onBind(Intent intent);

        void onCreate(MediaSessionService mediaSessionService);

        void onDestroy();

        int onStartCommand(Intent intent, int i, int i2);

        MediaNotification onUpdateNotification(MediaSession mediaSession);

        void removeSession(MediaSession mediaSession);
    }

    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    /* loaded from: classes.dex */
    public static class MediaNotification {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Notification mNotification;
        public final int mNotificationId;

        public MediaNotification(int i, Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), notification};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (notification != null) {
                this.mNotificationId = i;
                this.mNotification = notification;
                return;
            }
            throw new NullPointerException("notification shouldn't be null");
        }

        public Notification getNotification() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mNotification;
            }
            return (Notification) invokeV.objValue;
        }

        public int getNotificationId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mNotificationId;
            }
            return invokeV.intValue;
        }
    }

    public MediaSessionService() {
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
        this.mImpl = createImpl();
    }

    public MediaSessionServiceImpl createImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new MediaSessionServiceImplBase();
        }
        return (MediaSessionServiceImpl) invokeV.objValue;
    }

    public final List<MediaSession> getSessions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.getSessions();
        }
        return (List) invokeV.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onCreate();
            this.mImpl.onCreate(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.mImpl.onDestroy();
        }
    }

    public final void addSession(MediaSession mediaSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaSession) == null) {
            if (mediaSession != null) {
                if (!mediaSession.isClosed()) {
                    this.mImpl.addSession(mediaSession);
                    return;
                }
                throw new IllegalArgumentException("session is already closed");
            }
            throw new NullPointerException("session shouldn't be null");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, intent)) == null) {
            return this.mImpl.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }

    public MediaNotification onUpdateNotification(MediaSession mediaSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSession)) == null) {
            if (mediaSession != null) {
                return this.mImpl.onUpdateNotification(mediaSession);
            }
            throw new NullPointerException("session shouldn't be null");
        }
        return (MediaNotification) invokeL.objValue;
    }

    public final void removeSession(MediaSession mediaSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaSession) == null) {
            if (mediaSession != null) {
                this.mImpl.removeSession(mediaSession);
                return;
            }
            throw new NullPointerException("session shouldn't be null");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, intent, i, i2)) == null) {
            return this.mImpl.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}
