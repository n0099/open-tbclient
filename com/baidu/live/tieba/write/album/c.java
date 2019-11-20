package com.baidu.live.tieba.write.album;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.album.MediaFileInfo;
import com.baidu.live.tbadk.album.ResutMediaStore;
import com.baidu.live.tbadk.album.VideoFileInfo;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private String apC;
    private WriteImagesInfo apI;
    private VideoFileInfo apJ;
    private ImageFileInfo apK;
    private List<ImageFileInfo> apL;
    private final AlbumActivity apq;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> apM = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.apq = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.apJ = videoFileInfo;
    }

    public boolean vW() {
        return !ListUtils.isEmpty(vZ());
    }

    public boolean vX() {
        return this.apJ != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.apJ == null || videoFileInfo == null || this.apJ.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.apK = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.apI == null) {
            this.apI = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.apI.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.apI != null) {
            this.apI.delChooseFile(imageFileInfo);
        }
    }

    public void vY() {
        if (this.apI != null) {
            this.apI.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.apI == null) {
            return false;
        }
        return this.apI.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> vZ() {
        if (this.apI != null) {
            return this.apI.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo wa() {
        return this.apI;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.apI = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.apI != null) {
            return this.apI.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.apI == null) {
            this.apI = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.apI.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.apI != null) {
            return this.apI.getMaxImagesAllowed();
        }
        return 0;
    }

    public String wb() {
        return this.apC;
    }

    public void cQ(String str) {
        this.apC = str;
        cR(str);
    }

    private void cR(String str) {
        if (this.apM != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.apM) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.apL = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> wc() {
        return this.apL;
    }

    public List<AlbumData> wd() {
        return this.apM;
    }

    public List<MediaFileInfo> cS(String str) {
        if (this.apM == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.apM) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean we() {
        return ListUtils.isEmpty(cS(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(K(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(L(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.apM.clear();
            this.apM.addAll(arrayList);
        }
    }

    public int size() {
        if (this.apI == null) {
            return 0;
        }
        return this.apI.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.apI != null) {
            this.apI.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.apI != null) {
            return this.apI.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.apK == null || TextUtils.isEmpty(this.apK.getFilePath())) {
            return 0;
        }
        if (this.apL == null || this.apL.size() == 0) {
            return 0;
        }
        int size = this.apL.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.apL.get(i);
            if (imageFileInfo != null && this.apK.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData K(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.apq.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData L(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.apq.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
