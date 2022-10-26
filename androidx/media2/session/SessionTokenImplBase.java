package androidx.media2.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.SessionToken;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SessionTokenImplBase implements SessionToken.SessionTokenImpl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ComponentName mComponentName;
    public Bundle mExtras;
    public IBinder mISession;
    public String mPackageName;
    public String mServiceName;
    public int mType;
    public int mUid;

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public boolean isLegacySession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public SessionTokenImplBase() {
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

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public Object getBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mISession;
        }
        return invokeV.objValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public ComponentName getComponentName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mComponentName;
        }
        return (ComponentName) invokeV.objValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mExtras;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPackageName;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mServiceName;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.SessionToken.SessionTokenImpl
    public int getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mUid;
        }
        return invokeV.intValue;
    }

    public SessionTokenImplBase(int i, int i2, String str, IMediaSession iMediaSession, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), str, iMediaSession, bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUid = i;
        this.mType = i2;
        this.mPackageName = str;
        this.mServiceName = null;
        this.mComponentName = null;
        this.mISession = iMediaSession.asBinder();
        this.mExtras = bundle;
    }

    public SessionTokenImplBase(ComponentName componentName, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {componentName, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (componentName != null) {
            this.mComponentName = componentName;
            this.mPackageName = componentName.getPackageName();
            this.mServiceName = componentName.getClassName();
            this.mUid = i;
            this.mType = i2;
            this.mISession = null;
            this.mExtras = null;
            return;
        }
        throw new NullPointerException("serviceComponent shouldn't be null");
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof SessionTokenImplBase)) {
                return false;
            }
            SessionTokenImplBase sessionTokenImplBase = (SessionTokenImplBase) obj;
            if (this.mUid != sessionTokenImplBase.mUid || !TextUtils.equals(this.mPackageName, sessionTokenImplBase.mPackageName) || !TextUtils.equals(this.mServiceName, sessionTokenImplBase.mServiceName) || this.mType != sessionTokenImplBase.mType || !ObjectsCompat.equals(this.mISession, sessionTokenImplBase.mISession)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ObjectsCompat.hash(Integer.valueOf(this.mType), Integer.valueOf(this.mUid), this.mPackageName, this.mServiceName);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "SessionToken {pkg=" + this.mPackageName + " type=" + this.mType + " service=" + this.mServiceName + " IMediaSession=" + this.mISession + " extras=" + this.mExtras + "}";
        }
        return (String) invokeV.objValue;
    }
}
