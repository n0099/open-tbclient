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
    private final AlbumActivity brU;
    private String bsh;
    private WriteImagesInfo bsn;
    private VideoFileInfo bso;
    private ImageFileInfo bsp;
    private List<ImageFileInfo> bsq;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bsr = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.brU = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bso = videoFileInfo;
    }

    public boolean Pn() {
        return !ListUtils.isEmpty(Pq());
    }

    public boolean Po() {
        return this.bso != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bso == null || videoFileInfo == null || this.bso.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bsp = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bsn == null) {
            this.bsn = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bsn.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bsn != null) {
            this.bsn.delChooseFile(imageFileInfo);
        }
    }

    public void Pp() {
        if (this.bsn != null) {
            this.bsn.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bsn == null) {
            return false;
        }
        return this.bsn.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> Pq() {
        if (this.bsn != null) {
            return this.bsn.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo Pr() {
        return this.bsn;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bsn = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bsn != null) {
            return this.bsn.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bsn == null) {
            this.bsn = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bsn.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bsn != null) {
            return this.bsn.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Ps() {
        return this.bsh;
    }

    public void hv(String str) {
        this.bsh = str;
        hw(str);
    }

    private void hw(String str) {
        if (this.bsr != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bsr) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bsq = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Pt() {
        return this.bsq;
    }

    public List<AlbumData> Pu() {
        return this.bsr;
    }

    public List<MediaFileInfo> hx(String str) {
        if (this.bsr == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bsr) {
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
            arrayList.add(V(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(W(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bsr.clear();
            this.bsr.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bsn == null) {
            return 0;
        }
        return this.bsn.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bsn != null) {
            this.bsn.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bsn != null) {
            return this.bsn.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bsp == null || TextUtils.isEmpty(this.bsp.getFilePath())) {
            return 0;
        }
        if (this.bsq == null || this.bsq.size() == 0) {
            return 0;
        }
        int size = this.bsq.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bsq.get(i);
            if (imageFileInfo != null && this.bsp.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData V(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.brU.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData W(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.brU.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
