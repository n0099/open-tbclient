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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a byR;
    private String byS;
    private int byT;
    private com.baidu.swan.apps.media.b.b.b byV;
    private long byW;
    private long byX;
    private com.baidu.swan.apps.media.b.b byZ;
    private com.baidu.swan.apps.media.b.b.a bza;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int byU = -1;
    private com.baidu.swan.apps.media.b.a byY = new com.baidu.swan.apps.media.b.a();
    private boolean bzb = false;

    private a() {
    }

    public static a Vg() {
        if (byR == null) {
            synchronized (a.class) {
                if (byR == null) {
                    byR = new a();
                }
            }
        }
        return byR;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.byU != -1 && this.byU != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.byY = aVar;
        iX(str);
        this.byZ = bVar;
        this.byT = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.byC, 2);
        if (this.byT <= 0) {
            Vn();
            c.e("recorder", "wrong buffer size");
            Vk();
            return;
        }
        if (aVar.byC == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.byD, aVar.sampleRate, i, 2, this.byT);
        this.byU = 0;
        this.mContext = context;
        this.mAppId = str2;
        Vp();
    }

    private void iX(String str) {
        String str2;
        if (TextUtils.equals(this.byY.byB, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.byY.byB, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.byS = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void cL(boolean z) {
        if (this.mContext == null) {
            Vn();
            c.e("recorder", "start error, context is null");
            Vk();
        } else if (this.mIsBackground) {
            u(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            Vk();
        } else if (this.byU == -1 || TextUtils.isEmpty(this.byS)) {
            Vn();
            c.e("recorder", "start error, wrong state");
            Vk();
        } else {
            if (z) {
                String str = null;
                if (this.byU == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.byU != 0 && this.byU != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    u(2003, str);
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
                    Vn();
                    c.e("recorder", "start error, no real permission");
                    Vk();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void Hv() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.Vk();
                        }
                    });
                    aL(com.baidu.swan.apps.media.b.b.byF, "recorderStart");
                } else {
                    aL(com.baidu.swan.apps.media.b.b.byH, "recorderResume");
                }
                d.bS("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: iZ */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.Vj());
                    }
                }).c(rx.a.b.a.dGl()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.Vn();
                            c.e("recorder", "record error");
                            a.this.Vk();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                Vn();
                c.e("recorder", "can't start", e);
                Vk();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            Vn();
            c.e("recorder", "none audio record");
            Vk();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.byU = 2;
            Ub();
            aL(com.baidu.swan.apps.media.b.b.byG, "recorderPause");
        } catch (IllegalStateException e) {
            Vn();
            c.e("recorder", "pause error", e);
            Vk();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        cL(false);
        Ua();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            Vn();
            c.e("recorder", "none audioRecord");
            Vk();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.byU = 3;
            Vo();
            Vq();
        } catch (IllegalStateException e) {
            Vn();
            c.e("recorder", "stop error", e);
            Vk();
        }
    }

    public void Vh() {
        if (this.byU == 0 || this.byU == 1) {
            if (!this.bzb) {
                this.bzb = true;
                aL(com.baidu.swan.apps.media.b.b.byK, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void Vi() {
        if (this.bzb) {
            this.bzb = false;
            aL(com.baidu.swan.apps.media.b.b.byL, "recorderInterruptionEnd");
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
    public boolean Vj() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.byT];
        String str = this.byY.byB;
        int i = this.byY.byC;
        ?? r4 = this.byY.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.byY.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.byS);
                if (this.byU == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.byU = 1;
                    while (this.byU == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.byT) >= 0) {
                            byte[] t = TextUtils.equals(this.byY.byB, "pcm") ? bArr : aVar.t(bArr);
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
                    if (this.byU == 1) {
                        this.byU = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.byU == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.byY.byA);
        }
        c.i("recorder", "start timer, totalTime:" + this.byY.byA);
        this.byV = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Hv();
                }
                a.this.stopTimer();
            }
        }, this.byY.byA);
        this.byW = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.byV = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void Ub() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.byX);
        }
        c.i("recorder", "pause timer, lastTime:" + this.byX);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.byX = this.byY.byA - (System.currentTimeMillis() - this.byW);
    }

    public void Ua() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.byV != null) {
            if (this.byX <= 0) {
                this.byV.Hv();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.byV != null) {
                        a.this.byV.Hv();
                    }
                    a.this.stopTimer();
                }
            }, this.byX);
            this.byW = System.currentTimeMillis();
        }
    }

    public void bO(boolean z) {
        if (z && this.byU == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cM(boolean z) {
        if (byR != null) {
            byR.bO(z);
        }
    }

    public static void release() {
        if (byR != null) {
            byR.Vk();
            byR.Vq();
            byR.Vi();
        }
    }

    public static void releaseAll() {
        release();
        byR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vk() {
        stopTimer();
        this.mContext = null;
        this.byU = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a Vl() {
        return this.byY;
    }

    public com.baidu.swan.apps.media.b.b Vm() {
        return this.byZ;
    }

    public boolean iY(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.byU != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.byU != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.byU != 2 && this.byU != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            u(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vn() {
        u(2002, "error execute");
    }

    private void u(int i, String str) {
        if (this.byZ == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.byJ)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                Vk();
                return;
            }
        }
        this.byZ.u(i, str);
    }

    private void aL(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.byZ != null && !TextUtils.isEmpty(str)) {
            this.byZ.iK(str);
            return;
        }
        com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void Vo() {
        long j;
        long j2 = -1;
        String bh = com.baidu.swan.apps.storage.b.bh(this.byS, this.mAppId);
        if (TextUtils.isEmpty(this.byS)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.qR(this.byS);
            j2 = new File(this.byS).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bh)) {
                jSONObject.put("tempFilePath", bh);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.byZ != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.byI)) {
                this.byZ.d(com.baidu.swan.apps.media.b.b.byI, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            Vn();
            c.e("recorder", "json error", e);
            Vk();
        }
    }

    private void Vp() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.bza = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bza, 32);
        }
    }

    private void Vq() {
        if (this.mTelephonyManager != null && this.bza != null) {
            this.mTelephonyManager.listen(this.bza, 0);
            this.mTelephonyManager = null;
            this.bza = null;
        }
    }
}
