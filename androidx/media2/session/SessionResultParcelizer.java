package androidx.media2.session;

import androidx.media2.common.MediaItem;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class SessionResultParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionResultParcelizer() {
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

    public static SessionResult read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionResult sessionResult = new SessionResult();
            sessionResult.mResultCode = versionedParcel.readInt(sessionResult.mResultCode, 1);
            sessionResult.mCompletionTime = versionedParcel.readLong(sessionResult.mCompletionTime, 2);
            sessionResult.mCustomCommandResult = versionedParcel.readBundle(sessionResult.mCustomCommandResult, 3);
            sessionResult.mParcelableItem = (MediaItem) versionedParcel.readVersionedParcelable(sessionResult.mParcelableItem, 4);
            sessionResult.onPostParceling();
            return sessionResult;
        }
        return (SessionResult) invokeL.objValue;
    }

    public static void write(SessionResult sessionResult, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sessionResult, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            sessionResult.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeInt(sessionResult.mResultCode, 1);
            versionedParcel.writeLong(sessionResult.mCompletionTime, 2);
            versionedParcel.writeBundle(sessionResult.mCustomCommandResult, 3);
            versionedParcel.writeVersionedParcelable(sessionResult.mParcelableItem, 4);
        }
    }
}
