package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    public static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    public static final String TAG = "MediaSessionManager";
    public transient /* synthetic */ FieldHolder $fh;
    public ContentResolver mContentResolver;
    public Context mContext;

    /* loaded from: classes.dex */
    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mPackageName;
        public int mPid;
        public int mUid;

        public RemoteUserInfoImplBase(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mPackageName = str;
            this.mPid = i2;
            this.mUid = i3;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RemoteUserInfoImplBase) {
                    RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
                    return TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mPid == remoteUserInfoImplBase.mPid && this.mUid == remoteUserInfoImplBase.mUid;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPid : invokeV.intValue;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUid : invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ObjectsCompat.hash(this.mPackageName, Integer.valueOf(this.mPid), Integer.valueOf(this.mUid)) : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-254574380, "Landroidx/media/MediaSessionManagerImplBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-254574380, "Landroidx/media/MediaSessionManagerImplBase;");
                return;
            }
        }
        DEBUG = MediaSessionManager.DEBUG;
    }

    public MediaSessionManagerImplBase(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
    }

    private boolean isPermissionGranted(MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, remoteUserInfoImpl, str)) == null) ? remoteUserInfoImpl.getPid() < 0 ? this.mContext.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0 : this.mContext.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0 : invokeLL.booleanValue;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public boolean isEnabledNotificationListener(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, remoteUserInfoImpl)) == null) {
            String string = Settings.Secure.getString(this.mContentResolver, "enabled_notification_listeners");
            if (string != null) {
                for (String str : string.split(":")) {
                    ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                    if (unflattenFromString != null && unflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, remoteUserInfoImpl)) == null) {
            try {
                if (this.mContext.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0).uid == remoteUserInfoImpl.getUid()) {
                    return isPermissionGranted(remoteUserInfoImpl, PERMISSION_STATUS_BAR_SERVICE) || isPermissionGranted(remoteUserInfoImpl, PERMISSION_MEDIA_CONTENT_CONTROL) || remoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(remoteUserInfoImpl);
                }
                if (DEBUG) {
                    Log.d("MediaSessionManager", "Package name " + remoteUserInfoImpl.getPackageName() + " doesn't match with the uid " + remoteUserInfoImpl.getUid());
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                if (DEBUG) {
                    Log.d("MediaSessionManager", "Package " + remoteUserInfoImpl.getPackageName() + " doesn't exist");
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
