package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.r.a;
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
    private final AlbumActivity axQ;
    private String ayb;
    private WriteImagesInfo ayh;
    private VideoFileInfo ayi;
    private ImageFileInfo ayj;
    private List<ImageFileInfo> ayk;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> ayl = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.axQ = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.ayi = videoFileInfo;
    }

    public boolean yk() {
        return !ListUtils.isEmpty(yn());
    }

    public boolean yl() {
        return this.ayi != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.ayi == null || videoFileInfo == null || this.ayi.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.ayj = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ayh == null) {
            this.ayh = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.ayh.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.ayh != null) {
            this.ayh.delChooseFile(imageFileInfo);
        }
    }

    public void ym() {
        if (this.ayh != null) {
            this.ayh.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.ayh == null) {
            return false;
        }
        return this.ayh.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> yn() {
        if (this.ayh != null) {
            return this.ayh.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo yo() {
        return this.ayh;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.ayh = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.ayh != null) {
            return this.ayh.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.ayh == null) {
            this.ayh = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.ayh.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.ayh != null) {
            return this.ayh.getMaxImagesAllowed();
        }
        return 0;
    }

    public String yp() {
        return this.ayb;
    }

    public void dL(String str) {
        this.ayb = str;
        dM(str);
    }

    private void dM(String str) {
        if (this.ayl != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.ayl) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.ayk = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> yq() {
        return this.ayk;
    }

    public List<AlbumData> yr() {
        return this.ayl;
    }

    public List<MediaFileInfo> dN(String str) {
        if (this.ayl == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.ayl) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean ys() {
        return ListUtils.isEmpty(dN(AlbumData.ALBUM_ID_ALL));
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
            this.ayl.clear();
            this.ayl.addAll(arrayList);
        }
    }

    public int size() {
        if (this.ayh == null) {
            return 0;
        }
        return this.ayh.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.ayh != null) {
            this.ayh.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.ayh != null) {
            return this.ayh.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.ayj == null || TextUtils.isEmpty(this.ayj.getFilePath())) {
            return 0;
        }
        if (this.ayk == null || this.ayk.size() == 0) {
            return 0;
        }
        int size = this.ayk.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.ayk.get(i);
            if (imageFileInfo != null && this.ayj.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData H(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.axQ.getPageContext().getString(a.i.sdk_ph_album_all_media));
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
        albumData.setName(this.axQ.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
