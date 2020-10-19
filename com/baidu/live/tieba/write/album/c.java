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
    private final AlbumActivity bvI;
    private String bvV;
    private WriteImagesInfo bwb;
    private VideoFileInfo bwc;
    private ImageFileInfo bwd;
    private List<ImageFileInfo> bwe;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bwf = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bvI = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bwc = videoFileInfo;
    }

    public boolean Qs() {
        return !ListUtils.isEmpty(Qv());
    }

    public boolean Qt() {
        return this.bwc != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bwc == null || videoFileInfo == null || this.bwc.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bwd = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bwb == null) {
            this.bwb = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bwb.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bwb != null) {
            this.bwb.delChooseFile(imageFileInfo);
        }
    }

    public void Qu() {
        if (this.bwb != null) {
            this.bwb.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bwb == null) {
            return false;
        }
        return this.bwb.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> Qv() {
        if (this.bwb != null) {
            return this.bwb.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo Qw() {
        return this.bwb;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bwb = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bwb != null) {
            return this.bwb.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bwb == null) {
            this.bwb = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bwb.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bwb != null) {
            return this.bwb.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Qx() {
        return this.bvV;
    }

    public void hM(String str) {
        this.bvV = str;
        hN(str);
    }

    private void hN(String str) {
        if (this.bwf != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bwf) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bwe = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Qy() {
        return this.bwe;
    }

    public List<AlbumData> Qz() {
        return this.bwf;
    }

    public List<MediaFileInfo> hO(String str) {
        if (this.bwf == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bwf) {
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
            arrayList.add(X(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(Y(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bwf.clear();
            this.bwf.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bwb == null) {
            return 0;
        }
        return this.bwb.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bwb != null) {
            this.bwb.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bwb != null) {
            return this.bwb.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bwd == null || TextUtils.isEmpty(this.bwd.getFilePath())) {
            return 0;
        }
        if (this.bwe == null || this.bwe.size() == 0) {
            return 0;
        }
        int size = this.bwe.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bwe.get(i);
            if (imageFileInfo != null && this.bwd.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData X(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bvI.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData Y(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bvI.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
