package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import com.baidu.android.util.media.MediaQuery;
import com.baidu.android.util.media.model.DefaultVideoInfo;
import com.baidu.searchbox.ugc.model.VideoInfo;
import com.baidu.searchbox.ugc.utils.BaseTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class VideoLoadTask extends BaseTask {
    private Context mContext;

    public VideoLoadTask(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public VideoLoadTask(Context context, OnTaskResultListener onTaskResultListener) {
        this.mContext = null;
        this.mContext = context;
        setOnResultListener(onTaskResultListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public BaseTask.Result doInBackground(Void... voidArr) {
        List<DefaultVideoInfo> query = MediaQuery.with(this.mContext, MediaStore.Video.Media.EXTERNAL_CONTENT_URI).build().query(DefaultVideoInfo.class);
        ArrayList arrayList = new ArrayList();
        if (query != null) {
            for (DefaultVideoInfo defaultVideoInfo : query) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setInfo(defaultVideoInfo);
                arrayList.add(videoInfo);
            }
        }
        return new BaseTask.Result(true, arrayList);
    }

    private Bitmap getVideoThumb(int i, String str) {
        return getVideoThumbnail(str, 300, 300, 3);
    }

    private Bitmap getVideoThumbnail(String str, int i, int i2, int i3) {
        return ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(str, i3), i, i2, 2);
    }
}
