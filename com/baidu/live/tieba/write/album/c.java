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
    private final AlbumActivity boI;
    private String boV;
    private WriteImagesInfo bpb;
    private VideoFileInfo bpc;
    private ImageFileInfo bpd;
    private List<ImageFileInfo> bpe;
    private int maxImagesAllowed = 10;
    private final List<AlbumData> bpf = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.boI = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.bpc = videoFileInfo;
    }

    public boolean OK() {
        return !ListUtils.isEmpty(ON());
    }

    public boolean OL() {
        return this.bpc != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.bpc == null || videoFileInfo == null || this.bpc.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.bpd = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bpb == null) {
            this.bpb = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bpb.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.bpb != null) {
            this.bpb.delChooseFile(imageFileInfo);
        }
    }

    public void OM() {
        if (this.bpb != null) {
            this.bpb.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.bpb == null) {
            return false;
        }
        return this.bpb.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> ON() {
        if (this.bpb != null) {
            return this.bpb.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo OO() {
        return this.bpb;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.bpb = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.bpb != null) {
            return this.bpb.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.bpb == null) {
            this.bpb = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.bpb.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.bpb != null) {
            return this.bpb.getMaxImagesAllowed();
        }
        return 0;
    }

    public String OP() {
        return this.boV;
    }

    public void he(String str) {
        this.boV = str;
        hf(str);
    }

    private void hf(String str) {
        if (this.bpf != null && !StringUtils.isNull(str)) {
            for (AlbumData albumData : this.bpf) {
                if (albumData != null && TextUtils.equals(str, albumData.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (albumData.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : albumData.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bpe = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> OQ() {
        return this.bpe;
    }

    public List<AlbumData> OR() {
        return this.bpf;
    }

    public List<MediaFileInfo> hg(String str) {
        if (this.bpf == null || StringUtils.isNull(str)) {
            return null;
        }
        for (AlbumData albumData : this.bpf) {
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
            this.bpf.clear();
            this.bpf.addAll(arrayList);
        }
    }

    public int size() {
        if (this.bpb == null) {
            return 0;
        }
        return this.bpb.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.bpb != null) {
            this.bpb.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.bpb != null) {
            return this.bpb.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.bpd == null || TextUtils.isEmpty(this.bpd.getFilePath())) {
            return 0;
        }
        if (this.bpe == null || this.bpe.size() == 0) {
            return 0;
        }
        int size = this.bpe.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bpe.get(i);
            if (imageFileInfo != null && this.bpd.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public AlbumData S(List<MediaFileInfo> list) {
        AlbumData albumData = new AlbumData();
        albumData.setAlbumId(AlbumData.ALBUM_ID_ALL);
        albumData.setName(this.boI.getPageContext().getString(a.i.sdk_ph_album_all_media));
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
        albumData.setName(this.boI.getPageContext().getString(a.i.sdk_ph_album_all_video));
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
