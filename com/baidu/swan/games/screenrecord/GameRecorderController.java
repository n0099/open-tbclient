package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class GameRecorderController {
    private AREngineDelegate dWW;
    private com.baidu.mario.a.c dWX;
    private RecorderState dWY;
    private com.baidu.mario.audio.a.a dWZ;
    private long dXa;
    private com.baidu.swan.nalib.audio.b dXb = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dWZ != null) {
                GameRecorderController.this.dWZ.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dXa);
            }
        }
    };

    /* loaded from: classes7.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dWW = aREngineDelegate;
        if (this.dWW != null) {
            this.dWY = RecorderState.IDLE;
            this.dWW.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aSl().aSn().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dXb);
            }
        });
    }

    public void ay(int i, String str) {
        if (this.dWW != null) {
            SwanAppActivity ayQ = f.azg().ayQ();
            boolean z = ayQ != null && ayQ.isLandScape();
            this.dWW.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dWZ = aVar;
                    GameRecorderController.this.dXa = System.nanoTime();
                    GameRecorderController.this.aWb();
                }
            });
            this.dWW.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        if (this.dWZ != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dWZ.a(true, audioParams);
        }
        hB(true);
    }

    private void hB(final boolean z) {
        com.baidu.swan.games.audio.b.b.aSl().aSn().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWc() {
        if (this.dWZ != null) {
            this.dWZ.onAudioStop(true);
        }
        hB(false);
    }

    public void pauseRecord() {
        if (this.dWW != null) {
            this.dWW.pauseRecord();
        }
        hB(false);
    }

    public void resumeRecord() {
        if (this.dWW != null) {
            this.dWW.resumeRecord();
        }
        hB(true);
    }

    public void stopRecord() {
        if (this.dWW != null) {
            this.dWW.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dWW != null) {
            return this.dWW.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dWX = cVar;
    }

    public RecorderState aWd() {
        return this.dWY;
    }

    public void release() {
        if (this.dWW != null && this.dWX != null && (aWd() == RecorderState.RECORDING || aWd() == RecorderState.PAUSE)) {
            this.dWX.onError(-1);
        }
        setGameRecordCallback(null);
        this.dWY = RecorderState.IDLE;
    }

    public static GameRecorderController aWe() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes7.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dWY = RecorderState.RECORDING;
            if (GameRecorderController.this.dWX != null) {
                GameRecorderController.this.dWX.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void Y(int i, String str) {
            GameRecorderController.this.dWY = RecorderState.STOP;
            GameRecorderController.this.aWc();
            if (GameRecorderController.this.dWX != null) {
                GameRecorderController.this.dWX.Y(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dWY = RecorderState.PAUSE;
            if (GameRecorderController.this.dWX != null) {
                GameRecorderController.this.dWX.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dWY = RecorderState.RECORDING;
            if (GameRecorderController.this.dWX != null) {
                GameRecorderController.this.dWX.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dWY = RecorderState.IDLE;
            if (GameRecorderController.this.dWX != null) {
                GameRecorderController.this.dWX.onError(i);
            }
        }
    }
}
