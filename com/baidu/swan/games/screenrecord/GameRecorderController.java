package com.baidu.swan.games.screenrecord;

import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class GameRecorderController {
    private AREngineDelegate bkq;
    private com.baidu.mario.b.b bkr;
    private RecorderState bks;

    /* loaded from: classes2.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.bkq = aREngineDelegate;
        if (this.bkq != null) {
            this.bks = RecorderState.IDLE;
            this.bkq.setGameRecordCallback(new a());
        }
    }

    public void a(boolean z, int i, String str) {
        if (this.bkq != null) {
            SwanAppActivity Gr = e.GF().Gr();
            this.bkq.startRecord(z, i, str, Gr != null && Gr.isLandScape());
        }
    }

    public void pauseRecord() {
        if (this.bkq != null) {
            this.bkq.pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.bkq != null) {
            this.bkq.resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.bkq != null) {
            this.bkq.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.bkq != null) {
            return this.bkq.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        this.bkr = bVar;
    }

    public RecorderState SR() {
        return this.bks;
    }

    public void release() {
        if (this.bkq != null && this.bkr != null && (SR() == RecorderState.RECORDING || SR() == RecorderState.PAUSE)) {
            this.bkr.onError(-1);
        }
        setGameRecordCallback(null);
        this.bks = RecorderState.IDLE;
    }

    public static GameRecorderController SS() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.mario.b.b {
        private a() {
        }

        @Override // com.baidu.mario.b.b
        public void onStart() {
            GameRecorderController.this.bks = RecorderState.RECORDING;
            if (GameRecorderController.this.bkr != null) {
                GameRecorderController.this.bkr.onStart();
            }
        }

        @Override // com.baidu.mario.b.b
        public void h(int i, String str) {
            GameRecorderController.this.bks = RecorderState.STOP;
            if (GameRecorderController.this.bkr != null) {
                GameRecorderController.this.bkr.h(i, str);
            }
        }

        @Override // com.baidu.mario.b.b
        public void onPause() {
            GameRecorderController.this.bks = RecorderState.PAUSE;
            if (GameRecorderController.this.bkr != null) {
                GameRecorderController.this.bkr.onPause();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onResume() {
            GameRecorderController.this.bks = RecorderState.RECORDING;
            if (GameRecorderController.this.bkr != null) {
                GameRecorderController.this.bkr.onResume();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onError(int i) {
            GameRecorderController.this.bks = RecorderState.IDLE;
            if (GameRecorderController.this.bkr != null) {
                GameRecorderController.this.bkr.onError(i);
            }
        }
    }
}
