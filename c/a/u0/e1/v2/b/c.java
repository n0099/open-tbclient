package c.a.u0.e1.v2.b;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public interface c extends c.a.u0.e1.v2.c.f.a {
    @Override // c.a.u0.e1.v2.c.f.a
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(boolean z);

    void e(@NonNull ThemeElement themeElement);

    void f(@NonNull FrsFragment frsFragment, @NonNull View view);

    @NonNull
    c.a.u0.e1.v2.c.c h();

    void i(@Nullable Integer num, @Nullable Integer num2, boolean z);

    View m();

    int n(@NonNull LogicField logicField);
}
