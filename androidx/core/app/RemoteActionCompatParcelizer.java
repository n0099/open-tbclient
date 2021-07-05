package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RemoteActionCompatParcelizer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
            remoteActionCompat.mIcon = (IconCompat) versionedParcel.readVersionedParcelable(remoteActionCompat.mIcon, 1);
            remoteActionCompat.mTitle = versionedParcel.readCharSequence(remoteActionCompat.mTitle, 2);
            remoteActionCompat.mContentDescription = versionedParcel.readCharSequence(remoteActionCompat.mContentDescription, 3);
            remoteActionCompat.mActionIntent = (PendingIntent) versionedParcel.readParcelable(remoteActionCompat.mActionIntent, 4);
            remoteActionCompat.mEnabled = versionedParcel.readBoolean(remoteActionCompat.mEnabled, 5);
            remoteActionCompat.mShouldShowIcon = versionedParcel.readBoolean(remoteActionCompat.mShouldShowIcon, 6);
            return remoteActionCompat;
        }
        return (RemoteActionCompat) invokeL.objValue;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, remoteActionCompat, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeVersionedParcelable(remoteActionCompat.mIcon, 1);
            versionedParcel.writeCharSequence(remoteActionCompat.mTitle, 2);
            versionedParcel.writeCharSequence(remoteActionCompat.mContentDescription, 3);
            versionedParcel.writeParcelable(remoteActionCompat.mActionIntent, 4);
            versionedParcel.writeBoolean(remoteActionCompat.mEnabled, 5);
            versionedParcel.writeBoolean(remoteActionCompat.mShouldShowIcon, 6);
        }
    }
}
