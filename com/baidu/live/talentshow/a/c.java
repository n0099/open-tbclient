package com.baidu.live.talentshow.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.bm;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.tbadk.TbConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    private AlaLiveRecorder bAP;
    private VideoBeautyType bAZ;
    private TbPageContext mPageContext;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.talentshow.a.c.1
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
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }
    };

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public AlaLiveRecorder TI() {
        if (this.bAP == null) {
            TJ();
        }
        return this.bAP;
    }

    private void TJ() {
        this.bAZ = bm.b(com.baidu.live.ae.a.RB().bxq) ? VideoBeautyType.DUMIX_AR : VideoBeautyType.BEAUTY_NONE;
        if (this.bAP == null) {
            AlaLiveVideoConfig d = LiveRecorderConfigHelper.QY().d(4, 1, false);
            d.setOutputWidth(UIMsg.MsgDefine.MSG_NETWORK_CHANNEL);
            d.setOutputHeight(TbConfig.HEAD_IMG_SIZE);
            this.bAP = new AlaLiveRecorder(this.mPageContext.getPageActivity(), d, VideoRecorderType.CAMERA, this.bAZ);
            this.bAP.addRecorderCallback(this.mRecorderCallback);
        }
    }

    public void t(ViewGroup viewGroup) {
        TI();
        this.bAP.getPreview().setEnabled(false);
        TL();
        ab(this.bAP.getPreview());
        viewGroup.addView(this.bAP.getPreview(), 0, TK());
    }

    private FrameLayout.LayoutParams TK() {
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

    public void TL() {
        View preview;
        if (this.bAP != null && (preview = this.bAP.getPreview()) != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(preview, 0.0f);
            }
            if (preview.getParent() != null) {
                ((ViewGroup) preview.getParent()).removeView(preview);
            }
        }
    }

    public void startPreview() {
        if (this.bAP != null) {
            this.bAP.startRecord();
        }
    }

    public void TM() {
        if (this.bAP != null) {
            this.bAP.stopRecord();
        }
    }

    public void onDestroy() {
        if (this.bAP != null) {
            this.bAP.stopRecord();
            this.bAP.release();
            this.bAP = null;
        }
    }
}
