package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate crA;
    private com.baidu.mario.a.c crB;
    private RecorderState crC;
    private com.baidu.mario.audio.a.a crD;
    private long crE;
    private com.baidu.swan.nalib.audio.b crF = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.crD != null) {
                GameRecorderController.this.crD.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.crE);
            }
        }
    };

    /* loaded from: classes11.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.crA = aREngineDelegate;
        if (this.crA != null) {
            this.crC = RecorderState.IDLE;
            this.crA.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.alB().alD().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.crF);
            }
        });
    }

    public void K(int i, String str) {
        if (this.crA != null) {
            SwanAppActivity WD = f.WS().WD();
            boolean z = WD != null && WD.isLandScape();
            this.crA.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.crD = aVar;
                    GameRecorderController.this.crE = System.nanoTime();
                    GameRecorderController.this.apl();
                }
            });
            this.crA.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        if (this.crD != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.crD.a(true, audioParams);
        }
        eG(true);
    }

    private void eG(final boolean z) {
        com.baidu.swan.games.audio.b.b.alB().alD().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apm() {
        if (this.crD != null) {
            this.crD.onAudioStop(true);
        }
        eG(false);
    }

    public void pauseRecord() {
        if (this.crA != null) {
            this.crA.pauseRecord();
        }
        eG(false);
    }

    public void resumeRecord() {
        if (this.crA != null) {
            this.crA.resumeRecord();
        }
        eG(true);
    }

    public void stopRecord() {
        if (this.crA != null) {
            this.crA.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.crA != null) {
            return this.crA.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.crB = cVar;
    }

    public RecorderState apn() {
        return this.crC;
    }

    public void release() {
        if (this.crA != null && this.crB != null && (apn() == RecorderState.RECORDING || apn() == RecorderState.PAUSE)) {
            this.crB.onError(-1);
        }
        setGameRecordCallback(null);
        this.crC = RecorderState.IDLE;
    }

    public static GameRecorderController apo() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.crC = RecorderState.RECORDING;
            if (GameRecorderController.this.crB != null) {
                GameRecorderController.this.crB.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void q(int i, String str) {
            GameRecorderController.this.crC = RecorderState.STOP;
            GameRecorderController.this.apm();
            if (GameRecorderController.this.crB != null) {
                GameRecorderController.this.crB.q(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.crC = RecorderState.PAUSE;
            if (GameRecorderController.this.crB != null) {
                GameRecorderController.this.crB.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.crC = RecorderState.RECORDING;
            if (GameRecorderController.this.crB != null) {
                GameRecorderController.this.crB.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.crC = RecorderState.IDLE;
            if (GameRecorderController.this.crB != null) {
                GameRecorderController.this.crB.onError(i);
            }
        }
    }
}
