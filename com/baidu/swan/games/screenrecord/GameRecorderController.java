package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private com.baidu.mario.a.c crA;
    private RecorderState crB;
    private com.baidu.mario.audio.a.a crC;
    private long crD;
    private com.baidu.swan.nalib.audio.b crE = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.crC != null) {
                GameRecorderController.this.crC.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.crD);
            }
        }
    };
    private AREngineDelegate crz;

    /* loaded from: classes11.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.crz = aREngineDelegate;
        if (this.crz != null) {
            this.crB = RecorderState.IDLE;
            this.crz.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.alz().alB().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.crE);
            }
        });
    }

    public void K(int i, String str) {
        if (this.crz != null) {
            SwanAppActivity WB = f.WQ().WB();
            boolean z = WB != null && WB.isLandScape();
            this.crz.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.crC = aVar;
                    GameRecorderController.this.crD = System.nanoTime();
                    GameRecorderController.this.apj();
                }
            });
            this.crz.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apj() {
        if (this.crC != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.crC.a(true, audioParams);
        }
        eG(true);
    }

    private void eG(final boolean z) {
        com.baidu.swan.games.audio.b.b.alz().alB().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apk() {
        if (this.crC != null) {
            this.crC.onAudioStop(true);
        }
        eG(false);
    }

    public void pauseRecord() {
        if (this.crz != null) {
            this.crz.pauseRecord();
        }
        eG(false);
    }

    public void resumeRecord() {
        if (this.crz != null) {
            this.crz.resumeRecord();
        }
        eG(true);
    }

    public void stopRecord() {
        if (this.crz != null) {
            this.crz.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.crz != null) {
            return this.crz.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.crA = cVar;
    }

    public RecorderState apl() {
        return this.crB;
    }

    public void release() {
        if (this.crz != null && this.crA != null && (apl() == RecorderState.RECORDING || apl() == RecorderState.PAUSE)) {
            this.crA.onError(-1);
        }
        setGameRecordCallback(null);
        this.crB = RecorderState.IDLE;
    }

    public static GameRecorderController apm() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.crB = RecorderState.RECORDING;
            if (GameRecorderController.this.crA != null) {
                GameRecorderController.this.crA.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void q(int i, String str) {
            GameRecorderController.this.crB = RecorderState.STOP;
            GameRecorderController.this.apk();
            if (GameRecorderController.this.crA != null) {
                GameRecorderController.this.crA.q(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.crB = RecorderState.PAUSE;
            if (GameRecorderController.this.crA != null) {
                GameRecorderController.this.crA.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.crB = RecorderState.RECORDING;
            if (GameRecorderController.this.crA != null) {
                GameRecorderController.this.crA.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.crB = RecorderState.IDLE;
            if (GameRecorderController.this.crA != null) {
                GameRecorderController.this.crA.onError(i);
            }
        }
    }
}
