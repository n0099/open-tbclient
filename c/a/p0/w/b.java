package c.a.p0.w;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public interface b extends SharedPreferences, SharedPreferences.Editor {
    Set<String> a();

    boolean b();

    long c();

    @Override // android.content.SharedPreferences
    @Deprecated
    Map<String, ?> getAll();

    @NonNull
    File getFile();

    @Override // android.content.SharedPreferences
    @Deprecated
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    @Deprecated
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
