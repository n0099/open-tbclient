package c.a.p0.x2.e0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import c.a.p0.x2.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes4.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo c(@Nullable c.a.o0.b1.c cVar);

    o i(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
