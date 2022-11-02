package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.SessionPlayer;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class MediaLibraryService extends MediaSessionService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SERVICE_INTERFACE = "androidx.media2.session.MediaLibraryService";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaSessionService
    @Nullable
    public abstract MediaLibrarySession onGetSession(@NonNull MediaSession.ControllerInfo controllerInfo);

    /* loaded from: classes.dex */
    public static final class LibraryParams implements VersionedParcelable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Bundle mBundle;
        public int mOffline;
        public int mRecent;
        public int mSuggested;

        public static boolean convertToBoolean(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i != 0 : invokeI.booleanValue;
        }

        public static int convertToInteger(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) ? z ? 1 : 0 : invokeZ.intValue;
        }

        /* loaded from: classes.dex */
        public static final class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Bundle mBundle;
            public boolean mOffline;
            public boolean mRecent;
            public boolean mSuggested;

            public Builder() {
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

            @NonNull
            public LibraryParams build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new LibraryParams(this.mBundle, this.mRecent, this.mOffline, this.mSuggested);
                }
                return (LibraryParams) invokeV.objValue;
            }

            @NonNull
            public Builder setExtras(@Nullable Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                    this.mBundle = bundle;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setOffline(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                    this.mOffline = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setRecent(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                    this.mRecent = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setSuggested(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                    this.mSuggested = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }
        }

        public LibraryParams() {
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

        @Nullable
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mBundle;
            }
            return (Bundle) invokeV.objValue;
        }

        public boolean isOffline() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return convertToBoolean(this.mOffline);
            }
            return invokeV.booleanValue;
        }

        public boolean isRecent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return convertToBoolean(this.mRecent);
            }
            return invokeV.booleanValue;
        }

        public boolean isSuggested() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return convertToBoolean(this.mSuggested);
            }
            return invokeV.booleanValue;
        }

        public LibraryParams(Bundle bundle, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mBundle = bundle;
            this.mRecent = i;
            this.mOffline = i2;
            this.mSuggested = i3;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LibraryParams(Bundle bundle, boolean z, boolean z2, boolean z3) {
            this(bundle, convertToInteger(z), convertToInteger(z2), convertToInteger(z3));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Bundle) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class MediaLibrarySession extends MediaSession {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public interface MediaLibrarySessionImpl extends MediaSession.MediaSessionImpl {
            @Override // androidx.media2.session.MediaSession.MediaSessionImpl
            MediaLibrarySessionCallback getCallback();

            @Override // androidx.media2.session.MediaSession.MediaSessionImpl
            /* bridge */ /* synthetic */ MediaSession.SessionCallback getCallback();

            @Override // androidx.media2.session.MediaSession.MediaSessionImpl
            MediaLibrarySession getInstance();

            @Override // androidx.media2.session.MediaSession.MediaSessionImpl
            /* bridge */ /* synthetic */ MediaSession getInstance();

            void notifyChildrenChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, @Nullable LibraryParams libraryParams);

            void notifyChildrenChanged(@NonNull String str, int i, @Nullable LibraryParams libraryParams);

            void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, @Nullable LibraryParams libraryParams);

            LibraryResult onGetChildrenOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, @Nullable LibraryParams libraryParams);

            LibraryResult onGetItemOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str);

            LibraryResult onGetLibraryRootOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @Nullable LibraryParams libraryParams);

            LibraryResult onGetSearchResultOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, int i, int i2, @Nullable LibraryParams libraryParams);

            int onSearchOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @Nullable LibraryParams libraryParams);

            int onSubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @Nullable LibraryParams libraryParams);

            int onUnsubscribeOnExecutor(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str);
        }

        /* loaded from: classes.dex */
        public static final class Builder extends MediaSession.BuilderBase<MediaLibrarySession, Builder, MediaLibrarySessionCallback> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Builder(@NonNull MediaLibraryService mediaLibraryService, @NonNull SessionPlayer sessionPlayer, @NonNull Executor executor, @NonNull MediaLibrarySessionCallback mediaLibrarySessionCallback) {
                super(mediaLibraryService, sessionPlayer);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaLibraryService, sessionPlayer, executor, mediaLibrarySessionCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Context) objArr2[0], (SessionPlayer) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                setSessionCallback(executor, mediaLibrarySessionCallback);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSession.BuilderBase
            @NonNull
            public MediaLibrarySession build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    if (this.mCallbackExecutor == null) {
                        this.mCallbackExecutor = ContextCompat.getMainExecutor(this.mContext);
                    }
                    if (this.mCallback == 0) {
                        this.mCallback = new MediaLibrarySessionCallback(this) { // from class: androidx.media2.session.MediaLibraryService.MediaLibrarySession.Builder.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Builder this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
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
                            }
                        };
                    }
                    return new MediaLibrarySession(this.mContext, this.mId, this.mPlayer, this.mSessionActivity, this.mCallbackExecutor, this.mCallback, this.mExtras);
                }
                return (MediaLibrarySession) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSession.BuilderBase
            @NonNull
            public Builder setExtras(@NonNull Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                    return (Builder) super.setExtras(bundle);
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSession.BuilderBase
            @NonNull
            public Builder setId(@NonNull String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    return (Builder) super.setId(str);
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSession.BuilderBase
            @NonNull
            public Builder setSessionActivity(@Nullable PendingIntent pendingIntent) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pendingIntent)) == null) {
                    return (Builder) super.setSessionActivity(pendingIntent);
                }
                return (Builder) invokeL.objValue;
            }
        }

        /* loaded from: classes.dex */
        public static class MediaLibrarySessionCallback extends MediaSession.SessionCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public int onSearch(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @Nullable LibraryParams libraryParams) {
                InterceptResult invokeLLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, mediaLibrarySession, controllerInfo, str, libraryParams)) == null) {
                    return -6;
                }
                return invokeLLLL.intValue;
            }

            public int onSubscribe(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @Nullable LibraryParams libraryParams) {
                InterceptResult invokeLLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, mediaLibrarySession, controllerInfo, str, libraryParams)) == null) {
                    return -6;
                }
                return invokeLLLL.intValue;
            }

            public int onUnsubscribe(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, mediaLibrarySession, controllerInfo, str)) == null) {
                    return -6;
                }
                return invokeLLL.intValue;
            }

            public MediaLibrarySessionCallback() {
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

            @NonNull
            public LibraryResult onGetChildren(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable LibraryParams libraryParams) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{mediaLibrarySession, controllerInfo, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
                    return new LibraryResult(-6);
                }
                return (LibraryResult) invokeCommon.objValue;
            }

            @NonNull
            public LibraryResult onGetSearchResult(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable LibraryParams libraryParams) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{mediaLibrarySession, controllerInfo, str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
                    return new LibraryResult(-6);
                }
                return (LibraryResult) invokeCommon.objValue;
            }

            @NonNull
            public LibraryResult onGetItem(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaLibrarySession, controllerInfo, str)) == null) {
                    return new LibraryResult(-6);
                }
                return (LibraryResult) invokeLLL.objValue;
            }

            @NonNull
            public LibraryResult onGetLibraryRoot(@NonNull MediaLibrarySession mediaLibrarySession, @NonNull MediaSession.ControllerInfo controllerInfo, @Nullable LibraryParams libraryParams) {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaLibrarySession, controllerInfo, libraryParams)) == null) {
                    return new LibraryResult(-6);
                }
                return (LibraryResult) invokeLLL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaLibrarySession(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
            super(context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SessionPlayer) objArr2[2], (PendingIntent) objArr2[3], (Executor) objArr2[4], (MediaSession.SessionCallback) objArr2[5], (Bundle) objArr2[6]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.session.MediaSession
        public MediaLibrarySessionImpl createImpl(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle})) == null) {
                return new MediaLibrarySessionImplBase(this, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
            }
            return (MediaLibrarySessionImpl) invokeCommon.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.session.MediaSession
        @NonNull
        public MediaLibrarySessionCallback getCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return (MediaLibrarySessionCallback) super.getCallback();
            }
            return (MediaLibrarySessionCallback) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.session.MediaSession
        public MediaLibrarySessionImpl getImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return (MediaLibrarySessionImpl) super.getImpl();
            }
            return (MediaLibrarySessionImpl) invokeV.objValue;
        }

        public void notifyChildrenChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @IntRange(from = 0) int i, @Nullable LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(1048582, this, controllerInfo, str, i, libraryParams) == null) {
                if (controllerInfo != null) {
                    if (str != null) {
                        if (!TextUtils.isEmpty(str)) {
                            if (i >= 0) {
                                getImpl().notifyChildrenChanged(controllerInfo, str, i, libraryParams);
                                return;
                            }
                            throw new IllegalArgumentException("itemCount shouldn't be negative");
                        }
                        throw new IllegalArgumentException("parentId shouldn't be empty");
                    }
                    throw new NullPointerException("parentId shouldn't be null");
                }
                throw new NullPointerException("controller shouldn't be null");
            }
        }

        public void notifySearchResultChanged(@NonNull MediaSession.ControllerInfo controllerInfo, @NonNull String str, @IntRange(from = 0) int i, @Nullable LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, controllerInfo, str, i, libraryParams) == null) {
                if (controllerInfo != null) {
                    if (str != null) {
                        if (!TextUtils.isEmpty(str)) {
                            if (i >= 0) {
                                getImpl().notifySearchResultChanged(controllerInfo, str, i, libraryParams);
                                return;
                            }
                            throw new IllegalArgumentException("itemCount shouldn't be negative");
                        }
                        throw new IllegalArgumentException("query shouldn't be empty");
                    }
                    throw new NullPointerException("query shouldn't be null");
                }
                throw new NullPointerException("controller shouldn't be null");
            }
        }

        public void notifyChildrenChanged(@NonNull String str, int i, @Nullable LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048583, this, str, i, libraryParams) == null) {
                if (!TextUtils.isEmpty(str)) {
                    if (i >= 0) {
                        getImpl().notifyChildrenChanged(str, i, libraryParams);
                        return;
                    }
                    throw new IllegalArgumentException("itemCount shouldn't be negative");
                }
                throw new IllegalArgumentException("parentId shouldn't be empty");
            }
        }
    }

    public MediaLibraryService() {
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

    @Override // androidx.media2.session.MediaSessionService
    public MediaSessionService.MediaSessionServiceImpl createImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new MediaLibraryServiceImplBase();
        }
        return (MediaSessionService.MediaSessionServiceImpl) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSessionService, android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return super.onBind(intent);
        }
        return (IBinder) invokeL.objValue;
    }
}
