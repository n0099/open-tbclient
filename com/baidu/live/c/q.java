package com.baidu.live.c;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes3.dex */
public class q extends IntentConfig {
    public q(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity());
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }
}
