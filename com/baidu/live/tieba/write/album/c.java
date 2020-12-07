package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private final AlbumActivity bHE;
    private String bHR;
    private WriteImagesInfo bHX;
    private VideoFileInfo bHY;
    private ImageFileInfo bHZ;
    private List<ImageFileInfo> bIa;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bIb = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bHE = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bHY = videoFileInfo;
    }

    public boolean VM() {
        return !ListUtils.isEmpty(VP());
    }

    public boolean VN() {
        return this.bHY != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bHY == null || videoFileInfo == null || this.bHY.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bHZ = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bHX == null) {
            this.bHX = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bHX.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bHX != null) {
            this.bHX.delChooseFile(imageFileInfo);
        }
    }

    public void VO() {
        if (this.bHX != null) {
            this.bHX.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bHX == null) {
            return false;
        }
        return this.bHX.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> VP() {
        if (this.bHX != null) {
            return this.bHX.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo VQ() {
        return this.bHX;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bHX = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bHX != null) {
            return this.bHX.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bHX == null) {
            this.bHX = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bHX.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bHX != null) {
            return this.bHX.getMaxImagesAllowed();
        }
        return 0;
    }

    public String VR() {
        return this.bHR;
    }

    public void iT(String str) {
        this.bHR = str;
        iU(str);
    }

    private void iU(String str) {
        if (this.bIb != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bIb) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bIa = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> VS() {
        return this.bIa;
    }

    public List<AlbumData> VT() {
        return this.bIb;
    }

    public List<MediaFileInfo> iV(String str) {
        if (this.bIb == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bIb) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(af(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(ag(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bIb.clear();
            this.bIb.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bHX == null) {
            return 0;
        }
        return this.bHX.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bHX != null) {
            this.bHX.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bHX != null) {
            return this.bHX.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bHZ == null || TextUtils.isEmpty(this.bHZ.getFilePath())) {
            return 0;
        }
        if (this.bIa == null || this.bIa.size() == 0) {
            return 0;
        }
        int size = this.bIa.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bIa.get(i);
            if (imageFileInfo != null && this.bHZ.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData af(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bHE.getPageContext().getString(a.h.sdk_ph_album_all_media));
        int count = ListUtils.getCount(list);
        albumData.setFileList(list);
        albumData.setCount(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) ListUtils.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            albumData.setLastFileInfo((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            albumData.setLastFileInfo((VideoFileInfo) mediaFileInfo);
        }
        return albumData;
    }

    public AlbumData ag(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bHE.getPageContext().getString(a.h.sdk_ph_album_all_video));
        int count = ListUtils.getCount(list);
        albumData.setCount(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!ListUtils.isEmpty(list)) {
            arrayList.addAll(list);
        }
        albumData.setFileList(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) ListUtils.getItem(list, count - 1);
        if (videoFileInfo != null) {
            albumData.setLastFileInfo(videoFileInfo);
        }
        return albumData;
    }
}
