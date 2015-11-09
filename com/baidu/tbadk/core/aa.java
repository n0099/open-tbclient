package com.baidu.tbadk.core;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ TbadkCoreApplication Ty;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TbadkCoreApplication tbadkCoreApplication, Context context) {
        this.Ty = tbadkCoreApplication;
        this.val$context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tbadk.core.util.d.ab(this.val$context));
    }
}
