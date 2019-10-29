package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private final AlbumActivity apI;
    private String apU;
    private WriteImagesInfo aqa;
    private VideoFileInfo aqb;
    private ImageFileInfo aqc;
    private List<ImageFileInfo> aqd;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aqe = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.apI = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aqb = videoFileInfo;
    }

    public boolean vV() {
        return !ListUtils.isEmpty(vY());
    }

    public boolean vW() {
        return this.aqb != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aqb == null || videoFileInfo == null || this.aqb.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aqc = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aqa == null) {
            this.aqa = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aqa.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aqa != null) {
            this.aqa.delChooseFile(imageFileInfo);
        }
    }

    public void vX() {
        if (this.aqa != null) {
            this.aqa.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aqa == null) {
            return false;
        }
        return this.aqa.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> vY() {
        if (this.aqa != null) {
            return this.aqa.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo vZ() {
        return this.aqa;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aqa = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aqa != null) {
            return this.aqa.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aqa == null) {
            this.aqa = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aqa.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aqa != null) {
            return this.aqa.getMaxImagesAllowed();
        }
        return 0;
    }

    public String wa() {
        return this.apU;
    }

    public void cQ(String str) {
        this.apU = str;
        cR(str);
    }

    private void cR(String str) {
        if (this.aqe != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aqe) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aqd = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> wb() {
        return this.aqd;
    }

    public List<AlbumData> wc() {
        return this.aqe;
    }

    public List<MediaFileInfo> cS(String str) {
        if (this.aqe == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aqe) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean wd() {
        return ListUtils.isEmpty(cS(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(K(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(L(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.aqe.clear();
            this.aqe.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aqa == null) {
            return 0;
        }
        return this.aqa.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aqa != null) {
            this.aqa.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aqa != null) {
            return this.aqa.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aqc == null || TextUtils.isEmpty(this.aqc.getFilePath())) {
            return 0;
        }
        if (this.aqd == null || this.aqd.size() == 0) {
            return 0;
        }
        int size = this.aqd.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aqd.get(i);
            if (imageFileInfo != null && this.aqc.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData K(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.apI.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData L(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.apI.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
