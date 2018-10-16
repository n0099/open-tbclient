package com.baidu.searchbox.ng.ai.apps.media.audio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.media.audio.event.AudioStatusCallback;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsAudioPlayer implements AiAppsPlayerContext {
    private static final boolean DEBUG = false;
    public static final String ERROR_FILE = "10003";
    public static final String ERROR_FORMAT = "10004";
    public static final String ERROR_NET = "10002";
    public static final String ERROR_SYSTEM = "10001";
    public static final String ERROR_UNKNOWN = "-1";
    private static final String TAG = "AiAppsAudioPlayer";
    private MediaPlayer mPlayer;
    private String mPlayerId;
    private UpdateProgress mProgressHandler;
    private AudioStatusCallback mStatusCallback;
    private AudioPlayerParams mParams = new AudioPlayerParams();
    private PlayerStatus mStatus = PlayerStatus.NONE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum PlayerStatus {
        NONE,
        IDLE,
        PREPARING,
        PREPARED
    }

    public AiAppsAudioPlayer(String str) {
        this.mPlayerId = "";
        this.mPlayerId = str;
        AiAppsPlayerManager.addPlayerContext(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start() {
        getPlayer().start();
        if (this.mProgressHandler != null) {
            this.mProgressHandler.sendEmptyMessage(0);
        }
        if (this.mStatusCallback != null) {
            this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PLAY);
        }
        updatePlayerConfig();
        if (this.mParams.mStartTime > 0) {
            seekTo(this.mParams.mStartTime);
        }
    }

    public void pause() {
        if (getPlayer().isPlaying()) {
            getPlayer().pause();
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PAUSE);
            }
            if (this.mProgressHandler != null) {
                this.mProgressHandler.removeMessages(0);
            }
        }
    }

    public void seekTo(int i) {
        if (this.mStatus == PlayerStatus.PREPARED) {
            getPlayer().seekTo((int) (i * 1000));
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_SEEKING);
            }
        }
    }

    private void setLooping(boolean z) {
        getPlayer().setLooping(z);
    }

    public void stop() {
        if (this.mStatus == PlayerStatus.PREPARED) {
            getPlayer().stop();
            this.mStatus = PlayerStatus.IDLE;
            if (this.mProgressHandler != null) {
                this.mProgressHandler.removeMessages(0);
            }
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_STOP);
            }
        }
    }

    public void release() {
        getPlayer().release();
        this.mStatus = PlayerStatus.NONE;
        this.mPlayer = null;
        if (this.mProgressHandler != null) {
            this.mProgressHandler.removeMessages(0);
            this.mProgressHandler = null;
        }
        AiAppsPlayerManager.removePlayerContext(this);
    }

    private int getSystemVolume() {
        return ((AudioManager) AppRuntime.getAppContext().getSystemService("audio")).getStreamVolume(1);
    }

    public int getDuration() {
        return getPlayer().getDuration();
    }

    public int getCurrentPosition() {
        return getPlayer().getCurrentPosition();
    }

    public boolean isPaused() {
        return !getPlayer().isPlaying();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaPlayer getPlayer() {
        if (this.mPlayer == null) {
            this.mPlayer = new MediaPlayer();
            AudioPlayerListener audioPlayerListener = new AudioPlayerListener();
            this.mPlayer.setOnPreparedListener(audioPlayerListener);
            this.mPlayer.setOnCompletionListener(audioPlayerListener);
            this.mPlayer.setOnInfoListener(audioPlayerListener);
            this.mPlayer.setOnErrorListener(audioPlayerListener);
            this.mPlayer.setOnSeekCompleteListener(audioPlayerListener);
            this.mPlayer.setOnBufferingUpdateListener(audioPlayerListener);
            this.mProgressHandler = new UpdateProgress();
        }
        return this.mPlayer;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getPlayerId() {
        return this.mPlayerId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public String getSlaveId() {
        return this.mParams.mSlaveId;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public Object getPlayerObject() {
        return this;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public int getPlayerType() {
        return 3;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onForegroundChanged(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onAppForegroundChanged(boolean z) {
        if (!z) {
            pause();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void resetPlayer() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext
    public void onDestroy() {
    }

    public AudioPlayerParams getCurrentParams() {
        return this.mParams;
    }

    public void openPlayer(AudioPlayerParams audioPlayerParams, CallbackHandler callbackHandler) {
        this.mParams = audioPlayerParams;
        if (this.mParams.mCallbacks != null) {
            try {
                this.mStatusCallback = new AudioStatusCallback(callbackHandler, new JSONObject(this.mParams.mCallbacks));
            } catch (JSONException e) {
            }
        }
        getPlayer().reset();
        try {
            getPlayer().setDataSource(this.mParams.mUrl);
            this.mStatus = PlayerStatus.IDLE;
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_CAN_PLAY);
            }
        } catch (IOException e2) {
            if (this.mStatusCallback != null) {
                JSONObject jSONObject = new JSONObject();
                if (AiAppNetworkUtils.isNetworkConnected(null)) {
                    jSONObject.optString(AudioStatusCallback.KEY_ERROR_CODE, ERROR_NET);
                } else {
                    jSONObject.optString(AudioStatusCallback.KEY_ERROR_CODE, ERROR_FILE);
                }
                this.mStatusCallback.dispatchCallback("onError");
            }
        }
    }

    public void play() {
        if (this.mStatus == PlayerStatus.PREPARED) {
            getPlayer().start();
            if (this.mProgressHandler != null) {
                this.mProgressHandler.sendEmptyMessage(0);
            }
            if (this.mStatusCallback != null) {
                this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_PLAY);
            }
        } else if (this.mStatus == PlayerStatus.IDLE) {
            getPlayer().prepareAsync();
            this.mStatus = PlayerStatus.PREPARING;
        }
    }

    public void update(AudioPlayerParams audioPlayerParams) {
        this.mParams = audioPlayerParams;
        if (this.mStatusCallback != null) {
            this.mStatusCallback.setCallbacks(this.mParams.mCallbacks);
        }
        updatePlayerConfig();
    }

    private void updatePlayerConfig() {
        setLooping(this.mParams.mLoop);
        setVolume(this.mParams.mVolume);
        if (getSystemVolume() > 0 || !this.mParams.mObeyMute) {
            setVolume(this.mParams.mVolume);
        } else {
            setVolume(0.0f);
        }
    }

    private void setVolume(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        getPlayer().setVolume(f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class UpdateProgress extends Handler {
        private static final long UPDATE_INTERVAL = 1000;
        private static final int WHAT_UPDATE_PROGRESS = 0;

        private UpdateProgress() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt(AudioStatusCallback.KEY_POSITION, Long.valueOf(AiAppsAudioPlayer.this.getPlayer().getCurrentPosition() / 1000));
                    jSONObject.putOpt("duration", Long.valueOf(AiAppsAudioPlayer.this.getPlayer().getDuration() / 1000));
                    if (AiAppsAudioPlayer.this.mStatusCallback != null) {
                        AiAppsAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_UPDATE_PROGRESS, jSONObject);
                    }
                } catch (JSONException e) {
                }
                sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AudioPlayerListener implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
        private AudioPlayerListener() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AiAppsAudioPlayer.this.mStatus = PlayerStatus.PREPARED;
            AiAppsAudioPlayer.this.start();
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (AiAppsAudioPlayer.this.mStatusCallback != null) {
                AiAppsAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_END);
            }
            AiAppsAudioPlayer.this.mProgressHandler.removeMessages(0);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            String str;
            switch (i) {
                case 1:
                    str = AiAppsAudioPlayer.ERROR_UNKNOWN;
                    break;
                case 100:
                    str = AiAppsAudioPlayer.ERROR_SYSTEM;
                    break;
                default:
                    str = AiAppsAudioPlayer.ERROR_UNKNOWN;
                    break;
            }
            if (i2 == -1007) {
                str = AiAppsAudioPlayer.ERROR_FORMAT;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(AudioStatusCallback.KEY_ERROR_CODE, str);
            } catch (JSONException e) {
            }
            if (AiAppsAudioPlayer.this.mStatusCallback != null) {
                AiAppsAudioPlayer.this.mStatusCallback.dispatchCallback("onError", jSONObject);
                return true;
            }
            return true;
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (AiAppsAudioPlayer.this.mStatusCallback != null) {
                AiAppsAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_SEEK_COMPLETION);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            if (AiAppsAudioPlayer.this.mStatus == PlayerStatus.PREPARED && (AiAppsAudioPlayer.this.getPlayer().getDuration() * i) / 100 <= AiAppsAudioPlayer.this.getPlayer().getCurrentPosition() && AiAppsAudioPlayer.this.mStatusCallback != null) {
                AiAppsAudioPlayer.this.mStatusCallback.dispatchCallback(AudioStatusCallback.ON_WAIT);
            }
        }
    }
}
