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
    private String bCJ;
    private WriteImagesInfo bCP;
    private VideoFileInfo bCQ;
    private ImageFileInfo bCR;
    private List<ImageFileInfo> bCS;
    private final AlbumActivity bCw;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bCT = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bCw = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bCQ = videoFileInfo;
    }

    public boolean Tm() {
        return !ListUtils.isEmpty(Tp());
    }

    public boolean Tn() {
        return this.bCQ != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bCQ == null || videoFileInfo == null || this.bCQ.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bCR = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bCP == null) {
            this.bCP = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bCP.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bCP != null) {
            this.bCP.delChooseFile(imageFileInfo);
        }
    }

    public void To() {
        if (this.bCP != null) {
            this.bCP.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bCP == null) {
            return false;
        }
        return this.bCP.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> Tp() {
        if (this.bCP != null) {
            return this.bCP.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo Tq() {
        return this.bCP;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bCP = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bCP != null) {
            return this.bCP.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bCP == null) {
            this.bCP = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bCP.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bCP != null) {
            return this.bCP.getMaxImagesAllowed();
        }
        return 0;
    }

    public String Tr() {
        return this.bCJ;
    }

    public void ip(String str) {
        this.bCJ = str;
        iq(str);
    }

    private void iq(String str) {
        if (this.bCT != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bCT) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bCS = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Ts() {
        return this.bCS;
    }

    public List<AlbumData> Tt() {
        return this.bCT;
    }

    public List<MediaFileInfo> ir(String str) {
        if (this.bCT == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bCT) {
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
            this.bCT.clear();
            this.bCT.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bCP == null) {
            return 0;
        }
        return this.bCP.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bCP != null) {
            this.bCP.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bCP != null) {
            return this.bCP.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bCR == null || TextUtils.isEmpty(this.bCR.getFilePath())) {
            return 0;
        }
        if (this.bCS == null || this.bCS.size() == 0) {
            return 0;
        }
        int size = this.bCS.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bCS.get(i);
            if (imageFileInfo != null && this.bCR.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData ad(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bCw.getPageContext().getString(a.h.sdk_ph_album_all_media));
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
        albumData.setName(this.bCw.getPageContext().getString(a.h.sdk_ph_album_all_video));
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
