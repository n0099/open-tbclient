package com.baidu.audiorecorder.lib.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import com.baidu.ar.auth.FeatureCodes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements Runnable {
    private Amrnb QG;
    private String acr;
    private int acv;
    private FileOutputStream acx;
    private long acy;
    private long acz;
    private final Handler mHandler;
    private volatile int acp = 0;
    private final Handler QI = new Handler();
    private final Runnable mRecordTimeThread = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.bk((int) (System.currentTimeMillis() - b.this.acy));
            b.this.QI.postDelayed(b.this.mRecordTimeThread, 200L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public b(Handler handler) {
        this.mHandler = handler;
        try {
            this.QG = Amrnb.getInstance();
            if (this.QG == null || !Amrnb.bLoadLibrary) {
                this.QG = null;
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
        boolean z;
        Process.setThreadPriority(-19);
        if (this.QG == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.acp == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.acp = 0;
        } else {
            if (this.acr != null && this.acr.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.f.createFile(null, this.acr);
                    if (createFile != null) {
                        this.acx = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    rM();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.acp = 0;
                    return;
                }
            }
            if (this.acp == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                rM();
                this.acp = 0;
                return;
            }
            AudioRecord audioRecord2 = null;
            try {
                audioRecord2 = c.rN().rO();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                rM();
                this.acp = 0;
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
                rM();
                this.acp = 0;
            } else if (this.acp == 4) {
                try {
                    audioRecord2.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                rM();
                this.acp = 0;
            } else {
                audioRecord2.startRecording();
                if (this.acp == 4) {
                    try {
                        audioRecord2.stop();
                        audioRecord2.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    rM();
                    this.acp = 0;
                    return;
                }
                this.acp = 3;
                try {
                    if (this.acx == null) {
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
                            this.acp = 0;
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
                            this.acp = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.f.writeAmrFileHeader(this.acx);
                    this.QG.encoderInit();
                    if (this.acv > 0) {
                        BdSoundGate.rP().init(FeatureCodes.ADVANCE_BEAUTY, this.acv);
                    }
                    ArrayList arrayList = new ArrayList();
                    short[] sArr = null;
                    short s = 0;
                    this.acy = System.currentTimeMillis();
                    this.QI.post(this.mRecordTimeThread);
                    while (true) {
                        if (this.acp != 3) {
                            z = false;
                            break;
                        }
                        if (sArr == null) {
                            sArr = new short[160];
                            s = 0;
                        }
                        int read = audioRecord2.read(sArr, s, 160 - s);
                        if (read > 0) {
                            int i = 0;
                            for (int i2 = 0; i2 < sArr.length; i2++) {
                                i += sArr[i2] * sArr[i2];
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
                        s = (short) (s + read);
                        if (s == 160) {
                            if (this.acv > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    q(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr);
                            } else {
                                a(sArr);
                            }
                            sArr = null;
                        }
                        if (System.currentTimeMillis() - this.acy > com.baidu.adp.lib.voice.d.QM) {
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
                    if (this.acv > 0) {
                        BdSoundGate.rP().release();
                    }
                    System.currentTimeMillis();
                    audioRecord2.stop();
                    audioRecord2.release();
                    System.currentTimeMillis();
                    if (this.acp == 5) {
                        if (!rM()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.f.delFile(this.acr);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.acp = 0;
                            }
                        }
                        this.acp = 0;
                        return;
                    }
                    this.acp = 4;
                    this.acz = System.currentTimeMillis() - this.acy;
                    bk((int) this.acz);
                    if (this.QI != null) {
                        this.QI.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!rM() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.QG.encoderDeinit();
                    this.acp = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.acz;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord = audioRecord2;
                }
            }
        }
    }

    private void q(List<short[]> list) {
        int blockSize = BdSoundGate.rP().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.rP().a(sArr2, sArr);
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    System.arraycopy(sArr, i3, list.get(i4), 0, 160);
                    i3 += 160;
                    a(list.get(i4));
                }
                i = 0;
            }
        }
    }

    private void a(short[] sArr) {
        byte[] bArr = new byte[32];
        try {
            this.acx.write(bArr, 0, this.QG.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean rM() {
        if (this.acx != null) {
            try {
                this.acx.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean q(String str, int i) {
        if (this.QG == null) {
            return false;
        }
        this.acp = 0;
        this.acr = str;
        this.acv = i;
        return true;
    }

    public void stop() {
        this.acp = 4;
    }

    public void cancel() {
        this.acp = 5;
    }
}
