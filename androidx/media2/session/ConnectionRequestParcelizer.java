package androidx.media2.session;

import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ConnectionRequestParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ConnectionRequestParcelizer() {
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

    public static ConnectionRequest read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            ConnectionRequest connectionRequest = new ConnectionRequest();
            connectionRequest.mVersion = versionedParcel.readInt(connectionRequest.mVersion, 0);
            connectionRequest.mPackageName = versionedParcel.readString(connectionRequest.mPackageName, 1);
            connectionRequest.mPid = versionedParcel.readInt(connectionRequest.mPid, 2);
            connectionRequest.mConnectionHints = versionedParcel.readBundle(connectionRequest.mConnectionHints, 3);
            return connectionRequest;
        }
        return (ConnectionRequest) invokeL.objValue;
    }

    public static void write(ConnectionRequest connectionRequest, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, connectionRequest, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeInt(connectionRequest.mVersion, 0);
            versionedParcel.writeString(connectionRequest.mPackageName, 1);
            versionedParcel.writeInt(connectionRequest.mPid, 2);
            versionedParcel.writeBundle(connectionRequest.mConnectionHints, 3);
        }
    }
}
