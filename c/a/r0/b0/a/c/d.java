package c.a.r0.b0.a.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class d implements c.a.q0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f15916e;

    /* renamed from: f  reason: collision with root package name */
    public int f15917f;

    /* renamed from: g  reason: collision with root package name */
    public String f15918g;

    /* renamed from: h  reason: collision with root package name */
    public String f15919h;

    /* renamed from: i  reason: collision with root package name */
    public String f15920i;

    public d(int i2, tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), tinfoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tinfoVar == null) {
            return;
        }
        this.f15916e = new ArrayList<>();
        this.f15917f = i2;
        this.f15919h = String.valueOf(tinfoVar.forum_id);
        this.f15918g = tinfoVar.forum_name;
        this.f15920i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f15916e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(this.f15916e);
            bVar.B(this.f15917f);
            bVar.z(this.f15918g);
            bVar.y(this.f15919h);
            bVar.O(this.f15920i);
            bVar.C(true);
            bVar.F(false);
            ArrayList<String> arrayList = this.f15916e;
            bVar.J(arrayList.get(arrayList.size() - 1));
            return new CustomMessage<>(2010000, bVar.v(context));
        }
        return (CustomMessage) invokeL.objValue;
    }
}
