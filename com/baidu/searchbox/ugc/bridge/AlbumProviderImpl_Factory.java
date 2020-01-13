package com.baidu.searchbox.ugc.bridge;
/* loaded from: classes5.dex */
public class AlbumProviderImpl_Factory {
    private static volatile AlbumProviderImpl instance;

    private AlbumProviderImpl_Factory() {
    }

    public static synchronized AlbumProviderImpl get() {
        AlbumProviderImpl albumProviderImpl;
        synchronized (AlbumProviderImpl_Factory.class) {
            if (instance == null) {
                instance = new AlbumProviderImpl();
            }
            albumProviderImpl = instance;
        }
        return albumProviderImpl;
    }
}
