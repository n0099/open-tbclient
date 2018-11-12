package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a implements Serializable {
    public ArrayList<b> a;

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        this.a = null;
        if (activityInfoArr != null && (length = activityInfoArr.length) > 0) {
            this.a = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                if (activityInfoArr[i] != null) {
                    b bVar = new b();
                    bVar.h = activityInfoArr[i].configChanges;
                    bVar.f = activityInfoArr[i].flags;
                    bVar.l = activityInfoArr[i].labelRes;
                    bVar.b = activityInfoArr[i].launchMode;
                    if (activityInfoArr[i].nonLocalizedLabel != null) {
                        bVar.m = activityInfoArr[i].nonLocalizedLabel.toString();
                    }
                    bVar.j = activityInfoArr[i].name;
                    bVar.k = activityInfoArr[i].packageName;
                    bVar.c = activityInfoArr[i].permission;
                    bVar.g = activityInfoArr[i].screenOrientation;
                    bVar.i = activityInfoArr[i].softInputMode;
                    bVar.e = activityInfoArr[i].targetActivity;
                    bVar.d = activityInfoArr[i].taskAffinity;
                    bVar.a = activityInfoArr[i].theme;
                    this.a.add(bVar);
                }
            }
        }
    }

    public byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException e) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
            }
        } catch (IOException e2) {
            objectOutputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(this.a);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e3) {
                    com.baidu.sofire.b.e.a(e3);
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        } catch (IOException e4) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e5) {
                    com.baidu.sofire.b.e.a(e5);
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e6) {
                    com.baidu.sofire.b.e.a(e6);
                    throw th;
                }
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.ArrayList<com.baidu.sofire.core.b> a(byte[] r4) {
        /*
            r1 = 0
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L21
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L21
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L4c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r0 = r2.readObject()     // Catch: java.lang.Throwable -> L50
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L16
            r2.close()     // Catch: java.io.IOException -> L1c
        L16:
            if (r3 == 0) goto L1b
            r3.close()     // Catch: java.io.IOException -> L1c
        L1b:
            return r0
        L1c:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L1b
        L21:
            r0 = move-exception
            r0 = r1
            r2 = r1
        L24:
            if (r0 == 0) goto L29
            r0.close()     // Catch: java.io.IOException -> L30
        L29:
            if (r2 == 0) goto L2e
            r2.close()     // Catch: java.io.IOException -> L30
        L2e:
            r0 = r1
            goto L1b
        L30:
            r0 = move-exception
            com.baidu.sofire.b.e.a(r0)
            goto L2e
        L35:
            r0 = move-exception
            r3 = r1
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L42
        L3c:
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L42
        L41:
            throw r0
        L42:
            r1 = move-exception
            com.baidu.sofire.b.e.a(r1)
            goto L41
        L47:
            r0 = move-exception
            goto L37
        L49:
            r0 = move-exception
            r1 = r2
            goto L37
        L4c:
            r0 = move-exception
            r0 = r1
            r2 = r3
            goto L24
        L50:
            r0 = move-exception
            r0 = r2
            r2 = r3
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.a.a(byte[]):java.util.ArrayList");
    }
}
