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
/* loaded from: classes6.dex */
public class b implements Runnable {
    private Amrnb EC;
    private String SV;
    private int SY;
    private FileOutputStream SZ;
    private long Ta;
    private long Tb;
    private final Handler mHandler;
    private volatile int ST = 0;
    private final Handler EE = new Handler();
    private final Runnable mRecordTimeThread = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.bi((int) (System.currentTimeMillis() - b.this.Ta));
            b.this.EE.postDelayed(b.this.mRecordTimeThread, 200L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public b(Handler handler) {
        this.mHandler = handler;
        try {
            this.EC = Amrnb.getInstance();
            if (this.EC == null || !Amrnb.bLoadLibrary) {
                this.EC = null;
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
        if (this.EC == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.ST == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.ST = 0;
        } else {
            if (this.SV != null && this.SV.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.f.createFile(null, this.SV);
                    if (createFile != null) {
                        this.SZ = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    pF();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.ST = 0;
                    return;
                }
            }
            if (this.ST == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                pF();
                this.ST = 0;
                return;
            }
            AudioRecord audioRecord2 = null;
            try {
                audioRecord2 = c.pG().pH();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                pF();
                this.ST = 0;
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
                pF();
                this.ST = 0;
            } else if (this.ST == 4) {
                try {
                    audioRecord2.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                pF();
                this.ST = 0;
            } else {
                audioRecord2.startRecording();
                if (this.ST == 4) {
                    try {
                        audioRecord2.stop();
                        audioRecord2.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    pF();
                    this.ST = 0;
                    return;
                }
                this.ST = 3;
                try {
                    if (this.SZ == null) {
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
                            this.ST = 0;
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
                            this.ST = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.f.c(this.SZ);
                    this.EC.encoderInit();
                    if (this.SY > 0) {
                        BdSoundGate.pI().init(1600, this.SY);
                    }
                    ArrayList arrayList = new ArrayList();
                    short[] sArr2 = null;
                    short s2 = 0;
                    this.Ta = System.currentTimeMillis();
                    this.EE.post(this.mRecordTimeThread);
                    while (true) {
                        if (this.ST != 3) {
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
                            if (this.SY > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    m(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr2);
                            } else {
                                a(sArr2);
                            }
                            sArr2 = null;
                        }
                        if (System.currentTimeMillis() - this.Ta > com.baidu.adp.lib.voice.d.EI) {
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
                    if (this.SY > 0) {
                        BdSoundGate.pI().release();
                    }
                    System.currentTimeMillis();
                    audioRecord2.stop();
                    audioRecord2.release();
                    System.currentTimeMillis();
                    if (this.ST == 5) {
                        if (!pF()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.f.aY(this.SV);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.ST = 0;
                            }
                        }
                        this.ST = 0;
                        return;
                    }
                    this.ST = 4;
                    this.Tb = System.currentTimeMillis() - this.Ta;
                    bi((int) this.Tb);
                    if (this.EE != null) {
                        this.EE.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!pF() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.EC.encoderDeinit();
                    this.ST = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.Tb;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord = audioRecord2;
                }
            }
        }
    }

    private void m(List<short[]> list) {
        int blockSize = BdSoundGate.pI().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.pI().a(sArr2, sArr);
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
            this.SZ.write(bArr, 0, this.EC.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean pF() {
        if (this.SZ != null) {
            try {
                this.SZ.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean n(String str, int i) {
        if (this.EC == null) {
            return false;
        }
        this.ST = 0;
        this.SV = str;
        this.SY = i;
        return true;
    }

    public void stop() {
        this.ST = 4;
    }

    public void cancel() {
        this.ST = 5;
    }
}
