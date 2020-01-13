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
/* loaded from: classes9.dex */
public class b implements Runnable {
    private String ER;
    private int EU;
    private FileOutputStream EV;
    private long EW;
    private long EX;
    private final Handler mHandler;
    private Amrnb us;
    private volatile int EO = 0;
    private final Handler uu = new Handler();
    private final Runnable mRecordTimeThread = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.b.1
        @Override // java.lang.Runnable
        public void run() {
            b.this.aA((int) (System.currentTimeMillis() - b.this.EW));
            b.this.uu.postDelayed(b.this.mRecordTimeThread, 200L);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public b(Handler handler) {
        this.mHandler = handler;
        try {
            this.us = Amrnb.getInstance();
            if (this.us == null || !Amrnb.bLoadLibrary) {
                this.us = null;
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
        if (this.us == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.EO == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.EO = 0;
        } else {
            if (this.ER != null && this.ER.length() > 0) {
                try {
                    File createFile = com.baidu.adp.lib.util.f.createFile(null, this.ER);
                    if (createFile != null) {
                        this.EV = new FileOutputStream(createFile);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    lo();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.EO = 0;
                    return;
                }
            }
            if (this.EO == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lo();
                this.EO = 0;
                return;
            }
            AudioRecord audioRecord2 = null;
            try {
                audioRecord2 = c.lp().lq();
            } catch (IllegalArgumentException e2) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                lo();
                this.EO = 0;
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
                lo();
                this.EO = 0;
            } else if (this.EO == 4) {
                try {
                    audioRecord2.release();
                } catch (Exception e5) {
                }
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                lo();
                this.EO = 0;
            } else {
                audioRecord2.startRecording();
                if (this.EO == 4) {
                    try {
                        audioRecord2.stop();
                        audioRecord2.release();
                    } catch (Exception e6) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    lo();
                    this.EO = 0;
                    return;
                }
                this.EO = 3;
                try {
                    if (this.EV == null) {
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
                            this.EO = 0;
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
                            this.EO = 0;
                            return;
                        }
                    }
                    com.baidu.adp.lib.util.f.writeAmrFileHeader(this.EV);
                    this.us.encoderInit();
                    if (this.EU > 0) {
                        BdSoundGate.lr().init(1600, this.EU);
                    }
                    ArrayList arrayList = new ArrayList();
                    short[] sArr2 = null;
                    short s2 = 0;
                    this.EW = System.currentTimeMillis();
                    this.uu.post(this.mRecordTimeThread);
                    while (true) {
                        if (this.EO != 3) {
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
                            if (this.EU > 0) {
                                int size = arrayList.size();
                                if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                    k(arrayList);
                                    arrayList.clear();
                                }
                                arrayList.add(sArr2);
                            } else {
                                a(sArr2);
                            }
                            sArr2 = null;
                        }
                        if (System.currentTimeMillis() - this.EW > com.baidu.adp.lib.voice.d.uy) {
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
                    if (this.EU > 0) {
                        BdSoundGate.lr().release();
                    }
                    System.currentTimeMillis();
                    audioRecord2.stop();
                    audioRecord2.release();
                    System.currentTimeMillis();
                    if (this.EO == 5) {
                        if (!lo()) {
                            if (this.mHandler != null) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                            }
                        } else {
                            try {
                                com.baidu.adp.lib.util.f.delFile(this.ER);
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                }
                            } catch (Exception e11) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                }
                                this.EO = 0;
                            }
                        }
                        this.EO = 0;
                        return;
                    }
                    this.EO = 4;
                    this.EX = System.currentTimeMillis() - this.EW;
                    aA((int) this.EX);
                    if (this.uu != null) {
                        this.uu.removeCallbacks(this.mRecordTimeThread);
                    }
                    System.currentTimeMillis();
                    if (!lo() && this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                    }
                    this.us.encoderDeinit();
                    this.EO = 0;
                    if (this.mHandler != null) {
                        if (z) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                            return;
                        }
                        Message obtainMessage2 = this.mHandler.obtainMessage(0);
                        obtainMessage2.arg1 = (int) this.EX;
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                } catch (IOException e12) {
                    audioRecord = audioRecord2;
                }
            }
        }
    }

    private void k(List<short[]> list) {
        int blockSize = BdSoundGate.lr().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.lr().a(sArr2, sArr);
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
            this.EV.write(bArr, 0, this.us.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean lo() {
        if (this.EV != null) {
            try {
                this.EV.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean l(String str, int i) {
        if (this.us == null) {
            return false;
        }
        this.EO = 0;
        this.ER = str;
        this.EU = i;
        return true;
    }

    public void stop() {
        this.EO = 4;
    }

    public void cancel() {
        this.EO = 5;
    }
}
