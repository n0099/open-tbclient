package com.baidu.tbadk.core;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ TbadkCoreApplication this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TbadkCoreApplication tbadkCoreApplication) {
        this.this$0 = tbadkCoreApplication;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        if (bool != null) {
            this.this$0.mIsOfficial = bool.booleanValue();
        }
    }
}
