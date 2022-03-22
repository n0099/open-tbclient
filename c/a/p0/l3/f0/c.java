package c.a.p0.l3.f0;

import androidx.annotation.Nullable;
import c.a.p0.l3.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes2.dex */
public interface c extends IAdBaseAsyncController {

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);
    }

    void a(TbPageContext<BaseFragmentActivity> tbPageContext);

    void c(AdvertAppInfo advertAppInfo, boolean z);

    @Nullable
    m k(AdvertAppInfo advertAppInfo);

    void loadAd();

    void o(AdvertAppInfo advertAppInfo);
}
