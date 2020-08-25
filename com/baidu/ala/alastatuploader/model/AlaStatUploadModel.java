package com.baidu.ala.alastatuploader.model;

import com.baidu.ala.alastatuploader.AlaUploadStatItem;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaStatUploadModel {
    public boolean upload(List<AlaUploadStatItem> list) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            return false;
        }
        AlaStatUploadMessage alaStatUploadMessage = new AlaStatUploadMessage();
        alaStatUploadMessage.list = list;
        MessageManager.getInstance().sendMessage(alaStatUploadMessage);
        return true;
    }
}
