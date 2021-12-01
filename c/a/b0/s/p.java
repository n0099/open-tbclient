package c.a.b0.s;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes.dex */
public interface p extends h, m {
    public static final a a = c.a.b0.h0.g.a;

    /* loaded from: classes.dex */
    public interface a {
        p a(Context context, int i2);

        p b(Context context, int i2, @Nullable q qVar);
    }

    void a(i iVar);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull c.a.b0.p.l lVar);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
