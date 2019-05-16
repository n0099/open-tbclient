package com.baidu.swan.games.screenrecord;

import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class GameRecorderController {
    private AREngineDelegate bjD;
    private com.baidu.mario.b.b bjE;
    private RecorderState bjF;

    /* loaded from: classes2.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.bjD = aREngineDelegate;
        if (this.bjD != null) {
            this.bjF = RecorderState.IDLE;
            this.bjD.setGameRecordCallback(new a());
        }
    }

    public void a(boolean z, int i, String str) {
        if (this.bjD != null) {
            SwanAppActivity FH = e.FV().FH();
            this.bjD.startRecord(z, i, str, FH != null && FH.isLandScape());
        }
    }

    public void pauseRecord() {
        if (this.bjD != null) {
            this.bjD.pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.bjD != null) {
            this.bjD.resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.bjD != null) {
            this.bjD.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.bjD != null) {
            return this.bjD.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        this.bjE = bVar;
    }

    public RecorderState RY() {
        return this.bjF;
    }

    public void release() {
        if (this.bjD != null && this.bjE != null && (RY() == RecorderState.RECORDING || RY() == RecorderState.PAUSE)) {
            this.bjE.onError(-1);
        }
        setGameRecordCallback(null);
        this.bjF = RecorderState.IDLE;
    }

    public static GameRecorderController RZ() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.mario.b.b {
        private a() {
        }

        @Override // com.baidu.mario.b.b
        public void onStart() {
            GameRecorderController.this.bjF = RecorderState.RECORDING;
            if (GameRecorderController.this.bjE != null) {
                GameRecorderController.this.bjE.onStart();
            }
        }

        @Override // com.baidu.mario.b.b
        public void h(int i, String str) {
            GameRecorderController.this.bjF = RecorderState.STOP;
            if (GameRecorderController.this.bjE != null) {
                GameRecorderController.this.bjE.h(i, str);
            }
        }

        @Override // com.baidu.mario.b.b
        public void onPause() {
            GameRecorderController.this.bjF = RecorderState.PAUSE;
            if (GameRecorderController.this.bjE != null) {
                GameRecorderController.this.bjE.onPause();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onResume() {
            GameRecorderController.this.bjF = RecorderState.RECORDING;
            if (GameRecorderController.this.bjE != null) {
                GameRecorderController.this.bjE.onResume();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onError(int i) {
            GameRecorderController.this.bjF = RecorderState.IDLE;
            if (GameRecorderController.this.bjE != null) {
                GameRecorderController.this.bjE.onError(i);
            }
        }
    }
}
