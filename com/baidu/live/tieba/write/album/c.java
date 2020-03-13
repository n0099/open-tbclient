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
    private VideoFileInfo aCA;
    private ImageFileInfo aCB;
    private List<ImageFileInfo> aCC;
    private final AlbumActivity aCi;
    private String aCt;
    private WriteImagesInfo aCz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aCD = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aCi = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aCA = videoFileInfo;
    }

    public boolean AD() {
        return !ListUtils.isEmpty(AG());
    }

    public boolean AE() {
        return this.aCA != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aCA == null || videoFileInfo == null || this.aCA.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aCB = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCz == null) {
            this.aCz = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCz.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCz != null) {
            this.aCz.delChooseFile(imageFileInfo);
        }
    }

    public void AF() {
        if (this.aCz != null) {
            this.aCz.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aCz == null) {
            return false;
        }
        return this.aCz.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> AG() {
        if (this.aCz != null) {
            return this.aCz.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo AH() {
        return this.aCz;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aCz = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aCz != null) {
            return this.aCz.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aCz == null) {
            this.aCz = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCz.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aCz != null) {
            return this.aCz.getMaxImagesAllowed();
        }
        return 0;
    }

    public String AI() {
        return this.aCt;
    }

    public void ea(String str) {
        this.aCt = str;
        eb(str);
    }

    private void eb(String str) {
        if (this.aCD != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aCD) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aCC = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> AJ() {
        return this.aCC;
    }

    public List<AlbumData> AK() {
        return this.aCD;
    }

    public List<MediaFileInfo> ec(String str) {
        if (this.aCD == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aCD) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean AL() {
        return ListUtils.isEmpty(ec(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(H(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(I(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.aCD.clear();
            this.aCD.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aCz == null) {
            return 0;
        }
        return this.aCz.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aCz != null) {
            this.aCz.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aCz != null) {
            return this.aCz.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aCB == null || TextUtils.isEmpty(this.aCB.getFilePath())) {
            return 0;
        }
        if (this.aCC == null || this.aCC.size() == 0) {
            return 0;
        }
        int size = this.aCC.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aCC.get(i);
            if (imageFileInfo != null && this.aCB.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData H(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aCi.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData I(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.aCi.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
