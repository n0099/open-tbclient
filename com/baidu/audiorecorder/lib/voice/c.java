package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
public class c {
    private static c IO;
    private static int[] IP = {8000, 11025, 16000, 22050, 32000, 44100, 47250, 48000};
    private static short[] IQ = {2, 3};
    private static short[] IR = {2, 16, 12, 3};
    private int IK;
    private short IL;
    private short IM;
    private int IN = -2;

    public static c lA() {
        c cVar;
        if (IO == null) {
            synchronized (c.class) {
                if (IO == null) {
                    IO = new c();
                }
                cVar = IO;
            }
            return cVar;
        }
        return IO;
    }

    private c() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=7, 150=6, 151=6, 152=6] */
    public android.media.AudioRecord lB() throws java.lang.IllegalArgumentException {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.IK
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.IL
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.IM
            if (r1 <= 0) goto L29
            android.media.AudioRecord r1 = new android.media.AudioRecord
            r2 = 1
            r0 = r18
            int r3 = r0.IK
            r0 = r18
            short r4 = r0.IM
            r0 = r18
            short r5 = r0.IL
            r0 = r18
            int r6 = r0.IN
            r1.<init>(r2, r3, r4, r5, r6)
        L28:
            return r1
        L29:
            r2 = 0
            int[] r12 = com.baidu.audiorecorder.lib.voice.c.IP
            int r13 = r12.length
            r1 = 0
            r9 = r1
            r1 = r2
        L30:
            if (r9 >= r13) goto L112
            r3 = r12[r9]
            short[] r14 = com.baidu.audiorecorder.lib.voice.c.IQ
            int r15 = r14.length
            r2 = 0
            r10 = r2
            r2 = r1
        L3a:
            if (r10 >= r15) goto L10c
            short r5 = r14[r10]
            short[] r16 = com.baidu.audiorecorder.lib.voice.c.IR
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r7 = r2
        L48:
            r0 = r17
            if (r11 >= r0) goto L106
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L128
            r0 = r18
            r0.IN = r1     // Catch: java.lang.Throwable -> L128
            r0 = r18
            int r1 = r0.IN     // Catch: java.lang.Throwable -> L128
            r2 = -2
            if (r1 != r2) goto L6f
            if (r7 == 0) goto L12c
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L12c
            r7.release()
            r1 = 0
        L6a:
            int r2 = r11 + 1
            r11 = r2
            r7 = r1
            goto L48
        L6f:
            r0 = r18
            int r1 = r0.IN     // Catch: java.lang.Throwable -> L128
            int r1 = r1 * 8
            r2 = 4096(0x1000, float:5.74E-42)
            int r6 = java.lang.Math.min(r1, r2)     // Catch: java.lang.Throwable -> L128
            android.media.AudioRecord r8 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L128
            r2 = 1
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L128
            int r1 = r8.getState()     // Catch: java.lang.Throwable -> Le3
            r2 = 1
            if (r1 != r2) goto La7
            r0 = r18
            r0.IK = r3     // Catch: java.lang.Throwable -> Le3
            r0 = r18
            r0.IL = r5     // Catch: java.lang.Throwable -> Le3
            r0 = r18
            r0.IM = r4     // Catch: java.lang.Throwable -> Le3
            r0 = r18
            r0.IN = r6     // Catch: java.lang.Throwable -> Le3
            if (r8 == 0) goto La5
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto La5
            r8.release()
        La5:
            r1 = r8
            goto L28
        La7:
            r8.release()     // Catch: java.lang.Throwable -> Le3
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Le3
            r2 = 1
            r0 = r18
            int r6 = r0.IN     // Catch: java.lang.Throwable -> Le3
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Le3
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L126
            r6 = 1
            if (r2 != r6) goto Ld5
            r0 = r18
            r0.IK = r3     // Catch: java.lang.Throwable -> L126
            r0 = r18
            r0.IL = r5     // Catch: java.lang.Throwable -> L126
            r0 = r18
            r0.IM = r4     // Catch: java.lang.Throwable -> L126
            if (r1 == 0) goto L28
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Ld5:
            if (r1 == 0) goto L6a
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L6a
            r1.release()
            r1 = 0
            goto L6a
        Le3:
            r1 = move-exception
            r2 = r1
            r1 = r8
        Le6:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L11f
            if (r1 == 0) goto L6a
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L6a
            r1.release()
            r1 = 0
            goto L6a
        Lf8:
            r1 = move-exception
        Lf9:
            if (r8 == 0) goto L105
            int r2 = r8.getState()
            r3 = 1
            if (r2 == r3) goto L105
            r8.release()
        L105:
            throw r1
        L106:
            int r1 = r10 + 1
            r10 = r1
            r2 = r7
            goto L3a
        L10c:
            int r1 = r9 + 1
            r9 = r1
            r1 = r2
            goto L30
        L112:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L11b:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lf9
        L11f:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lf9
        L123:
            r1 = move-exception
            r8 = r7
            goto Lf9
        L126:
            r2 = move-exception
            goto Le6
        L128:
            r1 = move-exception
            r2 = r1
            r1 = r7
            goto Le6
        L12c:
            r1 = r7
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.audiorecorder.lib.voice.c.lB():android.media.AudioRecord");
    }
}
