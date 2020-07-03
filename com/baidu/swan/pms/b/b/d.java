package com.baidu.swan.pms.b.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.ConnectManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.pms.d.DEBUG;
    private final Deque<a> dql;
    private final Deque<a> dqm;
    private final ExecutorService executorService;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b {
        private static d dqp = new d();
    }

    private d() {
        this.dql = new ArrayDeque();
        this.dqm = new ArrayDeque();
        this.executorService = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static d aHk() {
        return b.dqp;
    }

    public synchronized void a(@NonNull com.baidu.swan.pms.b.b.a aVar) {
        a aVar2 = new a(aVar);
        if (this.dqm.size() < 1) {
            this.dqm.add(aVar2);
            this.executorService.execute(aVar2);
        } else {
            this.dql.add(aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(@NonNull a aVar) {
        if (!this.dqm.remove(aVar) && DEBUG) {
            throw new RuntimeException("runningCalls remove fail ");
        }
        if (this.dqm.size() < 1 && !this.dql.isEmpty()) {
            Iterator<a> it = this.dql.iterator();
            while (it.hasNext()) {
                a next = it.next();
                it.remove();
                this.dqm.add(next);
                this.executorService.execute(next);
                if (this.dqm.size() >= 1) {
                    break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public final class a implements Runnable {
        private File ckZ;
        @NonNull
        private com.baidu.swan.pms.b.b.a dqn;
        public String filePath = "";

        a(@NonNull com.baidu.swan.pms.b.b.a aVar) {
            this.dqn = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.DEBUG) {
                Log.d("Mini-Pm-Download", "run thread: " + Thread.currentThread().getName() + " md5: " + this.dqn.md5);
            }
            execute();
            d.this.a(this);
        }

        private void execute() {
            com.baidu.swan.pms.b.b bVar = this.dqn.dqk;
            if (!ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                com.baidu.swan.pms.b.b.b bVar2 = new com.baidu.swan.pms.b.b.b(1003, "无网");
                if (d.DEBUG) {
                    Log.d("Mini-Pm-Download", bVar2.toString());
                }
                bVar.a(bVar2);
            } else if (!aHl()) {
                com.baidu.swan.pms.b.b.b bVar3 = new com.baidu.swan.pms.b.b.b(1004, "创建本地文件失败");
                if (d.DEBUG) {
                    Log.d("Mini-Pm-Download", bVar3.toString());
                }
                bVar.a(bVar3);
            } else {
                try {
                    Response executeSync = com.baidu.swan.c.c.a.aGD().getRequest().url(this.dqn.downloadUrl).build().executeSync();
                    com.baidu.swan.pms.b.b.b e = e(executeSync, executeSync.code());
                    e.filePath = this.filePath;
                    if (d.DEBUG) {
                        Log.d("Mini-Pm-Download", "parseResponse: " + e.toString());
                    }
                    if (e.isSuccess()) {
                        bVar.b(e);
                    } else {
                        bVar.a(e);
                    }
                    if (executeSync != null) {
                        if (0 != 0) {
                            executeSync.close();
                        } else {
                            executeSync.close();
                        }
                    }
                } catch (Exception e2) {
                    if (d.DEBUG) {
                        Log.e("Mini-Pm-Download", "execute with exception", e2);
                    }
                    bVar.a(new com.baidu.swan.pms.b.b.b(1005, "execute with exception: " + e2.getMessage(), this.filePath));
                }
            }
        }

        private boolean aHl() {
            if (TextUtils.isEmpty(this.filePath)) {
                this.ckZ = com.baidu.swan.pms.f.c.cP(c.afR().getPath(), this.dqn.md5);
                if (this.ckZ == null) {
                    return false;
                }
                this.filePath = this.ckZ.getAbsolutePath();
                return true;
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [275=5, 277=5, 278=5, 279=5] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0111 -> B:71:0x0023). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0113 -> B:71:0x0023). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0119 -> B:71:0x0023). Please submit an issue!!! */
        @NonNull
        private com.baidu.swan.pms.b.b.b e(@NonNull Response response, int i) {
            com.baidu.swan.pms.b.b.b bVar;
            if (i < 200 || i > 300) {
                return new com.baidu.swan.pms.b.b.b(1005, "http status code: " + i);
            }
            ResponseBody body = response.body();
            if (body == null) {
                return new com.baidu.swan.pms.b.b.b(1005, "response body is null");
            }
            long contentLength = body.contentLength();
            if (contentLength <= 0 || contentLength == this.dqn.size) {
                if (c.p(c.afR().getPath(), this.dqn.size)) {
                    BufferedSource source = body.source();
                    try {
                        if (source == null) {
                            return new com.baidu.swan.pms.b.b.b(1005, "body source is null");
                        }
                        try {
                            if (!c.a(Channels.newInputStream(source), new FileOutputStream(this.ckZ), contentLength)) {
                                bVar = new com.baidu.swan.pms.b.b.b(1008, "写入磁盘出错");
                                if (source.isOpen()) {
                                    try {
                                        source.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (c.e(this.filePath, this.dqn.size, this.dqn.md5)) {
                                bVar = new com.baidu.swan.pms.b.b.b(0, "成功");
                                if (source.isOpen()) {
                                    try {
                                        source.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } else {
                                bVar = new com.baidu.swan.pms.b.b.b(1009, "md5 校验失败");
                            }
                        } catch (IOException e3) {
                            bVar = new com.baidu.swan.pms.b.b.b(1008, "写入磁盘出错: " + e3.getMessage());
                            if (source.isOpen()) {
                                try {
                                    source.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        return bVar;
                    } finally {
                        if (source.isOpen()) {
                            try {
                                source.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
                return new com.baidu.swan.pms.b.b.b(1007, "磁盘空间不足");
            }
            return new com.baidu.swan.pms.b.b.b(1006, "真实文件大小跟服务器返回的size不一样");
        }
    }
}
