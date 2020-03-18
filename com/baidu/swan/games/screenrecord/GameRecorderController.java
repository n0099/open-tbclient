package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate crM;
    private com.baidu.mario.a.c crN;
    private RecorderState crO;
    private com.baidu.mario.audio.a.a crP;
    private long crQ;
    private com.baidu.swan.nalib.audio.b crR = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.crP != null) {
                GameRecorderController.this.crP.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.crQ);
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
        this.crM = aREngineDelegate;
        if (this.crM != null) {
            this.crO = RecorderState.IDLE;
            this.crM.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.alE().alG().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.crR);
            }
        });
    }

    public void K(int i, String str) {
        if (this.crM != null) {
            SwanAppActivity WG = f.WV().WG();
            boolean z = WG != null && WG.isLandScape();
            this.crM.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.crP = aVar;
                    GameRecorderController.this.crQ = System.nanoTime();
                    GameRecorderController.this.apo();
                }
            });
            this.crM.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apo() {
        if (this.crP != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.crP.a(true, audioParams);
        }
        eH(true);
    }

    private void eH(final boolean z) {
        com.baidu.swan.games.audio.b.b.alE().alG().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        if (this.crP != null) {
            this.crP.onAudioStop(true);
        }
        eH(false);
    }

    public void pauseRecord() {
        if (this.crM != null) {
            this.crM.pauseRecord();
        }
        eH(false);
    }

    public void resumeRecord() {
        if (this.crM != null) {
            this.crM.resumeRecord();
        }
        eH(true);
    }

    public void stopRecord() {
        if (this.crM != null) {
            this.crM.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.crM != null) {
            return this.crM.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.crN = cVar;
    }

    public RecorderState apq() {
        return this.crO;
    }

    public void release() {
        if (this.crM != null && this.crN != null && (apq() == RecorderState.RECORDING || apq() == RecorderState.PAUSE)) {
            this.crN.onError(-1);
        }
        setGameRecordCallback(null);
        this.crO = RecorderState.IDLE;
    }

    public static GameRecorderController apr() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.crO = RecorderState.RECORDING;
            if (GameRecorderController.this.crN != null) {
                GameRecorderController.this.crN.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void q(int i, String str) {
            GameRecorderController.this.crO = RecorderState.STOP;
            GameRecorderController.this.app();
            if (GameRecorderController.this.crN != null) {
                GameRecorderController.this.crN.q(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.crO = RecorderState.PAUSE;
            if (GameRecorderController.this.crN != null) {
                GameRecorderController.this.crN.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.crO = RecorderState.RECORDING;
            if (GameRecorderController.this.crN != null) {
                GameRecorderController.this.crN.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.crO = RecorderState.IDLE;
            if (GameRecorderController.this.crN != null) {
                GameRecorderController.this.crN.onError(i);
            }
        }
    }
}
