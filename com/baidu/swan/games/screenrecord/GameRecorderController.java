package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class GameRecorderController {
    private AREngineDelegate dme;
    private com.baidu.mario.a.c dmf;
    private RecorderState dmg;
    private com.baidu.mario.audio.a.a dmh;
    private long dmi;
    private com.baidu.swan.nalib.audio.b dmj = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.dmh != null) {
                GameRecorderController.this.dmh.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.dmi);
            }
        }
    };

    /* loaded from: classes7.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.dme = aREngineDelegate;
        if (this.dme != null) {
            this.dmg = RecorderState.IDLE;
            this.dme.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aCq().aCs().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.dmj);
            }
        });
    }

    public void ai(int i, String str) {
        if (this.dme != null) {
            SwanAppActivity akb = f.akr().akb();
            boolean z = akb != null && akb.isLandScape();
            this.dme.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.dmh = aVar;
                    GameRecorderController.this.dmi = System.nanoTime();
                    GameRecorderController.this.aGe();
                }
            });
            this.dme.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGe() {
        if (this.dmh != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.dmh.a(true, audioParams);
        }
        gl(true);
    }

    private void gl(final boolean z) {
        com.baidu.swan.games.audio.b.b.aCq().aCs().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGf() {
        if (this.dmh != null) {
            this.dmh.onAudioStop(true);
        }
        gl(false);
    }

    public void pauseRecord() {
        if (this.dme != null) {
            this.dme.pauseRecord();
        }
        gl(false);
    }

    public void resumeRecord() {
        if (this.dme != null) {
            this.dme.resumeRecord();
        }
        gl(true);
    }

    public void stopRecord() {
        if (this.dme != null) {
            this.dme.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.dme != null) {
            return this.dme.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.dmf = cVar;
    }

    public RecorderState aGg() {
        return this.dmg;
    }

    public void release() {
        if (this.dme != null && this.dmf != null && (aGg() == RecorderState.RECORDING || aGg() == RecorderState.PAUSE)) {
            this.dmf.onError(-1);
        }
        setGameRecordCallback(null);
        this.dmg = RecorderState.IDLE;
    }

    public static GameRecorderController aGh() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes7.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.dmg = RecorderState.RECORDING;
            if (GameRecorderController.this.dmf != null) {
                GameRecorderController.this.dmf.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void H(int i, String str) {
            GameRecorderController.this.dmg = RecorderState.STOP;
            GameRecorderController.this.aGf();
            if (GameRecorderController.this.dmf != null) {
                GameRecorderController.this.dmf.H(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.dmg = RecorderState.PAUSE;
            if (GameRecorderController.this.dmf != null) {
                GameRecorderController.this.dmf.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.dmg = RecorderState.RECORDING;
            if (GameRecorderController.this.dmf != null) {
                GameRecorderController.this.dmf.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.dmg = RecorderState.IDLE;
            if (GameRecorderController.this.dmf != null) {
                GameRecorderController.this.dmf.onError(i);
            }
        }
    }
}
