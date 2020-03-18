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
    private String aCH;
    private WriteImagesInfo aCN;
    private VideoFileInfo aCO;
    private ImageFileInfo aCP;
    private List<ImageFileInfo> aCQ;
    private final AlbumActivity aCw;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> aCR = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.aCw = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.aCO = videoFileInfo;
    }

    public boolean AK() {
        return !ListUtils.isEmpty(AN());
    }

    public boolean AL() {
        return this.aCO != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.aCO == null || videoFileInfo == null || this.aCO.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.aCP = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCN == null) {
            this.aCN = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCN.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.aCN != null) {
            this.aCN.delChooseFile(imageFileInfo);
        }
    }

    public void AM() {
        if (this.aCN != null) {
            this.aCN.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.aCN == null) {
            return false;
        }
        return this.aCN.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> AN() {
        if (this.aCN != null) {
            return this.aCN.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo AO() {
        return this.aCN;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.aCN = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.aCN != null) {
            return this.aCN.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.aCN == null) {
            this.aCN = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.aCN.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.aCN != null) {
            return this.aCN.getMaxImagesAllowed();
        }
        return 0;
    }

    public String AP() {
        return this.aCH;
    }

    public void dZ(String str) {
        this.aCH = str;
        ea(str);
    }

    private void ea(String str) {
        if (this.aCR != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.aCR) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aCQ = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> AQ() {
        return this.aCQ;
    }

    public List<AlbumData> AR() {
        return this.aCR;
    }

    public List<MediaFileInfo> eb(String str) {
        if (this.aCR == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.aCR) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean AS() {
        return ListUtils.isEmpty(eb(AlbumData.ALBUM_ID_ALL));
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
            this.aCR.clear();
            this.aCR.addAll(arrayList);
        }
    }

    public int size() {
        if (this.aCN == null) {
            return 0;
        }
        return this.aCN.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.aCN != null) {
            this.aCN.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.aCN != null) {
            return this.aCN.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.aCP == null || TextUtils.isEmpty(this.aCP.getFilePath())) {
            return 0;
        }
        if (this.aCQ == null || this.aCQ.size() == 0) {
            return 0;
        }
        int size = this.aCQ.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aCQ.get(i);
            if (imageFileInfo != null && this.aCP.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData H(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.aCw.getPageContext().getString(a.i.sdk_ph_album_all_media));
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
        albumData.setName(this.aCw.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
