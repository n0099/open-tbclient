package androidx.media2.session;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.MediaSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ConnectedControllersManager<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "MS2ControllerMgr";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public final ArrayMap<T, MediaSession.ControllerInfo> mControllerInfoMap;
    @GuardedBy("mLock")
    public final ArrayMap<MediaSession.ControllerInfo, ConnectedControllersManager<T>.ConnectedControllerRecord> mControllerRecords;
    public final Object mLock;
    public final MediaSession.MediaSessionImpl mSessionImpl;

    /* loaded from: classes.dex */
    public class ConnectedControllerRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SessionCommandGroup allowedCommands;
        public final T controllerKey;
        public final SequencedFutureManager sequencedFutureManager;
        public final /* synthetic */ ConnectedControllersManager this$0;

        public ConnectedControllerRecord(ConnectedControllersManager connectedControllersManager, T t, SequencedFutureManager sequencedFutureManager, SessionCommandGroup sessionCommandGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectedControllersManager, t, sequencedFutureManager, sessionCommandGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = connectedControllersManager;
            this.controllerKey = t;
            this.sequencedFutureManager = sequencedFutureManager;
            this.allowedCommands = sessionCommandGroup;
            if (sessionCommandGroup == null) {
                this.allowedCommands = new SessionCommandGroup();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-222830436, "Landroidx/media2/session/ConnectedControllersManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-222830436, "Landroidx/media2/session/ConnectedControllersManager;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public ConnectedControllersManager(MediaSession.MediaSessionImpl mediaSessionImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSessionImpl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mControllerInfoMap = new ArrayMap<>();
        this.mControllerRecords = new ArrayMap<>();
        this.mSessionImpl = mediaSessionImpl;
    }

    public void addController(T t, MediaSession.ControllerInfo controllerInfo, SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, t, controllerInfo, sessionCommandGroup) == null) {
            if (t != null && controllerInfo != null) {
                synchronized (this.mLock) {
                    MediaSession.ControllerInfo controller = getController(t);
                    if (controller == null) {
                        this.mControllerInfoMap.put(t, controllerInfo);
                        this.mControllerRecords.put(controllerInfo, new ConnectedControllerRecord(this, t, new SequencedFutureManager(), sessionCommandGroup));
                    } else {
                        this.mControllerRecords.get(controller).allowedCommands = sessionCommandGroup;
                    }
                }
            } else if (DEBUG) {
                throw new IllegalArgumentException("controllerKey and controllerInfo shouldn't be null");
            }
        }
    }

    public final List<MediaSession.ControllerInfo> getConnectedControllers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.mLock) {
                arrayList.addAll(this.mControllerInfoMap.values());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public MediaSession.ControllerInfo getController(T t) {
        InterceptResult invokeL;
        MediaSession.ControllerInfo controllerInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            synchronized (this.mLock) {
                controllerInfo = this.mControllerInfoMap.get(t);
            }
            return controllerInfo;
        }
        return (MediaSession.ControllerInfo) invokeL.objValue;
    }

    @Nullable
    public final SequencedFutureManager getSequencedFutureManager(@Nullable MediaSession.ControllerInfo controllerInfo) {
        InterceptResult invokeL;
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, controllerInfo)) == null) {
            synchronized (this.mLock) {
                connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
            }
            if (connectedControllerRecord != null) {
                return connectedControllerRecord.sequencedFutureManager;
            }
            return null;
        }
        return (SequencedFutureManager) invokeL.objValue;
    }

    public boolean isAllowedCommand(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        InterceptResult invokeLL;
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, controllerInfo, sessionCommand)) == null) {
            synchronized (this.mLock) {
                connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
            }
            return connectedControllerRecord != null && connectedControllerRecord.allowedCommands.hasCommand(sessionCommand);
        }
        return invokeLL.booleanValue;
    }

    public final boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, controllerInfo)) == null) {
            synchronized (this.mLock) {
                z = this.mControllerRecords.get(controllerInfo) != null;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void removeController(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, t) == null) || t == null) {
            return;
        }
        removeController(getController(t));
    }

    public void updateAllowedCommands(MediaSession.ControllerInfo controllerInfo, SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, controllerInfo, sessionCommandGroup) == null) || controllerInfo == null) {
            return;
        }
        synchronized (this.mLock) {
            ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
            if (connectedControllerRecord != null) {
                connectedControllerRecord.allowedCommands = sessionCommandGroup;
            }
        }
    }

    public void removeController(MediaSession.ControllerInfo controllerInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, controllerInfo) == null) || controllerInfo == null) {
            return;
        }
        synchronized (this.mLock) {
            ConnectedControllersManager<T>.ConnectedControllerRecord remove = this.mControllerRecords.remove(controllerInfo);
            if (remove == null) {
                return;
            }
            this.mControllerInfoMap.remove(remove.controllerKey);
            if (DEBUG) {
                Log.d(TAG, "Controller " + controllerInfo + " is disconnected");
            }
            remove.sequencedFutureManager.close();
            this.mSessionImpl.getCallbackExecutor().execute(new Runnable(this, controllerInfo) { // from class: androidx.media2.session.ConnectedControllersManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ConnectedControllersManager this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controllerInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, controllerInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$controllerInfo = controllerInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mSessionImpl.isClosed()) {
                        return;
                    }
                    this.this$0.mSessionImpl.getCallback().onDisconnected(this.this$0.mSessionImpl.getInstance(), this.val$controllerInfo);
                }
            });
        }
    }

    public SequencedFutureManager getSequencedFutureManager(@Nullable T t) {
        InterceptResult invokeL;
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            synchronized (this.mLock) {
                connectedControllerRecord = this.mControllerRecords.get(getController(t));
            }
            if (connectedControllerRecord != null) {
                return connectedControllerRecord.sequencedFutureManager;
            }
            return null;
        }
        return (SequencedFutureManager) invokeL.objValue;
    }

    public boolean isAllowedCommand(MediaSession.ControllerInfo controllerInfo, int i) {
        InterceptResult invokeLI;
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, controllerInfo, i)) == null) {
            synchronized (this.mLock) {
                connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
            }
            return connectedControllerRecord != null && connectedControllerRecord.allowedCommands.hasCommand(i);
        }
        return invokeLI.booleanValue;
    }
}
