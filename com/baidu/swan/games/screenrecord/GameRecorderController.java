package com.baidu.swan.games.screenrecord;

import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.w.e;
/* loaded from: classes2.dex */
public class GameRecorderController {
    private AREngineDelegate bCL;
    private com.baidu.mario.b.b bCM;
    private RecorderState bCN;

    /* loaded from: classes2.dex */
    public enum RecorderState {
        IDLE,
        RECORDING,
        PAUSE,
        STOP
    }

    public GameRecorderController(AREngineDelegate aREngineDelegate) {
        this.bCL = aREngineDelegate;
        if (this.bCL != null) {
            this.bCN = RecorderState.IDLE;
            this.bCL.setGameRecordCallback(new a());
        }
    }

    public void a(boolean z, int i, String str) {
        if (this.bCL != null) {
            SwanAppActivity Lq = e.LE().Lq();
            this.bCL.startRecord(z, i, str, Lq != null && Lq.isLandScape());
        }
    }

    public void pauseRecord() {
        if (this.bCL != null) {
            this.bCL.pauseRecord();
        }
    }

    public void resumeRecord() {
        if (this.bCL != null) {
            this.bCL.resumeRecord();
        }
    }

    public void stopRecord() {
        if (this.bCL != null) {
            this.bCL.stopRecord();
        }
    }

    public long getCurrentRecordProcess() {
        if (this.bCL != null) {
            return this.bCL.getCurrentRecordProcess();
        }
        return 0L;
    }

    public void setGameRecordCallback(com.baidu.mario.b.b bVar) {
        this.bCM = bVar;
    }

    public RecorderState XK() {
        return this.bCN;
    }

    public void release() {
        if (this.bCL != null && this.bCM != null && (XK() == RecorderState.RECORDING || XK() == RecorderState.PAUSE)) {
            this.bCM.onError(-1);
        }
        setGameRecordCallback(null);
        this.bCN = RecorderState.IDLE;
    }

    public static GameRecorderController XL() {
        return new GameRecorderController(null);
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.mario.b.b {
        private a() {
        }

        @Override // com.baidu.mario.b.b
        public void onStart() {
            GameRecorderController.this.bCN = RecorderState.RECORDING;
            if (GameRecorderController.this.bCM != null) {
                GameRecorderController.this.bCM.onStart();
            }
        }

        @Override // com.baidu.mario.b.b
        public void l(int i, String str) {
            GameRecorderController.this.bCN = RecorderState.STOP;
            if (GameRecorderController.this.bCM != null) {
                GameRecorderController.this.bCM.l(i, str);
            }
        }

        @Override // com.baidu.mario.b.b
        public void onPause() {
            GameRecorderController.this.bCN = RecorderState.PAUSE;
            if (GameRecorderController.this.bCM != null) {
                GameRecorderController.this.bCM.onPause();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onResume() {
            GameRecorderController.this.bCN = RecorderState.RECORDING;
            if (GameRecorderController.this.bCM != null) {
                GameRecorderController.this.bCM.onResume();
            }
        }

        @Override // com.baidu.mario.b.b
        public void onError(int i) {
            GameRecorderController.this.bCN = RecorderState.IDLE;
            if (GameRecorderController.this.bCM != null) {
                GameRecorderController.this.bCM.onError(i);
            }
        }
    }
}
