package com.baidu.minivideo.arface.b;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes11.dex */
public class a {
    private static com.baidu.minivideo.arface.a.b ckL = new com.baidu.minivideo.arface.a.b() { // from class: com.baidu.minivideo.arface.b.a.1
        @Override // com.baidu.minivideo.arface.a.b
        public void a(String str, String str2, String str3, final com.baidu.minivideo.arface.a.a aVar) {
            com.baidu.tieba.ala.alaar.sticker.download.b.bSX().a(str, str2, str3, new com.baidu.tieba.ala.alaar.sticker.download.a.a() { // from class: com.baidu.minivideo.arface.b.a.1.1
                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onStarted() {
                    if (aVar != null) {
                        aVar.onStarted();
                    }
                    super.onStarted();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onConnecting() {
                    super.onConnecting();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onConnected(long j, boolean z) {
                    if (aVar != null) {
                        aVar.onConnected(j, z);
                    }
                    super.onConnected(j, z);
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onProgress(long j, long j2, int i) {
                    if (aVar != null) {
                        aVar.onProgress(j, j2, i);
                    }
                    super.onProgress(j, j2, i);
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onCompleted(String str4) {
                    if (aVar != null) {
                        aVar.onCompleted(str4);
                    }
                    super.onCompleted(str4);
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onDownloadPaused() {
                    if (aVar != null) {
                        aVar.onDownloadPaused();
                    }
                    super.onDownloadPaused();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void onDownloadCanceled() {
                    if (aVar != null) {
                        aVar.onDownloadCanceled();
                    }
                    super.onDownloadCanceled();
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.download.a.a
                public void a(DownloadException downloadException) {
                    if (aVar != null) {
                        aVar.onFailed(downloadException);
                    }
                    super.a(downloadException);
                }
            });
        }
    };

    public static void init() {
        com.baidu.minivideo.arface.b.a(ckL);
    }
}
