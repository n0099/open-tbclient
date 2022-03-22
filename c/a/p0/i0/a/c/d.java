package c.a.p0.i0.a.c;

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
/* loaded from: classes2.dex */
public class d implements c.a.o0.k0.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;

    /* renamed from: b  reason: collision with root package name */
    public int f15482b;

    /* renamed from: c  reason: collision with root package name */
    public String f15483c;

    /* renamed from: d  reason: collision with root package name */
    public String f15484d;

    /* renamed from: e  reason: collision with root package name */
    public String f15485e;

    public d(int i, tinfo tinfoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), tinfoVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (tinfoVar == null) {
            return;
        }
        this.a = new ArrayList<>();
        this.f15482b = i;
        this.f15484d = String.valueOf(tinfoVar.forum_id);
        this.f15483c = tinfoVar.forum_name;
        this.f15485e = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.a.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(this.a);
            bVar.B(this.f15482b);
            bVar.z(this.f15483c);
            bVar.y(this.f15484d);
            bVar.O(this.f15485e);
            bVar.C(true);
            bVar.F(false);
            ArrayList<String> arrayList = this.a;
            bVar.J(arrayList.get(arrayList.size() - 1));
            return new CustomMessage<>(2010000, bVar.v(context));
        }
        return (CustomMessage) invokeL.objValue;
    }
}
