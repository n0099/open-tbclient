package com.baidu.audiorecorder.lib.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements Runnable {
    private String IB;
    private int IF;
    private FileOutputStream IG;
    private long IH;
    private long II;
    private final Handler mHandler;
    private Amrnb yX;
    private volatile int Iz = 0;
    private final Handler yZ = new Handler();
    private final Runnable mRecordTimeThread = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.aM((int) (System.currentTimeMillis() - b.this.IH));
            b.this.yZ.postDelayed(b.this.mRecordTimeThread, 200L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public b(Handler handler) {
        this.mHandler = handler;
        try {
            this.yX = Amrnb.getInstance();
            if (this.yX == null || !Amrnb.bLoadLibrary) {
                this.yX = null;
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
                }
            }
        } catch (Exception e) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AudioRecord audioRecord;
        short[] sArr;
        short s;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.yX == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.Iz == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.Iz = 0;
        } else {
            if (this.IB != null && this.IB.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.e.createFile(null, this.IB);
                    if (createFile != null) {
                        this.IG = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    lz();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.Iz = 0;
                    return;
                }
            }
            if (this.Iz == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lz();
                this.Iz = 0;
                return;
            }
            AudioRecord audioRecord2 = null;
            try {
                audioRecord2 = c.lA().lB();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                lz();
                this.Iz = 0;
                return;
            } catch (Exception e3) {
            }
            if (audioRecord2 == null || audioRecord2.getState() == 0) {
                if (audioRecord2 != null) {
                    try {
                        audioRecord2.release();
                    } catch (Exception e4) {
                    }
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                lz();
                this.Iz = 0;
            } else if (this.Iz == 4) {
                try {
                    audioRecord2.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lz();
                this.Iz = 0;
            } else {
                audioRecord2.startRecording();
                if (this.Iz == 4) {
                    try {
                        audioRecord2.stop();
                        audioRecord2.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    lz();
                    this.Iz = 0;
                    return;
                }
                this.Iz = 3;
                try {
                    if (this.IG == null) {
                        try {
                            audioRecord2.stop();
                            audioRecord2.release();
                            audioRecord = null;
                        } catch (Exception e7) {
                            audioRecord = audioRecord2;
                        }
                        try {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                            }
                            this.Iz = 0;
                            return;
                        } catch (IOException e8) {
                            try {
                                audioRecord.stop();
                                audioRecord.release();
                            } catch (Exception e9) {
                            }
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                            }
                            this.Iz = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.e.c(this.IG);
                    this.yX.encoderInit();
                    if (this.IF > 0) {
                        BdSoundGate.lC().init(1600, this.IF);
                    }
                    ArrayList arrayList = new ArrayList();
                    short[] sArr2 = null;
                    short s2 = 0;
                    this.IH = System.currentTimeMillis();
                    this.yZ.post(this.mRecordTimeThread);
                    while (true) {
                        if (this.Iz != 3) {
                            sArr = sArr2;
                            s = s2;
                            z = false;
                            break;
                        }
                        if (sArr2 == null) {
                            sArr2 = new short[160];
                            s2 = 0;
                        }
                        int read = audioRecord2.read(sArr2, s2, 160 - s2);
                        if (read > 0) {
                            int i = 0;
                            for (int i2 = 0; i2 < sArr2.length; i2++) {
                                i += sArr2[i2] * sArr2[i2];
                            }
                            if (this.mHandler != null) {
                                Message obtainMessage = this.mHandler.obtainMessage(4);
                                int abs = Math.abs((((int) (i / read)) / 100000) >> 1);
                                while (abs > 100) {
                                    abs = (int) (abs / 10.0d);
                                }
                                obtainMessage.arg1 = abs;
                                this.mHandler.sendMessage(obtainMessage);
                            }
                        }
                        s2 = (short) (s2 + read);
                        if (s2 == 160) {
                            if (this.IF > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    i(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr2);
                            } else {
                                a(sArr2);
                            }
                            sArr2 = null;
                        }
                        if (System.currentTimeMillis() - this.IH > com.baidu.adp.lib.voice.d.zd) {
                            sArr = sArr2;
                            s = s2;
                            z = true;
                            break;
                        }
                    }
                    System.currentTimeMillis();
                    if (sArr != null) {
                        while (s < 160) {
                            try {
                                if (s >= sArr.length || s < 0) {
                                    break;
                                }
                                sArr[s] = 0;
                                s = (short) (s + 1);
                            } catch (Exception e10) {
                            }
                        }
                        a(sArr);
                    }
                    if (this.IF > 0) {
                        BdSoundGate.lC().release();
                    }
                    System.currentTimeMillis();
                    audioRecord2.stop();
                    audioRecord2.release();
                    System.currentTimeMillis();
                    if (this.Iz == 5) {
                        if (!lz()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.e.aE(this.IB);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.Iz = 0;
                            }
                        }
                        this.Iz = 0;
                        return;
                    }
                    this.Iz = 4;
                    this.II = System.currentTimeMillis() - this.IH;
                    aM((int) this.II);
                    if (this.yZ != null) {
                        this.yZ.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!lz() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.yX.encoderDeinit();
                    this.Iz = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.II;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord = audioRecord2;
                }
            }
        }
    }

    private void i(List<short[]> list) {
        int blockSize = BdSoundGate.lC().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.lC().a(sArr2, sArr);
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    System.arraycopy(sArr, i4, list.get(i3), 0, 160);
                    a(list.get(i3));
                    i3++;
                    i4 += 160;
                }
                i = 0;
            }
        }
    }

    private void a(short[] sArr) {
        byte[] bArr = new byte[32];
        try {
            this.IG.write(bArr, 0, this.yX.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean lz() {
        if (this.IG != null) {
            try {
                this.IG.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean o(String str, int i) {
        if (this.yX == null) {
            return false;
        }
        this.Iz = 0;
        this.IB = str;
        this.IF = i;
        return true;
    }

    public void stop() {
        this.Iz = 4;
    }

    public void cancel() {
        this.Iz = 5;
    }
}
