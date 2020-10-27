package com.baidu.live.tieba.yuyinala;

import com.baidu.live.b.aa;
import com.baidu.live.b.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class AlaFeedBackInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(z.class, AlaFeedBackReasonActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(aa.class, AlaFeedBackEditActivity.class);
    }
}
