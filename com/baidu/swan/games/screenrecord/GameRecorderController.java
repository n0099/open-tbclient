package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class GameRecorderController {
    private AREngineDelegate dSM;
    private com.baidu.mario.a.c dSN;
    private RecorderState dSO;
    private com.baidu.mario.audio.a.a dSP;
    private long dSQ;
    private com.baidu.swan.nalib.audio.b dSR = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dSP != null) {
                GameRecorderController.this.dSP.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dSQ);
            }
        }
    };

    /* loaded from: classes10.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dSM = aREngineDelegate;
        if (this.dSM != null) {
            this.dSO = RecorderState.IDLE;
            this.dSM.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aQt().aQv().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dSR);
            }
        });
    }

    public void au(int i, String str) {
        if (this.dSM != null) {
            SwanAppActivity awY = f.axo().awY();
            boolean z = awY != null && awY.isLandScape();
            this.dSM.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dSP = aVar;
                    GameRecorderController.this.dSQ = System.nanoTime();
                    GameRecorderController.this.aUj();
                }
            });
            this.dSM.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUj() {
        if (this.dSP != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dSP.a(true, audioParams);
        }
        hp(true);
    }

    private void hp(final boolean z) {
        com.baidu.swan.games.audio.b.b.aQt().aQv().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUk() {
        if (this.dSP != null) {
            this.dSP.onAudioStop(true);
        }
        hp(false);
    }

    public void pauseRecord() {
        if (this.dSM != null) {
            this.dSM.pauseRecord();
        }
        hp(false);
    }

    public void resumeRecord() {
        if (this.dSM != null) {
            this.dSM.resumeRecord();
        }
        hp(true);
    }

    public void stopRecord() {
        if (this.dSM != null) {
            this.dSM.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dSM != null) {
            return this.dSM.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dSN = cVar;
    }

    public RecorderState aUl() {
        return this.dSO;
    }

    public void release() {
        if (this.dSM != null && this.dSN != null && (aUl() == RecorderState.RECORDING || aUl() == RecorderState.PAUSE)) {
            this.dSN.onError(-1);
        }
        setGameRecordCallback(null);
        this.dSO = RecorderState.IDLE;
    }

    public static GameRecorderController aUm() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes10.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dSO = RecorderState.RECORDING;
            if (GameRecorderController.this.dSN != null) {
                GameRecorderController.this.dSN.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void U(int i, String str) {
            GameRecorderController.this.dSO = RecorderState.STOP;
            GameRecorderController.this.aUk();
            if (GameRecorderController.this.dSN != null) {
                GameRecorderController.this.dSN.U(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dSO = RecorderState.PAUSE;
            if (GameRecorderController.this.dSN != null) {
                GameRecorderController.this.dSN.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dSO = RecorderState.RECORDING;
            if (GameRecorderController.this.dSN != null) {
                GameRecorderController.this.dSN.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dSO = RecorderState.IDLE;
            if (GameRecorderController.this.dSN != null) {
                GameRecorderController.this.dSN.onError(i);
            }
        }
    }
}
