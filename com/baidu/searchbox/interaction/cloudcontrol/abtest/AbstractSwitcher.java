package com.baidu.searchbox.interaction.cloudcontrol.abtest;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\r\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u000bH&J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/AbstractSwitcher;", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "hasObtainSwitchState", "", "getKey", "()Ljava/lang/String;", "switchState", "generateDebugSelectedKey", "getCloudSwitcherValue", "getDebugSwitcherValue", "getSwitcherValue", "isDebug", "isSelectedByDebug", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractSwitcher<T> {
    public final T defaultValue;
    public boolean hasObtainSwitchState;
    public final String key;
    public T switchState;

    public abstract T getCloudSwitcherValue();

    public abstract T getDebugSwitcherValue();

    public abstract boolean isDebug();

    public boolean isSelectedByDebug() {
        return false;
    }

    public AbstractSwitcher(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.defaultValue = t;
        this.switchState = t;
    }

    public final String generateDebugSelectedKey() {
        return this.key + "_debug";
    }

    public final T getDefaultValue() {
        return this.defaultValue;
    }

    public final String getKey() {
        return this.key;
    }

    public final T getSwitcherValue() {
        T cloudSwitcherValue;
        if (!this.hasObtainSwitchState) {
            this.hasObtainSwitchState = true;
            if (isDebug() && isSelectedByDebug()) {
                cloudSwitcherValue = getDebugSwitcherValue();
            } else {
                cloudSwitcherValue = getCloudSwitcherValue();
            }
            this.switchState = cloudSwitcherValue;
        }
        return this.switchState;
    }
}
