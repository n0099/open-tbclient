package cn.jpush.android.api;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.d.f;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DefaultPushNotificationBuilder implements PushNotificationBuilder {
    private static final String DEFAULT_NOTIFICATION_CHANNEL_ID = "JPush";
    private static final String DEFAULT_NOTIFICATION_CHANNEL_NAME = "Notification";
    private static final String TAG = "DefaultPushNotificationBuilder";
    private static boolean hasCreateNotificationChannel = false;

    RemoteViews buildContentView(String str, String str2) {
        return null;
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public Notification buildNotification(Map<String, String> map) {
        String str = cn.jpush.android.a.d;
        String str2 = map.containsKey(JPushInterface.EXTRA_ALERT) ? map.get(JPushInterface.EXTRA_ALERT) : "";
        if (TextUtils.isEmpty(str2)) {
            f.c(TAG, "No notification content to show. Give up.");
            return null;
        }
        if (map.containsKey(JPushInterface.EXTRA_NOTIFICATION_TITLE)) {
            str = map.get(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        }
        String str3 = map.containsKey(JPushInterface.EXTRA_BIG_TEXT) ? map.get(JPushInterface.EXTRA_BIG_TEXT) : "";
        String str4 = map.containsKey(JPushInterface.EXTRA_INBOX) ? map.get(JPushInterface.EXTRA_INBOX) : "";
        int parseInt = map.containsKey(JPushInterface.EXTRA_NOTI_PRIORITY) ? Integer.parseInt(map.get(JPushInterface.EXTRA_NOTI_PRIORITY)) : 0;
        String str5 = map.containsKey(JPushInterface.EXTRA_NOTI_CATEGORY) ? map.get(JPushInterface.EXTRA_NOTI_CATEGORY) : "";
        String str6 = map.containsKey(JPushInterface.EXTRA_BIG_PIC_PATH) ? map.get(JPushInterface.EXTRA_BIG_PIC_PATH) : "";
        int parseInt2 = map.containsKey(JPushInterface.EXTRA_ALERT_TYPE) ? Integer.parseInt(map.get(JPushInterface.EXTRA_ALERT_TYPE)) : -1;
        int i = (parseInt2 < -1 || parseInt2 > 7) ? -1 : parseInt2;
        if (cn.jpush.android.a.e != null) {
            int identifier = cn.jpush.android.a.e.getResources().getIdentifier("jpush_notification_icon", "drawable", cn.jpush.android.a.e.getPackageName());
            if (identifier == 0) {
                if (cn.jpush.android.a.b != 0) {
                    identifier = cn.jpush.android.a.b;
                } else {
                    try {
                        identifier = cn.jpush.android.a.e.getPackageManager().getApplicationInfo(cn.jpush.android.a.e.getPackageName(), 0).icon;
                    } catch (Throwable th) {
                        f.d(TAG, "failed to get application info and icon.", th);
                        return null;
                    }
                }
            }
            RemoteViews buildContentView = buildContentView(str2, str);
            if (Build.VERSION.SDK_INT < 11) {
                Notification notification = new Notification(identifier, str2, System.currentTimeMillis());
                resetNotificationParams(notification);
                notification.defaults = i;
                if (str == null) {
                    str = cn.jpush.android.a.d;
                }
                if (buildContentView != null) {
                    notification.contentView = buildContentView;
                } else {
                    c.a(notification, cn.jpush.android.a.e, str, str2, (PendingIntent) null);
                }
                return notification;
            }
            Notification.Builder builder = new Notification.Builder(cn.jpush.android.a.e);
            builder.setContentTitle(str).setContentText(str2).setTicker(str2).setSmallIcon(identifier);
            if (Build.VERSION.SDK_INT >= 17) {
                builder.setShowWhen(true);
            }
            c.a(builder, DEFAULT_NOTIFICATION_CHANNEL_ID, DEFAULT_NOTIFICATION_CHANNEL_NAME, parseInt, i);
            if (Build.VERSION.SDK_INT >= 16) {
                if (!TextUtils.isEmpty(str3)) {
                    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                    bigTextStyle.bigText(str3);
                    builder.setStyle(bigTextStyle);
                }
                if (!TextUtils.isEmpty(str4)) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    try {
                        TreeMap treeMap = new TreeMap();
                        JSONObject jSONObject = new JSONObject(str4);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            treeMap.put(next, jSONObject.optString(next));
                        }
                        for (String str7 : treeMap.values()) {
                            inboxStyle.addLine(str7);
                        }
                        inboxStyle.setSummaryText(" + " + jSONObject.length() + " new messages");
                    } catch (Throwable th2) {
                        f.d(TAG, "Set inbox style error: " + th2.getMessage());
                    }
                    builder.setStyle(inboxStyle);
                }
                if (!TextUtils.isEmpty(str6)) {
                    try {
                        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                        bigPictureStyle.bigPicture(BitmapFactory.decodeFile(str6));
                        builder.setStyle(bigPictureStyle);
                    } catch (Exception e) {
                        f.c(TAG, "Create big picture style failed.");
                        e.printStackTrace();
                    } catch (OutOfMemoryError e2) {
                        f.c(TAG, "Create bitmap failed caused by OutOfMemoryError.");
                        e2.printStackTrace();
                    }
                }
                if (parseInt != 0) {
                    if (parseInt == 1) {
                        builder.setPriority(1);
                    } else if (parseInt == 2) {
                        builder.setPriority(2);
                    } else if (parseInt == -1) {
                        builder.setPriority(-1);
                    } else if (parseInt == -2) {
                        builder.setPriority(-2);
                    } else {
                        builder.setPriority(0);
                    }
                }
                if (!TextUtils.isEmpty(str5)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            Class.forName("android.app.Notification$Builder").getDeclaredMethod("setCategory", String.class).invoke(builder, str5);
                        } catch (ClassNotFoundException e3) {
                            e3.printStackTrace();
                        } catch (NoSuchMethodException e4) {
                            e4.printStackTrace();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    } else {
                        f.c(TAG, "Device rom SDK < 21, can not set notification category!");
                    }
                }
            }
            if (buildContentView != null) {
                builder.setContent(buildContentView);
            }
            builder.setDefaults(i);
            return getNotification(builder);
        }
        return null;
    }

    @Override // cn.jpush.android.api.PushNotificationBuilder
    public String getDeveloperArg0() {
        return null;
    }

    Notification getNotification(Notification.Builder builder) {
        try {
            return Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        } catch (Throwable th) {
            f.c(TAG, "Build notification error:", th);
            return null;
        }
    }

    void resetNotificationParams(Notification notification) {
    }

    public String toString() {
        return "";
    }
}
