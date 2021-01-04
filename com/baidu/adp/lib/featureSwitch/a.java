package com.baidu.adp.lib.featureSwitch;

import com.baidu.adp.lib.featureSwitch.b;
/* loaded from: classes.dex */
public abstract class a {
    protected static final int DEF_CRASHTIME_LIMIT = 10;
    public static final int OFF_TYPE = 0;
    public static final int ON_TYPE = 1;
    protected String[] mKey;
    protected String mName;
    protected int mDefaultType = 0;
    protected int mOffType = 1;
    protected int mMaxCrashTimes = 10;
    protected b.a mSwitchListener = new b.a() { // from class: com.baidu.adp.lib.featureSwitch.a.1
        @Override // com.baidu.adp.lib.featureSwitch.b.a
        public void a(String str, int i, boolean z) {
            a.this.changeSettingByType(i);
        }
    };

    protected abstract void changeSettingByType(int i);

    protected abstract String[] getCrashKeys();

    protected abstract int getDefaultType();

    protected abstract int getMaxCrashTimes();

    protected abstract String getName();

    protected abstract int getOffType();

    /* JADX INFO: Access modifiers changed from: protected */
    public String[] getSwitchLibs() {
        return null;
    }

    protected void addToManager() {
        b bVar = new b(this.mName, this.mDefaultType, this.mSwitchListener);
        bVar.a(this.mMaxCrashTimes, this.mKey, this.mOffType);
        bVar.g(getSwitchLibs());
        SwitchManager.getInstance().addSwitchData(bVar);
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
