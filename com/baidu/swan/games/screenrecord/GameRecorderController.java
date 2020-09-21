package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class GameRecorderController {
    private AREngineDelegate dyo;
    private com.baidu.mario.a.c dyp;
    private RecorderState dyq;
    private com.baidu.mario.audio.a.a dyr;
    private long dys;
    private com.baidu.swan.nalib.audio.b dyt = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dyr != null) {
                GameRecorderController.this.dyr.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dys);
            }
        }
    };

    /* loaded from: classes3.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dyo = aREngineDelegate;
        if (this.dyo != null) {
            this.dyq = RecorderState.IDLE;
            this.dyo.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aLQ().aLS().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dyt);
            }
        });
    }

    public void ah(int i, String str) {
        if (this.dyo != null) {
            SwanAppActivity ast = f.asJ().ast();
            boolean z = ast != null && ast.isLandScape();
            this.dyo.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dyr = aVar;
                    GameRecorderController.this.dys = System.nanoTime();
                    GameRecorderController.this.aPG();
                }
            });
            this.dyo.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPG() {
        if (this.dyr != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dyr.a(true, audioParams);
        }
        gG(true);
    }

    private void gG(final boolean z) {
        com.baidu.swan.games.audio.b.b.aLQ().aLS().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPH() {
        if (this.dyr != null) {
            this.dyr.onAudioStop(true);
        }
        gG(false);
    }

    public void pauseRecord() {
        if (this.dyo != null) {
            this.dyo.pauseRecord();
        }
        gG(false);
    }

    public void resumeRecord() {
        if (this.dyo != null) {
            this.dyo.resumeRecord();
        }
        gG(true);
    }

    public void stopRecord() {
        if (this.dyo != null) {
            this.dyo.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dyo != null) {
            return this.dyo.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dyp = cVar;
    }

    public RecorderState aPI() {
        return this.dyq;
    }

    public void release() {
        if (this.dyo != null && this.dyp != null && (aPI() == RecorderState.RECORDING || aPI() == RecorderState.PAUSE)) {
            this.dyp.onError(-1);
        }
        setGameRecordCallback(null);
        this.dyq = RecorderState.IDLE;
    }

    public static GameRecorderController aPJ() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes3.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dyq = RecorderState.RECORDING;
            if (GameRecorderController.this.dyp != null) {
                GameRecorderController.this.dyp.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void H(int i, String str) {
            GameRecorderController.this.dyq = RecorderState.STOP;
            GameRecorderController.this.aPH();
            if (GameRecorderController.this.dyp != null) {
                GameRecorderController.this.dyp.H(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dyq = RecorderState.PAUSE;
            if (GameRecorderController.this.dyp != null) {
                GameRecorderController.this.dyp.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dyq = RecorderState.RECORDING;
            if (GameRecorderController.this.dyp != null) {
                GameRecorderController.this.dyp.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dyq = RecorderState.IDLE;
            if (GameRecorderController.this.dyp != null) {
                GameRecorderController.this.dyp.onError(i);
            }
        }
    }
}
