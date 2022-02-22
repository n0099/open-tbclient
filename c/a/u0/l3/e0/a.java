package c.a.u0.l3.e0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import c.a.t0.d1.g;
import c.a.u0.l3.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes8.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo c(@Nullable g gVar);

    o h(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
