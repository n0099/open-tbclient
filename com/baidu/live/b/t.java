package com.baidu.live.b;

import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
/* loaded from: classes4.dex */
public class t extends IntentConfig {
    public t(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity());
        getIntent().putExtra("live_id", str);
        getIntent().putExtra("room_id", str2);
    }
}
