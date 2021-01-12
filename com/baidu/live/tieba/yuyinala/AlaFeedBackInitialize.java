package com.baidu.live.tieba.yuyinala;

import com.baidu.live.d.aa;
import com.baidu.live.d.ab;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class AlaFeedBackInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(aa.class, AlaFeedBackReasonActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ab.class, AlaFeedBackEditActivity.class);
    }
}
