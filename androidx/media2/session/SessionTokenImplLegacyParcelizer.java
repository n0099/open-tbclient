package androidx.media2.session;

import android.content.ComponentName;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SessionTokenImplLegacyParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SessionTokenImplLegacyParcelizer() {
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

    public static SessionTokenImplLegacy read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            SessionTokenImplLegacy sessionTokenImplLegacy = new SessionTokenImplLegacy();
            sessionTokenImplLegacy.mLegacyTokenBundle = versionedParcel.readBundle(sessionTokenImplLegacy.mLegacyTokenBundle, 1);
            sessionTokenImplLegacy.mUid = versionedParcel.readInt(sessionTokenImplLegacy.mUid, 2);
            sessionTokenImplLegacy.mType = versionedParcel.readInt(sessionTokenImplLegacy.mType, 3);
            sessionTokenImplLegacy.mComponentName = (ComponentName) versionedParcel.readParcelable(sessionTokenImplLegacy.mComponentName, 4);
            sessionTokenImplLegacy.mPackageName = versionedParcel.readString(sessionTokenImplLegacy.mPackageName, 5);
            sessionTokenImplLegacy.mExtras = versionedParcel.readBundle(sessionTokenImplLegacy.mExtras, 6);
            sessionTokenImplLegacy.onPostParceling();
            return sessionTokenImplLegacy;
        }
        return (SessionTokenImplLegacy) invokeL.objValue;
    }

    public static void write(SessionTokenImplLegacy sessionTokenImplLegacy, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, sessionTokenImplLegacy, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            sessionTokenImplLegacy.onPreParceling(versionedParcel.isStream());
            versionedParcel.writeBundle(sessionTokenImplLegacy.mLegacyTokenBundle, 1);
            versionedParcel.writeInt(sessionTokenImplLegacy.mUid, 2);
            versionedParcel.writeInt(sessionTokenImplLegacy.mType, 3);
            versionedParcel.writeParcelable(sessionTokenImplLegacy.mComponentName, 4);
            versionedParcel.writeString(sessionTokenImplLegacy.mPackageName, 5);
            versionedParcel.writeBundle(sessionTokenImplLegacy.mExtras, 6);
        }
    }
}
