package c.a.c0.v;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes.dex */
public interface p extends h, m {
    public static final a a = c.a.c0.k0.e.a;

    /* loaded from: classes.dex */
    public interface a {
        p a(Context context, int i2);

        p b(Context context, int i2, @Nullable q qVar);
    }

    void a(i iVar);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull c.a.c0.s.l lVar);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
