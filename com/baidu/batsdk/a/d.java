package com.baidu.batsdk.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.g;
import com.baidu.batsdk.ui.BatsdkService;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class d {
    public static long a = 0;
    public static long b = 0;

    public static void a(Context context) {
        String e = com.baidu.batsdk.b.b.e(context);
        if ("NONE".equals(e) || "UNKNOWN".equals(e)) {
            com.baidu.batsdk.f.a.b("upload fail, netType is " + e);
        } else if ("MOBILE".equals(e)) {
            com.baidu.batsdk.f.a.b("netType is MOBILE");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a + 100000) {
                b(context);
            } else if (System.currentTimeMillis() - g.e() > com.baidu.batsdk.a.y) {
                c(context);
            } else if (currentTimeMillis < b + 100000) {
                c(context);
            } else {
                com.baidu.batsdk.f.a.a("Hold.");
            }
        } else if ("WIFI".equals(e)) {
            com.baidu.batsdk.f.a.b("netType is WIFI");
            b(context);
        } else {
            com.baidu.batsdk.f.a.d("UploadStrategy get a unexpected netType: " + e);
        }
    }

    private static void b(Context context) {
        Map<String, Object> m = com.baidu.batsdk.b.b.m(context);
        List<String> list = (List) m.get("crashFiles");
        List<String> list2 = (List) m.get("feedbackFiles");
        com.baidu.batsdk.f.a.b("got " + list.size() + " crashRecords, " + list2.size() + " feedbackRecords, allSize " + com.baidu.batsdk.b.b.b(((Long) m.get("allSize")).longValue()) + ".");
        for (String str : list) {
            byte[] c = com.baidu.batsdk.b.b.c(context, str);
            if (c.length < 100) {
                com.baidu.batsdk.f.a.c("Invalid jsonRecord size " + c.length);
                com.baidu.batsdk.b.b.d(context, str);
            } else if (com.baidu.batsdk.d.b.a("http://batsdk.baidu.com/batsdk/api/add_crash", c)) {
                com.baidu.batsdk.b.b.d(context, str);
                g.a(System.currentTimeMillis());
            }
        }
        for (String str2 : list2) {
            byte[] c2 = com.baidu.batsdk.b.b.c(context, str2);
            if (c2.length < 10) {
                com.baidu.batsdk.f.a.c("Invalid jsonRecord size " + c2.length);
                com.baidu.batsdk.b.b.d(context, str2);
            } else if (com.baidu.batsdk.d.b.a("http://batsdk.baidu.com/batsdk/api/add_feedback", c2)) {
                com.baidu.batsdk.b.b.d(context, str2);
                g.a(System.currentTimeMillis());
            }
        }
    }

    private static void c(final Context context) {
        Handler a2;
        if (com.baidu.batsdk.a.b) {
            Map<String, Object> m = com.baidu.batsdk.b.b.m(context);
            final long longValue = ((Long) m.get("allSize")).longValue();
            final int size = ((List) m.get("crashFiles")).size();
            final int size2 = ((List) m.get("feedbackFiles")).size();
            if ((size > 0 || size2 > 0) && (a2 = BatsdkService.a()) != null) {
                a2.post(new Runnable() { // from class: com.baidu.batsdk.a.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("上传提示 - " + e.b());
                        builder.setMessage("亲，感谢您参与百度App测试！截止当前已收集: 崩溃" + size + "个、反馈" + size2 + "个，总计" + com.baidu.batsdk.b.b.b(longValue) + "。本次测试结果上传可能将消耗2G/3G流量，是否上传？ (上传之后可得积分噢！)");
                        builder.setPositiveButton("现在上传", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.a.d.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                d.a = System.currentTimeMillis();
                                a.a();
                            }
                        }).setNegativeButton("等有wifi再说", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.a.d.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AlertDialog create = builder.create();
                        create.getWindow().setType(2003);
                        create.show();
                    }
                });
            }
        }
    }
}
