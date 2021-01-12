package com.baidu.ala.alastatuploader.model;

import com.baidu.ala.alastatuploader.AlaUploadStatItem;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class AlaStatUploadMessage extends HttpMessage {
    public List<AlaUploadStatItem> list;
    private String uploadString;

    public AlaStatUploadMessage() {
        super(1021185);
        this.uploadString = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.message.HttpMessage, com.baidu.live.adp.framework.message.IEncode
    public synchronized List<Map.Entry<String, Object>> encodeInBackGround() {
        removeAllParams();
        if (this.uploadString == null) {
            StringBuilder sb = new StringBuilder();
            if (this.list != null) {
                for (AlaUploadStatItem alaUploadStatItem : this.list) {
                    try {
                        sb.append(alaUploadStatItem.toJsonObject().toString());
                        sb.append("\n");
                    } catch (Exception e) {
                    }
                }
            }
            this.uploadString = sb.toString();
        }
        addParam("index", "tieba_zhibo.client_data_dbg");
        if (this.uploadString != null) {
            addParam(TbConfig.TMP_LOG_DIR_NAME, this.uploadString.getBytes());
        }
        return super.encodeInBackGround();
    }
}
