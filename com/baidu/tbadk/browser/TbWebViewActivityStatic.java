package com.baidu.tbadk.browser;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
/* loaded from: classes.dex */
public class TbWebViewActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(TbWebViewActivityConfig.class, TbWebViewActivity.class);
    }
}
