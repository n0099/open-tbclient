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
    private WriteImagesInfo bEA;
    private VideoFileInfo bEB;
    private ImageFileInfo bEC;
    private List<ImageFileInfo> bED;
    private final AlbumActivity bEh;
    private String bEu;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bEE = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bEh = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bEB = videoFileInfo;
    }

    public boolean TV() {
        return !ListUtils.isEmpty(TY());
    }

    public boolean TW() {
        return this.bEB != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bEB == null || videoFileInfo == null || this.bEB.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bEC = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bEA == null) {
            this.bEA = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bEA.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bEA != null) {
            this.bEA.delChooseFile(imageFileInfo);
        }
    }

    public void TX() {
        if (this.bEA != null) {
            this.bEA.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bEA == null) {
            return false;
        }
        return this.bEA.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> TY() {
        if (this.bEA != null) {
            return this.bEA.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo TZ() {
        return this.bEA;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bEA = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bEA != null) {
            return this.bEA.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bEA == null) {
            this.bEA = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bEA.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bEA != null) {
            return this.bEA.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Ua() {
        return this.bEu;
    }

    public void iv(String str) {
        this.bEu = str;
        iw(str);
    }

    private void iw(String str) {
        if (this.bEE != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bEE) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bED = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Ub() {
        return this.bED;
    }

    public List<AlbumData> Uc() {
        return this.bEE;
    }

    public List<MediaFileInfo> ix(String str) {
        if (this.bEE == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bEE) {
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
            arrayList.add(ad(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(ae(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bEE.clear();
            this.bEE.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bEA == null) {
            return 0;
        }
        return this.bEA.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bEA != null) {
            this.bEA.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bEA != null) {
            return this.bEA.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bEC == null || TextUtils.isEmpty(this.bEC.getFilePath())) {
            return 0;
        }
        if (this.bED == null || this.bED.size() == 0) {
            return 0;
        }
        int size = this.bED.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bED.get(i);
            if (imageFileInfo != null && this.bEC.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ad(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bEh.getPageContext().getString(a.h.sdk_ph_album_all_media));
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

    public AlbumData ae(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bEh.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
