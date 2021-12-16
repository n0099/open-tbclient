package c.a.c0.g.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface i<VIEW extends View> {
    void bind(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull c.a.c0.g.d.a aVar);
}
