package com.baidu.audiorecorder.lib.voice;

import com.baidu.ala.helper.StreamConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
/* loaded from: classes7.dex */
public class c {
    private static c acF;
    private static int[] acG = {8000, RequestResponseCode.REQUEST_LOGIN_PB_AT, 16000, 22050, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_32K, 44100, 47250, StreamConfig.Audio.AUDIO_RTC_FREQUENCY_48K};
    private static short[] acH = {2, 3};
    private static short[] acI = {2, 16, 12, 3};
    private int acB;
    private short acC;
    private short acD;
    private int acE = -2;

    public static c rN() {
        c cVar;
        if (acF == null) {
            synchronized (c.class) {
                if (acF == null) {
                    acF = new c();
                }
                cVar = acF;
            }
            return cVar;
        }
        return acF;
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
    public android.media.AudioRecord rO() throws java.lang.IllegalArgumentException {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.acB
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.acC
            if (r1 <= 0) goto L29
            r0 = r18
            short r1 = r0.acD
            if (r1 <= 0) goto L29
            android.media.AudioRecord r1 = new android.media.AudioRecord
            r2 = 1
            r0 = r18
            int r3 = r0.acB
            r0 = r18
            short r4 = r0.acD
            r0 = r18
            short r5 = r0.acC
            r0 = r18
            int r6 = r0.acE
            r1.<init>(r2, r3, r4, r5, r6)
        L28:
            return r1
        L29:
            r2 = 0
            int[] r12 = com.baidu.audiorecorder.lib.voice.c.acG
            int r13 = r12.length
            r1 = 0
            r9 = r1
        L2f:
            if (r9 >= r13) goto L10f
            r3 = r12[r9]
            short[] r14 = com.baidu.audiorecorder.lib.voice.c.acH
            int r15 = r14.length
            r1 = 0
            r10 = r1
        L38:
            if (r10 >= r15) goto L10a
            short r5 = r14[r10]
            short[] r16 = com.baidu.audiorecorder.lib.voice.c.acI
            r0 = r16
            int r0 = r0.length
            r17 = r0
            r1 = 0
            r11 = r1
            r7 = r2
        L46:
            r0 = r17
            if (r11 >= r0) goto L104
            short r4 = r16[r11]
            int r1 = android.media.AudioRecord.getMinBufferSize(r3, r4, r5)     // Catch: java.lang.Throwable -> L124
            r0 = r18
            r0.acE = r1     // Catch: java.lang.Throwable -> L124
            r0 = r18
            int r1 = r0.acE     // Catch: java.lang.Throwable -> L124
            r2 = -2
            if (r1 != r2) goto L6d
            if (r7 == 0) goto L127
            int r1 = r7.getState()
            r2 = 1
            if (r1 == r2) goto L127
            r7.release()
            r1 = 0
        L68:
            int r2 = r11 + 1
            r11 = r2
            r7 = r1
            goto L46
        L6d:
            r0 = r18
            int r1 = r0.acE     // Catch: java.lang.Throwable -> L124
            int r1 = r1 * 8
            r2 = 4096(0x1000, float:5.74E-42)
            int r6 = java.lang.Math.min(r1, r2)     // Catch: java.lang.Throwable -> L124
            android.media.AudioRecord r8 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> L124
            r2 = 1
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L124
            int r1 = r8.getState()     // Catch: java.lang.Throwable -> Le1
            r2 = 1
            if (r1 != r2) goto La5
            r0 = r18
            r0.acB = r3     // Catch: java.lang.Throwable -> Le1
            r0 = r18
            r0.acC = r5     // Catch: java.lang.Throwable -> Le1
            r0 = r18
            r0.acD = r4     // Catch: java.lang.Throwable -> Le1
            r0 = r18
            r0.acE = r6     // Catch: java.lang.Throwable -> Le1
            if (r8 == 0) goto La3
            int r1 = r8.getState()
            r2 = 1
            if (r1 == r2) goto La3
            r8.release()
        La3:
            r1 = r8
            goto L28
        La5:
            r8.release()     // Catch: java.lang.Throwable -> Le1
            android.media.AudioRecord r1 = new android.media.AudioRecord     // Catch: java.lang.Throwable -> Le1
            r2 = 1
            r0 = r18
            int r6 = r0.acE     // Catch: java.lang.Throwable -> Le1
            r1.<init>(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Le1
            int r2 = r1.getState()     // Catch: java.lang.Throwable -> L122
            r6 = 1
            if (r2 != r6) goto Ld3
            r0 = r18
            r0.acB = r3     // Catch: java.lang.Throwable -> L122
            r0 = r18
            r0.acC = r5     // Catch: java.lang.Throwable -> L122
            r0 = r18
            r0.acD = r4     // Catch: java.lang.Throwable -> L122
            if (r1 == 0) goto L28
            int r2 = r1.getState()
            r3 = 1
            if (r2 == r3) goto L28
            r1.release()
            goto L28
        Ld3:
            if (r1 == 0) goto L68
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L68
            r1.release()
            r1 = 0
            goto L68
        Le1:
            r2 = move-exception
            r1 = r8
        Le3:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L11b
            if (r1 == 0) goto L68
            int r2 = r1.getState()
            r4 = 1
            if (r2 == r4) goto L68
            r1.release()
            r1 = 0
            goto L68
        Lf5:
            r1 = move-exception
            r2 = r1
        Lf7:
            if (r8 == 0) goto L103
            int r1 = r8.getState()
            r3 = 1
            if (r1 == r3) goto L103
            r8.release()
        L103:
            throw r2
        L104:
            int r1 = r10 + 1
            r10 = r1
            r2 = r7
            goto L38
        L10a:
            int r1 = r9 + 1
            r9 = r1
            goto L2f
        L10f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "getInstance() failed : no suitable audio configurations on this device."
            r1.<init>(r2)
            throw r1
        L118:
            r2 = move-exception
            r8 = r1
            goto Lf7
        L11b:
            r2 = move-exception
            r8 = r1
            goto Lf7
        L11e:
            r1 = move-exception
            r2 = r1
            r8 = r7
            goto Lf7
        L122:
            r2 = move-exception
            goto Le3
        L124:
            r2 = move-exception
            r1 = r7
            goto Le3
        L127:
            r1 = r7
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.audiorecorder.lib.voice.c.rO():android.media.AudioRecord");
    }
}
