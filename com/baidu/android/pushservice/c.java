package com.baidu.android.pushservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.h.u;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes2.dex */
public class c {
    protected int a;
    protected int b;
    protected int c;
    protected Uri d;
    protected long[] e;
    protected String f;
    protected String g;
    protected boolean h = false;
    private final String i;

    public c(String str) {
        this.i = str;
    }

    public static int a(Context context, String str) {
        return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(Drawable drawable, Context context) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        float f = context.getResources().getDisplayMetrics().density;
        drawable.setBounds(0, 0, (int) (48.0f * f), (int) (f * 48.0f));
        drawable.draw(canvas);
        return createBitmap;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(final Context context, final PendingIntent pendingIntent, final String str) {
        int a = a(context, "bpush_lapp_notification_status_icon");
        if (a > 0) {
            a(a);
        } else {
            a(17301620);
        }
        if (Build.VERSION.SDK_INT >= 16 && !TextUtils.isEmpty(this.i)) {
            new Thread(new Runnable() { // from class: com.baidu.android.pushservice.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Notification build = new Notification.Builder(context).setContentTitle(c.this.f).setContentText(c.this.g).setSmallIcon(c.this.a).setLargeIcon(c.this.a(Drawable.createFromStream(new URL(c.this.i).openStream(), null), context)).build();
                        if (c.this.b != 0) {
                            build.flags = c.this.b;
                        }
                        if (c.this.h) {
                            build.defaults = 0;
                        } else {
                            build.defaults = -1;
                            if (c.this.c != 0) {
                                build.defaults = c.this.c;
                            }
                            if (c.this.d != null) {
                                build.sound = c.this.d;
                            }
                            if (c.this.e != null) {
                                build.vibrate = c.this.e;
                            }
                        }
                        build.contentIntent = pendingIntent;
                        ((NotificationManager) context.getSystemService("notification")).notify(str, 0, build);
                    } catch (MalformedURLException e) {
                        com.baidu.android.pushservice.e.a.a("NewPushNotificationBuilder", e);
                    } catch (IOException e2) {
                    }
                }
            }, "DownNotiIcon").start();
            return;
        }
        Notification notification = new Notification.Builder(context).setContentTitle(this.f).setContentText(this.g).setSmallIcon(this.a).setContentIntent(pendingIntent).getNotification();
        if (this.h) {
            notification.defaults = 0;
        } else {
            notification.defaults = -1;
            if (this.c != 0) {
                notification.defaults = this.c;
            }
            if (this.d != null) {
                notification.sound = this.d;
            }
            if (this.e != null) {
                notification.vibrate = this.e;
            }
        }
        if (this.b != 0) {
            notification.flags = this.b;
        }
        if (notification != null) {
            notification.contentIntent = pendingIntent;
            ((NotificationManager) context.getSystemService("notification")).notify(u.b(str), notification);
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(int i) {
        this.c = i;
    }
}
