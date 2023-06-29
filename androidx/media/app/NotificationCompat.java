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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NotificationCompat {

    /* loaded from: classes.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? R.layout.obfuscated_res_0x7f0d0714 : R.layout.obfuscated_res_0x7f0d0712;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() != null) {
                return R.layout.obfuscated_res_0x7f0d0719;
            }
            return super.getContentViewLayoutResource();
        }

        private void setBackgroundColor(RemoteViews remoteViews) {
            int color;
            if (this.mBuilder.getColor() != 0) {
                color = this.mBuilder.getColor();
            } else {
                color = this.mBuilder.mContext.getResources().getColor(R.color.obfuscated_res_0x7f0608f8);
            }
            remoteViews.setInt(R.id.obfuscated_res_0x7f092267, "setBackgroundColor", color);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
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

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews contentView;
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

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z;
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z2 = true;
            if (this.mBuilder.getContentView() != null) {
                z = true;
            } else {
                z = false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (!z && this.mBuilder.getBigContentView() == null) {
                    z2 = false;
                }
                if (z2) {
                    RemoteViews generateContentView = generateContentView();
                    if (z) {
                        buildIntoRemoteViews(generateContentView, this.mBuilder.getContentView());
                    }
                    setBackgroundColor(generateContentView);
                    return generateContentView;
                }
            } else {
                RemoteViews generateContentView2 = generateContentView();
                if (z) {
                    buildIntoRemoteViews(generateContentView2, this.mBuilder.getContentView());
                    return generateContentView2;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class MediaStyle extends NotificationCompat.Style {
        public static final int MAX_MEDIA_BUTTONS = 5;
        public static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        public int[] mActionsToShowInCompact = null;
        public PendingIntent mCancelButtonIntent;
        public boolean mShowCancelButton;
        public MediaSessionCompat.Token mToken;

        public int getBigContentViewLayoutResource(int i) {
            return i <= 3 ? R.layout.obfuscated_res_0x7f0d0713 : R.layout.obfuscated_res_0x7f0d0711;
        }

        public int getContentViewLayoutResource() {
            return R.layout.obfuscated_res_0x7f0d0718;
        }

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
            } else if (this.mShowCancelButton) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        @RequiresApi(21)
        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
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

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return generateBigContentView();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.mShowCancelButton = z;
            }
            return this;
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z;
            if (action.getActionIntent() == null) {
                z = true;
            } else {
                z = false;
            }
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), (int) R.layout.obfuscated_res_0x7f0d070f);
            remoteViews.setImageViewResource(R.id.obfuscated_res_0x7f09006b, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.obfuscated_res_0x7f09006b, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.obfuscated_res_0x7f09006b, action.getTitle());
            }
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
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

        public RemoteViews generateBigContentView() {
            int min = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(min), false);
            applyStandardTemplate.removeAllViews(R.id.obfuscated_res_0x7f0916d6);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    applyStandardTemplate.addView(R.id.obfuscated_res_0x7f0916d6, generateMediaActionButton(this.mBuilder.mActions.get(i)));
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f09052c, 0);
                applyStandardTemplate.setInt(R.id.obfuscated_res_0x7f09052c, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0008));
                applyStandardTemplate.setOnClickPendingIntent(R.id.obfuscated_res_0x7f09052c, this.mCancelButtonIntent);
            } else {
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f09052c, 8);
            }
            return applyStandardTemplate;
        }

        public RemoteViews generateContentView() {
            int min;
            RemoteViews applyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr == null) {
                min = 0;
            } else {
                min = Math.min(iArr.length, 3);
            }
            applyStandardTemplate.removeAllViews(R.id.obfuscated_res_0x7f0916d6);
            if (min > 0) {
                for (int i = 0; i < min; i++) {
                    if (i < size) {
                        applyStandardTemplate.addView(R.id.obfuscated_res_0x7f0916d6, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i])));
                    } else {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i), Integer.valueOf(size - 1)));
                    }
                }
            }
            if (this.mShowCancelButton) {
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f0909f6, 8);
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f09052c, 0);
                applyStandardTemplate.setOnClickPendingIntent(R.id.obfuscated_res_0x7f09052c, this.mCancelButtonIntent);
                applyStandardTemplate.setInt(R.id.obfuscated_res_0x7f09052c, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.obfuscated_res_0x7f0a0008));
            } else {
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f0909f6, 0);
                applyStandardTemplate.setViewVisibility(R.id.obfuscated_res_0x7f09052c, 8);
            }
            return applyStandardTemplate;
        }
    }
}
