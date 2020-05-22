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
    private String bdJ;
    private WriteImagesInfo bdP;
    private VideoFileInfo bdQ;
    private ImageFileInfo bdR;
    private List<ImageFileInfo> bdS;
    private final AlbumActivity bdw;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bdT = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.bdw = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bdQ = videoFileInfo;
    }

    public boolean Hy() {
        return !ListUtils.isEmpty(HB());
    }

    public boolean Hz() {
        return this.bdQ != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bdQ == null || videoFileInfo == null || this.bdQ.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bdR = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bdP == null) {
            this.bdP = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bdP.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bdP != null) {
            this.bdP.delChooseFile(imageFileInfo);
        }
    }

    public void HA() {
        if (this.bdP != null) {
            this.bdP.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bdP == null) {
            return false;
        }
        return this.bdP.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> HB() {
        if (this.bdP != null) {
            return this.bdP.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo HC() {
        return this.bdP;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bdP = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bdP != null) {
            return this.bdP.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bdP == null) {
            this.bdP = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bdP.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bdP != null) {
            return this.bdP.getMaxImagesAllowed();
        }
        return 0;
    }

    public String HD() {
        return this.bdJ;
    }

    public void fE(String str) {
        this.bdJ = str;
        fF(str);
    }

    private void fF(String str) {
        if (this.bdT != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bdT) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bdS = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> HE() {
        return this.bdS;
    }

    public List<AlbumData> HF() {
        return this.bdT;
    }

    public List<MediaFileInfo> fG(String str) {
        if (this.bdT == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bdT) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean HG() {
        return ListUtils.isEmpty(fG(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(N(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(O(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bdT.clear();
            this.bdT.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bdP == null) {
            return 0;
        }
        return this.bdP.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bdP != null) {
            this.bdP.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bdP != null) {
            return this.bdP.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bdR == null || TextUtils.isEmpty(this.bdR.getFilePath())) {
            return 0;
        }
        if (this.bdS == null || this.bdS.size() == 0) {
            return 0;
        }
        int size = this.bdS.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bdS.get(i);
            if (imageFileInfo != null && this.bdR.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData N(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.bdw.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData O(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.bdw.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
