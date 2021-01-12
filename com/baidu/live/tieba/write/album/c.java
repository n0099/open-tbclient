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
    private final AlbumActivity bHF;
    private String bHT;
    private WriteImagesInfo bHZ;
    private VideoFileInfo bIa;
    private ImageFileInfo bIb;
    private List<ImageFileInfo> bIc;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bId = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bHF = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bIa = videoFileInfo;
    }

    public boolean SW() {
        return !ListUtils.isEmpty(SZ());
    }

    public boolean SX() {
        return this.bIa != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bIa == null || videoFileInfo == null || this.bIa.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bIb = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bHZ == null) {
            this.bHZ = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bHZ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bHZ != null) {
            this.bHZ.delChooseFile(imageFileInfo);
        }
    }

    public void SY() {
        if (this.bHZ != null) {
            this.bHZ.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bHZ == null) {
            return false;
        }
        return this.bHZ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> SZ() {
        if (this.bHZ != null) {
            return this.bHZ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo Ta() {
        return this.bHZ;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bHZ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bHZ != null) {
            return this.bHZ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bHZ == null) {
            this.bHZ = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bHZ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bHZ != null) {
            return this.bHZ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Tb() {
        return this.bHT;
    }

    public void hx(String str) {
        this.bHT = str;
        hy(str);
    }

    private void hy(String str) {
        if (this.bId != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bId) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bIc = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Tc() {
        return this.bIc;
    }

    public List<AlbumData> Td() {
        return this.bId;
    }

    public List<MediaFileInfo> hz(String str) {
        if (this.bId == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bId) {
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
            this.bId.clear();
            this.bId.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bHZ == null) {
            return 0;
        }
        return this.bHZ.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bHZ != null) {
            this.bHZ.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bHZ != null) {
            return this.bHZ.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bIb == null || TextUtils.isEmpty(this.bIb.getFilePath())) {
            return 0;
        }
        if (this.bIc == null || this.bIc.size() == 0) {
            return 0;
        }
        int size = this.bIc.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bIc.get(i);
            if (imageFileInfo != null && this.bIb.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ag(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bHF.getPageContext().getString(a.h.sdk_ph_album_all_media));
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
        albumData.setName(this.bHF.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
