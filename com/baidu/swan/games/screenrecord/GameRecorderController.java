package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes25.dex */
public class GameRecorderController {
    private AREngineDelegate edV;
    private com.baidu.mario.a.c edW;
    private RecorderState edX;
    private com.baidu.mario.audio.a.a edY;
    private long edZ;
    private com.baidu.swan.nalib.audio.b eea = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.edY != null) {
                GameRecorderController.this.edY.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.edZ);
            }
        }
    };

    /* loaded from: classes25.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.edV = aREngineDelegate;
        if (this.edV != null) {
            this.edX = RecorderState.IDLE;
            this.edV.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aVq().aVs().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.eea);
            }
        });
    }

    public void ay(int i, String str) {
        if (this.edV != null) {
            SwanAppActivity aBZ = f.aCp().aBZ();
            boolean z = aBZ != null && aBZ.isLandScape();
            this.edV.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.edY = aVar;
                    GameRecorderController.this.edZ = System.nanoTime();
                    GameRecorderController.this.aZg();
                }
            });
            this.edV.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZg() {
        if (this.edY != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.edY.a(true, audioParams);
        }
        hQ(true);
    }

    private void hQ(final boolean z) {
        com.baidu.swan.games.audio.b.b.aVq().aVs().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZh() {
        if (this.edY != null) {
            this.edY.onAudioStop(true);
        }
        hQ(false);
    }

    public void pauseRecord() {
        if (this.edV != null) {
            this.edV.pauseRecord();
        }
        hQ(false);
    }

    public void resumeRecord() {
        if (this.edV != null) {
            this.edV.resumeRecord();
        }
        hQ(true);
    }

    public void stopRecord() {
        if (this.edV != null) {
            this.edV.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.edV != null) {
            return this.edV.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.edW = cVar;
    }

    public RecorderState aZi() {
        return this.edX;
    }

    public void release() {
        if (this.edV != null && this.edW != null && (aZi() == RecorderState.RECORDING || aZi() == RecorderState.PAUSE)) {
            this.edW.onError(-1);
        }
        setGameRecordCallback(null);
        this.edX = RecorderState.IDLE;
    }

    public static GameRecorderController aZj() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes25.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.edX = RecorderState.RECORDING;
            if (GameRecorderController.this.edW != null) {
                GameRecorderController.this.edW.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void Y(int i, String str) {
            GameRecorderController.this.edX = RecorderState.STOP;
            GameRecorderController.this.aZh();
            if (GameRecorderController.this.edW != null) {
                GameRecorderController.this.edW.Y(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.edX = RecorderState.PAUSE;
            if (GameRecorderController.this.edW != null) {
                GameRecorderController.this.edW.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.edX = RecorderState.RECORDING;
            if (GameRecorderController.this.edW != null) {
                GameRecorderController.this.edW.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.edX = RecorderState.IDLE;
            if (GameRecorderController.this.edW != null) {
                GameRecorderController.this.edW.onError(i);
            }
        }
    }
}
