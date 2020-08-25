package com.baidu.fsg.base.router;
/* loaded from: classes10.dex */
public class ApplicationLogicWrapper {
    public BaseApplicationLogic instance;
    public Class<? extends BaseApplicationLogic> logicClass;

    public ApplicationLogicWrapper(Class<? extends BaseApplicationLogic> cls) {
        this.logicClass = null;
        this.logicClass = cls;
    }
}
