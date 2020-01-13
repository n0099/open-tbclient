package com.baidu.swan.mini.e;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.m;
import java.io.File;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public interface a {
        void onFailed(int i, String str);

        void onSuccess(String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void pT(@NonNull String str);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.swan.mini.e.c.1.run():void] */
    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    @NonNull
    public static String pY(@NonNull String str) {
        return str + File.separator + "mini";
    }

    public static void a(@NonNull final String str, @NonNull final b bVar) {
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.mini.e.c.1
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
                	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
                	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                */
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=4, 94=4] */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r8 = this;
                    r2 = 0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Exception -> L59
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L59
                    r1.<init>()     // Catch: java.lang.Exception -> L59
                    java.lang.String r4 = r1     // Catch: java.lang.Exception -> L59
                    java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> L59
                    java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Exception -> L59
                    java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> L59
                    java.lang.String r4 = "app-code-info.json"
                    java.lang.StringBuilder r1 = r1.append(r4)     // Catch: java.lang.Exception -> L59
                    java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L59
                    r3.<init>(r1)     // Catch: java.lang.Exception -> L59
                    r1 = 0
                    java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4c
                    r4.<init>(r3)     // Catch: java.lang.Throwable -> L4c
                    r5 = 0
                L2e:
                    java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L3e
                    if (r6 == 0) goto L72
                    r0.append(r6)     // Catch: java.lang.Throwable -> L3e
                    java.lang.String r6 = "\r\n"
                    r0.append(r6)     // Catch: java.lang.Throwable -> L3e
                    goto L2e
                L3e:
                    r0 = move-exception
                    throw r0     // Catch: java.lang.Throwable -> L40
                L40:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                L44:
                    if (r4 == 0) goto L4b
                    if (r1 == 0) goto Lbe
                    r4.close()     // Catch: java.lang.Throwable -> Lb9
                L4b:
                    throw r0     // Catch: java.lang.Throwable -> L4c
                L4c:
                    r0 = move-exception
                    throw r0     // Catch: java.lang.Throwable -> L4e
                L4e:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                L51:
                    if (r3 == 0) goto L58
                    if (r2 == 0) goto Ld0
                    r3.close()     // Catch: java.lang.Throwable -> Lcb
                L58:
                    throw r0     // Catch: java.lang.Exception -> L59
                L59:
                    r0 = move-exception
                    boolean r0 = com.baidu.swan.mini.e.c.access$000()
                    if (r0 == 0) goto L69
                    java.lang.String r0 = "SwanMiniRuntime"
                    java.lang.String r1 = "Error in loadAppCodeInfoJsonStr"
                    android.util.Log.e(r0, r1)
                L69:
                    com.baidu.swan.mini.e.c$b r0 = r2
                    java.lang.String r1 = ""
                    r0.pT(r1)
                L71:
                    return
                L72:
                    if (r4 == 0) goto L79
                    if (r2 == 0) goto Lb5
                    r4.close()     // Catch: java.lang.Throwable -> Lae
                L79:
                    if (r3 == 0) goto L80
                    if (r2 == 0) goto Lc7
                    r3.close()     // Catch: java.lang.Throwable -> Lc2
                L80:
                    boolean r1 = com.baidu.swan.mini.e.c.access$000()
                    if (r1 == 0) goto La4
                    java.lang.String r1 = "SwanMiniRuntime"
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Called loadAppCodeInfoJsonStr: "
                    java.lang.StringBuilder r2 = r2.append(r3)
                    java.lang.String r3 = r0.toString()
                    java.lang.StringBuilder r2 = r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    android.util.Log.v(r1, r2)
                La4:
                    com.baidu.swan.mini.e.c$b r1 = r2
                    java.lang.String r0 = r0.toString()
                    r1.pT(r0)
                    goto L71
                Lae:
                    r4 = move-exception
                    r5.addSuppressed(r4)     // Catch: java.lang.Throwable -> L4c
                    goto L79
                Lb3:
                    r0 = move-exception
                    goto L51
                Lb5:
                    r4.close()     // Catch: java.lang.Throwable -> L4c
                    goto L79
                Lb9:
                    r4 = move-exception
                    r1.addSuppressed(r4)     // Catch: java.lang.Throwable -> L4c
                    goto L4b
                Lbe:
                    r4.close()     // Catch: java.lang.Throwable -> L4c
                    goto L4b
                Lc2:
                    r2 = move-exception
                    r1.addSuppressed(r2)     // Catch: java.lang.Exception -> L59
                    goto L80
                Lc7:
                    r3.close()     // Catch: java.lang.Exception -> L59
                    goto L80
                Lcb:
                    r1 = move-exception
                    r2.addSuppressed(r1)     // Catch: java.lang.Exception -> L59
                    goto L58
                Ld0:
                    r3.close()     // Catch: java.lang.Exception -> L59
                    goto L58
                Ld4:
                    r0 = move-exception
                    r1 = r2
                    goto L44
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.mini.e.c.AnonymousClass1.run():void");
            }
        }, "loadSlaveJsStringSync");
    }
}
