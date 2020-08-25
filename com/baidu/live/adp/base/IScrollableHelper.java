package com.baidu.live.adp.base;

import android.content.Context;
import com.baidu.live.adp.lib.util.BSBeanUtils;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.megapp.ma.MAFragmentActivity;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class IScrollableHelper {
    public static BdPageContextCreator defaultPageContextCreater = null;

    public static IScrollable getIScrollable(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof IScrollable) {
            return (IScrollable) context;
        }
        if (context instanceof BdPageContextSupport) {
            Object orignalPage = ((BdPageContextSupport) context).getPageContext().getOrignalPage();
            if (orignalPage instanceof IScrollable) {
                return (IScrollable) orignalPage;
            }
        }
        Field declaredField = BSBeanUtils.getDeclaredField(context.getClass(), IScrollable.class);
        if (declaredField == null && (declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField == null || (forceGetProperty = BSBeanUtils.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof IScrollable)) {
            return null;
        }
        return (IScrollable) forceGetProperty;
    }

    public static BdPageContextSupport<?> getBdPageContextSupport(Context context) {
        Object forceGetProperty;
        if (context == null) {
            return null;
        }
        if (context instanceof BdPageContextSupport) {
            return (BdPageContextSupport) context;
        }
        Field declaredField = BSBeanUtils.getDeclaredField(context.getClass(), IScrollable.class);
        if (declaredField == null && (declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField == null || (forceGetProperty = BSBeanUtils.forceGetProperty(context, declaredField)) == null || !(forceGetProperty instanceof IScrollable) || !(forceGetProperty instanceof BdPageContextSupport)) {
            return null;
        }
        return (BdPageContextSupport) forceGetProperty;
    }

    public static BdPageContext<?> getBbPageContext(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof BdPageContext) {
            return (BdPageContext) context;
        }
        if (context instanceof BdPageContextSupport) {
            return ((BdPageContextSupport) context).getPageContext();
        }
        Field declaredField = BSBeanUtils.getDeclaredField(context.getClass(), IScrollable.class);
        if (declaredField == null && (declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAActivity.class)) == null) {
            declaredField = BSBeanUtils.getDeclaredField(context.getClass(), MAFragmentActivity.class);
        }
        if (declaredField != null) {
            Object forceGetProperty = BSBeanUtils.forceGetProperty(context, declaredField);
            if (forceGetProperty != null && (forceGetProperty instanceof IScrollable) && (forceGetProperty instanceof BdPageContextSupport)) {
                return ((BdPageContextSupport) forceGetProperty).getPageContext();
            }
        } else if ((context instanceof MAActivity) && defaultPageContextCreater != null) {
            return defaultPageContextCreater.createPageContext((MAActivity) context);
        }
        return null;
    }
}
