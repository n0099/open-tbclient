package com.baidu.swan.games.screenrecord;

import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class GameRecorderController {
    private AREngineDelegate bkO;
    private com.baidu.mario.b.b bkP;
    private RecorderState bkQ;

    /* loaded from: classes2.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.bkO = aREngineDelegate;
        if (this.bkO != null) {
            this.bkQ = RecorderState.IDLE;
            this.bkO.setGameRecordCallback(new a());
        }
    }

    public void a(boolean z, int i, String str) {
        if (this.bkO != null) {
            SwanAppActivity Gv = e.GJ().Gv();
            this.bkO.startRecord(z, i, str, Gv != null && Gv.isLandScape());
        }
    }

    public void pauseRecord() {
        if (this.bkO != null) {
            this.bkO.pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.bkO != null) {
            this.bkO.resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.bkO != null) {
            this.bkO.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.bkO != null) {
            return this.bkO.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        this.bkP = bVar;
    }

    public RecorderState SV() {
        return this.bkQ;
    }

    public void release() {
        if (this.bkO != null && this.bkP != null && (SV() == RecorderState.RECORDING || SV() == RecorderState.PAUSE)) {
            this.bkP.onError(-1);
        }
        setGameRecordCallback(null);
        this.bkQ = RecorderState.IDLE;
    }

    public static GameRecorderController SW() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.mario.b.b {
        private a() {
        }

        @Override // com.baidu.mario.b.b
        public void onStart() {
            GameRecorderController.this.bkQ = RecorderState.RECORDING;
            if (GameRecorderController.this.bkP != null) {
                GameRecorderController.this.bkP.onStart();
            }
        }

        @Override // com.baidu.mario.b.b
        public void h(int i, String str) {
            GameRecorderController.this.bkQ = RecorderState.STOP;
            if (GameRecorderController.this.bkP != null) {
                GameRecorderController.this.bkP.h(i, str);
            }
        }

        @Override // com.baidu.mario.b.b
        public void onPause() {
            GameRecorderController.this.bkQ = RecorderState.PAUSE;
            if (GameRecorderController.this.bkP != null) {
                GameRecorderController.this.bkP.onPause();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onResume() {
            GameRecorderController.this.bkQ = RecorderState.RECORDING;
            if (GameRecorderController.this.bkP != null) {
                GameRecorderController.this.bkP.onResume();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onError(int i) {
            GameRecorderController.this.bkQ = RecorderState.IDLE;
            if (GameRecorderController.this.bkP != null) {
                GameRecorderController.this.bkP.onError(i);
            }
        }
    }
}
