package com.baidu.swan.apps.media.c.c;

import android.content.Context;
import android.media.AudioRecord;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.media.c.b;
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
    private static final boolean DEBUG = c.DEBUG;
    private static volatile a aBa;
    private String aBb;
    private int aBc;
    private com.baidu.swan.apps.media.c.b.a aBe;
    private long aBf;
    private long aBg;
    private b aBi;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private Context mContext;
    private boolean mIsBackground;
    private Timer mTimer;
    private int aBd = -1;
    private com.baidu.swan.apps.media.c.a aBh = new com.baidu.swan.apps.media.c.a();

    private a() {
    }

    public static a EG() {
        if (aBa == null) {
            synchronized (a.class) {
                if (aBa == null) {
                    aBa = new a();
                }
            }
        }
        return aBa;
    }

    public void a(String str, com.baidu.swan.apps.media.c.a aVar, Context context, b bVar, String str2) {
        int i;
        if (this.aBd != -1 && this.aBd != 3) {
            com.baidu.swan.apps.console.c.w("record", "wrong state, can't init");
            return;
        }
        this.aBh = aVar;
        eZ(str);
        this.aBi = bVar;
        this.aBc = AudioRecord.getMinBufferSize(aVar.aAO, aVar.aAN, 2);
        if (this.aBc <= 0) {
            com.baidu.swan.apps.console.c.e("record", "wrong buffer size");
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            zP();
            return;
        }
        if (aVar.aAN == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, aVar.aAO, i, 2, this.aBc);
        this.aBd = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void eZ(String str) {
        String str2;
        if (TextUtils.equals(this.aBh.aAM, "mp3")) {
            str2 = ".mp3";
        } else if (TextUtils.equals(this.aBh.aAM, "pcm")) {
            str2 = ".pcm";
        } else {
            str2 = ".aac";
        }
        this.aBb = str + File.separator + "AUDIO_" + Calendar.getInstance().getTimeInMillis() + str2;
    }

    public void bn(boolean z) {
        if (this.mContext == null) {
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "start error, context is null");
            zP();
        } else if (this.mIsBackground) {
            if (this.aBi != null) {
                this.aBi.k(2001, "error execute time");
            }
            com.baidu.swan.apps.console.c.e("record", "start error, wrong execute time");
            zP();
        } else if (this.aBd == -1 || TextUtils.isEmpty(this.aBb)) {
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "start error, wrong state");
            zP();
        } else if (z && this.aBd != 0 && this.aBd != 3) {
            if (this.aBi != null) {
                this.aBi.k(2003, "error execute action");
            }
            com.baidu.swan.apps.console.c.w("record", "error execute action when start");
        } else {
            if (DEBUG) {
                Log.d("AudioRecorderManager", "start record");
            }
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.aBi != null) {
                        this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
                    }
                    com.baidu.swan.apps.console.c.e("record", "start error, no real permission");
                    zP();
                    return;
                }
                if (z) {
                    a(new com.baidu.swan.apps.media.c.b.a() { // from class: com.baidu.swan.apps.media.c.c.a.1
                        @Override // com.baidu.swan.apps.media.c.b.a
                        public void wq() {
                            if (a.DEBUG) {
                                Log.d("AudioRecorderManager", "record --- timeOut");
                            }
                            com.baidu.swan.apps.console.c.i("record", "time out");
                            a.this.stopRecord();
                            a.this.zP();
                        }
                    });
                }
                if (this.aBi != null) {
                    this.aBi.eY(b.aAR);
                }
                d.bm("").b(Schedulers.io()).d(new f<String, Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    /* renamed from: fa */
                    public Boolean call(String str) {
                        return Boolean.valueOf(a.this.EH());
                    }
                }).a(rx.a.b.a.cDH()).c(new rx.functions.b<Boolean>() { // from class: com.baidu.swan.apps.media.c.c.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    /* renamed from: c */
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (a.this.aBi != null) {
                                a.this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
                            }
                            com.baidu.swan.apps.console.c.e("record", "record error");
                            a.this.zP();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (DEBUG) {
                    Log.d("AudioRecorderManager", "record --- start error");
                }
                if (this.aBi != null) {
                    this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
                }
                com.baidu.swan.apps.console.c.e("record", "can't start");
                zP();
            }
        }
    }

    public void EE() {
        if (this.aBd != 1) {
            if (this.aBi != null) {
                this.aBi.k(2003, "error execute action");
            }
            com.baidu.swan.apps.console.c.w("record", "pause error, wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "none audio record");
            zP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            this.aBd = 2;
            DY();
            if (this.aBi != null) {
                this.aBi.eY(b.aAS);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- pause error");
            }
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "pause error");
            zP();
        }
    }

    public void EF() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume record");
        }
        if (this.aBd != 2) {
            if (this.aBi != null) {
                this.aBi.k(2003, "error execute action");
            }
            com.baidu.swan.apps.console.c.w("record", "wrong state");
            return;
        }
        bn(false);
        DX();
    }

    public void stopRecord() {
        if (this.aBd != 2 && this.aBd != 1) {
            if (this.aBi != null) {
                this.aBi.k(2003, "error execute action");
            }
            com.baidu.swan.apps.console.c.w("record", "wrong state");
            return;
        }
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop record");
        }
        if (this.mAudioRecord == null) {
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "none audioRecord");
            zP();
            return;
        }
        try {
            this.mAudioRecord.stop();
            stopTimer();
            this.aBd = 3;
            if (this.aBi != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.aD(this.aBb, this.mAppId));
                    if (this.aBi != null) {
                        this.aBi.f(b.aAT, jSONObject);
                    }
                } catch (JSONException e) {
                    if (this.aBi != null) {
                        this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
                    }
                    com.baidu.swan.apps.console.c.e("record", "json error" + e.toString());
                    zP();
                }
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (DEBUG) {
                Log.d("AudioRecorderManager", "record --- stop error");
            }
            if (this.aBi != null) {
                this.aBi.k(BaseActivity.EXTRA_PARAM_FROM_PASS_SDK_ENTER, "error execute");
            }
            com.baidu.swan.apps.console.c.e("record", "stop error");
            zP();
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
    public boolean EH() {
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[this.aBc];
        String str = this.aBh.aAM;
        int i = this.aBh.aAN;
        ?? r4 = this.aBh.aAO;
        com.baidu.swan.apps.media.c.d.a aVar = new com.baidu.swan.apps.media.c.d.a(str, i, r4, this.aBh.aAP);
        if (this.mAudioRecord == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(this.aBb);
                if (this.aBd == 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                    com.baidu.swan.c.b.C(file);
                }
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    this.aBd = 1;
                    while (this.aBd == 1) {
                        if (this.mAudioRecord.read(bArr, 0, this.aBc) >= 0) {
                            byte[] F = TextUtils.equals(this.aBh.aAM, "pcm") ? bArr : aVar.F(bArr);
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
                    if (this.aBd == 1) {
                        this.aBd = 3;
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
                    if (this.aBd == 1) {
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
            Log.d("AudioRecorderManager", "start timer:" + this.aBh.aAL);
        }
        com.baidu.swan.apps.console.c.i("record", "start timer, totalTime:" + this.aBh.aAL);
        this.aBe = aVar;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    aVar.wq();
                }
                a.this.stopTimer();
            }
        }, this.aBh.aAL);
        this.aBf = System.currentTimeMillis();
    }

    public void stopTimer() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "stop timer");
        }
        com.baidu.swan.apps.console.c.i("record", "stop timer");
        this.aBe = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    public void DY() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "pause timer, lastTime:" + this.aBg);
        }
        com.baidu.swan.apps.console.c.i("record", "pause timer, lastTime:" + this.aBg);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.aBg = this.aBh.aAL - (System.currentTimeMillis() - this.aBf);
    }

    public void DX() {
        if (DEBUG) {
            Log.d("AudioRecorderManager", "resume timer");
        }
        com.baidu.swan.apps.console.c.i("record", "resume timer");
        if (this.aBe != null) {
            if (this.aBg <= 0) {
                this.aBe.wq();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.swan.apps.media.c.c.a.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (a.this.aBe != null) {
                        a.this.aBe.wq();
                    }
                    a.this.stopTimer();
                }
            }, this.aBg);
            this.aBf = System.currentTimeMillis();
        }
    }

    public void aO(boolean z) {
        if (z && this.aBd == 1) {
            EE();
        }
        this.mIsBackground = z;
    }

    public boolean bu(Context context) {
        return !com.baidu.swan.apps.an.a.LN() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (aBa != null) {
            aBa.zP();
        }
    }

    public static void bo(boolean z) {
        if (aBa != null) {
            aBa.aO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        this.aBd = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        aBa = null;
    }

    public com.baidu.swan.apps.media.c.a EI() {
        return this.aBh;
    }

    public b EJ() {
        return this.aBi;
    }
}
