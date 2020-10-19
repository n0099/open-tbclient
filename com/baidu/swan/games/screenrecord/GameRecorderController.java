package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class GameRecorderController {
    private AREngineDelegate dKp;
    private com.baidu.mario.a.c dKq;
    private RecorderState dKr;
    private com.baidu.mario.audio.a.a dKs;
    private long dKt;
    private com.baidu.swan.nalib.audio.b dKu = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dKs != null) {
                GameRecorderController.this.dKs.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dKt);
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
        this.dKp = aREngineDelegate;
        if (this.dKp != null) {
            this.dKr = RecorderState.IDLE;
            this.dKp.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aOz().aOB().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dKu);
            }
        });
    }

    public void as(int i, String str) {
        if (this.dKp != null) {
            SwanAppActivity ave = f.avu().ave();
            boolean z = ave != null && ave.isLandScape();
            this.dKp.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dKs = aVar;
                    GameRecorderController.this.dKt = System.nanoTime();
                    GameRecorderController.this.aSp();
                }
            });
            this.dKp.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSp() {
        if (this.dKs != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dKs.a(true, audioParams);
        }
        hc(true);
    }

    private void hc(final boolean z) {
        com.baidu.swan.games.audio.b.b.aOz().aOB().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSq() {
        if (this.dKs != null) {
            this.dKs.onAudioStop(true);
        }
        hc(false);
    }

    public void pauseRecord() {
        if (this.dKp != null) {
            this.dKp.pauseRecord();
        }
        hc(false);
    }

    public void resumeRecord() {
        if (this.dKp != null) {
            this.dKp.resumeRecord();
        }
        hc(true);
    }

    public void stopRecord() {
        if (this.dKp != null) {
            this.dKp.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dKp != null) {
            return this.dKp.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dKq = cVar;
    }

    public RecorderState aSr() {
        return this.dKr;
    }

    public void release() {
        if (this.dKp != null && this.dKq != null && (aSr() == RecorderState.RECORDING || aSr() == RecorderState.PAUSE)) {
            this.dKq.onError(-1);
        }
        setGameRecordCallback(null);
        this.dKr = RecorderState.IDLE;
    }

    public static GameRecorderController aSs() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes10.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dKr = RecorderState.RECORDING;
            if (GameRecorderController.this.dKq != null) {
                GameRecorderController.this.dKq.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void S(int i, String str) {
            GameRecorderController.this.dKr = RecorderState.STOP;
            GameRecorderController.this.aSq();
            if (GameRecorderController.this.dKq != null) {
                GameRecorderController.this.dKq.S(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dKr = RecorderState.PAUSE;
            if (GameRecorderController.this.dKq != null) {
                GameRecorderController.this.dKq.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dKr = RecorderState.RECORDING;
            if (GameRecorderController.this.dKq != null) {
                GameRecorderController.this.dKq.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dKr = RecorderState.IDLE;
            if (GameRecorderController.this.dKq != null) {
                GameRecorderController.this.dKq.onError(i);
            }
        }
    }
}
