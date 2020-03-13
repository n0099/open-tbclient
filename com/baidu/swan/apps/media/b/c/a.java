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
    private static volatile a bDM;
    private String bDN;
    private int bDO;
    private com.baidu.swan.apps.media.b.b.b bDQ;
    private long bDR;
    private long bDS;
    private com.baidu.swan.apps.media.b.b bDU;
    private com.baidu.swan.apps.media.b.b.a bDV;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int bDP = -1;
    private com.baidu.swan.apps.media.b.a bDT = new com.baidu.swan.apps.media.b.a();
    private boolean bDW = false;

    private a() {
    }

    public static a XT() {
        if (bDM == null) {
            synchronized (a.class) {
                if (bDM == null) {
                    bDM = new a();
                }
            }
        }
        return bDM;
    }

    public void a(String str, com.baidu.swan.apps.media.b.a aVar, Context context, com.baidu.swan.apps.media.b.b bVar, String str2) {
        int i;
        if (this.bDP != -1 && this.bDP != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.bDT = aVar;
        jp(str);
        this.bDU = bVar;
        this.bDO = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.bDO <= 0) {
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
        this.mAudioRecord = new AudioRecord(aVar.bDy, aVar.sampleRate, i, 2, this.bDO);
        this.bDP = 0;
        this.mContext = context;
        this.mAppId = str2;
        Yc();
    }

    private void jp(String str) {
        String str2;
        if (TextUtils.equals(this.bDT.bDx, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.bDT.bDx, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.bDN = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
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
        } else if (this.bDP == -1 || TextUtils.isEmpty(this.bDN)) {
            Ya();
            c.e("recorder", "start error, wrong state");
            XX();
        } else {
            if (z) {
                String str = null;
                if (this.bDP == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.bDP != 0 && this.bDP != 3) {
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
                    aV(com.baidu.swan.apps.media.b.b.bDA, "recorderStart");
                } else {
                    aV(com.baidu.swan.apps.media.b.b.bDC, "recorderResume");
                }
                d.cb("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: jr */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.XW());
                    }
                }).c(rx.a.b.a.dOe()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.b.c.a.2
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
            this.bDP = 2;
            WO();
            aV(com.baidu.swan.apps.media.b.b.bDB, "recorderPause");
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
            this.bDP = 3;
            Yb();
            Yd();
        } catch (IllegalStateException e) {
            Ya();
            c.e("recorder", "stop error", e);
            XX();
        }
    }

    public void XU() {
        if (this.bDP == 0 || this.bDP == 1) {
            if (!this.bDW) {
                this.bDW = true;
                aV(com.baidu.swan.apps.media.b.b.bDF, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void XV() {
        if (this.bDW) {
            this.bDW = false;
            aV(com.baidu.swan.apps.media.b.b.bDG, "recorderInterruptionEnd");
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
        byte[] bArr = new byte[this.bDO];
        String str = this.bDT.bDx;
        int i = this.bDT.channel;
        ?? r4 = this.bDT.sampleRate;
        com.baidu.swan.apps.media.b.d.a aVar = new com.baidu.swan.apps.media.b.d.a(str, i, r4, this.bDT.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.bDN);
                if (this.bDP == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.d.c.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.bDP = 1;
                    while (this.bDP == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.bDO) >= 0) {
                            byte[] y = TextUtils.equals(this.bDT.bDx, "pcm") ? bArr : aVar.y(bArr);
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
                    if (this.bDP == 1) {
                        this.bDP = 3;
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                } catch (IllegalStateException e2) {
                    e = e2;
                    c.e("recorder", "save record error", e);
                    if (this.bDP == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.bDT.bDw);
        }
        c.i("recorder", "start timer, totalTime:" + this.bDT.bDw);
        this.bDQ = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.Ki();
                }
                a.this.stopTimer();
            }
        }, this.bDT.bDw);
        this.bDR = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.bDQ = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void WO() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.bDS);
        }
        c.i("recorder", "pause timer, lastTime:" + this.bDS);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.bDS = this.bDT.bDw - (System.currentTimeMillis() - this.bDR);
    }

    public void WN() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.bDQ != null) {
            if (this.bDS <= 0) {
                this.bDQ.Ki();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.b.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.bDQ != null) {
                        a.this.bDQ.Ki();
                    }
                    a.this.stopTimer();
                }
            }, this.bDS);
            this.bDR = System.currentTimeMillis();
        }
    }

    public void cb(boolean z) {
        if (z && this.bDP == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void cY(boolean z) {
        if (bDM != null) {
            bDM.cb(z);
        }
    }

    public static void release() {
        if (bDM != null) {
            bDM.XX();
            bDM.Yd();
            bDM.XV();
        }
    }

    public static void releaseAll() {
        release();
        bDM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XX() {
        stopTimer();
        this.mContext = null;
        this.bDP = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.b.a XY() {
        return this.bDT;
    }

    public com.baidu.swan.apps.media.b.b XZ() {
        return this.bDU;
    }

    public boolean jq(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.bDP != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.bDP != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.bDP != 2 && this.bDP != 1) {
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
        if (this.bDU == null || TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDE)) {
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
        this.bDU.z(i, str);
    }

    private void aV(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + HanziToPinyin.Token.SEPARATOR + str2);
        }
        if (this.bDU != null && !TextUtils.isEmpty(str)) {
            this.bDU.jc(str);
            return;
        }
        com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.b(str2));
    }

    private void Yb() {
        long j;
        long j2 = -1;
        String br = com.baidu.swan.apps.storage.b.br(this.bDN, this.mAppId);
        if (TextUtils.isEmpty(this.bDN)) {
            j = -1;
        } else {
            j = com.baidu.swan.d.c.rj(this.bDN);
            j2 = new File(this.bDN).length();
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
            if (this.bDU != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.b.b.bDD)) {
                this.bDU.d(com.baidu.swan.apps.media.b.b.bDD, jSONObject);
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
            this.bDV = new com.baidu.swan.apps.media.b.b.a();
            this.mTelephonyManager.listen(this.bDV, 32);
        }
    }

    private void Yd() {
        if (this.mTelephonyManager != null && this.bDV != null) {
            this.mTelephonyManager.listen(this.bDV, 0);
            this.mTelephonyManager = null;
            this.bDV = null;
        }
    }
}
