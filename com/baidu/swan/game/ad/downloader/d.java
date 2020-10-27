package com.baidu.swan.game.ad.downloader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes14.dex */
public class d extends com.baidu.swan.apps.process.a.b.c.c {
    private com.baidu.swan.apps.adlanding.download.a.a dGu;
    private SwanAppDownloadAction.SwanAppDownloadType dGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.baidu.swan.apps.adlanding.download.a.a aVar, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        this.dGu = aVar;
        this.dGv = swanAppDownloadType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.process.a.b.c.a
    public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
        Bundle result = bVar.getResult();
        if (result != null) {
            int i = result.getInt("state", SwanAdDownloadState.NOT_START.value());
            int i2 = result.getInt("progress", 0);
            SwanAdDownloadState convert = SwanAdDownloadState.convert(i);
            this.dGu.a(convert, i2);
            this.dGu.b(convert, i2);
            String string = result.getString("packageName", "");
            if (!TextUtils.isEmpty(string)) {
                this.dGu.km(string);
            }
            if (this.dGv == SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD) {
                this.dGu.eh(true);
            }
        }
    }

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public boolean aCy() {
        return false;
    }

    @Override // com.baidu.swan.apps.process.a.b.c.a
    public long getTimeoutMillis() {
        return 0L;
    }
}
