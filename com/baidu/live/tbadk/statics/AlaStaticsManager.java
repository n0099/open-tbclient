package com.baidu.live.tbadk.statics;

import com.baidu.live.adp.lib.util.StringUtils;
import java.util.Collections;
/* loaded from: classes3.dex */
public class AlaStaticsManager {
    private IAlaBdStatics mIAlaBdStatics;
    private IAlaBdStaticsBuilder mIAlaBdStaticsBuilder;

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final AlaStaticsManager sInst = new AlaStaticsManager();
    }

    public static AlaStaticsManager getInst() {
        return InstanceHolder.sInst;
    }

    private AlaStaticsManager() {
    }

    public void setBuilder(IAlaBdStaticsBuilder iAlaBdStaticsBuilder) {
        if (iAlaBdStaticsBuilder != null) {
            if (this.mIAlaBdStaticsBuilder == null || this.mIAlaBdStatics == null) {
                this.mIAlaBdStaticsBuilder = iAlaBdStaticsBuilder;
                this.mIAlaBdStatics = this.mIAlaBdStaticsBuilder.build();
            }
        }
    }

    public void onStatic(AlaStaticItem alaStaticItem) {
        if (alaStaticItem != null && this.mIAlaBdStatics != null) {
            this.mIAlaBdStatics.onStatic(alaStaticItem.getKey(), alaStaticItem.getParams());
        }
    }

    public void onStatic(String str) {
        if (!StringUtils.isNull(str) && this.mIAlaBdStatics != null) {
            this.mIAlaBdStatics.onStatic(str, Collections.emptyMap());
        }
    }
}
