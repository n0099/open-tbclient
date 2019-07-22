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
    private static volatile a aCK;
    private String aCL;
    private int aCM;
    private com.baidu.swan.apps.media.c.b.a aCO;
    private long aCP;
    private long aCQ;
    private com.baidu.swan.apps.media.c.b aCS;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aCN = -1;
    private com.baidu.swan.apps.media.c.a aCR = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a Hi() {
        if (aCK == null) {
            synchronized (a.class) {
                if (aCK == null) {
                    aCK = new a();
                }
            }
        }
        return aCK;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, com.baidu.swan.apps.media.c.b bVar, String str2) {
        int i;
        if (this.aCN != -1 && this.aCN != 3) {
            c.w("record", "wrong state, can't init");
            return;
        }
        this.aCR = aVar;
        fp(str);
        this.aCS = bVar;
        this.aCM = AudioRecord.getMinBufferSize(aVar.aCx, aVar.aCw, 2);
        if (this.aCM <= 0) {
            c.e("record", "wrong buffer size");
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            BF();
            return;
        }
        if (aVar.aCw == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aCx, i, 2, this.aCM);
        this.aCN = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void fp(String str) {
        String str2;
        if (TextUtils.equals(this.aCR.aCv, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aCR.aCv, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aCL = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void aG(boolean z) {
        if (this.mContext == null) {
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "start error, context is null");
            BF();
        } else if (this.mIsBackground) {
            if (this.aCS != null) {
                this.aCS.n(2001, "error execute time");
            }
            c.e("record", "start error, wrong execute time");
            BF();
        } else if (this.aCN == -1 || TextUtils.isEmpty(this.aCL)) {
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "start error, wrong state");
            BF();
        } else if (z && this.aCN != 0 && this.aCN != 3) {
            if (this.aCS != null) {
                this.aCS.n(2003, "error execute action");
            }
            c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aCS != null) {
                        this.aCS.n(2002, "error execute");
                    }
                    c.e("record", "start error, no real permission");
                    BF();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void xI() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.BF();
                        }
                    });
                }
                if (this.aCS != null) {
                    this.aCS.fo(com.baidu.swan.apps.media.c.b.aCA);
                }
                d.bm("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fq */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.Hj());
                    }
                }).a(rx.a.b.a.cPf()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aCS != null) {
                                a.this.aCS.n(2002, "error execute");
                            }
                            c.e("record", "record error");
                            a.this.BF();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aCS != null) {
                    this.aCS.n(2002, "error execute");
                }
                c.e("record", "can't start");
                BF();
            }
        }
    }

    public void pauseRecord() {
        if (this.aCN != 1) {
            if (this.aCS != null) {
                this.aCS.n(2003, "error execute action");
            }
            c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "none audio record");
            BF();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aCN = 2;
            GB();
            if (this.aCS != null) {
                this.aCS.fo(com.baidu.swan.apps.media.c.b.aCB);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "pause error");
            BF();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aCN != 2) {
            if (this.aCS != null) {
                this.aCS.n(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        aG(false);
        GA();
    }

    public void stopRecord() {
        if (this.aCN != 2 && this.aCN != 1) {
            if (this.aCS != null) {
                this.aCS.n(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "none audioRecord");
            BF();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.aCN = 3;
            if (this.aCS != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aG(this.aCL, this.mAppId));
                    if (this.aCS != null) {
                        this.aCS.f(com.baidu.swan.apps.media.c.b.aCC, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aCS != null) {
                        this.aCS.n(2002, "error execute");
                    }
                    c.e("record", "json error" + e.toString());
                    BF();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aCS != null) {
                this.aCS.n(2002, "error execute");
            }
            c.e("record", "stop error");
            BF();
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
    public boolean Hj() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aCM];
        String str = this.aCR.aCv;
        int i = this.aCR.aCw;
        ?? r4 = this.aCR.aCx;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aCR.aCy);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aCL);
                if (this.aCN == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.a.w(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aCN = 1;
                    while (this.aCN == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aCM) >= 0) {
                            byte[] A = TextUtils.equals(this.aCR.aCv, "pcm") ? bArr : aVar.A(bArr);
                            if (A != null && A.length > 0) {
                                fileOutputStream.write(A);
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
                    if (this.aCN == 1) {
                        this.aCN = 3;
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
                    if (this.aCN == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.aCR.aCu);
        }
        c.i("record", "start timer, totalTime:" + this.aCR.aCu);
        this.aCO = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.xI();
                }
                a.this.stopTimer();
            }
        }, this.aCR.aCu);
        this.aCP = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("record", "stop timer");
        this.aCO = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void GB() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aCQ);
        }
        c.i("record", "pause timer, lastTime:" + this.aCQ);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aCQ = this.aCR.aCu - (System.currentTimeMillis() - this.aCP);
    }

    public void GA() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("record", "resume timer");
        if (this.aCO != null) {
            if (this.aCQ <= 0) {
                this.aCO.xI();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aCO != null) {
                        a.this.aCO.xI();
                    }
                    a.this.stopTimer();
                }
            }, this.aCQ);
            this.aCP = System.currentTimeMillis();
        }
    }

    public void aT(boolean z) {
        if (z && this.aCN == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public boolean aN(Context context) {
        return !com.baidu.swan.apps.an.a.Ph() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aCK != null) {
            aCK.BF();
        }
    }

    public static void bz(boolean z) {
        if (aCK != null) {
            aCK.aT(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF() {
        this.aCN = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aCK = null;
    }

    public com.baidu.swan.apps.media.c.a Hk() {
        return this.aCR;
    }

    public com.baidu.swan.apps.media.c.b Hl() {
        return this.aCS;
    }
}
