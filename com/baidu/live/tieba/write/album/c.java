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
    private final AlbumActivity aWd;
    private String aWo;
    private WriteImagesInfo aWu;
    private VideoFileInfo aWv;
    private ImageFileInfo aWw;
    private List<ImageFileInfo> aWx;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aWy = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aWd = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aWv = videoFileInfo;
    }

    public boolean FI() {
        return !ListUtils.isEmpty(FL());
    }

    public boolean FJ() {
        return this.aWv != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aWv == null || videoFileInfo == null || this.aWv.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aWw = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aWu == null) {
            this.aWu = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aWu.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aWu != null) {
            this.aWu.delChooseFile(imageFileInfo);
        }
    }

    public void FK() {
        if (this.aWu != null) {
            this.aWu.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aWu == null) {
            return false;
        }
        return this.aWu.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> FL() {
        if (this.aWu != null) {
            return this.aWu.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo FM() {
        return this.aWu;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aWu = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aWu != null) {
            return this.aWu.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aWu == null) {
            this.aWu = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aWu.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aWu != null) {
            return this.aWu.getMaxImagesAllowed();
        }
        return 0;
    }

    public String FN() {
        return this.aWo;
    }

    public void eS(String str) {
        this.aWo = str;
        eT(str);
    }

    private void eT(String str) {
        if (this.aWy != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aWy) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aWx = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> FO() {
        return this.aWx;
    }

    public List<AlbumData> FP() {
        return this.aWy;
    }

    public List<MediaFileInfo> eU(String str) {
        if (this.aWy == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aWy) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean FQ() {
        return ListUtils.isEmpty(eU(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(M(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(N(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.aWy.clear();
            this.aWy.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aWu == null) {
            return 0;
        }
        return this.aWu.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aWu != null) {
            this.aWu.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aWu != null) {
            return this.aWu.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aWw == null || TextUtils.isEmpty(this.aWw.getFilePath())) {
            return 0;
        }
        if (this.aWx == null || this.aWx.size() == 0) {
            return 0;
        }
        int size = this.aWx.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aWx.get(i);
            if (imageFileInfo != null && this.aWw.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData M(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aWd.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData N(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.aWd.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
