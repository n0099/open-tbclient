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
    private static volatile a bDK;
    private String bDL;
    private int bDM;
    private com.baidu.swan.apps.media.b.b.b bDO;
    private long bDP;
    private long bDQ;
    private com.baidu.swan.apps.media.b.b bDS;
    private com.baidu.swan.apps.media.b.b.a bDT;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int bDN = -1;
    private com.baidu.swan.apps.media.b.a bDR = new com.baidu.swan.apps.media.b.a();
    private boolean bDU = false;

    private a() {
    }

    public static a XR() {
        if (bDK == null) {
            synchronized (a.class) {
                if (bDK == null) {
                    bDK = new a();
                }
            }
        }
        return bDK;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.bDN != -1 && this.bDN != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.bDR = aVar;
        jp(str);
        this.bDS = bVar;
        this.bDM = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.bDM <= 0) {
            XY();
            c.e("recorder", "wrong buffer size");
            XV();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.bDw, aVar.sampleRate, i, 2, this.bDM);
        this.bDN = 0;
        this.mContext = context;
        this.mAppId = str2;
        Ya();
    }

    private void jp(String str) {
        String str2;
        if (TextUtils.equals(this.bDR.bDv, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.bDR.bDv, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.bDL = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void cX(boolean z) {
        if (this.mContext == null) {
            XY();
            c.e("recorder", "start error, context is null");
            XV();
        } else if (this.mIsBackground) {
            z(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            XV();
        } else if (this.bDN == -1 || TextUtils.isEmpty(this.bDL)) {
            XY();
            c.e("recorder", "start error, wrong state");
            XV();
        } else {
            if (z) {
                String str = null;
                if (this.bDN == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.bDN != 0 && this.bDN != 3) {
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
                    XY();
                    c.e("recorder", "start error, no real permission");
                    XV();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void Kg() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.XV();
                        }
                    });
                    aV(com.baidu.swan.apps.media.b.b.bDy, "recorderStart");
                } else {
                    aV(com.baidu.swan.apps.media.b.b.bDA, "recorderResume");
                }
                d.cb("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: jr */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.XU());
                    }
                }).c(rx.a.b.a.dOb()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.XY();
                            c.e("recorder", "record error");
                            a.this.XV();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                XY();
                c.e("recorder", "can't start", e);
                XV();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            XY();
            c.e("recorder", "none audio record");
            XV();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.bDN = 2;
            WM();
            aV(com.baidu.swan.apps.media.b.b.bDz, "recorderPause");
        } catch (IllegalStateException e) {
            XY();
            c.e("recorder", "pause error", e);
            XV();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        cX(false);
        WL();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            XY();
            c.e("recorder", "none audioRecord");
            XV();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.bDN = 3;
            XZ();
            Yb();
        } catch (IllegalStateException e) {
            XY();
            c.e("recorder", "stop error", e);
            XV();
        }
    }

    public void XS() {
        if (this.bDN == 0 || this.bDN == 1) {
            if (!this.bDU) {
                this.bDU = true;
                aV(com.baidu.swan.apps.media.b.b.bDD, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void XT() {
        if (this.bDU) {
            this.bDU = false;
            aV(com.baidu.swan.apps.media.b.b.bDE, "recorderInterruptionEnd");
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
    public boolean XU() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.bDM];
        String str = this.bDR.bDv;
        int i = this.bDR.channel;
        ?? r4 = this.bDR.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.bDR.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.bDL);
                if (this.bDN == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.bDN = 1;
                    while (this.bDN == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.bDM) >= 0) {
                            byte[] y = TextUtils.equals(this.bDR.bDv, "pcm") ? bArr : aVar.y(bArr);
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
                    if (this.bDN == 1) {
                        this.bDN = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.bDN == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.bDR.bDu);
        }
        c.i("recorder", "start timer, totalTime:" + this.bDR.bDu);
        this.bDO = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Kg();
                }
                a.this.stopTimer();
            }
        }, this.bDR.bDu);
        this.bDP = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.bDO = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void WM() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.bDQ);
        }
        c.i("recorder", "pause timer, lastTime:" + this.bDQ);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.bDQ = this.bDR.bDu - (System.currentTimeMillis() - this.bDP);
    }

    public void WL() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.bDO != null) {
            if (this.bDQ <= 0) {
                this.bDO.Kg();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.bDO != null) {
                        a.this.bDO.Kg();
                    }
                    a.this.stopTimer();
                }
            }, this.bDQ);
            this.bDP = System.currentTimeMillis();
        }
    }

    public void cb(boolean z) {
        if (z && this.bDN == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cY(boolean z) {
        if (bDK != null) {
            bDK.cb(z);
        }
    }

    public static void release() {
        if (bDK != null) {
            bDK.XV();
            bDK.Yb();
            bDK.XT();
        }
    }

    public static void releaseAll() {
        release();
        bDK = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XV() {
        stopTimer();
        this.mContext = null;
        this.bDN = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a XW() {
        return this.bDR;
    }

    public com.baidu.swan.apps.media.b.b XX() {
        return this.bDS;
    }

    public boolean jq(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.bDN != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.bDN != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.bDN != 2 && this.bDN != 1) {
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
    public void XY() {
        z(2002, "error execute");
    }

    private void z(int i, String str) {
        if (this.bDS == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDC)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                XV();
                return;
            }
        }
        this.bDS.z(i, str);
    }

    private void aV(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.bDS != null && !TextUtils.isEmpty(str)) {
            this.bDS.jc(str);
            return;
        }
        com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void XZ() {
        long j;
        long j2 = -1;
        String br = com.baidu.swan.apps.storage.b.br(this.bDL, this.mAppId);
        if (TextUtils.isEmpty(this.bDL)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.rj(this.bDL);
            j2 = new File(this.bDL).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(br)) {
                jSONObject.put("tempFilePath", br);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.bDS != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDB)) {
                this.bDS.d(com.baidu.swan.apps.media.b.b.bDB, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            XY();
            c.e("recorder", "json error", e);
            XV();
        }
    }

    private void Ya() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.bDT = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bDT, 32);
        }
    }

    private void Yb() {
        if (this.mTelephonyManager != null && this.bDT != null) {
            this.mTelephonyManager.listen(this.bDT, 0);
            this.mTelephonyManager = null;
            this.bDT = null;
        }
    }
}
