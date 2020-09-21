package com.baidu.ala.alastatuploader;

import com.baidu.ala.alastatuploader.model.AlaStatUploadResponseMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.tieba.f.a.a;
/* loaded from: classes4.dex */
public class AlaStatInitialize {
    static {
        AlaStatManager.getInstance().setUploader(AlaStatUploaderManager.getInstance());
        a.b(1021185, "ala/sys/eslog", AlaStatUploadResponseMessage.class, false, false, false, false);
    }
}
