package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.android.util.media.MediaQuery;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.ugc.album.R;
import com.baidu.searchbox.ugc.model.ImageGroup;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.UgcImageInfo;
import com.baidu.searchbox.ugc.utils.BaseTask;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes13.dex */
public class ImageLoadTask extends BaseTask {
    private static final String[] IMG_TYPES = {MimeType.Image.JPEG, MimeType.Image.PNG, "image/gif"};
    private Context mContext;

    public ImageLoadTask(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public ImageLoadTask(Context context, OnTaskResultListener onTaskResultListener) {
        this.mContext = null;
        this.mContext = context;
        setOnResultListener(onTaskResultListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public BaseTask.Result doInBackground(Void... voidArr) {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        StringBuilder sb = new StringBuilder();
        sb.append("mime_type").append("=?");
        sb.append(" or ");
        sb.append("mime_type").append("=?");
        String[] strArr = {IMG_TYPES[0], IMG_TYPES[1]};
        if (SelectUtil.supportGifLongImg) {
            sb.append(" or ");
            sb.append("mime_type").append("=?");
            strArr = IMG_TYPES;
        }
        List<UgcImageInfo> query = MediaQuery.with(this.mContext, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).selection(sb.toString()).selectionArgs(strArr).build().query(UgcImageInfo.class);
        if (query == null) {
            return new BaseTask.Result(false, null);
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (UgcImageInfo ugcImageInfo : query) {
            ImageGroup imageGroup = (ImageGroup) hashMap.get(ugcImageInfo.bucketId);
            if (imageGroup == null) {
                imageGroup = new ImageGroup();
                imageGroup.setBucketID(ugcImageInfo.bucketId);
                imageGroup.setBucketName(ugcImageInfo.bucketDisplayName);
                hashMap.put(ugcImageInfo.bucketId, imageGroup);
            }
            ImageStruct imageStruct = new ImageStruct(ugcImageInfo);
            imageGroup.addImage(imageStruct);
            arrayList.add(imageStruct);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.values());
        Collections.sort(arrayList2);
        ImageGroup imageGroup2 = new ImageGroup();
        imageGroup2.setBucketID(ImageGroup.ALL_IMAGE_BUCKET_ID);
        imageGroup2.setBucketName(this.mContext.getResources().getString(R.string.ugc_album_all_photos));
        imageGroup2.setImages(arrayList);
        arrayList2.add(0, imageGroup2);
        return new BaseTask.Result(true, arrayList2);
    }
}
