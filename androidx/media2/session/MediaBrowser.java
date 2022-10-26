package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaBrowser extends MediaController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "MediaBrowser";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface BrowserCallbackRunnable {
        void run(BrowserCallback browserCallback);
    }

    /* loaded from: classes.dex */
    public interface MediaBrowserImpl extends MediaController.MediaControllerImpl {
        ListenableFuture getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture getItem(String str);

        ListenableFuture getLibraryRoot(MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture search(String str, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture subscribe(String str, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture unsubscribe(String str);
    }

    /* loaded from: classes.dex */
    public static class BrowserCallback extends MediaController.ControllerCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onChildrenChanged(MediaBrowser mediaBrowser, String str, int i, MediaLibraryService.LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048576, this, mediaBrowser, str, i, libraryParams) == null) {
            }
        }

        public void onSearchResultChanged(MediaBrowser mediaBrowser, String str, int i, MediaLibraryService.LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaBrowser, str, i, libraryParams) == null) {
            }
        }

        public BrowserCallback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends MediaController.BuilderBase<MediaBrowser, Builder, BrowserCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        public MediaBrowser build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mToken == null && this.mCompatToken == null) {
                    throw new IllegalArgumentException("token and compat token shouldn't be both null");
                }
                if (this.mToken != null) {
                    return new MediaBrowser(this.mContext, this.mToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback);
                }
                return new MediaBrowser(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback);
            }
            return (MediaBrowser) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        public Builder setConnectionHints(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                return (Builder) super.setConnectionHints(bundle);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        public Builder setSessionCompatToken(MediaSessionCompat.Token token) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, token)) == null) {
                return (Builder) super.setSessionCompatToken(token);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        public Builder setSessionToken(SessionToken sessionToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sessionToken)) == null) {
                return (Builder) super.setSessionToken(sessionToken);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.session.MediaController.BuilderBase
        public Builder setControllerCallback(Executor executor, BrowserCallback browserCallback) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, executor, browserCallback)) == null) {
                return (Builder) super.setControllerCallback(executor, (Executor) browserCallback);
            }
            return (Builder) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(262861655, "Landroidx/media2/session/MediaBrowser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(262861655, "Landroidx/media2/session/MediaBrowser;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public static ListenableFuture<LibraryResult> createDisconnectedFuture() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        return (ListenableFuture) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl getImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (MediaBrowserImpl) super.getImpl();
        }
        return (MediaBrowserImpl) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowser(Context context, MediaSessionCompat.Token token, Bundle bundle, Executor executor, BrowserCallback browserCallback) {
        super(context, token, bundle, executor, browserCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, token, bundle, executor, browserCallback};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (MediaSessionCompat.Token) objArr2[1], (Bundle) objArr2[2], (Executor) objArr2[3], (MediaController.ControllerCallback) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowser(Context context, SessionToken sessionToken, Bundle bundle, Executor executor, BrowserCallback browserCallback) {
        super(context, sessionToken, bundle, executor, browserCallback);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sessionToken, bundle, executor, browserCallback};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (SessionToken) objArr2[1], (Bundle) objArr2[2], (Executor) objArr2[3], (MediaController.ControllerCallback) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl createImpl(Context context, SessionToken sessionToken, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, sessionToken, bundle)) == null) {
            if (sessionToken.isLegacySession()) {
                return new MediaBrowserImplLegacy(context, this, sessionToken);
            }
            return new MediaBrowserImplBase(context, this, sessionToken, bundle);
        }
        return (MediaBrowserImpl) invokeLLL.objValue;
    }

    public ListenableFuture<LibraryResult> getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (i >= 0) {
                    if (i2 >= 1) {
                        if (isConnected()) {
                            return getImpl().getChildren(str, i, i2, libraryParams);
                        }
                        return createDisconnectedFuture();
                    }
                    throw new IllegalArgumentException("pageSize shouldn't be less than 1");
                }
                throw new IllegalArgumentException("page shouldn't be negative");
            }
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    public ListenableFuture<LibraryResult> getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (i >= 0) {
                    if (i2 >= 1) {
                        if (isConnected()) {
                            return getImpl().getSearchResult(str, i, i2, libraryParams);
                        }
                        return createDisconnectedFuture();
                    }
                    throw new IllegalArgumentException("pageSize shouldn't be less than 1");
                }
                throw new IllegalArgumentException("page shouldn't be negative");
            }
            throw new IllegalArgumentException("query shouldn't be empty");
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    public ListenableFuture<LibraryResult> getItem(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (isConnected()) {
                    return getImpl().getItem(str);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("mediaId shouldn't be empty");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public ListenableFuture<LibraryResult> unsubscribe(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (isConnected()) {
                    return getImpl().unsubscribe(str);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public ListenableFuture<LibraryResult> getLibraryRoot(MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, libraryParams)) == null) {
            if (isConnected()) {
                return getImpl().getLibraryRoot(libraryParams);
            }
            return createDisconnectedFuture();
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public void notifyBrowserCallback(BrowserCallbackRunnable browserCallbackRunnable) {
        Executor executor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, browserCallbackRunnable) == null) && this.mPrimaryCallback != null && (executor = this.mPrimaryCallbackExecutor) != null) {
            executor.execute(new Runnable(this, browserCallbackRunnable) { // from class: androidx.media2.session.MediaBrowser.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowser this$0;
                public final /* synthetic */ BrowserCallbackRunnable val$callbackRunnable;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, browserCallbackRunnable};
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
                    this.val$callbackRunnable = browserCallbackRunnable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.val$callbackRunnable.run((BrowserCallback) this.this$0.mPrimaryCallback);
                    }
                }
            });
        }
    }

    public ListenableFuture<LibraryResult> search(String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, libraryParams)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (isConnected()) {
                    return getImpl().search(str, libraryParams);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("query shouldn't be empty");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public ListenableFuture<LibraryResult> subscribe(String str, MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, libraryParams)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (isConnected()) {
                    return getImpl().subscribe(str, libraryParams);
                }
                return createDisconnectedFuture();
            }
            throw new IllegalArgumentException("parentId shouldn't be empty");
        }
        return (ListenableFuture) invokeLL.objValue;
    }
}
