package com.baidu.swan.c;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public interface b extends SharedPreferences, SharedPreferences.Editor {
    boolean aDd();

    Set<String> aDe();

    @Override // android.content.SharedPreferences
    @Deprecated
    Map<String, ?> getAll();

    long getContentSize();

    @NonNull
    File getFile();

    @Override // android.content.SharedPreferences
    @Deprecated
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    @Deprecated
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
