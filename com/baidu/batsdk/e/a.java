package com.baidu.batsdk.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Process;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.g;
import com.baidu.batsdk.ui.BatsdkService;
/* loaded from: classes.dex */
public final class a {
    private static long a = 0;

    public static void a(Context context) {
        b(context);
    }

    public static void a(Activity activity) {
        b(activity.getApplicationContext());
    }

    public static void a() {
    }

    private static void b(final Context context) {
        final long j = com.baidu.batsdk.a.e;
        long j2 = com.baidu.batsdk.a.d;
        long q = com.baidu.batsdk.b.b.q(context);
        long p = com.baidu.batsdk.b.b.p(context);
        com.baidu.batsdk.f.a.a("confEAT:" + j + " confEAP:" + j2 + " syncEAT:" + q + " syncEAP:" + p);
        if (0 != j2 || 0 != j || 0 != p || 0 != q) {
            long a2 = g.a();
            if (j2 > 0 && (j >= j2 + a2 || 0 == j)) {
                j = j2 + a2;
            }
            if (q > 0 && (j >= q || 0 == j)) {
                j = q;
            }
            if (p > 0 && (j >= p + a2 || 0 == j)) {
                j = p + a2;
            }
            com.baidu.batsdk.f.a.a("eat: " + j);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > j) {
                Handler a3 = BatsdkService.a();
                if (a3 != null) {
                    a3.post(new Runnable() { // from class: com.baidu.batsdk.e.a.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setIcon(new BitmapDrawable(context.getResources(), com.baidu.batsdk.b.b.g()));
                            builder.setTitle("过期提醒 - " + e.b());
                            builder.setMessage("亲，感谢您使用" + e.b() + "测试版，很遗憾它已于" + com.baidu.batsdk.b.b.a(j) + "过期了!!! \n请检查新版或联系管理员。");
                            builder.setPositiveButton("检查新版", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.e.a.2.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            builder.setNegativeButton("退出程序", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.e.a.2.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    a.b();
                                }
                            });
                            AlertDialog create = builder.create();
                            create.getWindow().setType(2003);
                            create.setCanceledOnTouchOutside(false);
                            create.setOnDismissListener(new DialogInterface.OnDismissListener(this) { // from class: com.baidu.batsdk.e.a.2.3
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    a.b();
                                }
                            });
                            create.show();
                        }
                    });
                }
            } else if (currentTimeMillis > j - 172800000 && currentTimeMillis - a > 43200000) {
                final long j3 = j - currentTimeMillis;
                Handler a4 = BatsdkService.a();
                if (a4 != null) {
                    a4.post(new Runnable() { // from class: com.baidu.batsdk.e.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String str;
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setIcon(new BitmapDrawable(context.getResources(), com.baidu.batsdk.b.b.g()));
                            builder.setTitle("过期提醒 - " + e.b());
                            StringBuilder append = new StringBuilder("感谢您使用").append(e.b()).append("测试版，由于版本有时间限制，您只能再使用");
                            long j4 = j3;
                            long j5 = j4 / 86400000;
                            long j6 = j4 / 3600000;
                            long j7 = j4 / 60000;
                            if (j5 > 0) {
                                str = j5 + "天";
                            } else {
                                str = j6 > 0 ? j6 + "小时" : j7 > 0 ? j7 + "分" : (j4 / 1000) + "秒";
                            }
                            builder.setMessage(append.append(str).append("，请尽量完成测试，非常谢谢您的配合！").toString());
                            builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.e.a.1.1
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
                a = currentTimeMillis;
            }
        }
    }

    public static void b() {
        Process.killProcess(Process.myPid());
        System.exit(10);
        com.baidu.batsdk.f.a.d("endApplication fail!!!!!!!!!");
    }
}
