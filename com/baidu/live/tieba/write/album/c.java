package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private ImageFileInfo axA;
    private List<ImageFileInfo> axB;
    private final AlbumActivity axh;
    private String axs;
    private WriteImagesInfo axy;
    private VideoFileInfo axz;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> axC = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.axh = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.axz = videoFileInfo;
    }

    public boolean xU() {
        return !ListUtils.isEmpty(xX());
    }

    public boolean xV() {
        return this.axz != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.axz == null || videoFileInfo == null || this.axz.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.axA = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.axy == null) {
            this.axy = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.axy.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.axy != null) {
            this.axy.delChooseFile(imageFileInfo);
        }
    }

    public void xW() {
        if (this.axy != null) {
            this.axy.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.axy == null) {
            return false;
        }
        return this.axy.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> xX() {
        if (this.axy != null) {
            return this.axy.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo xY() {
        return this.axy;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.axy = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.axy != null) {
            return this.axy.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.axy == null) {
            this.axy = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.axy.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.axy != null) {
            return this.axy.getMaxImagesAllowed();
        }
        return 0;
    }

    public String xZ() {
        return this.axs;
    }

    public void dJ(String str) {
        this.axs = str;
        dK(str);
    }

    private void dK(String str) {
        if (this.axC != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.axC) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.axB = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> ya() {
        return this.axB;
    }

    public List<AlbumData> yb() {
        return this.axC;
    }

    public List<MediaFileInfo> dL(String str) {
        if (this.axC == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.axC) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean yc() {
        return ListUtils.isEmpty(dL(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(I(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(J(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.axC.clear();
            this.axC.addAll(arrayList);
        }
    }

    public int size() {
        if (this.axy == null) {
            return 0;
        }
        return this.axy.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.axy != null) {
            this.axy.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.axy != null) {
            return this.axy.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.axA == null || TextUtils.isEmpty(this.axA.getFilePath())) {
            return 0;
        }
        if (this.axB == null || this.axB.size() == 0) {
            return 0;
        }
        int size = this.axB.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.axB.get(i);
            if (imageFileInfo != null && this.axA.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData I(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.axh.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData J(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.axh.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
