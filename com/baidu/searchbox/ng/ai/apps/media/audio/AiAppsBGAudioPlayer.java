package com.baidu.searchbox.ng.ai.apps.media.audio;

import android.content.Context;
import android.os.Message;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsBGAudioPlayer {
    private static final boolean DEBUG = false;
    private static final String KEY_BUFFERED = "buffered";
    private static final String KEY_COVER_URL = "coverImgUrl";
    private static final String KEY_EPNAME = "epname";
    private static final String KEY_PAUSED = "paused";
    private static final String KEY_SINGER = "singer";
    private static final String KEY_SRC = "src";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_TITLE = "title";
    private static final String MODULE_TAG = "backgroundAudio";
    private static final String TAG = "AiAppsBGAudioPlayer";
    private Context mContext;
    private AiAppsAudioClient mPlayer;
    private AudioStatusCallback mStatusCallback;
    private AudioBGPlayerParams mParams = new AudioBGPlayerParams();
    private int mCurrentPosition = 0;
    private int mBuffer = 0;

    public AiAppsBGAudioPlayer(Context context) {
        this.mContext = context;
    }

    public void pause() {
        getPlayer().pause();
        if (this.mStatusCallback != null) {
            this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PAUSE);
        }
    }

    public void seekTo(int i) {
        getPlayer().seek(i * 1000);
        if (this.mStatusCallback != null) {
            this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_SEEKING);
        }
    }

    public void stop() {
        getPlayer().stop();
        if (this.mStatusCallback != null) {
            this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_STOP);
        }
    }

    public void release() {
        AiAppsLog.d(MODULE_TAG, "release ");
        getPlayer().release();
        this.mPlayer = null;
    }

    public int getDuration() {
        return getPlayer().getDuration();
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    public boolean isPaused() {
        return !getPlayer().isPlaying();
    }

    private AiAppsAudioClient getPlayer() {
        if (this.mPlayer == null) {
            this.mPlayer = new AiAppsAudioClient(this.mContext);
            this.mPlayer.setMessageCallback(new AudioPlayerListener());
        }
        return this.mPlayer;
    }

    public AudioBGPlayerParams getCurrentParams() {
        return this.mParams;
    }

    public void openPlayer(AudioBGPlayerParams audioBGPlayerParams, CallbackHandler callbackHandler) {
        this.mParams = audioBGPlayerParams;
        if (this.mParams.mCallbacks != null) {
            try {
                this.mStatusCallback = new AudioStatusCallback(callbackHandler, new JSONObject(this.mParams.mCallbacks));
            } catch (JSONException e) {
                AiAppsLog.e(MODULE_TAG, e.toString());
            }
        }
        play();
    }

    private void play() {
        getPlayer().play(this.mParams.toSongString(), this.mParams.mUrl);
    }

    public void resume() {
        getPlayer().resume();
    }

    public void update(AudioBGPlayerParams audioBGPlayerParams) {
        this.mParams = audioBGPlayerParams;
        if (this.mStatusCallback != null) {
            this.mStatusCallback.setCallbacks(this.mParams.mCallbacks);
        }
        play();
    }

    public String getCurrentSwanParam(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2129294769:
                if (str.equals(KEY_START_TIME)) {
                    c = 4;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c = 0;
                    break;
                }
                break;
            case -1522036513:
                if (str.equals(KEY_BUFFERED)) {
                    c = 5;
                    break;
                }
                break;
            case -1296614986:
                if (str.equals(KEY_EPNAME)) {
                    c = 7;
                    break;
                }
                break;
            case -995321554:
                if (str.equals(KEY_PAUSED)) {
                    c = 2;
                    break;
                }
                break;
            case -902265988:
                if (str.equals(KEY_SINGER)) {
                    c = '\b';
                    break;
                }
                break;
            case -453814973:
                if (str.equals(KEY_COVER_URL)) {
                    c = '\t';
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c = 3;
                    break;
                }
                break;
            case 110371416:
                if (str.equals("title")) {
                    c = 6;
                    break;
                }
                break;
            case 601235430:
                if (str.equals(AudioStatusCallback.KEY_POSITION)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return getPlayer().getDuration() + "";
            case 1:
                return this.mCurrentPosition + "";
            case 2:
                return isPaused() + "";
            case 3:
                return this.mParams.mUrl;
            case 4:
                return this.mParams.mStartTime + "";
            case 5:
                return this.mBuffer + "";
            case 6:
                return this.mParams.mTitle;
            case 7:
                return this.mParams.mEpName;
            case '\b':
                return this.mParams.mSinger;
            case '\t':
                return this.mParams.mCoverUrl;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AudioPlayerListener implements AiAppsAudioClient.OnMessageCallback {
        private boolean mIsFirstPlay;

        private AudioPlayerListener() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.media.audio.AiAppsAudioClient.OnMessageCallback
        public boolean onHandleMessage(Message message) {
            int i = message.what;
            int i2 = message.arg1;
            int i3 = message.arg2;
            JSONObject jSONObject = new JSONObject();
            switch (i) {
                case 1001:
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onCanPlay");
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_CAN_PLAY);
                    }
                    this.mIsFirstPlay = true;
                    return true;
                case 1002:
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onPlay");
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PLAY);
                    }
                    if (this.mIsFirstPlay) {
                        AiAppsBGAudioPlayer.this.seekTo(AiAppsBGAudioPlayer.this.mParams.mStartTime);
                        this.mIsFirstPlay = false;
                        return true;
                    }
                    return true;
                case 1003:
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onPause");
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PAUSE);
                        return true;
                    }
                    return true;
                case 1004:
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onStop");
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_STOP);
                    }
                    this.mIsFirstPlay = true;
                    return true;
                case 1005:
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onEnd");
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_END);
                        return true;
                    }
                    return true;
                case 1006:
                    AiAppsBGAudioPlayer.this.mCurrentPosition = i3;
                    try {
                        jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Integer.valueOf(AiAppsBGAudioPlayer.this.getCurrentPosition()));
                        jSONObject.putOpt("duration", Integer.valueOf(AiAppsBGAudioPlayer.this.getDuration()));
                    } catch (JSONException e) {
                    }
                    AiAppsLog.d(AiAppsBGAudioPlayer.MODULE_TAG, "event onTimeUpdate " + jSONObject.toString());
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_UPDATE_PROGRESS, jSONObject);
                        return true;
                    }
                    return true;
                case 1007:
                    try {
                        jSONObject.putOpt(AudioStatusCallback.KEY_ERROR_CODE, Integer.valueOf(i2));
                    } catch (JSONException e2) {
                    }
                    AiAppsLog.i(AiAppsBGAudioPlayer.MODULE_TAG, "event onError code:" + i2);
                    if (AiAppsBGAudioPlayer.this.mStatusCallback != null) {
                        AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback("onError", jSONObject);
                        return true;
                    }
                    return true;
                case 1008:
                    AiAppsBGAudioPlayer.this.mBuffer = i2;
                    AiAppsLog.d(AiAppsBGAudioPlayer.MODULE_TAG, "event onDownloadProgress " + AiAppsBGAudioPlayer.this.mBuffer);
                    if (AiAppsBGAudioPlayer.this.mStatusCallback == null || AiAppsBGAudioPlayer.this.mCurrentPosition < AiAppsBGAudioPlayer.this.mBuffer) {
                        return true;
                    }
                    AiAppsBGAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_WAIT);
                    return true;
                default:
                    return false;
            }
        }
    }
}
