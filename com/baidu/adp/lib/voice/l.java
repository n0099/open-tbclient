package com.baidu.adp.lib.voice;
/* loaded from: classes.dex */
public class l {
    private static l oA;
    private static int[] oB = {8000, 11025, 16000, 22050, 32000, 44100, 47250, 48000};
    private static short[] oC = {2, 3};
    private static short[] oD = {2, 16, 12, 3};
    private int ow;
    private short ox;
    private short oy;
    private int oz = -2;

    public static l fH() {
        l lVar;
        if (oA == null) {
            synchronized (l.class) {
                if (oA == null) {
                    oA = new l();
                }
                lVar = oA;
            }
            return lVar;
        }
        return oA;
    }

    private l() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=6, 150=6, 151=6] */
    public android.media.AudioRecord fI() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.ow
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.ox
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.oy
            if (r1 <= 0) goto L29
            android.media.AudioRecord r1 = new android.media.AudioRecord
            r2 = 1
            r0 = r18
            int r3 = r0.ow
            r0 = r18
            short r4 = r0.oy
            r0 = r18
            short r5 = r0.ox
            r0 = r18
            int r6 = r0.oz
            r1.<init>(r2, r3, r4, r5, r6)
        L28:
            return r1
        L29:
            r2 = 0
            int[] r12 = com.baidu.adp.lib.voice.l.oB
            int r13 = r12.length
            r1 = 0
            r9 = r1
            r1 = r2
        L30:
            if (r9 < r13) goto L3a
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L3a:
            r3 = r12[r9]
            short[] r14 = com.baidu.adp.lib.voice.l.oC
            int r15 = r14.length
            r2 = 0
            r10 = r2
            r2 = r1
        L42:
            if (r10 < r15) goto L49
            int r1 = r9 + 1
            r9 = r1
            r1 = r2
            goto L30
        L49:
            short r5 = r14[r10]
            short[] r16 = com.baidu.adp.lib.voice.l.oD
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r7 = r2
        L55:
            r0 = r17
            if (r11 < r0) goto L5e
            int r1 = r10 + 1
            r10 = r1
            r2 = r7
            goto L42
        L5e:
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L126
            r0 = r18
            r0.oz = r1     // Catch: java.lang.Throwable -> L126
            r0 = r18
            int r1 = r0.oz     // Catch: java.lang.Throwable -> L126
            r2 = -2
            if (r1 != r2) goto L81
            if (r7 == 0) goto L12a
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L12a
            r7.release()
            r1 = 0
        L7c:
            int r2 = r11 + 1
            r11 = r2
            r7 = r1
            goto L55
        L81:
            r0 = r18
            int r1 = r0.oz     // Catch: java.lang.Throwable -> L126
            int r1 = r1 * 8
            r2 = 4096(0x1000, float:5.74E-42)
            int r6 = java.lang.Math.min(r1, r2)     // Catch: java.lang.Throwable -> L126
            android.media.AudioRecord r8 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L126
            r2 = 1
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L126
            int r1 = r8.getState()     // Catch: java.lang.Throwable -> Le8
            r2 = 1
            if (r1 != r2) goto Lba
            r0 = r18
            r0.ow = r3     // Catch: java.lang.Throwable -> Le8
            r0 = r18
            r0.ox = r5     // Catch: java.lang.Throwable -> Le8
            r0 = r18
            r0.oy = r4     // Catch: java.lang.Throwable -> Le8
            r0 = r18
            r0.oz = r6     // Catch: java.lang.Throwable -> Le8
            if (r8 == 0) goto Lb7
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto Lb7
            r8.release()
        Lb7:
            r1 = r8
            goto L28
        Lba:
            r8.release()     // Catch: java.lang.Throwable -> Le8
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Le8
            r2 = 1
            r0 = r18
            int r6 = r0.oz     // Catch: java.lang.Throwable -> Le8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Le8
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L124
            r6 = 1
            if (r2 != r6) goto L10a
            r0 = r18
            r0.ow = r3     // Catch: java.lang.Throwable -> L124
            r0 = r18
            r0.ox = r5     // Catch: java.lang.Throwable -> L124
            r0 = r18
            r0.oy = r4     // Catch: java.lang.Throwable -> L124
            if (r1 == 0) goto L28
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Le8:
            r1 = move-exception
            r2 = r1
            r1 = r8
        Leb:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L11d
            if (r1 == 0) goto L7c
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7c
            r1.release()
            r1 = 0
            goto L7c
        Lfc:
            r1 = move-exception
        Lfd:
            if (r8 == 0) goto L109
            int r2 = r8.getState()
            r3 = 1
            if (r2 == r3) goto L109
            r8.release()
        L109:
            throw r1
        L10a:
            if (r1 == 0) goto L7c
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7c
            r1.release()
            r1 = 0
            goto L7c
        L119:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lfd
        L11d:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lfd
        L121:
            r1 = move-exception
            r8 = r7
            goto Lfd
        L124:
            r2 = move-exception
            goto Leb
        L126:
            r1 = move-exception
            r2 = r1
            r1 = r7
            goto Leb
        L12a:
            r1 = r7
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.adp.lib.voice.l.fI():android.media.AudioRecord");
    }
}
