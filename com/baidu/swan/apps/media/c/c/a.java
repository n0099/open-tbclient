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
    private static volatile a aDi;
    private String aDj;
    private int aDk;
    private com.baidu.swan.apps.media.c.b.a aDm;
    private long aDn;
    private long aDo;
    private com.baidu.swan.apps.media.c.b aDq;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aDl = -1;
    private com.baidu.swan.apps.media.c.a aDp = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a Hm() {
        if (aDi == null) {
            synchronized (a.class) {
                if (aDi == null) {
                    aDi = new a();
                }
            }
        }
        return aDi;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, com.baidu.swan.apps.media.c.b bVar, String str2) {
        int i;
        if (this.aDl != -1 && this.aDl != 3) {
            c.w("record", "wrong state, can't init");
            return;
        }
        this.aDp = aVar;
        fr(str);
        this.aDq = bVar;
        this.aDk = AudioRecord.getMinBufferSize(aVar.aCV, aVar.aCU, 2);
        if (this.aDk <= 0) {
            c.e("record", "wrong buffer size");
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            BJ();
            return;
        }
        if (aVar.aCU == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aCV, i, 2, this.aDk);
        this.aDl = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void fr(String str) {
        String str2;
        if (TextUtils.equals(this.aDp.aCT, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aDp.aCT, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aDj = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void aG(boolean z) {
        if (this.mContext == null) {
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "start error, context is null");
            BJ();
        } else if (this.mIsBackground) {
            if (this.aDq != null) {
                this.aDq.n(2001, "error execute time");
            }
            c.e("record", "start error, wrong execute time");
            BJ();
        } else if (this.aDl == -1 || TextUtils.isEmpty(this.aDj)) {
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "start error, wrong state");
            BJ();
        } else if (z && this.aDl != 0 && this.aDl != 3) {
            if (this.aDq != null) {
                this.aDq.n(2003, "error execute action");
            }
            c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aDq != null) {
                        this.aDq.n(2002, "error execute");
                    }
                    c.e("record", "start error, no real permission");
                    BJ();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void xM() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.BJ();
                        }
                    });
                }
                if (this.aDq != null) {
                    this.aDq.fq(com.baidu.swan.apps.media.c.b.aCY);
                }
                d.bm("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fs */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.Hn());
                    }
                }).a(rx.a.b.a.cQm()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aDq != null) {
                                a.this.aDq.n(2002, "error execute");
                            }
                            c.e("record", "record error");
                            a.this.BJ();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aDq != null) {
                    this.aDq.n(2002, "error execute");
                }
                c.e("record", "can't start");
                BJ();
            }
        }
    }

    public void pauseRecord() {
        if (this.aDl != 1) {
            if (this.aDq != null) {
                this.aDq.n(2003, "error execute action");
            }
            c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "none audio record");
            BJ();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aDl = 2;
            GF();
            if (this.aDq != null) {
                this.aDq.fq(com.baidu.swan.apps.media.c.b.aCZ);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "pause error");
            BJ();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aDl != 2) {
            if (this.aDq != null) {
                this.aDq.n(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        aG(false);
        GE();
    }

    public void stopRecord() {
        if (this.aDl != 2 && this.aDl != 1) {
            if (this.aDq != null) {
                this.aDq.n(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "none audioRecord");
            BJ();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.aDl = 3;
            if (this.aDq != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aG(this.aDj, this.mAppId));
                    if (this.aDq != null) {
                        this.aDq.f(com.baidu.swan.apps.media.c.b.aDa, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aDq != null) {
                        this.aDq.n(2002, "error execute");
                    }
                    c.e("record", "json error" + e.toString());
                    BJ();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aDq != null) {
                this.aDq.n(2002, "error execute");
            }
            c.e("record", "stop error");
            BJ();
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
    public boolean Hn() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aDk];
        String str = this.aDp.aCT;
        int i = this.aDp.aCU;
        ?? r4 = this.aDp.aCV;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aDp.aCW);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aDj);
                if (this.aDl == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.a.w(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aDl = 1;
                    while (this.aDl == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aDk) >= 0) {
                            byte[] A = TextUtils.equals(this.aDp.aCT, "pcm") ? bArr : aVar.A(bArr);
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
                    if (this.aDl == 1) {
                        this.aDl = 3;
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
                    if (this.aDl == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.aDp.aCS);
        }
        c.i("record", "start timer, totalTime:" + this.aDp.aCS);
        this.aDm = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.xM();
                }
                a.this.stopTimer();
            }
        }, this.aDp.aCS);
        this.aDn = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("record", "stop timer");
        this.aDm = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void GF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aDo);
        }
        c.i("record", "pause timer, lastTime:" + this.aDo);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aDo = this.aDp.aCS - (System.currentTimeMillis() - this.aDn);
    }

    public void GE() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("record", "resume timer");
        if (this.aDm != null) {
            if (this.aDo <= 0) {
                this.aDm.xM();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aDm != null) {
                        a.this.aDm.xM();
                    }
                    a.this.stopTimer();
                }
            }, this.aDo);
            this.aDn = System.currentTimeMillis();
        }
    }

    public void aT(boolean z) {
        if (z && this.aDl == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public boolean aN(Context context) {
        return !com.baidu.swan.apps.an.a.Pl() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aDi != null) {
            aDi.BJ();
        }
    }

    public static void bz(boolean z) {
        if (aDi != null) {
            aDi.aT(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        this.aDl = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aDi = null;
    }

    public com.baidu.swan.apps.media.c.a Ho() {
        return this.aDp;
    }

    public com.baidu.swan.apps.media.c.b Hp() {
        return this.aDq;
    }
}
