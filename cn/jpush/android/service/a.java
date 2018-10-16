package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsLifecycleMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class a {
    private static volatile a a = null;
    private static ExecutorService b = Executors.newSingleThreadExecutor();
    private static final Object f = new Object();
    private Handler c;
    private Context d;
    private String e;

    private a(Context context) {
        this.c = null;
        this.d = null;
        this.e = "";
        this.c = new Handler(Looper.getMainLooper());
        this.d = context;
        this.e = this.d.getPackageName();
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (f) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private synchronized void a(long j, long j2) {
        if (this.c != null) {
            c cVar = new c(this, j);
            if (j2 <= 0) {
                this.c.post(cVar);
            } else {
                this.c.postDelayed(cVar, j2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY);
        intent.putExtra("senderId", str3);
        intent.putExtra(AiAppsLifecycleMessage.APP_ID_KEY, str2);
        intent.putExtra("message", str);
        intent.putExtra("notificaion_type", 1);
        intent.addCategory(str2);
        context.sendOrderedBroadcast(intent, str2 + ".permission.JPUSH_MESSAGE");
    }

    private synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        boolean z;
        cn.jpush.android.d.f.a("JPushLocalNotificationCenter", "add LocalNotification");
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        ServiceInterface.d(context);
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            cn.jpush.android.data.d a2 = cn.jpush.android.data.d.a(context);
            if (a2.a(notificationId, 0) != null) {
                a2.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a2.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (broadcastTime < ReportUserInfoModel.TIME_INTERVAL) {
            a(jPushLocalNotification.getNotificationId(), broadcastTime);
            z = true;
        } else {
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004c A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:15:0x004c, B:16:0x004f, B:31:0x0081, B:32:0x0084, B:33:0x0088, B:22:0x0072, B:23:0x0075), top: B:40:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081 A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:15:0x004c, B:16:0x004f, B:31:0x0081, B:32:0x0084, B:33:0x0088, B:22:0x0072, B:23:0x0075), top: B:40:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void e(Context context) {
        Cursor cursor;
        cn.jpush.android.data.d a2 = cn.jpush.android.data.d.a(context);
        if (a2.a(false)) {
            Cursor cursor2 = null;
            try {
                cursor = a2.a(1, System.currentTimeMillis());
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            cn.jpush.android.data.e a3 = cn.jpush.android.data.d.a(cursor);
                            if (a3 != null) {
                                a(context, a3.d(), this.e, "");
                                a2.b(a3.a(), 0, 0, 0, a3.d(), a3.f(), a3.e());
                            }
                        } while (cursor.moveToNext());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                    } else {
                        if (cursor != null) {
                        }
                        a2.b(false);
                    }
                } catch (Exception e) {
                    e = e;
                    cursor2 = cursor;
                    try {
                        cn.jpush.android.d.f.c("JPushLocalNotificationCenter", "triggerLNKillProcess: " + e.getMessage());
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        a2.b(false);
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursor2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    a2.b(false);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        }
    }

    public final synchronized boolean a(Context context, long j) {
        boolean z = false;
        synchronized (this) {
            cn.jpush.android.d.f.a("JPushLocalNotificationCenter", "remove LocalNotification ");
            long j2 = (int) j;
            try {
                cn.jpush.android.data.d a2 = cn.jpush.android.data.d.a(context);
                if (a2.a(j2, 0) != null) {
                    a2.a(j2);
                    JPushInterface.clearNotificationById(this.d, (int) j2);
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    public final synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification, boolean z) {
        if (z) {
            a(context, jPushLocalNotification);
        } else {
            Bundle bundle = new Bundle();
            e.a(context, bundle, "intent.MULTI_PROCESS");
            bundle.putInt("multi_type", 6);
            bundle.putSerializable("local_notification", jPushLocalNotification);
            cn.jiguang.api.e.b(context, cn.jpush.android.a.a, bundle);
        }
        return true;
    }

    public final synchronized void b(Context context) {
        cn.jpush.android.d.f.a("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a2 = cn.jpush.android.data.d.a(context).a();
        if (a2 != null && a2.length > 0) {
            for (int i : a2) {
                JPushInterface.clearNotificationById(this.d, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: all -> 0x004c, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:15:0x0038, B:16:0x003b, B:30:0x0055, B:31:0x0058, B:32:0x005c, B:21:0x0044, B:22:0x0047, B:6:0x000d, B:7:0x0018, B:9:0x001e, B:11:0x0024, B:12:0x0030), top: B:35:0x0001, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(Context context) {
        Cursor cursor;
        Throwable th;
        cn.jpush.android.data.d a2 = cn.jpush.android.data.d.a(context);
        if (a2.a(false)) {
            Cursor cursor2 = null;
            try {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    Cursor a3 = a2.a(currentTimeMillis, ReportUserInfoModel.TIME_INTERVAL);
                    try {
                        if (a3.moveToFirst()) {
                            do {
                                cn.jpush.android.data.e a4 = cn.jpush.android.data.d.a(a3);
                                if (a4 != null) {
                                    a(a4.a(), a4.f() - currentTimeMillis);
                                }
                            } while (a3.moveToNext());
                            if (a3 != null) {
                                a3.close();
                            }
                            a2.b(false);
                        } else {
                            if (a3 != null) {
                            }
                            a2.b(false);
                        }
                    } catch (Throwable th2) {
                        cursor = a3;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.b(false);
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                }
            } catch (Exception e) {
                if (0 != 0) {
                    cursor2.close();
                }
                a2.b(false);
            }
        }
    }

    public final void d(Context context) {
        b.execute(new b(this, context));
    }
}
