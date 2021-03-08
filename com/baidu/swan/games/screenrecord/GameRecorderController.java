package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class GameRecorderController {
    private AREngineDelegate elO;
    private com.baidu.mario.a.c elP;
    private RecorderState elQ;
    private com.baidu.mario.audio.a.a elR;
    private long elS;
    private com.baidu.swan.nalib.audio.b elT = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.elR != null) {
                GameRecorderController.this.elR.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.elS);
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
        this.elO = aREngineDelegate;
        if (this.elO != null) {
            this.elQ = RecorderState.IDLE;
            this.elO.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aUg().aUi().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.elT);
            }
        });
    }

    public void aF(int i, String str) {
        if (this.elO != null) {
            SwanAppActivity azY = f.aAo().azY();
            boolean z = azY != null && azY.isLandScape();
            this.elO.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.elR = aVar;
                    GameRecorderController.this.elS = System.nanoTime();
                    GameRecorderController.this.aXW();
                }
            });
            this.elO.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXW() {
        if (this.elR != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.elR.a(true, audioParams);
        }
        ig(true);
    }

    private void ig(final boolean z) {
        com.baidu.swan.games.audio.b.b.aUg().aUi().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXX() {
        if (this.elR != null) {
            this.elR.onAudioStop(true);
        }
        ig(false);
    }

    public void pauseRecord() {
        if (this.elO != null) {
            this.elO.pauseRecord();
        }
        ig(false);
    }

    public void resumeRecord() {
        if (this.elO != null) {
            this.elO.resumeRecord();
        }
        ig(true);
    }

    public void stopRecord() {
        if (this.elO != null) {
            this.elO.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.elO != null) {
            return this.elO.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.elP = cVar;
    }

    public RecorderState aXY() {
        return this.elQ;
    }

    public void release() {
        if (this.elO != null && this.elP != null && (aXY() == RecorderState.RECORDING || aXY() == RecorderState.PAUSE)) {
            this.elP.onError(-1);
        }
        setGameRecordCallback(null);
        this.elQ = RecorderState.IDLE;
    }

    public static GameRecorderController aXZ() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes8.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.elQ = RecorderState.RECORDING;
            if (GameRecorderController.this.elP != null) {
                GameRecorderController.this.elP.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void af(int i, String str) {
            GameRecorderController.this.elQ = RecorderState.STOP;
            GameRecorderController.this.aXX();
            if (GameRecorderController.this.elP != null) {
                GameRecorderController.this.elP.af(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.elQ = RecorderState.PAUSE;
            if (GameRecorderController.this.elP != null) {
                GameRecorderController.this.elP.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.elQ = RecorderState.RECORDING;
            if (GameRecorderController.this.elP != null) {
                GameRecorderController.this.elP.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.elQ = RecorderState.IDLE;
            if (GameRecorderController.this.elP != null) {
                GameRecorderController.this.elP.onError(i);
            }
        }
    }
}
