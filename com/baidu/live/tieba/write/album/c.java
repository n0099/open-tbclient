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
/* loaded from: classes3.dex */
public class c {
    private final AlbumActivity biJ;
    private String biW;
    private WriteImagesInfo bjc;
    private VideoFileInfo bjd;
    private ImageFileInfo bje;
    private List<ImageFileInfo> bjf;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bjg = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.biJ = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bjd = videoFileInfo;
    }

    public boolean IL() {
        return !ListUtils.isEmpty(IO());
    }

    public boolean IM() {
        return this.bjd != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bjd == null || videoFileInfo == null || this.bjd.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bje = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bjc == null) {
            this.bjc = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bjc.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bjc != null) {
            this.bjc.delChooseFile(imageFileInfo);
        }
    }

    public void IN() {
        if (this.bjc != null) {
            this.bjc.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bjc == null) {
            return false;
        }
        return this.bjc.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> IO() {
        if (this.bjc != null) {
            return this.bjc.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo IP() {
        return this.bjc;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bjc = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bjc != null) {
            return this.bjc.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bjc == null) {
            this.bjc = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bjc.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bjc != null) {
            return this.bjc.getMaxImagesAllowed();
        }
        return 0;
    }

    public String IQ() {
        return this.biW;
    }

    public void fM(String str) {
        this.biW = str;
        fN(str);
    }

    private void fN(String str) {
        if (this.bjg != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bjg) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bjf = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> IR() {
        return this.bjf;
    }

    public List<AlbumData> IS() {
        return this.bjg;
    }

    public List<MediaFileInfo> fO(String str) {
        if (this.bjg == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bjg) {
            if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                return albumData.getFileList();
            }
        }
        return null;
    }

    public boolean IT() {
        return ListUtils.isEmpty(fO(AlbumData.ALBUM_ID_ALL));
    }

    public void a(ResutMediaStore resutMediaStore) {
        if (resutMediaStore != null) {
            List<MediaFileInfo> list = resutMediaStore.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(R(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(S(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bjg.clear();
            this.bjg.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bjc == null) {
            return 0;
        }
        return this.bjc.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bjc != null) {
            this.bjc.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bjc != null) {
            return this.bjc.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bje == null || TextUtils.isEmpty(this.bje.getFilePath())) {
            return 0;
        }
        if (this.bjf == null || this.bjf.size() == 0) {
            return 0;
        }
        int size = this.bjf.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bjf.get(i);
            if (imageFileInfo != null && this.bje.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData R(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.biJ.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData S(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.biJ.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
