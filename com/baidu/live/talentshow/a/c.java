package com.baidu.live.talentshow.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.bl;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes4.dex */
public class c {
    private VideoBeautyType bxA;
    private AlaLiveRecorder bxq;
    private TbPageContext mPageContext;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.talentshow.a.c.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("BCVideoChat video chat rtc error=" + i + "|msg=" + str);
            if (i == 3) {
                c.this.mPageContext.showToast(c.this.mPageContext.getString(a.h.talent_video_device_open_failed));
            } else if (i == 1) {
                c.this.mPageContext.showToast(c.this.mPageContext.getString(a.h.talent_video_device_open_failed));
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public AlaLiveRecorder RT() {
        if (this.bxq == null) {
            RU();
        }
        return this.bxq;
    }

    private void RU() {
        this.bxA = bl.b(com.baidu.live.aa.a.PQ().btT) ? VideoBeautyType.DUMIX_AR : VideoBeautyType.BEAUTY_NONE;
        if (this.bxq == null) {
            AlaLiveVideoConfig d = LiveRecorderConfigHelper.Pn().d(4, 1, false);
            d.setOutputWidth(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL);
            d.setOutputHeight(TbConfig.HEAD_IMG_SIZE);
            this.bxq = new AlaLiveRecorder(this.mPageContext.getPageActivity(), d, VideoRecorderType.CAMERA, this.bxA);
            this.bxq.addRecorderCallback(this.mRecorderCallback);
        }
    }

    public void x(ViewGroup viewGroup) {
        RT();
        this.bxq.getPreview().setEnabled(false);
        RW();
        ab(this.bxq.getPreview());
        viewGroup.addView(this.bxq.getPreview(), 0, RV());
    }

    private FrameLayout.LayoutParams RV() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public void ab(View view) {
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(a.d.sdk_ds36);
        if (Build.VERSION.SDK_INT >= 21) {
            n(view, dimensionPixelSize);
        }
    }

    @RequiresApi(api = 21)
    private void n(View view, final float f) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.baidu.live.talentshow.a.c.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), f);
            }
        });
        view.setClipToOutline(true);
    }

    public void RW() {
        View preview;
        if (this.bxq != null && (preview = this.bxq.getPreview()) != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(preview, 0.0f);
            }
            if (preview.getParent() != null) {
                ((ViewGroup) preview.getParent()).removeView(preview);
            }
        }
    }

    public void startPreview() {
        if (this.bxq != null) {
            this.bxq.startRecord();
        }
    }

    public void RX() {
        if (this.bxq != null) {
            this.bxq.stopRecord();
        }
    }

    public void onDestroy() {
        if (this.bxq != null) {
            this.bxq.stopRecord();
            this.bxq.release();
            this.bxq = null;
        }
    }
}
