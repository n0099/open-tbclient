package com.baidu.live.d;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes10.dex */
public class u extends IntentConfig {
    public u(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity());
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }
}
