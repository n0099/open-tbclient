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
/* loaded from: classes11.dex */
public class c {
    private String bMF;
    private WriteImagesInfo bML;
    private VideoFileInfo bMM;
    private ImageFileInfo bMN;
    private List<ImageFileInfo> bMO;
    private final AlbumActivity bMr;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bMP = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bMr = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bMM = videoFileInfo;
    }

    public boolean WP() {
        return !ListUtils.isEmpty(WS());
    }

    public boolean WQ() {
        return this.bMM != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bMM == null || videoFileInfo == null || this.bMM.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bMN = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bML == null) {
            this.bML = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bML.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bML != null) {
            this.bML.delChooseFile(imageFileInfo);
        }
    }

    public void WR() {
        if (this.bML != null) {
            this.bML.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bML == null) {
            return false;
        }
        return this.bML.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> WS() {
        if (this.bML != null) {
            return this.bML.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo WT() {
        return this.bML;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bML = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bML != null) {
            return this.bML.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bML == null) {
            this.bML = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bML.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bML != null) {
            return this.bML.getMaxImagesAllowed();
        }
        return 0;
    }

    public String WU() {
        return this.bMF;
    }

    public void iI(String str) {
        this.bMF = str;
        iJ(str);
    }

    private void iJ(String str) {
        if (this.bMP != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bMP) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bMO = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> WV() {
        return this.bMO;
    }

    public List<AlbumData> WW() {
        return this.bMP;
    }

    public List<MediaFileInfo> iK(String str) {
        if (this.bMP == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bMP) {
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
            arrayList.add(ag(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(ah(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bMP.clear();
            this.bMP.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bML == null) {
            return 0;
        }
        return this.bML.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bML != null) {
            this.bML.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bML != null) {
            return this.bML.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bMN == null || TextUtils.isEmpty(this.bMN.getFilePath())) {
            return 0;
        }
        if (this.bMO == null || this.bMO.size() == 0) {
            return 0;
        }
        int size = this.bMO.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bMO.get(i);
            if (imageFileInfo != null && this.bMN.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ag(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bMr.getPageContext().getString(a.h.sdk_ph_album_all_media));
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

    public AlbumData ah(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bMr.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
