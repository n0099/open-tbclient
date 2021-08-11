package c.a.p0.x2.e0;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes4.dex */
public interface b extends IAdBaseAsyncController {
    void d(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    int e();

    boolean f(@NonNull String str);

    void g(@NonNull c.a.o0.b1.c cVar);

    View h(@NonNull String str);

    void j(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void l(@NonNull String str);

    void m(@NonNull AdvertAppInfo advertAppInfo);

    boolean o();

    void onDestroy();

    void p(String str);
}
