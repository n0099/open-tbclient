package com.baidu.ar.plugin.helper;

import android.content.ComponentName;
import android.text.TextUtils;
import java.util.Comparator;
/* loaded from: classes.dex */
public class ComponentNameComparator implements Comparator<ComponentName> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(ComponentName componentName, ComponentName componentName2) {
        if (componentName == null && componentName2 == null) {
            return 0;
        }
        if (componentName == null || componentName2 != null) {
            if (componentName != null || componentName2 == null) {
                if (componentName == null || componentName2 == null) {
                    return 0;
                }
                if (TextUtils.equals(componentName.getPackageName(), componentName2.getPackageName()) && TextUtils.equals(componentName.getShortClassName(), componentName2.getShortClassName())) {
                    return 0;
                }
                if (componentName != null) {
                    return componentName.compareTo(componentName2);
                }
                return -1;
            }
            return -1;
        }
        return 1;
    }
}
