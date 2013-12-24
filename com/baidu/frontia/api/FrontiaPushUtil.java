package com.baidu.frontia.api;

import android.net.Uri;
import com.baidu.android.pushservice.internal.BasicPushNotificationBuilder;
import com.baidu.android.pushservice.internal.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.internal.PushNotificationBuilder;
import com.baidu.frontia.module.push.FrontiaPushUtilImpl;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FrontiaPushUtil {

    /* loaded from: classes.dex */
    public class AndroidContent {
        private FrontiaPushUtilImpl.AndroidContentImpl a;

        public AndroidContent() {
            this.a = new FrontiaPushUtilImpl.AndroidContentImpl();
        }

        AndroidContent(FrontiaPushUtilImpl.AndroidContentImpl androidContentImpl) {
            this.a = androidContentImpl;
        }

        FrontiaPushUtilImpl.AndroidContentImpl a() {
            return this.a;
        }

        public int getBuilderId() {
            return this.a.getBuilderId();
        }

        public DefaultNotificationStyle getNotificationStyle() {
            return new DefaultNotificationStyle(this.a.getNotificationStyle());
        }

        public String getPKGContent() {
            return this.a.getPKGContent();
        }

        public String getUrl() {
            return this.a.getUrl();
        }

        public void setBuilderId(int i) {
            this.a.setBuilderId(i);
        }

        public void setNotificationStyle(DefaultNotificationStyle defaultNotificationStyle) {
            this.a.setNotificationStyle(defaultNotificationStyle.a());
        }

        public void setPKGContent(String str) {
            this.a.setPKGContent(str);
        }

        public void setUrl(String str) {
            this.a.setUrl(str);
        }
    }

    /* loaded from: classes.dex */
    public class DefaultNotificationStyle {
        private FrontiaPushUtilImpl.DefaultNotificationStyleImpl a;

        public DefaultNotificationStyle() {
            this.a = new FrontiaPushUtilImpl.DefaultNotificationStyleImpl();
        }

        DefaultNotificationStyle(FrontiaPushUtilImpl.DefaultNotificationStyleImpl defaultNotificationStyleImpl) {
            this.a = defaultNotificationStyleImpl;
        }

        FrontiaPushUtilImpl.DefaultNotificationStyleImpl a() {
            return this.a;
        }

        public void disableAlert() {
            this.a.disableAlert();
        }

        public void disableDismissible() {
            this.a.disableDismissible();
        }

        public void disableVibration() {
            this.a.disableVibration();
        }

        public void enableAlert() {
            this.a.enableAlert();
        }

        public void enableDismissible() {
            this.a.enableDismissible();
        }

        public void enableVibration() {
            this.a.enableVibration();
        }

        public boolean isAlertEnabled() {
            return this.a.isAlertEnabled();
        }

        public boolean isDismissible() {
            return this.a.isDismissible();
        }

        public boolean isVibrationEnabled() {
            return this.a.isVibrationEnabled();
        }
    }

    /* loaded from: classes.dex */
    public enum DeployStatus {
        DEVELOPE,
        PRODUCTION
    }

    /* loaded from: classes.dex */
    public class FrontiaPushBasicNotificationBuilder extends a {
        private BasicPushNotificationBuilder a = new BasicPushNotificationBuilder();

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        PushNotificationBuilder a() {
            return this.a;
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationDefaults(int i) {
            this.a.setNotificationDefaults(i);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationFlags(int i) {
            this.a.setNotificationFlags(i);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationSound(Uri uri) {
            this.a.setNotificationSound(uri);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationText(String str) {
            this.a.setNotificationText(str);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationTitle(String str) {
            this.a.setNotificationTitle(str);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationVibrate(long[] jArr) {
            this.a.setNotificationVibrate(jArr);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setStatusbarIcon(int i) {
            this.a.setStatusbarIcon(i);
        }
    }

    /* loaded from: classes.dex */
    public class FrontiaPushCustomNotificationBuilder extends a {
        private CustomPushNotificationBuilder a;

        public FrontiaPushCustomNotificationBuilder(int i, int i2, int i3, int i4) {
            this.a = null;
            this.a = new CustomPushNotificationBuilder(i, i2, i3, i4);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        PushNotificationBuilder a() {
            return this.a;
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationDefaults(int i) {
            this.a.setNotificationDefaults(i);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationFlags(int i) {
            this.a.setNotificationFlags(i);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationSound(Uri uri) {
            this.a.setNotificationSound(uri);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationText(String str) {
            this.a.setNotificationText(str);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationTitle(String str) {
            this.a.setNotificationTitle(str);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setNotificationVibrate(long[] jArr) {
            this.a.setNotificationVibrate(jArr);
        }

        @Override // com.baidu.frontia.api.FrontiaPushUtil.a
        public void setStatusbarIcon(int i) {
            this.a.setStatusbarIcon(i);
        }
    }

    /* loaded from: classes.dex */
    public class IOSContent {
        private FrontiaPushUtilImpl.IOSContentImpl a;

        public IOSContent() {
            this.a = new FrontiaPushUtilImpl.IOSContentImpl();
        }

        IOSContent(FrontiaPushUtilImpl.IOSContentImpl iOSContentImpl) {
            this.a = iOSContentImpl;
        }

        FrontiaPushUtilImpl.IOSContentImpl a() {
            return this.a;
        }

        public String getAlertMsg() {
            return this.a.getAlertMsg();
        }

        public int getBadge() {
            return this.a.getBadge();
        }

        public String getSoundFile() {
            return this.a.getSoundFile();
        }

        public void setAlertMsg(String str) {
            this.a.setAlertMsg(str);
        }

        public void setBadge(int i) {
            this.a.setBadge(i);
        }

        public void setSoundFile(String str) {
            this.a.setSoundFile(str);
        }
    }

    /* loaded from: classes.dex */
    public class MessageContent {
        private FrontiaPushUtilImpl.MessageContentImpl a;
        private int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MessageContent(FrontiaPushUtilImpl.MessageContentImpl messageContentImpl) {
            this.a = messageContentImpl;
        }

        public MessageContent(String str, DeployStatus deployStatus) {
            if (deployStatus == DeployStatus.DEVELOPE) {
                this.b = 1;
            } else {
                this.b = 2;
            }
            this.a = new FrontiaPushUtilImpl.MessageContentImpl(str, this.b);
        }

        public static MessageContent createNotificationMessage(String str, String str2, String str3) {
            return new MessageContent(FrontiaPushUtilImpl.MessageContentImpl.createNotificationMessage(str, str2, str3));
        }

        public static MessageContent createStringMessage(String str, String str2) {
            return new MessageContent(FrontiaPushUtilImpl.MessageContentImpl.createStringMessage(str, str2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FrontiaPushUtilImpl.MessageContentImpl a() {
            return this.a;
        }

        public DeployStatus getDeployStatus() {
            return this.a.getDeployStatus() == 1 ? DeployStatus.DEVELOPE : DeployStatus.PRODUCTION;
        }

        public String getMessage() {
            return this.a.getMesssage();
        }

        public String getMessageKeys() {
            return this.a.getMessageKeys();
        }

        public NotificationContent getNotification() {
            return new NotificationContent(this.a.getNotificationContent());
        }

        public void setMessage(String str) {
            this.a.setMessage(str);
        }

        public void setNotification(NotificationContent notificationContent) {
            this.a.setNotification(notificationContent.a());
        }
    }

    /* loaded from: classes.dex */
    public class NotificationContent {
        private FrontiaPushUtilImpl.NotificationContentImpl a;

        NotificationContent(FrontiaPushUtilImpl.NotificationContentImpl notificationContentImpl) {
            this.a = notificationContentImpl;
        }

        public NotificationContent(String str, String str2) {
            this.a = new FrontiaPushUtilImpl.NotificationContentImpl(str, str2);
        }

        FrontiaPushUtilImpl.NotificationContentImpl a() {
            return this.a;
        }

        public void addAndroidContent(AndroidContent androidContent) {
            this.a.addAndroidContent(androidContent.a());
        }

        public void addCustomContent(String str, String str2) {
            this.a.addCustomContent(str, str2);
        }

        public void addIOSContent(IOSContent iOSContent) {
            this.a.addIOSContent(iOSContent.a());
        }

        public AndroidContent getAndroidContent() {
            return new AndroidContent(this.a.getAndroidContent());
        }

        public JSONObject getCustomContent() {
            return this.a.getCustomContent();
        }

        public String getDescription() {
            return this.a.getDescription();
        }

        public IOSContent getIOSContent() {
            return new IOSContent(this.a.getIOSContent());
        }

        public String getTitle() {
            return this.a.getTitle();
        }
    }

    /* loaded from: classes.dex */
    public class Trigger {
        private FrontiaPushUtilImpl.TriggerImpl a;

        public Trigger() {
            this.a = new FrontiaPushUtilImpl.TriggerImpl();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Trigger(FrontiaPushUtilImpl.TriggerImpl triggerImpl) {
            this.a = triggerImpl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public FrontiaPushUtilImpl.TriggerImpl a() {
            return this.a;
        }

        public String getCrontab() {
            return this.a.getCrontab();
        }

        public String getTime() {
            return this.a.getTime();
        }

        public void setCrontab(String str) {
            this.a.setCrontab(str);
        }

        public void setTime(String str) {
            this.a.setTime(str);
        }
    }

    /* loaded from: classes.dex */
    abstract class a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract PushNotificationBuilder a();

        public abstract void setNotificationDefaults(int i);

        public abstract void setNotificationFlags(int i);

        public abstract void setNotificationSound(Uri uri);

        public abstract void setNotificationText(String str);

        public abstract void setNotificationTitle(String str);

        public abstract void setNotificationVibrate(long[] jArr);

        public abstract void setStatusbarIcon(int i);
    }
}
