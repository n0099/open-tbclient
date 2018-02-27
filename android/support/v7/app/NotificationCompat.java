package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NotificationCompat extends android.support.v4.app.NotificationCompat {

    /* loaded from: classes2.dex */
    public static class DecoratedCustomViewStyle extends NotificationCompat.Style {
    }

    /* loaded from: classes2.dex */
    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
    }

    public static MediaSessionCompat.Token getMediaSession(Notification notification) {
        Bundle extras = getExtras(notification);
        if (extras != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return MediaSessionCompat.Token.fromToken(parcelable);
                }
            } else {
                IBinder binder = BundleCompat.getBinder(extras, android.support.v4.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (binder != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.writeStrongBinder(binder);
                    obtain.setDataPosition(0);
                    MediaSessionCompat.Token createFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(obtain);
                    obtain.recycle();
                    return createFromParcel;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            j.a(notificationBuilderWithBuilderAccessor);
        } else if (builder.mStyle instanceof DecoratedMediaCustomViewStyle) {
            j.b(notificationBuilderWithBuilderAccessor);
        } else if (!(builder.mStyle instanceof NotificationCompat.MessagingStyle)) {
            b(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RemoteViews b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            i.a(notificationBuilderWithBuilderAccessor, mediaStyle.DG, mediaStyle.yY != null ? mediaStyle.yY.getToken() : null);
            boolean z = builder.getContentView() != null;
            boolean z2 = z || ((Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT <= 23) && builder.getBigContentView() != null);
            if ((builder.mStyle instanceof DecoratedMediaCustomViewStyle) && z2) {
                RemoteViews a2 = k.a(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), (List) builder.mActions, mediaStyle.DG, false, (PendingIntent) null, z);
                if (z) {
                    k.a(builder.mContext, a2, builder.getContentView());
                }
                a(builder.mContext, a2, builder.getColor());
                return a2;
            }
            return null;
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            return a(builder);
        } else {
            return c(notificationBuilderWithBuilderAccessor, builder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RemoteViews c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof NotificationCompat.MessagingStyle) {
            a((NotificationCompat.MessagingStyle) builder.mStyle, notificationBuilderWithBuilderAccessor, builder);
        }
        return d(notificationBuilderWithBuilderAccessor, builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static NotificationCompat.MessagingStyle.Message a(NotificationCompat.MessagingStyle messagingStyle) {
        List<NotificationCompat.MessagingStyle.Message> messages = messagingStyle.getMessages();
        for (int size = messages.size() - 1; size >= 0; size--) {
            NotificationCompat.MessagingStyle.Message message = messages.get(size);
            if (!TextUtils.isEmpty(message.getSender())) {
                return message;
            }
        }
        if (!messages.isEmpty()) {
            return messages.get(messages.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CharSequence a(NotificationCompat.Builder builder, NotificationCompat.MessagingStyle messagingStyle, NotificationCompat.MessagingStyle.Message message) {
        int i;
        CharSequence charSequence;
        BidiFormatter bidiFormatter = BidiFormatter.getInstance();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z = Build.VERSION.SDK_INT >= 21;
        int i2 = (z || Build.VERSION.SDK_INT <= 10) ? ViewCompat.MEASURED_STATE_MASK : -1;
        CharSequence sender = message.getSender();
        if (TextUtils.isEmpty(message.getSender())) {
            String userDisplayName = messagingStyle.getUserDisplayName() == null ? "" : messagingStyle.getUserDisplayName();
            if (z && builder.getColor() != 0) {
                i2 = builder.getColor();
            }
            CharSequence charSequence2 = userDisplayName;
            i = i2;
            charSequence = charSequence2;
        } else {
            i = i2;
            charSequence = sender;
        }
        CharSequence unicodeWrap = bidiFormatter.unicodeWrap(charSequence);
        spannableStringBuilder.append(unicodeWrap);
        spannableStringBuilder.setSpan(aD(i), spannableStringBuilder.length() - unicodeWrap.length(), spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "  ").append(bidiFormatter.unicodeWrap(message.getText() == null ? "" : message.getText()));
        return spannableStringBuilder;
    }

    private static TextAppearanceSpan aD(int i) {
        return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i), null);
    }

    private static void a(NotificationCompat.MessagingStyle messagingStyle, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<NotificationCompat.MessagingStyle.Message> messages = messagingStyle.getMessages();
        boolean z = messagingStyle.getConversationTitle() != null || j(messagingStyle.getMessages());
        for (int size = messages.size() - 1; size >= 0; size--) {
            NotificationCompat.MessagingStyle.Message message = messages.get(size);
            CharSequence a2 = z ? a(builder, messagingStyle, message) : message.getText();
            if (size != messages.size() - 1) {
                spannableStringBuilder.insert(0, (CharSequence) "\n");
            }
            spannableStringBuilder.insert(0, a2);
        }
        l.a(notificationBuilderWithBuilderAccessor, spannableStringBuilder);
    }

    private static boolean j(List<NotificationCompat.MessagingStyle.Message> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).getSender() == null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, NotificationCompat.Builder builder) {
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            boolean z = (builder.mStyle instanceof DecoratedMediaCustomViewStyle) && builder.getContentView() != null;
            RemoteViews a2 = k.a(notificationBuilderWithBuilderAccessor, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.mActions, mediaStyle.DG, mediaStyle.DH, mediaStyle.DI, z);
            if (z) {
                k.a(builder.mContext, a2, builder.getContentView());
                return a2;
            }
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            return a(builder);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews contentView;
        if (builder.mStyle instanceof MediaStyle) {
            MediaStyle mediaStyle = (MediaStyle) builder.mStyle;
            if (builder.getBigContentView() != null) {
                contentView = builder.getBigContentView();
            } else {
                contentView = builder.getContentView();
            }
            boolean z = (builder.mStyle instanceof DecoratedMediaCustomViewStyle) && contentView != null;
            k.a(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, builder.mActions, mediaStyle.DH, mediaStyle.DI, z);
            if (z) {
                k.a(builder.mContext, notification.bigContentView, contentView);
            }
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            b(notification, builder);
        }
    }

    private static RemoteViews a(NotificationCompat.Builder builder) {
        if (builder.getContentView() == null) {
            return null;
        }
        RemoteViews a2 = k.a(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mNotification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, (ArrayList<NotificationCompat.Action>) null);
        k.a(builder.mContext, a2, builder.getContentView());
        return a2;
    }

    private static void b(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews bigContentView = builder.getBigContentView();
        if (bigContentView == null) {
            bigContentView = builder.getContentView();
        }
        if (bigContentView != null) {
            RemoteViews a2 = k.a(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, notification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder.mActions);
            k.a(builder.mContext, a2, bigContentView);
            notification.bigContentView = a2;
        }
    }

    private static void c(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews headsUpContentView = builder.getHeadsUpContentView();
        RemoteViews contentView = headsUpContentView != null ? headsUpContentView : builder.getContentView();
        if (headsUpContentView != null) {
            RemoteViews a2 = k.a(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, notification.icon, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), builder.getColor(), R.layout.notification_template_custom_big, false, builder.mActions);
            k.a(builder.mContext, a2, contentView);
            notification.headsUpContentView = a2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews contentView;
        if (builder.getBigContentView() != null) {
            contentView = builder.getBigContentView();
        } else {
            contentView = builder.getContentView();
        }
        if ((builder.mStyle instanceof DecoratedMediaCustomViewStyle) && contentView != null) {
            k.a(notification, builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, (List) builder.mActions, false, (PendingIntent) null, true);
            k.a(builder.mContext, notification.bigContentView, contentView);
            a(builder.mContext, notification.bigContentView, builder.getColor());
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            b(notification, builder);
        }
    }

    private static void a(Context context, RemoteViews remoteViews, int i) {
        if (i == 0) {
            i = context.getResources().getColor(R.color.notification_material_background_media_default_color);
        }
        remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Notification notification, NotificationCompat.Builder builder) {
        RemoteViews contentView;
        if (builder.getHeadsUpContentView() != null) {
            contentView = builder.getHeadsUpContentView();
        } else {
            contentView = builder.getContentView();
        }
        if ((builder.mStyle instanceof DecoratedMediaCustomViewStyle) && contentView != null) {
            notification.headsUpContentView = k.a(builder.mContext, builder.mContentTitle, builder.mContentText, builder.mContentInfo, builder.mNumber, builder.mLargeIcon, builder.mSubText, builder.mUseChronometer, builder.getWhenIfShowing(), builder.getPriority(), 0, (List) builder.mActions, false, (PendingIntent) null, true);
            k.a(builder.mContext, notification.headsUpContentView, contentView);
            a(builder.mContext, notification.headsUpContentView, builder.getColor());
        } else if (builder.mStyle instanceof DecoratedCustomViewStyle) {
            c(notification, builder);
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder extends NotificationCompat.Builder {
        public Builder(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.app.NotificationCompat.Builder
        @RestrictTo
        public CharSequence resolveText() {
            if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
                NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle) this.mStyle;
                NotificationCompat.MessagingStyle.Message a = NotificationCompat.a(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (a != null) {
                    if (conversationTitle != null) {
                        return NotificationCompat.a(this, messagingStyle, a);
                    }
                    return a.getText();
                }
            }
            return super.resolveText();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.app.NotificationCompat.Builder
        @RestrictTo
        public CharSequence resolveTitle() {
            if (this.mStyle instanceof NotificationCompat.MessagingStyle) {
                NotificationCompat.MessagingStyle messagingStyle = (NotificationCompat.MessagingStyle) this.mStyle;
                NotificationCompat.MessagingStyle.Message a = NotificationCompat.a(messagingStyle);
                CharSequence conversationTitle = messagingStyle.getConversationTitle();
                if (conversationTitle != null || a != null) {
                    if (conversationTitle == null) {
                        return a.getSender();
                    }
                    return conversationTitle;
                }
            }
            return super.resolveTitle();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.app.NotificationCompat.Builder
        @RestrictTo
        public NotificationCompat.BuilderExtender getExtender() {
            if (Build.VERSION.SDK_INT >= 24) {
                return new a();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return new d();
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return new c();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return new b();
            }
            return super.getExtender();
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends NotificationCompat.BuilderExtender {
        b() {
        }

        @Override // android.support.v4.app.NotificationCompat.BuilderExtender
        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews d = NotificationCompat.d(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (d != null) {
                build.contentView = d;
            } else if (builder.getContentView() != null) {
                build.contentView = builder.getContentView();
            }
            return build;
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends NotificationCompat.BuilderExtender {
        c() {
        }

        @Override // android.support.v4.app.NotificationCompat.BuilderExtender
        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews c = NotificationCompat.c(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (c != null) {
                build.contentView = c;
            }
            NotificationCompat.a(build, builder);
            return build;
        }
    }

    /* loaded from: classes2.dex */
    private static class d extends NotificationCompat.BuilderExtender {
        d() {
        }

        @Override // android.support.v4.app.NotificationCompat.BuilderExtender
        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            RemoteViews b = NotificationCompat.b(notificationBuilderWithBuilderAccessor, builder);
            Notification build = notificationBuilderWithBuilderAccessor.build();
            if (b != null) {
                build.contentView = b;
            }
            NotificationCompat.d(build, builder);
            NotificationCompat.e(build, builder);
            return build;
        }
    }

    /* loaded from: classes2.dex */
    private static class a extends NotificationCompat.BuilderExtender {
        private a() {
        }

        @Override // android.support.v4.app.NotificationCompat.BuilderExtender
        public Notification build(NotificationCompat.Builder builder, NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            NotificationCompat.a(notificationBuilderWithBuilderAccessor, builder);
            return notificationBuilderWithBuilderAccessor.build();
        }
    }

    /* loaded from: classes2.dex */
    public static class MediaStyle extends NotificationCompat.Style {
        int[] DG = null;
        boolean DH;
        PendingIntent DI;
        MediaSessionCompat.Token yY;

        public MediaStyle() {
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.DG = iArr;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.yY = token;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            this.DH = z;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.DI = pendingIntent;
            return this;
        }
    }
}
