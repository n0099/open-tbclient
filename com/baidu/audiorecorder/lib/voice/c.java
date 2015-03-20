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
    private String JS;
    private int JV;
    private long JW;
    private long JX;
    private FileOutputStream mFileOutputStream;
    private final Handler mHandler;
    private Amrnb zB;
    private volatile int JQ = 0;
    private final Handler zD = new Handler();
    private final Runnable mRecordTimeThread = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(int i) {
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
        short[] sArr;
        short s;
        boolean z;
        Process.setThreadPriority(-19);
        if (this.zB == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.JQ == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.JQ = 0;
        } else {
            if (this.JS != null && this.JS.length() > 0) {
                try {
                    File x = com.baidu.adp.lib.util.f.x(null, this.JS);
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
                    nN();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.JQ = 0;
                    return;
                }
            }
            if (this.JQ == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                nN();
                this.JQ = 0;
                return;
            }
            try {
                AudioRecord nP = e.nO().nP();
                if (nP == null || nP.getState() == 0) {
                    if (nP != null) {
                        try {
                            nP.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                    }
                    nN();
                    this.JQ = 0;
                } else if (this.JQ == 4) {
                    try {
                        nP.release();
                    } catch (Exception e3) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    nN();
                    this.JQ = 0;
                } else {
                    nP.startRecording();
                    if (this.JQ == 4) {
                        try {
                            nP.stop();
                            nP.release();
                        } catch (Exception e4) {
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                        }
                        nN();
                        this.JQ = 0;
                        return;
                    }
                    this.JQ = 3;
                    try {
                        if (this.mFileOutputStream == null) {
                            try {
                                nP.stop();
                                nP.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = nP;
                            }
                            try {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                                }
                                this.JQ = 0;
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
                                this.JQ = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.f.c(this.mFileOutputStream);
                        this.zB.encoderInit();
                        if (this.JV > 0) {
                            BdSoundGate.nQ().k(1600, this.JV);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.JW = System.currentTimeMillis();
                        this.zD.post(this.mRecordTimeThread);
                        short s2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.JQ != 3) {
                                sArr = sArr2;
                                s = s2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                s2 = 0;
                            }
                            int read = nP.read(sArr2, s2, 160 - s2);
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
                                if (this.JV > 0) {
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
                            if (System.currentTimeMillis() - this.JW > com.baidu.adp.lib.voice.h.zH) {
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
                        if (this.JV > 0) {
                            BdSoundGate.nQ().release();
                        }
                        Log.d("test_record", "1:" + (System.currentTimeMillis() - currentTimeMillis));
                        System.currentTimeMillis();
                        nP.stop();
                        nP.release();
                        System.currentTimeMillis();
                        if (this.JQ == 5) {
                            if (!nN()) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.f.aF(this.JS);
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                    }
                                } catch (Exception e9) {
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                    }
                                    this.JQ = 0;
                                }
                            }
                            this.JQ = 0;
                            return;
                        }
                        this.JQ = 4;
                        this.JX = System.currentTimeMillis() - this.JW;
                        aG((int) this.JX);
                        if (this.zD != null) {
                            this.zD.removeCallbacks(this.mRecordTimeThread);
                        }
                        System.currentTimeMillis();
                        if (!nN() && this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                        }
                        this.zB.encoderDeinit();
                        this.JQ = 0;
                        if (this.mHandler != null) {
                            if (z) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = this.mHandler.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.JX;
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                    } catch (IOException e10) {
                        audioRecord = nP;
                    }
                }
            } catch (IllegalArgumentException e11) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                nN();
                this.JQ = 0;
            }
        }
    }

    private void h(List<short[]> list) {
        int blockSize = BdSoundGate.nQ().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.nQ().a(sArr2, sArr);
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
            this.mFileOutputStream.write(bArr, 0, this.zB.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean nN() {
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
        if (this.zB == null) {
            return false;
        }
        this.JQ = 0;
        this.JS = str;
        this.JV = i;
        return true;
    }

    public void stop() {
        this.JQ = 4;
    }

    public void cancel() {
        this.JQ = 5;
    }
}
