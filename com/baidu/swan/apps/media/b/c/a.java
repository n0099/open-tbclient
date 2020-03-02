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
    private static volatile a bDL;
    private String bDM;
    private int bDN;
    private com.baidu.swan.apps.media.b.b.b bDP;
    private long bDQ;
    private long bDR;
    private com.baidu.swan.apps.media.b.b bDT;
    private com.baidu.swan.apps.media.b.b.a bDU;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int bDO = -1;
    private com.baidu.swan.apps.media.b.a bDS = new com.baidu.swan.apps.media.b.a();
    private boolean bDV = false;

    private a() {
    }

    public static a XT() {
        if (bDL == null) {
            synchronized (a.class) {
                if (bDL == null) {
                    bDL = new a();
                }
            }
        }
        return bDL;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.bDO != -1 && this.bDO != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.bDS = aVar;
        jp(str);
        this.bDT = bVar;
        this.bDN = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.bDN <= 0) {
            Ya();
            c.e("recorder", "wrong buffer size");
            XX();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.bDx, aVar.sampleRate, i, 2, this.bDN);
        this.bDO = 0;
        this.mContext = context;
        this.mAppId = str2;
        Yc();
    }

    private void jp(String str) {
        String str2;
        if (TextUtils.equals(this.bDS.bDw, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.bDS.bDw, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.bDM = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void cX(boolean z) {
        if (this.mContext == null) {
            Ya();
            c.e("recorder", "start error, context is null");
            XX();
        } else if (this.mIsBackground) {
            z(2001, "error execute time");
            c.e("recorder", "start error, wrong execute time");
            XX();
        } else if (this.bDO == -1 || TextUtils.isEmpty(this.bDM)) {
            Ya();
            c.e("recorder", "start error, wrong state");
            XX();
        } else {
            if (z) {
                String str = null;
                if (this.bDO == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.bDO != 0 && this.bDO != 3) {
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
                    Ya();
                    c.e("recorder", "start error, no real permission");
                    XX();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.b.b.b() { // from class: com.baidu.swan.apps.media.b.c.a.1
                        @Override // com.baidu.swan.apps.media.b.b.b
                        public void Ki() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.XX();
                        }
                    });
                    aV(com.baidu.swan.apps.media.b.b.bDz, "recorderStart");
                } else {
                    aV(com.baidu.swan.apps.media.b.b.bDB, "recorderResume");
                }
                d.cb("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: jr */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.XW());
                    }
                }).c(rx.a.b.a.dOd()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.Ya();
                            c.e("recorder", "record error");
                            a.this.XX();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                Ya();
                c.e("recorder", "can't start", e);
                XX();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            Ya();
            c.e("recorder", "none audio record");
            XX();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.bDO = 2;
            WO();
            aV(com.baidu.swan.apps.media.b.b.bDA, "recorderPause");
        } catch (IllegalStateException e) {
            Ya();
            c.e("recorder", "pause error", e);
            XX();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        cX(false);
        WN();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            Ya();
            c.e("recorder", "none audioRecord");
            XX();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.bDO = 3;
            Yb();
            Yd();
        } catch (IllegalStateException e) {
            Ya();
            c.e("recorder", "stop error", e);
            XX();
        }
    }

    public void XU() {
        if (this.bDO == 0 || this.bDO == 1) {
            if (!this.bDV) {
                this.bDV = true;
                aV(com.baidu.swan.apps.media.b.b.bDE, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void XV() {
        if (this.bDV) {
            this.bDV = false;
            aV(com.baidu.swan.apps.media.b.b.bDF, "recorderInterruptionEnd");
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
    public boolean XW() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.bDN];
        String str = this.bDS.bDw;
        int i = this.bDS.channel;
        ?? r4 = this.bDS.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.bDS.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.bDM);
                if (this.bDO == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.bDO = 1;
                    while (this.bDO == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.bDN) >= 0) {
                            byte[] y = TextUtils.equals(this.bDS.bDw, "pcm") ? bArr : aVar.y(bArr);
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
                    if (this.bDO == 1) {
                        this.bDO = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.bDO == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.bDS.bDv);
        }
        c.i("recorder", "start timer, totalTime:" + this.bDS.bDv);
        this.bDP = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Ki();
                }
                a.this.stopTimer();
            }
        }, this.bDS.bDv);
        this.bDQ = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.bDP = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void WO() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.bDR);
        }
        c.i("recorder", "pause timer, lastTime:" + this.bDR);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.bDR = this.bDS.bDv - (System.currentTimeMillis() - this.bDQ);
    }

    public void WN() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.bDP != null) {
            if (this.bDR <= 0) {
                this.bDP.Ki();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.bDP != null) {
                        a.this.bDP.Ki();
                    }
                    a.this.stopTimer();
                }
            }, this.bDR);
            this.bDQ = System.currentTimeMillis();
        }
    }

    public void cb(boolean z) {
        if (z && this.bDO == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cY(boolean z) {
        if (bDL != null) {
            bDL.cb(z);
        }
    }

    public static void release() {
        if (bDL != null) {
            bDL.XX();
            bDL.Yd();
            bDL.XV();
        }
    }

    public static void releaseAll() {
        release();
        bDL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        stopTimer();
        this.mContext = null;
        this.bDO = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a XY() {
        return this.bDS;
    }

    public com.baidu.swan.apps.media.b.b XZ() {
        return this.bDT;
    }

    public boolean jq(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.bDO != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.bDO != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.bDO != 2 && this.bDO != 1) {
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
    public void Ya() {
        z(2002, "error execute");
    }

    private void z(int i, String str) {
        if (this.bDT == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDD)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                XX();
                return;
            }
        }
        this.bDT.z(i, str);
    }

    private void aV(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.bDT != null && !TextUtils.isEmpty(str)) {
            this.bDT.jc(str);
            return;
        }
        com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void Yb() {
        long j;
        long j2 = -1;
        String br = com.baidu.swan.apps.storage.b.br(this.bDM, this.mAppId);
        if (TextUtils.isEmpty(this.bDM)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.rj(this.bDM);
            j2 = new File(this.bDM).length();
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
            if (this.bDT != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDC)) {
                this.bDT.d(com.baidu.swan.apps.media.b.b.bDC, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            Ya();
            c.e("recorder", "json error", e);
            XX();
        }
    }

    private void Yc() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.bDU = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bDU, 32);
        }
    }

    private void Yd() {
        if (this.mTelephonyManager != null && this.bDU != null) {
            this.mTelephonyManager.listen(this.bDU, 0);
            this.mTelephonyManager = null;
            this.bDU = null;
        }
    }
}
