package com.baidu.swan.apps.media.a.c;

import android.content.Context;
import android.media.AudioRecord;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import java.io.File;
import java.io.FileOutputStream;
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
    private static volatile a csb;
    private String csc;
    private int csd;
    private com.baidu.swan.apps.media.a.b.b csf;
    private long csg;
    private long csh;
    private com.baidu.swan.apps.media.a.b csj;
    private com.baidu.swan.apps.media.a.b.a csk;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private TelephonyManager mTelephonyManager;
    private Timer mTimer;
    private int cse = -1;
    private com.baidu.swan.apps.media.a.a csi = new com.baidu.swan.apps.media.a.a();
    private boolean csl = false;

    private a() {
    }

    public static a akv() {
        if (csb == null) {
            synchronized (a.class) {
                if (csb == null) {
                    csb = new a();
                }
            }
        }
        return csb;
    }

    public void a(String str, com.baidu.swan.apps.media.a.a aVar, Context context, com.baidu.swan.apps.media.a.b bVar, String str2) {
        int i;
        if (this.cse != -1 && this.cse != 3) {
            c.e("recorder", "wrong state, can't init");
            return;
        }
        this.csi = aVar;
        lW(str);
        this.csj = bVar;
        this.csd = AudioRecord.getMinBufferSize(aVar.sampleRate, aVar.channel, 2);
        if (this.csd <= 0) {
            akC();
            c.e("recorder", "wrong buffer size");
            akz();
            return;
        }
        if (aVar.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(aVar.crN, aVar.sampleRate, i, 2, this.csd);
        this.cse = 0;
        this.mContext = context;
        this.mAppId = str2;
        akE();
    }

    private void lW(String str) {
        String str2;
        if (TextUtils.equals(this.csi.crM, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.csi.crM, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.csc = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void eq(boolean z) {
        if (this.mContext == null) {
            akC();
            c.e("recorder", "start error, context is null");
            akz();
        } else if (this.cse == -1 || TextUtils.isEmpty(this.csc)) {
            akC();
            c.e("recorder", "start error, wrong state");
            akz();
        } else {
            if (z) {
                String str = null;
                if (this.cse == 1) {
                    str = "start fail: recorder is recording";
                } else if (this.cse != 0 && this.cse != 3) {
                    str = "start fail: recorder is paused";
                }
                if (str != null) {
                    T(2003, str);
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
                    akC();
                    c.e("recorder", "start error, no real permission");
                    akz();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.a.b.b() { // from class: com.baidu.swan.apps.media.a.c.a.1
                        @Override // com.baidu.swan.apps.media.a.b.b
                        public void VQ() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            c.i("recorder", "time out");
                            a.this.stopRecord();
                            a.this.akz();
                        }
                    });
                    bx(com.baidu.swan.apps.media.a.b.crP, "recorderStart");
                } else {
                    bx(com.baidu.swan.apps.media.a.b.crR, "recorderResume");
                }
                d.bS("").d(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: lZ */
                    public Boolean call(String str2) {
                        return Boolean.valueOf(a.this.aky());
                    }
                }).c(rx.a.b.a.dUp()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.a.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: e */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            a.this.akC();
                            c.e("recorder", "record error");
                            a.this.akz();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                akC();
                c.e("recorder", "can't start", e);
                akz();
            }
        }
    }

    public void pauseRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            akC();
            c.e("recorder", "none audio record");
            akz();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.cse = 2;
            aiX();
            bx(com.baidu.swan.apps.media.a.b.crQ, "recorderPause");
        } catch (IllegalStateException e) {
            akC();
            c.e("recorder", "pause error", e);
            akz();
        }
    }

    public void resumeRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        eq(false);
        aiW();
    }

    public void stopRecord() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            akC();
            c.e("recorder", "none audioRecord");
            akz();
            return;
        }
        try {
            this.mAudioRecord.stop();
            VO();
            this.cse = 3;
            akD();
            akF();
        } catch (IllegalStateException e) {
            akC();
            c.e("recorder", "stop error", e);
            akz();
        }
    }

    public void akw() {
        if (this.cse == 0 || this.cse == 1) {
            if (!this.csl) {
                this.csl = true;
                bx(com.baidu.swan.apps.media.a.b.crU, "recorderInterruptionBegin");
            }
            pauseRecord();
        }
    }

    public void akx() {
        if (this.csl) {
            this.csl = false;
            bx(com.baidu.swan.apps.media.a.b.crV, "recorderInterruptionEnd");
        }
    }

    public boolean aky() {
        byte[] bArr = new byte[this.csd];
        com.baidu.swan.apps.media.a.d.a aVar = new com.baidu.swan.apps.media.a.d.a(this.csi.crM, this.csi.channel, this.csi.sampleRate, this.csi.bitRate);
        if (this.mAudioRecord == null) {
            return false;
        }
        return a(bArr, aVar);
    }

    private boolean a(byte[] bArr, com.baidu.swan.apps.media.a.d.a aVar) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.csc);
                if (this.cse == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.e.d.createNewFileSafely(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            this.cse = 1;
            while (this.cse == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.csd) >= 0) {
                    byte[] J = TextUtils.equals(this.csi.crM, "pcm") ? bArr : aVar.J(bArr);
                    if (J != null && J.length > 0) {
                        fileOutputStream.write(J);
                    }
                }
            }
            com.baidu.swan.e.d.closeSafely(fileOutputStream);
            return true;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            c.e("recorder", "save record error", e);
            if (this.cse == 1) {
                this.cse = 3;
            }
            com.baidu.swan.e.d.closeSafely(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.baidu.swan.e.d.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public void a(final com.baidu.swan.apps.media.a.b.b bVar) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "start timer:" + this.csi.crL);
        }
        c.i("recorder", "start timer, totalTime:" + this.csi.crL);
        this.csf = bVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    bVar.VQ();
                }
                a.this.VO();
            }
        }, this.csi.crL);
        this.csg = System.currentTimeMillis();
    }

    public void VO() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        c.i("recorder", "stop timer");
        this.csf = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void aiX() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.csh);
        }
        c.i("recorder", "pause timer, lastTime:" + this.csh);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.csh = this.csi.crL - (System.currentTimeMillis() - this.csg);
    }

    public void aiW() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        c.i("recorder", "resume timer");
        if (this.csf != null) {
            if (this.csh <= 0) {
                this.csf.VQ();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.a.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.csf != null) {
                        a.this.csf.VQ();
                    }
                    a.this.VO();
                }
            }, this.csh);
            this.csg = System.currentTimeMillis();
        }
    }

    public void dq(boolean z) {
        if (z && this.cse == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    public static void er(boolean z) {
        if (csb != null) {
            csb.dq(z);
        }
    }

    public static void release() {
        if (csb != null) {
            csb.akz();
            csb.akF();
            csb.akx();
        }
    }

    public static void releaseAll() {
        release();
        csb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akz() {
        VO();
        this.mContext = null;
        this.cse = -1;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
    }

    public com.baidu.swan.apps.media.a.a akA() {
        return this.csi;
    }

    public com.baidu.swan.apps.media.a.b akB() {
        return this.csj;
    }

    public boolean lX(String str) {
        String str2 = null;
        if (TextUtils.equals(str, "/swanAPI/recorder/pause")) {
            if (this.cse != 1) {
                str2 = "pause fail: recorder is not recording";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/resume")) {
            if (this.cse != 2) {
                str2 = "resume fail: recorder is not paused";
            }
        } else if (TextUtils.equals(str, "/swanAPI/recorder/stop") && this.cse != 2 && this.cse != 1) {
            str2 = "stop fail: recorder is not started";
        }
        if (str2 != null) {
            T(2003, str2);
            c.e("recorder", str2);
            return false;
        }
        return true;
    }

    public boolean lY(String str) {
        if (this.mIsBackground) {
            return TextUtils.equals(str, "/swanAPI/recorder/start") || TextUtils.equals(str, "/swanAPI/recorder/resume");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akC() {
        T(2002, "error execute");
    }

    private void T(int i, String str) {
        if (this.csj == null || TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.crT)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.b("recorderError", hashMap));
                return;
            } catch (JSONException e) {
                c.e("recorder", "json error", e);
                akz();
                return;
            }
        }
        this.csj.T(i, str);
    }

    private void bx(String str, String str2) {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "dispatchCallback: " + str + " " + str2);
        }
        if (this.csj != null && !TextUtils.isEmpty(str)) {
            this.csj.lJ(str);
            return;
        }
        com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.b(str2));
    }

    private void akD() {
        long j;
        long j2 = -1;
        String bY = com.baidu.swan.apps.storage.b.bY(this.csc, this.mAppId);
        if (TextUtils.isEmpty(this.csc)) {
            j = -1;
        } else {
            j = com.baidu.swan.e.d.ui(this.csc);
            j2 = new File(this.csc).length();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bY)) {
                jSONObject.put("tempFilePath", bY);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            if (j2 >= 0) {
                jSONObject.put("fileSize", j2);
            }
            if (this.csj != null && !TextUtils.isEmpty(com.baidu.swan.apps.media.a.b.crS)) {
                this.csj.e(com.baidu.swan.apps.media.a.b.crS, jSONObject);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.b("recorderStop", hashMap));
        } catch (JSONException e) {
            akC();
            c.e("recorder", "json error", e);
            akz();
        }
    }

    private void akE() {
        if (this.mContext != null) {
            this.mTelephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            this.csk = new com.baidu.swan.apps.media.a.b.a();
            this.mTelephonyManager.listen(this.csk, 32);
        }
    }

    private void akF() {
        if (this.mTelephonyManager != null && this.csk != null) {
            this.mTelephonyManager.listen(this.csk, 0);
            this.mTelephonyManager = null;
            this.csk = null;
        }
    }
}
