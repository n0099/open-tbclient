package c.a.d0.j.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface i<VIEW extends View> {
    void bind(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull c.a.d0.j.d.a aVar);
}
