package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private VideoFileInfo aWA;
    private ImageFileInfo aWB;
    private List<ImageFileInfo> aWC;
    private final AlbumActivity aWi;
    private String aWt;
    private WriteImagesInfo aWz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aWD = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aWi = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aWA = videoFileInfo;
    }

    public boolean FH() {
        return !ListUtils.isEmpty(FK());
    }

    public boolean FI() {
        return this.aWA != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aWA == null || videoFileInfo == null || this.aWA.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aWB = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aWz == null) {
            this.aWz = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aWz.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aWz != null) {
            this.aWz.delChooseFile(imageFileInfo);
        }
    }

    public void FJ() {
        if (this.aWz != null) {
            this.aWz.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aWz == null) {
            return false;
        }
        return this.aWz.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> FK() {
        if (this.aWz != null) {
            return this.aWz.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo FL() {
        return this.aWz;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aWz = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aWz != null) {
            return this.aWz.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aWz == null) {
            this.aWz = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aWz.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aWz != null) {
            return this.aWz.getMaxImagesAllowed();
        }
        return 0;
    }

    public String FM() {
        return this.aWt;
    }

    public void eS(String str) {
        this.aWt = str;
        eT(str);
    }

    private void eT(String str) {
        if (this.aWD != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aWD) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aWC = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> FN() {
        return this.aWC;
    }

    public List<AlbumData> FO() {
        return this.aWD;
    }

    public List<MediaFileInfo> eU(String str) {
        if (this.aWD == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aWD) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean FP() {
        return ListUtils.isEmpty(eU(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(M(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(N(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.aWD.clear();
            this.aWD.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aWz == null) {
            return 0;
        }
        return this.aWz.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aWz != null) {
            this.aWz.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aWz != null) {
            return this.aWz.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aWB == null || TextUtils.isEmpty(this.aWB.getFilePath())) {
            return 0;
        }
        if (this.aWC == null || this.aWC.size() == 0) {
            return 0;
        }
        int size = this.aWC.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aWC.get(i);
            if (imageFileInfo != null && this.aWB.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData M(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aWi.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData N(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.aWi.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
