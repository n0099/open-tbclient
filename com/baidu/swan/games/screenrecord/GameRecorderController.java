package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class GameRecorderController {
    private AREngineDelegate dwj;
    private com.baidu.mario.a.c dwk;
    private RecorderState dwl;
    private com.baidu.mario.audio.a.a dwm;
    private long dwn;
    private com.baidu.swan.nalib.audio.b dwo = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dwm != null) {
                GameRecorderController.this.dwm.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dwn);
            }
        }
    };

    /* loaded from: classes8.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dwj = aREngineDelegate;
        if (this.dwj != null) {
            this.dwl = RecorderState.IDLE;
            this.dwj.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aLf().aLh().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dwo);
            }
        });
    }

    public void ag(int i, String str) {
        if (this.dwj != null) {
            SwanAppActivity arI = f.arY().arI();
            boolean z = arI != null && arI.isLandScape();
            this.dwj.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dwm = aVar;
                    GameRecorderController.this.dwn = System.nanoTime();
                    GameRecorderController.this.aOV();
                }
            });
            this.dwj.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        if (this.dwm != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dwm.a(true, audioParams);
        }
        gH(true);
    }

    private void gH(final boolean z) {
        com.baidu.swan.games.audio.b.b.aLf().aLh().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        if (this.dwm != null) {
            this.dwm.onAudioStop(true);
        }
        gH(false);
    }

    public void pauseRecord() {
        if (this.dwj != null) {
            this.dwj.pauseRecord();
        }
        gH(false);
    }

    public void resumeRecord() {
        if (this.dwj != null) {
            this.dwj.resumeRecord();
        }
        gH(true);
    }

    public void stopRecord() {
        if (this.dwj != null) {
            this.dwj.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dwj != null) {
            return this.dwj.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dwk = cVar;
    }

    public RecorderState aOX() {
        return this.dwl;
    }

    public void release() {
        if (this.dwj != null && this.dwk != null && (aOX() == RecorderState.RECORDING || aOX() == RecorderState.PAUSE)) {
            this.dwk.onError(-1);
        }
        setGameRecordCallback(null);
        this.dwl = RecorderState.IDLE;
    }

    public static GameRecorderController aOY() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes8.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dwl = RecorderState.RECORDING;
            if (GameRecorderController.this.dwk != null) {
                GameRecorderController.this.dwk.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void G(int i, String str) {
            GameRecorderController.this.dwl = RecorderState.STOP;
            GameRecorderController.this.aOW();
            if (GameRecorderController.this.dwk != null) {
                GameRecorderController.this.dwk.G(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dwl = RecorderState.PAUSE;
            if (GameRecorderController.this.dwk != null) {
                GameRecorderController.this.dwk.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dwl = RecorderState.RECORDING;
            if (GameRecorderController.this.dwk != null) {
                GameRecorderController.this.dwk.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dwl = RecorderState.IDLE;
            if (GameRecorderController.this.dwk != null) {
                GameRecorderController.this.dwk.onError(i);
            }
        }
    }
}
