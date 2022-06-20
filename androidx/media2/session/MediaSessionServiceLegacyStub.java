package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.session.MediaSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class MediaSessionServiceLegacyStub extends MediaBrowserServiceCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    public final androidx.media.MediaSessionManager mManager;
    public final MediaSession.MediaSessionImpl mSessionImpl;

    public MediaSessionServiceLegacyStub(Context context, MediaSession.MediaSessionImpl mediaSessionImpl, MediaSessionCompat.Token token) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaSessionImpl, token};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        attachToBaseContext(context);
        onCreate();
        setSessionToken(token);
        this.mManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mSessionImpl = mediaSessionImpl;
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, remoteUserInfo)) == null) ? new MediaSession.ControllerInfo(remoteUserInfo, -1, this.mManager.isTrustedForMediaControl(remoteUserInfo), null, null) : (MediaSession.ControllerInfo) invokeL.objValue;
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mConnectedControllersManager : (ConnectedControllersManager) invokeV.objValue;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, bundle)) == null) {
            MediaSessionManager.RemoteUserInfo currentBrowserInfo = getCurrentBrowserInfo();
            MediaSession.ControllerInfo createControllerInfo = createControllerInfo(currentBrowserInfo);
            SessionCommandGroup onConnect = this.mSessionImpl.getCallback().onConnect(this.mSessionImpl.getInstance(), createControllerInfo);
            if (onConnect == null) {
                return null;
            }
            this.mConnectedControllersManager.addController(currentBrowserInfo, createControllerInfo, onConnect);
            return MediaUtils.sDefaultBrowserRoot;
        }
        return (MediaBrowserServiceCompat.BrowserRoot) invokeLIL.objValue;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, result) == null) {
            result.sendResult(null);
        }
    }
}
