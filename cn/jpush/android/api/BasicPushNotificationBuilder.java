package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
/* loaded from: classes3.dex */
public class BasicPushNotificationBuilder extends DefaultPushNotificationBuilder {
    protected Context a;
    public int notificationDefaults = -2;
    public int notificationFlags = 16;
    public int statusBarDrawable = cn.jpush.android.a.b;
    public String developerArg0 = "developerArg0";

    public BasicPushNotificationBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PushNotificationBuilder a(String str) {
        String[] split = str.split("_____");
        String str2 = split[0];
        BasicPushNotificationBuilder basicPushNotificationBuilder = "basic".equals(str2) ? new BasicPushNotificationBuilder(cn.jpush.android.a.e) : "custom".equals(str2) ? new CustomPushNotificationBuilder(cn.jpush.android.a.e) : new BasicPushNotificationBuilder(cn.jpush.android.a.e);
        basicPushNotificationBuilder.a(split);
        return basicPushNotificationBuilder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.notificationDefaults + "_____" + this.notificationFlags + "_____" + this.statusBarDrawable + "_____" + this.developerArg0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String[] strArr) {
        this.notificationDefaults = Integer.parseInt(strArr[1]);
        this.notificationFlags = Integer.parseInt(strArr[2]);
        this.statusBarDrawable = Integer.parseInt(strArr[3]);
        if (5 == strArr.length) {
            this.developerArg0 = strArr[4];
        }
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder, cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return this.developerArg0;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    @TargetApi(11)
    Notification getNotification(Notification.Builder builder) {
        if (this.notificationDefaults != -2) {
            builder.setDefaults(this.notificationDefaults);
        }
        builder.setSmallIcon(this.statusBarDrawable);
        Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        build.flags = this.notificationFlags | 1;
        return build;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    void resetNotificationParams(Notification notification) {
        notification.defaults = this.notificationDefaults;
        notification.flags = this.notificationFlags;
        notification.icon = this.statusBarDrawable;
    }

    @Override // cn.jpush.android.api.DefaultPushNotificationBuilder
    public String toString() {
        return "basic_____" + a();
    }
}
