package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.MediaBrowser;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SequencedFutureManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
/* loaded from: classes.dex */
public class MediaBrowserImplBase extends MediaControllerImplBase implements MediaBrowser.MediaBrowserImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final LibraryResult RESULT_WHEN_CLOSED;
    public transient /* synthetic */ FieldHolder $fh;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteLibrarySessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1438452806, "Landroidx/media2/session/MediaBrowserImplBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1438452806, "Landroidx/media2/session/MediaBrowserImplBase;");
                return;
            }
        }
        RESULT_WHEN_CLOSED = new LibraryResult(1);
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (MediaBrowser) this.mInstance;
        }
        return (MediaBrowser) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        super(context, mediaController, sessionToken, bundle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaController, sessionToken, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (MediaController) objArr2[1], (SessionToken) objArr2[2], (Bundle) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private ListenableFuture<LibraryResult> dispatchRemoteLibrarySessionTask(int i, RemoteLibrarySessionTask remoteLibrarySessionTask) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i, remoteLibrarySessionTask)) == null) {
            IMediaSession sessionInterfaceIfAble = getSessionInterfaceIfAble(i);
            if (sessionInterfaceIfAble != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                try {
                    remoteLibrarySessionTask.run(sessionInterfaceIfAble, createSequencedFuture.getSequenceNumber());
                } catch (RemoteException e) {
                    Log.w(MediaControllerImplBase.TAG, "Cannot connect to the service or the session is gone", e);
                    createSequencedFuture.set(new LibraryResult(-100));
                }
                return createSequencedFuture;
            }
            return LibraryResult.createFutureWithResult(-4);
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, new RemoteLibrarySessionTask(this, str, i, i2, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ int val$page;
                public final /* synthetic */ int val$pageSize;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$parentId = str;
                    this.val$page = i;
                    this.val$pageSize = i2;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i3) == null) {
                        iMediaSession.getChildren(this.this$0.mControllerStub, i3, this.val$parentId, this.val$page, this.val$pageSize, MediaParcelUtils.toParcelable(this.val$params));
                    }
                }
            });
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new RemoteLibrarySessionTask(this, str, i, i2, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ int val$page;
                public final /* synthetic */ int val$pageSize;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$query = str;
                    this.val$page = i;
                    this.val$pageSize = i2;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i3) == null) {
                        iMediaSession.getSearchResult(this.this$0.mControllerStub, i3, this.val$query, this.val$page, this.val$pageSize, MediaParcelUtils.toParcelable(this.val$params));
                    }
                }
            });
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new RemoteLibrarySessionTask(this, str) { // from class: androidx.media2.session.MediaBrowserImplBase.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ String val$mediaId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$mediaId = str;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                        iMediaSession.getItem(this.this$0.mControllerStub, i, this.val$mediaId);
                    }
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getLibraryRoot(MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, libraryParams)) == null) {
            return dispatchRemoteLibrarySessionTask(50000, new RemoteLibrarySessionTask(this, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, libraryParams};
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
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                        iMediaSession.getLibraryRoot(this.this$0.mControllerStub, i, MediaParcelUtils.toParcelable(this.val$params));
                    }
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> unsubscribe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, new RemoteLibrarySessionTask(this, str) { // from class: androidx.media2.session.MediaBrowserImplBase.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$parentId = str;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                        iMediaSession.unsubscribe(this.this$0.mControllerStub, i, this.val$parentId);
                    }
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public void notifyChildrenChanged(String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, str, i, libraryParams) == null) {
            getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable(this, str, i, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$libraryParams;
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
                    this.val$libraryParams = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, browserCallback) == null) {
                        browserCallback.onChildrenChanged(this.this$0.getMediaBrowser(), this.val$parentId, this.val$itemCount, this.val$libraryParams);
                    }
                }
            });
        }
    }

    public void notifySearchResultChanged(String str, int i, MediaLibraryService.LibraryParams libraryParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i, libraryParams) == null) {
            getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable(this, str, i, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$libraryParams;
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
                    this.val$libraryParams = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, browserCallback) == null) {
                        browserCallback.onSearchResultChanged(this.this$0.getMediaBrowser(), this.val$query, this.val$itemCount, this.val$libraryParams);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> search(String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, libraryParams)) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, new RemoteLibrarySessionTask(this, str, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, libraryParams};
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
                    this.val$query = str;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                        iMediaSession.search(this.this$0.mControllerStub, i, this.val$query, MediaParcelUtils.toParcelable(this.val$params));
                    }
                }
            });
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> subscribe(String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, libraryParams)) == null) {
            return dispatchRemoteLibrarySessionTask(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, new RemoteLibrarySessionTask(this, str, libraryParams) { // from class: androidx.media2.session.MediaBrowserImplBase.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplBase this$0;
                public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, libraryParams};
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
                    this.val$parentId = str;
                    this.val$params = libraryParams;
                }

                @Override // androidx.media2.session.MediaBrowserImplBase.RemoteLibrarySessionTask
                public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                        iMediaSession.subscribe(this.this$0.mControllerStub, i, this.val$parentId, MediaParcelUtils.toParcelable(this.val$params));
                    }
                }
            });
        }
        return (ListenableFuture) invokeLL.objValue;
    }
}
