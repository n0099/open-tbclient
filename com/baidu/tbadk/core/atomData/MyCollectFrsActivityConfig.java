package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MyCollectFrsActivityConfig extends IntentConfig {
    private Context context;
    private String forumId;
    private String forumName;

    /* synthetic */ MyCollectFrsActivityConfig(a aVar, MyCollectFrsActivityConfig myCollectFrsActivityConfig) {
        this(aVar);
    }

    private MyCollectFrsActivityConfig(a aVar) {
        super(aVar.context);
        this.context = aVar.context;
        this.forumName = aVar.forumName;
        this.forumId = aVar.forumId;
    }

    public void createNormalCfg() {
        Intent intent = getIntent();
        intent.putExtra("forum_name", this.forumName);
        intent.putExtra("forum_id", this.forumId);
        if (!(this.context instanceof Activity)) {
            intent.addFlags(268435456);
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private Context context;
        private String forumId;
        private String forumName;
    }
}
