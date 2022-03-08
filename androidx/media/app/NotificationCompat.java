package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.R$color;
import androidx.media.R$id;
import androidx.media.R$integer;
import androidx.media.R$layout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class NotificationCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DecoratedMediaCustomViewStyle() {
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

        private void setBackgroundColor(RemoteViews remoteViews) {
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, remoteViews) == null) {
                if (this.mBuilder.getColor() != 0) {
                    color = this.mBuilder.getColor();
                } else {
                    color = this.mBuilder.mContext.getResources().getColor(R$color.notification_material_background_media_default_color);
                }
                remoteViews.setInt(R$id.status_bar_latest_event_content, "setBackgroundColor", color);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, notificationBuilderWithBuilderAccessor) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
                } else {
                    super.apply(notificationBuilderWithBuilderAccessor);
                }
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 <= 3 ? R$layout.notification_template_big_media_narrow_custom : R$layout.notification_template_big_media_custom : invokeI.intValue;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBuilder.getContentView() != null ? R$layout.notification_template_media_custom : super.getContentViewLayoutResource() : invokeV.intValue;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            RemoteViews contentView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return null;
                }
                if (this.mBuilder.getBigContentView() != null) {
                    contentView = this.mBuilder.getBigContentView();
                } else {
                    contentView = this.mBuilder.getContentView();
                }
                if (contentView == null) {
                    return null;
                }
                RemoteViews generateBigContentView = generateBigContentView();
                buildIntoRemoteViews(generateBigContentView, contentView);
                if (Build.VERSION.SDK_INT >= 21) {
                    setBackgroundColor(generateBigContentView);
                }
                return generateBigContentView;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return null;
                }
                boolean z = true;
                boolean z2 = this.mBuilder.getContentView() != null;
                if (Build.VERSION.SDK_INT >= 21) {
                    if (!z2 && this.mBuilder.getBigContentView() == null) {
                        z = false;
                    }
                    if (z) {
                        RemoteViews generateContentView = generateContentView();
                        if (z2) {
                            buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
                        }
                        setBackgroundColor(generateContentView);
                        return generateContentView;
                    }
                } else {
                    RemoteViews generateContentView2 = generateContentView();
                    if (z2) {
                        buildIntoRemoteViews(generateContentView2, this.mBuilder.getContentView());
                        return generateContentView2;
                    }
                }
                return null;
            }
            return (RemoteViews) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            RemoteViews contentView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return null;
                }
                if (this.mBuilder.getHeadsUpContentView() != null) {
                    contentView = this.mBuilder.getHeadsUpContentView();
                } else {
                    contentView = this.mBuilder.getContentView();
                }
                if (contentView == null) {
                    return null;
                }
                RemoteViews generateBigContentView = generateBigContentView();
                buildIntoRemoteViews(generateBigContentView, contentView);
                if (Build.VERSION.SDK_INT >= 21) {
                    setBackgroundColor(generateBigContentView);
                }
                return generateBigContentView;
            }
            return (RemoteViews) invokeL.objValue;
        }
    }

    public NotificationCompat() {
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

    /* loaded from: classes.dex */
    public static class MediaStyle extends NotificationCompat.Style {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MAX_MEDIA_BUTTONS = 5;
        public static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] mActionsToShowInCompact;
        public PendingIntent mCancelButtonIntent;
        public boolean mShowCancelButton;
        public MediaSessionCompat.Token mToken;

        public MediaStyle() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mActionsToShowInCompact = null;
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, action)) == null) {
                boolean z = action.getActionIntent() == null;
                RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R$layout.notification_media_action);
                remoteViews.setImageViewResource(R$id.action0, action.getIcon());
                if (!z) {
                    remoteViews.setOnClickPendingIntent(R$id.action0, action.getActionIntent());
                }
                if (Build.VERSION.SDK_INT >= 15) {
                    remoteViews.setContentDescription(R$id.action0, action.getTitle());
                }
                return remoteViews;
            }
            return (RemoteViews) invokeL.objValue;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, notification)) == null) {
                Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
                if (extras != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        Parcelable parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                        if (parcelable != null) {
                            return MediaSessionCompat.Token.fromToken(parcelable);
                        }
                        return null;
                    }
                    IBinder binder = BundleCompat.getBinder(extras, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                    if (binder != null) {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeStrongBinder(binder);
                        obtain.setDataPosition(0);
                        MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
                        obtain.recycle();
                        return createFromParcel;
                    }
                    return null;
                }
                return null;
            }
            return (MediaSessionCompat.Token) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, notificationBuilderWithBuilderAccessor) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
                } else if (this.mShowCancelButton) {
                    notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
                }
            }
        }

        @RequiresApi(21)
        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaStyle)) == null) {
                int[] iArr = this.mActionsToShowInCompact;
                if (iArr != null) {
                    mediaStyle.setShowActionsInCompactView(iArr);
                }
                MediaSessionCompat.Token token = this.mToken;
                if (token != null) {
                    mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
                }
                return mediaStyle;
            }
            return (Notification.MediaStyle) invokeL.objValue;
        }

        public RemoteViews generateBigContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int min = Math.min(this.mBuilder.mActions.size(), 5);
                RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
                applyStandardTemplate.removeAllViews(R$id.media_actions);
                if (min > 0) {
                    for (int i2 = 0; i2 < min; i2++) {
                        applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i2)));
                    }
                }
                if (this.mShowCancelButton) {
                    applyStandardTemplate.setViewVisibility(R$id.cancel_action, 0);
                    applyStandardTemplate.setInt(R$id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
                    applyStandardTemplate.setOnClickPendingIntent(R$id.cancel_action, this.mCancelButtonIntent);
                } else {
                    applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
                }
                return applyStandardTemplate;
            }
            return (RemoteViews) invokeV.objValue;
        }

        public RemoteViews generateContentView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
                int size = this.mBuilder.mActions.size();
                int[] iArr = this.mActionsToShowInCompact;
                int min = iArr == null ? 0 : Math.min(iArr.length, 3);
                applyStandardTemplate.removeAllViews(R$id.media_actions);
                if (min > 0) {
                    for (int i2 = 0; i2 < min; i2++) {
                        if (i2 < size) {
                            applyStandardTemplate.addView(R$id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i2])));
                        } else {
                            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                        }
                    }
                }
                if (this.mShowCancelButton) {
                    applyStandardTemplate.setViewVisibility(R$id.end_padder, 8);
                    applyStandardTemplate.setViewVisibility(R$id.cancel_action, 0);
                    applyStandardTemplate.setOnClickPendingIntent(R$id.cancel_action, this.mCancelButtonIntent);
                    applyStandardTemplate.setInt(R$id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R$integer.cancel_button_image_alpha));
                } else {
                    applyStandardTemplate.setViewVisibility(R$id.end_padder, 0);
                    applyStandardTemplate.setViewVisibility(R$id.cancel_action, 8);
                }
                return applyStandardTemplate;
            }
            return (RemoteViews) invokeV.objValue;
        }

        public int getBigContentViewLayoutResource(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 <= 3 ? R$layout.notification_template_big_media_narrow : R$layout.notification_template_big_media : invokeI.intValue;
        }

        public int getContentViewLayoutResource() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R$layout.notification_template_media : invokeV.intValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return null;
                }
                return generateBigContentView();
            }
            return (RemoteViews) invokeL.objValue;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, notificationBuilderWithBuilderAccessor)) == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return null;
                }
                return generateContentView();
            }
            return (RemoteViews) invokeL.objValue;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pendingIntent)) == null) {
                this.mCancelButtonIntent = pendingIntent;
                return this;
            }
            return (MediaStyle) invokeL.objValue;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, token)) == null) {
                this.mToken = token;
                return this;
            }
            return (MediaStyle) invokeL.objValue;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iArr)) == null) {
                this.mActionsToShowInCompact = iArr;
                return this;
            }
            return (MediaStyle) invokeL.objValue;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                if (Build.VERSION.SDK_INT < 21) {
                    this.mShowCancelButton = z;
                }
                return this;
            }
            return (MediaStyle) invokeZ.objValue;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {builder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mActionsToShowInCompact = null;
            setBuilder(builder);
        }
    }
}
