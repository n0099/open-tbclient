package com.baidu.searchbox.ng.ai.apps.trace;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class Index<ValueT> {
    public final String id;
    private ValueUpdater<ValueT> mUpdater;
    private ValueT mValue;

    /* loaded from: classes2.dex */
    public interface ValueUpdater<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ng.ai.apps.trace.Tracer */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public Index(String str) {
        this.id = str;
        Tracer.get().regIndex(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", super.toString(), this.id, getFormatValue());
    }

    public Index<ValueT> updater(ValueUpdater<ValueT> valueUpdater) {
        this.mUpdater = valueUpdater;
        update();
        return this;
    }

    public boolean update() {
        return update((ValueUpdater) this.mUpdater);
    }

    public boolean update(ValueUpdater<ValueT> valueUpdater) {
        if (valueUpdater != null) {
            try {
                return update((Index<ValueT>) valueUpdater.update());
            } catch (IllegalStateException e) {
                AiAppsLog.w(ITracer.LOG_TAG, "index update IllegalStateException " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.ng.ai.apps.trace.Tracer */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean update(ValueT valuet) {
        this.mValue = valuet;
        Tracer.get().notifyCallbacks(this);
        return true;
    }

    public ValueT getValue() {
        return this.mValue;
    }

    public CharSequence getFormatValue() {
        return this.mValue == null ? "" : this.mValue.toString();
    }
}
