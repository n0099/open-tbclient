package c.a.c0.j0.n.a;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface a {
    void doFinish();

    @NonNull
    Activity getActivity();

    @NonNull
    Intent getIntent();

    boolean handleSetContentView();
}
