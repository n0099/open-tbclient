package c.a.q0.b0.a.c;

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
public class d implements c.a.p0.i0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f15906e;

    /* renamed from: f  reason: collision with root package name */
    public int f15907f;

    /* renamed from: g  reason: collision with root package name */
    public String f15908g;

    /* renamed from: h  reason: collision with root package name */
    public String f15909h;

    /* renamed from: i  reason: collision with root package name */
    public String f15910i;

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
        this.f15906e = new ArrayList<>();
        this.f15907f = i2;
        this.f15909h = String.valueOf(tinfoVar.forum_id);
        this.f15908g = tinfoVar.forum_name;
        this.f15910i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f15906e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(this.f15906e);
            bVar.B(this.f15907f);
            bVar.z(this.f15908g);
            bVar.y(this.f15909h);
            bVar.O(this.f15910i);
            bVar.C(true);
            bVar.F(false);
            ArrayList<String> arrayList = this.f15906e;
            bVar.J(arrayList.get(arrayList.size() - 1));
            return new CustomMessage<>(2010000, bVar.v(context));
        }
        return (CustomMessage) invokeL.objValue;
    }
}
