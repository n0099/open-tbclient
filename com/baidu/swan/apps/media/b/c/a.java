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
    private static volatile a ccG;
    private String ccH;
    private int ccI;
    private com.baidu.swan.apps.media.b.b.b ccK;
    private long ccL;
    private long ccM;
    private com.baidu.swan.apps.media.b.b ccO;
    private com.baidu.swan.apps.media.b.b.a ccP;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int ccJ = -1;
    private com.baidu.swan.apps.media.b.a ccN = new com.baidu.swan.apps.media.b.a();
    private boolean ccQ = false;

    private a() {
    }

    public static a agc() {
        if (ccG == null) {
            synchronized (a.class) {
                if (ccG == null) {
                    ccG = new a();
                }
            }
        }
        return ccG;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.ccJ != -1 && this.ccJ != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.ccN = aVar;
        kB(str);
        this.ccO = bVar;
        this.ccI = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.ccI <= 0) {
            agj();
            c.e("recorder", "wrong buffer size");
            agg();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.ccr, aVar.sampleRate, i, 2, this.ccI);
        this.ccJ = 0;
        this.mContext = context;
        this.mAppId = str2;
        agl();
    }

    private void kB(String str) {
        String str2;
        if (TextUtils.equals(this.ccN.ccq, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.ccN.ccq, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.ccH = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void dU(boolean z) {
        if (this.mContext == null) {
            agj();
            c.e("recorder", "start error, context is null");
            agg();
        } else if (this.mIsBackground) {
            Q(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            agg();
        } else if (this.ccJ == -1 || TextUtils.isEmpty(this.ccH)) {
            agj();
            c.e("recorder", "start error, wrong state");
            agg();
        } else {
            if (z) {
                String str = null;
                if (this.ccJ == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.ccJ != 0 && this.ccJ != 3) {
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
                    agj();
                    c.e("recorder", "start error, no real permission");
                    agg();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void RZ() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.agg();
                        }
                    });
                    be(com.baidu.swan.apps.media.b.b.ccu, "recorderStart");
                } else {
                    be(com.baidu.swan.apps.media.b.b.ccw, "recorderResume");
                }
                d.bK("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: kD */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.agf());
                    }
                }).c(rx.a.b.a.dHE()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.agj();
                            c.e("recorder", "record error");
                            a.this.agg();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                agj();
                c.e("recorder", "can't start", e);
                agg();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            agj();
            c.e("recorder", "none audio record");
            agg();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.ccJ = 2;
            aeG();
            be(com.baidu.swan.apps.media.b.b.ccv, "recorderPause");
        } catch (IllegalStateException e) {
            agj();
            c.e("recorder", "pause error", e);
            agg();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        dU(false);
        aeF();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            agj();
            c.e("recorder", "none audioRecord");
            agg();
            return;
        }
        try {
            this.mAudioRecord.stop();
            RX();
            this.ccJ = 3;
            agk();
            agm();
        } catch (IllegalStateException e) {
            agj();
            c.e("recorder", "stop error", e);
            agg();
        }
    }

    public void agd() {
        if (this.ccJ == 0 || this.ccJ == 1) {
            if (!this.ccQ) {
                this.ccQ = true;
                be(com.baidu.swan.apps.media.b.b.ccz, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void age() {
        if (this.ccQ) {
            this.ccQ = false;
            be(com.baidu.swan.apps.media.b.b.ccA, "recorderInterruptionEnd");
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
    public boolean agf() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.ccI];
        String str = this.ccN.ccq;
        int i = this.ccN.channel;
        ?? r4 = this.ccN.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.ccN.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.ccH);
                if (this.ccJ == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.ccJ = 1;
                    while (this.ccJ == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.ccI) >= 0) {
                            byte[] A = TextUtils.equals(this.ccN.ccq, "pcm") ? bArr : aVar.A(bArr);
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
                    if (this.ccJ == 1) {
                        this.ccJ = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.ccJ == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.ccN.ccp);
        }
        c.i("recorder", "start timer, totalTime:" + this.ccN.ccp);
        this.ccK = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.RZ();
                }
                a.this.RX();
            }
        }, this.ccN.ccp);
        this.ccL = System.currentTimeMillis();
    }

    public void RX() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.ccK = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aeG() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.ccM);
        }
        c.i("recorder", "pause timer, lastTime:" + this.ccM);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.ccM = this.ccN.ccp - (System.currentTimeMillis() - this.ccL);
    }

    public void aeF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.ccK != null) {
            if (this.ccM <= 0) {
                this.ccK.RZ();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.ccK != null) {
                        a.this.ccK.RZ();
                    }
                    a.this.RX();
                }
            }, this.ccM);
            this.ccL = System.currentTimeMillis();
        }
    }

    public void cY(boolean z) {
        if (z && this.ccJ == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void dV(boolean z) {
        if (ccG != null) {
            ccG.cY(z);
        }
    }

    public static void release() {
        if (ccG != null) {
            ccG.agg();
            ccG.agm();
            ccG.age();
        }
    }

    public static void releaseAll() {
        release();
        ccG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        RX();
        this.mContext = null;
        this.ccJ = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a agh() {
        return this.ccN;
    }

    public com.baidu.swan.apps.media.b.b agi() {
        return this.ccO;
    }

    public boolean kC(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.ccJ != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.ccJ != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.ccJ != 2 && this.ccJ != 1) {
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
    public void agj() {
        Q(2002, "error execute");
    }

    private void Q(int i, String str) {
        if (this.ccO == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.ccy)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                agg();
                return;
            }
        }
        this.ccO.Q(i, str);
    }

    private void be(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.ccO != null && !TextUtils.isEmpty(str)) {
            this.ccO.ko(str);
            return;
        }
        com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void agk() {
        long j;
        long j2 = -1;
        String bA = com.baidu.swan.apps.storage.b.bA(this.ccH, this.mAppId);
        if (TextUtils.isEmpty(this.ccH)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.sw(this.ccH);
            j2 = new File(this.ccH).length();
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
            if (this.ccO != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.ccx)) {
                this.ccO.e(com.baidu.swan.apps.media.b.b.ccx, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            agj();
            c.e("recorder", "json error", e);
            agg();
        }
    }

    private void agl() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.ccP = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.ccP, 32);
        }
    }

    private void agm() {
        if (this.mTelephonyManager != null && this.ccP != null) {
            this.mTelephonyManager.listen(this.ccP, 0);
            this.mTelephonyManager = null;
            this.ccP = null;
        }
    }
}
