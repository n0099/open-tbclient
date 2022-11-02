package androidx.media2.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaInterface;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaSession implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    @GuardedBy("STATIC_LOCK")
    public static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP;
    public static final Object STATIC_LOCK;
    public static final String TAG = "MediaSession";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaSessionImpl mImpl;

    /* loaded from: classes.dex */
    public interface MediaSessionImpl extends MediaInterface.SessionPlayer, Closeable {
        void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void connectFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle);

        PlaybackStateCompat createPlaybackStateCompat();

        SessionCallback getCallback();

        Executor getCallbackExecutor();

        @NonNull
        List<ControllerInfo> getConnectedControllers();

        Context getContext();

        @NonNull
        String getId();

        MediaSession getInstance();

        IBinder getLegacyBrowserServiceBinder();

        MediaController.PlaybackInfo getPlaybackInfo();

        @NonNull
        SessionPlayer getPlayer();

        PendingIntent getSessionActivity();

        MediaSessionCompat getSessionCompat();

        @NonNull
        SessionToken getToken();

        @NonNull
        Uri getUri();

        boolean isClosed();

        boolean isConnected(@NonNull ControllerInfo controllerInfo);

        ListenableFuture<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle);

        void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup);

        ListenableFuture<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list);

        void setLegacyControllerConnectionTimeoutMs(long j);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer);

        void updatePlayer(@NonNull SessionPlayer sessionPlayer, @Nullable SessionPlayer sessionPlayer2);
    }

    /* loaded from: classes.dex */
    public static final class CommandButton implements VersionedParcelable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SessionCommand mCommand;
        public CharSequence mDisplayName;
        public boolean mEnabled;
        public Bundle mExtras;
        public int mIconResId;

        /* loaded from: classes.dex */
        public static final class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public SessionCommand mCommand;
            public CharSequence mDisplayName;
            public boolean mEnabled;
            public Bundle mExtras;
            public int mIconResId;

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
            public CommandButton build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new CommandButton(this.mCommand, this.mIconResId, this.mDisplayName, this.mExtras, this.mEnabled);
                }
                return (CommandButton) invokeV.objValue;
            }

            @NonNull
            public Builder setCommand(@Nullable SessionCommand sessionCommand) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionCommand)) == null) {
                    this.mCommand = sessionCommand;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setDisplayName(@Nullable CharSequence charSequence) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence)) == null) {
                    this.mDisplayName = charSequence;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setEnabled(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                    this.mEnabled = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            @NonNull
            public Builder setExtras(@Nullable Bundle bundle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bundle)) == null) {
                    this.mExtras = bundle;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            @NonNull
            public Builder setIconResId(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                    this.mIconResId = i;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }
        }

        public CommandButton() {
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
        public SessionCommand getCommand() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCommand;
            }
            return (SessionCommand) invokeV.objValue;
        }

        @Nullable
        public CharSequence getDisplayName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDisplayName;
            }
            return (CharSequence) invokeV.objValue;
        }

        @Nullable
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mExtras;
            }
            return (Bundle) invokeV.objValue;
        }

        public int getIconResId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mIconResId;
            }
            return invokeV.intValue;
        }

        public boolean isEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mEnabled;
            }
            return invokeV.booleanValue;
        }

        public CommandButton(@Nullable SessionCommand sessionCommand, int i, @Nullable CharSequence charSequence, Bundle bundle, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sessionCommand, Integer.valueOf(i), charSequence, bundle, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCommand = sessionCommand;
            this.mIconResId = i;
            this.mDisplayName = charSequence;
            this.mExtras = bundle;
            this.mEnabled = z;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SessionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ForegroundServiceEventCallback mForegroundServiceEventCallback;

        public int onCommandRequest(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, mediaSession, controllerInfo, sessionCommand)) == null) {
                return 0;
            }
            return invokeLLL.intValue;
        }

        @Nullable
        public MediaItem onCreateMediaItem(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mediaSession, controllerInfo, str)) == null) {
                return null;
            }
            return (MediaItem) invokeLLL.objValue;
        }

        public void onDisconnected(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, mediaSession, controllerInfo) == null) {
            }
        }

        public int onFastForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, mediaSession, controllerInfo)) == null) {
                return -6;
            }
            return invokeLL.intValue;
        }

        public void onPostConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, mediaSession, controllerInfo) == null) {
            }
        }

        public int onRewind(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSession, controllerInfo)) == null) {
                return -6;
            }
            return invokeLL.intValue;
        }

        public int onSetMediaUri(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull Uri uri, @Nullable Bundle bundle) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, mediaSession, controllerInfo, uri, bundle)) == null) {
                return -6;
            }
            return invokeLLLL.intValue;
        }

        public int onSetRating(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull String str, @NonNull Rating rating) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, mediaSession, controllerInfo, str, rating)) == null) {
                return -6;
            }
            return invokeLLLL.intValue;
        }

        public int onSkipBackward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, mediaSession, controllerInfo)) == null) {
                return -6;
            }
            return invokeLL.intValue;
        }

        public int onSkipForward(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, mediaSession, controllerInfo)) == null) {
                return -6;
            }
            return invokeLL.intValue;
        }

        /* loaded from: classes.dex */
        public static abstract class ForegroundServiceEventCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public void onPlayerStateChanged(MediaSession mediaSession, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, mediaSession, i) == null) {
                }
            }

            public void onSessionClosed(MediaSession mediaSession) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSession) == null) {
                }
            }

            public ForegroundServiceEventCallback() {
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

        public SessionCallback() {
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
        public SessionCommandGroup onConnect(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaSession, controllerInfo)) == null) {
                return new SessionCommandGroup.Builder().addAllPredefinedCommands(2).build();
            }
            return (SessionCommandGroup) invokeLL.objValue;
        }

        public final void onPlayerStateChanged(MediaSession mediaSession, int i) {
            ForegroundServiceEventCallback foregroundServiceEventCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048582, this, mediaSession, i) == null) && (foregroundServiceEventCallback = this.mForegroundServiceEventCallback) != null) {
                foregroundServiceEventCallback.onPlayerStateChanged(mediaSession, i);
            }
        }

        @NonNull
        public SessionResult onCustomCommand(@NonNull MediaSession mediaSession, @NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, mediaSession, controllerInfo, sessionCommand, bundle)) == null) {
                return new SessionResult(-6, null);
            }
            return (SessionResult) invokeLLLL.objValue;
        }

        public final void onSessionClosed(MediaSession mediaSession) {
            ForegroundServiceEventCallback foregroundServiceEventCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048585, this, mediaSession) == null) && (foregroundServiceEventCallback = this.mForegroundServiceEventCallback) != null) {
                foregroundServiceEventCallback.onSessionClosed(mediaSession);
            }
        }

        public void setForegroundServiceEventCallback(ForegroundServiceEventCallback foregroundServiceEventCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, foregroundServiceEventCallback) == null) {
                this.mForegroundServiceEventCallback = foregroundServiceEventCallback;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends BuilderBase<MediaSession, Builder, SessionCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            super(context, sessionPlayer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, sessionPlayer};
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
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [C extends androidx.media2.session.MediaSession$SessionCallback, androidx.media2.session.MediaSession$Builder$1] */
        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public MediaSession build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mCallbackExecutor == null) {
                    this.mCallbackExecutor = ContextCompat.getMainExecutor(this.mContext);
                }
                if (this.mCallback == 0) {
                    this.mCallback = new SessionCallback(this) { // from class: androidx.media2.session.MediaSession.Builder.1
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
                return new MediaSession(this.mContext, this.mId, this.mPlayer, this.mSessionActivity, this.mCallbackExecutor, this.mCallback, this.mExtras);
            }
            return (MediaSession) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setExtras(@NonNull Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pendingIntent)) == null) {
                return (Builder) super.setSessionActivity(pendingIntent);
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaSession.BuilderBase
        @NonNull
        public Builder setSessionCallback(@NonNull Executor executor, @NonNull SessionCallback sessionCallback) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, executor, sessionCallback)) == null) {
                return (Builder) super.setSessionCallback(executor, (Executor) sessionCallback);
            }
            return (Builder) invokeLL.objValue;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static abstract class BuilderBase<T extends MediaSession, U extends BuilderBase<T, U, C>, C extends SessionCallback> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public C mCallback;
        public Executor mCallbackExecutor;
        public final Context mContext;
        public Bundle mExtras;
        public String mId;
        public SessionPlayer mPlayer;
        public PendingIntent mSessionActivity;

        @NonNull
        public abstract T build();

        public BuilderBase(@NonNull Context context, @NonNull SessionPlayer sessionPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, sessionPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (context != null) {
                if (sessionPlayer != null) {
                    this.mContext = context;
                    this.mPlayer = sessionPlayer;
                    this.mId = "";
                    return;
                }
                throw new NullPointerException("player shouldn't be null");
            }
            throw new NullPointerException("context shouldn't be null");
        }

        @NonNull
        public U setExtras(@NonNull Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                if (bundle != null) {
                    if (!MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                        this.mExtras = new Bundle(bundle);
                        return this;
                    }
                    throw new IllegalArgumentException("extras shouldn't contain any custom parcelables");
                }
                throw new NullPointerException("extras shouldn't be null");
            }
            return (U) invokeL.objValue;
        }

        @NonNull
        public U setId(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null) {
                    this.mId = str;
                    return this;
                }
                throw new NullPointerException("id shouldn't be null");
            }
            return (U) invokeL.objValue;
        }

        @NonNull
        public U setSessionActivity(@Nullable PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pendingIntent)) == null) {
                this.mSessionActivity = pendingIntent;
                return this;
            }
            return (U) invokeL.objValue;
        }

        @NonNull
        public U setSessionCallback(@NonNull Executor executor, @NonNull C c) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, executor, c)) == null) {
                if (executor != null) {
                    if (c != null) {
                        this.mCallbackExecutor = executor;
                        this.mCallback = c;
                        return this;
                    }
                    throw new NullPointerException("callback shouldn't be null");
                }
                throw new NullPointerException("executor shouldn't be null");
            }
            return (U) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ControllerCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException;

        public abstract void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException;

        public abstract void onChildrenChanged(int i, @NonNull String str, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        public abstract void onCurrentMediaItemChanged(int i, @Nullable MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException;

        public abstract void onDisconnected(int i) throws RemoteException;

        public abstract void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException;

        public abstract void onPlaybackCompleted(int i) throws RemoteException;

        public abstract void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException;

        public abstract void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException;

        public abstract void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException;

        public abstract void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException;

        public abstract void onPlaylistChanged(int i, @NonNull List<MediaItem> list, @Nullable MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException;

        public abstract void onPlaylistMetadataChanged(int i, @Nullable MediaMetadata mediaMetadata) throws RemoteException;

        public abstract void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

        public abstract void onSearchResultChanged(int i, @NonNull String str, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) throws RemoteException;

        public abstract void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException;

        public abstract void onSessionResult(int i, SessionResult sessionResult) throws RemoteException;

        public abstract void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

        public abstract void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) throws RemoteException;

        public abstract void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException;

        public abstract void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException;

        public abstract void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException;

        public abstract void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException;

        public abstract void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) throws RemoteException;

        public abstract void setCustomLayout(int i, @NonNull List<CommandButton> list) throws RemoteException;

        public ControllerCb() {
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
    public static final class ControllerInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mConnectionHints;
        public final ControllerCb mControllerCb;
        public final int mControllerVersion;
        public final boolean mIsTrusted;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;

        public ControllerInfo(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, boolean z, @Nullable ControllerCb controllerCb, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {remoteUserInfo, Integer.valueOf(i), Boolean.valueOf(z), controllerCb, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRemoteUserInfo = remoteUserInfo;
            this.mControllerVersion = i;
            this.mIsTrusted = z;
            this.mControllerCb = controllerCb;
            if (bundle != null && !MediaUtils.doesBundleHaveCustomParcelable(bundle)) {
                this.mConnectionHints = bundle;
            } else {
                this.mConnectionHints = null;
            }
        }

        @NonNull
        public static ControllerInfo createLegacyControllerInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1), -1, false, null, null);
            }
            return (ControllerInfo) invokeV.objValue;
        }

        @NonNull
        public Bundle getConnectionHints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mConnectionHints == null) {
                    return Bundle.EMPTY;
                }
                return new Bundle(this.mConnectionHints);
            }
            return (Bundle) invokeV.objValue;
        }

        @Nullable
        public ControllerCb getControllerCb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mControllerCb;
            }
            return (ControllerCb) invokeV.objValue;
        }

        @NonNull
        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mRemoteUserInfo.getPackageName();
            }
            return (String) invokeV.objValue;
        }

        public MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mRemoteUserInfo;
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        public int getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mRemoteUserInfo.getUid();
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return ObjectsCompat.hash(this.mControllerCb, this.mRemoteUserInfo);
            }
            return invokeV.intValue;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public boolean isTrusted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mIsTrusted;
            }
            return invokeV.booleanValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!(obj instanceof ControllerInfo)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                ControllerInfo controllerInfo = (ControllerInfo) obj;
                if (this.mControllerCb == null && controllerInfo.mControllerCb == null) {
                    return this.mRemoteUserInfo.equals(controllerInfo.mRemoteUserInfo);
                }
                return ObjectsCompat.equals(this.mControllerCb, controllerInfo.mControllerCb);
            }
            return invokeL.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return "ControllerInfo {pkg=" + this.mRemoteUserInfo.getPackageName() + ", uid=" + this.mRemoteUserInfo.getUid() + "})";
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1283754409, "Landroidx/media2/session/MediaSession;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1283754409, "Landroidx/media2/session/MediaSession;");
                return;
            }
        }
        STATIC_LOCK = new Object();
        SESSION_ID_TO_SESSION_MAP = new HashMap<>();
    }

    @NonNull
    private Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.mImpl.getUri();
        }
        return (Uri) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                synchronized (STATIC_LOCK) {
                    SESSION_ID_TO_SESSION_MAP.remove(this.mImpl.getId());
                }
                this.mImpl.close();
            } catch (Exception unused) {
            }
        }
    }

    @NonNull
    public SessionCallback getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImpl.getCallback();
        }
        return (SessionCallback) invokeV.objValue;
    }

    @NonNull
    public Executor getCallbackExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getCallbackExecutor();
        }
        return (Executor) invokeV.objValue;
    }

    @NonNull
    public List<ControllerInfo> getConnectedControllers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getConnectedControllers();
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getContext();
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.getId();
        }
        return (String) invokeV.objValue;
    }

    public MediaSessionImpl getImpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl;
        }
        return (MediaSessionImpl) invokeV.objValue;
    }

    public IBinder getLegacyBrowerServiceBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.getLegacyBrowserServiceBinder();
        }
        return (IBinder) invokeV.objValue;
    }

    @NonNull
    public SessionPlayer getPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mImpl.getPlayer();
        }
        return (SessionPlayer) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public MediaSessionCompat getSessionCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mImpl.getSessionCompat();
        }
        return (MediaSessionCompat) invokeV.objValue;
    }

    @NonNull
    public MediaSessionCompat.Token getSessionCompatToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mImpl.getSessionCompat().getSessionToken();
        }
        return (MediaSessionCompat.Token) invokeV.objValue;
    }

    @NonNull
    public SessionToken getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mImpl.getToken();
        }
        return (SessionToken) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mImpl.isClosed();
        }
        return invokeV.booleanValue;
    }

    public MediaSession(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (STATIC_LOCK) {
            if (!SESSION_ID_TO_SESSION_MAP.containsKey(str)) {
                SESSION_ID_TO_SESSION_MAP.put(str, this);
            } else {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
        }
        this.mImpl = createImpl(context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
    }

    public static MediaSession getSession(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            synchronized (STATIC_LOCK) {
                for (MediaSession mediaSession : SESSION_ID_TO_SESSION_MAP.values()) {
                    if (ObjectsCompat.equals(mediaSession.getUri(), uri)) {
                        return mediaSession;
                    }
                }
                return null;
            }
        }
        return (MediaSession) invokeL.objValue;
    }

    public void broadcastCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sessionCommand, bundle) == null) {
            if (sessionCommand != null) {
                if (sessionCommand.getCommandCode() == 0) {
                    this.mImpl.broadcastCustomCommand(sessionCommand, bundle);
                    return;
                }
                throw new IllegalArgumentException("command should be a custom command");
            }
            throw new NullPointerException("command shouldn't be null");
        }
    }

    public void setAllowedCommands(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, controllerInfo, sessionCommandGroup) == null) {
            if (controllerInfo != null) {
                if (sessionCommandGroup != null) {
                    this.mImpl.setAllowedCommands(controllerInfo, sessionCommandGroup);
                    return;
                }
                throw new NullPointerException("commands shouldn't be null");
            }
            throw new NullPointerException("controller shouldn't be null");
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> setCustomLayout(@NonNull ControllerInfo controllerInfo, @NonNull List<CommandButton> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, controllerInfo, list)) == null) {
            if (controllerInfo != null) {
                if (list != null) {
                    return this.mImpl.setCustomLayout(controllerInfo, list);
                }
                throw new NullPointerException("layout shouldn't be null");
            }
            throw new NullPointerException("controller shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public MediaSessionImpl createImpl(Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, SessionCallback sessionCallback, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle})) == null) {
            return new MediaSessionImplBase(this, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle);
        }
        return (MediaSessionImpl) invokeCommon.objValue;
    }

    public void handleControllerConnectionFromService(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            this.mImpl.connectFromService(iMediaController, i, str, i2, i3, bundle);
        }
    }

    @NonNull
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull ControllerInfo controllerInfo, @NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, controllerInfo, sessionCommand, bundle)) == null) {
            if (controllerInfo != null) {
                if (sessionCommand != null) {
                    if (sessionCommand.getCommandCode() == 0) {
                        return this.mImpl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
                    }
                    throw new IllegalArgumentException("command should be a custom command");
                }
                throw new NullPointerException("command shouldn't be null");
            }
            throw new NullPointerException("controller shouldn't be null");
        }
        return (ListenableFuture) invokeLLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLegacyControllerConnectionTimeoutMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.mImpl.setLegacyControllerConnectionTimeoutMs(j);
        }
    }

    public void updatePlayer(@NonNull SessionPlayer sessionPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sessionPlayer) == null) {
            if (sessionPlayer != null) {
                this.mImpl.updatePlayer(sessionPlayer);
                return;
            }
            throw new NullPointerException("player shouldn't be null");
        }
    }
}
