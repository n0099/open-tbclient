package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes3.dex */
public class BasicPushNotificationBuilder extends PushNotificationBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BasicPushNotificationBuilder() {
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

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, objectInputStream) == null) {
            this.mStatusbarIcon = objectInputStream.readInt();
            this.mNotificationFlags = objectInputStream.readInt();
            this.mNotificationDefaults = objectInputStream.readInt();
            if (objectInputStream.readBoolean()) {
                this.mNotificationsound = (String) objectInputStream.readObject();
            }
            int readInt = objectInputStream.readInt();
            this.mVibratePattern = new long[readInt];
            for (int i2 = 0; i2 < readInt; i2++) {
                this.mVibratePattern[i2] = objectInputStream.readLong();
            }
            this.mNotificationTitle = (String) objectInputStream.readObject();
            this.mNotificationText = (String) objectInputStream.readObject();
            this.mChannelId = (String) objectInputStream.readObject();
            this.mChannelName = (String) objectInputStream.readObject();
            this.mLargeIcon = (Bitmap) objectInputStream.readObject();
            this.mColor = objectInputStream.readInt();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, objectOutputStream) == null) {
            objectOutputStream.writeInt(this.mStatusbarIcon);
            objectOutputStream.writeInt(this.mNotificationFlags);
            objectOutputStream.writeInt(this.mNotificationDefaults);
            int i2 = 0;
            if (this.mNotificationsound != null) {
                objectOutputStream.writeBoolean(true);
                objectOutputStream.writeObject(this.mNotificationsound);
            } else {
                objectOutputStream.writeBoolean(false);
            }
            long[] jArr = this.mVibratePattern;
            if (jArr != null) {
                objectOutputStream.writeInt(jArr.length);
                while (true) {
                    long[] jArr2 = this.mVibratePattern;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    objectOutputStream.writeLong(jArr2[i2]);
                    i2++;
                }
            } else {
                objectOutputStream.writeInt(0);
            }
            objectOutputStream.writeObject(this.mNotificationTitle);
            objectOutputStream.writeObject(this.mNotificationText);
            objectOutputStream.writeObject(this.mChannelId);
            objectOutputStream.writeObject(this.mChannelName);
            objectOutputStream.writeObject(this.mLargeIcon);
            objectOutputStream.writeInt(this.mColor);
        }
    }

    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    @SuppressLint({"NewApi"})
    public Notification construct(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Notification.Builder builder = new Notification.Builder(context);
            int i3 = this.mNotificationDefaults;
            if (i3 != 0) {
                builder.setDefaults(i3);
            }
            String str = this.mNotificationsound;
            if (str != null) {
                builder.setSound(Uri.parse(str));
            }
            Bitmap bitmap = this.mLargeIcon;
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
            long[] jArr = this.mVibratePattern;
            if (jArr != null) {
                builder.setVibrate(jArr);
            }
            int i4 = this.mStatusbarIcon;
            if (i4 == 0) {
                i4 = 0;
                if (context.getPackageName().equals("com.baidu.searchbox") || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                    try {
                        i4 = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", "drawable", context.getPackageName());
                    } catch (Throwable unused) {
                    }
                }
                if (i4 == 0) {
                    i4 = context.getApplicationInfo().icon;
                }
            }
            builder.setSmallIcon(i4);
            builder.setContentTitle(this.mNotificationTitle);
            builder.setContentText(this.mNotificationText);
            if (Build.VERSION.SDK_INT >= 21 && (i2 = this.mColor) != 0) {
                builder.setColor(i2);
            }
            if (m.p(context)) {
                if (TextUtils.isEmpty(this.mChannelId)) {
                    this.mChannelId = "com.baidu.android.pushservice.push";
                }
                if (TextUtils.isEmpty(this.mChannelName)) {
                    this.mChannelName = "云推送";
                }
                com.baidu.android.pushservice.i.h.a(context, this.mChannelId, this.mChannelName);
                builder.setChannelId(this.mChannelId);
            }
            Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
            if (build != null) {
                int i5 = this.mNotificationFlags;
                if (i5 == 0) {
                    i5 = build.flags | 16;
                }
                build.flags = i5;
            }
            return build;
        }
        return (Notification) invokeL.objValue;
    }
}
