package c.a.d.f.l;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public interface e<T> {
    BdAsyncTaskParallel getAsyncTaskParallel();

    int getAsyncTaskPriority();

    T getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr);

    T getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr);

    T getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr);

    boolean isNeedLoad();

    void updateMemory(String str, Object obj, int i2, int i3, Object... objArr);
}
