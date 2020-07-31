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
    private final AlbumActivity bjd;
    private String bjq;
    private WriteImagesInfo bjw;
    private VideoFileInfo bjx;
    private ImageFileInfo bjy;
    private List<ImageFileInfo> bjz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bjA = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bjd = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bjx = videoFileInfo;
    }

    public boolean IR() {
        return !ListUtils.isEmpty(IU());
    }

    public boolean IS() {
        return this.bjx != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bjx == null || videoFileInfo == null || this.bjx.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bjy = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bjw == null) {
            this.bjw = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bjw.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bjw != null) {
            this.bjw.delChooseFile(imageFileInfo);
        }
    }

    public void IT() {
        if (this.bjw != null) {
            this.bjw.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bjw == null) {
            return false;
        }
        return this.bjw.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> IU() {
        if (this.bjw != null) {
            return this.bjw.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo IV() {
        return this.bjw;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bjw = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bjw != null) {
            return this.bjw.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bjw == null) {
            this.bjw = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bjw.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bjw != null) {
            return this.bjw.getMaxImagesAllowed();
        }
        return 0;
    }

    public String IW() {
        return this.bjq;
    }

    public void fK(String str) {
        this.bjq = str;
        fL(str);
    }

    private void fL(String str) {
        if (this.bjA != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bjA) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bjz = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> IX() {
        return this.bjz;
    }

    public List<AlbumData> IY() {
        return this.bjA;
    }

    public List<MediaFileInfo> fM(String str) {
        if (this.bjA == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bjA) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean IZ() {
        return ListUtils.isEmpty(fM(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(R(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(S(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bjA.clear();
            this.bjA.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bjw == null) {
            return 0;
        }
        return this.bjw.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bjw != null) {
            this.bjw.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bjw != null) {
            return this.bjw.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bjy == null || TextUtils.isEmpty(this.bjy.getFilePath())) {
            return 0;
        }
        if (this.bjz == null || this.bjz.size() == 0) {
            return 0;
        }
        int size = this.bjz.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bjz.get(i);
            if (imageFileInfo != null && this.bjy.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData R(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bjd.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData S(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bjd.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
