package com.baidu.swan.apps.media.b.c;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bzE;
    private String bzF;
    private int bzG;
    private com.baidu.swan.apps.media.b.b.b bzI;
    private long bzJ;
    private long bzK;
    private com.baidu.swan.apps.media.b.b bzM;
    private com.baidu.swan.apps.media.b.b.a bzN;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int bzH = -1;
    private com.baidu.swan.apps.media.b.a bzL = new com.baidu.swan.apps.media.b.a();
    private boolean bzO = false;

    private a() {
    }

    public static a VD() {
        if (bzE == null) {
            synchronized (a.class) {
                if (bzE == null) {
                    bzE = new a();
                }
            }
        }
        return bzE;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.bzH != -1 && this.bzH != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.bzL = aVar;
        ja(str);
        this.bzM = bVar;
        this.bzG = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.bzp, 2);
        if (this.bzG <= 0) {
            VK();
            c.e("recorder", "wrong buffer size");
            VH();
            return;
        }
        if (aVar.bzp == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.bzq, aVar.sampleRate, i, 2, this.bzG);
        this.bzH = 0;
        this.mContext = context;
        this.mAppId = str2;
        VM();
    }

    private void ja(String str) {
        String str2;
        if (TextUtils.equals(this.bzL.bzo, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.bzL.bzo, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.bzF = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void cQ(boolean z) {
        if (this.mContext == null) {
            VK();
            c.e("recorder", "start error, context is null");
            VH();
        } else if (this.mIsBackground) {
            x(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            VH();
        } else if (this.bzH == -1 || TextUtils.isEmpty(this.bzF)) {
            VK();
            c.e("recorder", "start error, wrong state");
            VH();
        } else {
            if (z) {
                String str = null;
                if (this.bzH == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.bzH != 0 && this.bzH != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    x(2003, str);
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
                    VK();
                    c.e("recorder", "start error, no real permission");
                    VH();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void HR() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.VH();
                        }
                    });
                    aM(com.baidu.swan.apps.media.b.b.bzs, "recorderStart");
                } else {
                    aM(com.baidu.swan.apps.media.b.b.bzu, "recorderResume");
                }
                d.ca("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: jc */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.VG());
                    }
                }).c(rx.a.b.a.dMM()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.VK();
                            c.e("recorder", "record error");
                            a.this.VH();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                VK();
                c.e("recorder", "can't start", e);
                VH();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            VK();
            c.e("recorder", "none audio record");
            VH();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.bzH = 2;
            Uy();
            aM(com.baidu.swan.apps.media.b.b.bzt, "recorderPause");
        } catch (IllegalStateException e) {
            VK();
            c.e("recorder", "pause error", e);
            VH();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        cQ(false);
        Ux();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            VK();
            c.e("recorder", "none audioRecord");
            VH();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.bzH = 3;
            VL();
            VN();
        } catch (IllegalStateException e) {
            VK();
            c.e("recorder", "stop error", e);
            VH();
        }
    }

    public void VE() {
        if (this.bzH == 0 || this.bzH == 1) {
            if (!this.bzO) {
                this.bzO = true;
                aM(com.baidu.swan.apps.media.b.b.bzx, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void VF() {
        if (this.bzO) {
            this.bzO = false;
            aM(com.baidu.swan.apps.media.b.b.bzy, "recorderInterruptionEnd");
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
    public boolean VG() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.bzG];
        String str = this.bzL.bzo;
        int i = this.bzL.bzp;
        ?? r4 = this.bzL.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.bzL.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.bzF);
                if (this.bzH == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.bzH = 1;
                    while (this.bzH == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.bzG) >= 0) {
                            byte[] t = TextUtils.equals(this.bzL.bzo, "pcm") ? bArr : aVar.t(bArr);
                            if (t != null && t.length > 0) {
                                fileOutputStream.write(t);
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
                    if (this.bzH == 1) {
                        this.bzH = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.bzH == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.bzL.bzn);
        }
        c.i("recorder", "start timer, totalTime:" + this.bzL.bzn);
        this.bzI = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.HR();
                }
                a.this.stopTimer();
            }
        }, this.bzL.bzn);
        this.bzJ = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.bzI = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void Uy() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.bzK);
        }
        c.i("recorder", "pause timer, lastTime:" + this.bzK);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.bzK = this.bzL.bzn - (System.currentTimeMillis() - this.bzJ);
    }

    public void Ux() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.bzI != null) {
            if (this.bzK <= 0) {
                this.bzI.HR();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.bzI != null) {
                        a.this.bzI.HR();
                    }
                    a.this.stopTimer();
                }
            }, this.bzK);
            this.bzJ = System.currentTimeMillis();
        }
    }

    public void bT(boolean z) {
        if (z && this.bzH == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cR(boolean z) {
        if (bzE != null) {
            bzE.bT(z);
        }
    }

    public static void release() {
        if (bzE != null) {
            bzE.VH();
            bzE.VN();
            bzE.VF();
        }
    }

    public static void releaseAll() {
        release();
        bzE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VH() {
        stopTimer();
        this.mContext = null;
        this.bzH = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a VI() {
        return this.bzL;
    }

    public com.baidu.swan.apps.media.b.b VJ() {
        return this.bzM;
    }

    public boolean jb(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.bzH != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.bzH != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.bzH != 2 && this.bzH != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            x(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VK() {
        x(2002, "error execute");
    }

    private void x(int i, String str) {
        if (this.bzM == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bzw)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                VH();
                return;
            }
        }
        this.bzM.x(i, str);
    }

    private void aM(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.bzM != null && !TextUtils.isEmpty(str)) {
            this.bzM.iN(str);
            return;
        }
        com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void VL() {
        long j;
        long j2 = -1;
        String bi = com.baidu.swan.apps.storage.b.bi(this.bzF, this.mAppId);
        if (TextUtils.isEmpty(this.bzF)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.qU(this.bzF);
            j2 = new File(this.bzF).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bi)) {
                jSONObject.put("tempFilePath", bi);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.bzM != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bzv)) {
                this.bzM.d(com.baidu.swan.apps.media.b.b.bzv, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            VK();
            c.e("recorder", "json error", e);
            VH();
        }
    }

    private void VM() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.bzN = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bzN, 32);
        }
    }

    private void VN() {
        if (this.mTelephonyManager != null && this.bzN != null) {
            this.mTelephonyManager.listen(this.bzN, 0);
            this.mTelephonyManager = null;
            this.bzN = null;
        }
    }
}
