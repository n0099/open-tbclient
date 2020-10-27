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
    private final AlbumActivity bxW;
    private String byj;
    private WriteImagesInfo byp;
    private VideoFileInfo byq;
    private ImageFileInfo byr;
    private List<ImageFileInfo> bys;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> byt = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bxW = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.byq = videoFileInfo;
    }

    public boolean Rn() {
        return !ListUtils.isEmpty(Rq());
    }

    public boolean Ro() {
        return this.byq != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.byq == null || videoFileInfo == null || this.byq.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.byr = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.byp == null) {
            this.byp = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.byp.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.byp != null) {
            this.byp.delChooseFile(imageFileInfo);
        }
    }

    public void Rp() {
        if (this.byp != null) {
            this.byp.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.byp == null) {
            return false;
        }
        return this.byp.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> Rq() {
        if (this.byp != null) {
            return this.byp.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo Rr() {
        return this.byp;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.byp = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.byp != null) {
            return this.byp.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.byp == null) {
            this.byp = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.byp.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.byp != null) {
            return this.byp.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Rs() {
        return this.byj;
    }

    public void ic(String str) {
        this.byj = str;
        id(str);
    }

    private void id(String str) {
        if (this.byt != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.byt) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bys = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Rt() {
        return this.bys;
    }

    public List<AlbumData> Ru() {
        return this.byt;
    }

    public List<MediaFileInfo> ie(String str) {
        if (this.byt == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.byt) {
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
            arrayList.add(Y(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(Z(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.byt.clear();
            this.byt.addAll(arrayList);
        }
    }

    public int size() {
        if (this.byp == null) {
            return 0;
        }
        return this.byp.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.byp != null) {
            this.byp.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.byp != null) {
            return this.byp.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.byr == null || TextUtils.isEmpty(this.byr.getFilePath())) {
            return 0;
        }
        if (this.bys == null || this.bys.size() == 0) {
            return 0;
        }
        int size = this.bys.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bys.get(i);
            if (imageFileInfo != null && this.byr.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData Y(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bxW.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData Z(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bxW.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
