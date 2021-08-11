package com.baidu.searchbox.net.update.statistics;
/* loaded from: classes5.dex */
public interface ICommandStatistics<T> {
    void collectInfo(String str, T t, boolean z);

    void doStatistics();
}
