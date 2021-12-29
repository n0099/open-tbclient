package c.a.t0.j3.e0;

import androidx.annotation.Nullable;
import c.a.t0.j3.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
/* loaded from: classes7.dex */
public interface c extends IAdBaseAsyncController {

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i2);
    }

    void a(TbPageContext<BaseFragmentActivity> tbPageContext);

    void b(AdvertAppInfo advertAppInfo, boolean z);

    @Nullable
    m j(AdvertAppInfo advertAppInfo);

    void loadAd();

    void n(AdvertAppInfo advertAppInfo);
}
