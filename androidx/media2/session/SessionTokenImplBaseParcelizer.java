package androidx.media2.session;

import android.content.ComponentName;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SessionTokenImplBaseParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionTokenImplBaseParcelizer() {
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

    public static SessionTokenImplBase read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionTokenImplBase sessionTokenImplBase = new SessionTokenImplBase();
            sessionTokenImplBase.mUid = versionedParcel.readInt(sessionTokenImplBase.mUid, 1);
            sessionTokenImplBase.mType = versionedParcel.readInt(sessionTokenImplBase.mType, 2);
            sessionTokenImplBase.mPackageName = versionedParcel.readString(sessionTokenImplBase.mPackageName, 3);
            sessionTokenImplBase.mServiceName = versionedParcel.readString(sessionTokenImplBase.mServiceName, 4);
            sessionTokenImplBase.mISession = versionedParcel.readStrongBinder(sessionTokenImplBase.mISession, 5);
            sessionTokenImplBase.mComponentName = (ComponentName) versionedParcel.readParcelable(sessionTokenImplBase.mComponentName, 6);
            sessionTokenImplBase.mExtras = versionedParcel.readBundle(sessionTokenImplBase.mExtras, 7);
            return sessionTokenImplBase;
        }
        return (SessionTokenImplBase) invokeL.objValue;
    }

    public static void write(SessionTokenImplBase sessionTokenImplBase, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sessionTokenImplBase, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeInt(sessionTokenImplBase.mUid, 1);
            versionedParcel.writeInt(sessionTokenImplBase.mType, 2);
            versionedParcel.writeString(sessionTokenImplBase.mPackageName, 3);
            versionedParcel.writeString(sessionTokenImplBase.mServiceName, 4);
            versionedParcel.writeStrongBinder(sessionTokenImplBase.mISession, 5);
            versionedParcel.writeParcelable(sessionTokenImplBase.mComponentName, 6);
            versionedParcel.writeBundle(sessionTokenImplBase.mExtras, 7);
        }
    }
}
