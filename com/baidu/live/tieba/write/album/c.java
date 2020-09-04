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
/* loaded from: classes7.dex */
public class c {
    private final AlbumActivity boL;
    private String boY;
    private WriteImagesInfo bpe;
    private VideoFileInfo bpf;
    private ImageFileInfo bpg;
    private List<ImageFileInfo> bph;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bpi = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.boL = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bpf = videoFileInfo;
    }

    public boolean OK() {
        return !ListUtils.isEmpty(ON());
    }

    public boolean OL() {
        return this.bpf != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bpf == null || videoFileInfo == null || this.bpf.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bpg = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bpe == null) {
            this.bpe = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bpe.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bpe != null) {
            this.bpe.delChooseFile(imageFileInfo);
        }
    }

    public void OM() {
        if (this.bpe != null) {
            this.bpe.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bpe == null) {
            return false;
        }
        return this.bpe.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> ON() {
        if (this.bpe != null) {
            return this.bpe.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo OO() {
        return this.bpe;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bpe = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bpe != null) {
            return this.bpe.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bpe == null) {
            this.bpe = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bpe.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bpe != null) {
            return this.bpe.getMaxImagesAllowed();
        }
        return 0;
    }

    public String OP() {
        return this.boY;
    }

    public void hf(String str) {
        this.boY = str;
        hg(str);
    }

    private void hg(String str) {
        if (this.bpi != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bpi) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bph = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> OQ() {
        return this.bph;
    }

    public List<AlbumData> OR() {
        return this.bpi;
    }

    public List<MediaFileInfo> hh(String str) {
        if (this.bpi == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bpi) {
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
            arrayList.add(S(list));
            if (!ListUtils.isEmpty(resutMediaStore.videoFileList)) {
                arrayList.add(T(resutMediaStore.videoFileList));
            }
            if (!ListUtils.isEmpty(resutMediaStore.albumList)) {
                arrayList.addAll(resutMediaStore.albumList);
            }
            this.bpi.clear();
            this.bpi.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bpe == null) {
            return 0;
        }
        return this.bpe.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bpe != null) {
            this.bpe.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bpe != null) {
            return this.bpe.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bpg == null || TextUtils.isEmpty(this.bpg.getFilePath())) {
            return 0;
        }
        if (this.bph == null || this.bph.size() == 0) {
            return 0;
        }
        int size = this.bph.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bph.get(i);
            if (imageFileInfo != null && this.bpg.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData S(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.boL.getPageContext().getString(a.i.sdk_ph_album_all_media));
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

    public AlbumData T(List<VideoFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_VIDEO);
        albumData.setName(this.boL.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
