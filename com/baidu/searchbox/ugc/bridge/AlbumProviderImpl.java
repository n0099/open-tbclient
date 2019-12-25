package com.baidu.searchbox.ugc.bridge;

import android.content.Context;
import com.baidu.searchbox.album.provider.IAlbumInterface;
import com.baidu.searchbox.ugc.activity.LocalAlbumActivity;
import com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.provider.listener.OnDeletePreviewPhotoListener;
import com.baidu.searchbox.ugc.provider.listener.OnSelectPhotoListener;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlbumProviderImpl implements IAlbumInterface {
    private static final String COMMENT_VALUE = "comment";
    UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void openImagePicker(Context context, OnSelectPhotoListener onSelectPhotoListener) {
        openImagePicker(context, false, SelectUtil.MAX_SELECTED_DEFAULT, onSelectPhotoListener);
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void openImagePicker(Context context, boolean z, int i, OnSelectPhotoListener onSelectPhotoListener) {
        this.ugcSchemeModel.from = 0;
        this.ugcSchemeModel.supportSingleSelect = z;
        if (z) {
            this.ugcSchemeModel.maxSelected = 1;
        } else if (i > 0 && i <= SelectUtil.MAX_SELECTED_DEFAULT) {
            this.ugcSchemeModel.maxSelected = i;
        } else {
            this.ugcSchemeModel.maxSelected = SelectUtil.MAX_SELECTED_DEFAULT;
        }
        LocalAlbumActivity.startActivity(context, this.ugcSchemeModel, onSelectPhotoListener);
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void openPreviewer(Context context, List<String> list, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        openPreviewer(context, list, 0, onDeletePreviewPhotoListener);
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void openPreviewer(Context context, List<String> list, int i, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                ImageStruct imageStruct = new ImageStruct(str);
                if (imageStruct.contentUri != null) {
                    arrayList.add(imageStruct);
                }
            }
            SelectUtil.setSeletedImages(arrayList);
            LocalPhotoPreviewActivity.openPreviewer(context, "comment", i, onDeletePreviewPhotoListener);
        }
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void clearSelectedImages() {
        SelectUtil.clear();
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public List<ImageStruct> getSelectedImages() {
        return SelectUtil.getSeletedImages();
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void removeSelectedImage(ImageStruct imageStruct) {
        SelectUtil.removeSelectedImags(imageStruct);
    }

    @Override // com.baidu.searchbox.album.provider.IAlbumInterface
    public void setSelectedImages(ImageStruct imageStruct) {
        SelectUtil.saveSelectedImages(imageStruct);
    }
}
