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
/* loaded from: classes10.dex */
public class c {
    private final AlbumActivity bMP;
    private String bNd;
    private WriteImagesInfo bNj;
    private VideoFileInfo bNk;
    private ImageFileInfo bNl;
    private List<ImageFileInfo> bNm;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bNn = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bMP = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bNk = videoFileInfo;
    }

    public boolean UG() {
        return !ListUtils.isEmpty(UJ());
    }

    public boolean UH() {
        return this.bNk != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bNk == null || videoFileInfo == null || this.bNk.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bNl = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bNj == null) {
            this.bNj = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bNj.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bNj != null) {
            this.bNj.delChooseFile(imageFileInfo);
        }
    }

    public void UI() {
        if (this.bNj != null) {
            this.bNj.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bNj == null) {
            return false;
        }
        return this.bNj.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> UJ() {
        if (this.bNj != null) {
            return this.bNj.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo UK() {
        return this.bNj;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bNj = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bNj != null) {
            return this.bNj.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bNj == null) {
            this.bNj = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bNj.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bNj != null) {
            return this.bNj.getMaxImagesAllowed();
        }
        return 0;
    }

    public String UL() {
        return this.bNd;
    }

    public void hZ(String str) {
        this.bNd = str;
        ia(str);
    }

    private void ia(String str) {
        if (this.bNn != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bNn) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bNm = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> UM() {
        return this.bNm;
    }

    public List<AlbumData> UN() {
        return this.bNn;
    }

    public List<MediaFileInfo> ib(String str) {
        if (this.bNn == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bNn) {
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
            arrayList.add(ah(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(ai(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bNn.clear();
            this.bNn.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bNj == null) {
            return 0;
        }
        return this.bNj.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bNj != null) {
            this.bNj.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bNj != null) {
            return this.bNj.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bNl == null || TextUtils.isEmpty(this.bNl.getFilePath())) {
            return 0;
        }
        if (this.bNm == null || this.bNm.size() == 0) {
            return 0;
        }
        int size = this.bNm.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bNm.get(i);
            if (imageFileInfo != null && this.bNl.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ah(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bMP.getPageContext().getString(a.h.sdk_ph_album_all_media));
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

    public AlbumData ai(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bMP.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
