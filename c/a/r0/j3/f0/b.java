package c.a.r0.j3.f0;

import android.view.View;
import androidx.annotation.NonNull;
import c.a.q0.c1.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes2.dex */
public interface b extends IAdBaseAsyncController {
    View b(@NonNull String str, boolean z);

    void e(@NonNull String str, @NonNull AdvertAppInfo advertAppInfo);

    boolean f(@NonNull String str);

    void g(@NonNull g gVar);

    int getAdCount();

    void i(@NonNull TbPageContext tbPageContext, @NonNull DragImageView.h hVar, boolean z);

    void k(@NonNull String str);

    void l(@NonNull AdvertAppInfo advertAppInfo);

    void m();

    boolean o();

    void onDestroy();

    void p(String str);
}
