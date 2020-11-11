package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class GameRecorderController {
    private AREngineDelegate dYE;
    private com.baidu.mario.a.c dYF;
    private RecorderState dYG;
    private com.baidu.mario.audio.a.a dYH;
    private long dYI;
    private com.baidu.swan.nalib.audio.b dYJ = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dYH != null) {
                GameRecorderController.this.dYH.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dYI);
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
        this.dYE = aREngineDelegate;
        if (this.dYE != null) {
            this.dYG = RecorderState.IDLE;
            this.dYE.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aST().aSV().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dYJ);
            }
        });
    }

    public void ay(int i, String str) {
        if (this.dYE != null) {
            SwanAppActivity azy = f.azO().azy();
            boolean z = azy != null && azy.isLandScape();
            this.dYE.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dYH = aVar;
                    GameRecorderController.this.dYI = System.nanoTime();
                    GameRecorderController.this.aWJ();
                }
            });
            this.dYE.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWJ() {
        if (this.dYH != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dYH.a(true, audioParams);
        }
        hy(true);
    }

    private void hy(final boolean z) {
        com.baidu.swan.games.audio.b.b.aST().aSV().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWK() {
        if (this.dYH != null) {
            this.dYH.onAudioStop(true);
        }
        hy(false);
    }

    public void pauseRecord() {
        if (this.dYE != null) {
            this.dYE.pauseRecord();
        }
        hy(false);
    }

    public void resumeRecord() {
        if (this.dYE != null) {
            this.dYE.resumeRecord();
        }
        hy(true);
    }

    public void stopRecord() {
        if (this.dYE != null) {
            this.dYE.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dYE != null) {
            return this.dYE.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dYF = cVar;
    }

    public RecorderState aWL() {
        return this.dYG;
    }

    public void release() {
        if (this.dYE != null && this.dYF != null && (aWL() == RecorderState.RECORDING || aWL() == RecorderState.PAUSE)) {
            this.dYF.onError(-1);
        }
        setGameRecordCallback(null);
        this.dYG = RecorderState.IDLE;
    }

    public static GameRecorderController aWM() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes10.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dYG = RecorderState.RECORDING;
            if (GameRecorderController.this.dYF != null) {
                GameRecorderController.this.dYF.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void Y(int i, String str) {
            GameRecorderController.this.dYG = RecorderState.STOP;
            GameRecorderController.this.aWK();
            if (GameRecorderController.this.dYF != null) {
                GameRecorderController.this.dYF.Y(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dYG = RecorderState.PAUSE;
            if (GameRecorderController.this.dYF != null) {
                GameRecorderController.this.dYF.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dYG = RecorderState.RECORDING;
            if (GameRecorderController.this.dYF != null) {
                GameRecorderController.this.dYF.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dYG = RecorderState.IDLE;
            if (GameRecorderController.this.dYF != null) {
                GameRecorderController.this.dYF.onError(i);
            }
        }
    }
}
