package b.a.r0.z2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.r0.l3.l0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.Cmatch;
import java.util.List;
import tbclient.App;
/* loaded from: classes6.dex */
public interface v {
    b.a.e.l.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    q b();

    App c(App app, Cmatch cmatch);

    void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5);

    l e();

    b.a.e.l.e.a<?, ?> f(u uVar, BdUniqueId bdUniqueId);

    void g();

    List<AdvertAppInfo> h();

    void i(AdvertAppInfo advertAppInfo, Context context);

    b.a.e.l.e.a<?, ?> j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController k(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    b.a.r0.j3.a l();

    void m(boolean z, String str, String str2, String str3, List<a.c> list, String str4);

    s n();
}
