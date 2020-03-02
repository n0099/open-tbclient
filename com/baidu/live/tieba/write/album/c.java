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
    private ImageFileInfo aCA;
    private List<ImageFileInfo> aCB;
    private final AlbumActivity aCh;
    private String aCs;
    private WriteImagesInfo aCy;
    private VideoFileInfo aCz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aCC = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aCh = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aCz = videoFileInfo;
    }

    public boolean AD() {
        return !ListUtils.isEmpty(AG());
    }

    public boolean AE() {
        return this.aCz != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aCz == null || videoFileInfo == null || this.aCz.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aCA = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCy == null) {
            this.aCy = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCy.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCy != null) {
            this.aCy.delChooseFile(imageFileInfo);
        }
    }

    public void AF() {
        if (this.aCy != null) {
            this.aCy.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aCy == null) {
            return false;
        }
        return this.aCy.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> AG() {
        if (this.aCy != null) {
            return this.aCy.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo AH() {
        return this.aCy;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aCy = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aCy != null) {
            return this.aCy.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aCy == null) {
            this.aCy = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCy.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aCy != null) {
            return this.aCy.getMaxImagesAllowed();
        }
        return 0;
    }

    public String AI() {
        return this.aCs;
    }

    public void ea(String str) {
        this.aCs = str;
        eb(str);
    }

    private void eb(String str) {
        if (this.aCC != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aCC) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aCB = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> AJ() {
        return this.aCB;
    }

    public List<AlbumData> AK() {
        return this.aCC;
    }

    public List<MediaFileInfo> ec(String str) {
        if (this.aCC == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aCC) {
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
            this.aCC.clear();
            this.aCC.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aCy == null) {
            return 0;
        }
        return this.aCy.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aCy != null) {
            this.aCy.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aCy != null) {
            return this.aCy.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aCA == null || TextUtils.isEmpty(this.aCA.getFilePath())) {
            return 0;
        }
        if (this.aCB == null || this.aCB.size() == 0) {
            return 0;
        }
        int size = this.aCB.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aCB.get(i);
            if (imageFileInfo != null && this.aCA.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData H(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aCh.getPageContext().getString(a.i.sdk_ph_album_all_media));
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
        albumData.setName(this.aCh.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
