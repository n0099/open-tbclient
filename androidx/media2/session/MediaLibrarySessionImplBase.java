package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionImplBase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaLibrarySessionImplBase extends MediaSessionImplBase implements MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public final ArrayMap<MediaSession.ControllerCb, Set<String>> mSubscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibrarySessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        super(mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MediaSession) objArr2[0], (Context) objArr2[1], (String) objArr2[2], (SessionPlayer) objArr2[3], (PendingIntent) objArr2[4], (Executor) objArr2[5], (MediaSession.SessionCallback) objArr2[6], (Bundle) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSubscriptions = new ArrayMap<>();
    }

    private LibraryResult ensureNonNullResult(LibraryResult libraryResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, libraryResult)) == null) {
            if (libraryResult != null) {
                return libraryResult;
            }
            throw new RuntimeException("LibraryResult shouldn't be null");
        }
        return (LibraryResult) invokeL.objValue;
    }

    private LibraryResult ensureNonNullResultWithValidItem(LibraryResult libraryResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, libraryResult)) == null) {
            LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
            return (ensureNonNullResult.getResultCode() != 0 || isValidItem(ensureNonNullResult.getMediaItem())) ? ensureNonNullResult : new LibraryResult(-1);
        }
        return (LibraryResult) invokeL.objValue;
    }

    private LibraryResult ensureNonNullResultWithValidList(LibraryResult libraryResult, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, libraryResult, i)) == null) {
            LibraryResult ensureNonNullResult = ensureNonNullResult(libraryResult);
            if (ensureNonNullResult.getResultCode() == 0) {
                List<MediaItem> mediaItems = ensureNonNullResult.getMediaItems();
                if (mediaItems != null) {
                    if (mediaItems.size() <= i) {
                        for (MediaItem mediaItem : mediaItems) {
                            if (!isValidItem(mediaItem)) {
                                return new LibraryResult(-1);
                            }
                        }
                    } else {
                        throw new RuntimeException("List shouldn't contain items more than pageSize, size=" + ensureNonNullResult.getMediaItems().size() + ", pageSize" + i);
                    }
                } else {
                    throw new RuntimeException("List shouldn't be null for the success");
                }
            }
            return ensureNonNullResult;
        }
        return (LibraryResult) invokeLI.objValue;
    }

    private boolean isValidItem(MediaItem mediaItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, mediaItem)) == null) {
            if (mediaItem != null) {
                if (!TextUtils.isEmpty(mediaItem.getMediaId())) {
                    MediaMetadata metadata = mediaItem.getMetadata();
                    if (metadata != null) {
                        if (metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE)) {
                            if (metadata.containsKey(MediaMetadata.METADATA_KEY_PLAYABLE)) {
                                return true;
                            }
                            throw new RuntimeException("METADATA_KEY_PLAYABLE should be specified in metadata of an item");
                        }
                        throw new RuntimeException("METADATA_KEY_BROWSABLE should be specified in metadata of an item");
                    }
                    throw new RuntimeException("Metadata of an item shouldn't be null for the success");
                }
                throw new RuntimeException("Media ID of an item shouldn't be empty for the success");
            }
            throw new RuntimeException("Item shouldn't be null for the success");
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaBrowserServiceCompat createLegacyBrowserService(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, sessionToken, token)) == null) ? new MediaLibraryServiceLegacyStub(context, this, token) : (MediaBrowserServiceCompat) invokeLLL.objValue;
    }

    @Override // androidx.media2.session.MediaSessionImplBase
    public void dispatchRemoteControllerTaskWithoutReturn(@NonNull MediaSessionImplBase.RemoteControllerTask remoteControllerTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, remoteControllerTask) == null) {
            super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
            MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
            if (legacyBrowserService != null) {
                try {
                    remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
                } catch (RemoteException e) {
                    Log.e(MediaSessionImplBase.TAG, "Exception in using media1 API", e);
                }
            }
        }
    }

    public void dumpSubscription() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && MediaSessionImplBase.DEBUG) {
            synchronized (this.mLock) {
                Log.d(MediaSessionImplBase.TAG, "Dumping subscription, controller sz=" + this.mSubscriptions.size());
                for (int i = 0; i < this.mSubscriptions.size(); i++) {
                    Log.d(MediaSessionImplBase.TAG, "  controller " + this.mSubscriptions.valueAt(i));
                    Iterator<String> it = this.mSubscriptions.valueAt(i).iterator();
                    while (it.hasNext()) {
                        Log.d(MediaSessionImplBase.TAG, "  - " + it.next());
                    }
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
            MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
            if (legacyBrowserService != null) {
                connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
            }
            return connectedControllers;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(@NonNull MediaSession.ControllerInfo controllerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, controllerInfo)) == null) {
            if (super.isConnected(controllerInfo)) {
                return true;
            }
            MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
            if (legacyBrowserService != null) {
                return legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, controllerCb, str)) == null) {
            synchronized (this.mLock) {
                Set<String> set = this.mSubscriptions.get(controllerCb);
                if (set != null && set.contains(str)) {
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, str, i, libraryParams) == null) {
            dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImplBase.RemoteControllerTask(this, str, i, libraryParams) { // from class: androidx.media2.session.MediaLibrarySessionImplBase.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibrarySessionImplBase this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i), libraryParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$parentId = str;
                    this.val$itemCount = i;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) && this.this$0.isSubscribed(controllerCb, this.val$parentId)) {
                        controllerCb.onChildrenChanged(i2, this.val$parentId, this.val$itemCount, this.val$params);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048590, this, controllerInfo, str, i, libraryParams) == null) {
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask(this, str, i, libraryParams) { // from class: androidx.media2.session.MediaLibrarySessionImplBase.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibrarySessionImplBase this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i), libraryParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$query = str;
                    this.val$itemCount = i;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                        controllerCb.onSearchResultChanged(i2, this.val$query, this.val$itemCount, this.val$params);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetChildrenOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{controllerInfo, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) ? ensureNonNullResultWithValidList(getCallback().onGetChildren(getInstance(), controllerInfo, str, i, i2, libraryParams), i2) : (LibraryResult) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetItemOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, controllerInfo, str)) == null) ? ensureNonNullResultWithValidItem(getCallback().onGetItem(getInstance(), controllerInfo, str)) : (LibraryResult) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetLibraryRootOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, controllerInfo, libraryParams)) == null) ? ensureNonNullResultWithValidItem(getCallback().onGetLibraryRoot(getInstance(), controllerInfo, libraryParams)) : (LibraryResult) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public LibraryResult onGetSearchResultOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{controllerInfo, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) ? ensureNonNullResultWithValidList(getCallback().onGetSearchResult(getInstance(), controllerInfo, str, i, i2, libraryParams), i2) : (LibraryResult) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSearchOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, controllerInfo, str, libraryParams)) == null) ? getCallback().onSearch(getInstance(), controllerInfo, str, libraryParams) : invokeLLL.intValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onSubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, controllerInfo, str, libraryParams)) == null) {
            synchronized (this.mLock) {
                Set<String> set = this.mSubscriptions.get(controllerInfo.getControllerCb());
                if (set == null) {
                    set = new HashSet<>();
                    this.mSubscriptions.put(controllerInfo.getControllerCb(), set);
                }
                set.add(str);
            }
            int onSubscribe = getCallback().onSubscribe(getInstance(), controllerInfo, str, libraryParams);
            if (onSubscribe != 0) {
                synchronized (this.mLock) {
                    this.mSubscriptions.remove(controllerInfo.getControllerCb());
                }
            }
            return onSubscribe;
        }
        return invokeLLL.intValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public int onUnsubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, controllerInfo, str)) == null) {
            int onUnsubscribe = getCallback().onUnsubscribe(getInstance(), controllerInfo, str);
            synchronized (this.mLock) {
                this.mSubscriptions.remove(controllerInfo.getControllerCb());
            }
            return onUnsubscribe;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback) super.getCallback() : (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaSessionImplBase, androidx.media2.session.MediaSession.MediaSessionImpl
    @NonNull
    public MediaLibraryService.MediaLibrarySession getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (MediaLibraryService.MediaLibrarySession) super.getInstance() : (MediaLibraryService.MediaLibrarySession) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaSessionImplBase
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService() : (MediaLibraryServiceLegacyStub) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl
    public void notifyChildrenChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048588, this, controllerInfo, str, i, libraryParams) == null) {
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImplBase.RemoteControllerTask(this, str, controllerInfo, i, libraryParams) { // from class: androidx.media2.session.MediaLibrarySessionImplBase.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibrarySessionImplBase this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, controllerInfo, Integer.valueOf(i), libraryParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$parentId = str;
                    this.val$controller = controllerInfo;
                    this.val$itemCount = i;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                        if (!this.this$0.isSubscribed(controllerCb, this.val$parentId)) {
                            if (MediaSessionImplBase.DEBUG) {
                                Log.d(MediaSessionImplBase.TAG, "Skipping notifyChildrenChanged() to " + this.val$controller + " because it hasn't subscribed");
                                this.this$0.dumpSubscription();
                                return;
                            }
                            return;
                        }
                        controllerCb.onChildrenChanged(i2, this.val$parentId, this.val$itemCount, this.val$params);
                    }
                }
            });
        }
    }
}
