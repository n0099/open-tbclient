package com.baidu.adp.lib.voice;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h implements Runnable {
    private FileOutputStream mFileOutputStream;
    private final Handler mHandler;
    private Amrnb oe;
    private String oo;
    private int os;
    private long ot;
    private long ou;
    private volatile int ol = 0;
    private final Handler og = new Handler();
    private final Runnable mRecordTimeThread = new i(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i) {
        Message obtainMessage = this.mHandler.obtainMessage(9);
        obtainMessage.arg1 = i;
        this.mHandler.sendMessage(obtainMessage);
    }

    public h(Handler handler) {
        this.mHandler = handler;
        try {
            this.oe = Amrnb.getInstance();
            if (this.oe == null || !Amrnb.bLoadLibrary) {
                this.oe = null;
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
        if (this.oe == null) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
            }
        } else if (this.ol == 4) {
            if (this.mHandler != null) {
                this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
            }
            this.ol = 0;
        } else {
            if (this.oo != null && this.oo.length() > 0) {
                try {
                    File x = com.baidu.adp.lib.util.d.x(null, this.oo);
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
                    fG();
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                    }
                    this.ol = 0;
                    return;
                }
            }
            if (this.ol == 4) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                }
                fG();
                this.ol = 0;
                return;
            }
            try {
                AudioRecord fI = l.fH().fI();
                if (fI == null || fI.getState() == 0) {
                    if (fI != null) {
                        try {
                            fI.release();
                        } catch (Exception e2) {
                        }
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                    }
                    fG();
                    this.ol = 0;
                } else if (this.ol == 4) {
                    try {
                        fI.release();
                    } catch (Exception e3) {
                    }
                    if (this.mHandler != null) {
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                    }
                    fG();
                    this.ol = 0;
                } else {
                    fI.startRecording();
                    if (this.ol == 4) {
                        try {
                            fI.stop();
                            fI.release();
                        } catch (Exception e4) {
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(8));
                        }
                        fG();
                        this.ol = 0;
                        return;
                    }
                    this.ol = 3;
                    try {
                        if (this.mFileOutputStream == null) {
                            try {
                                fI.stop();
                                fI.release();
                                audioRecord = null;
                            } catch (Exception e5) {
                                audioRecord = fI;
                            }
                            try {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
                                }
                                this.ol = 0;
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
                                this.ol = 0;
                                return;
                            }
                        }
                        com.baidu.adp.lib.util.d.c(this.mFileOutputStream);
                        this.oe.encoderInit();
                        if (this.os > 0) {
                            BdSoundGate.fJ().c(1600, this.os);
                        }
                        ArrayList arrayList = new ArrayList();
                        this.ot = System.currentTimeMillis();
                        this.og.post(this.mRecordTimeThread);
                        short s2 = 0;
                        short[] sArr2 = null;
                        while (true) {
                            if (this.ol != 3) {
                                sArr = sArr2;
                                s = s2;
                                z = false;
                                break;
                            }
                            if (sArr2 == null) {
                                sArr2 = new short[160];
                                s2 = 0;
                            }
                            int read = fI.read(sArr2, s2, 160 - s2);
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
                                if (this.os > 0) {
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
                            if (System.currentTimeMillis() - this.ot > m.oE) {
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
                        if (this.os > 0) {
                            BdSoundGate.fJ().release();
                        }
                        Log.d("test_record", "1:" + (System.currentTimeMillis() - currentTimeMillis));
                        System.currentTimeMillis();
                        fI.stop();
                        fI.release();
                        System.currentTimeMillis();
                        if (this.ol == 5) {
                            if (!fG()) {
                                if (this.mHandler != null) {
                                    this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                                }
                            } else {
                                try {
                                    com.baidu.adp.lib.util.d.ax(this.oo);
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(100));
                                    }
                                } catch (Exception e9) {
                                    if (this.mHandler != null) {
                                        this.mHandler.sendMessage(this.mHandler.obtainMessage(PersonInfoActivityConfig.REQUSET_CHANGE));
                                    }
                                    this.ol = 0;
                                }
                            }
                            this.ol = 0;
                            return;
                        }
                        this.ol = 4;
                        this.ou = System.currentTimeMillis() - this.ot;
                        af((int) this.ou);
                        if (this.og != null) {
                            this.og.removeCallbacks(this.mRecordTimeThread);
                        }
                        System.currentTimeMillis();
                        if (!fG() && this.mHandler != null) {
                            this.mHandler.sendMessage(this.mHandler.obtainMessage(2));
                        }
                        this.oe.encoderDeinit();
                        this.ol = 0;
                        if (this.mHandler != null) {
                            if (z) {
                                this.mHandler.sendMessage(this.mHandler.obtainMessage(7));
                                return;
                            }
                            Message obtainMessage2 = this.mHandler.obtainMessage(0);
                            obtainMessage2.arg1 = (int) this.ou;
                            this.mHandler.sendMessage(obtainMessage2);
                        }
                    } catch (IOException e10) {
                        audioRecord = fI;
                    }
                }
            } catch (IllegalArgumentException e11) {
                if (this.mHandler != null) {
                    this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
                }
                fG();
                this.ol = 0;
            }
        }
    }

    private void d(List<short[]> list) {
        int blockSize = BdSoundGate.fJ().getBlockSize();
        short[] sArr = new short[blockSize];
        short[] sArr2 = new short[blockSize];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            System.arraycopy(list.get(i2), 0, sArr2, i, 160);
            i += 160;
            if (i2 == size - 1) {
                BdSoundGate.fJ().a(sArr2, sArr);
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
            this.mFileOutputStream.write(bArr, 0, this.oe.encoderEncode(2, sArr, bArr));
        } catch (IOException e) {
        }
    }

    private boolean fG() {
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

    public boolean i(String str, int i) {
        if (this.oe == null) {
            return false;
        }
        this.ol = 0;
        this.oo = str;
        this.os = i;
        return true;
    }

    public void stop() {
        this.ol = 4;
    }

    public void cancel() {
        this.ol = 5;
    }
}
