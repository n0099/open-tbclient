package com.baidu.sumeru.universalimageloader.core.download;

import com.baidu.sumeru.universalimageloader.core.assist.FlushedInputStream;
import com.baidu.sumeru.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class SlowNetworkImageDownloader implements ImageDownloader {
    private final ImageDownloader wrappedDownloader;

    public SlowNetworkImageDownloader(ImageDownloader imageDownloader) {
        this.wrappedDownloader = imageDownloader;
    }

    @Override // com.baidu.sumeru.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        InputStream stream = this.wrappedDownloader.getStream(str, obj);
        switch (ImageDownloader.Scheme.ofUri(str)) {
            case HTTP:
            case HTTPS:
                return new FlushedInputStream(stream);
            default:
                return stream;
        }
    }
}
