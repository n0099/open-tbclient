package com.baidu.live.tbadk.schemeability;
/* loaded from: classes3.dex */
public class SchemeAbilityManager {
    private ISchemeAbility mSchemeAbility;
    private ISchemeAbilityBuilder mSchemeAbilityBuilder;

    public static SchemeAbilityManager getInstance() {
        return InstanceHolder.sInst;
    }

    private SchemeAbilityManager() {
    }

    public void init(ISchemeAbilityBuilder iSchemeAbilityBuilder) {
        this.mSchemeAbilityBuilder = iSchemeAbilityBuilder;
        build();
    }

    public ISchemeAbility buildSchemeAbility() {
        if (this.mSchemeAbility != null) {
            return this.mSchemeAbility;
        }
        build();
        return this.mSchemeAbility;
    }

    private void build() {
        if (this.mSchemeAbilityBuilder != null) {
            this.mSchemeAbility = this.mSchemeAbilityBuilder.build();
        }
    }

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        private static final SchemeAbilityManager sInst = new SchemeAbilityManager();
    }
}
