package c.a.u0.e1.v2.c;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public interface c {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(boolean z);

    void c(float f2);

    void d(int i2, boolean z);

    void e(@NonNull ThemeElement themeElement);

    @NonNull
    NavigationBar f();

    @Nullable
    c.a.u0.e1.v2.c.f.d g();

    void h(boolean z);

    int i();

    void j(@NonNull FrsFragment frsFragment, @NonNull View view, @NonNull View.OnClickListener onClickListener);

    @Nullable
    c.a.u0.e1.v2.c.f.a k();

    void onChangeSkinType(int i2);
}
