package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate cQM;
    private com.baidu.mario.a.c cQN;
    private RecorderState cQO;
    private com.baidu.mario.audio.a.a cQP;
    private long cQQ;
    private com.baidu.swan.nalib.audio.b cQR = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.cQP != null) {
                GameRecorderController.this.cQP.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.cQQ);
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
        this.cQM = aREngineDelegate;
        if (this.cQM != null) {
            this.cQO = RecorderState.IDLE;
            this.cQM.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.atS().atU().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.cQR);
            }
        });
    }

    public void ab(int i, String str) {
        if (this.cQM != null) {
            SwanAppActivity aeu = f.aeJ().aeu();
            boolean z = aeu != null && aeu.isLandScape();
            this.cQM.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.cQP = aVar;
                    GameRecorderController.this.cQQ = System.nanoTime();
                    GameRecorderController.this.axA();
                }
            });
            this.cQM.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        if (this.cQP != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.cQP.a(true, audioParams);
        }
        fE(true);
    }

    private void fE(final boolean z) {
        com.baidu.swan.games.audio.b.b.atS().atU().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axB() {
        if (this.cQP != null) {
            this.cQP.onAudioStop(true);
        }
        fE(false);
    }

    public void pauseRecord() {
        if (this.cQM != null) {
            this.cQM.pauseRecord();
        }
        fE(false);
    }

    public void resumeRecord() {
        if (this.cQM != null) {
            this.cQM.resumeRecord();
        }
        fE(true);
    }

    public void stopRecord() {
        if (this.cQM != null) {
            this.cQM.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.cQM != null) {
            return this.cQM.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.cQN = cVar;
    }

    public RecorderState axC() {
        return this.cQO;
    }

    public void release() {
        if (this.cQM != null && this.cQN != null && (axC() == RecorderState.RECORDING || axC() == RecorderState.PAUSE)) {
            this.cQN.onError(-1);
        }
        setGameRecordCallback(null);
        this.cQO = RecorderState.IDLE;
    }

    public static GameRecorderController axD() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.cQO = RecorderState.RECORDING;
            if (GameRecorderController.this.cQN != null) {
                GameRecorderController.this.cQN.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void F(int i, String str) {
            GameRecorderController.this.cQO = RecorderState.STOP;
            GameRecorderController.this.axB();
            if (GameRecorderController.this.cQN != null) {
                GameRecorderController.this.cQN.F(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.cQO = RecorderState.PAUSE;
            if (GameRecorderController.this.cQN != null) {
                GameRecorderController.this.cQN.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.cQO = RecorderState.RECORDING;
            if (GameRecorderController.this.cQN != null) {
                GameRecorderController.this.cQN.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.cQO = RecorderState.IDLE;
            if (GameRecorderController.this.cQN != null) {
                GameRecorderController.this.cQN.onError(i);
            }
        }
    }
}
