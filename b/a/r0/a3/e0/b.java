package b.a.r0.a3.e0;

import android.view.View;
import androidx.annotation.NonNull;
import b.a.q0.c1.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes4.dex */
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
