package com.baidu.cyberplayer.sdk.extractor;

import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
/* loaded from: classes3.dex */
public class ExtractorProviderFactory {
    public static ExtractorProviderFactory sPlayerFactory;

    public static synchronized ExtractorProviderFactory getInstance() {
        ExtractorProviderFactory extractorProviderFactory;
        synchronized (ExtractorProviderFactory.class) {
            if (sPlayerFactory == null) {
                sPlayerFactory = new ExtractorProviderFactory();
            }
            extractorProviderFactory = sPlayerFactory;
        }
        return extractorProviderFactory;
    }

    public ExtractorProvider createExtractor(boolean z) {
        ExtractorProvider extractorProvider;
        if (z) {
            extractorProvider = RemoteExtractorProxy.createExtractor();
        } else {
            extractorProvider = null;
        }
        if (extractorProvider == null) {
            extractorProvider = CyberPlayerCoreInvoker.createCyberExtractor();
        }
        if (extractorProvider == null) {
            return new MediaExtractorImpl();
        }
        return extractorProvider;
    }
}
