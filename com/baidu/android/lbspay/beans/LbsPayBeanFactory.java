package com.baidu.android.lbspay.beans;

import android.content.Context;
import com.baidu.apollon.beans.IBeanFactory;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.beans.BeanManager;
/* loaded from: classes.dex */
public final class LbsPayBeanFactory implements IBeanFactory {
    public static final int BEAN_ID_AUTHORIZE_SIGN = 3;
    public static final int BEAN_ID_GET_PAY = 2;
    public static final int BEAN_ID_NEW_CASHIER = 1;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static LbsPayBeanFactory f2634a = new LbsPayBeanFactory();
    }

    public static LbsPayBeanFactory getInstance() {
        return a.f2634a;
    }

    public LbsPayBeanFactory() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    @Override // com.baidu.apollon.beans.IBeanFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseBean<?> getBean(Context context, int i2, String str) {
        BaseBean<?> newCashierBean;
        BaseBean<?> baseBean;
        if (i2 == 1) {
            newCashierBean = new NewCashierBean(context);
        } else if (i2 == 2) {
            newCashierBean = new GetPayBean(context);
        } else if (i2 != 3) {
            baseBean = null;
            if (baseBean != null) {
                BeanManager.getInstance().addBean(str, baseBean);
            }
            return baseBean;
        } else {
            newCashierBean = new AuthorizeSignBean(context);
        }
        baseBean = newCashierBean;
        if (baseBean != null) {
        }
        return baseBean;
    }
}
