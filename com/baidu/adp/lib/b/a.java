package com.baidu.adp.lib.b;
/* loaded from: classes.dex */
public abstract class a {
    protected static final int DEF_CRASHTIME_LIMIT = 10;
    protected String[] mKey;
    protected String mName;
    protected int mDefaultType = 0;
    protected int mOffType = 1;
    protected int mMaxCrashTimes = 10;
    protected d mSwitchListener = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void changeSettingByType(int i);

    protected abstract String[] getCrashKeys();

    protected abstract int getDefaultType();

    protected abstract int getMaxCrashTimes();

    protected abstract String getName();

    protected abstract int getOffType();

    /* JADX INFO: Access modifiers changed from: protected */
    public void addToManager() {
        c cVar = new c(this.mName, this.mDefaultType, this.mSwitchListener);
        cVar.a(this.mMaxCrashTimes, this.mKey, this.mOffType);
        f.da().a(cVar);
    }

    public a() {
        initData();
        addToManager();
    }

    protected void initData() {
        this.mName = getName();
        this.mKey = getCrashKeys();
        this.mDefaultType = getDefaultType();
        this.mOffType = getOffType();
        this.mMaxCrashTimes = getMaxCrashTimes();
    }
}
