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
public class c implements Runnable {
    private String Jh;
    private int Jk;
    private FileOutputStream Jl;
    private long Jm;
    private long Jn;
    private final Handler mHandler;
    private Amrnb zB;
    private volatile int Jf = 0;
    private final Handler zD = new Handler();
    private final Runnable mRecordTimeThread = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public c(Handler handler) {
        this.mHandler = handler;
        try {
            this.zB = Amrnb.getInstance();
            if (this.zB == null || !Amrnb.bLoadLibrary) {
                this.zB = null;
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
        AudioRecord audioRecord2;
        short[] sArr;
        short s;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.zB == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.Jf == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.Jf = 0;
        } else {
            if (this.Jh != null && this.Jh.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.e.createFile(null, this.Jh);
                    if (createFile != null) {
                        this.Jl = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    lB();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.Jf = 0;
                    return;
                }
            }
            if (this.Jf == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lB();
                this.Jf = 0;
                return;
            }
            try {
                audioRecord = e.lC().lD();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                lB();
                this.Jf = 0;
                return;
            } catch (Exception e3) {
                audioRecord = null;
            }
            if (audioRecord == null || audioRecord.getState() == 0) {
                if (audioRecord != null) {
                    try {
                        audioRecord.release();
                    } catch (Exception e4) {
                    }
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                lB();
                this.Jf = 0;
            } else if (this.Jf == 4) {
                try {
                    audioRecord.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lB();
                this.Jf = 0;
            } else {
                audioRecord.startRecording();
                if (this.Jf == 4) {
                    try {
                        audioRecord.stop();
                        audioRecord.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    lB();
                    this.Jf = 0;
                    return;
                }
                this.Jf = 3;
                try {
                    if (this.Jl == null) {
                        try {
                            audioRecord.stop();
                            audioRecord.release();
                            audioRecord2 = null;
                        } catch (Exception e7) {
                            audioRecord2 = audioRecord;
                        }
                        try {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                            }
                            this.Jf = 0;
                            return;
                        } catch (IOException e8) {
                            try {
                                audioRecord2.stop();
                                audioRecord2.release();
                            } catch (Exception e9) {
                            }
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                            }
                            this.Jf = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.e.e(this.Jl);
                    this.zB.encoderInit();
                    if (this.Jk > 0) {
                        BdSoundGate.lE().init(1600, this.Jk);
                    }
                    ArrayList arrayList = new ArrayList();
                    this.Jm = System.currentTimeMillis();
                    this.zD.post(this.mRecordTimeThread);
                    short s2 = 0;
                    short[] sArr2 = null;
                    while (true) {
                        if (this.Jf != 3) {
                            sArr = sArr2;
                            s = s2;
                            z = false;
                            break;
                        }
                        if (sArr2 == null) {
                            sArr2 = new short[160];
                            s2 = 0;
                        }
                        int read = audioRecord.read(sArr2, s2, 160 - s2);
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
                            if (this.Jk > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    i(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr2);
                            } else {
                                b(sArr2);
                            }
                            sArr2 = null;
                        }
                        if (System.currentTimeMillis() - this.Jm > com.baidu.adp.lib.voice.h.zH) {
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
                        b(sArr);
                    }
                    if (this.Jk > 0) {
                        BdSoundGate.lE().release();
                    }
                    System.currentTimeMillis();
                    audioRecord.stop();
                    audioRecord.release();
                    System.currentTimeMillis();
                    if (this.Jf == 5) {
                        if (!lB()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.e.delFile(this.Jh);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.Jf = 0;
                            }
                        }
                        this.Jf = 0;
                        return;
                    }
                    this.Jf = 4;
                    this.Jn = System.currentTimeMillis() - this.Jm;
                    aN((int) this.Jn);
                    if (this.zD != null) {
                        this.zD.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!lB() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.zB.encoderDeinit();
                    this.Jf = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.Jn;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord2 = audioRecord;
                }
            }
        }
    }

    private void i(List<short[]> list) {
        int blockSize = BdSoundGate.lE().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.lE().a(sArr2, sArr);
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    System.arraycopy(sArr, i4, list.get(i3), 0, 160);
                    b(list.get(i3));
                    i3++;
                    i4 += 160;
                }
                i = 0;
            }
        }
    }

    private void b(short[] sArr) {
        byte[] bArr = new byte[32];
        try {
            this.Jl.write(bArr, 0, this.zB.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean lB() {
        if (this.Jl != null) {
            try {
                this.Jl.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean o(String str, int i) {
        if (this.zB == null) {
            return false;
        }
        this.Jf = 0;
        this.Jh = str;
        this.Jk = i;
        return true;
    }

    public void stop() {
        this.Jf = 4;
    }

    public void cancel() {
        this.Jf = 5;
    }
}
