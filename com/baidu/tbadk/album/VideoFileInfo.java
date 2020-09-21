package com.baidu.tbadk.album;

import android.graphics.Bitmap;
/* loaded from: classes20.dex */
public class VideoFileInfo extends MediaFileInfo {
    private static final long serialVersionUID = 4168698601975684150L;
    public int albumId;
    public String albumName;
    public long beginTime;
    public String contentUriStr;
    public String displayName;
    public String durationText;
    public long fileSize;
    public boolean hasLoaded = false;
    public long lastModified;
    public String mimeType;
    public String thumbPath;
    public Bitmap thumbnailBitmap;
    public String title;
    public int videoDuration;
    public int videoHeight;
    public int videoId;
    public String videoMd5;
    public String videoPath;
    public int videoWidth;

    @Override // com.baidu.tbadk.album.MediaFileInfo
    public int getType() {
        return 1;
    }
}
