package com.baidu.swan.apps.media.c.c;

import android.content.Context;
import android.media.AudioRecord;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a aBb;
    private String aBc;
    private int aBd;
    private com.baidu.swan.apps.media.c.b.a aBf;
    private long aBg;
    private long aBh;
    private com.baidu.swan.apps.media.c.b aBj;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aBe = -1;
    private com.baidu.swan.apps.media.c.a aBi = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a EG() {
        if (aBb == null) {
            synchronized (a.class) {
                if (aBb == null) {
                    aBb = new a();
                }
            }
        }
        return aBb;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, com.baidu.swan.apps.media.c.b bVar, String str2) {
        int i;
        if (this.aBe != -1 && this.aBe != 3) {
            c.w("record", "wrong state, can't init");
            return;
        }
        this.aBi = aVar;
        eZ(str);
        this.aBj = bVar;
        this.aBd = AudioRecord.getMinBufferSize(aVar.aAP, aVar.aAO, 2);
        if (this.aBd <= 0) {
            c.e("record", "wrong buffer size");
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            zP();
            return;
        }
        if (aVar.aAO == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aAP, i, 2, this.aBd);
        this.aBe = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void eZ(String str) {
        String str2;
        if (TextUtils.equals(this.aBi.aAN, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aBi.aAN, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aBc = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void bn(boolean z) {
        if (this.mContext == null) {
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "start error, context is null");
            zP();
        } else if (this.mIsBackground) {
            if (this.aBj != null) {
                this.aBj.k(2001, "error execute time");
            }
            c.e("record", "start error, wrong execute time");
            zP();
        } else if (this.aBe == -1 || TextUtils.isEmpty(this.aBc)) {
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "start error, wrong state");
            zP();
        } else if (z && this.aBe != 0 && this.aBe != 3) {
            if (this.aBj != null) {
                this.aBj.k(2003, "error execute action");
            }
            c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aBj != null) {
                        this.aBj.k(2002, "error execute");
                    }
                    c.e("record", "start error, no real permission");
                    zP();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void wq() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.zP();
                        }
                    });
                }
                if (this.aBj != null) {
                    this.aBj.eY(com.baidu.swan.apps.media.c.b.aAS);
                }
                d.bn("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fa */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.EH());
                    }
                }).a(rx.a.b.a.cDU()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aBj != null) {
                                a.this.aBj.k(2002, "error execute");
                            }
                            c.e("record", "record error");
                            a.this.zP();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aBj != null) {
                    this.aBj.k(2002, "error execute");
                }
                c.e("record", "can't start");
                zP();
            }
        }
    }

    public void EE() {
        if (this.aBe != 1) {
            if (this.aBj != null) {
                this.aBj.k(2003, "error execute action");
            }
            c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "none audio record");
            zP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aBe = 2;
            DY();
            if (this.aBj != null) {
                this.aBj.eY(com.baidu.swan.apps.media.c.b.aAT);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "pause error");
            zP();
        }
    }

    public void EF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aBe != 2) {
            if (this.aBj != null) {
                this.aBj.k(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        bn(false);
        DX();
    }

    public void stopRecord() {
        if (this.aBe != 2 && this.aBe != 1) {
            if (this.aBj != null) {
                this.aBj.k(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "none audioRecord");
            zP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.aBe = 3;
            if (this.aBj != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aD(this.aBc, this.mAppId));
                    if (this.aBj != null) {
                        this.aBj.f(com.baidu.swan.apps.media.c.b.aAU, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aBj != null) {
                        this.aBj.k(2002, "error execute");
                    }
                    c.e("record", "json error" + e.toString());
                    zP();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aBj != null) {
                this.aBj.k(2002, "error execute");
            }
            c.e("record", "stop error");
            zP();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0101 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:14:0x003f, B:15:0x0041, B:17:0x0045, B:19:0x0050, B:23:0x0060, B:25:0x0063, B:41:0x00a0, B:28:0x0068, B:30:0x006c, B:31:0x006f, B:33:0x0073), top: B:67:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073 A[Catch: all -> 0x0101, TRY_LEAVE, TryCatch #0 {all -> 0x0101, blocks: (B:14:0x003f, B:15:0x0041, B:17:0x0045, B:19:0x0050, B:23:0x0060, B:25:0x0063, B:41:0x00a0, B:28:0x0068, B:30:0x006c, B:31:0x006f, B:33:0x0073), top: B:67:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean EH() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aBd];
        String str = this.aBi.aAN;
        int i = this.aBi.aAO;
        ?? r4 = this.aBi.aAP;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aBi.aAQ);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aBc);
                if (this.aBe == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.b.C(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aBe = 1;
                    while (this.aBe == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aBd) >= 0) {
                            byte[] F = TextUtils.equals(this.aBi.aAN, "pcm") ? bArr : aVar.F(bArr);
                            if (F != null && F.length > 0) {
                                fileOutputStream.write(F);
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            if (DEBUG) {
                                Log.w("AudioRecorderManager", "close recorder fos error:" + e.getMessage());
                            }
                        }
                    }
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    fileOutputStream = fileOutputStream2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (this.aBe == 1) {
                        this.aBe = 3;
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e3) {
                            if (DEBUG) {
                                Log.w("AudioRecorderManager", "close recorder fos error:" + e3.getMessage());
                                return false;
                            }
                            return false;
                        }
                    }
                    return false;
                } catch (IllegalStateException e4) {
                    e = e4;
                    if (DEBUG) {
                    }
                    if (this.aBe == 1) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r4 != 0) {
                    try {
                        r4.close();
                    } catch (Exception e5) {
                        if (DEBUG) {
                            Log.w("AudioRecorderManager", "close recorder fos error:" + e5.getMessage());
                        }
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (IllegalStateException e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r4 = 0;
            if (r4 != 0) {
            }
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.c.b.a aVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.aBi.aAM);
        }
        c.i("record", "start timer, totalTime:" + this.aBi.aAM);
        this.aBf = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.wq();
                }
                a.this.stopTimer();
            }
        }, this.aBi.aAM);
        this.aBg = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("record", "stop timer");
        this.aBf = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void DY() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aBh);
        }
        c.i("record", "pause timer, lastTime:" + this.aBh);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aBh = this.aBi.aAM - (System.currentTimeMillis() - this.aBg);
    }

    public void DX() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("record", "resume timer");
        if (this.aBf != null) {
            if (this.aBh <= 0) {
                this.aBf.wq();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aBf != null) {
                        a.this.aBf.wq();
                    }
                    a.this.stopTimer();
                }
            }, this.aBh);
            this.aBg = System.currentTimeMillis();
        }
    }

    public void aO(boolean z) {
        if (z && this.aBe == 1) {
            EE();
        }
        this.mIsBackground = z;
    }

    public boolean bu(Context context) {
        return !com.baidu.swan.apps.an.a.LN() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aBb != null) {
            aBb.zP();
        }
    }

    public static void bo(boolean z) {
        if (aBb != null) {
            aBb.aO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        this.aBe = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aBb = null;
    }

    public com.baidu.swan.apps.media.c.a EI() {
        return this.aBi;
    }

    public com.baidu.swan.apps.media.c.b EJ() {
        return this.aBj;
    }
}
