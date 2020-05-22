package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate dbI;
    private com.baidu.mario.a.c dbJ;
    private RecorderState dbK;
    private com.baidu.mario.audio.a.a dbL;
    private long dbM;
    private com.baidu.swan.nalib.audio.b dbN = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dbL != null) {
                GameRecorderController.this.dbL.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dbM);
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
        this.dbI = aREngineDelegate;
        if (this.dbI != null) {
            this.dbK = RecorderState.IDLE;
            this.dbI.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.axF().axH().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dbN);
            }
        });
    }

    public void af(int i, String str) {
        if (this.dbI != null) {
            SwanAppActivity ahF = f.ahV().ahF();
            boolean z = ahF != null && ahF.isLandScape();
            this.dbI.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dbL = aVar;
                    GameRecorderController.this.dbM = System.nanoTime();
                    GameRecorderController.this.aBr();
                }
            });
            this.dbI.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        if (this.dbL != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dbL.a(true, audioParams);
        }
        fP(true);
    }

    private void fP(final boolean z) {
        com.baidu.swan.games.audio.b.b.axF().axH().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.dbL != null) {
            this.dbL.onAudioStop(true);
        }
        fP(false);
    }

    public void pauseRecord() {
        if (this.dbI != null) {
            this.dbI.pauseRecord();
        }
        fP(false);
    }

    public void resumeRecord() {
        if (this.dbI != null) {
            this.dbI.resumeRecord();
        }
        fP(true);
    }

    public void stopRecord() {
        if (this.dbI != null) {
            this.dbI.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dbI != null) {
            return this.dbI.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dbJ = cVar;
    }

    public RecorderState aBt() {
        return this.dbK;
    }

    public void release() {
        if (this.dbI != null && this.dbJ != null && (aBt() == RecorderState.RECORDING || aBt() == RecorderState.PAUSE)) {
            this.dbJ.onError(-1);
        }
        setGameRecordCallback(null);
        this.dbK = RecorderState.IDLE;
    }

    public static GameRecorderController aBu() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dbK = RecorderState.RECORDING;
            if (GameRecorderController.this.dbJ != null) {
                GameRecorderController.this.dbJ.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void F(int i, String str) {
            GameRecorderController.this.dbK = RecorderState.STOP;
            GameRecorderController.this.aBs();
            if (GameRecorderController.this.dbJ != null) {
                GameRecorderController.this.dbJ.F(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dbK = RecorderState.PAUSE;
            if (GameRecorderController.this.dbJ != null) {
                GameRecorderController.this.dbJ.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dbK = RecorderState.RECORDING;
            if (GameRecorderController.this.dbJ != null) {
                GameRecorderController.this.dbJ.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dbK = RecorderState.IDLE;
            if (GameRecorderController.this.dbJ != null) {
                GameRecorderController.this.dbJ.onError(i);
            }
        }
    }
}
