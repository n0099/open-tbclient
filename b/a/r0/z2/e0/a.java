package b.a.r0.z2.e0;

import android.view.ViewStub;
import androidx.annotation.Nullable;
import b.a.q0.d1.e;
import b.a.r0.z2.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes6.dex */
public interface a extends IAdBaseAsyncController {
    @Nullable
    AdvertAppInfo c(@Nullable e eVar);

    o h(ViewStub viewStub, TbPageContext tbPageContext);

    void onDestroy();
}
