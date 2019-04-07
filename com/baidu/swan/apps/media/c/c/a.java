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
    private static volatile a aBe;
    private String aBf;
    private int aBg;
    private com.baidu.swan.apps.media.c.b.a aBi;
    private long aBj;
    private long aBk;
    private com.baidu.swan.apps.media.c.b aBm;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aBh = -1;
    private com.baidu.swan.apps.media.c.a aBl = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a EE() {
        if (aBe == null) {
            synchronized (a.class) {
                if (aBe == null) {
                    aBe = new a();
                }
            }
        }
        return aBe;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, com.baidu.swan.apps.media.c.b bVar, String str2) {
        int i;
        if (this.aBh != -1 && this.aBh != 3) {
            c.w("record", "wrong state, can't init");
            return;
        }
        this.aBl = aVar;
        fa(str);
        this.aBm = bVar;
        this.aBg = AudioRecord.getMinBufferSize(aVar.aAS, aVar.aAR, 2);
        if (this.aBg <= 0) {
            c.e("record", "wrong buffer size");
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            zO();
            return;
        }
        if (aVar.aAR == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aAS, i, 2, this.aBg);
        this.aBh = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void fa(String str) {
        String str2;
        if (TextUtils.equals(this.aBl.aAQ, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aBl.aAQ, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aBf = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void bn(boolean z) {
        if (this.mContext == null) {
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "start error, context is null");
            zO();
        } else if (this.mIsBackground) {
            if (this.aBm != null) {
                this.aBm.k(2001, "error execute time");
            }
            c.e("record", "start error, wrong execute time");
            zO();
        } else if (this.aBh == -1 || TextUtils.isEmpty(this.aBf)) {
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "start error, wrong state");
            zO();
        } else if (z && this.aBh != 0 && this.aBh != 3) {
            if (this.aBm != null) {
                this.aBm.k(2003, "error execute action");
            }
            c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aBm != null) {
                        this.aBm.k(2002, "error execute");
                    }
                    c.e("record", "start error, no real permission");
                    zO();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void wp() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.zO();
                        }
                    });
                }
                if (this.aBm != null) {
                    this.aBm.eZ(com.baidu.swan.apps.media.c.b.aAV);
                }
                d.bj("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fb */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.EF());
                    }
                }).a(rx.a.b.a.cDJ()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aBm != null) {
                                a.this.aBm.k(2002, "error execute");
                            }
                            c.e("record", "record error");
                            a.this.zO();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aBm != null) {
                    this.aBm.k(2002, "error execute");
                }
                c.e("record", "can't start");
                zO();
            }
        }
    }

    public void EC() {
        if (this.aBh != 1) {
            if (this.aBm != null) {
                this.aBm.k(2003, "error execute action");
            }
            c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "none audio record");
            zO();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aBh = 2;
            DW();
            if (this.aBm != null) {
                this.aBm.eZ(com.baidu.swan.apps.media.c.b.aAW);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "pause error");
            zO();
        }
    }

    public void ED() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aBh != 2) {
            if (this.aBm != null) {
                this.aBm.k(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        bn(false);
        DV();
    }

    public void stopRecord() {
        if (this.aBh != 2 && this.aBh != 1) {
            if (this.aBm != null) {
                this.aBm.k(2003, "error execute action");
            }
            c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "none audioRecord");
            zO();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.aBh = 3;
            if (this.aBm != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aD(this.aBf, this.mAppId));
                    if (this.aBm != null) {
                        this.aBm.f(com.baidu.swan.apps.media.c.b.aAX, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aBm != null) {
                        this.aBm.k(2002, "error execute");
                    }
                    c.e("record", "json error" + e.toString());
                    zO();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aBm != null) {
                this.aBm.k(2002, "error execute");
            }
            c.e("record", "stop error");
            zO();
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
    public boolean EF() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aBg];
        String str = this.aBl.aAQ;
        int i = this.aBl.aAR;
        ?? r4 = this.aBl.aAS;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aBl.aAT);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aBf);
                if (this.aBh == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.b.C(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aBh = 1;
                    while (this.aBh == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aBg) >= 0) {
                            byte[] F = TextUtils.equals(this.aBl.aAQ, "pcm") ? bArr : aVar.F(bArr);
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
                    if (this.aBh == 1) {
                        this.aBh = 3;
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
                    if (this.aBh == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.aBl.aAP);
        }
        c.i("record", "start timer, totalTime:" + this.aBl.aAP);
        this.aBi = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.wp();
                }
                a.this.stopTimer();
            }
        }, this.aBl.aAP);
        this.aBj = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("record", "stop timer");
        this.aBi = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void DW() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aBk);
        }
        c.i("record", "pause timer, lastTime:" + this.aBk);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aBk = this.aBl.aAP - (System.currentTimeMillis() - this.aBj);
    }

    public void DV() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("record", "resume timer");
        if (this.aBi != null) {
            if (this.aBk <= 0) {
                this.aBi.wp();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aBi != null) {
                        a.this.aBi.wp();
                    }
                    a.this.stopTimer();
                }
            }, this.aBk);
            this.aBj = System.currentTimeMillis();
        }
    }

    public void aO(boolean z) {
        if (z && this.aBh == 1) {
            EC();
        }
        this.mIsBackground = z;
    }

    public boolean bu(Context context) {
        return !com.baidu.swan.apps.an.a.LL() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aBe != null) {
            aBe.zO();
        }
    }

    public static void bo(boolean z) {
        if (aBe != null) {
            aBe.aO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO() {
        this.aBh = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aBe = null;
    }

    public com.baidu.swan.apps.media.c.a EG() {
        return this.aBl;
    }

    public com.baidu.swan.apps.media.c.b EH() {
        return this.aBm;
    }
}
