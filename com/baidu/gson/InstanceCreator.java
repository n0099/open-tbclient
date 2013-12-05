package com.baidu.gson;

import java.lang.reflect.Type;
/* loaded from: classes.dex */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
