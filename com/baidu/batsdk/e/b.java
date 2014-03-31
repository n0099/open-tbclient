package com.baidu.batsdk.e;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.ui.BatsdkService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class b {
    private static Context a;
    private static ActivityManager b;

    public static void b(Context context) {
        if (a == null) {
            a = context;
            b = (ActivityManager) context.getSystemService("activity");
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 8192);
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                sb.append(readLine).append(IOUtils.LINE_SEPARATOR_UNIX);
                i = i2;
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            com.baidu.batsdk.f.a.b("getSysMemInfo fail.", e);
        } catch (IOException e2) {
            com.baidu.batsdk.f.a.b("getSysMemInfo fail.", e2);
        }
        return sb.toString();
    }

    public static void a(Context context) {
        String n = com.baidu.batsdk.b.b.n(context);
        String u = com.baidu.batsdk.b.b.u(context);
        long v = com.baidu.batsdk.b.b.v(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (n.equals(u)) {
            long s = com.baidu.batsdk.b.b.s(context);
            long t = com.baidu.batsdk.b.b.t(context);
            if (0 != s) {
                if ((t <= 0 || currentTimeMillis - t <= 0) && currentTimeMillis - v > s * 3600 * 1000) {
                    String o = com.baidu.batsdk.b.b.o(context);
                    if (o.length() > 0) {
                        a(context, o);
                        com.baidu.batsdk.b.b.x(context);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        String o2 = com.baidu.batsdk.b.b.o(context);
        if (o2.length() > 0) {
            a(context, o2);
            com.baidu.batsdk.b.b.x(context);
        }
    }

    public static String b() {
        Debug.MemoryInfo memoryInfo;
        StringBuilder sb = new StringBuilder();
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        b.getMemoryInfo(memoryInfo2);
        sb.append("isLowMem: ").append(memoryInfo2.lowMemory ? "yes" : "no").append("\navailMem: ").append(com.baidu.batsdk.b.b.b(memoryInfo2.availMem)).append("\nthreshold: ").append(com.baidu.batsdk.b.b.b(memoryInfo2.threshold)).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (com.baidu.batsdk.b.b.h() >= 5 && (memoryInfo = b.getProcessMemoryInfo(new int[]{Process.myPid()})[0]) != null) {
            sb.append("totalPrivateDirty: ").append(com.baidu.batsdk.b.b.b(memoryInfo.getTotalPrivateDirty() << 10)).append("\ntotalPss: ").append(com.baidu.batsdk.b.b.b(memoryInfo.getTotalPss() << 10)).append("\ntotalSharedDirty: ").append(com.baidu.batsdk.b.b.b(memoryInfo.getTotalSharedDirty() << 10)).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    private static void a(final Context context, final String str) {
        Handler a2 = BatsdkService.a();
        if (a2 != null) {
            a2.post(new Runnable() { // from class: com.baidu.batsdk.e.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setIcon(new BitmapDrawable(context.getResources(), com.baidu.batsdk.b.b.g()));
                    builder.setTitle("消息提醒 - " + e.b());
                    builder.setMessage(str);
                    builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener(this) { // from class: com.baidu.batsdk.e.b.1.1
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
