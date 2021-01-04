package com.baidu.ala.recorder.video.screen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.baidu.ala.tbadk.core.TbadkCoreApplicationProxy;
/* loaded from: classes15.dex */
public class ScreenRecorderPrepareActivity extends Activity {
    private static final int REQUEST_CODE = 1;
    private MediaProjectionManager mMediaProjectionManager;

    @Override // android.app.Activity
    @TargetApi(21)
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.mMediaProjectionManager = (MediaProjectionManager) TbadkCoreApplicationProxy.getInst().getAppContext().getSystemService("media_projection");
        startActivityForResult(this.mMediaProjectionManager.createScreenCaptureIntent(), 1);
    }

    @Override // android.app.Activity
    @TargetApi(21)
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        MediaProjection mediaProjection = this.mMediaProjectionManager.getMediaProjection(i2, intent);
        if (mediaProjection != null) {
            AlaScreenRecorder.getInstance().startRecorderThread(mediaProjection);
        } else {
            AlaScreenRecorder.getInstance().sendError();
        }
        finish();
    }
}
