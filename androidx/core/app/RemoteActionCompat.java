package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class RemoteActionCompat implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    public RemoteActionCompat(@NonNull IconCompat iconCompat, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull PendingIntent pendingIntent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iconCompat, charSequence, charSequence2, pendingIntent};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mIcon = (IconCompat) Preconditions.checkNotNull(iconCompat);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(charSequence);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(charSequence2);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    @NonNull
    @RequiresApi(26)
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction remoteAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, remoteAction)) == null) {
            Preconditions.checkNotNull(remoteAction);
            RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(remoteAction.getIcon()), remoteAction.getTitle(), remoteAction.getContentDescription(), remoteAction.getActionIntent());
            remoteActionCompat.setEnabled(remoteAction.isEnabled());
            if (Build.VERSION.SDK_INT >= 28) {
                remoteActionCompat.setShouldShowIcon(remoteAction.shouldShowIcon());
            }
            return remoteActionCompat;
        }
        return (RemoteActionCompat) invokeL.objValue;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mActionIntent : (PendingIntent) invokeV.objValue;
    }

    @NonNull
    public CharSequence getContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContentDescription : (CharSequence) invokeV.objValue;
    }

    @NonNull
    public IconCompat getIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIcon : (IconCompat) invokeV.objValue;
    }

    @NonNull
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mTitle : (CharSequence) invokeV.objValue;
    }

    public boolean isEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEnabled : invokeV.booleanValue;
    }

    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mEnabled = z;
        }
    }

    public void setShouldShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mShouldShowIcon = z;
        }
    }

    public boolean shouldShowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mShouldShowIcon : invokeV.booleanValue;
    }

    @NonNull
    @RequiresApi(26)
    public RemoteAction toRemoteAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RemoteAction remoteAction = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
            remoteAction.setEnabled(isEnabled());
            if (Build.VERSION.SDK_INT >= 28) {
                remoteAction.setShouldShowIcon(shouldShowIcon());
            }
            return remoteAction;
        }
        return (RemoteAction) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
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

    public RemoteActionCompat(@NonNull RemoteActionCompat remoteActionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {remoteActionCompat};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }
}
