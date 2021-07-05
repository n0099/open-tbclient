package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final float EPSILON = 1.0E-5f;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_MEDIA_ITEM = "media_item";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String KEY_SEARCH_RESULTS = "search_results";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    public static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    public static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    public static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    public static final String TAG = "MBServiceCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayMap<IBinder, ConnectionRecord> mConnections;
    public ConnectionRecord mCurConnection;
    public final ServiceHandler mHandler;
    public MediaBrowserServiceImpl mImpl;
    public MediaSessionCompat.Token mSession;

    /* loaded from: classes.dex */
    public static final class BrowserRoot {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mExtras;
        public final String mRootId;

        public BrowserRoot(@NonNull String str, @Nullable Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (str != null) {
                this.mRootId = str;
                this.mExtras = bundle;
                return;
            }
            throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
        }

        public Bundle getExtras() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mExtras : (Bundle) invokeV.objValue;
        }

        public String getRootId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRootId : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class ConnectionRecord implements IBinder.DeathRecipient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;
        public final int uid;

        public ConnectionRecord(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat, str, Integer.valueOf(i2), Integer.valueOf(i3), bundle, serviceCallbacks};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
            this.subscriptions = new HashMap<>();
            this.pkg = str;
            this.pid = i2;
            this.uid = i3;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.mHandler.post(new Runnable(this) { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConnectionRecord this$1;

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
                        this.this$1 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ConnectionRecord connectionRecord = this.this$1;
                            connectionRecord.this$0.mConnections.remove(connectionRecord.callbacks.asBinder());
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Messenger mMessenger;
        public final List<Bundle> mRootExtrasList;
        public Object mServiceObj;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplApi21(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
            this.mRootExtrasList = new ArrayList();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mMessenger == null) {
                    return null;
                }
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    if (connectionRecord.rootHints == null) {
                        return null;
                    }
                    return new Bundle(this.this$0.mCurConnection.rootHints);
                }
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    return connectionRecord.browserInfo;
                }
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                notifyChildrenChangedForFramework(str, bundle);
                notifyChildrenChangedForCompat(str, bundle);
            }
        }

        public void notifyChildrenChangedForCompat(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, str, bundle) == null) {
                this.this$0.mHandler.post(new Runnable(this, str, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi21 this$1;
                    public final /* synthetic */ Bundle val$options;
                    public final /* synthetic */ String val$parentId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$parentId = str;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (IBinder iBinder : this.this$1.this$0.mConnections.keySet()) {
                                ArrayMap<IBinder, ConnectionRecord> arrayMap = this.this$1.this$0.mConnections;
                                this.this$1.notifyChildrenChangedForCompatOnHandler(arrayMap.get(iBinder), this.val$parentId, this.val$options);
                            }
                        }
                    }
                });
            }
        }

        public void notifyChildrenChangedForCompatOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048582, this, connectionRecord, str, bundle) == null) || (list = connectionRecord.subscriptions.get(str)) == null) {
                return;
            }
            for (Pair<IBinder, Bundle> pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                    this.this$0.performLoadChildren(str, connectionRecord, pair.second, bundle);
                }
            }
        }

        public void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, str, bundle) == null) {
                MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent)) == null) ? MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent) : (IBinder) invokeL.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                Object createService = MediaBrowserServiceCompatApi21.createService(this.this$0, this);
                this.mServiceObj = createService;
                MediaBrowserServiceCompatApi21.onCreate(createService);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i2, Bundle bundle) {
            InterceptResult invokeLIL;
            Bundle bundle2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048586, this, str, i2, bundle)) == null) {
                if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                    bundle2 = null;
                } else {
                    bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                    this.mMessenger = new Messenger(this.this$0.mHandler);
                    bundle2 = new Bundle();
                    bundle2.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                    BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                    MediaSessionCompat.Token token = this.this$0.mSession;
                    if (token != null) {
                        IMediaSession extraBinder = token.getExtraBinder();
                        BundleCompat.putBinder(bundle2, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                    } else {
                        this.mRootExtrasList.add(bundle2);
                    }
                }
                MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$0;
                mediaBrowserServiceCompat.mCurConnection = new ConnectionRecord(mediaBrowserServiceCompat, str, -1, i2, bundle, null);
                BrowserRoot onGetRoot = this.this$0.onGetRoot(str, i2, bundle);
                this.this$0.mCurConnection = null;
                if (onGetRoot == null) {
                    return null;
                }
                if (bundle2 == null) {
                    bundle2 = onGetRoot.getExtras();
                } else if (onGetRoot.getExtras() != null) {
                    bundle2.putAll(onGetRoot.getExtras());
                }
                return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
            }
            return (MediaBrowserServiceCompatApi21.BrowserRoot) invokeLIL.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, resultWrapper) == null) {
                this.this$0.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultWrapper) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi21 this$1;
                    public final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(str);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, resultWrapper};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$resultWrapper = resultWrapper;
                    }

                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void detach() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$resultWrapper.detach();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                        ArrayList arrayList;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                            if (list != null) {
                                arrayList = new ArrayList();
                                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                                    Parcel obtain = Parcel.obtain();
                                    mediaItem.writeToParcel(obtain, 0);
                                    arrayList.add(obtain);
                                }
                            } else {
                                arrayList = null;
                            }
                            this.val$resultWrapper.sendResult(arrayList);
                        }
                    }
                });
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, token) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, token) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi21 this$1;
                    public final /* synthetic */ MediaSessionCompat.Token val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, token};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$token = token;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.this$1.mRootExtrasList.isEmpty()) {
                                IMediaSession extraBinder = this.val$token.getExtraBinder();
                                if (extraBinder != null) {
                                    for (Bundle bundle : this.this$1.mRootExtrasList) {
                                        BundleCompat.putBinder(bundle, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                                    }
                                }
                                this.this$1.mRootExtrasList.clear();
                            }
                            MediaBrowserServiceCompatApi21.setSessionToken(this.this$1.mServiceObj, this.val$token.getToken());
                        }
                    }
                });
            }
        }

        public void notifyChildrenChangedForCompat(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, remoteUserInfo, str, bundle) == null) {
                this.this$0.mHandler.post(new Runnable(this, remoteUserInfo, str, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi21 this$1;
                    public final /* synthetic */ Bundle val$options;
                    public final /* synthetic */ String val$parentId;
                    public final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, remoteUserInfo, str, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$remoteUserInfo = remoteUserInfo;
                        this.val$parentId = str;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (int i2 = 0; i2 < this.this$1.this$0.mConnections.size(); i2++) {
                                ConnectionRecord valueAt = this.this$1.this$0.mConnections.valueAt(i2);
                                if (valueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                                    this.this$1.notifyChildrenChangedForCompatOnHandler(valueAt, this.val$parentId, this.val$options);
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, remoteUserInfo, str, bundle) == null) {
                notifyChildrenChangedForCompat(remoteUserInfo, str, bundle);
            }
        }
    }

    @RequiresApi(23)
    /* loaded from: classes.dex */
    public class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super(mediaBrowserServiceCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MediaBrowserServiceCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Object createService = MediaBrowserServiceCompatApi23.createService(this.this$0, this);
                this.mServiceObj = createService;
                MediaBrowserServiceCompatApi21.onCreate(createService);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, resultWrapper) == null) {
                this.this$0.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(this, str, resultWrapper) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi23 this$1;
                    public final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(str);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, resultWrapper};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$resultWrapper = resultWrapper;
                    }

                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void detach() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$resultWrapper.detach();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaItem) == null) {
                            if (mediaItem == null) {
                                this.val$resultWrapper.sendResult(null);
                                return;
                            }
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            this.val$resultWrapper.sendResult(obtain);
                        }
                    }
                });
            }
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    public class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaBrowserServiceImplApi26(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super(mediaBrowserServiceCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MediaBrowserServiceCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    if (connectionRecord.rootHints == null) {
                        return null;
                    }
                    return new Bundle(this.this$0.mCurConnection.rootHints);
                }
                return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        public void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bundle) == null) {
                if (bundle != null) {
                    MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
                } else {
                    super.notifyChildrenChangedForFramework(str, bundle);
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object createService = MediaBrowserServiceCompatApi26.createService(this.this$0, this);
                this.mServiceObj = createService;
                MediaBrowserServiceCompatApi21.onCreate(createService);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, str, resultWrapper, bundle) == null) {
                this.this$0.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultWrapper) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplApi26 this$1;
                    public final /* synthetic */ MediaBrowserServiceCompatApi26.ResultWrapper val$resultWrapper;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(str);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, resultWrapper};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super(newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$resultWrapper = resultWrapper;
                    }

                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void detach() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$resultWrapper.detach();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media.MediaBrowserServiceCompat.Result
                    public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                        ArrayList arrayList;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
                            if (list != null) {
                                arrayList = new ArrayList();
                                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                                    Parcel obtain = Parcel.obtain();
                                    mediaItem.writeToParcel(obtain, 0);
                                    arrayList.add(obtain);
                                }
                            } else {
                                arrayList = null;
                            }
                            this.val$resultWrapper.sendResult(arrayList, getFlags());
                        }
                    }
                }, bundle);
            }
        }
    }

    @RequiresApi(28)
    /* loaded from: classes.dex */
    public class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaBrowserServiceImplApi28(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super(mediaBrowserServiceCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((MediaBrowserServiceCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    return connectionRecord.browserInfo;
                }
                return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Messenger mMessenger;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        public MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    if (connectionRecord.rootHints == null) {
                        return null;
                    }
                    return new Bundle(this.this$0.mCurConnection.rootHints);
                }
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return (Bundle) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ConnectionRecord connectionRecord = this.this$0.mCurConnection;
                if (connectionRecord != null) {
                    return connectionRecord.browserInfo;
                }
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                this.this$0.mHandler.post(new Runnable(this, str, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplBase this$1;
                    public final /* synthetic */ Bundle val$options;
                    public final /* synthetic */ String val$parentId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$parentId = str;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (IBinder iBinder : this.this$1.this$0.mConnections.keySet()) {
                                ArrayMap<IBinder, ConnectionRecord> arrayMap = this.this$1.this$0.mConnections;
                                this.this$1.notifyChildrenChangedOnHandler(arrayMap.get(iBinder), this.val$parentId, this.val$options);
                            }
                        }
                    }
                });
            }
        }

        public void notifyChildrenChangedOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048580, this, connectionRecord, str, bundle) == null) || (list = connectionRecord.subscriptions.get(str)) == null) {
                return;
            }
            for (Pair<IBinder, Bundle> pair : list) {
                if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                    this.this$0.performLoadChildren(str, connectionRecord, pair.second, bundle);
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, intent)) == null) {
                if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                    return this.mMessenger.getBinder();
                }
                return null;
            }
            return (IBinder) invokeL.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.mMessenger = new Messenger(this.this$0.mHandler);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, token) == null) {
                this.this$0.mHandler.post(new Runnable(this, token) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplBase this$1;
                    public final /* synthetic */ MediaSessionCompat.Token val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, token};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$token = token;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Iterator<ConnectionRecord> it = this.this$1.this$0.mConnections.values().iterator();
                            while (it.hasNext()) {
                                ConnectionRecord next = it.next();
                                try {
                                    next.callbacks.onConnect(next.root.getRootId(), this.val$token, next.root.getExtras());
                                } catch (RemoteException unused) {
                                    Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + next.pkg + " is no longer valid.");
                                    it.remove();
                                }
                            }
                        }
                    }
                });
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, remoteUserInfo, str, bundle) == null) {
                this.this$0.mHandler.post(new Runnable(this, remoteUserInfo, str, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserServiceImplBase this$1;
                    public final /* synthetic */ Bundle val$options;
                    public final /* synthetic */ String val$parentId;
                    public final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, remoteUserInfo, str, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$remoteUserInfo = remoteUserInfo;
                        this.val$parentId = str;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            for (int i2 = 0; i2 < this.this$1.this$0.mConnections.size(); i2++) {
                                ConnectionRecord valueAt = this.this$1.this$0.mConnections.valueAt(i2);
                                if (valueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                                    this.this$1.notifyChildrenChangedOnHandler(valueAt, this.val$parentId, this.val$options);
                                    return;
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Result<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mDebug;
        public boolean mDetachCalled;
        public int mFlags;
        public boolean mSendErrorCalled;
        public boolean mSendProgressUpdateCalled;
        public boolean mSendResultCalled;

        public Result(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDebug = obj;
        }

        private void checkExtraFields(Bundle bundle) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65537, this, bundle) == null) && bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f2 = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f2 < -1.0E-5f || f2 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.mDetachCalled) {
                    if (!this.mSendResultCalled) {
                        if (!this.mSendErrorCalled) {
                            this.mDetachCalled = true;
                            return;
                        }
                        throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
                    }
                    throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
                }
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
        }

        public int getFlags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFlags : invokeV.intValue;
        }

        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled : invokeV.booleanValue;
        }

        public void onErrorSent(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
            }
        }

        public void onProgressUpdateSent(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
                throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
            }
        }

        public void onResultSent(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            }
        }

        public void sendError(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
                if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                    this.mSendErrorCalled = true;
                    onErrorSent(bundle);
                    return;
                }
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void sendProgressUpdate(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
                if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                    checkExtraFields(bundle);
                    this.mSendProgressUpdateCalled = true;
                    onProgressUpdateSent(bundle);
                    return;
                }
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void sendResult(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
                if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                    this.mSendResultCalled = true;
                    onResultSent(t);
                    return;
                }
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void setFlags(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
                this.mFlags = i2;
            }
        }
    }

    /* loaded from: classes.dex */
    public class ServiceBinderImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceBinderImpl(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, iBinder, bundle, serviceCallbacks) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, iBinder, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceBinderImpl this$1;
                    public final /* synthetic */ ServiceCallbacks val$callbacks;
                    public final /* synthetic */ String val$id;
                    public final /* synthetic */ Bundle val$options;
                    public final /* synthetic */ IBinder val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceCallbacks, str, iBinder, bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$callbacks = serviceCallbacks;
                        this.val$id = str;
                        this.val$token = iBinder;
                        this.val$options = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                            if (connectionRecord == null) {
                                Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + this.val$id);
                                return;
                            }
                            this.this$1.this$0.addSubscription(this.val$id, connectionRecord, this.val$token, this.val$options);
                        }
                    }
                });
            }
        }

        public void connect(String str, int i2, int i3, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), bundle, serviceCallbacks}) == null) {
                if (this.this$0.isValidPackage(str, i3)) {
                    this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, i2, i3, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ServiceBinderImpl this$1;
                        public final /* synthetic */ ServiceCallbacks val$callbacks;
                        public final /* synthetic */ int val$pid;
                        public final /* synthetic */ String val$pkg;
                        public final /* synthetic */ Bundle val$rootHints;
                        public final /* synthetic */ int val$uid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, serviceCallbacks, str, Integer.valueOf(i2), Integer.valueOf(i3), bundle};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$callbacks = serviceCallbacks;
                            this.val$pkg = str;
                            this.val$pid = i2;
                            this.val$uid = i3;
                            this.val$rootHints = bundle;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                IBinder asBinder = this.val$callbacks.asBinder();
                                this.this$1.this$0.mConnections.remove(asBinder);
                                ConnectionRecord connectionRecord = new ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                                MediaBrowserServiceCompat mediaBrowserServiceCompat = this.this$1.this$0;
                                mediaBrowserServiceCompat.mCurConnection = connectionRecord;
                                BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                                connectionRecord.root = onGetRoot;
                                MediaBrowserServiceCompat mediaBrowserServiceCompat2 = this.this$1.this$0;
                                mediaBrowserServiceCompat2.mCurConnection = null;
                                if (onGetRoot == null) {
                                    Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + this.val$pkg + " from service " + AnonymousClass1.class.getName());
                                    try {
                                        this.val$callbacks.onConnectFailed();
                                        return;
                                    } catch (RemoteException unused) {
                                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
                                        return;
                                    }
                                }
                                try {
                                    mediaBrowserServiceCompat2.mConnections.put(asBinder, connectionRecord);
                                    asBinder.linkToDeath(connectionRecord, 0);
                                    if (this.this$1.this$0.mSession != null) {
                                        this.val$callbacks.onConnect(connectionRecord.root.getRootId(), this.this$1.this$0.mSession, connectionRecord.root.getExtras());
                                    }
                                } catch (RemoteException unused2) {
                                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
                                    this.this$1.this$0.mConnections.remove(asBinder);
                                }
                            }
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
            }
        }

        public void disconnect(ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, serviceCallbacks) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceBinderImpl this$1;
                    public final /* synthetic */ ServiceCallbacks val$callbacks;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceCallbacks};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$callbacks = serviceCallbacks;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ConnectionRecord remove = this.this$1.this$0.mConnections.remove(this.val$callbacks.asBinder());
                            if (remove != null) {
                                remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                            }
                        }
                    }
                });
            }
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048579, this, str, resultReceiver, serviceCallbacks) == null) || TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ServiceBinderImpl this$1;
                public final /* synthetic */ ServiceCallbacks val$callbacks;
                public final /* synthetic */ String val$mediaId;
                public final /* synthetic */ ResultReceiver val$receiver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, serviceCallbacks, str, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$mediaId = str;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
                            return;
                        }
                        this.this$1.this$0.performLoadItem(this.val$mediaId, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, String str, int i2, int i3, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{serviceCallbacks, str, Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, i2, i3, bundle) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceBinderImpl this$1;
                    public final /* synthetic */ ServiceCallbacks val$callbacks;
                    public final /* synthetic */ int val$pid;
                    public final /* synthetic */ String val$pkg;
                    public final /* synthetic */ Bundle val$rootHints;
                    public final /* synthetic */ int val$uid;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceCallbacks, str, Integer.valueOf(i2), Integer.valueOf(i3), bundle};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$callbacks = serviceCallbacks;
                        this.val$pkg = str;
                        this.val$pid = i2;
                        this.val$uid = i3;
                        this.val$rootHints = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            IBinder asBinder = this.val$callbacks.asBinder();
                            this.this$1.this$0.mConnections.remove(asBinder);
                            ConnectionRecord connectionRecord = new ConnectionRecord(this.this$1.this$0, this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                            this.this$1.this$0.mConnections.put(asBinder, connectionRecord);
                            try {
                                asBinder.linkToDeath(connectionRecord, 0);
                            } catch (RemoteException unused) {
                                Log.w(MediaBrowserServiceCompat.TAG, "IBinder is already dead.");
                            }
                        }
                    }
                });
            }
        }

        public void removeSubscription(String str, IBinder iBinder, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, str, iBinder, serviceCallbacks) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, iBinder) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceBinderImpl this$1;
                    public final /* synthetic */ ServiceCallbacks val$callbacks;
                    public final /* synthetic */ String val$id;
                    public final /* synthetic */ IBinder val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceCallbacks, str, iBinder};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$callbacks = serviceCallbacks;
                        this.val$id = str;
                        this.val$token = iBinder;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                            if (connectionRecord == null) {
                                Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + this.val$id);
                            } else if (this.this$1.this$0.removeSubscription(this.val$id, connectionRecord, this.val$token)) {
                            } else {
                                Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + this.val$id + " which is not subscribed");
                            }
                        }
                    }
                });
            }
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, bundle, resultReceiver, serviceCallbacks) == null) || TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, bundle, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ServiceBinderImpl this$1;
                public final /* synthetic */ ServiceCallbacks val$callbacks;
                public final /* synthetic */ Bundle val$extras;
                public final /* synthetic */ String val$query;
                public final /* synthetic */ ResultReceiver val$receiver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, serviceCallbacks, str, bundle, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$query = str;
                    this.val$extras = bundle;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.TAG, "search for callback that isn't registered query=" + this.val$query);
                            return;
                        }
                        this.this$1.this$0.performSearch(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLLL(1048583, this, str, bundle, resultReceiver, serviceCallbacks) == null) || TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks, str, bundle, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ServiceBinderImpl this$1;
                public final /* synthetic */ String val$action;
                public final /* synthetic */ ServiceCallbacks val$callbacks;
                public final /* synthetic */ Bundle val$extras;
                public final /* synthetic */ ResultReceiver val$receiver;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, serviceCallbacks, str, bundle, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$1 = this;
                    this.val$callbacks = serviceCallbacks;
                    this.val$action = str;
                    this.val$extras = bundle;
                    this.val$receiver = resultReceiver;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ConnectionRecord connectionRecord = this.this$1.this$0.mConnections.get(this.val$callbacks.asBinder());
                        if (connectionRecord == null) {
                            Log.w(MediaBrowserServiceCompat.TAG, "sendCustomAction for callback that isn't registered action=" + this.val$action + ", extras=" + this.val$extras);
                            return;
                        }
                        this.this$1.this$0.performCustomAction(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
                    }
                }
            });
        }

        public void unregisterCallbacks(ServiceCallbacks serviceCallbacks) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, serviceCallbacks) == null) {
                this.this$0.mHandler.postOrRun(new Runnable(this, serviceCallbacks) { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ServiceBinderImpl this$1;
                    public final /* synthetic */ ServiceCallbacks val$callbacks;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, serviceCallbacks};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$callbacks = serviceCallbacks;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder asBinder;
                        ConnectionRecord remove;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (remove = this.this$1.this$0.mConnections.remove((asBinder = this.val$callbacks.asBinder()))) == null) {
                            return;
                        }
                        asBinder.unlinkToDeath(remove, 0);
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public static class ServiceCallbacksCompat implements ServiceCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Messenger mCallbacks;

        public ServiceCallbacksCompat(Messenger messenger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messenger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallbacks = messenger;
        }

        private void sendRequest(int i2, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65537, this, i2, bundle) == null) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.arg1 = 2;
                obtain.setData(bundle);
                this.mCallbacks.send(obtain);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCallbacks.getBinder() : (IBinder) invokeV.objValue;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, token, bundle) == null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                Bundle bundle2 = new Bundle();
                bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
                bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
                sendRequest(1, bundle2);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                sendRequest(2, null);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, list, bundle, bundle2) == null) {
                Bundle bundle3 = new Bundle();
                bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
                bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
                bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
                if (list != null) {
                    bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
                }
                sendRequest(3, bundle3);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ServiceHandler extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ServiceBinderImpl mServiceBinderImpl;
        public final /* synthetic */ MediaBrowserServiceCompat this$0;

        public ServiceHandler(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserServiceCompat;
            this.mServiceBinderImpl = new ServiceBinderImpl(this.this$0);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Bundle data = message.getData();
                switch (message.what) {
                    case 1:
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle);
                        this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 2:
                        this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 3:
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.ensureClassLoader(bundle2);
                        this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 4:
                        this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 5:
                        this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 6:
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.ensureClassLoader(bundle3);
                        this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                        return;
                    case 7:
                        this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 8:
                        Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle4);
                        this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                        return;
                    case 9:
                        Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                        MediaSessionCompat.ensureClassLoader(bundle5);
                        this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                        return;
                    default:
                        Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                        return;
                }
            }
        }

        public void postOrRun(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                if (Thread.currentThread() == getLooper().getThread()) {
                    runnable.run();
                } else {
                    post(runnable);
                }
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, message, j)) == null) {
                Bundle data = message.getData();
                data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
                data.putInt("data_calling_uid", Binder.getCallingUid());
                data.putInt("data_calling_pid", Binder.getCallingPid());
                return super.sendMessageAtTime(message, j);
            }
            return invokeLJ.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1586189325, "Landroidx/media/MediaBrowserServiceCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1586189325, "Landroidx/media/MediaBrowserServiceCompat;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserServiceCompat() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mConnections = new ArrayMap<>();
        this.mHandler = new ServiceHandler(this);
    }

    public void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, connectionRecord, iBinder, bundle) == null) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            for (Pair<IBinder, Bundle> pair : list) {
                if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                    return;
                }
            }
            list.add(new Pair<>(iBinder, bundle));
            connectionRecord.subscriptions.put(str, list);
            performLoadChildren(str, connectionRecord, bundle, null);
            this.mCurConnection = connectionRecord;
            onSubscribe(str, bundle);
            this.mCurConnection = null;
        }
    }

    public List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, bundle)) == null) {
            if (list == null) {
                return null;
            }
            int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
            int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
            if (i2 == -1 && i3 == -1) {
                return list;
            }
            int i4 = i3 * i2;
            int i5 = i4 + i3;
            if (i2 >= 0 && i3 >= 1 && i4 < list.size()) {
                if (i5 > list.size()) {
                    i5 = list.size();
                }
                return list.subList(i4, i5);
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            attachBaseContext(context);
        }
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fileDescriptor, printWriter, strArr) == null) {
        }
    }

    public final Bundle getBrowserRootHints() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mImpl.getBrowserRootHints() : (Bundle) invokeV.objValue;
    }

    @NonNull
    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImpl.getCurrentBrowserInfo() : (MediaSessionManager.RemoteUserInfo) invokeV.objValue;
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSession : (MediaSessionCompat.Token) invokeV.objValue;
    }

    public boolean isValidPackage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            if (str == null) {
                return false;
            }
            for (String str2 : getPackageManager().getPackagesForUid(i2)) {
                if (str2.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void notifyChildrenChanged(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (str != null) {
                this.mImpl.notifyChildrenChanged(str, null);
                return;
            }
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, intent)) == null) ? this.mImpl.onBind(intent) : (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onCreate();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                this.mImpl = new MediaBrowserServiceImplApi28(this);
            } else if (i2 >= 26) {
                this.mImpl = new MediaBrowserServiceImplApi26(this);
            } else if (i2 >= 23) {
                this.mImpl = new MediaBrowserServiceImplApi23(this);
            } else if (i2 >= 21) {
                this.mImpl = new MediaBrowserServiceImplApi21(this);
            } else {
                this.mImpl = new MediaBrowserServiceImplBase(this);
            }
            this.mImpl.onCreate();
        }
    }

    public void onCustomAction(@NonNull String str, Bundle bundle, @NonNull Result<Bundle> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, bundle, result) == null) {
            result.sendError(null);
        }
    }

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i2, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, result, bundle) == null) {
            result.setFlags(1);
            onLoadChildren(str, result);
        }
    }

    public void onLoadItem(String str, @NonNull Result<MediaBrowserCompat.MediaItem> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, result) == null) {
            result.setFlags(2);
            result.sendResult(null);
        }
    }

    public void onSearch(@NonNull String str, Bundle bundle, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, bundle, result) == null) {
            result.setFlags(4);
            result.sendResult(null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, bundle) == null) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048597, this, str, bundle, connectionRecord, resultReceiver) == null) {
            Result<Bundle> result = new Result<Bundle>(this, str, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserServiceCompat this$0;
                public final /* synthetic */ ResultReceiver val$receiver;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$receiver = resultReceiver;
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onErrorSent(Bundle bundle2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bundle2) == null) {
                        this.val$receiver.send(-1, bundle2);
                    }
                }

                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onProgressUpdateSent(Bundle bundle2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle2) == null) {
                        this.val$receiver.send(1, bundle2);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onResultSent(Bundle bundle2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle2) == null) {
                        this.val$receiver.send(0, bundle2);
                    }
                }
            };
            this.mCurConnection = connectionRecord;
            onCustomAction(str, bundle, result);
            this.mCurConnection = null;
            if (result.isDone()) {
                return;
            }
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048598, this, str, connectionRecord, bundle, bundle2) == null) {
            Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, str, connectionRecord, str, bundle, bundle2) { // from class: androidx.media.MediaBrowserServiceCompat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserServiceCompat this$0;
                public final /* synthetic */ ConnectionRecord val$connection;
                public final /* synthetic */ Bundle val$notifyChildrenChangedOptions;
                public final /* synthetic */ String val$parentId;
                public final /* synthetic */ Bundle val$subscribeOptions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, connectionRecord, str, bundle, bundle2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$connection = connectionRecord;
                    this.val$parentId = str;
                    this.val$subscribeOptions = bundle;
                    this.val$notifyChildrenChangedOptions = bundle2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if (this.this$0.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
                            if (MediaBrowserServiceCompat.DEBUG) {
                                Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
                                return;
                            }
                            return;
                        }
                        if ((getFlags() & 1) != 0) {
                            list = this.this$0.applyOptions(list, this.val$subscribeOptions);
                        }
                        try {
                            this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$subscribeOptions, this.val$notifyChildrenChangedOptions);
                        } catch (RemoteException unused) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
                        }
                    }
                }
            };
            this.mCurConnection = connectionRecord;
            if (bundle == null) {
                onLoadChildren(str, result);
            } else {
                onLoadChildren(str, result, bundle);
            }
            this.mCurConnection = null;
            if (result.isDone()) {
                return;
            }
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    public void performLoadItem(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, str, connectionRecord, resultReceiver) == null) {
            Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(this, str, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserServiceCompat this$0;
                public final /* synthetic */ ResultReceiver val$receiver;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$receiver = resultReceiver;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaItem) == null) {
                        if ((getFlags() & 2) != 0) {
                            this.val$receiver.send(-1, null);
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                        this.val$receiver.send(0, bundle);
                    }
                }
            };
            this.mCurConnection = connectionRecord;
            onLoadItem(str, result);
            this.mCurConnection = null;
            if (result.isDone()) {
                return;
            }
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    public void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, str, bundle, connectionRecord, resultReceiver) == null) {
            Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(this, str, resultReceiver) { // from class: androidx.media.MediaBrowserServiceCompat.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserServiceCompat this$0;
                public final /* synthetic */ ResultReceiver val$receiver;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, resultReceiver};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super(newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$receiver = resultReceiver;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                        if ((getFlags() & 4) == 0 && list != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                            this.val$receiver.send(0, bundle2);
                            return;
                        }
                        this.val$receiver.send(-1, null);
                    }
                }
            };
            this.mCurConnection = connectionRecord;
            onSearch(str, bundle, result);
            this.mCurConnection = null;
            if (result.isDone()) {
                return;
            }
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    public boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048601, this, str, connectionRecord, iBinder)) == null) {
            boolean z = false;
            try {
                if (iBinder == null) {
                    return connectionRecord.subscriptions.remove(str) != null;
                }
                List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
                if (list != null) {
                    Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == it.next().first) {
                            it.remove();
                            z = true;
                        }
                    }
                    if (list.size() == 0) {
                        connectionRecord.subscriptions.remove(str);
                    }
                }
                return z;
            } finally {
                this.mCurConnection = connectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = null;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, token) == null) {
            if (token != null) {
                if (this.mSession == null) {
                    this.mSession = token;
                    this.mImpl.setSessionToken(token);
                    return;
                }
                throw new IllegalStateException("The session token has already been set.");
            }
            throw new IllegalArgumentException("Session token may not be null.");
        }
    }

    public void notifyChildrenChanged(@NonNull String str, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, bundle) == null) {
            if (str == null) {
                throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
            }
            if (bundle != null) {
                this.mImpl.notifyChildrenChanged(str, bundle);
                return;
            }
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@NonNull MediaSessionManager.RemoteUserInfo remoteUserInfo, @NonNull String str, @NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, remoteUserInfo, str, bundle) == null) {
            if (remoteUserInfo == null) {
                throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
            }
            if (str == null) {
                throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
            }
            if (bundle != null) {
                this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
                return;
            }
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
    }
}
