package com.baidu.adp.lib.a;
/* loaded from: classes.dex */
public abstract class a {
    protected String[] mKey;
    protected String mName;
    protected int mDefaultType = 0;
    protected int mOffType = 1;
    protected int mCrashTimes = 10;
    protected d mSwitchListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void changeSettingByType(int i);

    protected abstract void initData();

    protected void addToManager() {
        c cVar = new c(this.mName, this.mDefaultType, this.mSwitchListener);
        cVar.a(this.mCrashTimes, this.mKey, this.mOffType);
        f.a().a(cVar);
    }

    public a() {
        initData();
        addToManager();
    }
}
