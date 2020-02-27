package com.baidu.searchbox.album.provider;

import android.support.annotation.NonNull;
import com.baidu.searchbox.ugc.bridge.AlbumProviderImpl_Factory;
/* loaded from: classes7.dex */
public class AlbumProviderManager {
    @NonNull
    public static IAlbumInterface getAlbumProvider() {
        return AlbumProviderImpl_Factory.get();
    }
}
