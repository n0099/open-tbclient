package com.baidu.swan.games.screenrecord;

import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class GameRecorderController {
    private AREngineDelegate bDC;
    private com.baidu.mario.b.b bDD;
    private RecorderState bDE;

    /* loaded from: classes2.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.bDC = aREngineDelegate;
        if (this.bDC != null) {
            this.bDE = RecorderState.IDLE;
            this.bDC.setGameRecordCallback(new a());
        }
    }

    public void a(boolean z, int i, String str) {
        if (this.bDC != null) {
            SwanAppActivity Lp = e.LD().Lp();
            this.bDC.startRecord(z, i, str, Lp != null && Lp.isLandScape());
        }
    }

    public void pauseRecord() {
        if (this.bDC != null) {
            this.bDC.pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.bDC != null) {
            this.bDC.resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.bDC != null) {
            this.bDC.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.bDC != null) {
            return this.bDC.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        this.bDD = bVar;
    }

    public RecorderState XM() {
        return this.bDE;
    }

    public void release() {
        if (this.bDC != null && this.bDD != null && (XM() == RecorderState.RECORDING || XM() == RecorderState.PAUSE)) {
            this.bDD.onError(-1);
        }
        setGameRecordCallback(null);
        this.bDE = RecorderState.IDLE;
    }

    public static GameRecorderController XN() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.mario.b.b {
        private a() {
        }

        @Override // com.baidu.mario.b.b
        public void onStart() {
            GameRecorderController.this.bDE = RecorderState.RECORDING;
            if (GameRecorderController.this.bDD != null) {
                GameRecorderController.this.bDD.onStart();
            }
        }

        @Override // com.baidu.mario.b.b
        public void l(int i, String str) {
            GameRecorderController.this.bDE = RecorderState.STOP;
            if (GameRecorderController.this.bDD != null) {
                GameRecorderController.this.bDD.l(i, str);
            }
        }

        @Override // com.baidu.mario.b.b
        public void onPause() {
            GameRecorderController.this.bDE = RecorderState.PAUSE;
            if (GameRecorderController.this.bDD != null) {
                GameRecorderController.this.bDD.onPause();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onResume() {
            GameRecorderController.this.bDE = RecorderState.RECORDING;
            if (GameRecorderController.this.bDD != null) {
                GameRecorderController.this.bDD.onResume();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onError(int i) {
            GameRecorderController.this.bDE = RecorderState.IDLE;
            if (GameRecorderController.this.bDD != null) {
                GameRecorderController.this.bDD.onError(i);
            }
        }
    }
}
