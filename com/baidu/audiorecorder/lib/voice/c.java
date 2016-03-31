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
    private String KS;
    private int KV;
    private FileOutputStream KW;
    private long KX;
    private long KY;
    private final Handler mHandler;
    private Amrnb zI;
    private volatile int KQ = 0;
    private final Handler zK = new Handler();
    private final Runnable mRecordTimeThread = new d(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public c(Handler handler) {
        this.mHandler = handler;
        try {
            this.zI = Amrnb.getInstance();
            if (this.zI == null || !Amrnb.bLoadLibrary) {
                this.zI = null;
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
        if (this.zI == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.KQ == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.KQ = 0;
        } else {
            if (this.KS != null && this.KS.length() > 0) {
                try {
                    File y = com.baidu.adp.lib.util.e.y(null, this.KS);
                    if (y != null) {
                        this.KW = new FileOutputStream(y);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    od();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.KQ = 0;
                    return;
                }
            }
            if (this.KQ == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                od();
                this.KQ = 0;
                return;
            }
            try {
                audioRecord = e.oe().of();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                od();
                this.KQ = 0;
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
                od();
                this.KQ = 0;
            } else if (this.KQ == 4) {
                try {
                    audioRecord.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                od();
                this.KQ = 0;
            } else {
                audioRecord.startRecording();
                if (this.KQ == 4) {
                    try {
                        audioRecord.stop();
                        audioRecord.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    od();
                    this.KQ = 0;
                    return;
                }
                this.KQ = 3;
                try {
                    if (this.KW == null) {
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
                            this.KQ = 0;
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
                            this.KQ = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.e.c(this.KW);
                    this.zI.encoderInit();
                    if (this.KV > 0) {
                        BdSoundGate.og().m(1600, this.KV);
                    }
                    ArrayList arrayList = new ArrayList();
                    this.KX = System.currentTimeMillis();
                    this.zK.post(this.mRecordTimeThread);
                    short s2 = 0;
                    short[] sArr2 = null;
                    while (true) {
                        if (this.KQ != 3) {
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
                            if (this.KV > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    h(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr2);
                            } else {
                                b(sArr2);
                            }
                            sArr2 = null;
                        }
                        if (System.currentTimeMillis() - this.KX > com.baidu.adp.lib.voice.h.zO) {
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
                    if (this.KV > 0) {
                        BdSoundGate.og().release();
                    }
                    System.currentTimeMillis();
                    audioRecord.stop();
                    audioRecord.release();
                    System.currentTimeMillis();
                    if (this.KQ == 5) {
                        if (!od()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.e.aL(this.KS);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.KQ = 0;
                            }
                        }
                        this.KQ = 0;
                        return;
                    }
                    this.KQ = 4;
                    this.KY = System.currentTimeMillis() - this.KX;
                    aM((int) this.KY);
                    if (this.zK != null) {
                        this.zK.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!od() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.zI.encoderDeinit();
                    this.KQ = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.KY;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord2 = audioRecord;
                }
            }
        }
    }

    private void h(List<short[]> list) {
        int blockSize = BdSoundGate.og().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.og().a(sArr2, sArr);
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
            this.KW.write(bArr, 0, this.zI.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean od() {
        if (this.KW != null) {
            try {
                this.KW.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean n(String str, int i) {
        if (this.zI == null) {
            return false;
        }
        this.KQ = 0;
        this.KS = str;
        this.KV = i;
        return true;
    }

    public void stop() {
        this.KQ = 4;
    }

    public void cancel() {
        this.KQ = 5;
    }
}
