package com.baidu.android.pushservice.message;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.util.n;
import com.baidu.android.pushservice.y;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {
    private com.baidu.android.pushservice.util.a c;

    public c(Context context, com.baidu.android.pushservice.e eVar) {
        super(context, eVar);
    }

    private int a(String str, String str2, String str3, byte[] bArr) {
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.f321a).b(str);
        if (b == null || !b.c.equals(str2)) {
            String str4 = ">>> NOT delivere message to app: " + (b == null ? "client not found." : "userid not match: msg_userID-" + str2 + " client_userId-" + b.c + " in " + b.f309a);
            Log.i("MessageHandler", str4);
            n.a(str4);
            return 2;
        }
        PublicMsg a2 = j.a(str3, str, bArr);
        if (a2 != null) {
            Intent intent = new Intent(PushConstants.ACTION_MESSAGE);
            intent.setPackage(b.f309a);
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING, a2.d);
            intent.setFlags(32);
            if (!TextUtils.isEmpty(a2.n)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2.n);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        intent.putExtra(next, jSONObject.getString(next));
                    }
                    intent.putExtra(PushConstants.EXTRA_EXTRA, a2.n);
                } catch (JSONException e) {
                    Log.w("MessageHandler", "Custom content to JSONObject exception::" + e.getMessage());
                }
            }
            this.f321a.sendBroadcast(intent);
            String str5 = ">>> Deliver message to client: " + b.f309a;
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", str5);
            }
            n.a(str5);
        }
        return 0;
    }

    private int a(String str, String str2, byte[] bArr) {
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.e)) {
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                Log.d("MessageHandler", ">>> Don't Show rich media Notification! url is null");
            }
            n.a(">>> Don't Show rich media Notification! url is null");
        } else {
            com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.f321a).b(str);
            if (b != null && b.f309a != null) {
                a2.f = b.f309a;
            }
            b(a2, str2);
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                Log.d("MessageHandler", ">>> Show rich media Notification!");
            }
            n.a(">>> Show rich media Notification!");
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(byte[] bArr) {
        String str;
        Intent intent;
        JSONObject jSONObject;
        String str2 = null;
        boolean z = true;
        try {
            jSONObject = new JSONObject(new String(bArr));
            str = jSONObject.getString("action");
        } catch (JSONException e) {
            e = e;
            str = null;
        }
        try {
            str2 = jSONObject.getString(PushConstants.EXTRA_PUSH_MESSAGE);
        } catch (JSONException e2) {
            e = e2;
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                Log.d("MessageHandler", "Supper message parsing action Fail:\r\n" + e.getMessage());
            }
            z = false;
            if (z) {
            }
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
            }
            intent.setFlags(32);
            this.f321a.sendBroadcast(intent);
            return 0;
        }
        if (z || TextUtils.isEmpty(str)) {
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                n.a(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE");
            }
        } else {
            intent = new Intent(str);
            intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, str2);
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                n.a(">>> Deliver baidu supper msg with s action: " + str);
            }
        }
        intent.setFlags(32);
        this.f321a.sendBroadcast(intent);
        return 0;
    }

    private void a(PublicMsg publicMsg, String str) {
        Intent intent = new Intent(this.f321a, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
        intent.setData(Uri.parse("content://" + str));
        intent.putExtra("public_msg", publicMsg);
        Intent intent2 = new Intent(this.f321a, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
        intent2.setData(Uri.parse("content://" + str));
        intent2.putExtra("public_msg", publicMsg);
        intent.setClass(this.f321a, PushService.class);
        intent2.setClass(this.f321a, PushService.class);
        PendingIntent service = PendingIntent.getService(this.f321a, 0, intent, 0);
        PendingIntent service2 = PendingIntent.getService(this.f321a, 0, intent2, 0);
        Notification notification = new Notification();
        notification.icon = 17301569;
        notification.tickerText = publicMsg.c;
        notification.setLatestEventInfo(this.f321a, publicMsg.c, publicMsg.d, service);
        notification.sound = RingtoneManager.getDefaultUri(2);
        notification.deleteIntent = service2;
        notification.flags |= 16;
        ((NotificationManager) this.f321a.getSystemService("notification")).notify((int) Long.parseLong(str), notification);
    }

    private void a(PublicMsg publicMsg, String str, String str2) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.notification.SHOW");
        intent.setPackage(publicMsg.f);
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "private");
        intent.putExtra("pushService_package_name", this.f321a.getPackageName());
        intent.putExtra("message_id", str);
        intent.putExtra(PushConstants.EXTRA_APP_ID, str2);
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        this.f321a.sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(PublicMsg publicMsg) {
        boolean z;
        boolean z2;
        if (publicMsg.i == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f321a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.d("MessageHandler", "network type : " + activeNetworkInfo.getTypeName().toLowerCase());
                }
                if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                    z2 = true;
                    if (!z2) {
                        return false;
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
        if (TextUtils.isEmpty(publicMsg.o)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> isNeedShowNotification supportapp = null");
            }
            return true;
        }
        try {
        } catch (PackageManager.NameNotFoundException e) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", e.getMessage());
            }
        }
        if (this.f321a.getPackageManager().getPackageInfo(publicMsg.o, 0) != null) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> isNeedShowNotification supportapp found \r\n pckname = " + publicMsg.o);
            }
            z = true;
            return (!publicMsg.p && z) || !(publicMsg.p || z);
        }
        z = false;
        if (publicMsg.p) {
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(long j, String str, String str2, String str3, long j2, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.util.c cVar = new com.baidu.android.pushservice.util.c(byteArrayOutputStream);
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "wrapMsgHead , appid:" + str + " userid:" + str2 + " msgid: " + j2 + " type: " + i + " result: " + i2);
        }
        try {
            try {
                cVar.a(Long.parseLong(y.a().b()));
                cVar.a(a(str, DERTags.TAGGED));
                cVar.a(a(str2, DERTags.TAGGED));
                cVar.a(a(str3, DERTags.TAGGED));
                cVar.a(j2);
                cVar.b(i);
                cVar.b(0);
                cVar.b(i2);
                cVar.b(0);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } catch (Exception e2) {
                Log.e("MessageHandler", e2);
                try {
                    byteArrayOutputStream.close();
                    cVar.a();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            }
        } finally {
            try {
                byteArrayOutputStream.close();
                cVar.a();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private byte[] a(String str, int i) {
        byte[] bArr = new byte[i];
        if (str != null) {
            byte[] bytes = str.getBytes();
            System.arraycopy(bytes, 0, bArr, 0, Math.min(bArr.length, bytes.length));
        }
        return bArr;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(short s, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.util.c cVar = new com.baidu.android.pushservice.util.c(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            try {
                cVar.a((int) s);
                if (s != 5 && s != 6) {
                    cVar.a(10);
                    cVar.b(0);
                    cVar.a(a(n.e(this.f321a, this.f321a.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                    cVar.b(-76508268);
                    cVar.b(1);
                    cVar.b(length);
                    if (bArr != null) {
                        cVar.a(bArr);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                    cVar.a();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            try {
                byteArrayOutputStream.close();
                cVar.a();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return null;
        }
    }

    private int b(String str, String str2, byte[] bArr) {
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.d)) {
            Log.e("MessageHandler", ">>> pMsg JSON parsing error!");
            n.a(">>> pMsg JSON parsing error!");
            return 2;
        }
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.f321a).b(str);
        if (b == null || b.f309a == null) {
            if (com.baidu.android.pushservice.b.a(this.f321a)) {
                Log.d("MessageHandler", ">>> Don't Show pMsg private Notification! package name is null");
            }
            n.a(">>> Don't Show pMsg private Notification! package name is null");
            return 0;
        }
        a2.f = b.f309a;
        if (TextUtils.isEmpty(a2.c)) {
            PackageManager packageManager = this.f321a.getPackageManager();
            a2.c = packageManager.getApplicationLabel(packageManager.getApplicationInfo(a2.f, DERTags.TAGGED)).toString();
        }
        a(a2, str2, str);
        if (com.baidu.android.pushservice.b.a(this.f321a)) {
            Log.d("MessageHandler", ">>> Show pMsg private Notification!");
        }
        n.a(">>> Show pMsg private Notification!");
        return 1;
    }

    private String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        int i = 0;
        while (true) {
            if (i >= bArr.length) {
                i = 0;
                break;
            } else if (bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        return new String(bArr, 0, i);
    }

    private void b(PublicMsg publicMsg, String str) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.notification.SHOW");
        intent.setPackage(publicMsg.f);
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "rich_media");
        intent.putExtra("pushService_package_name", this.f321a.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        this.f321a.sendBroadcast(intent);
    }

    private int c(String str, String str2, byte[] bArr) {
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.c) || TextUtils.isEmpty(a2.d) || TextUtils.isEmpty(a2.e)) {
            Log.e("MessageHandler", ">>> pMsg JSON parsing error!");
            n.a(">>> pMsg JSON parsing error!");
            return 2;
        } else if (a(a2) && n.e(this.f321a, this.f321a.getPackageName())) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> Show pMsg Notification!");
            }
            n.a(">>> Show pMsg Notification!");
            a(a2, str2);
            return 1;
        } else {
            String str3 = ">>> Don't Show pMsg Notification! --- IsBaiduApp = " + n.e(this.f321a, this.f321a.getPackageName());
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", str3);
            }
            n.a(str3);
            return 0;
        }
    }

    private int d(String str, String str2, byte[] bArr) {
        PackageInfo packageInfo;
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.f321a).b(str);
        if (b != null) {
            try {
                packageInfo = this.f321a.getPackageManager().getPackageInfo(b.f309a, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("MessageHandler", Log.getStackTraceString(e));
                }
                packageInfo = null;
            }
            if (packageInfo == null) {
                com.baidu.android.pushservice.a.b.b(this.f321a);
                String str3 = ">>> NOT deliver to app: " + b.f309a + ", package has been uninstalled.";
                if (com.baidu.android.pushservice.b.a()) {
                    Log.i("MessageHandler", str3);
                }
                n.a(str3);
                return 0;
            } else if (b.c.equals(str2)) {
                Intent intent = new Intent(PushConstants.ACTION_MESSAGE);
                intent.setPackage(b.f309a);
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr);
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING, new String(bArr, "UTF-8"));
                intent.setFlags(32);
                this.f321a.sendBroadcast(intent);
                String str4 = ">>> Deliver message to client: " + b.f309a;
                if (com.baidu.android.pushservice.b.a()) {
                    Log.d("MessageHandler", str4);
                }
                n.a(str4);
                return 0;
            } else {
                String str5 = ">>> Not deliver message to client: client userid: " + b.c;
                if (com.baidu.android.pushservice.b.a()) {
                    Log.d("MessageHandler", str5);
                }
                n.a(str5);
            }
        } else {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> Not deliver message to client: client NOT found");
            }
            n.a(">>> Not deliver message to client: client NOT found");
        }
        return 2;
    }

    private void d(b bVar) {
        String str = new String(bVar.c);
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleMessage MSG_ID_HANDSHAKE : " + str);
        }
        int i = new JSONObject(str).getInt("ret");
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleMessage MSG_ID_HANDSHAKE : result = " + i);
        }
        if (i == 0) {
            com.baidu.android.pushservice.a.b.b(this.f321a);
        } else if (i == 5003) {
            com.baidu.android.pushservice.a.b.b(this.f321a);
        } else if (i != 2002) {
            throw new d("MessageHandler handle handshake msg failed. ret = " + i);
        } else {
            y.a().a((String) null, (String) null);
            n.i(this.f321a);
        }
    }

    private void e(b bVar) {
        int d;
        byte[] bArr = bVar.c;
        if (bArr == null) {
            return;
        }
        com.baidu.android.pushservice.util.a aVar = new com.baidu.android.pushservice.util.a(new ByteArrayInputStream(bArr));
        long c = aVar.c();
        byte[] bArr2 = new byte[DERTags.TAGGED];
        aVar.a(bArr2);
        String b = b(bArr2);
        byte[] bArr3 = new byte[DERTags.TAGGED];
        aVar.a(bArr3);
        String b2 = b(bArr3);
        byte[] bArr4 = new byte[DERTags.TAGGED];
        aVar.a(bArr4);
        String b3 = b(bArr4);
        com.baidu.android.pushservice.util.b d2 = aVar.d();
        String str = d2.f355a;
        long j = d2.b;
        int a2 = aVar.a();
        int a3 = aVar.a();
        int a4 = aVar.a();
        int a5 = aVar.a();
        int length = bArr.length - 416;
        if (length <= 0) {
            length = 0;
        }
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, BdWebErrorView.ERROR_CODE_416, bArr5, 0, length);
        String str2 = "type:" + a2 + " channelId:" + c + " appid:" + b + " userid:" + b2 + " msgId:" + str + " msgKey:" + b3 + " bodyLength:" + a3 + " result:" + a4 + " reserved:" + a5;
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "New MSG: " + str2);
            Log.i("MessageHandler", "msgBody :" + new String(bArr5));
        }
        n.a("New MSG: " + str2 + " msgBody :" + new String(bArr5));
        b bVar2 = new b();
        if (this.b.a(str)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", "Message ID(" + str + ") received duplicated, ack success to server directly.");
            }
            n.a(">>> MSG ID duplicated, not deliver to app.");
            bVar2.c = a((short) 3, a(c, b, b2, b3, j, a2, 0));
            a(bVar2);
            return;
        }
        if (a2 == 0 || a2 == 1) {
            d = d(b, b2, bArr5);
        } else if (a2 == 6) {
            d = a(b, b2, str, bArr5);
        } else if (a2 == 2 || a2 == 3) {
            d = c(b, str, bArr5);
        } else if (a2 == 5) {
            d = b(b, str, bArr5);
        } else if (a2 == 7) {
            d = a(b, str, bArr5);
        } else if (a2 == 10) {
            d = a(bArr5);
        } else {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("MessageHandler", ">>> Unknown msg_type : " + a2);
            }
            n.a(">>> Unknown msg_type : " + a2);
            d = 2;
        }
        bVar2.c = a((short) 3, a(c, b, b2, b3, j, a2, d));
        if (com.baidu.android.pushservice.b.a()) {
            Log.d("MessageHandler", "send ack to server");
            n.a("send ack to server, msg = " + bVar2.c);
        }
        a(bVar2);
    }

    @Override // com.baidu.android.pushservice.message.a
    public b a(byte[] bArr, int i) {
        byte[] bArr2;
        this.c = new com.baidu.android.pushservice.util.a(new ByteArrayInputStream(bArr));
        short b = this.c.b();
        b bVar = new b();
        bVar.f322a = b;
        if (b == 6 || b == 5) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", "readMessage tiny heart beat from server, msgId:" + ((int) b));
            }
            return bVar;
        }
        short b2 = this.c.b();
        int a2 = this.c.a();
        this.c.a(new byte[16]);
        int a3 = this.c.a();
        int a4 = this.c.a();
        int a5 = this.c.a();
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "readMessage nshead, msgId:" + ((int) b) + " magicNum:" + Integer.toHexString(a3) + " length:" + a5 + " version =" + ((int) b2) + " logId =" + a2 + " reserved = " + a4);
        }
        if (a5 > 0) {
            bArr2 = new byte[a5 <= 20480 ? a5 : 20480];
            this.c.a(bArr2);
        } else {
            bArr2 = null;
        }
        bVar.c = bArr2;
        return bVar;
    }

    @Override // com.baidu.android.pushservice.message.a
    public void a() {
    }

    @Override // com.baidu.android.pushservice.message.a
    public void a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel_token", y.a().c());
            jSONObject.put("channel_id", y.a().b());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            jSONObject.put("connect_version", 2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "onSessionOpened, send handshake msg :" + jSONObject2);
        }
        byte[] a2 = a((short) 1, jSONObject2.getBytes());
        b bVar = new b();
        bVar.c = a2;
        bVar.d = true;
        a(bVar);
    }

    @Override // com.baidu.android.pushservice.message.a
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        int i = bVar.f322a;
        if (i == 1) {
            d(bVar);
        } else if (i == 2 || i == 6) {
            c(bVar);
        } else if (i == 4) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", "handleMessage MSG_ID_HEARTBEAT_CLIENT");
            }
        } else if (i == 5) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", "handleMessage MSG_ID_TIMY_HEARTBEAT_CLIENT");
            }
        } else if (i == 3) {
            e(bVar);
        }
    }

    public void c(b bVar) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleMessage: server heart beat id - " + bVar.f322a);
        }
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleServerHeartbeatMsg, send handshake return msg ");
        }
        byte[] a2 = a((short) bVar.f322a, (byte[]) null);
        b bVar2 = new b();
        bVar2.c = a2;
        a(bVar2);
    }
}
