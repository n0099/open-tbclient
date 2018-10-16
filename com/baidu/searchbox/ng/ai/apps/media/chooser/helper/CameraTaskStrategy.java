package com.baidu.searchbox.ng.ai.apps.media.chooser.helper;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class CameraTaskStrategy extends PickVideoTask.TaskStrategy {
    private static final boolean DEBUG = false;
    private static final String TAG = "CameraTaskStrategy";

    public CameraTaskStrategy(VideoPickHelper.PickData pickData) {
        super(pickData);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [71=4] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    @Override // com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.TaskStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PickVideoTask.TaskToken doInBackground(Context context, PickVideoTask.TaskToken taskToken) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (taskToken == null) {
            taskToken = new PickVideoTask.TaskToken();
        }
        if (this.pickData.uri == null) {
            taskToken.setError(true, "uri in pickData is null");
        } else {
            String path = this.pickData.uri.getPath();
            if (TextUtils.isEmpty(path)) {
                taskToken.setError(true, this.pickData.uri + " get file path failed");
            } else {
                VideoPickHelper.VideoChooserResult videoChooserResult = new VideoPickHelper.VideoChooserResult();
                videoChooserResult.realFilePath = path;
                MediaMetadataRetriever mediaMetadataRetriever2 = null;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                } catch (Exception e) {
                    mediaMetadataRetriever = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    mediaMetadataRetriever.setDataSource(videoChooserResult.realFilePath);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                    videoChooserResult.width = Long.parseLong(extractMetadata);
                    videoChooserResult.height = Long.parseLong(extractMetadata2);
                    videoChooserResult.duration = Long.parseLong(extractMetadata3);
                    videoChooserResult.size = new File(path).length();
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                } catch (Exception e2) {
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    this.pickData.result = videoChooserResult;
                    if (needCompressed(this.pickData)) {
                    }
                    return taskToken;
                } catch (Throwable th2) {
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    th = th2;
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                    }
                    throw th;
                }
                this.pickData.result = videoChooserResult;
                if (needCompressed(this.pickData)) {
                    this.pickData.result.tempPath = StorageUtil.path2Scheme(path, AiApp.getAiAppId());
                    taskToken.nextAction(0, this.pickData);
                } else {
                    taskToken.nextAction(1, this.pickData);
                }
            }
        }
        return taskToken;
    }
}
