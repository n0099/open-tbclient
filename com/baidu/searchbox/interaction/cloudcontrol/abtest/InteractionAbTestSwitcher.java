package com.baidu.searchbox.interaction.cloudcontrol.abtest;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionSpHelperByDebug;
import com.baidu.searchbox.interaction.cloudcontrol.InteractionSpHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\r\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/AbstractSwitcher;", "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getCloudSwitcherValue", "()Ljava/lang/Object;", "getDebugSwitcherValue", "isDebug", "", "isSelectedByDebug", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InteractionAbTestSwitcher<T> extends AbstractSwitcher<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractionAbTestSwitcher(String key, T t) {
        super(key, t);
        Intrinsics.checkNotNullParameter(key, "key");
    }

    @Override // com.baidu.searchbox.interaction.cloudcontrol.abtest.AbstractSwitcher
    public T getCloudSwitcherValue() {
        T defaultValue;
        try {
            defaultValue = getDefaultValue();
        } catch (Exception unused) {
        }
        if (defaultValue instanceof Integer) {
            return (T) Integer.valueOf(AbTestManager.getInstance().getSwitch(getKey(), ((Number) getDefaultValue()).intValue()));
        }
        if (defaultValue instanceof Long) {
            return (T) Long.valueOf(AbTestManager.getInstance().getSwitch(getKey(), ((Number) getDefaultValue()).longValue()));
        }
        if (defaultValue instanceof Double) {
            return (T) Double.valueOf(AbTestManager.getInstance().getSwitch(getKey(), ((Number) getDefaultValue()).doubleValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (T) Boolean.valueOf(AbTestManager.getInstance().getSwitch(getKey(), ((Boolean) getDefaultValue()).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (T) AbTestManager.getInstance().getSwitch(getKey(), (String) getDefaultValue());
        }
        return getDefaultValue();
    }

    @Override // com.baidu.searchbox.interaction.cloudcontrol.abtest.AbstractSwitcher
    public T getDebugSwitcherValue() {
        return (T) InteractionSpHelperKt.getSpSwitcherValue(InteractionSpHelperByDebug.INSTANCE, getKey(), getDefaultValue());
    }

    @Override // com.baidu.searchbox.interaction.cloudcontrol.abtest.AbstractSwitcher
    public boolean isDebug() {
        return AppConfig.isDebug();
    }

    @Override // com.baidu.searchbox.interaction.cloudcontrol.abtest.AbstractSwitcher
    public boolean isSelectedByDebug() {
        return InteractionSpHelperByDebug.INSTANCE.getBoolean(generateDebugSelectedKey(), false);
    }
}
