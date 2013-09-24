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
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushSDK;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.util.n;
import com.baidu.android.pushservice.y;
import com.baidu.zeus.bouncycastle.DERTags;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {
    private com.baidu.android.pushservice.util.a e;

    public c(Context context, com.baidu.android.pushservice.e eVar) {
        super(context, eVar);
    }

    public c(Context context, com.baidu.android.pushservice.e eVar, InputStream inputStream, OutputStream outputStream) {
        super(context, eVar, inputStream, outputStream);
        this.e = new com.baidu.android.pushservice.util.a(inputStream);
    }

    private int a(String str, String str2, byte[] bArr) {
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 != null && !TextUtils.isEmpty(a2.e)) {
            com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.c).b(str);
            if (b != null && b.f612a != null) {
                a2.f = b.f612a;
            }
            b(a2, str2);
            if (com.baidu.android.pushservice.b.a(this.c)) {
                Log.d("MessageHandler", ">>> Show rich media Notification!");
                n.a(">>> Show rich media Notification!");
            }
        } else if (com.baidu.android.pushservice.b.a(this.c)) {
            Log.d("MessageHandler", ">>> Don't Show rich media Notification! url is null");
            n.a(">>> Don't Show rich media Notification! url is null");
        }
        return 0;
    }

    private int a(String str, byte[] bArr) {
        PackageInfo packageInfo;
        int i = 0;
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.c).b(str);
        if (b != null) {
            try {
                packageInfo = this.c.getPackageManager().getPackageInfo(b.f612a, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (com.baidu.android.pushservice.b.a()) {
                    Log.e("MessageHandler", Log.getStackTraceString(e));
                }
                packageInfo = null;
            }
            if (packageInfo == null) {
                com.baidu.android.pushservice.a.b.b(this.c);
                String str2 = ">>> NOT deliver to app: " + b.f612a + ", package has been uninstalled.";
                a(str);
                if (com.baidu.android.pushservice.b.a()) {
                    Log.i("MessageHandler", str2);
                    n.a(str2);
                }
            } else {
                Intent intent = new Intent(PushConstants.ACTION_MESSAGE);
                intent.setPackage(b.f612a);
                intent.putExtra("message", bArr);
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE_STRING, new String(bArr, "UTF-8"));
                intent.setFlags(32);
                this.c.sendBroadcast(intent);
                String str3 = ">>> Deliver message to client: " + b.f612a;
                if (com.baidu.android.pushservice.b.a()) {
                    Log.d("MessageHandler", str3);
                    n.a(str3);
                }
            }
        } else {
            i = 2;
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> Not deliver message to client: client NOT found");
                n.a(">>> Not deliver message to client: client NOT found");
            }
        }
        return i;
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
            str2 = jSONObject.getString("message");
        } catch (JSONException e2) {
            e = e2;
            if (com.baidu.android.pushservice.b.a(this.c)) {
                Log.d("MessageHandler", "Supper message parsing action Fail:\r\n" + e.getMessage());
            }
            z = false;
            if (z) {
            }
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra("message", bArr);
            if (com.baidu.android.pushservice.b.a(this.c)) {
            }
            intent.setFlags(32);
            this.c.sendBroadcast(intent);
            return 0;
        }
        if (z || TextUtils.isEmpty(str)) {
            intent = new Intent("com.baidu.pushservice.action.supper.MESSAGE");
            intent.putExtra("message", bArr);
            if (com.baidu.android.pushservice.b.a(this.c)) {
                n.a(">>> Deliver baidu supper msg with g action: com.baidu.pushservice.action.supper.MESSAGE");
            }
        } else {
            intent = new Intent(str);
            intent.putExtra("message", str2);
            if (com.baidu.android.pushservice.b.a(this.c)) {
                n.a(">>> Deliver baidu supper msg with s action: " + str);
            }
        }
        intent.setFlags(32);
        this.c.sendBroadcast(intent);
        return 0;
    }

    private void a(PublicMsg publicMsg, String str) {
        Intent intent = new Intent(this.c, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK_V2");
        intent.setData(Uri.parse("content://" + str));
        intent.putExtra("public_msg", publicMsg);
        Intent intent2 = new Intent(this.c, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE_V2");
        intent2.setData(Uri.parse("content://" + str));
        intent2.putExtra("public_msg", publicMsg);
        intent.setClass(this.c, PushService.class);
        intent2.setClass(this.c, PushService.class);
        PendingIntent service = PendingIntent.getService(this.c, 0, intent, 0);
        PendingIntent service2 = PendingIntent.getService(this.c, 0, intent2, 0);
        Notification notification = new Notification();
        notification.icon = 17301569;
        notification.tickerText = publicMsg.c;
        notification.setLatestEventInfo(this.c, publicMsg.c, publicMsg.d, service);
        notification.sound = RingtoneManager.getDefaultUri(2);
        notification.deleteIntent = service2;
        notification.flags |= 16;
        ((NotificationManager) this.c.getSystemService("notification")).notify((int) Long.parseLong(str), notification);
    }

    private void a(PublicMsg publicMsg, String str, String str2) {
        Intent intent = new Intent("com.baidu.android.pushservice.action.notification.SHOW");
        intent.setPackage(publicMsg.f);
        intent.putExtra("public_msg", publicMsg);
        intent.putExtra("notify_type", "private");
        intent.putExtra("pushService_package_name", this.c.getPackageName());
        intent.putExtra("message_id", str);
        intent.putExtra(PushConstants.EXTRA_APP_ID, str2);
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        this.c.sendBroadcast(intent);
    }

    private void a(String str) {
        try {
            String b = PushSettings.b(str);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            int intValue = new Integer(b.substring(0, 1)).intValue();
            if (b.length() > 1) {
                String substring = b.substring(1);
                if (PushSDK.getInstantce(this.c).getRegistrationService() != null) {
                    PushSDK.getInstantce(this.c).getRegistrationService().a(str, intValue, substring);
                    PushSettings.a(str, 9, "");
                }
            }
        } catch (Exception e) {
            Log.i("MessageHandler", "unbind exception" + Log.getStackTraceString(e));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(PublicMsg publicMsg) {
        boolean z;
        boolean z2;
        if (publicMsg.i == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.c.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
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
        if (this.c.getPackageManager().getPackageInfo(publicMsg.o, 0) != null) {
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
    private byte[] a(long j, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.util.c cVar = new com.baidu.android.pushservice.util.c(byteArrayOutputStream);
        try {
            try {
                cVar.a(j);
                cVar.b(i);
                cVar.b(0);
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
        } catch (Exception e3) {
            Log.e("MessageHandler", e3);
            try {
                byteArrayOutputStream.close();
                cVar.a();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return null;
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
                    cVar.a(11);
                    cVar.b(0);
                    cVar.a(a(n.e(this.c, this.c.getPackageName()) ? "BaiduApp" : "DevApp", 16));
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
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("MessageHandler", ">>> pMsg JSON parsing error!");
                n.a(">>> pMsg JSON parsing error!");
            }
            return 2;
        }
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.c).b(str);
        if (b == null || b.f612a == null) {
            if (com.baidu.android.pushservice.b.a(this.c)) {
                Log.d("MessageHandler", ">>> Don't Show pMsg private Notification! package name is null");
            }
            a(str);
            n.a(">>> Don't Show pMsg private Notification! package name is null");
            return 0;
        }
        a2.f = b.f612a;
        if (TextUtils.isEmpty(a2.c)) {
            PackageManager packageManager = this.c.getPackageManager();
            a2.c = packageManager.getApplicationLabel(packageManager.getApplicationInfo(a2.f, DERTags.TAGGED)).toString();
        }
        a(a2, str2, str);
        if (com.baidu.android.pushservice.b.a(this.c)) {
            Log.d("MessageHandler", ">>> Show pMsg private Notification!");
            n.a(">>> Show pMsg private Notification!");
            return 1;
        }
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
        intent.putExtra("pushService_package_name", this.c.getPackageName());
        intent.putExtra("service_name", "com.baidu.android.pushservice.PushService");
        this.c.sendBroadcast(intent);
    }

    private int c(String str, String str2, byte[] bArr) {
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 == null || TextUtils.isEmpty(a2.c) || TextUtils.isEmpty(a2.d) || TextUtils.isEmpty(a2.e)) {
            Log.e("MessageHandler", ">>> pMsg JSON parsing error!");
            if (com.baidu.android.pushservice.b.a()) {
                n.a(">>> pMsg JSON parsing error!");
            }
            return 2;
        } else if (a(a2) && n.e(this.c, this.c.getPackageName())) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", ">>> Show pMsg Notification!");
                n.a(">>> Show pMsg Notification!");
            }
            a(a2, str2);
            return 1;
        } else {
            String str3 = ">>> Don't Show pMsg Notification! --- IsBaiduApp = " + n.e(this.c, this.c.getPackageName());
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", str3);
            }
            n.a(str3);
            return 0;
        }
    }

    private int d(String str, String str2, byte[] bArr) {
        com.baidu.android.pushservice.d b = com.baidu.android.pushservice.a.a(this.c).b(str);
        if (b == null) {
            String str3 = ">>> NOT delivere message to app: " + (b == null ? "client not found." : " client_userId-" + b.c + " in " + b.f612a);
            a(str);
            Log.i("MessageHandler", str3);
            if (com.baidu.android.pushservice.b.a()) {
                n.a(str3);
            }
            return 2;
        }
        PublicMsg a2 = j.a(str2, str, bArr);
        if (a2 != null) {
            Intent intent = new Intent(PushConstants.ACTION_MESSAGE);
            intent.setPackage(b.f612a);
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
            this.c.sendBroadcast(intent);
            String str4 = ">>> Deliver message to client: " + b.f612a;
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", str4);
                n.a(str4);
            }
        }
        return 0;
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
            com.baidu.android.pushservice.a.b.b(this.c);
        } else if (i == 5003) {
            com.baidu.android.pushservice.a.b.b(this.c);
        } else if (i != 2002) {
            throw new d("MessageHandler handle handshake msg failed. ret = " + i);
        } else {
            y.a().a((String) null, (String) null);
            n.i(this.c);
        }
    }

    private void e(b bVar) {
        int a2;
        byte[] bArr = bVar.c;
        if (bArr == null) {
            return;
        }
        com.baidu.android.pushservice.util.a aVar = new com.baidu.android.pushservice.util.a(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[DERTags.TAGGED];
        aVar.a(bArr2);
        String b = b(bArr2);
        com.baidu.android.pushservice.util.b c = aVar.c();
        String str = c.f658a;
        long j = c.b;
        int a3 = aVar.a();
        int length = bArr.length - 140;
        if (length <= 0) {
            length = 0;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 140, bArr3, 0, length);
        if (com.baidu.android.pushservice.b.a()) {
            String str2 = "type:" + a3 + " appid:" + b + " msgId:" + str;
            Log.i("MessageHandler", "New MSG: " + str2);
            Log.i("MessageHandler", "msgBody :" + new String(bArr3));
            n.a("New MSG: " + str2 + " msgBody :" + new String(bArr3));
        }
        b bVar2 = new b();
        if (this.d.a(str)) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.d("MessageHandler", "Message ID(" + str + ") received duplicated, ack success to server directly.");
            }
            Log.i("MessageHandler", ">>> MSG ID duplicated, not deliver to app.");
            bVar2.c = a((short) 3, a(j, 0));
            a(bVar2);
            return;
        }
        if (a3 == 0 || a3 == 1) {
            a2 = a(b, bArr3);
        } else if (a3 == 6) {
            a2 = d(b, str, bArr3);
        } else if (a3 == 2 || a3 == 3) {
            a2 = c(b, str, bArr3);
        } else if (a3 == 5) {
            a2 = b(b, str, bArr3);
        } else if (a3 == 7) {
            a2 = a(b, str, bArr3);
        } else if (a3 == 10) {
            a2 = a(bArr3);
        } else {
            if (com.baidu.android.pushservice.b.a()) {
                Log.e("MessageHandler", ">>> Unknown msg_type : " + a3);
                n.a(">>> Unknown msg_type : " + a3);
            }
            a2 = 2;
        }
        bVar2.c = a((short) 3, a(j, a2));
        a(bVar2);
    }

    @Override // com.baidu.android.pushservice.message.a
    public b a(byte[] bArr, int i) {
        byte[] bArr2;
        this.e = new com.baidu.android.pushservice.util.a(new ByteArrayInputStream(bArr));
        short b = this.e.b();
        b bVar = new b();
        bVar.f625a = b;
        if (b == 6 || b == 5) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", "readMessage tiny heart beat from server, msgId:" + ((int) b));
            }
            return bVar;
        }
        short b2 = this.e.b();
        int a2 = this.e.a();
        this.e.a(new byte[16]);
        int a3 = this.e.a();
        int a4 = this.e.a();
        int a5 = this.e.a();
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "readMessage nshead, msgId:" + ((int) b) + " magicNum:" + Integer.toHexString(a3) + " length:" + a5 + " version =" + ((int) b2) + " logId =" + a2 + " reserved = " + a4);
        }
        if (a5 > 0) {
            bArr2 = new byte[a5 <= 20480 ? a5 : 20480];
            this.e.a(bArr2);
        } else {
            bArr2 = null;
        }
        bVar.c = bArr2;
        return bVar;
    }

    @Override // com.baidu.android.pushservice.message.a
    public void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel_token", new String(RSAUtil.decryptByPublicKey(Base64.decode(y.a().d().getBytes()), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n")));
            jSONObject.put("channel_id", y.a().c());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            jSONObject.put("connect_version", 2);
            jSONObject.put("tiny_msghead", 1);
        } catch (Exception e) {
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
        bVar.a(false);
        a(bVar);
    }

    @Override // com.baidu.android.pushservice.message.a
    public void a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel_token", new String(RSAUtil.decryptByPublicKey(Base64.decode(y.a().d().getBytes()), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/7VlVn9LIrZ71PL2RZMbK/Yxc\r\ndb046w/cXVylxS7ouPY06namZUFVhdbUnNRJzmGUZlzs3jUbvMO3l+4c9cw/n9aQ\r\nrm/brgaRDeZbeSrQYRZv60xzJIimuFFxsRM+ku6/dAyYmXiQXlRbgvFQ0MsVng4j\r\nv+cXhtTis2Kbwb8mQwIDAQAB\r\n")));
            jSONObject.put("channel_id", y.a().c());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
            jSONObject.put("tinyheart", 1);
            jSONObject.put("connect_version", 2);
            jSONObject.put("tiny_msghead", 1);
        } catch (Exception e) {
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
        bVar.a(false);
        a(bVar);
    }

    @Override // com.baidu.android.pushservice.message.a
    public b b() {
        byte[] bArr;
        short b = this.e.b();
        b bVar = new b();
        bVar.f625a = b;
        if (b == 6 || b == 5) {
            if (com.baidu.android.pushservice.b.a()) {
                Log.i("MessageHandler", "readMessage tiny heart beat from server, msgId:" + ((int) b));
            }
            return bVar;
        }
        short b2 = this.e.b();
        int a2 = this.e.a();
        this.e.a(new byte[16]);
        int a3 = this.e.a();
        int a4 = this.e.a();
        int a5 = this.e.a();
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "readMessage nshead, msgId:" + ((int) b) + " magicNum:" + Integer.toHexString(a3) + " length:" + a5 + " version =" + ((int) b2) + " logId =" + a2 + " reserved = " + a4);
        }
        if (a5 > 0) {
            bArr = new byte[a5 <= 20480 ? a5 : 20480];
            this.e.a(bArr);
        } else {
            bArr = null;
        }
        bVar.c = bArr;
        return bVar;
    }

    @Override // com.baidu.android.pushservice.message.a
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        int i = bVar.f625a;
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

    @Override // com.baidu.android.pushservice.message.a
    public void c() {
    }

    public void c(b bVar) {
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleMessage: server heart beat id - " + bVar.f625a);
        }
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "handleServerHeartbeatMsg, send handshake return msg ");
        }
        byte[] a2 = a((short) bVar.f625a, (byte[]) null);
        b bVar2 = new b();
        bVar2.c = a2;
        a(bVar2);
    }

    @Override // com.baidu.android.pushservice.message.a
    public void d() {
        if (com.baidu.android.pushservice.b.a()) {
            Log.i("MessageHandler", "sendHeartbeatMessage ");
        }
        byte[] a2 = a((short) 5, (byte[]) null);
        b bVar = new b();
        bVar.c = a2;
        bVar.d = true;
        bVar.a(true);
        a(bVar);
    }
}
