package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class GameRecorderController {
    private AREngineDelegate eig;
    private com.baidu.mario.a.c eih;
    private RecorderState eii;
    private com.baidu.mario.audio.a.a eij;
    private long eik;
    private com.baidu.swan.nalib.audio.b eil = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.eij != null) {
                GameRecorderController.this.eij.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.eik);
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
        this.eig = aREngineDelegate;
        if (this.eig != null) {
            this.eii = RecorderState.IDLE;
            this.eig.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aTR().aTT().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.eil);
            }
        });
    }

    public void aB(int i, String str) {
        if (this.eig != null) {
            SwanAppActivity azx = f.azN().azx();
            boolean z = azx != null && azx.isLandScape();
            this.eig.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.eij = aVar;
                    GameRecorderController.this.eik = System.nanoTime();
                    GameRecorderController.this.aXH();
                }
            });
            this.eig.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXH() {
        if (this.eij != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.eij.a(true, audioParams);
        }
        ie(true);
    }

    private void ie(final boolean z) {
        com.baidu.swan.games.audio.b.b.aTR().aTT().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXI() {
        if (this.eij != null) {
            this.eij.onAudioStop(true);
        }
        ie(false);
    }

    public void pauseRecord() {
        if (this.eig != null) {
            this.eig.pauseRecord();
        }
        ie(false);
    }

    public void resumeRecord() {
        if (this.eig != null) {
            this.eig.resumeRecord();
        }
        ie(true);
    }

    public void stopRecord() {
        if (this.eig != null) {
            this.eig.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.eig != null) {
            return this.eig.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.eih = cVar;
    }

    public RecorderState aXJ() {
        return this.eii;
    }

    public void release() {
        if (this.eig != null && this.eih != null && (aXJ() == RecorderState.RECORDING || aXJ() == RecorderState.PAUSE)) {
            this.eih.onError(-1);
        }
        setGameRecordCallback(null);
        this.eii = RecorderState.IDLE;
    }

    public static GameRecorderController aXK() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes8.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.eii = RecorderState.RECORDING;
            if (GameRecorderController.this.eih != null) {
                GameRecorderController.this.eih.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void ab(int i, String str) {
            GameRecorderController.this.eii = RecorderState.STOP;
            GameRecorderController.this.aXI();
            if (GameRecorderController.this.eih != null) {
                GameRecorderController.this.eih.ab(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.eii = RecorderState.PAUSE;
            if (GameRecorderController.this.eih != null) {
                GameRecorderController.this.eih.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.eii = RecorderState.RECORDING;
            if (GameRecorderController.this.eih != null) {
                GameRecorderController.this.eih.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.eii = RecorderState.IDLE;
            if (GameRecorderController.this.eih != null) {
                GameRecorderController.this.eih.onError(i);
            }
        }
    }
}
