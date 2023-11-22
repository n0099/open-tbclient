package com.baidu.searchbox.task.sync.appcreate;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTask;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.rna;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/task/sync/appcreate/InitAutoRestartDownloadTask;", "Lcom/baidu/searchbox/performance/speed/task/LaunchTask;", "()V", "execute", "", "getName", "", "getProcess", "", "string2Item", "Lcom/baidu/tbadk/core/data/ItemData;", "itemString", "Main_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitAutoRestartDownloadTask extends LaunchTask {
    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public String getName() {
        return "AppCreate_InitAutoRestartDownload";
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public int getProcess() {
        return 1;
    }

    private final ItemData string2Item(String str) {
        if (StringUtils.isNotNull(str)) {
            ItemData itemData = new ItemData();
            itemData.parseJson(str);
            return itemData;
        }
        return null;
    }

    @Override // com.baidu.searchbox.performance.speed.task.LaunchTask
    public void execute() {
        TbDownloadManager tbDownloadManager = new TbDownloadManager();
        List<rna> g = tbDownloadManager.m().g();
        if (ListUtils.isEmpty(g)) {
            return;
        }
        for (rna rnaVar : CollectionsKt___CollectionsKt.toMutableList((Collection) g)) {
            DownloadData downloadData = new DownloadData();
            downloadData.setId(rnaVar.r());
            downloadData.setUrl(rnaVar.d());
            String c = rnaVar.c();
            Intrinsics.checkNotNullExpressionValue(c, "downloadMultiInfo.detailInfo()");
            ItemData string2Item = string2Item(c);
            boolean z = false;
            if (string2Item != null && string2Item.mTbFileDownloaderType == 2) {
                z = true;
            }
            if (z) {
                tbDownloadManager.w(2);
                if (tbDownloadManager.q(downloadData) == 1) {
                    tbDownloadManager.v(downloadData);
                }
            }
        }
    }
}
