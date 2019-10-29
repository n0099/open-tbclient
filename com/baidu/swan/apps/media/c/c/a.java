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
    private static volatile a aWx;
    private com.baidu.swan.apps.media.c.b.a aWB;
    private long aWC;
    private long aWD;
    private com.baidu.swan.apps.media.c.b aWF;
    private String aWy;
    private int aWz;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aWA = -1;
    private com.baidu.swan.apps.media.c.a aWE = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a Mg() {
        if (aWx == null) {
            synchronized (a.class) {
                if (aWx == null) {
                    aWx = new a();
                }
            }
        }
        return aWx;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, com.baidu.swan.apps.media.c.b bVar, String str2) {
        int i;
        if (this.aWA != -1 && this.aWA != 3) {
            c.w("record", "wrong state, can't init");
            return;
        }
        this.aWE = aVar;
        fX(str);
        this.aWF = bVar;
        this.aWz = AudioRecord.getMinBufferSize(aVar.aWk, aVar.aWj, 2);
        if (this.aWz <= 0) {
            c.e("record", "wrong buffer size");
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            GD();
            return;
        }
        if (aVar.aWj == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aWk, i, 2, this.aWz);
        this.aWA = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void fX(String str) {
        String str2;
        if (TextUtils.equals(this.aWE.aWi, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aWE.aWi, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aWy = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void aY(boolean z) {
        if (this.mContext == null) {
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "start error, context is null");
            GD();
        } else if (this.mIsBackground) {
            if (this.aWF != null) {
                this.aWF.r(2001, "error execute time");
            }
            c.e("record", "start error, wrong execute time");
            GD();
        } else if (this.aWA == -1 || TextUtils.isEmpty(this.aWy)) {
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "start error, wrong state");
            GD();
        } else if (z && this.aWA != 0 && this.aWA != 3) {
            if (this.aWF != null) {
                this.aWF.r(2003, "error execute action");
            }
            c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aWF != null) {
                        this.aWF.r(2002, "error execute");
                    }
                    c.e("record", "start error, no real permission");
                    GD();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void CH() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.GD();
                        }
                    });
                }
                if (this.aWF != null) {
                    this.aWF.fW(com.baidu.swan.apps.media.c.b.aWn);
                }
                d.bh("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fY */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.Mh());
                    }
                }).a(rx.a.b.a.cOs()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aWF != null) {
                                a.this.aWF.r(2002, "error execute");
                            }
                            c.e("record", "record error");
                            a.this.GD();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aWF != null) {
                    this.aWF.r(2002, "error execute");
                }
                c.e("record", "can't start");
                GD();
            }
        }
    }

    public void pauseRecord() {
        if (this.aWA != 1) {
            if (this.aWF != null) {
                this.aWF.r(2003, "error execute action");
            }
            c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "none audio record");
            GD();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aWA = 2;
            Lz();
            if (this.aWF != null) {
                this.aWF.fW(com.baidu.swan.apps.media.c.b.aWo);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "pause error");
            GD();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aWA != 2) {
            if (this.aWF != null) {
                this.aWF.r(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        aY(false);
        Ly();
    }

    public void stopRecord() {
        if (this.aWA != 2 && this.aWA != 1) {
            if (this.aWF != null) {
                this.aWF.r(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "none audioRecord");
            GD();
            return;
        }
        try {
            this.mAudioRecord.stop();
            CE();
            this.aWA = 3;
            if (this.aWF != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aN(this.aWy, this.mAppId));
                    if (this.aWF != null) {
                        this.aWF.f(com.baidu.swan.apps.media.c.b.aWp, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aWF != null) {
                        this.aWF.r(2002, "error execute");
                    }
                    c.e("record", "json error" + e.toString());
                    GD();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aWF != null) {
                this.aWF.r(2002, "error execute");
            }
            c.e("record", "stop error");
            GD();
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
    public boolean Mh() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aWz];
        String str = this.aWE.aWi;
        int i = this.aWE.aWj;
        ?? r4 = this.aWE.aWk;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aWE.aWl);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aWy);
                if (this.aWA == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.a.n(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aWA = 1;
                    while (this.aWA == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aWz) >= 0) {
                            byte[] s = TextUtils.equals(this.aWE.aWi, "pcm") ? bArr : aVar.s(bArr);
                            if (s != null && s.length > 0) {
                                fileOutputStream.write(s);
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
                    if (this.aWA == 1) {
                        this.aWA = 3;
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
                    if (this.aWA == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.aWE.aWh);
        }
        c.i("record", "start timer, totalTime:" + this.aWE.aWh);
        this.aWB = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.CH();
                }
                a.this.CE();
            }
        }, this.aWE.aWh);
        this.aWC = System.currentTimeMillis();
    }

    public void CE() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("record", "stop timer");
        this.aWB = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void Lz() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aWD);
        }
        c.i("record", "pause timer, lastTime:" + this.aWD);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aWD = this.aWE.aWh - (System.currentTimeMillis() - this.aWC);
    }

    public void Ly() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("record", "resume timer");
        if (this.aWB != null) {
            if (this.aWD <= 0) {
                this.aWB.CH();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aWB != null) {
                        a.this.aWB.CH();
                    }
                    a.this.CE();
                }
            }, this.aWD);
            this.aWC = System.currentTimeMillis();
        }
    }

    public void bl(boolean z) {
        if (z && this.aWA == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public boolean aP(Context context) {
        return !com.baidu.swan.apps.an.a.Ub() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aWx != null) {
            aWx.GD();
        }
    }

    public static void bR(boolean z) {
        if (aWx != null) {
            aWx.bl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        this.aWA = -1;
        CE();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aWx = null;
    }

    public com.baidu.swan.apps.media.c.a Mi() {
        return this.aWE;
    }

    public com.baidu.swan.apps.media.c.b Mj() {
        return this.aWF;
    }
}
