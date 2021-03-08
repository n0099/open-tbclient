package com.baidu.live.talentshow.a;

import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.bt;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private AlaLiveRecorder bFW;
    private VideoBeautyType bGg;
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

    public AlaLiveRecorder SF() {
        if (this.bFW == null) {
            SG();
        }
        return this.bFW;
    }

    private void SG() {
        this.bGg = bt.b(com.baidu.live.ae.a.Qm().bCs) ? VideoBeautyType.DUMIX_AR : VideoBeautyType.BEAUTY_NONE;
        if (this.bFW == null) {
            AlaLiveVideoConfig d = com.baidu.live.z.a.b.PI().d(4, 1, false);
            d.setOutputWidth(540);
            d.setOutputHeight(960);
            this.bFW = new AlaLiveRecorder(this.mPageContext.getPageActivity(), d, VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), this.bGg);
            this.bFW.addRecorderCallback(this.mRecorderCallback);
        }
    }

    public void u(ViewGroup viewGroup) {
        SF();
        this.bFW.getPreview().setEnabled(false);
        SI();
        ab(this.bFW.getPreview());
        viewGroup.addView(this.bFW.getPreview(), 0, SH());
    }

    private FrameLayout.LayoutParams SH() {
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

    public void SI() {
        View preview;
        if (this.bFW != null && (preview = this.bFW.getPreview()) != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                n(preview, 0.0f);
            }
            if (preview.getParent() != null) {
                ((ViewGroup) preview.getParent()).removeView(preview);
            }
        }
    }

    public void startPreview() {
        if (this.bFW != null) {
            this.bFW.startRecord();
        }
    }

    public void stopPreview() {
        if (this.bFW != null) {
            this.bFW.stopRecord();
        }
    }

    public void onDestroy() {
        if (this.bFW != null) {
            this.bFW.stopRecord();
            this.bFW.release();
            this.bFW = null;
        }
    }
}
