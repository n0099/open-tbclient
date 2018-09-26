package cn.jiguang.d.d;

import android.content.Context;
import android.net.http.Headers;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class g {
    public static cn.jiguang.d.b.j L(String str) {
        cn.jiguang.d.b.j jVar;
        try {
            jVar = new cn.jiguang.d.b.j();
            jVar.a(str);
            jVar.b(str);
        } catch (Exception e) {
            cn.jiguang.e.c.a("ConnectingHelper", "parseSisInfo crash:", e);
        }
        if (jVar.e()) {
            return null;
        }
        return jVar;
    }

    public static InetAddress M(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})").matcher(str).matches()) {
            try {
                return InetAddress.getByName(str);
            } catch (UnknownHostException e) {
                return null;
            }
        }
        h hVar = new h(str);
        try {
            hVar.start();
            hVar.join(3000L);
            return hVar.bF();
        } catch (InterruptedException e2) {
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (z) {
            cn.jiguang.e.c.d("ConnectingHelper", "Register Failed with server error - code:" + i);
            String a = cn.jiguang.g.h.a(i);
            if (!TextUtils.isEmpty(a)) {
                cn.jiguang.e.c.c("ConnectingHelper", "Local error description: " + a);
            }
        }
        String b = cn.jiguang.d.a.b(context);
        if (1006 == i) {
            cn.jiguang.g.a.a(context, "包名: " + cn.jiguang.d.a.c + " 不存在", -1);
            cn.jiguang.d.a.a.i();
        } else if (1007 != i) {
            if (1005 == i) {
                cn.jiguang.g.a.a(context, "包名: " + cn.jiguang.d.a.c + " 与 AppKey:" + b + "不匹配", -1);
                cn.jiguang.d.a.a.i();
            } else if (1009 == i) {
                cn.jiguang.g.a.a(context, " AppKey:" + b + " 非android AppKey", -1);
                cn.jiguang.d.a.a.i();
            } else if (1008 == i) {
                cn.jiguang.g.a.a(context, " AppKey:" + b + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
                cn.jiguang.d.a.a.i();
            } else if (10001 == i) {
                cn.jiguang.g.a.a(context, " 未在manifest中配置AppKey", -1);
            } else if (1012 == i) {
                cn.jiguang.d.a.a.a();
            }
        }
    }

    public static void a(Context context, long j) {
        cn.jiguang.e.c.a("ConnectingHelper", "Action - sendServerTimer");
        try {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("push_login_server_time", j);
            jSONObject.put("push_login_local_time", System.currentTimeMillis());
            bundle.putString("push_to_im_data", jSONObject.toString());
            cn.jiguang.g.a.a(context, "cn.jpush.im.android.action.IM_RESPONSE", bundle);
        } catch (JSONException e) {
        }
    }

    public static void a(Context context, boolean z) {
        cn.jiguang.e.c.a("ConnectingHelper", "Action - sendConnectionChanged");
        Bundle bundle = new Bundle();
        bundle.putBoolean(JPushInterface.EXTRA_CONNECTION_CHANGE, z);
        cn.jiguang.g.a.a(context, JPushInterface.ACTION_CONNECTION_CHANGE, bundle);
    }

    public static void a(Message message, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(Headers.CONN_DIRECTIVE, j);
        message.setData(bundle);
        message.sendToTarget();
    }

    public static synchronized byte[] a(String str, int i, byte[] bArr, boolean z, int i2) {
        byte[] byteArray;
        synchronized (g.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(300);
            bVar.l(0);
            bVar.writeByteArray(str.getBytes());
            bVar.g(i);
            bVar.l(i2);
            bVar.writeByteArray(bArr);
            bVar.l(bVar.current(), 0);
            bVar.k(z ? 1 : 0, 4);
            byteArray = bVar.toByteArray();
        }
        return byteArray;
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.e.c.a("ConnectingHelper", "SIS Receiving...");
        datagramSocket.receive(datagramPacket2);
        byte[] bArr = new byte[datagramPacket2.getLength()];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, bArr.length);
        return bArr;
    }
}
