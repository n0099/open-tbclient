package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class GameRecorderController {
    private com.baidu.mario.audio.a.a cnA;
    private long cnB;
    private com.baidu.swan.nalib.audio.b cnC = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.cnA != null) {
                GameRecorderController.this.cnA.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.cnB);
            }
        }
    };
    private AREngineDelegate cnx;
    private com.baidu.mario.a.c cny;
    private RecorderState cnz;

    /* loaded from: classes10.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.cnx = aREngineDelegate;
        if (this.cnx != null) {
            this.cnz = RecorderState.IDLE;
            this.cnx.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.ajl().ajn().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.cnC);
            }
        });
    }

    public void I(int i, String str) {
        if (this.cnx != null) {
            SwanAppActivity Un = f.UC().Un();
            boolean z = Un != null && Un.isLandScape();
            this.cnx.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.cnA = aVar;
                    GameRecorderController.this.cnB = System.nanoTime();
                    GameRecorderController.this.amV();
                }
            });
            this.cnx.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amV() {
        if (this.cnA != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.cnA.a(true, audioParams);
        }
        ez(true);
    }

    private void ez(final boolean z) {
        com.baidu.swan.games.audio.b.b.ajl().ajn().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amW() {
        if (this.cnA != null) {
            this.cnA.onAudioStop(true);
        }
        ez(false);
    }

    public void pauseRecord() {
        if (this.cnx != null) {
            this.cnx.pauseRecord();
        }
        ez(false);
    }

    public void resumeRecord() {
        if (this.cnx != null) {
            this.cnx.resumeRecord();
        }
        ez(true);
    }

    public void stopRecord() {
        if (this.cnx != null) {
            this.cnx.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.cnx != null) {
            return this.cnx.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.cny = cVar;
    }

    public RecorderState amX() {
        return this.cnz;
    }

    public void release() {
        if (this.cnx != null && this.cny != null && (amX() == RecorderState.RECORDING || amX() == RecorderState.PAUSE)) {
            this.cny.onError(-1);
        }
        setGameRecordCallback(null);
        this.cnz = RecorderState.IDLE;
    }

    public static GameRecorderController amY() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes10.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.cnz = RecorderState.RECORDING;
            if (GameRecorderController.this.cny != null) {
                GameRecorderController.this.cny.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void p(int i, String str) {
            GameRecorderController.this.cnz = RecorderState.STOP;
            GameRecorderController.this.amW();
            if (GameRecorderController.this.cny != null) {
                GameRecorderController.this.cny.p(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.cnz = RecorderState.PAUSE;
            if (GameRecorderController.this.cny != null) {
                GameRecorderController.this.cny.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.cnz = RecorderState.RECORDING;
            if (GameRecorderController.this.cny != null) {
                GameRecorderController.this.cny.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.cnz = RecorderState.IDLE;
            if (GameRecorderController.this.cny != null) {
                GameRecorderController.this.cny.onError(i);
            }
        }
    }
}
