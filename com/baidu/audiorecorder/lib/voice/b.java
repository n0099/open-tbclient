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
/* loaded from: classes8.dex */
public class b implements Runnable {
    private Amrnb QE;
    private String acm;
    private int acp;
    private FileOutputStream acq;
    private long acr;
    private long acs;
    private final Handler mHandler;
    private volatile int aci = 0;
    private final Handler QG = new Handler();
    private final Runnable mRecordTimeThread = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.bk((int) (System.currentTimeMillis() - b.this.acr));
            b.this.QG.postDelayed(b.this.mRecordTimeThread, 200L);
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
            this.QE = Amrnb.getInstance();
            if (this.QE == null || !Amrnb.bLoadLibrary) {
                this.QE = null;
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
        if (this.QE == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.aci == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.aci = 0;
        } else {
            if (this.acm != null && this.acm.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.f.createFile(null, this.acm);
                    if (createFile != null) {
                        this.acq = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    rK();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.aci = 0;
                    return;
                }
            }
            if (this.aci == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                rK();
                this.aci = 0;
                return;
            }
            AudioRecord audioRecord2 = null;
            try {
                audioRecord2 = c.rL().rM();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                rK();
                this.aci = 0;
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
                rK();
                this.aci = 0;
            } else if (this.aci == 4) {
                try {
                    audioRecord2.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                rK();
                this.aci = 0;
            } else {
                audioRecord2.startRecording();
                if (this.aci == 4) {
                    try {
                        audioRecord2.stop();
                        audioRecord2.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    rK();
                    this.aci = 0;
                    return;
                }
                this.aci = 3;
                try {
                    if (this.acq == null) {
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
                            this.aci = 0;
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
                            this.aci = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.f.writeAmrFileHeader(this.acq);
                    this.QE.encoderInit();
                    if (this.acp > 0) {
                        BdSoundGate.rN().init(FeatureCodes.ADVANCE_BEAUTY, this.acp);
                    }
                    ArrayList arrayList = new ArrayList();
                    short[] sArr = null;
                    short s = 0;
                    this.acr = System.currentTimeMillis();
                    this.QG.post(this.mRecordTimeThread);
                    while (true) {
                        if (this.aci != 3) {
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
                            if (this.acp > 0) {
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
                        if (System.currentTimeMillis() - this.acr > com.baidu.adp.lib.voice.d.QK) {
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
                    if (this.acp > 0) {
                        BdSoundGate.rN().release();
                    }
                    System.currentTimeMillis();
                    audioRecord2.stop();
                    audioRecord2.release();
                    System.currentTimeMillis();
                    if (this.aci == 5) {
                        if (!rK()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.f.delFile(this.acm);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.aci = 0;
                            }
                        }
                        this.aci = 0;
                        return;
                    }
                    this.aci = 4;
                    this.acs = System.currentTimeMillis() - this.acr;
                    bk((int) this.acs);
                    if (this.QG != null) {
                        this.QG.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!rK() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.QE.encoderDeinit();
                    this.aci = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.acs;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord = audioRecord2;
                }
            }
        }
    }

    private void q(List<short[]> list) {
        int blockSize = BdSoundGate.rN().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.rN().a(sArr2, sArr);
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
            this.acq.write(bArr, 0, this.QE.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean rK() {
        if (this.acq != null) {
            try {
                this.acq.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean q(String str, int i) {
        if (this.QE == null) {
            return false;
        }
        this.aci = 0;
        this.acm = str;
        this.acp = i;
        return true;
    }

    public void stop() {
        this.aci = 4;
    }

    public void cancel() {
        this.aci = 5;
    }
}
