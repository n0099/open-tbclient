package com.baidu.searchbox.download.model;
/* loaded from: classes3.dex */
public enum DownloadState {
    NOT_START,
    DOWNLOADING,
    DOWNLOAD_PAUSED,
    DOWNLOADED,
    DOWNLOAD_FAILED;

    public static DownloadState convert(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            return NOT_START;
                        }
                        return DOWNLOAD_FAILED;
                    }
                    return DOWNLOADED;
                }
                return DOWNLOAD_PAUSED;
            }
            return DOWNLOADING;
        }
        return DOWNLOADING;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DownloadState rawConvert(int i) {
        DownloadState downloadState;
        if (i != 190) {
            if (i != 200) {
                switch (i) {
                    case 192:
                        break;
                    case 193:
                    case 194:
                    case 195:
                    case 196:
                        downloadState = DOWNLOAD_PAUSED;
                        break;
                    default:
                        downloadState = NOT_START;
                        break;
                }
            } else {
                downloadState = DOWNLOADED;
            }
            if (!Downloads.isStatusError(i)) {
                return DOWNLOAD_FAILED;
            }
            return downloadState;
        }
        downloadState = DOWNLOADING;
        if (!Downloads.isStatusError(i)) {
        }
    }
}
