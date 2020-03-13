package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate crB;
    private com.baidu.mario.a.c crC;
    private RecorderState crD;
    private com.baidu.mario.audio.a.a crE;
    private long crF;
    private com.baidu.swan.nalib.audio.b crG = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.crE != null) {
                GameRecorderController.this.crE.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.crF);
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
        this.crB = aREngineDelegate;
        if (this.crB != null) {
            this.crD = RecorderState.IDLE;
            this.crB.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.alB().alD().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.crG);
            }
        });
    }

    public void K(int i, String str) {
        if (this.crB != null) {
            SwanAppActivity WD = f.WS().WD();
            boolean z = WD != null && WD.isLandScape();
            this.crB.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.crE = aVar;
                    GameRecorderController.this.crF = System.nanoTime();
                    GameRecorderController.this.apl();
                }
            });
            this.crB.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apl() {
        if (this.crE != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.crE.a(true, audioParams);
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
        if (this.crE != null) {
            this.crE.onAudioStop(true);
        }
        eG(false);
    }

    public void pauseRecord() {
        if (this.crB != null) {
            this.crB.pauseRecord();
        }
        eG(false);
    }

    public void resumeRecord() {
        if (this.crB != null) {
            this.crB.resumeRecord();
        }
        eG(true);
    }

    public void stopRecord() {
        if (this.crB != null) {
            this.crB.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.crB != null) {
            return this.crB.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.crC = cVar;
    }

    public RecorderState apn() {
        return this.crD;
    }

    public void release() {
        if (this.crB != null && this.crC != null && (apn() == RecorderState.RECORDING || apn() == RecorderState.PAUSE)) {
            this.crC.onError(-1);
        }
        setGameRecordCallback(null);
        this.crD = RecorderState.IDLE;
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
            GameRecorderController.this.crD = RecorderState.RECORDING;
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void q(int i, String str) {
            GameRecorderController.this.crD = RecorderState.STOP;
            GameRecorderController.this.apm();
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.q(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.crD = RecorderState.PAUSE;
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.crD = RecorderState.RECORDING;
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.crD = RecorderState.IDLE;
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.onError(i);
            }
        }
    }
}
