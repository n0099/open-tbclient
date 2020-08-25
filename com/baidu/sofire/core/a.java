package com.baidu.sofire.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes20.dex */
public final class a implements Serializable {
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

    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(this.a);
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        com.baidu.sofire.i.e.a();
                    }
                } catch (IOException e2) {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e3) {
                            com.baidu.sofire.i.e.a();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                            com.baidu.sofire.i.e.a();
                            throw th;
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                objectOutputStream = null;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
            }
        } catch (IOException e6) {
            objectOutputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            objectOutputStream = null;
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
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L1d
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1d
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L48
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L48
            java.lang.Object r0 = r2.readObject()     // Catch: java.lang.Throwable -> L4c
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch: java.lang.Throwable -> L4c
            r2.close()     // Catch: java.io.IOException -> L18
            r3.close()     // Catch: java.io.IOException -> L18
        L17:
            return r0
        L18:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L17
        L1d:
            r0 = move-exception
            r0 = r1
            r2 = r1
        L20:
            if (r0 == 0) goto L25
            r0.close()     // Catch: java.io.IOException -> L2c
        L25:
            if (r2 == 0) goto L2a
            r2.close()     // Catch: java.io.IOException -> L2c
        L2a:
            r0 = r1
            goto L17
        L2c:
            r0 = move-exception
            com.baidu.sofire.i.e.a()
            goto L2a
        L31:
            r0 = move-exception
            r3 = r1
        L33:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.io.IOException -> L3e
        L38:
            if (r3 == 0) goto L3d
            r3.close()     // Catch: java.io.IOException -> L3e
        L3d:
            throw r0
        L3e:
            r1 = move-exception
            com.baidu.sofire.i.e.a()
            goto L3d
        L43:
            r0 = move-exception
            goto L33
        L45:
            r0 = move-exception
            r1 = r2
            goto L33
        L48:
            r0 = move-exception
            r0 = r1
            r2 = r3
            goto L20
        L4c:
            r0 = move-exception
            r0 = r2
            r2 = r3
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.core.a.a(byte[]):java.util.ArrayList");
    }
}
