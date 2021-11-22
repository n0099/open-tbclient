package b.a.r0.a3.e0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import b.a.q0.c1.e;
import b.a.r0.a3.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes4.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo c(@Nullable e eVar);

    o h(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
