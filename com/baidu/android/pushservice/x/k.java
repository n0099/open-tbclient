package com.baidu.android.pushservice.x;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushNotificationBuilder;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.ResourceManager;
/* loaded from: classes.dex */
public class k extends PushNotificationBuilder {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676452855, "Lcom/baidu/android/pushservice/x/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676452855, "Lcom/baidu/android/pushservice/x/k;");
        }
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final g a(Context context, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, context, i, str)) == null) ? new d().a(context, i, str) : (g) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification construct(Context context) {
        InterceptResult invokeL;
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            g a2 = a(context, this.mNotificationBuilderId, this.mNotificationBuilderRes);
            Notification.Builder builder = new Notification.Builder(context);
            if (a2 != null) {
                a2.d(this.mNotificationTitle);
                a2.a(this.mNotificationText);
                a2.b(this.mLargeIconUrl);
                a2.c(this.mSummary);
            }
            int i2 = this.mNotificationDefaults;
            if (i2 != 0) {
                builder.setDefaults(i2);
            }
            String str2 = this.mNotificationsound;
            if (str2 != null) {
                builder.setSound(Uri.parse(str2));
            }
            Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
            long[] jArr = this.mVibratePattern;
            if (jArr != null) {
                builder.setVibrate(jArr);
            }
            int i3 = this.mStatusbarIcon;
            if (i3 == 0) {
                if (context.getPackageName().equals("com.baidu.searchbox") || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                    try {
                        i3 = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", ResourceManager.DRAWABLE, context.getPackageName());
                    } catch (Throwable unused) {
                    }
                    if (i3 == 0) {
                        i3 = context.getApplicationInfo().icon;
                    }
                }
                i3 = 0;
                if (i3 == 0) {
                }
            }
            builder.setSmallIcon(i3);
            builder.setContentTitle(this.mNotificationTitle);
            builder.setContentText(this.mNotificationText);
            if (Build.VERSION.SDK_INT >= 21 && (i = this.mColor) != 0) {
                builder.setColor(i);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (a2 != null) {
                    str = a2.b();
                } else {
                    com.baidu.android.pushservice.a0.h.a(context, "com.baidu.android.pushservice.push", "云推送");
                    str = this.mChannelId;
                }
                builder.setChannelId(str);
            }
            if (Build.VERSION.SDK_INT < 26 || a2 == null) {
                a = true;
            } else {
                RemoteViews c = a2.c();
                if (c != null) {
                    if (a2.e()) {
                        builder.setCustomBigContentView(c);
                        builder.setContentTitle(a2.d);
                        builder.setContentText(a2.e);
                    } else {
                        builder.setCustomContentView(c);
                    }
                    a = false;
                } else {
                    a = true;
                }
                RemoteViews d = a2.d();
                if (d != null) {
                    builder.setCustomHeadsUpContentView(d);
                }
            }
            if (!TextUtils.isEmpty(this.mGroup) && Build.VERSION.SDK_INT >= 24) {
                builder.setGroup(this.mGroup);
            }
            Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
            if (build != null) {
                int i4 = this.mNotificationFlags;
                if (i4 != 0) {
                    build.flags = i4;
                } else {
                    build.flags = 16 | build.flags;
                }
            }
            return build;
        }
        return (Notification) invokeL.objValue;
    }
}
