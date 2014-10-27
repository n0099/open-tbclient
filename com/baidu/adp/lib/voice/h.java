package com.baidu.adp.lib.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h implements Runnable {
    private final Handler mHandler;
    private Amrnb nZ;
    private String oh;
    private int ol;
    private FileOutputStream om;
    private long oo;
    private long oq;
    private volatile int of = 0;
    private final Handler ob = new Handler();
    private final Runnable mRecordTimeThread = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public h(Handler handler) {
        this.mHandler = handler;
        try {
            this.nZ = Amrnb.getInstance();
            if (this.nZ == null || !Amrnb.bLoadLibrary) {
                this.nZ = null;
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
        if (this.nZ == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.of == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.of = 0;
        } else {
            if (this.oh != null && this.oh.length() > 0) {
                try {
                    File r = com.baidu.adp.lib.util.d.r(null, this.oh);
                    if (r != null) {
                        this.om = new FileOutputStream(r);
                    } else if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                        return;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    fF();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.of = 0;
                    return;
                }
            }
            if (this.of == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                fF();
                this.of = 0;
                return;
            }
            try {
                AudioRecord fH = l.fG().fH();
                if (fH == null || fH.getState() == 0) {
                    if (fH != null) {
                        try {
                            fH.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                    }
                    fF();
                    this.of = 0;
                } else if (this.of == 4) {
                    try {
                        fH.release();
                    } catch (Exception e3) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    fF();
                    this.of = 0;
                } else {
                    fH.startRecording();
                    if (this.of == 4) {
                        try {
                            fH.stop();
                            fH.release();
                        } catch (Exception e4) {
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                        }
                        fF();
                        this.of = 0;
                        return;
                    }
                    this.of = 3;
                    try {
                        if (this.om == null) {
                            try {
                                fH.stop();
                                fH.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = fH;
                            }
                            try {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                                }
                                this.of = 0;
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
                                this.of = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.d.b(this.om);
                        this.nZ.encoderInit();
                        if (this.ol > 0) {
                            BdSoundGate.fI().b(1600, this.ol);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.oo = System.currentTimeMillis();
                        this.ob.post(this.mRecordTimeThread);
                        short s2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.of != 3) {
                                sArr = sArr2;
                                s = s2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                s2 = 0;
                            }
                            int read = fH.read(sArr2, s2, 160 - s2);
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
                                if (this.ol > 0) {
                                    int size = arrayList.size();
                                    if (size + 1 > 1 && (size + 1) % 10 == 0) {
                                        d(arrayList);
                                        arrayList.clear();
                                    }
                                    arrayList.add(sArr2);
                                } else {
                                    a(sArr2);
                                }
                                sArr2 = null;
                            }
                            if (System.currentTimeMillis() - this.oo > m.oA) {
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
                        if (this.ol > 0) {
                            BdSoundGate.fI().release();
                        }
                        Log.d("test_record", "1:" + (System.currentTimeMillis() - currentTimeMillis));
                        System.currentTimeMillis();
                        fH.stop();
                        fH.release();
                        System.currentTimeMillis();
                        if (this.of == 5) {
                            if (!fF()) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.d.au(this.oh);
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                    }
                                } catch (Exception e9) {
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
                                    }
                                    this.of = 0;
                                }
                            }
                            this.of = 0;
                            return;
                        }
                        this.of = 4;
                        this.oq = System.currentTimeMillis() - this.oo;
                        S((int) this.oq);
                        if (this.ob != null) {
                            this.ob.removeCallbacks(this.mRecordTimeThread);
                        }
                        System.currentTimeMillis();
                        if (!fF() && this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                        }
                        this.nZ.encoderDeinit();
                        this.of = 0;
                        if (this.mHandler != null) {
                            if (z) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = this.mHandler.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.oq;
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                    } catch (IOException e10) {
                        audioRecord = fH;
                    }
                }
            } catch (IllegalArgumentException e11) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                fF();
                this.of = 0;
            }
        }
    }

    private void d(List<short[]> list) {
        int blockSize = BdSoundGate.fI().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.fI().a(sArr2, sArr);
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
            this.om.write(bArr, 0, this.nZ.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean fF() {
        if (this.om != null) {
            try {
                this.om.close();
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean i(String str, int i) {
        if (this.nZ == null) {
            return false;
        }
        this.of = 0;
        this.oh = str;
        this.ol = i;
        return true;
    }

    public void stop() {
        this.of = 4;
    }

    public void cancel() {
        this.of = 5;
    }
}
