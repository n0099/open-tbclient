package c.a.a0.v;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes.dex */
public interface p extends h, m {
    public static final a a = c.a.a0.l0.e.a;

    /* loaded from: classes.dex */
    public interface a {
        p a(Context context, int i);

        p b(Context context, int i, @Nullable q qVar);
    }

    void a(i iVar);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull c.a.a0.s.p pVar);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
