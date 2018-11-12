package com.baidu.searchbox.ng.ai.apps.media.recorder.manager;

import android.content.Context;
import android.media.AudioRecord;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.media.recorder.AudioRecordParams;
import com.baidu.searchbox.ng.ai.apps.media.recorder.RecordStatusCallback;
import com.baidu.searchbox.ng.ai.apps.media.recorder.listener.TimeOutListener;
import com.baidu.searchbox.ng.ai.apps.media.recorder.utils.AiAppsRecordConstants;
import com.baidu.searchbox.ng.ai.apps.media.recorder.utils.AudioEncodeUtil;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppAPIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class AiAppsAudioRecorderManager implements IRecorderManager {
    private static final String AUDIO_AAC_SUFFIX = ".aac";
    private static final String AUDIO_MP3_SUFFIX = ".mp3";
    private static final String AUDIO_PCM_SUFFIX = ".pcm";
    private static final String AUDIO_PREFIX = "AUDIO_";
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "record";
    private static final int STATE_NO_READY = -1;
    private static final int STATE_PAUSE = 2;
    private static final int STATE_READY = 0;
    private static final int STATE_START = 1;
    private static final int STATE_STOP = 3;
    private static final String TAG = "AudioRecorderManager";
    private static volatile AiAppsAudioRecorderManager instance;
    private String mAppId;
    private AudioRecord mAudioRecord;
    private int mBufferSizeInBytes;
    private Context mContext;
    private boolean mIsBackground;
    private long mLastRecodeStartTime;
    private long mRealLastTime;
    private String mRecordFilePath;
    private RecordStatusCallback mStatusCallback;
    private TimeOutListener mTimeOutListener;
    private Timer mTimer;
    private int mRecordPlayState = -1;
    private AudioRecordParams mParams = new AudioRecordParams();

    private AiAppsAudioRecorderManager() {
    }

    public static AiAppsAudioRecorderManager getInstance() {
        if (instance == null) {
            synchronized (AiAppsAudioRecorderManager.class) {
                if (instance == null) {
                    instance = new AiAppsAudioRecorderManager();
                }
            }
        }
        return instance;
    }

    public void init(String str, AudioRecordParams audioRecordParams, Context context, RecordStatusCallback recordStatusCallback, String str2) {
        int i;
        if (this.mRecordPlayState != -1 && this.mRecordPlayState != 3) {
            AiAppsLog.w(MODULE_TAG, "wrong state, can't init");
            return;
        }
        this.mParams = audioRecordParams;
        initSaveAudioPath(str);
        this.mStatusCallback = recordStatusCallback;
        this.mBufferSizeInBytes = AudioRecord.getMinBufferSize(audioRecordParams.sampleRate, audioRecordParams.channel, 2);
        if (this.mBufferSizeInBytes <= 0) {
            AiAppsLog.e(MODULE_TAG, "wrong buffer size");
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
            }
            realRelease();
            return;
        }
        if (audioRecordParams.channel == 1) {
            i = 16;
        } else {
            i = 12;
        }
        this.mAudioRecord = new AudioRecord(1, audioRecordParams.sampleRate, i, 2, this.mBufferSizeInBytes);
        this.mRecordPlayState = 0;
        this.mContext = context;
        this.mAppId = str2;
    }

    private void initSaveAudioPath(String str) {
        String str2;
        if (TextUtils.equals(this.mParams.audioFormat, AiAppsRecordConstants.FORMAT_MP3)) {
            str2 = AUDIO_MP3_SUFFIX;
        } else if (TextUtils.equals(this.mParams.audioFormat, AiAppsRecordConstants.FORMAT_PCM)) {
            str2 = AUDIO_PCM_SUFFIX;
        } else {
            str2 = AUDIO_AAC_SUFFIX;
        }
        this.mRecordFilePath = str + File.separator + AUDIO_PREFIX + Calendar.getInstance().getTimeInMillis() + str2;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void startRecord(boolean z) {
        if (this.mContext == null) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
            }
            AiAppsLog.e(MODULE_TAG, "start error, context is null");
            realRelease();
        } else if (this.mIsBackground) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2001, AiAppsRecordConstants.ERROR_EXECUTE_TIME);
            }
            AiAppsLog.e(MODULE_TAG, "start error, wrong execute time");
            realRelease();
        } else if (this.mRecordPlayState == -1 || TextUtils.isEmpty(this.mRecordFilePath)) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
            }
            AiAppsLog.e(MODULE_TAG, "start error, wrong state");
            realRelease();
        } else if (z && this.mRecordPlayState != 0 && this.mRecordPlayState != 3) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2003, AiAppsRecordConstants.ERROR_EXECUTE_ACTION);
            }
            AiAppsLog.w(MODULE_TAG, "error execute action when start");
        } else {
            try {
                this.mAudioRecord.startRecording();
                if (this.mAudioRecord.getRecordingState() != 3) {
                    if (this.mStatusCallback != null) {
                        this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                    }
                    AiAppsLog.e(MODULE_TAG, "start error, no real permission");
                    realRelease();
                    return;
                }
                if (z) {
                    startTimer(new TimeOutListener() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager.1
                        @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.listener.TimeOutListener
                        public void timeOut() {
                            AiAppsLog.i(AiAppsAudioRecorderManager.MODULE_TAG, "time out");
                            AiAppsAudioRecorderManager.this.stopRecord();
                            AiAppsAudioRecorderManager.this.realRelease();
                        }

                        @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.listener.TimeOutListener
                        public void cancel() {
                            AiAppsLog.i(AiAppsAudioRecorderManager.MODULE_TAG, "time cancel");
                            AiAppsAudioRecorderManager.this.realRelease();
                        }
                    });
                }
                if (this.mStatusCallback != null) {
                    this.mStatusCallback.dispatchCallback(RecordStatusCallback.startCallback);
                }
                d.just("").subscribeOn(Schedulers.io()).map(new f<String, Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.f
                    public Boolean call(String str) {
                        return Boolean.valueOf(AiAppsAudioRecorderManager.this.saveRecord());
                    }
                }).observeOn(a.caV()).subscribe(new b<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // rx.functions.b
                    public void call(Boolean bool) {
                        if (!bool.booleanValue()) {
                            if (AiAppsAudioRecorderManager.this.mStatusCallback != null) {
                                AiAppsAudioRecorderManager.this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                            }
                            AiAppsLog.e(AiAppsAudioRecorderManager.MODULE_TAG, "record error");
                            AiAppsAudioRecorderManager.this.realRelease();
                        }
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (this.mStatusCallback != null) {
                    this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                }
                AiAppsLog.e(MODULE_TAG, "can't start");
                realRelease();
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void pauseRecord() {
        if (this.mRecordPlayState != 1) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2003, AiAppsRecordConstants.ERROR_EXECUTE_ACTION);
            }
            AiAppsLog.w(MODULE_TAG, "pause error, wrong state");
        } else if (this.mAudioRecord == null) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
            }
            AiAppsLog.e(MODULE_TAG, "none audio record");
            realRelease();
        } else {
            try {
                this.mAudioRecord.stop();
                this.mRecordPlayState = 2;
                pauseTimer();
                if (this.mStatusCallback != null) {
                    this.mStatusCallback.dispatchCallback(RecordStatusCallback.pauseCallback);
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
                if (this.mStatusCallback != null) {
                    this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                }
                AiAppsLog.e(MODULE_TAG, "pause error");
                realRelease();
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void resumeRecord() {
        if (this.mRecordPlayState != 2) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2003, AiAppsRecordConstants.ERROR_EXECUTE_ACTION);
            }
            AiAppsLog.w(MODULE_TAG, "wrong state");
            return;
        }
        startRecord(false);
        resumeTimer();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void stopRecord() {
        if (this.mRecordPlayState != 2 && this.mRecordPlayState != 1) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2003, AiAppsRecordConstants.ERROR_EXECUTE_ACTION);
            }
            AiAppsLog.w(MODULE_TAG, "wrong state");
        } else if (this.mAudioRecord == null) {
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
            }
            AiAppsLog.e(MODULE_TAG, "none audioRecord");
            realRelease();
        } else {
            try {
                this.mAudioRecord.stop();
                stopTimer();
                this.mRecordPlayState = 3;
                if (this.mStatusCallback != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tempFilePath", StorageUtil.path2Scheme(this.mRecordFilePath, this.mAppId));
                        if (this.mStatusCallback != null) {
                            this.mStatusCallback.dispatchCallback(RecordStatusCallback.stopCallback, jSONObject);
                        }
                    } catch (JSONException e) {
                        if (this.mStatusCallback != null) {
                            this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                        }
                        AiAppsLog.e(MODULE_TAG, "json error" + e.toString());
                        realRelease();
                    }
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                if (this.mStatusCallback != null) {
                    this.mStatusCallback.dispatchErrorCallback(2002, AiAppsRecordConstants.ERROR_EXECUTE);
                }
                AiAppsLog.e(MODULE_TAG, "stop error");
                realRelease();
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public boolean saveRecord() {
        byte[] bArr = new byte[this.mBufferSizeInBytes];
        try {
            File file = new File(this.mRecordFilePath);
            if (this.mRecordPlayState == 0) {
                if (file.exists()) {
                    file.delete();
                }
                AiAppsFileUtils.createNewFileSafely(file);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            AudioEncodeUtil audioEncodeUtil = new AudioEncodeUtil(this.mParams.audioFormat, this.mParams.channel, this.mParams.sampleRate, this.mParams.bitRate);
            if (this.mAudioRecord == null) {
                return false;
            }
            this.mRecordPlayState = 1;
            while (this.mRecordPlayState == 1) {
                if (this.mAudioRecord.read(bArr, 0, this.mBufferSizeInBytes) >= 0) {
                    byte[] startEncode = TextUtils.equals(this.mParams.audioFormat, AiAppsRecordConstants.FORMAT_PCM) ? bArr : audioEncodeUtil.startEncode(bArr);
                    if (startEncode != null && startEncode.length > 0) {
                        try {
                            fileOutputStream.write(startEncode);
                        } catch (IOException e) {
                            e.printStackTrace();
                            this.mRecordPlayState = 3;
                            return false;
                        }
                    }
                }
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (FileNotFoundException | IllegalStateException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void startTimer(final TimeOutListener timeOutListener) {
        AiAppsLog.i(MODULE_TAG, "start timer, totalTime:" + this.mParams.recordTime);
        this.mTimeOutListener = timeOutListener;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (timeOutListener != null) {
                    timeOutListener.timeOut();
                }
                AiAppsAudioRecorderManager.this.stopTimer();
            }
        }, this.mParams.recordTime);
        this.mLastRecodeStartTime = System.currentTimeMillis();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void stopTimer() {
        AiAppsLog.i(MODULE_TAG, "stop timer");
        this.mTimeOutListener = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void pauseTimer() {
        AiAppsLog.i(MODULE_TAG, "pause timer, lastTime:" + this.mRealLastTime);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.mRealLastTime = this.mParams.recordTime - (System.currentTimeMillis() - this.mLastRecodeStartTime);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void resumeTimer() {
        AiAppsLog.i(MODULE_TAG, "resume timer");
        if (this.mTimeOutListener != null) {
            if (this.mRealLastTime <= 0) {
                this.mTimeOutListener.timeOut();
                return;
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() { // from class: com.baidu.searchbox.ng.ai.apps.media.recorder.manager.AiAppsAudioRecorderManager.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AiAppsAudioRecorderManager.this.mTimeOutListener != null) {
                        AiAppsAudioRecorderManager.this.mTimeOutListener.timeOut();
                    }
                    AiAppsAudioRecorderManager.this.stopTimer();
                }
            }, this.mRealLastTime);
            this.mLastRecodeStartTime = System.currentTimeMillis();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void cancelTimer() {
        AiAppsLog.i(MODULE_TAG, "cancel timer");
        if (this.mTimeOutListener != null) {
            this.mTimeOutListener.cancel();
        }
        stopTimer();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public void onAiAppForegroundChange(boolean z) {
        if (z && this.mRecordPlayState == 1) {
            pauseRecord();
        }
        this.mIsBackground = z;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.recorder.manager.IRecorderManager
    public boolean hasRecordPermission(Context context) {
        return !AiAppAPIUtils.hasMarshMallow() || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }

    public static void release() {
        if (instance != null) {
            instance.realRelease();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realRelease() {
        this.mRecordPlayState = -1;
        stopTimer();
        this.mContext = null;
        if (this.mAudioRecord != null) {
            this.mAudioRecord.release();
            this.mAudioRecord = null;
        }
        instance = null;
    }

    public AudioRecordParams getCurrentParams() {
        return this.mParams;
    }

    public RecordStatusCallback getCurrentCallbacks() {
        return this.mStatusCallback;
    }
}
