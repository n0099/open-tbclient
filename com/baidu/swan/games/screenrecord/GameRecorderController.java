package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private AREngineDelegate cQH;
    private com.baidu.mario.a.c cQI;
    private RecorderState cQJ;
    private com.baidu.mario.audio.a.a cQK;
    private long cQL;
    private com.baidu.swan.nalib.audio.b cQM = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.cQK != null) {
                GameRecorderController.this.cQK.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.cQL);
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
        this.cQH = aREngineDelegate;
        if (this.cQH != null) {
            this.cQJ = RecorderState.IDLE;
            this.cQH.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.atS().atU().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.cQM);
            }
        });
    }

    public void ab(int i, String str) {
        if (this.cQH != null) {
            SwanAppActivity aev = f.aeK().aev();
            boolean z = aev != null && aev.isLandScape();
            this.cQH.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.cQK = aVar;
                    GameRecorderController.this.cQL = System.nanoTime();
                    GameRecorderController.this.axA();
                }
            });
            this.cQH.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axA() {
        if (this.cQK != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.cQK.a(true, audioParams);
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
        if (this.cQK != null) {
            this.cQK.onAudioStop(true);
        }
        fE(false);
    }

    public void pauseRecord() {
        if (this.cQH != null) {
            this.cQH.pauseRecord();
        }
        fE(false);
    }

    public void resumeRecord() {
        if (this.cQH != null) {
            this.cQH.resumeRecord();
        }
        fE(true);
    }

    public void stopRecord() {
        if (this.cQH != null) {
            this.cQH.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.cQH != null) {
            return this.cQH.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.cQI = cVar;
    }

    public RecorderState axC() {
        return this.cQJ;
    }

    public void release() {
        if (this.cQH != null && this.cQI != null && (axC() == RecorderState.RECORDING || axC() == RecorderState.PAUSE)) {
            this.cQI.onError(-1);
        }
        setGameRecordCallback(null);
        this.cQJ = RecorderState.IDLE;
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
            GameRecorderController.this.cQJ = RecorderState.RECORDING;
            if (GameRecorderController.this.cQI != null) {
                GameRecorderController.this.cQI.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void F(int i, String str) {
            GameRecorderController.this.cQJ = RecorderState.STOP;
            GameRecorderController.this.axB();
            if (GameRecorderController.this.cQI != null) {
                GameRecorderController.this.cQI.F(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.cQJ = RecorderState.PAUSE;
            if (GameRecorderController.this.cQI != null) {
                GameRecorderController.this.cQI.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.cQJ = RecorderState.RECORDING;
            if (GameRecorderController.this.cQI != null) {
                GameRecorderController.this.cQI.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.cQJ = RecorderState.IDLE;
            if (GameRecorderController.this.cQI != null) {
                GameRecorderController.this.cQI.onError(i);
            }
        }
    }
}
