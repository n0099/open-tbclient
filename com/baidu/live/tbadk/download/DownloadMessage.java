package com.baidu.live.tbadk.download;

import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadMessage extends CustomResponsedMessage<List<DownloadData>> {
    public DownloadMessage(List<DownloadData> list) {
        super(CmdConfigCustom.CMD_FILE_DOWNLOAD, list);
    }
}
