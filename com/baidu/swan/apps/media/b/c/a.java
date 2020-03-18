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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bDX;
    private String bDY;
    private int bDZ;
    private com.baidu.swan.apps.media.b.b.b bEb;
    private long bEc;
    private long bEd;
    private com.baidu.swan.apps.media.b.b bEf;
    private com.baidu.swan.apps.media.b.b.a bEg;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int bEa = -1;
    private com.baidu.swan.apps.media.b.a bEe = new com.baidu.swan.apps.media.b.a();
    private boolean bEh = false;

    private a() {
    }

    public static a XW() {
        if (bDX == null) {
            synchronized (a.class) {
                if (bDX == null) {
                    bDX = new a();
                }
            }
        }
        return bDX;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.bEa != -1 && this.bEa != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.bEe = aVar;
        jo(str);
        this.bEf = bVar;
        this.bDZ = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.bDZ <= 0) {
            Yd();
            c.e("recorder", "wrong buffer size");
            Ya();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.bDJ, aVar.sampleRate, i, 2, this.bDZ);
        this.bEa = 0;
        this.mContext = context;
        this.mAppId = str2;
        Yf();
    }

    private void jo(String str) {
        String str2;
        if (TextUtils.equals(this.bEe.bDI, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.bEe.bDI, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.bDY = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void cY(boolean z) {
        if (this.mContext == null) {
            Yd();
            c.e("recorder", "start error, context is null");
            Ya();
        } else if (this.mIsBackground) {
            z(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            Ya();
        } else if (this.bEa == -1 || TextUtils.isEmpty(this.bDY)) {
            Yd();
            c.e("recorder", "start error, wrong state");
            Ya();
        } else {
            if (z) {
                String str = null;
                if (this.bEa == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.bEa != 0 && this.bEa != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    z(2003, str);
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
                    Yd();
                    c.e("recorder", "start error, no real permission");
                    Ya();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void Kl() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.Ya();
                        }
                    });
                    aU(com.baidu.swan.apps.media.b.b.bDL, "recorderStart");
                } else {
                    aU(com.baidu.swan.apps.media.b.b.bDN, "recorderResume");
                }
                d.cb("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: jq */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.XZ());
                    }
                }).c(rx.a.b.a.dOE()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.Yd();
                            c.e("recorder", "record error");
                            a.this.Ya();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                Yd();
                c.e("recorder", "can't start", e);
                Ya();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            Yd();
            c.e("recorder", "none audio record");
            Ya();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.bEa = 2;
            WR();
            aU(com.baidu.swan.apps.media.b.b.bDM, "recorderPause");
        } catch (IllegalStateException e) {
            Yd();
            c.e("recorder", "pause error", e);
            Ya();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        cY(false);
        WQ();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            Yd();
            c.e("recorder", "none audioRecord");
            Ya();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.bEa = 3;
            Ye();
            Yg();
        } catch (IllegalStateException e) {
            Yd();
            c.e("recorder", "stop error", e);
            Ya();
        }
    }

    public void XX() {
        if (this.bEa == 0 || this.bEa == 1) {
            if (!this.bEh) {
                this.bEh = true;
                aU(com.baidu.swan.apps.media.b.b.bDQ, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void XY() {
        if (this.bEh) {
            this.bEh = false;
            aU(com.baidu.swan.apps.media.b.b.bDR, "recorderInterruptionEnd");
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
    public boolean XZ() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.bDZ];
        String str = this.bEe.bDI;
        int i = this.bEe.channel;
        ?? r4 = this.bEe.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.bEe.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.bDY);
                if (this.bEa == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.bEa = 1;
                    while (this.bEa == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.bDZ) >= 0) {
                            byte[] y = TextUtils.equals(this.bEe.bDI, "pcm") ? bArr : aVar.y(bArr);
                            if (y != null && y.length > 0) {
                                fileOutputStream.write(y);
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
                    if (this.bEa == 1) {
                        this.bEa = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.bEa == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.bEe.bDH);
        }
        c.i("recorder", "start timer, totalTime:" + this.bEe.bDH);
        this.bEb = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Kl();
                }
                a.this.stopTimer();
            }
        }, this.bEe.bDH);
        this.bEc = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.bEb = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void WR() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.bEd);
        }
        c.i("recorder", "pause timer, lastTime:" + this.bEd);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.bEd = this.bEe.bDH - (System.currentTimeMillis() - this.bEc);
    }

    public void WQ() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.bEb != null) {
            if (this.bEd <= 0) {
                this.bEb.Kl();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.bEb != null) {
                        a.this.bEb.Kl();
                    }
                    a.this.stopTimer();
                }
            }, this.bEd);
            this.bEc = System.currentTimeMillis();
        }
    }

    public void cc(boolean z) {
        if (z && this.bEa == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cZ(boolean z) {
        if (bDX != null) {
            bDX.cc(z);
        }
    }

    public static void release() {
        if (bDX != null) {
            bDX.Ya();
            bDX.Yg();
            bDX.XY();
        }
    }

    public static void releaseAll() {
        release();
        bDX = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ya() {
        stopTimer();
        this.mContext = null;
        this.bEa = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a Yb() {
        return this.bEe;
    }

    public com.baidu.swan.apps.media.b.b Yc() {
        return this.bEf;
    }

    public boolean jp(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.bEa != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.bEa != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.bEa != 2 && this.bEa != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            z(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yd() {
        z(2002, "error execute");
    }

    private void z(int i, String str) {
        if (this.bEf == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDP)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                Ya();
                return;
            }
        }
        this.bEf.z(i, str);
    }

    private void aU(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.bEf != null && !TextUtils.isEmpty(str)) {
            this.bEf.jb(str);
            return;
        }
        com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void Ye() {
        long j;
        long j2 = -1;
        String bq = com.baidu.swan.apps.storage.b.bq(this.bDY, this.mAppId);
        if (TextUtils.isEmpty(this.bDY)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.ri(this.bDY);
            j2 = new File(this.bDY).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bq)) {
                jSONObject.put("tempFilePath", bq);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.bEf != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDO)) {
                this.bEf.d(com.baidu.swan.apps.media.b.b.bDO, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            Yd();
            c.e("recorder", "json error", e);
            Ya();
        }
    }

    private void Yf() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.bEg = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bEg, 32);
        }
    }

    private void Yg() {
        if (this.mTelephonyManager != null && this.bEg != null) {
            this.mTelephonyManager.listen(this.bEg, 0);
            this.mTelephonyManager = null;
            this.bEg = null;
        }
    }
}
