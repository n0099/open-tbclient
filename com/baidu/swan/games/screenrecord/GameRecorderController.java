package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class GameRecorderController {
    private AREngineDelegate cnj;
    private com.baidu.mario.a.c cnk;
    private RecorderState cnl;
    private com.baidu.mario.audio.a.a cnm;
    private long cnn;
    private com.baidu.swan.nalib.audio.b cno = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.cnm != null) {
                GameRecorderController.this.cnm.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.cnn);
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
        this.cnj = aREngineDelegate;
        if (this.cnj != null) {
            this.cnl = RecorderState.IDLE;
            this.cnj.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aiS().aiU().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.cno);
            }
        });
    }

    public void G(int i, String str) {
        if (this.cnj != null) {
            SwanAppActivity TQ = f.Uf().TQ();
            boolean z = TQ != null && TQ.isLandScape();
            this.cnj.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.cnm = aVar;
                    GameRecorderController.this.cnn = System.nanoTime();
                    GameRecorderController.this.amC();
                }
            });
            this.cnj.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amC() {
        if (this.cnm != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.cnm.a(true, audioParams);
        }
        eu(true);
    }

    private void eu(final boolean z) {
        com.baidu.swan.games.audio.b.b.aiS().aiU().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amD() {
        if (this.cnm != null) {
            this.cnm.onAudioStop(true);
        }
        eu(false);
    }

    public void pauseRecord() {
        if (this.cnj != null) {
            this.cnj.pauseRecord();
        }
        eu(false);
    }

    public void resumeRecord() {
        if (this.cnj != null) {
            this.cnj.resumeRecord();
        }
        eu(true);
    }

    public void stopRecord() {
        if (this.cnj != null) {
            this.cnj.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.cnj != null) {
            return this.cnj.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.cnk = cVar;
    }

    public RecorderState amE() {
        return this.cnl;
    }

    public void release() {
        if (this.cnj != null && this.cnk != null && (amE() == RecorderState.RECORDING || amE() == RecorderState.PAUSE)) {
            this.cnk.onError(-1);
        }
        setGameRecordCallback(null);
        this.cnl = RecorderState.IDLE;
    }

    public static GameRecorderController amF() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes9.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.cnl = RecorderState.RECORDING;
            if (GameRecorderController.this.cnk != null) {
                GameRecorderController.this.cnk.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void m(int i, String str) {
            GameRecorderController.this.cnl = RecorderState.STOP;
            GameRecorderController.this.amD();
            if (GameRecorderController.this.cnk != null) {
                GameRecorderController.this.cnk.m(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.cnl = RecorderState.PAUSE;
            if (GameRecorderController.this.cnk != null) {
                GameRecorderController.this.cnk.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.cnl = RecorderState.RECORDING;
            if (GameRecorderController.this.cnk != null) {
                GameRecorderController.this.cnk.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.cnl = RecorderState.IDLE;
            if (GameRecorderController.this.cnk != null) {
                GameRecorderController.this.cnk.onError(i);
            }
        }
    }
}
