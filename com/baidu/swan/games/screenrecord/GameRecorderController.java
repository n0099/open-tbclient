package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class GameRecorderController {
    private com.baidu.swan.nalib.audio.b dgA = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dgy != null) {
                GameRecorderController.this.dgy.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dgz);
            }
        }
    };
    private AREngineDelegate dgv;
    private com.baidu.mario.a.c dgw;
    private RecorderState dgx;
    private com.baidu.mario.audio.a.a dgy;
    private long dgz;

    /* loaded from: classes11.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dgv = aREngineDelegate;
        if (this.dgv != null) {
            this.dgx = RecorderState.IDLE;
            this.dgv.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dgA);
            }
        });
    }

    public void ah(int i, String str) {
        if (this.dgv != null) {
            SwanAppActivity aiL = f.ajb().aiL();
            boolean z = aiL != null && aiL.isLandScape();
            this.dgv.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dgy = aVar;
                    GameRecorderController.this.dgz = System.nanoTime();
                    GameRecorderController.this.aCx();
                }
            });
            this.dgv.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCx() {
        if (this.dgy != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dgy.a(true, audioParams);
        }
        fU(true);
    }

    private void fU(final boolean z) {
        com.baidu.swan.games.audio.b.b.ayL().ayN().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCy() {
        if (this.dgy != null) {
            this.dgy.onAudioStop(true);
        }
        fU(false);
    }

    public void pauseRecord() {
        if (this.dgv != null) {
            this.dgv.pauseRecord();
        }
        fU(false);
    }

    public void resumeRecord() {
        if (this.dgv != null) {
            this.dgv.resumeRecord();
        }
        fU(true);
    }

    public void stopRecord() {
        if (this.dgv != null) {
            this.dgv.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dgv != null) {
            return this.dgv.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dgw = cVar;
    }

    public RecorderState aCz() {
        return this.dgx;
    }

    public void release() {
        if (this.dgv != null && this.dgw != null && (aCz() == RecorderState.RECORDING || aCz() == RecorderState.PAUSE)) {
            this.dgw.onError(-1);
        }
        setGameRecordCallback(null);
        this.dgx = RecorderState.IDLE;
    }

    public static GameRecorderController aCA() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes11.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dgx = RecorderState.RECORDING;
            if (GameRecorderController.this.dgw != null) {
                GameRecorderController.this.dgw.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void H(int i, String str) {
            GameRecorderController.this.dgx = RecorderState.STOP;
            GameRecorderController.this.aCy();
            if (GameRecorderController.this.dgw != null) {
                GameRecorderController.this.dgw.H(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dgx = RecorderState.PAUSE;
            if (GameRecorderController.this.dgw != null) {
                GameRecorderController.this.dgw.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dgx = RecorderState.RECORDING;
            if (GameRecorderController.this.dgw != null) {
                GameRecorderController.this.dgw.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dgx = RecorderState.IDLE;
            if (GameRecorderController.this.dgw != null) {
                GameRecorderController.this.dgw.onError(i);
            }
        }
    }
}
