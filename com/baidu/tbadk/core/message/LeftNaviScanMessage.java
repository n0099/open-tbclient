package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class LeftNaviScanMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public b XJ;
        public List<com.baidu.tieba.tbadkCore.f.a> list;
    }

    /* loaded from: classes.dex */
    public interface b {
        void k(List<com.baidu.tieba.tbadkCore.f.a> list);
    }

    public LeftNaviScanMessage(a aVar) {
        super(CmdConfigCustom.CMD_LEFT_NAVI_SCAN, aVar);
    }
}
