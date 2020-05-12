package com.baidu.swan.apps.media.b.c;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a ccM;
    private String ccN;
    private int ccO;
    private com.baidu.swan.apps.media.b.b.b ccQ;
    private long ccR;
    private long ccS;
    private com.baidu.swan.apps.media.b.b ccU;
    private com.baidu.swan.apps.media.b.b.a ccV;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int ccP = -1;
    private com.baidu.swan.apps.media.b.a ccT = new com.baidu.swan.apps.media.b.a();
    private boolean ccW = false;

    private a() {
    }

    public static a agb() {
        if (ccM == null) {
            synchronized (a.class) {
                if (ccM == null) {
                    ccM = new a();
                }
            }
        }
        return ccM;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.ccP != -1 && this.ccP != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.ccT = aVar;
        kB(str);
        this.ccU = bVar;
        this.ccO = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.ccO <= 0) {
            agi();
            c.e("recorder", "wrong buffer size");
            agf();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.ccy, aVar.sampleRate, i, 2, this.ccO);
        this.ccP = 0;
        this.mContext = context;
        this.mAppId = str2;
        agk();
    }

    private void kB(String str) {
        String str2;
        if (TextUtils.equals(this.ccT.ccx, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.ccT.ccx, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.ccN = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void dU(boolean z) {
        if (this.mContext == null) {
            agi();
            c.e("recorder", "start error, context is null");
            agf();
        } else if (this.mIsBackground) {
            Q(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            agf();
        } else if (this.ccP == -1 || TextUtils.isEmpty(this.ccN)) {
            agi();
            c.e("recorder", "start error, wrong state");
            agf();
        } else {
            if (z) {
                String str = null;
                if (this.ccP == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.ccP != 0 && this.ccP != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    Q(2003, str);
                    c.e("recorder", str);
                    return;
                }
            }
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    agi();
                    c.e("recorder", "start error, no real permission");
                    agf();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void RY() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.agf();
                        }
                    });
                    be(com.baidu.swan.apps.media.b.b.ccA, "recorderStart");
                } else {
                    be(com.baidu.swan.apps.media.b.b.ccC, "recorderResume");
                }
                d.bL("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: kD */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.age());
                    }
                }).c(rx.a.b.a.dHB()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.agi();
                            c.e("recorder", "record error");
                            a.this.agf();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                agi();
                c.e("recorder", "can't start", e);
                agf();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            agi();
            c.e("recorder", "none audio record");
            agf();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.ccP = 2;
            aeF();
            be(com.baidu.swan.apps.media.b.b.ccB, "recorderPause");
        } catch (IllegalStateException e) {
            agi();
            c.e("recorder", "pause error", e);
            agf();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        dU(false);
        aeE();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            agi();
            c.e("recorder", "none audioRecord");
            agf();
            return;
        }
        try {
            this.mAudioRecord.stop();
            RW();
            this.ccP = 3;
            agj();
            agl();
        } catch (IllegalStateException e) {
            agi();
            c.e("recorder", "stop error", e);
            agf();
        }
    }

    public void agc() {
        if (this.ccP == 0 || this.ccP == 1) {
            if (!this.ccW) {
                this.ccW = true;
                be(com.baidu.swan.apps.media.b.b.ccF, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void agd() {
        if (this.ccW) {
            this.ccW = false;
            be(com.baidu.swan.apps.media.b.b.ccG, "recorderInterruptionEnd");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [457=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x008f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0075 A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #4 {all -> 0x008f, blocks: (B:14:0x003f, B:15:0x0041, B:17:0x0045, B:19:0x0050, B:23:0x0060, B:25:0x0063, B:32:0x007c, B:28:0x0068, B:30:0x0075), top: B:47:0x0021 }] */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean age() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.ccO];
        String str = this.ccT.ccx;
        int i = this.ccT.channel;
        ?? r4 = this.ccT.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.ccT.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.ccN);
                if (this.ccP == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.ccP = 1;
                    while (this.ccP == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.ccO) >= 0) {
                            byte[] A = TextUtils.equals(this.ccT.ccx, "pcm") ? bArr : aVar.A(bArr);
                            if (A != null && A.length > 0) {
                                fileOutputStream.write(A);
                            }
                        }
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    fileOutputStream = fileOutputStream2;
                    c.e("recorder", "save record error", e);
                    if (this.ccP == 1) {
                        this.ccP = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.ccP == 1) {
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.d.c.closeSafely(r4);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (IllegalStateException e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r4 = 0;
            com.baidu.swan.d.c.closeSafely(r4);
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.b.b.b bVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.ccT.ccw);
        }
        c.i("recorder", "start timer, totalTime:" + this.ccT.ccw);
        this.ccQ = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.RY();
                }
                a.this.RW();
            }
        }, this.ccT.ccw);
        this.ccR = System.currentTimeMillis();
    }

    public void RW() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.ccQ = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aeF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.ccS);
        }
        c.i("recorder", "pause timer, lastTime:" + this.ccS);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.ccS = this.ccT.ccw - (System.currentTimeMillis() - this.ccR);
    }

    public void aeE() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.ccQ != null) {
            if (this.ccS <= 0) {
                this.ccQ.RY();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.ccQ != null) {
                        a.this.ccQ.RY();
                    }
                    a.this.RW();
                }
            }, this.ccS);
            this.ccR = System.currentTimeMillis();
        }
    }

    public void cY(boolean z) {
        if (z && this.ccP == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void dV(boolean z) {
        if (ccM != null) {
            ccM.cY(z);
        }
    }

    public static void release() {
        if (ccM != null) {
            ccM.agf();
            ccM.agl();
            ccM.agd();
        }
    }

    public static void releaseAll() {
        release();
        ccM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agf() {
        RW();
        this.mContext = null;
        this.ccP = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a agg() {
        return this.ccT;
    }

    public com.baidu.swan.apps.media.b.b agh() {
        return this.ccU;
    }

    public boolean kC(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.ccP != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.ccP != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.ccP != 2 && this.ccP != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            Q(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agi() {
        Q(2002, "error execute");
    }

    private void Q(int i, String str) {
        if (this.ccU == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.ccE)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                agf();
                return;
            }
        }
        this.ccU.Q(i, str);
    }

    private void be(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.ccU != null && !TextUtils.isEmpty(str)) {
            this.ccU.ko(str);
            return;
        }
        com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void agj() {
        long j;
        long j2 = -1;
        String bA = com.baidu.swan.apps.storage.b.bA(this.ccN, this.mAppId);
        if (TextUtils.isEmpty(this.ccN)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.sw(this.ccN);
            j2 = new File(this.ccN).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bA)) {
                jSONObject.put("tempFilePath", bA);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.ccU != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.ccD)) {
                this.ccU.e(com.baidu.swan.apps.media.b.b.ccD, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            agi();
            c.e("recorder", "json error", e);
            agf();
        }
    }

    private void agk() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.ccV = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.ccV, 32);
        }
    }

    private void agl() {
        if (this.mTelephonyManager != null && this.ccV != null) {
            this.mTelephonyManager.listen(this.ccV, 0);
            this.mTelephonyManager = null;
            this.ccV = null;
        }
    }
}
