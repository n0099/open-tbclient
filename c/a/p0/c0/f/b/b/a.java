package c.a.p0.c0.f.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f12876b;

    /* renamed from: c  reason: collision with root package name */
    public String f12877c;

    /* renamed from: d  reason: collision with root package name */
    public String f12878d;

    /* renamed from: e  reason: collision with root package name */
    public List<ThreadInfo> f12879e;

    /* renamed from: f  reason: collision with root package name */
    public int f12880f;

    /* renamed from: g  reason: collision with root package name */
    public List<String> f12881g;

    public a(HotLiveWithCategory hotLiveWithCategory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotLiveWithCategory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hotLiveWithCategory.tab_id.intValue();
        this.f12876b = hotLiveWithCategory.entry_name;
        this.f12877c = hotLiveWithCategory.label_name;
        this.f12878d = hotLiveWithCategory.bitmap_wh_ratio;
        this.f12879e = new ArrayList(hotLiveWithCategory.live);
        this.f12880f = hotLiveWithCategory.live_tab_type.intValue();
        this.f12881g = hotLiveWithCategory.sub_type_list;
    }
}
