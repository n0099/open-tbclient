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
/* loaded from: classes.dex */
public class c implements Runnable {
    private int KA;
    private long KB;
    private long KC;
    private String Kx;
    private FileOutputStream mFileOutputStream;
    private final Handler mHandler;
    private Amrnb zi;
    private volatile int Kv = 0;
    private final Handler zk = new Handler();
    private final Runnable mRecordTimeThread = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public c(Handler handler) {
        this.mHandler = handler;
        try {
            this.zi = Amrnb.getInstance();
            if (this.zi == null || !Amrnb.bLoadLibrary) {
                this.zi = null;
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
        if (this.zi == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.Kv == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.Kv = 0;
        } else {
            if (this.Kx != null && this.Kx.length() > 0) {
                try {
                    File x = com.baidu.adp.lib.util.e.x(null, this.Kx);
                    if (x != null) {
                        this.mFileOutputStream = new FileOutputStream(x);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    nQ();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.Kv = 0;
                    return;
                }
            }
            if (this.Kv == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                nQ();
                this.Kv = 0;
                return;
            }
            try {
                AudioRecord nS = e.nR().nS();
                if (nS == null || nS.getState() == 0) {
                    if (nS != null) {
                        try {
                            nS.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                    }
                    nQ();
                    this.Kv = 0;
                } else if (this.Kv == 4) {
                    try {
                        nS.release();
                    } catch (Exception e3) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    nQ();
                    this.Kv = 0;
                } else {
                    nS.startRecording();
                    if (this.Kv == 4) {
                        try {
                            nS.stop();
                            nS.release();
                        } catch (Exception e4) {
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                        }
                        nQ();
                        this.Kv = 0;
                        return;
                    }
                    this.Kv = 3;
                    try {
                        if (this.mFileOutputStream == null) {
                            try {
                                nS.stop();
                                nS.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = nS;
                            }
                            try {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                                }
                                this.Kv = 0;
                                return;
                            } catch (IOException e6) {
                                try {
                                    audioRecord.stop();
                                    audioRecord.release();
                                } catch (Exception e7) {
                                }
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
                                }
                                this.Kv = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.e.c(this.mFileOutputStream);
                        this.zi.encoderInit();
                        if (this.KA > 0) {
                            BdSoundGate.nT().l(1600, this.KA);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.KB = System.currentTimeMillis();
                        this.zk.post(this.mRecordTimeThread);
                        short s2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.Kv != 3) {
                                sArr = sArr2;
                                s = s2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                s2 = 0;
                            }
                            int read = nS.read(sArr2, s2, 160 - s2);
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
                                if (this.KA > 0) {
                                    int size = arrayList.size();
                                    if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                        h(arrayList);
                                        arrayList.clear();
                                    }
                                    arrayList.add(sArr2);
                                } else {
                                    a(sArr2);
                                }
                                sArr2 = null;
                            }
                            if (System.currentTimeMillis() - this.KB > com.baidu.adp.lib.voice.h.zo) {
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
                                } catch (Exception e8) {
                                }
                            }
                            a(sArr);
                        }
                        if (this.KA > 0) {
                            BdSoundGate.nT().release();
                        }
                        System.currentTimeMillis();
                        nS.stop();
                        nS.release();
                        System.currentTimeMillis();
                        if (this.Kv == 5) {
                            if (!nQ()) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.e.aK(this.Kx);
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                    }
                                } catch (Exception e9) {
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                    }
                                    this.Kv = 0;
                                }
                            }
                            this.Kv = 0;
                            return;
                        }
                        this.Kv = 4;
                        this.KC = System.currentTimeMillis() - this.KB;
                        aA((int) this.KC);
                        if (this.zk != null) {
                            this.zk.removeCallbacks(this.mRecordTimeThread);
                        }
                        System.currentTimeMillis();
                        if (!nQ() && this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                        }
                        this.zi.encoderDeinit();
                        this.Kv = 0;
                        if (this.mHandler != null) {
                            if (z) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = this.mHandler.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.KC;
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                    } catch (IOException e10) {
                        audioRecord = nS;
                    }
                }
            } catch (IllegalArgumentException e11) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                nQ();
                this.Kv = 0;
            }
        }
    }

    private void h(List<short[]> list) {
        int blockSize = BdSoundGate.nT().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.nT().a(sArr2, sArr);
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
            this.mFileOutputStream.write(bArr, 0, this.zi.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean nQ() {
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean m(String str, int i) {
        if (this.zi == null) {
            return false;
        }
        this.Kv = 0;
        this.Kx = str;
        this.KA = i;
        return true;
    }

    public void stop() {
        this.Kv = 4;
    }

    public void cancel() {
        this.Kv = 5;
    }
}
