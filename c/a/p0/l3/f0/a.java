package c.a.p0.l3.f0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import c.a.o0.c1.g;
import c.a.p0.l3.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes2.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo d(@Nullable g gVar);

    o i(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
