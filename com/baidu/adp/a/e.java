package com.baidu.adp.a;
/* loaded from: classes.dex */
public abstract class e {
    public static final int MODE_INVALID = 0;
    protected int mLoadDataMode = 0;
    protected int unique_id = 0;
    protected h mLoadDataCallBack = null;
    protected int mErrorCode = 0;
    protected String mErrorString = null;

    protected abstract boolean LoadData();

    public abstract boolean cancelLoadData();

    public int getLoadDataMode() {
        return this.mLoadDataMode;
    }

    public void setLoadDataCallBack(h hVar) {
        this.mLoadDataCallBack = hVar;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void setErrorString(String str) {
        this.mErrorString = str;
    }

    public void setUniqueId(int i) {
        this.unique_id = i;
    }

    public void sendMessage(com.baidu.adp.framework.message.d<?> dVar) {
        a();
        dVar.b(this.unique_id);
        com.baidu.adp.framework.c.a().a(dVar);
    }

    public void cancelMessage() {
        a();
        com.baidu.adp.framework.c.a().a(this.unique_id);
    }

    public void registerListener(com.baidu.adp.framework.c.c<?> cVar) {
        a();
        if (cVar != null && cVar.c() == 0) {
            cVar.b(this.unique_id);
        }
        com.baidu.adp.framework.c.a().a(cVar);
    }

    public void registerListener(int i, com.baidu.adp.framework.c.c<?> cVar) {
        a();
        if (cVar != null && cVar.c() == 0) {
            cVar.b(this.unique_id);
        }
        com.baidu.adp.framework.c.a().a(i, cVar);
    }

    private void a() {
        if (this.unique_id == 0) {
            com.baidu.adp.lib.util.f.b(String.valueOf(getClass().getName()) + "'s unique_id wasn't seted!");
        }
    }
}
