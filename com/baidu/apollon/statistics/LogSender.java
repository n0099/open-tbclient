package com.baidu.apollon.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.statistics.c;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogSender {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3920a = 10002;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3921b = 10003;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3922d = 10000;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3923e = 10001;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f3924c;

    /* renamed from: f  reason: collision with root package name */
    public Handler f3925f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LogSender f3927a = new LogSender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Context c2 = PayStatisticsUtil.c();
        if (c2 == null) {
            return;
        }
        this.f3925f.removeMessages(10001);
        int d2 = g.a().d();
        if (com.baidu.apollon.statistics.a.a(c2)) {
            d2 = g.a().c();
        }
        this.f3925f.sendEmptyMessageDelayed(10001, d2 * 60000);
    }

    public static LogSender getInstance() {
        return a.f3927a;
    }

    public void triggerSending(String str) {
        if (Config.w.equals(str)) {
            this.f3925f.sendEmptyMessage(10003);
        } else {
            this.f3925f.obtainMessage(10000, str).sendToTarget();
        }
    }

    public LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        this.f3924c = handlerThread;
        handlerThread.start();
        this.f3925f = new Handler(this.f3924c.getLooper()) { // from class: com.baidu.apollon.statistics.LogSender.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (PayStatisticsUtil.c() == null) {
                    return;
                }
                int i2 = message.what;
                if (10000 == i2) {
                    LogSender.this.a((String) message.obj);
                    LogSender.this.b();
                } else if (10001 == i2) {
                    LogSender.this.a("normal_log");
                    LogSender.this.b();
                } else if (10002 == i2) {
                    g.a().a(PayStatisticsUtil.c());
                } else if (10003 == i2) {
                    String sendData = CustomerService.getInstance().getSendData();
                    if (TextUtils.isEmpty(sendData)) {
                        return;
                    }
                    LogSender.this.a(sendData, CustomerService.sMarkString);
                }
            }
        };
    }

    public void a() {
        Context c2 = PayStatisticsUtil.c();
        if (c2 != null) {
            f.a(BasicStoreTools.getInstance().getLastEvtId(c2));
            this.f3925f.sendEmptyMessage(10002);
        }
    }

    public boolean a(String str) {
        Context c2;
        if (c.a().c() || (c2 = PayStatisticsUtil.c()) == null || !com.baidu.apollon.statistics.a.a(c2)) {
            return false;
        }
        c.a a2 = c.a().a(str);
        if (a2.f3944a == 0 || TextUtils.isEmpty(a2.f3945b) || !a(a2.f3945b, (String) null)) {
            return false;
        }
        if (str.equals("normal_log")) {
            BasicStoreTools.getInstance().setLastData(c2, com.baidu.apollon.statistics.a.a(a2.f3945b.getBytes(), false));
        }
        d.a().a(str, a2.f3944a);
        return true;
    }

    private synchronized boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lastData = BasicStoreTools.getInstance().getLastData(context);
        if (TextUtils.isEmpty(lastData)) {
            return false;
        }
        return lastData.equals(com.baidu.apollon.statistics.a.a(str.getBytes(), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        SyncHttpImpl b2;
        String str3 = str.toString();
        Context c2 = PayStatisticsUtil.c();
        if (c2 != null && a(c2, str)) {
            try {
                StatisticsSettings a2 = PayStatisticsUtil.getInstance().a();
                if (a2 == null || (b2 = PayStatisticsUtil.getInstance().b()) == null) {
                    return false;
                }
                String uploadUrl = a2.getUploadUrl();
                String encodeToString = Base64.encodeToString(str3.getBytes(), 2);
                HashMap hashMap = new HashMap();
                hashMap.put("publish_data", encodeToString);
                String str4 = a2.isReleaseVersion() ? "(null)" : "MhxzKhl";
                hashMap.put("sign", com.baidu.apollon.statistics.a.a((encodeToString + str4).getBytes("GBK"), false));
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("mk", str2);
                }
                return b2.send(c2, 1, uploadUrl, hashMap);
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    private boolean a(Context context, String str) {
        if (c.a().c() || !b(context, str)) {
            return true;
        }
        c.a().b("normal_log");
        return false;
    }
}
