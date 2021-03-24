package com.baidu.pass.ecommerce.common.mvp;
/* loaded from: classes2.dex */
public interface IBaseView {
    public static final int DEFAULT_CODE = Integer.MIN_VALUE;

    void doFailure(int i, int i2, String str);

    void doFailure(int i, int i2, String str, String str2);

    void doFailure(int i, String str);

    void doResult(int i, Object obj);

    void doResult(int i, Object obj, String str);

    void doResult(Object obj);

    void showLoading(int i);
}
