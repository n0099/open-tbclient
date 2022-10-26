package androidx.media2.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
/* loaded from: classes.dex */
public final class SessionToken implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_SEND_TOKEN2_FOR_LEGACY_SESSION = 1000;
    public static final String TAG = "SessionToken";
    public static final int TYPE_BROWSER_SERVICE_LEGACY = 101;
    public static final int TYPE_LIBRARY_SERVICE = 2;
    public static final int TYPE_SESSION = 0;
    public static final int TYPE_SESSION_LEGACY = 100;
    public static final int TYPE_SESSION_SERVICE = 1;
    public static final long WAIT_TIME_MS_FOR_SESSION_READY = 300;
    public transient /* synthetic */ FieldHolder $fh;
    public SessionTokenImpl mImpl;

    /* loaded from: classes.dex */
    public interface OnSessionTokenCreatedListener {
        void onSessionTokenCreated(MediaSessionCompat.Token token, SessionToken sessionToken);
    }

    /* loaded from: classes.dex */
    public interface SessionTokenImpl extends VersionedParcelable {
        Object getBinder();

        ComponentName getComponentName();

        Bundle getExtras();

        String getPackageName();

        String getServiceName();

        int getType();

        int getUid();

        boolean isLegacySession();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TokenType {
    }

    public SessionToken() {
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

    public Object getBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImpl.getBinder();
        }
        return invokeV.objValue;
    }

    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.getComponentName();
        }
        return (ComponentName) invokeV.objValue;
    }

    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bundle extras = this.mImpl.getExtras();
            if (extras != null && !MediaUtils.doesBundleHaveCustomParcelable(extras)) {
                return new Bundle(extras);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getServiceName();
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImpl.getType();
        }
        return invokeV.intValue;
    }

    public int getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mImpl.getUid();
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImpl.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isLegacySession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mImpl.isLegacySession();
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mImpl.toString();
        }
        return (String) invokeV.objValue;
    }

    public SessionToken(Context context, ComponentName componentName) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, componentName};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context != null) {
            if (componentName != null) {
                PackageManager packageManager = context.getPackageManager();
                int uid = getUid(packageManager, componentName.getPackageName());
                if (isInterfaceDeclared(packageManager, MediaLibraryService.SERVICE_INTERFACE, componentName)) {
                    i = 2;
                } else if (isInterfaceDeclared(packageManager, MediaSessionService.SERVICE_INTERFACE, componentName)) {
                    i = 1;
                } else if (isInterfaceDeclared(packageManager, MediaBrowserServiceCompat.SERVICE_INTERFACE, componentName)) {
                    i = 101;
                } else {
                    throw new IllegalArgumentException(componentName + " doesn't implement none of MediaSessionService, MediaLibraryService, MediaBrowserService nor MediaBrowserServiceCompat. Use service's full name");
                }
                if (i != 101) {
                    this.mImpl = new SessionTokenImplBase(componentName, uid, i);
                    return;
                } else {
                    this.mImpl = new SessionTokenImplLegacy(componentName, uid);
                    return;
                }
            }
            throw new NullPointerException("serviceComponent shouldn't be null");
        }
        throw new NullPointerException("context shouldn't be null");
    }

    public SessionToken(SessionTokenImpl sessionTokenImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sessionTokenImpl};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImpl = sessionTokenImpl;
    }

    public static void quitHandlerThread(HandlerThread handlerThread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, handlerThread) == null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof SessionToken)) {
                return false;
            }
            return this.mImpl.equals(((SessionToken) obj).mImpl);
        }
        return invokeL.booleanValue;
    }

    public static MediaControllerCompat createMediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, token)) == null) {
            return new MediaControllerCompat(context, token);
        }
        return (MediaControllerCompat) invokeLL.objValue;
    }

    public static int getUid(PackageManager packageManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, packageManager, str)) == null) {
            try {
                return packageManager.getApplicationInfo(str, 0).uid;
            } catch (PackageManager.NameNotFoundException unused) {
                throw new IllegalArgumentException("Cannot find package " + str);
            }
        }
        return invokeLL.intValue;
    }

    public static void createSessionToken(Context context, MediaSessionCompat.Token token, OnSessionTokenCreatedListener onSessionTokenCreatedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, token, onSessionTokenCreatedListener) == null) {
            if (context != null) {
                if (token != null) {
                    if (onSessionTokenCreatedListener != null) {
                        VersionedParcelable session2Token = token.getSession2Token();
                        if (session2Token instanceof SessionToken) {
                            onSessionTokenCreatedListener.onSessionTokenCreated(token, (SessionToken) session2Token);
                            return;
                        }
                        MediaControllerCompat createMediaControllerCompat = createMediaControllerCompat(context, token);
                        String packageName = createMediaControllerCompat.getPackageName();
                        int uid = getUid(context.getPackageManager(), packageName);
                        HandlerThread handlerThread = new HandlerThread(TAG);
                        handlerThread.start();
                        Handler handler = new Handler(handlerThread.getLooper(), onSessionTokenCreatedListener, createMediaControllerCompat, token, packageName, uid, handlerThread) { // from class: androidx.media2.session.SessionToken.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaSessionCompat.Token val$compatToken;
                            public final /* synthetic */ MediaControllerCompat val$controller;
                            public final /* synthetic */ OnSessionTokenCreatedListener val$listener;
                            public final /* synthetic */ String val$packageName;
                            public final /* synthetic */ HandlerThread val$thread;
                            public final /* synthetic */ int val$uid;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r7);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {r7, onSessionTokenCreatedListener, createMediaControllerCompat, token, packageName, Integer.valueOf(uid), handlerThread};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super((Looper) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = onSessionTokenCreatedListener;
                                this.val$controller = createMediaControllerCompat;
                                this.val$compatToken = token;
                                this.val$packageName = packageName;
                                this.val$uid = uid;
                                this.val$thread = handlerThread;
                            }

                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                                    synchronized (this.val$listener) {
                                        if (message.what != 1000) {
                                            return;
                                        }
                                        this.val$controller.unregisterCallback((MediaControllerCompat.Callback) message.obj);
                                        SessionToken sessionToken = new SessionToken(new SessionTokenImplLegacy(this.val$compatToken, this.val$packageName, this.val$uid, this.val$controller.getSessionInfo()));
                                        this.val$compatToken.setSession2Token(sessionToken);
                                        this.val$listener.onSessionTokenCreated(this.val$compatToken, sessionToken);
                                        SessionToken.quitHandlerThread(this.val$thread);
                                    }
                                }
                            }
                        };
                        MediaControllerCompat.Callback callback = new MediaControllerCompat.Callback(onSessionTokenCreatedListener, handler, createMediaControllerCompat, token, packageName, uid, handlerThread) { // from class: androidx.media2.session.SessionToken.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ MediaSessionCompat.Token val$compatToken;
                            public final /* synthetic */ MediaControllerCompat val$controller;
                            public final /* synthetic */ Handler val$handler;
                            public final /* synthetic */ OnSessionTokenCreatedListener val$listener;
                            public final /* synthetic */ String val$packageName;
                            public final /* synthetic */ HandlerThread val$thread;
                            public final /* synthetic */ int val$uid;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {onSessionTokenCreatedListener, handler, createMediaControllerCompat, token, packageName, Integer.valueOf(uid), handlerThread};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$listener = onSessionTokenCreatedListener;
                                this.val$handler = handler;
                                this.val$controller = createMediaControllerCompat;
                                this.val$compatToken = token;
                                this.val$packageName = packageName;
                                this.val$uid = uid;
                                this.val$thread = handlerThread;
                            }

                            @Override // android.support.v4.media.session.MediaControllerCompat.Callback
                            public void onSessionReady() {
                                SessionToken sessionToken;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    synchronized (this.val$listener) {
                                        this.val$handler.removeMessages(1000);
                                        this.val$controller.unregisterCallback(this);
                                        if (this.val$compatToken.getSession2Token() instanceof SessionToken) {
                                            sessionToken = (SessionToken) this.val$compatToken.getSession2Token();
                                        } else {
                                            sessionToken = new SessionToken(new SessionTokenImplLegacy(this.val$compatToken, this.val$packageName, this.val$uid, this.val$controller.getSessionInfo()));
                                            this.val$compatToken.setSession2Token(sessionToken);
                                        }
                                        this.val$listener.onSessionTokenCreated(this.val$compatToken, sessionToken);
                                        SessionToken.quitHandlerThread(this.val$thread);
                                    }
                                }
                            }
                        };
                        synchronized (onSessionTokenCreatedListener) {
                            createMediaControllerCompat.registerCallback(callback, handler);
                            handler.sendMessageDelayed(handler.obtainMessage(1000, callback), 300L);
                        }
                        return;
                    }
                    throw new NullPointerException("listener shouldn't be null");
                }
                throw new NullPointerException("compatToken shouldn't be null");
            }
            throw new NullPointerException("context shouldn't be null");
        }
    }

    public static boolean isInterfaceDeclared(PackageManager packageManager, String str, ComponentName componentName) {
        InterceptResult invokeLLL;
        ServiceInfo serviceInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, packageManager, str, componentName)) == null) {
            Intent intent = new Intent(str);
            intent.setPackage(componentName.getPackageName());
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 128);
            if (queryIntentServices != null) {
                for (int i = 0; i < queryIntentServices.size(); i++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null && TextUtils.equals(serviceInfo.name, componentName.getClassName())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
