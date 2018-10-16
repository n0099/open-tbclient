package com.baidu.searchbox.ng.ai.apps.media.chooser.helper;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.net.URI;
/* loaded from: classes2.dex */
public class AlbumTaskStrategy extends PickVideoTask.TaskStrategy {
    private static final boolean DEBUG = false;
    private static final int INDEX_DATA = 1;
    private static final int INDEX_DURATION = 2;
    private static final int INDEX_HEIGHT = 4;
    private static final int INDEX_ID = 0;
    private static final int INDEX_SIZE = 3;
    private static final int INDEX_WIDTH = 5;
    private static final String[] PROJECTION = {"_id", "_data", "duration", "_size", "height", "width"};
    private static final String TAG = "AlbumTaskStrategy";

    public AlbumTaskStrategy(VideoPickHelper.PickData pickData) {
        super(pickData);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.TaskStrategy
    public PickVideoTask.TaskToken doInBackground(Context context, PickVideoTask.TaskToken taskToken) {
        if (taskToken == null) {
            taskToken = new PickVideoTask.TaskToken();
        }
        if (this.pickData.uri == null) {
            return taskToken.setError(true, "uri is Null");
        }
        boolean fromFile = fromFile(taskToken);
        if (!fromFile) {
            fromFile = fromDatabase(context, taskToken);
        }
        if (!fromFile) {
            return taskToken.setError(true, "can not handle uri:" + this.pickData.uri);
        }
        if (needCompressed(this.pickData)) {
            taskToken.nextAction(1, this.pickData);
            return taskToken;
        }
        taskToken.nextAction(2, this.pickData);
        return taskToken;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [119=4] */
    private boolean fromDatabase(@NonNull Context context, @NonNull PickVideoTask.TaskToken taskToken) {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            Cursor query = context.getContentResolver().query(this.pickData.uri, PROJECTION, null, null, null);
            try {
            } catch (Exception e) {
                taskToken.setError(true, "query occurs exception:" + e.getMessage());
            } finally {
                AiAppsFileUtils.closeSafely(query);
            }
            if (query == null) {
                taskToken.setError(true, "query return null:" + this.pickData.uri);
                return false;
            } else if (query.moveToFirst()) {
                VideoPickHelper.VideoChooserResult videoChooserResult = new VideoPickHelper.VideoChooserResult();
                videoChooserResult.id = query.getLong(0);
                videoChooserResult.realFilePath = query.getString(1);
                videoChooserResult.duration = query.getLong(2);
                videoChooserResult.size = query.getLong(3);
                videoChooserResult.height = query.getLong(4);
                videoChooserResult.width = query.getLong(5);
                if ((videoChooserResult.width == 0 || videoChooserResult.height == 0) && !TextUtils.isEmpty(videoChooserResult.realFilePath)) {
                    try {
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(videoChooserResult.realFilePath);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                            videoChooserResult.width = Long.parseLong(extractMetadata);
                            videoChooserResult.height = Long.parseLong(extractMetadata2);
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                        } catch (Exception e2) {
                            if (mediaMetadataRetriever != null) {
                                mediaMetadataRetriever.release();
                            }
                            this.pickData.result = videoChooserResult;
                            return true;
                        } catch (Throwable th) {
                            mediaMetadataRetriever2 = mediaMetadataRetriever;
                            th = th;
                            if (mediaMetadataRetriever2 != null) {
                                mediaMetadataRetriever2.release();
                            }
                            throw th;
                        }
                    } catch (Exception e3) {
                        mediaMetadataRetriever = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                this.pickData.result = videoChooserResult;
                return true;
            } else {
                return false;
            }
        } catch (Exception e4) {
            taskToken.setError(true, e4.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=6, 168=5] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x007d -> B:10:0x0039). Please submit an issue!!! */
    private boolean fromFile(@NonNull PickVideoTask.TaskToken taskToken) {
        MediaMetadataRetriever mediaMetadataRetriever;
        File file;
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        try {
            file = new File(new URI(this.pickData.uri.toString()));
        } catch (Exception e) {
            mediaMetadataRetriever = null;
        } catch (Throwable th) {
            th = th;
        }
        if (!file.exists()) {
            if (0 != 0) {
                mediaMetadataRetriever2.release();
            }
            return false;
        }
        VideoPickHelper.VideoChooserResult videoChooserResult = new VideoPickHelper.VideoChooserResult();
        videoChooserResult.realFilePath = file.getPath();
        if (TextUtils.isEmpty(videoChooserResult.realFilePath)) {
            taskToken.setError(true, "can not find path");
            if (0 != 0) {
                mediaMetadataRetriever2.release();
                return true;
            }
            return true;
        }
        videoChooserResult.size = file.length();
        MediaMetadataRetriever mediaMetadataRetriever3 = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever3.setDataSource(videoChooserResult.realFilePath);
            String extractMetadata = mediaMetadataRetriever3.extractMetadata(18);
            String extractMetadata2 = mediaMetadataRetriever3.extractMetadata(19);
            String extractMetadata3 = mediaMetadataRetriever3.extractMetadata(9);
            videoChooserResult.width = Long.parseLong(extractMetadata);
            videoChooserResult.height = Long.parseLong(extractMetadata2);
            videoChooserResult.duration = Long.parseLong(extractMetadata3);
            this.pickData.result = videoChooserResult;
            if (mediaMetadataRetriever3 != null) {
                mediaMetadataRetriever3.release();
                return true;
            }
            return true;
        } catch (Exception e2) {
            mediaMetadataRetriever = mediaMetadataRetriever3;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever2 = mediaMetadataRetriever3;
            if (mediaMetadataRetriever2 != null) {
                mediaMetadataRetriever2.release();
            }
            throw th;
        }
    }
}
