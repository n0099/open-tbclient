package com.baidu.searchbox.net.update.statistics;
/* loaded from: classes2.dex */
public interface ICommandStatistics<T> {
    void collectInfo(String str, T t, boolean z);

    void doStatistics();
}
