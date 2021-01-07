package com.baidu.swan.games.screenrecord;

import com.baidu.mario.audio.AudioParams;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class GameRecorderController {
    private AREngineDelegate emS;
    private com.baidu.mario.a.c emT;
    private RecorderState emU;
    private com.baidu.mario.audio.a.a emV;
    private long emW;
    private com.baidu.swan.nalib.audio.b emX = new com.baidu.swan.nalib.audio.b() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.1
        @Override // com.baidu.swan.nalib.audio.b
        public void a(com.baidu.swan.nalib.audio.a aVar) {
            if (GameRecorderController.this.emV != null) {
                GameRecorderController.this.emV.onAudioFrameAvailable(ByteBuffer.wrap(aVar.data), (int) aVar.size, aVar.time - GameRecorderController.this.emW);
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
        this.emS = aREngineDelegate;
        if (this.emS != null) {
            this.emU = RecorderState.IDLE;
            this.emS.setGameRecordCallback(new a());
        }
        com.baidu.swan.games.audio.b.b.aXL().aXN().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.2
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setOnAudioRecordListener(GameRecorderController.this.emX);
            }
        });
    }

    public void aA(int i, String str) {
        if (this.emS != null) {
            SwanAppActivity aDr = f.aDH().aDr();
            boolean z = aDr != null && aDr.isLandScape();
            this.emS.setAudioEngineProxy(new com.baidu.mario.a.a() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.3
                @Override // com.baidu.mario.a.a
                public void a(com.baidu.mario.audio.a.a aVar) {
                    GameRecorderController.this.emV = aVar;
                    GameRecorderController.this.emW = System.nanoTime();
                    GameRecorderController.this.bbB();
                }
            });
            this.emS.startRecord(true, i, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbB() {
        if (this.emV != null) {
            int i = SwanAudioPlayer.mSampleRate;
            int i2 = SwanAudioPlayer.mSampleBufSize;
            AudioParams audioParams = new AudioParams();
            audioParams.setSampleRate(i * 2);
            audioParams.setAudioBufferSize(i2 * 2);
            audioParams.setChannelConfig(1);
            this.emV.a(true, audioParams);
        }
        ii(true);
    }

    private void ii(final boolean z) {
        com.baidu.swan.games.audio.b.b.aXL().aXN().post(new Runnable() { // from class: com.baidu.swan.games.screenrecord.GameRecorderController.4
            @Override // java.lang.Runnable
            public void run() {
                SwanAudioPlayer.getInstance().setAudioRecord(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbC() {
        if (this.emV != null) {
            this.emV.onAudioStop(true);
        }
        ii(false);
    }

    public void pauseRecord() {
        if (this.emS != null) {
            this.emS.pauseRecord();
        }
        ii(false);
    }

    public void resumeRecord() {
        if (this.emS != null) {
            this.emS.resumeRecord();
        }
        ii(true);
    }

    public void stopRecord() {
        if (this.emS != null) {
            this.emS.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.emS != null) {
            return this.emS.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.a.c cVar) {
        this.emT = cVar;
    }

    public RecorderState bbD() {
        return this.emU;
    }

    public void release() {
        if (this.emS != null && this.emT != null && (bbD() == RecorderState.RECORDING || bbD() == RecorderState.PAUSE)) {
            this.emT.onError(-1);
        }
        setGameRecordCallback(null);
        this.emU = RecorderState.IDLE;
    }

    public static GameRecorderController bbE() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes9.dex */
    private class a implements com.baidu.mario.a.c {
        private a() {
        }

        @Override // com.baidu.mario.a.c
        public void onStart() {
            GameRecorderController.this.emU = RecorderState.RECORDING;
            if (GameRecorderController.this.emT != null) {
                GameRecorderController.this.emT.onStart();
            }
        }

        @Override // com.baidu.mario.a.c
        public void aa(int i, String str) {
            GameRecorderController.this.emU = RecorderState.STOP;
            GameRecorderController.this.bbC();
            if (GameRecorderController.this.emT != null) {
                GameRecorderController.this.emT.aa(i, str);
            }
        }

        @Override // com.baidu.mario.a.c
        public void onPause() {
            GameRecorderController.this.emU = RecorderState.PAUSE;
            if (GameRecorderController.this.emT != null) {
                GameRecorderController.this.emT.onPause();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onResume() {
            GameRecorderController.this.emU = RecorderState.RECORDING;
            if (GameRecorderController.this.emT != null) {
                GameRecorderController.this.emT.onResume();
            }
        }

        @Override // com.baidu.mario.a.c
        public void onError(int i) {
            GameRecorderController.this.emU = RecorderState.IDLE;
            if (GameRecorderController.this.emT != null) {
                GameRecorderController.this.emT.onError(i);
            }
        }
    }
}
