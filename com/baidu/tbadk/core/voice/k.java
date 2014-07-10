package com.baidu.tbadk.core.voice;

import com.baidu.channelrtc.medialivesender.LiveSenderControl;
/* loaded from: classes.dex */
public class k {
    private static k e;
    private static int[] f = {LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_8, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_16, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_22_05, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_32, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_44_1, 47250, LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_48};
    private static short[] g = {2, 3};
    private static short[] h = {2, 16, 12, 3};
    private int a;
    private short b;
    private short c;
    private int d = -2;

    public static k a() {
        k kVar;
        if (e == null) {
            synchronized (k.class) {
                if (e == null) {
                    e = new k();
                }
                kVar = e;
            }
            return kVar;
        }
        return e;
    }

    private k() {
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
    public android.media.AudioRecord b() {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.a
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.b
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.c
            if (r1 <= 0) goto L29
            android.media.AudioRecord r1 = new android.media.AudioRecord
            r2 = 1
            r0 = r18
            int r3 = r0.a
            r0 = r18
            short r4 = r0.c
            r0 = r18
            short r5 = r0.b
            r0 = r18
            int r6 = r0.d
            r1.<init>(r2, r3, r4, r5, r6)
        L28:
            return r1
        L29:
            r2 = 0
            int[] r12 = com.baidu.tbadk.core.voice.k.f
            int r13 = r12.length
            r1 = 0
            r9 = r1
            r1 = r2
        L30:
            if (r9 < r13) goto L3b
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L3b:
            r3 = r12[r9]
            short[] r14 = com.baidu.tbadk.core.voice.k.g
            int r15 = r14.length
            r2 = 0
            r10 = r2
            r2 = r1
        L43:
            if (r10 < r15) goto L4a
            int r1 = r9 + 1
            r9 = r1
            r1 = r2
            goto L30
        L4a:
            short r5 = r14[r10]
            short[] r16 = com.baidu.tbadk.core.voice.k.h
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r7 = r2
        L56:
            r0 = r17
            if (r11 < r0) goto L5f
            int r1 = r10 + 1
            r10 = r1
            r2 = r7
            goto L43
        L5f:
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L127
            r0 = r18
            r0.d = r1     // Catch: java.lang.Throwable -> L127
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> L127
            r2 = -2
            if (r1 != r2) goto L82
            if (r7 == 0) goto L12b
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L12b
            r7.release()
            r1 = 0
        L7d:
            int r2 = r11 + 1
            r11 = r2
            r7 = r1
            goto L56
        L82:
            r0 = r18
            int r1 = r0.d     // Catch: java.lang.Throwable -> L127
            int r1 = r1 * 8
            r2 = 4096(0x1000, float:5.74E-42)
            int r6 = java.lang.Math.min(r1, r2)     // Catch: java.lang.Throwable -> L127
            android.media.AudioRecord r8 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L127
            r2 = 1
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L127
            int r1 = r8.getState()     // Catch: java.lang.Throwable -> Le9
            r2 = 1
            if (r1 != r2) goto Lbb
            r0 = r18
            r0.a = r3     // Catch: java.lang.Throwable -> Le9
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> Le9
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> Le9
            r0 = r18
            r0.d = r6     // Catch: java.lang.Throwable -> Le9
            if (r8 == 0) goto Lb8
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto Lb8
            r8.release()
        Lb8:
            r1 = r8
            goto L28
        Lbb:
            r8.release()     // Catch: java.lang.Throwable -> Le9
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Le9
            r2 = 1
            r0 = r18
            int r6 = r0.d     // Catch: java.lang.Throwable -> Le9
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Le9
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L125
            r6 = 1
            if (r2 != r6) goto L10b
            r0 = r18
            r0.a = r3     // Catch: java.lang.Throwable -> L125
            r0 = r18
            r0.b = r5     // Catch: java.lang.Throwable -> L125
            r0 = r18
            r0.c = r4     // Catch: java.lang.Throwable -> L125
            if (r1 == 0) goto L28
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Le9:
            r1 = move-exception
            r2 = r1
            r1 = r8
        Lec:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L11e
            if (r1 == 0) goto L7d
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7d
            r1.release()
            r1 = 0
            goto L7d
        Lfd:
            r1 = move-exception
        Lfe:
            if (r8 == 0) goto L10a
            int r2 = r8.getState()
            r3 = 1
            if (r2 == r3) goto L10a
            r8.release()
        L10a:
            throw r1
        L10b:
            if (r1 == 0) goto L7d
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L7d
            r1.release()
            r1 = 0
            goto L7d
        L11a:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lfe
        L11e:
            r2 = move-exception
            r8 = r1
            r1 = r2
            goto Lfe
        L122:
            r1 = move-exception
            r8 = r7
            goto Lfe
        L125:
            r2 = move-exception
            goto Lec
        L127:
            r1 = move-exception
            r2 = r1
            r1 = r7
            goto Lec
        L12b:
            r1 = r7
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.voice.k.b():android.media.AudioRecord");
    }
}
