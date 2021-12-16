package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes9.dex */
public class CustomPushNotificationBuilder extends PushNotificationBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLayoutIconDrawable;
    public int mLayoutIconId;
    public int mLayoutId;
    public int mLayoutTextId;
    public int mLayoutTitleId;

    public CustomPushNotificationBuilder(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLayoutId = i2;
        this.mLayoutIconId = i3;
        this.mLayoutTitleId = i4;
        this.mLayoutTextId = i5;
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
            this.mLayoutId = objectInputStream.readInt();
            this.mLayoutIconId = objectInputStream.readInt();
            this.mLayoutTitleId = objectInputStream.readInt();
            this.mLayoutTextId = objectInputStream.readInt();
            this.mLayoutIconDrawable = objectInputStream.readInt();
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
            objectOutputStream.writeInt(this.mLayoutId);
            objectOutputStream.writeInt(this.mLayoutIconId);
            objectOutputStream.writeInt(this.mLayoutTitleId);
            objectOutputStream.writeInt(this.mLayoutTextId);
            objectOutputStream.writeInt(this.mLayoutIconDrawable);
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
            long[] jArr = this.mVibratePattern;
            if (jArr != null) {
                builder.setVibrate(jArr);
            }
            int i4 = this.mStatusbarIcon;
            if (i4 != 0) {
                builder.setSmallIcon(i4);
            }
            if (this.mLayoutId != 0) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.mLayoutId);
                int i5 = this.mLayoutIconDrawable;
                if (i5 != 0) {
                    remoteViews.setImageViewResource(this.mLayoutIconId, i5);
                }
                String str2 = this.mNotificationTitle;
                if (str2 != null) {
                    remoteViews.setTextViewText(this.mLayoutTitleId, str2);
                }
                String str3 = this.mNotificationText;
                if (str3 != null) {
                    remoteViews.setTextViewText(this.mLayoutTextId, str3);
                }
                builder.setContent(remoteViews);
            } else {
                builder.setContentTitle(this.mNotificationTitle);
                builder.setContentText(this.mNotificationText);
            }
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
                com.baidu.android.pushservice.j.h.a(context, this.mChannelId, this.mChannelName);
                builder.setChannelId(this.mChannelId);
            }
            Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
            int i6 = this.mNotificationFlags;
            if (i6 != 0 && build != null) {
                build.flags = i6;
            }
            return build;
        }
        return (Notification) invokeL.objValue;
    }

    public void setLayoutDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.mLayoutIconDrawable = i2;
        }
    }
}
