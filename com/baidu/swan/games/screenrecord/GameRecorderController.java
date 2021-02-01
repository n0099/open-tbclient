package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class GameRecorderController {
    private AREngineDelegate ekn;
    private com.baidu.mario.a.c eko;
    private RecorderState ekp;
    private com.baidu.mario.audio.a.a ekq;
    private long ekr;
    private com.baidu.swan.nalib.audio.b eks = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.ekq != null) {
                GameRecorderController.this.ekq.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.ekr);
            }
        }
    };

    /* loaded from: classes9.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.ekn = aREngineDelegate;
        if (this.ekn != null) {
            this.ekp = RecorderState.IDLE;
            this.ekn.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aUd().aUf().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.eks);
            }
        });
    }

    public void aF(int i, String str) {
        if (this.ekn != null) {
            SwanAppActivity azV = f.aAl().azV();
            boolean z = azV != null && azV.isLandScape();
            this.ekn.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.ekq = aVar;
                    GameRecorderController.this.ekr = System.nanoTime();
                    GameRecorderController.this.aXT();
                }
            });
            this.ekn.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXT() {
        if (this.ekq != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.ekq.a(true, audioParams);
        }
        ig(true);
    }

    private void ig(final boolean z) {
        com.baidu.swan.games.audio.b.b.aUd().aUf().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXU() {
        if (this.ekq != null) {
            this.ekq.onAudioStop(true);
        }
        ig(false);
    }

    public void pauseRecord() {
        if (this.ekn != null) {
            this.ekn.pauseRecord();
        }
        ig(false);
    }

    public void resumeRecord() {
        if (this.ekn != null) {
            this.ekn.resumeRecord();
        }
        ig(true);
    }

    public void stopRecord() {
        if (this.ekn != null) {
            this.ekn.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.ekn != null) {
            return this.ekn.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.eko = cVar;
    }

    public RecorderState aXV() {
        return this.ekp;
    }

    public void release() {
        if (this.ekn != null && this.eko != null && (aXV() == RecorderState.RECORDING || aXV() == RecorderState.PAUSE)) {
            this.eko.onError(-1);
        }
        setGameRecordCallback(null);
        this.ekp = RecorderState.IDLE;
    }

    public static GameRecorderController aXW() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes9.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.ekp = RecorderState.RECORDING;
            if (GameRecorderController.this.eko != null) {
                GameRecorderController.this.eko.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void af(int i, String str) {
            GameRecorderController.this.ekp = RecorderState.STOP;
            GameRecorderController.this.aXU();
            if (GameRecorderController.this.eko != null) {
                GameRecorderController.this.eko.af(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.ekp = RecorderState.PAUSE;
            if (GameRecorderController.this.eko != null) {
                GameRecorderController.this.eko.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.ekp = RecorderState.RECORDING;
            if (GameRecorderController.this.eko != null) {
                GameRecorderController.this.eko.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.ekp = RecorderState.IDLE;
            if (GameRecorderController.this.eko != null) {
                GameRecorderController.this.eko.onError(i);
            }
        }
    }
}
