package c.a.b0.h0;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.model.AdBaseModel;
/* loaded from: classes.dex */
public interface k {

    /* loaded from: classes.dex */
    public interface a {
        void onClick(int i2);
    }

    @Nullable
    View a(String str);

    void b(@NonNull AdBaseModel adBaseModel);

    void release();
}
