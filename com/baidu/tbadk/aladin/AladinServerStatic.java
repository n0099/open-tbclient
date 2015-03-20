package com.baidu.tbadk.aladin;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AladinServerConfig;
/* loaded from: classes.dex */
public class AladinServerStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AladinServerConfig.class, AladinServer.class);
    }
}
