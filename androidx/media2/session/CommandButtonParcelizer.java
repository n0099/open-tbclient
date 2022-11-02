package androidx.media2.session;

import androidx.annotation.RestrictTo;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class CommandButtonParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommandButtonParcelizer() {
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

    public static MediaSession.CommandButton read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            MediaSession.CommandButton commandButton = new MediaSession.CommandButton();
            commandButton.mCommand = (SessionCommand) versionedParcel.readVersionedParcelable(commandButton.mCommand, 1);
            commandButton.mIconResId = versionedParcel.readInt(commandButton.mIconResId, 2);
            commandButton.mDisplayName = versionedParcel.readCharSequence(commandButton.mDisplayName, 3);
            commandButton.mExtras = versionedParcel.readBundle(commandButton.mExtras, 4);
            commandButton.mEnabled = versionedParcel.readBoolean(commandButton.mEnabled, 5);
            return commandButton;
        }
        return (MediaSession.CommandButton) invokeL.objValue;
    }

    public static void write(MediaSession.CommandButton commandButton, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, commandButton, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(false, false);
            versionedParcel.writeVersionedParcelable(commandButton.mCommand, 1);
            versionedParcel.writeInt(commandButton.mIconResId, 2);
            versionedParcel.writeCharSequence(commandButton.mDisplayName, 3);
            versionedParcel.writeBundle(commandButton.mExtras, 4);
            versionedParcel.writeBoolean(commandButton.mEnabled, 5);
        }
    }
}
