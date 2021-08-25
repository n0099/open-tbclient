package c.a.o0.t;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public interface b extends SharedPreferences, SharedPreferences.Editor {
    Set<String> a();

    boolean b();

    @NonNull
    File c();

    long d();

    @Override // android.content.SharedPreferences
    @Deprecated
    Map<String, ?> getAll();

    @Override // android.content.SharedPreferences
    @Deprecated
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    @Deprecated
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
