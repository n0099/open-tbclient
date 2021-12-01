package c.a.r0.h3.e0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import c.a.q0.d1.e;
import c.a.r0.h3.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes5.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo c(@Nullable e eVar);

    o h(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
