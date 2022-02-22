package c.a.u0.a0.f.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f14775b;

    /* renamed from: c  reason: collision with root package name */
    public String f14776c;

    /* renamed from: d  reason: collision with root package name */
    public String f14777d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f14778e;

    /* renamed from: f  reason: collision with root package name */
    public int f14779f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f14780g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotLiveWithCategory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hotLiveWithCategory.tab_id.intValue();
        this.f14775b = hotLiveWithCategory.entry_name;
        this.f14776c = hotLiveWithCategory.label_name;
        this.f14777d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f14778e = new ArrayList(hotLiveWithCategory.live);
        this.f14779f = hotLiveWithCategory.live_tab_type.intValue();
        this.f14780g = hotLiveWithCategory.sub_type_list;
    }
}
