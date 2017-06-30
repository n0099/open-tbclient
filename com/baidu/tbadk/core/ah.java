package com.baidu.tbadk.core;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.tbadk.util.w<Boolean> {
    final /* synthetic */ TbadkCoreApplication this$0;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(TbadkCoreApplication tbadkCoreApplication, Context context) {
        this.this$0 = tbadkCoreApplication;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tbadk.core.util.b.az(this.val$context));
    }
}
