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
/* loaded from: classes11.dex */
public class c {
    private String bLD;
    private WriteImagesInfo bLJ;
    private VideoFileInfo bLK;
    private ImageFileInfo bLL;
    private List<ImageFileInfo> bLM;
    private final AlbumActivity bLp;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bLN = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bLp = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bLK = videoFileInfo;
    }

    public boolean UD() {
        return !ListUtils.isEmpty(UG());
    }

    public boolean UE() {
        return this.bLK != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bLK == null || videoFileInfo == null || this.bLK.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bLL = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bLJ == null) {
            this.bLJ = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bLJ.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bLJ != null) {
            this.bLJ.delChooseFile(imageFileInfo);
        }
    }

    public void UF() {
        if (this.bLJ != null) {
            this.bLJ.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bLJ == null) {
            return false;
        }
        return this.bLJ.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> UG() {
        if (this.bLJ != null) {
            return this.bLJ.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo UH() {
        return this.bLJ;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bLJ = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bLJ != null) {
            return this.bLJ.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bLJ == null) {
            this.bLJ = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bLJ.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bLJ != null) {
            return this.bLJ.getMaxImagesAllowed();
        }
        return 0;
    }

    public String UI() {
        return this.bLD;
    }

    public void hT(String str) {
        this.bLD = str;
        hU(str);
    }

    private void hU(String str) {
        if (this.bLN != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bLN) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bLM = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> UJ() {
        return this.bLM;
    }

    public List<AlbumData> UK() {
        return this.bLN;
    }

    public List<MediaFileInfo> hV(String str) {
        if (this.bLN == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bLN) {
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
            this.bLN.clear();
            this.bLN.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bLJ == null) {
            return 0;
        }
        return this.bLJ.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bLJ != null) {
            this.bLJ.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bLJ != null) {
            return this.bLJ.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bLL == null || TextUtils.isEmpty(this.bLL.getFilePath())) {
            return 0;
        }
        if (this.bLM == null || this.bLM.size() == 0) {
            return 0;
        }
        int size = this.bLM.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bLM.get(i);
            if (imageFileInfo != null && this.bLL.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ah(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bLp.getPageContext().getString(a.h.sdk_ph_album_all_media));
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
        albumData.setName(this.bLp.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
