package com.baidu.swan.apps.r.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.swan.c.d;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes8.dex */
public class c extends HandlerThread {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch cvf;
    private File cvg;

    /* loaded from: classes8.dex */
    public static class a {
        byte[] content;
        String path;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, File file, CountDownLatch countDownLatch) {
        this(str, 0, file, countDownLatch);
    }

    private c(String str, int i, File file, CountDownLatch countDownLatch) {
        super(str, i);
        this.cvg = file;
        this.cvf = countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler aoI() {
        return new Handler(getLooper()) { // from class: com.baidu.swan.apps.r.a.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 100) {
                    a aVar = (a) message.obj;
                    File file = new File(c.this.cvg + aVar.path);
                    try {
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(aVar.content);
                        d.closeSafely(fileOutputStream);
                    } catch (Exception e) {
                        if (c.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                } else if (message.what == 200) {
                    if (c.this.cvf != null) {
                        c.this.cvf.countDown();
                    }
                    c.this.quit();
                }
            }
        };
    }
}
