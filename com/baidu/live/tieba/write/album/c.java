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
    private List<ImageFileInfo> aCA;
    private final AlbumActivity aCg;
    private String aCr;
    private WriteImagesInfo aCx;
    private VideoFileInfo aCy;
    private ImageFileInfo aCz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aCB = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aCg = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aCy = videoFileInfo;
    }

    public boolean AB() {
        return !ListUtils.isEmpty(AE());
    }

    public boolean AC() {
        return this.aCy != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aCy == null || videoFileInfo == null || this.aCy.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aCz = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCx == null) {
            this.aCx = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCx.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCx != null) {
            this.aCx.delChooseFile(imageFileInfo);
        }
    }

    public void AD() {
        if (this.aCx != null) {
            this.aCx.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aCx == null) {
            return false;
        }
        return this.aCx.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> AE() {
        if (this.aCx != null) {
            return this.aCx.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo AF() {
        return this.aCx;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aCx = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aCx != null) {
            return this.aCx.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aCx == null) {
            this.aCx = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCx.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aCx != null) {
            return this.aCx.getMaxImagesAllowed();
        }
        return 0;
    }

    public String AG() {
        return this.aCr;
    }

    public void ea(String str) {
        this.aCr = str;
        eb(str);
    }

    private void eb(String str) {
        if (this.aCB != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aCB) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aCA = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> AH() {
        return this.aCA;
    }

    public List<AlbumData> AI() {
        return this.aCB;
    }

    public List<MediaFileInfo> ec(String str) {
        if (this.aCB == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aCB) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean AJ() {
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
            this.aCB.clear();
            this.aCB.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aCx == null) {
            return 0;
        }
        return this.aCx.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aCx != null) {
            this.aCx.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aCx != null) {
            return this.aCx.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aCz == null || TextUtils.isEmpty(this.aCz.getFilePath())) {
            return 0;
        }
        if (this.aCA == null || this.aCA.size() == 0) {
            return 0;
        }
        int size = this.aCA.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aCA.get(i);
            if (imageFileInfo != null && this.aCz.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData H(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aCg.getPageContext().getString(a.i.sdk_ph_album_all_media));
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
        albumData.setName(this.aCg.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
