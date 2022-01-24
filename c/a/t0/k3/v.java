package c.a.t0.k3;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.t0.x3.l0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import java.util.HashMap;
import java.util.List;
import tbclient.App;
/* loaded from: classes7.dex */
public interface v {
    c.a.d.n.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    q b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    l e();

    c.a.d.n.e.a<?, ?> f(u uVar, BdUniqueId bdUniqueId);

    void g();

    List<AdvertAppInfo> h();

    void i(AdvertAppInfo advertAppInfo, Context context);

    c.a.d.n.e.a<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController k(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    c.a.t0.v3.a l();

    void m(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    s n();

    void o(AdvertAppInfo advertAppInfo);

    void p(HashMap<String, String> hashMap, Context context);
}
