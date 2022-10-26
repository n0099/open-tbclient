package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final boolean DEBUG;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    public static final String TAG = "MediaBrowserCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaBrowserImpl mImpl;

    /* loaded from: classes.dex */
    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        Bundle getExtras();

        void getItem(String str, ItemCallback itemCallback);

        Bundle getNotifyChildrenChangedOptions();

        String getRoot();

        ComponentName getServiceComponent();

        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(String str, Bundle bundle, SearchCallback searchCallback);

        void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback);

        void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback);

        void unsubscribe(String str, SubscriptionCallback subscriptionCallback);
    }

    /* loaded from: classes.dex */
    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger messenger);

        void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public class ConnectionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaBrowser.ConnectionCallback mConnectionCallbackFwk;
        public ConnectionCallbackInternal mConnectionCallbackInternal;

        /* loaded from: classes.dex */
        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void onConnectionFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void onConnectionSuspended() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* loaded from: classes.dex */
        public class ConnectionCallbackApi21 extends MediaBrowser.ConnectionCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConnectionCallback this$0;

            public ConnectionCallbackApi21(ConnectionCallback connectionCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {connectionCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = connectionCallback;
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ConnectionCallbackInternal connectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
                    if (connectionCallbackInternal != null) {
                        connectionCallbackInternal.onConnected();
                    }
                    this.this$0.onConnected();
                }
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    ConnectionCallbackInternal connectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
                    if (connectionCallbackInternal != null) {
                        connectionCallbackInternal.onConnectionFailed();
                    }
                    this.this$0.onConnectionFailed();
                }
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    ConnectionCallbackInternal connectionCallbackInternal = this.this$0.mConnectionCallbackInternal;
                    if (connectionCallbackInternal != null) {
                        connectionCallbackInternal.onConnectionSuspended();
                    }
                    this.this$0.onConnectionSuspended();
                }
            }
        }

        public ConnectionCallback() {
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
            if (Build.VERSION.SDK_INT >= 21) {
                this.mConnectionCallbackFwk = new ConnectionCallbackApi21(this);
            } else {
                this.mConnectionCallbackFwk = null;
            }
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, connectionCallbackInternal) == null) {
                this.mConnectionCallbackInternal = connectionCallbackInternal;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class ItemCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaBrowser.ItemCallback mItemCallbackFwk;

        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        public void onItemLoaded(MediaItem mediaItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaItem) == null) {
            }
        }

        /* loaded from: classes.dex */
        public class ItemCallbackApi23 extends MediaBrowser.ItemCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ItemCallback this$0;

            public ItemCallbackApi23(ItemCallback itemCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {itemCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = itemCallback;
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.this$0.onError(str);
                }
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaItem) == null) {
                    this.this$0.onItemLoaded(MediaItem.fromMediaItem(mediaItem));
                }
            }
        }

        public ItemCallback() {
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
            if (Build.VERSION.SDK_INT >= 23) {
                this.mItemCallbackFwk = new ItemCallbackApi23(this);
            } else {
                this.mItemCallbackFwk = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CONNECT_STATE_CONNECTED = 3;
        public static final int CONNECT_STATE_CONNECTING = 2;
        public static final int CONNECT_STATE_DISCONNECTED = 1;
        public static final int CONNECT_STATE_DISCONNECTING = 0;
        public static final int CONNECT_STATE_SUSPENDED = 4;
        public transient /* synthetic */ FieldHolder $fh;
        public final ConnectionCallback mCallback;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public Bundle mExtras;
        public final CallbackHandler mHandler;
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public String mRootId;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public final ComponentName mServiceComponent;
        public MediaServiceConnection mServiceConnection;
        public int mState;
        public final ArrayMap mSubscriptions;

        /* loaded from: classes.dex */
        public class MediaServiceConnection implements ServiceConnection {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaBrowserImplBase this$0;

            public MediaServiceConnection(MediaBrowserImplBase mediaBrowserImplBase) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaBrowserImplBase};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = mediaBrowserImplBase;
            }

            private void postOrRun(Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65537, this, runnable) == null) {
                    if (Thread.currentThread() == this.this$0.mHandler.getLooper().getThread()) {
                        runnable.run();
                    } else {
                        this.this$0.mHandler.post(runnable);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
                    postOrRun(new Runnable(this, componentName) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaServiceConnection this$1;
                        public final /* synthetic */ ComponentName val$name;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, componentName};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$name = componentName;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceDisconnected name=" + this.val$name + " this=" + this + " mServiceConnection=" + this.this$1.this$0.mServiceConnection);
                                    this.this$1.this$0.dump();
                                }
                                if (!this.this$1.isCurrent("onServiceDisconnected")) {
                                    return;
                                }
                                MediaBrowserImplBase mediaBrowserImplBase = this.this$1.this$0;
                                mediaBrowserImplBase.mServiceBinderWrapper = null;
                                mediaBrowserImplBase.mCallbacksMessenger = null;
                                mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                                MediaBrowserImplBase mediaBrowserImplBase2 = this.this$1.this$0;
                                mediaBrowserImplBase2.mState = 4;
                                mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                            }
                        }
                    });
                }
            }

            public boolean isCurrent(String str) {
                InterceptResult invokeL;
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                    MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
                    if (mediaBrowserImplBase.mServiceConnection == this && (i = mediaBrowserImplBase.mState) != 0 && i != 1) {
                        return true;
                    }
                    int i2 = this.this$0.mState;
                    if (i2 != 0 && i2 != 1) {
                        Log.i(MediaBrowserCompat.TAG, str + " for " + this.this$0.mServiceComponent + " with mServiceConnection=" + this.this$0.mServiceConnection + " this=" + this);
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                    postOrRun(new Runnable(this, componentName, iBinder) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaServiceConnection this$1;
                        public final /* synthetic */ IBinder val$binder;
                        public final /* synthetic */ ComponentName val$name;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, componentName, iBinder};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$name = componentName;
                            this.val$binder = iBinder;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                if (MediaBrowserCompat.DEBUG) {
                                    Log.d(MediaBrowserCompat.TAG, "MediaServiceConnection.onServiceConnected name=" + this.val$name + " binder=" + this.val$binder);
                                    this.this$1.this$0.dump();
                                }
                                if (!this.this$1.isCurrent("onServiceConnected")) {
                                    return;
                                }
                                MediaBrowserImplBase mediaBrowserImplBase = this.this$1.this$0;
                                mediaBrowserImplBase.mServiceBinderWrapper = new ServiceBinderWrapper(this.val$binder, mediaBrowserImplBase.mRootHints);
                                this.this$1.this$0.mCallbacksMessenger = new Messenger(this.this$1.this$0.mHandler);
                                MediaBrowserImplBase mediaBrowserImplBase2 = this.this$1.this$0;
                                mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                                this.this$1.this$0.mState = 2;
                                try {
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                        this.this$1.this$0.dump();
                                    }
                                    this.this$1.this$0.mServiceBinderWrapper.connect(this.this$1.this$0.mContext, this.this$1.this$0.mCallbacksMessenger);
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + this.this$1.this$0.mServiceComponent);
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                                        this.this$1.this$0.dump();
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName, connectionCallback, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if (context != null) {
                if (componentName != null) {
                    if (connectionCallback != null) {
                        this.mContext = context;
                        this.mServiceComponent = componentName;
                        this.mCallback = connectionCallback;
                        if (bundle == null) {
                            bundle2 = null;
                        } else {
                            bundle2 = new Bundle(bundle);
                        }
                        this.mRootHints = bundle2;
                        return;
                    }
                    throw new IllegalArgumentException("connection callback must not be null");
                }
                throw new IllegalArgumentException("service component must not be null");
            }
            throw new IllegalArgumentException("context must not be null");
        }

        public static String getStateLabel(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    return "UNKNOWN/" + i;
                                }
                                return "CONNECT_STATE_SUSPENDED";
                            }
                            return "CONNECT_STATE_CONNECTED";
                        }
                        return "CONNECT_STATE_CONNECTING";
                    }
                    return "CONNECT_STATE_DISCONNECTED";
                }
                return "CONNECT_STATE_DISCONNECTING";
            }
            return (String) invokeI.objValue;
        }

        private boolean isCurrent(Messenger messenger, String str) {
            InterceptResult invokeLL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, messenger, str)) == null) {
                if (this.mCallbacksMessenger == messenger && (i = this.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = this.mState;
                if (i2 != 0 && i2 != 1) {
                    Log.i(MediaBrowserCompat.TAG, str + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.mState;
                if (i != 0 && i != 1) {
                    throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + SmallTailInfo.EMOTION_SUFFIX);
                }
                this.mState = 2;
                this.mHandler.post(new Runnable(this) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserImplBase this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
                            if (mediaBrowserImplBase.mState == 0) {
                                return;
                            }
                            mediaBrowserImplBase.mState = 2;
                            if (MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.this$0.mServiceConnection);
                            }
                            MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
                            if (mediaBrowserImplBase2.mServiceBinderWrapper == null) {
                                if (mediaBrowserImplBase2.mCallbacksMessenger == null) {
                                    Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                                    intent.setComponent(this.this$0.mServiceComponent);
                                    MediaBrowserImplBase mediaBrowserImplBase3 = this.this$0;
                                    mediaBrowserImplBase3.mServiceConnection = new MediaServiceConnection(mediaBrowserImplBase3);
                                    boolean z = false;
                                    try {
                                        z = this.this$0.mContext.bindService(intent, this.this$0.mServiceConnection, 1);
                                    } catch (Exception unused) {
                                        Log.e(MediaBrowserCompat.TAG, "Failed binding to service " + this.this$0.mServiceComponent);
                                    }
                                    if (!z) {
                                        this.this$0.forceCloseConnection();
                                        this.this$0.mCallback.onConnectionFailed();
                                    }
                                    if (MediaBrowserCompat.DEBUG) {
                                        Log.d(MediaBrowserCompat.TAG, "connect...");
                                        this.this$0.dump();
                                        return;
                                    }
                                    return;
                                }
                                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.this$0.mCallbacksMessenger);
                            }
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.this$0.mServiceBinderWrapper);
                        }
                    }
                });
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (isConnected()) {
                    return this.mExtras;
                }
                throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (isConnected()) {
                    return this.mRootId;
                }
                throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (isConnected()) {
                    return this.mServiceComponent;
                }
                throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + SmallTailInfo.EMOTION_SUFFIX);
            }
            return (ComponentName) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (isConnected()) {
                    return this.mMediaSessionToken;
                }
                throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + SmallTailInfo.EMOTION_SUFFIX);
            }
            return (MediaSessionCompat.Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mState = 0;
                this.mHandler.post(new Runnable(this) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserImplBase this$0;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
                            Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                            if (messenger != null) {
                                try {
                                    mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserCompat.TAG, "RemoteException during connect for " + this.this$0.mServiceComponent);
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase2 = this.this$0;
                            int i = mediaBrowserImplBase2.mState;
                            mediaBrowserImplBase2.forceCloseConnection();
                            if (i != 0) {
                                this.this$0.mState = i;
                            }
                            if (MediaBrowserCompat.DEBUG) {
                                Log.d(MediaBrowserCompat.TAG, "disconnect...");
                                this.this$0.dump();
                            }
                        }
                    }
                });
            }
        }

        public void forceCloseConnection() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
                if (mediaServiceConnection != null) {
                    this.mContext.unbindService(mediaServiceConnection);
                }
                this.mState = 1;
                this.mServiceConnection = null;
                this.mServiceBinderWrapper = null;
                this.mCallbacksMessenger = null;
                this.mHandler.setCallbacksMessenger(null);
                this.mRootId = null;
                this.mMediaSessionToken = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mNotifyChildrenChangedOptions;
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.mState == 3) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void dump() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
                Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
                Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
                Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
                Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
                Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
                Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
                Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
                Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
                Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String str, ItemCallback itemCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, itemCallback) == null) {
                if (!TextUtils.isEmpty(str)) {
                    if (itemCallback != null) {
                        if (!isConnected()) {
                            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                            this.mHandler.post(new Runnable(this, itemCallback, str) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplBase this$0;
                                public final /* synthetic */ ItemCallback val$cb;
                                public final /* synthetic */ String val$mediaId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, itemCallback, str};
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
                                    this.val$cb = itemCallback;
                                    this.val$mediaId = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$cb.onError(this.val$mediaId);
                                    }
                                }
                            });
                            return;
                        }
                        try {
                            this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
                            return;
                        } catch (RemoteException unused) {
                            Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                            this.mHandler.post(new Runnable(this, itemCallback, str) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplBase this$0;
                                public final /* synthetic */ ItemCallback val$cb;
                                public final /* synthetic */ String val$mediaId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, itemCallback, str};
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
                                    this.val$cb = itemCallback;
                                    this.val$mediaId = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$cb.onError(this.val$mediaId);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    throw new IllegalArgumentException("cb is null");
                }
                throw new IllegalArgumentException("mediaId is empty");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048593, this, str, subscriptionCallback) != null) || (subscription = (Subscription) this.mSubscriptions.get(str)) == null) {
                return;
            }
            try {
                if (subscriptionCallback == null) {
                    if (isConnected()) {
                        this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    }
                } else {
                    List callbacks = subscription.getCallbacks();
                    List optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                }
            } catch (RemoteException unused) {
                Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, messenger) == null) {
                Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
                if (!isCurrent(messenger, "onConnectFailed")) {
                    return;
                }
                if (this.mState != 2) {
                    Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                    return;
                }
                forceCloseConnection();
                this.mCallback.onConnectionFailed();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLLL(1048588, this, messenger, str, list, bundle, bundle2) != null) || !isCurrent(messenger, "onLoadChildren")) {
                return;
            }
            if (MediaBrowserCompat.DEBUG) {
                Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + str);
            }
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                    this.mNotifyChildrenChangedOptions = null;
                } else if (list == null) {
                    callback.onError(str, bundle);
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLL(1048589, this, messenger, str, token, bundle) != null) || !isCurrent(messenger, "onConnect")) {
                return;
            }
            if (this.mState != 2) {
                Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
                return;
            }
            this.mRootId = str;
            this.mMediaSessionToken = token;
            this.mExtras = bundle;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG) {
                Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
                dump();
            }
            this.mCallback.onConnected();
            try {
                for (Map.Entry entry : this.mSubscriptions.entrySet()) {
                    String str2 = (String) entry.getKey();
                    Subscription subscription = (Subscription) entry.getValue();
                    List callbacks = subscription.getCallbacks();
                    List optionsList = subscription.getOptionsList();
                    for (int i = 0; i < callbacks.size(); i++) {
                        this.mServiceBinderWrapper.addSubscription(str2, ((SubscriptionCallback) callbacks.get(i)).mToken, (Bundle) optionsList.get(i), this.mCallbacksMessenger);
                    }
                }
            } catch (RemoteException unused) {
                Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(String str, Bundle bundle, SearchCallback searchCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048590, this, str, bundle, searchCallback) == null) {
                if (isConnected()) {
                    try {
                        this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e);
                        this.mHandler.post(new Runnable(this, searchCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaBrowserImplBase this$0;
                            public final /* synthetic */ SearchCallback val$callback;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ String val$query;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, searchCallback, str, bundle};
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
                                this.val$callback = searchCallback;
                                this.val$query = str;
                                this.val$extras = bundle;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$callback.onError(this.val$query, this.val$extras);
                                }
                            }
                        });
                        return;
                    }
                }
                throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + SmallTailInfo.EMOTION_SUFFIX);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bundle, customActionCallback) == null) {
                if (isConnected()) {
                    try {
                        this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                        if (customActionCallback != null) {
                            this.mHandler.post(new Runnable(this, customActionCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplBase this$0;
                                public final /* synthetic */ String val$action;
                                public final /* synthetic */ CustomActionCallback val$callback;
                                public final /* synthetic */ Bundle val$extras;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, customActionCallback, str, bundle};
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
                                    this.val$callback = customActionCallback;
                                    this.val$action = str;
                                    this.val$extras = bundle;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$callback.onError(this.val$action, this.val$extras, null);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Bundle bundle2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048592, this, str, bundle, subscriptionCallback) == null) {
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    subscription = new Subscription();
                    this.mSubscriptions.put(str, subscription);
                }
                if (bundle == null) {
                    bundle2 = null;
                } else {
                    bundle2 = new Bundle(bundle);
                }
                subscription.putCallback(bundle2, subscriptionCallback);
                if (isConnected()) {
                    try {
                        this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                    } catch (RemoteException unused) {
                        Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + str);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class SubscriptionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        public WeakReference mSubscriptionRef;
        public final IBinder mToken;

        public void onChildrenLoaded(String str, List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
            }
        }

        public void onChildrenLoaded(String str, List list, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, bundle) == null) {
            }
        }

        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public void onError(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
            }
        }

        /* loaded from: classes.dex */
        public class SubscriptionCallbackApi21 extends MediaBrowser.SubscriptionCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SubscriptionCallback this$0;

            public SubscriptionCallbackApi21(SubscriptionCallback subscriptionCallback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {subscriptionCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = subscriptionCallback;
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    this.this$0.onError(str);
                }
            }

            public List applyOptions(List list, Bundle bundle) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, bundle)) == null) {
                    if (list == null) {
                        return null;
                    }
                    int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                    int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                    if (i == -1 && i2 == -1) {
                        return list;
                    }
                    int i3 = i2 * i;
                    int i4 = i3 + i2;
                    if (i >= 0 && i2 >= 1 && i3 < list.size()) {
                        if (i4 > list.size()) {
                            i4 = list.size();
                        }
                        return list.subList(i3, i4);
                    }
                    return Collections.emptyList();
                }
                return (List) invokeLL.objValue;
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String str, List list) {
                Subscription subscription;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list) == null) {
                    WeakReference weakReference = this.this$0.mSubscriptionRef;
                    if (weakReference == null) {
                        subscription = null;
                    } else {
                        subscription = (Subscription) weakReference.get();
                    }
                    if (subscription == null) {
                        this.this$0.onChildrenLoaded(str, MediaItem.fromMediaItemList(list));
                        return;
                    }
                    List<MediaItem> fromMediaItemList = MediaItem.fromMediaItemList(list);
                    List callbacks = subscription.getCallbacks();
                    List optionsList = subscription.getOptionsList();
                    for (int i = 0; i < callbacks.size(); i++) {
                        Bundle bundle = (Bundle) optionsList.get(i);
                        if (bundle == null) {
                            this.this$0.onChildrenLoaded(str, fromMediaItemList);
                        } else {
                            this.this$0.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class SubscriptionCallbackApi26 extends SubscriptionCallbackApi21 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SubscriptionCallback this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubscriptionCallbackApi26(SubscriptionCallback subscriptionCallback) {
                super(subscriptionCallback);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {subscriptionCallback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((SubscriptionCallback) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = subscriptionCallback;
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(String str, List list, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048576, this, str, list, bundle) == null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.this$0.onChildrenLoaded(str, MediaItem.fromMediaItemList(list), bundle);
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(String str, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.this$0.onError(str, bundle);
                }
            }
        }

        public SubscriptionCallback() {
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
            this.mToken = new Binder();
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi26(this);
            } else if (i3 >= 21) {
                this.mSubscriptionCallbackFwk = new SubscriptionCallbackApi21(this);
            } else {
                this.mSubscriptionCallbackFwk = null;
            }
        }

        public void setSubscription(Subscription subscription) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, subscription) == null) {
                this.mSubscriptionRef = new WeakReference(subscription);
            }
        }
    }

    /* loaded from: classes.dex */
    public class CallbackHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference mCallbackImplRef;
        public WeakReference mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCallbackImpl};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallbackImplRef = new WeakReference(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (weakReference = this.mCallbacksMessengerRef) != null && weakReference.get() != null && this.mCallbackImplRef.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) this.mCallbackImplRef.get();
                Messenger messenger = (Messenger) this.mCallbacksMessengerRef.get();
                try {
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            } else {
                                Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle);
                                Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                                MediaSessionCompat.ensureClassLoader(bundle2);
                                mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle, bundle2);
                            }
                        } else {
                            mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                        }
                    } else {
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
                    if (message.what == 1) {
                        mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                    }
                }
            }
        }

        public void setCallbacksMessenger(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messenger) == null) {
                this.mCallbacksMessengerRef = new WeakReference(messenger);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class CustomActionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onError(String str, Bundle bundle, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, bundle2) == null) {
            }
        }

        public void onProgressUpdate(String str, Bundle bundle, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle, bundle2) == null) {
            }
        }

        public void onResult(String str, Bundle bundle, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle, bundle2) == null) {
            }
        }

        public CustomActionCallback() {
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
    public class CustomActionResultReceiver extends ResultReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mAction;
        public final CustomActionCallback mCallback;
        public final Bundle mExtras;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomActionResultReceiver(String str, Bundle bundle, CustomActionCallback customActionCallback, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bundle, customActionCallback, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, bundle) != null) || this.mCallback == null) {
                return;
            }
            MediaSessionCompat.ensureClassLoader(bundle);
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        Log.w(MediaBrowserCompat.TAG, "Unknown result code: " + i + " (extras=" + this.mExtras + ", resultData=" + bundle + SmallTailInfo.EMOTION_SUFFIX);
                        return;
                    }
                    this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                    return;
                }
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                return;
            }
            this.mCallback.onError(this.mAction, this.mExtras, bundle);
        }
    }

    /* loaded from: classes.dex */
    public class ItemReceiver extends ResultReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ItemCallback mCallback;
        public final String mMediaId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemReceiver(String str, ItemCallback itemCallback, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, itemCallback, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bundle) == null) {
                if (bundle != null) {
                    bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
                }
                if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                    Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                    if (parcelable != null && !(parcelable instanceof MediaItem)) {
                        this.mCallback.onError(this.mMediaId);
                        return;
                    } else {
                        this.mCallback.onItemLoaded((MediaItem) parcelable);
                        return;
                    }
                }
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    /* loaded from: classes.dex */
    public class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaBrowser mBrowserFwk;
        public Messenger mCallbacksMessenger;
        public final Context mContext;
        public final CallbackHandler mHandler;
        public MediaSessionCompat.Token mMediaSessionToken;
        public Bundle mNotifyChildrenChangedOptions;
        public final Bundle mRootHints;
        public ServiceBinderWrapper mServiceBinderWrapper;
        public int mServiceVersion;
        public final ArrayMap mSubscriptions;

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, messenger) == null) {
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048590, this, messenger, str, token, bundle) == null) {
            }
        }

        public MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            Bundle bundle2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName, connectionCallback, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = context;
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            this.mRootHints = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            this.mRootHints.putInt(MediaBrowserProtocol.EXTRA_CALLING_PID, Process.myPid());
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, this.mRootHints);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mBrowserFwk.connect();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                    try {
                        serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                    } catch (RemoteException unused) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
                    }
                }
                this.mBrowserFwk.disconnect();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mBrowserFwk.getExtras();
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mNotifyChildrenChangedOptions;
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public String getRoot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mBrowserFwk.getRoot();
            }
            return (String) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mBrowserFwk.getServiceComponent();
            }
            return (ComponentName) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token getSessionToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.mMediaSessionToken == null) {
                    this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
                }
                return this.mMediaSessionToken;
            }
            return (MediaSessionCompat.Token) invokeV.objValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mBrowserFwk.isConnected();
            }
            return invokeV.booleanValue;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                this.mServiceBinderWrapper = null;
                this.mCallbacksMessenger = null;
                this.mMediaSessionToken = null;
                this.mHandler.setCallbacksMessenger(null);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String str, ItemCallback itemCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, itemCallback) == null) {
                if (!TextUtils.isEmpty(str)) {
                    if (itemCallback != null) {
                        if (!this.mBrowserFwk.isConnected()) {
                            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
                            this.mHandler.post(new Runnable(this, itemCallback, str) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplApi21 this$0;
                                public final /* synthetic */ ItemCallback val$cb;
                                public final /* synthetic */ String val$mediaId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, itemCallback, str};
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
                                    this.val$cb = itemCallback;
                                    this.val$mediaId = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$cb.onError(this.val$mediaId);
                                    }
                                }
                            });
                            return;
                        } else if (this.mServiceBinderWrapper == null) {
                            this.mHandler.post(new Runnable(this, itemCallback, str) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplApi21 this$0;
                                public final /* synthetic */ ItemCallback val$cb;
                                public final /* synthetic */ String val$mediaId;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, itemCallback, str};
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
                                    this.val$cb = itemCallback;
                                    this.val$mediaId = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$cb.onError(this.val$mediaId);
                                    }
                                }
                            });
                            return;
                        } else {
                            try {
                                this.mServiceBinderWrapper.getMediaItem(str, new ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
                                return;
                            } catch (RemoteException unused) {
                                Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + str);
                                this.mHandler.post(new Runnable(this, itemCallback, str) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ MediaBrowserImplApi21 this$0;
                                    public final /* synthetic */ ItemCallback val$cb;
                                    public final /* synthetic */ String val$mediaId;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, itemCallback, str};
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
                                        this.val$cb = itemCallback;
                                        this.val$mediaId = str;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            this.val$cb.onError(this.val$mediaId);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                    }
                    throw new IllegalArgumentException("cb is null");
                }
                throw new IllegalArgumentException("mediaId is empty");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    Bundle extras = this.mBrowserFwk.getExtras();
                    if (extras == null) {
                        return;
                    }
                    this.mServiceVersion = extras.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                    IBinder binder = BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                    if (binder != null) {
                        this.mServiceBinderWrapper = new ServiceBinderWrapper(binder, this.mRootHints);
                        Messenger messenger = new Messenger(this.mHandler);
                        this.mCallbacksMessenger = messenger;
                        this.mHandler.setCallbacksMessenger(messenger);
                        try {
                            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                        } catch (RemoteException unused) {
                            Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
                        }
                    }
                    IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.getBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                    if (asInterface != null) {
                        this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), asInterface);
                    }
                } catch (IllegalStateException e) {
                    Log.e(MediaBrowserCompat.TAG, "Unexpected IllegalStateException", e);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLLL(1048589, this, messenger, str, list, bundle, bundle2) != null) || this.mCallbacksMessenger != messenger) {
                return;
            }
            Subscription subscription = (Subscription) this.mSubscriptions.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.DEBUG) {
                    Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                    this.mNotifyChildrenChangedOptions = null;
                } else if (list == null) {
                    callback.onError(str, bundle);
                } else {
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(String str, Bundle bundle, SearchCallback searchCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bundle, searchCallback) == null) {
                if (isConnected()) {
                    if (this.mServiceBinderWrapper == null) {
                        Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
                        this.mHandler.post(new Runnable(this, searchCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaBrowserImplApi21 this$0;
                            public final /* synthetic */ SearchCallback val$callback;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ String val$query;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, searchCallback, str, bundle};
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
                                this.val$callback = searchCallback;
                                this.val$query = str;
                                this.val$extras = bundle;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$callback.onError(this.val$query, this.val$extras);
                                }
                            }
                        });
                        return;
                    }
                    try {
                        this.mServiceBinderWrapper.search(str, bundle, new SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + str, e);
                        this.mHandler.post(new Runnable(this, searchCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.5
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaBrowserImplApi21 this$0;
                            public final /* synthetic */ SearchCallback val$callback;
                            public final /* synthetic */ Bundle val$extras;
                            public final /* synthetic */ String val$query;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, searchCallback, str, bundle};
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
                                this.val$callback = searchCallback;
                                this.val$query = str;
                                this.val$extras = bundle;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.val$callback.onError(this.val$query, this.val$extras);
                                }
                            }
                        });
                        return;
                    }
                }
                throw new IllegalStateException("search() called while not connected");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Bundle bundle2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048593, this, str, bundle, subscriptionCallback) == null) {
                Subscription subscription = (Subscription) this.mSubscriptions.get(str);
                if (subscription == null) {
                    subscription = new Subscription();
                    this.mSubscriptions.put(str, subscription);
                }
                subscriptionCallback.setSubscription(subscription);
                if (bundle == null) {
                    bundle2 = null;
                } else {
                    bundle2 = new Bundle(bundle);
                }
                subscription.putCallback(bundle2, subscriptionCallback);
                ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
                if (serviceBinderWrapper == null) {
                    this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                    return;
                }
                try {
                    serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (RemoteException unused) {
                    Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048592, this, str, bundle, customActionCallback) == null) {
                if (isConnected()) {
                    if (this.mServiceBinderWrapper == null) {
                        Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
                        if (customActionCallback != null) {
                            this.mHandler.post(new Runnable(this, customActionCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.6
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplApi21 this$0;
                                public final /* synthetic */ String val$action;
                                public final /* synthetic */ CustomActionCallback val$callback;
                                public final /* synthetic */ Bundle val$extras;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, customActionCallback, str, bundle};
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
                                    this.val$callback = customActionCallback;
                                    this.val$action = str;
                                    this.val$extras = bundle;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$callback.onError(this.val$action, this.val$extras, null);
                                    }
                                }
                            });
                        }
                    }
                    try {
                        this.mServiceBinderWrapper.sendCustomAction(str, bundle, new CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
                        return;
                    } catch (RemoteException e) {
                        Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + str + ", extras=" + bundle, e);
                        if (customActionCallback != null) {
                            this.mHandler.post(new Runnable(this, customActionCallback, str, bundle) { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.7
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ MediaBrowserImplApi21 this$0;
                                public final /* synthetic */ String val$action;
                                public final /* synthetic */ CustomActionCallback val$callback;
                                public final /* synthetic */ Bundle val$extras;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, customActionCallback, str, bundle};
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
                                    this.val$callback = customActionCallback;
                                    this.val$action = str;
                                    this.val$extras = bundle;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.val$callback.onError(this.val$action, this.val$extras, null);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Subscription subscription;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048594, this, str, subscriptionCallback) != null) || (subscription = (Subscription) this.mSubscriptions.get(str)) == null) {
                return;
            }
            ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                if (subscriptionCallback == null) {
                    this.mBrowserFwk.unsubscribe(str);
                } else {
                    List callbacks = subscription.getCallbacks();
                    List optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                    if (callbacks.size() == 0) {
                        this.mBrowserFwk.unsubscribe(str);
                    }
                }
            } else {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        List callbacks2 = subscription.getCallbacks();
                        List optionsList2 = subscription.getOptionsList();
                        for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                            if (callbacks2.get(size2) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks2.remove(size2);
                                optionsList2.remove(size2);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    /* loaded from: classes.dex */
    public class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName, connectionCallback, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (ComponentName) objArr2[1], (ConnectionCallback) objArr2[2], (Bundle) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(String str, ItemCallback itemCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, itemCallback) == null) {
                if (this.mServiceBinderWrapper == null) {
                    this.mBrowserFwk.getItem(str, itemCallback.mItemCallbackFwk);
                } else {
                    super.getItem(str, itemCallback);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, componentName, connectionCallback, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (ComponentName) objArr2[1], (ConnectionCallback) objArr2[2], (Bundle) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, subscriptionCallback) == null) {
                if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                    super.subscribe(str, bundle, subscriptionCallback);
                } else if (bundle == null) {
                    this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                } else {
                    this.mBrowserFwk.subscribe(str, bundle, subscriptionCallback.mSubscriptionCallbackFwk);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, subscriptionCallback) == null) {
                if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                    super.unsubscribe(str, subscriptionCallback);
                } else if (subscriptionCallback == null) {
                    this.mBrowserFwk.unsubscribe(str);
                } else {
                    this.mBrowserFwk.unsubscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<MediaItem> CREATOR;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaDescriptionCompat mDescription;
        public final int mFlags;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-867105966, "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-867105966, "Landroid/support/v4/media/MediaBrowserCompat$MediaItem;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public MediaItem createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new MediaItem(parcel);
                    }
                    return (MediaItem) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public MediaItem[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new MediaItem[i];
                    }
                    return (MediaItem[]) invokeI.objValue;
                }
            };
        }

        public MediaDescriptionCompat getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDescription;
            }
            return (MediaDescriptionCompat) invokeV.objValue;
        }

        public int getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mFlags;
            }
            return invokeV.intValue;
        }

        public String getMediaId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mDescription.getMediaId();
            }
            return (String) invokeV.objValue;
        }

        public boolean isBrowsable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if ((this.mFlags & 1) != 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isPlayable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if ((this.mFlags & 2) != 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public MediaItem(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mFlags = parcel.readInt();
            this.mDescription = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public static MediaItem fromMediaItem(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
                if (obj != null && Build.VERSION.SDK_INT >= 21) {
                    MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
                    return new MediaItem(MediaDescriptionCompat.fromMediaDescription(mediaItem.getDescription()), mediaItem.getFlags());
                }
                return null;
            }
            return (MediaItem) invokeL.objValue;
        }

        public static List<MediaItem> fromMediaItemList(List<?> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
                if (list != null && Build.VERSION.SDK_INT >= 21) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator<?> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(fromMediaItem(it.next()));
                    }
                    return arrayList;
                }
                return null;
            }
            return (List) invokeL.objValue;
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaDescriptionCompat, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                    this.mFlags = i;
                    this.mDescription = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
            }
            return (String) invokeV.objValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeInt(this.mFlags);
                this.mDescription.writeToParcel(parcel, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class SearchCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void onError(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bundle) == null) {
            }
        }

        public void onSearchResult(String str, Bundle bundle, List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle, list) == null) {
            }
        }

        public SearchCallback() {
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
    public class SearchResultReceiver extends ResultReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SearchCallback mCallback;
        public final Bundle mExtras;
        public final String mQuery;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchResultReceiver(String str, Bundle bundle, SearchCallback searchCallback, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bundle, searchCallback, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, bundle) == null) {
                if (bundle != null) {
                    bundle = MediaSessionCompat.unparcelWithClassLoader(bundle);
                }
                if (i == 0 && bundle != null && bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
                    if (parcelableArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Parcelable parcelable : parcelableArray) {
                            arrayList.add((MediaItem) parcelable);
                        }
                        this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
                        return;
                    }
                    this.mCallback.onError(this.mQuery, this.mExtras);
                    return;
                }
                this.mCallback.onError(this.mQuery, this.mExtras);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ServiceBinderWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Messenger mMessenger;
        public Bundle mRootHints;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iBinder, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMessenger = new Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(65537, this, i, bundle, messenger) == null) {
                Message obtain = Message.obtain();
                obtain.what = i;
                obtain.arg1 = 1;
                obtain.setData(bundle);
                obtain.replyTo = messenger;
                this.mMessenger.send(obtain);
            }
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, resultReceiver, messenger) == null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                bundle.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
                sendRequest(5, bundle, messenger);
            }
        }

        public void removeSubscription(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, iBinder, messenger) == null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                BundleCompat.putBinder(bundle, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
                sendRequest(4, bundle, messenger);
            }
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, iBinder, bundle, messenger) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                BundleCompat.putBinder(bundle2, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
                bundle2.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
                sendRequest(3, bundle2, messenger);
            }
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048582, this, str, bundle, resultReceiver, messenger) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
                bundle2.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
                bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
                sendRequest(8, bundle2, messenger);
            }
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048583, this, str, bundle, resultReceiver, messenger) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
                bundle2.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
                bundle2.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
                sendRequest(9, bundle2, messenger);
            }
        }

        public void connect(Context context, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, messenger) == null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                bundle.putInt("data_calling_pid", Process.myPid());
                bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
                sendRequest(1, bundle, messenger);
            }
        }

        public void registerCallbackMessenger(Context context, Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, context, messenger) == null) {
                Bundle bundle = new Bundle();
                bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
                bundle.putInt("data_calling_pid", Process.myPid());
                bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
                sendRequest(6, bundle, messenger);
            }
        }

        public void disconnect(Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, messenger) == null) {
                sendRequest(2, null, messenger);
            }
        }

        public void unregisterCallbackMessenger(Messenger messenger) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, messenger) == null) {
                sendRequest(7, null, messenger);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Subscription {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List mCallbacks;
        public final List mOptionsList;

        public Subscription() {
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
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public List getCallbacks() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mCallbacks;
            }
            return (List) invokeV.objValue;
        }

        public List getOptionsList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mOptionsList;
            }
            return (List) invokeV.objValue;
        }

        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mCallbacks.isEmpty();
            }
            return invokeV.booleanValue;
        }

        public SubscriptionCallback getCallback(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                for (int i = 0; i < this.mOptionsList.size(); i++) {
                    if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), bundle)) {
                        return (SubscriptionCallback) this.mCallbacks.get(i);
                    }
                }
                return null;
            }
            return (SubscriptionCallback) invokeL.objValue;
        }

        public void putCallback(Bundle bundle, SubscriptionCallback subscriptionCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bundle, subscriptionCallback) == null) {
                for (int i = 0; i < this.mOptionsList.size(); i++) {
                    if (MediaBrowserCompatUtils.areSameOptions((Bundle) this.mOptionsList.get(i), bundle)) {
                        this.mCallbacks.set(i, subscriptionCallback);
                        return;
                    }
                }
                this.mCallbacks.add(subscriptionCallback);
                this.mOptionsList.add(bundle);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1595780411, "Landroid/support/v4/media/MediaBrowserCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1595780411, "Landroid/support/v4/media/MediaBrowserCompat;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d(TAG, "Connecting to a MediaBrowserService.");
            this.mImpl.connect();
        }
    }

    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mImpl.disconnect();
        }
    }

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.getExtras();
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle getNotifyChildrenChangedOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getNotifyChildrenChangedOptions();
        }
        return (Bundle) invokeV.objValue;
    }

    public String getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getRoot();
        }
        return (String) invokeV.objValue;
    }

    public ComponentName getServiceComponent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getServiceComponent();
        }
        return (ComponentName) invokeV.objValue;
    }

    public MediaSessionCompat.Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.getSessionToken();
        }
        return (MediaSessionCompat.Token) invokeV.objValue;
    }

    public boolean isConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.isConnected();
        }
        return invokeV.booleanValue;
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, componentName, connectionCallback, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            this.mImpl = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
        } else if (i3 >= 23) {
            this.mImpl = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (i3 >= 21) {
            this.mImpl = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public void getItem(String str, ItemCallback itemCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, itemCallback) == null) {
            this.mImpl.getItem(str, itemCallback);
        }
    }

    public void subscribe(String str, SubscriptionCallback subscriptionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, subscriptionCallback) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (subscriptionCallback != null) {
                    this.mImpl.subscribe(str, null, subscriptionCallback);
                    return;
                }
                throw new IllegalArgumentException("callback is null");
            }
            throw new IllegalArgumentException("parentId is empty");
        }
    }

    public void unsubscribe(String str, SubscriptionCallback subscriptionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, subscriptionCallback) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (subscriptionCallback != null) {
                    this.mImpl.unsubscribe(str, subscriptionCallback);
                    return;
                }
                throw new IllegalArgumentException("callback is null");
            }
            throw new IllegalArgumentException("parentId is empty");
        }
    }

    public void search(String str, Bundle bundle, SearchCallback searchCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, str, bundle, searchCallback) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (searchCallback != null) {
                    this.mImpl.search(str, bundle, searchCallback);
                    return;
                }
                throw new IllegalArgumentException("callback cannot be null");
            }
            throw new IllegalArgumentException("query cannot be empty");
        }
    }

    public void sendCustomAction(String str, Bundle bundle, CustomActionCallback customActionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, bundle, customActionCallback) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mImpl.sendCustomAction(str, bundle, customActionCallback);
                return;
            }
            throw new IllegalArgumentException("action cannot be empty");
        }
    }

    public void subscribe(String str, Bundle bundle, SubscriptionCallback subscriptionCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bundle, subscriptionCallback) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (subscriptionCallback != null) {
                    if (bundle != null) {
                        this.mImpl.subscribe(str, bundle, subscriptionCallback);
                        return;
                    }
                    throw new IllegalArgumentException("options are null");
                }
                throw new IllegalArgumentException("callback is null");
            }
            throw new IllegalArgumentException("parentId is empty");
        }
    }

    public void unsubscribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                this.mImpl.unsubscribe(str, null);
                return;
            }
            throw new IllegalArgumentException("parentId is empty");
        }
    }
}
