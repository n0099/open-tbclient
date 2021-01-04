package com.baidu.sumeru.universalimageloader.core.download;

import com.baidu.sumeru.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class NetworkDeniedImageDownloader implements ImageDownloader {
    private final ImageDownloader wrappedDownloader;

    public NetworkDeniedImageDownloader(ImageDownloader imageDownloader) {
        this.wrappedDownloader = imageDownloader;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (ImageDownloader.Scheme.ofUri(str)) {
            case HTTP:
            case HTTPS:
                throw new IllegalStateException();
            default:
                return this.wrappedDownloader.getStream(str, obj);
        }
    }
}
