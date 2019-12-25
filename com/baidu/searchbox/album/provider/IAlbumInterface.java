package com.baidu.searchbox.album.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.provider.listener.OnDeletePreviewPhotoListener;
import com.baidu.searchbox.ugc.provider.listener.OnSelectPhotoListener;
import java.util.List;
/* loaded from: classes11.dex */
public interface IAlbumInterface {
    public static final IAlbumInterface EMPTY = new IAlbumInterface() { // from class: com.baidu.searchbox.album.provider.IAlbumInterface.1
        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void openImagePicker(Context context, OnSelectPhotoListener onSelectPhotoListener) {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void openImagePicker(Context context, boolean z, int i, OnSelectPhotoListener onSelectPhotoListener) {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void openPreviewer(Context context, List<String> list, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void openPreviewer(Context context, List<String> list, int i, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener) {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void clearSelectedImages() {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public List<ImageStruct> getSelectedImages() {
            return null;
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void removeSelectedImage(ImageStruct imageStruct) {
        }

        @Override // com.baidu.searchbox.album.provider.IAlbumInterface
        public void setSelectedImages(ImageStruct imageStruct) {
        }
    };

    void clearSelectedImages();

    List<ImageStruct> getSelectedImages();

    void openImagePicker(Context context, OnSelectPhotoListener onSelectPhotoListener);

    void openImagePicker(Context context, boolean z, int i, OnSelectPhotoListener onSelectPhotoListener);

    void openPreviewer(Context context, List<String> list, int i, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener);

    void openPreviewer(Context context, List<String> list, OnDeletePreviewPhotoListener onDeletePreviewPhotoListener);

    void removeSelectedImage(ImageStruct imageStruct);

    void setSelectedImages(ImageStruct imageStruct);

    /* loaded from: classes11.dex */
    public static final class Impl {
        private static IAlbumInterface sAlbumProvider = AlbumProviderManager.getAlbumProvider();

        private Impl() {
        }

        @NonNull
        public static IAlbumInterface get() {
            if (sAlbumProvider == null) {
                sAlbumProvider = IAlbumInterface.EMPTY;
            }
            return sAlbumProvider;
        }
    }
}
