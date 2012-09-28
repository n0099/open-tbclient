package com.baidu.android.pushservice.message;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushService;
import com.baidu.android.pushservice.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {
    private com.baidu.android.pushservice.b.a e;

    public c(Context context, com.baidu.android.pushservice.c cVar, InputStream inputStream, OutputStream outputStream) {
        super(context, cVar, inputStream, outputStream);
        this.e = new com.baidu.android.pushservice.b.a(inputStream);
    }

    private String a(byte[] bArr) {
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

    private void a(PublicMsg publicMsg, long j) {
        Intent intent = new Intent(this.c, PushService.class);
        intent.setAction("com.baidu.pushservice.action.publicmsg.CLICK");
        intent.setData(Uri.parse("content://" + Long.toString(j)));
        intent.putExtra("public_msg", publicMsg);
        PendingIntent service = PendingIntent.getService(this.c, 0, intent, 0);
        Intent intent2 = new Intent(this.c, PushService.class);
        intent2.setAction("com.baidu.pushservice.action.publicmsg.DELETE");
        intent2.setData(Uri.parse("content://" + Long.toString(j)));
        intent2.putExtra("public_msg", publicMsg);
        PendingIntent service2 = PendingIntent.getService(this.c, 0, intent2, 0);
        Notification notification = new Notification();
        notification.tickerText = publicMsg.a;
        notification.setLatestEventInfo(this.c, publicMsg.a, publicMsg.b, service);
        notification.icon = 17301569;
        notification.sound = RingtoneManager.getDefaultUri(2);
        notification.deleteIntent = service2;
        notification.flags |= 16;
        ((NotificationManager) this.c.getSystemService("notification")).notify((int) j, notification);
    }

    private boolean a(PublicMsg publicMsg) {
        boolean z;
        if (publicMsg.g == 1) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.c.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo != null && "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase()))) {
                return false;
            }
        }
        if (TextUtils.isEmpty(publicMsg.h)) {
            return true;
        }
        try {
            z = this.c.getPackageManager().getPackageInfo(publicMsg.h, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            z = false;
        }
        return (publicMsg.i && z) || !(publicMsg.i || z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private byte[] a(long j, String str, String str2, String str3, long j2, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.baidu.android.pushservice.b.b bVar = new com.baidu.android.pushservice.b.b(byteArrayOutputStream);
        try {
            try {
                bVar.a(Long.parseLong(x.a().b()));
                bVar.a(a(str, 128));
                bVar.a(a(str2, 128));
                bVar.a(a(str3, 128));
                bVar.a(j2);
                bVar.b(i);
                bVar.b(0);
                bVar.b(i2);
                bVar.b(0);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("MessageHandler", e2);
                try {
                    byteArrayOutputStream.close();
                    bVar.a();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            }
        } finally {
            try {
                byteArrayOutputStream.close();
                bVar.a();
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
        com.baidu.android.pushservice.b.b bVar = new com.baidu.android.pushservice.b.b(byteArrayOutputStream);
        int length = bArr != null ? bArr.length : 0;
        try {
            try {
                bVar.a((int) s);
                bVar.a(1);
                bVar.b(0);
                bVar.a(a(com.baidu.android.pushservice.b.d.c(this.c, this.c.getPackageName()) ? "BaiduApp" : "DevApp", 16));
                bVar.b(-76508268);
                bVar.b(1);
                bVar.b(length);
                if (bArr != null) {
                    bVar.a(bArr);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    return byteArray;
                } catch (IOException e) {
                    return byteArray;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                    bVar.a();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return null;
            }
        } finally {
            try {
                byteArrayOutputStream.close();
                bVar.a();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void c(b bVar) {
        int i = new JSONObject(new String(bVar.c)).getInt("ret");
        if (i == 0) {
            Intent intent = new Intent("com.baidu.pushservice.action.connect.STAMP");
            intent.putExtra("last_connect_stamp", System.currentTimeMillis());
            this.c.sendStickyBroadcast(intent);
        } else if (i != 5003) {
            x.a().a((String) null, (String) null);
            throw new d("MessageHandler handle handshake msg failed. ret = " + i);
        } else {
            Intent intent2 = new Intent("com.baidu.pushservice.action.connect.STAMP");
            intent2.putExtra("last_connect_stamp", 0L);
            this.c.sendStickyBroadcast(intent2);
        }
    }

    private void d(b bVar) {
        byte[] a = a((short) 2, (byte[]) null);
        b bVar2 = new b();
        bVar2.c = a;
        a(bVar2);
    }

    private void e(b bVar) {
        int i;
        int i2;
        int i3;
        byte[] bArr = bVar.c;
        if (bArr == null) {
            return;
        }
        com.baidu.android.pushservice.b.a aVar = new com.baidu.android.pushservice.b.a(new ByteArrayInputStream(bArr));
        long c = aVar.c();
        byte[] bArr2 = new byte[128];
        aVar.a(bArr2);
        String a = a(bArr2);
        byte[] bArr3 = new byte[128];
        aVar.a(bArr3);
        String a2 = a(bArr3);
        byte[] bArr4 = new byte[128];
        aVar.a(bArr4);
        String a3 = a(bArr4);
        long c2 = aVar.c();
        int a4 = aVar.a();
        aVar.a();
        aVar.a();
        aVar.a();
        int length = bArr.length - 416;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 416, bArr5, 0, length);
        if (a4 == 0 || a4 == 1) {
            com.baidu.android.pushservice.b b = com.baidu.android.pushservice.a.a(this.c).b(a);
            if (b == null || !b.c.equals(a2)) {
                i = 2;
            } else {
                i = 0;
                Intent intent = new Intent(PushConstants.ACTION_MESSAGE);
                intent.setPackage(b.a);
                intent.putExtra(PushConstants.EXTRA_PUSH_MESSAGE, bArr5);
                intent.setFlags(32);
                this.c.sendBroadcast(intent);
            }
            i2 = i;
        } else if (a4 == 2 || a4 == 3) {
            PublicMsg a5 = g.a(bArr5);
            if (a5 == null || TextUtils.isEmpty(a5.a) || TextUtils.isEmpty(a5.b) || TextUtils.isEmpty(a5.c)) {
                i3 = 2;
            } else if (a(a5) && com.baidu.android.pushservice.b.d.c(this.c, this.c.getPackageName())) {
                a(a5, c2);
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i3;
        } else {
            i2 = 2;
        }
        byte[] a6 = a((short) 3, a(c, a, a2, a3, c2, a4, i2));
        b bVar2 = new b();
        bVar2.c = a6;
        a(bVar2);
    }

    @Override // com.baidu.android.pushservice.message.a
    public b a() {
        short b = this.e.b();
        this.e.b();
        this.e.a();
        this.e.a(new byte[16]);
        this.e.a();
        this.e.a();
        int a = this.e.a();
        byte[] bArr = null;
        if (a > 0) {
            bArr = new byte[a];
            this.e.a(bArr);
        }
        b bVar = new b();
        bVar.a = b;
        bVar.c = bArr;
        return bVar;
    }

    @Override // com.baidu.android.pushservice.message.a
    public void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel_token", x.a().c());
            jSONObject.put("channel_id", x.a().b());
            jSONObject.put("period", 1800);
            jSONObject.put("channel_type", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        byte[] a = a((short) 1, jSONObject.toString().getBytes());
        b bVar = new b();
        bVar.c = a;
        bVar.d = true;
        a(bVar);
    }

    @Override // com.baidu.android.pushservice.message.a
    public void b(b bVar) {
        if (bVar == null) {
            return;
        }
        int i = bVar.a;
        if (i == 1) {
            c(bVar);
        } else if (i == 2) {
            d(bVar);
        } else if (i == 4 || i != 3) {
        } else {
            e(bVar);
        }
    }

    @Override // com.baidu.android.pushservice.message.a
    public void c() {
    }

    @Override // com.baidu.android.pushservice.message.a
    public void d() {
        byte[] a = a((short) 4, (byte[]) null);
        b bVar = new b();
        bVar.c = a;
        bVar.d = true;
        a(bVar);
    }
}
