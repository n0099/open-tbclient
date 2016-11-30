package com.baidu.tbadk.core;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ TbadkCoreApplication this$0;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TbadkCoreApplication tbadkCoreApplication, Context context) {
        this.this$0 = tbadkCoreApplication;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tbadk.core.util.c.W(this.val$context));
    }
}
