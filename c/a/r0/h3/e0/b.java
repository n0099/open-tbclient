package c.a.r0.h3.e0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.q0.d1.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes5.dex */
public interface b extends IAdBaseAsyncController {
    void d(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    boolean e(@NonNull String str);

    void f(@NonNull e eVar);

    View g(@NonNull String str, boolean z, boolean z2);

    int getAdCount();

    void i(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void k(@NonNull String str);

    void l(@NonNull AdvertAppInfo advertAppInfo);

    void m();

    boolean o();

    void onDestroy();

    void p(String str);
}
