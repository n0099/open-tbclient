package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class NotificationChannelCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    public static final int DEFAULT_LIGHT_COLOR = 0;
    public static final boolean DEFAULT_SHOW_BADGE = true;
    public transient /* synthetic */ FieldHolder $fh;
    public AudioAttributes mAudioAttributes;
    public boolean mBypassDnd;
    public boolean mCanBubble;
    public String mConversationId;
    public String mDescription;
    public String mGroupId;
    @NonNull
    public final String mId;
    public int mImportance;
    public boolean mImportantConversation;
    public int mLightColor;
    public boolean mLights;
    public int mLockscreenVisibility;
    public CharSequence mName;
    public String mParentId;
    public boolean mShowBadge;
    public Uri mSound;
    public boolean mVibrationEnabled;
    public long[] mVibrationPattern;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final NotificationChannelCompat mChannel;

        public Builder(@NonNull String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mChannel = new NotificationChannelCompat(str, i);
        }

        @NonNull
        public NotificationChannelCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mChannel;
            }
            return (NotificationChannelCompat) invokeV.objValue;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    NotificationChannelCompat notificationChannelCompat = this.mChannel;
                    notificationChannelCompat.mParentId = str;
                    notificationChannelCompat.mConversationId = str2;
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, uri, audioAttributes)) == null) {
                NotificationChannelCompat notificationChannelCompat = this.mChannel;
                notificationChannelCompat.mSound = uri;
                notificationChannelCompat.mAudioAttributes = audioAttributes;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mChannel.mDescription = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mChannel.mGroupId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setImportance(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                this.mChannel.mImportance = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder setLightColor(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.mChannel.mLightColor = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mChannel.mLights = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
                this.mChannel.mName = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setShowBadge(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
                this.mChannel.mShowBadge = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mChannel.mVibrationEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jArr)) == null) {
                NotificationChannelCompat notificationChannelCompat = this.mChannel;
                if (jArr != null && jArr.length > 0) {
                    z = true;
                } else {
                    z = false;
                }
                notificationChannelCompat.mVibrationEnabled = z;
                this.mChannel.mVibrationPattern = jArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public NotificationChannelCompat(@NonNull NotificationChannel notificationChannel) {
        this(notificationChannel.getId(), notificationChannel.getImportance());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {notificationChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mName = notificationChannel.getName();
        this.mDescription = notificationChannel.getDescription();
        this.mGroupId = notificationChannel.getGroup();
        this.mShowBadge = notificationChannel.canShowBadge();
        this.mSound = notificationChannel.getSound();
        this.mAudioAttributes = notificationChannel.getAudioAttributes();
        this.mLights = notificationChannel.shouldShowLights();
        this.mLightColor = notificationChannel.getLightColor();
        this.mVibrationEnabled = notificationChannel.shouldVibrate();
        this.mVibrationPattern = notificationChannel.getVibrationPattern();
        if (Build.VERSION.SDK_INT >= 30) {
            this.mParentId = notificationChannel.getParentChannelId();
            this.mConversationId = notificationChannel.getConversationId();
        }
        this.mBypassDnd = notificationChannel.canBypassDnd();
        this.mLockscreenVisibility = notificationChannel.getLockscreenVisibility();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mCanBubble = notificationChannel.canBubble();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImportantConversation = notificationChannel.isImportantConversation();
        }
    }

    public NotificationChannelCompat(@NonNull String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(str);
        this.mImportance = i;
        if (Build.VERSION.SDK_INT >= 21) {
            this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        }
    }

    public boolean canBubble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCanBubble;
        }
        return invokeV.booleanValue;
    }

    public boolean canBypassDnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBypassDnd;
        }
        return invokeV.booleanValue;
    }

    public boolean canShowBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mShowBadge;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mAudioAttributes;
        }
        return (AudioAttributes) invokeV.objValue;
    }

    @Nullable
    public String getConversationId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mConversationId;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDescription;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public String getGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mGroupId;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mId;
        }
        return (String) invokeV.objValue;
    }

    public int getImportance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mImportance;
        }
        return invokeV.intValue;
    }

    public int getLightColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mLightColor;
        }
        return invokeV.intValue;
    }

    public int getLockscreenVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mLockscreenVisibility;
        }
        return invokeV.intValue;
    }

    @Nullable
    public CharSequence getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mName;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public String getParentChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mParentId;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Uri getSound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mSound;
        }
        return (Uri) invokeV.objValue;
    }

    @Nullable
    public long[] getVibrationPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mVibrationPattern;
        }
        return (long[]) invokeV.objValue;
    }

    public boolean isImportantConversation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mImportantConversation;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldShowLights() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mLights;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldVibrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mVibrationEnabled;
        }
        return invokeV.booleanValue;
    }

    public NotificationChannel getNotificationChannel() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return null;
            }
            NotificationChannel notificationChannel = new NotificationChannel(this.mId, this.mName, this.mImportance);
            notificationChannel.setDescription(this.mDescription);
            notificationChannel.setGroup(this.mGroupId);
            notificationChannel.setShowBadge(this.mShowBadge);
            notificationChannel.setSound(this.mSound, this.mAudioAttributes);
            notificationChannel.enableLights(this.mLights);
            notificationChannel.setLightColor(this.mLightColor);
            notificationChannel.setVibrationPattern(this.mVibrationPattern);
            notificationChannel.enableVibration(this.mVibrationEnabled);
            if (Build.VERSION.SDK_INT >= 30 && (str = this.mParentId) != null && (str2 = this.mConversationId) != null) {
                notificationChannel.setConversationId(str, str2);
            }
            return notificationChannel;
        }
        return (NotificationChannel) invokeV.objValue;
    }

    @NonNull
    public Builder toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
        }
        return (Builder) invokeV.objValue;
    }
}
