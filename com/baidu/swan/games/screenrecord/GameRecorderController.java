package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class GameRecorderController {
    private AREngineDelegate dwn;
    private com.baidu.mario.a.c dwo;
    private RecorderState dwp;
    private com.baidu.mario.audio.a.a dwq;
    private long dwr;
    private com.baidu.swan.nalib.audio.b dws = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dwq != null) {
                GameRecorderController.this.dwq.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dwr);
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
        this.dwn = aREngineDelegate;
        if (this.dwn != null) {
            this.dwp = RecorderState.IDLE;
            this.dwn.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aLf().aLh().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dws);
            }
        });
    }

    public void ag(int i, String str) {
        if (this.dwn != null) {
            SwanAppActivity arI = f.arY().arI();
            boolean z = arI != null && arI.isLandScape();
            this.dwn.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dwq = aVar;
                    GameRecorderController.this.dwr = System.nanoTime();
                    GameRecorderController.this.aOV();
                }
            });
            this.dwn.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        if (this.dwq != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dwq.a(true, audioParams);
        }
        gI(true);
    }

    private void gI(final boolean z) {
        com.baidu.swan.games.audio.b.b.aLf().aLh().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOW() {
        if (this.dwq != null) {
            this.dwq.onAudioStop(true);
        }
        gI(false);
    }

    public void pauseRecord() {
        if (this.dwn != null) {
            this.dwn.pauseRecord();
        }
        gI(false);
    }

    public void resumeRecord() {
        if (this.dwn != null) {
            this.dwn.resumeRecord();
        }
        gI(true);
    }

    public void stopRecord() {
        if (this.dwn != null) {
            this.dwn.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dwn != null) {
            return this.dwn.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dwo = cVar;
    }

    public RecorderState aOX() {
        return this.dwp;
    }

    public void release() {
        if (this.dwn != null && this.dwo != null && (aOX() == RecorderState.RECORDING || aOX() == RecorderState.PAUSE)) {
            this.dwo.onError(-1);
        }
        setGameRecordCallback(null);
        this.dwp = RecorderState.IDLE;
    }

    public static GameRecorderController aOY() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes8.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dwp = RecorderState.RECORDING;
            if (GameRecorderController.this.dwo != null) {
                GameRecorderController.this.dwo.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void G(int i, String str) {
            GameRecorderController.this.dwp = RecorderState.STOP;
            GameRecorderController.this.aOW();
            if (GameRecorderController.this.dwo != null) {
                GameRecorderController.this.dwo.G(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dwp = RecorderState.PAUSE;
            if (GameRecorderController.this.dwo != null) {
                GameRecorderController.this.dwo.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dwp = RecorderState.RECORDING;
            if (GameRecorderController.this.dwo != null) {
                GameRecorderController.this.dwo.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dwp = RecorderState.IDLE;
            if (GameRecorderController.this.dwo != null) {
                GameRecorderController.this.dwo.onError(i);
            }
        }
    }
}
