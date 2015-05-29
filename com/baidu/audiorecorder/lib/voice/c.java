package com.baidu.audiorecorder.lib.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.voice.Amrnb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements Runnable {
    private String JL;
    private int JO;
    private long JP;
    private long JQ;
    private FileOutputStream mFileOutputStream;
    private final Handler mHandler;
    private Amrnb zq;
    private volatile int JJ = 0;
    private final Handler zs = new Handler();
    private final Runnable mRecordTimeThread = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public c(Handler handler) {
        this.mHandler = handler;
        try {
            this.zq = Amrnb.getInstance();
            if (this.zq == null || !Amrnb.bLoadLibrary) {
                this.zq = null;
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
        if (this.zq == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.JJ == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.JJ = 0;
        } else {
            if (this.JL != null && this.JL.length() > 0) {
                try {
                    File z2 = com.baidu.adp.lib.util.f.z(null, this.JL);
                    if (z2 != null) {
                        this.mFileOutputStream = new FileOutputStream(z2);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    oe();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.JJ = 0;
                    return;
                }
            }
            if (this.JJ == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                oe();
                this.JJ = 0;
                return;
            }
            try {
                AudioRecord og = e.of().og();
                if (og == null || og.getState() == 0) {
                    if (og != null) {
                        try {
                            og.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                    }
                    oe();
                    this.JJ = 0;
                } else if (this.JJ == 4) {
                    try {
                        og.release();
                    } catch (Exception e3) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    oe();
                    this.JJ = 0;
                } else {
                    og.startRecording();
                    if (this.JJ == 4) {
                        try {
                            og.stop();
                            og.release();
                        } catch (Exception e4) {
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                        }
                        oe();
                        this.JJ = 0;
                        return;
                    }
                    this.JJ = 3;
                    try {
                        if (this.mFileOutputStream == null) {
                            try {
                                og.stop();
                                og.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = og;
                            }
                            try {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                                }
                                this.JJ = 0;
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
                                this.JJ = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.f.c(this.mFileOutputStream);
                        this.zq.encoderInit();
                        if (this.JO > 0) {
                            BdSoundGate.oh().k(1600, this.JO);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.JP = System.currentTimeMillis();
                        this.zs.post(this.mRecordTimeThread);
                        short s2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.JJ != 3) {
                                sArr = sArr2;
                                s = s2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                s2 = 0;
                            }
                            int read = og.read(sArr2, s2, 160 - s2);
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
                                if (this.JO > 0) {
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
                            if (System.currentTimeMillis() - this.JP > com.baidu.adp.lib.voice.h.zw) {
                                sArr = sArr2;
                                s = s2;
                                z = true;
                                break;
                            }
                        }
                        long currentTimeMillis = System.currentTimeMillis();
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
                        if (this.JO > 0) {
                            BdSoundGate.oh().release();
                        }
                        Log.d("test_record", "1:" + (System.currentTimeMillis() - currentTimeMillis));
                        System.currentTimeMillis();
                        og.stop();
                        og.release();
                        System.currentTimeMillis();
                        if (this.JJ == 5) {
                            if (!oe()) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.f.aO(this.JL);
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                    }
                                } catch (Exception e9) {
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                    }
                                    this.JJ = 0;
                                }
                            }
                            this.JJ = 0;
                            return;
                        }
                        this.JJ = 4;
                        this.JQ = System.currentTimeMillis() - this.JP;
                        aE((int) this.JQ);
                        if (this.zs != null) {
                            this.zs.removeCallbacks(this.mRecordTimeThread);
                        }
                        System.currentTimeMillis();
                        if (!oe() && this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                        }
                        this.zq.encoderDeinit();
                        this.JJ = 0;
                        if (this.mHandler != null) {
                            if (z) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = this.mHandler.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.JQ;
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                    } catch (IOException e10) {
                        audioRecord = og;
                    }
                }
            } catch (IllegalArgumentException e11) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                oe();
                this.JJ = 0;
            }
        }
    }

    private void i(List<short[]> list) {
        int blockSize = BdSoundGate.oh().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.oh().a(sArr2, sArr);
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
            this.mFileOutputStream.write(bArr, 0, this.zq.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean oe() {
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

    public boolean k(String str, int i) {
        if (this.zq == null) {
            return false;
        }
        this.JJ = 0;
        this.JL = str;
        this.JO = i;
        return true;
    }

    public void stop() {
        this.JJ = 4;
    }

    public void cancel() {
        this.JJ = 5;
    }
}
