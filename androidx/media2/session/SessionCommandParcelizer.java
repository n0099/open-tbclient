package androidx.media2.session;

import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SessionCommandParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionCommandParcelizer() {
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

    public static SessionCommand read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionCommand sessionCommand = new SessionCommand();
            sessionCommand.mCommandCode = versionedParcel.readInt(sessionCommand.mCommandCode, 1);
            sessionCommand.mCustomAction = versionedParcel.readString(sessionCommand.mCustomAction, 2);
            sessionCommand.mCustomExtras = versionedParcel.readBundle(sessionCommand.mCustomExtras, 3);
            return sessionCommand;
        }
        return (SessionCommand) invokeL.objValue;
    }

    public static void write(SessionCommand sessionCommand, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sessionCommand, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeInt(sessionCommand.mCommandCode, 1);
            versionedParcel.writeString(sessionCommand.mCustomAction, 2);
            versionedParcel.writeBundle(sessionCommand.mCustomExtras, 3);
        }
    }
}
