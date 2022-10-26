package androidx.media2.session;

import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SessionCommandGroupParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionCommandGroupParcelizer() {
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

    public static SessionCommandGroup read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionCommandGroup sessionCommandGroup = new SessionCommandGroup();
            sessionCommandGroup.mCommands = versionedParcel.readSet(sessionCommandGroup.mCommands, 1);
            return sessionCommandGroup;
        }
        return (SessionCommandGroup) invokeL.objValue;
    }

    public static void write(SessionCommandGroup sessionCommandGroup, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sessionCommandGroup, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeSet(sessionCommandGroup.mCommands, 1);
        }
    }
}
