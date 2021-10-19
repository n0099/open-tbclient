package c.a.r0.c0.a.c;

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
    public ArrayList<String> f16078e;

    /* renamed from: f  reason: collision with root package name */
    public int f16079f;

    /* renamed from: g  reason: collision with root package name */
    public String f16080g;

    /* renamed from: h  reason: collision with root package name */
    public String f16081h;

    /* renamed from: i  reason: collision with root package name */
    public String f16082i;

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
        this.f16078e = new ArrayList<>();
        this.f16079f = i2;
        this.f16081h = String.valueOf(tinfoVar.forum_id);
        this.f16080g = tinfoVar.forum_name;
        this.f16082i = String.valueOf(tinfoVar.thread_id);
        for (Pic pic : tinfoVar.pics) {
            if (pic != null && !StringUtils.isNull(pic.big_pic)) {
                this.f16078e.add(pic.big_pic);
            }
        }
    }

    public CustomMessage<ImageViewerConfig> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
            bVar.x(this.f16078e);
            bVar.B(this.f16079f);
            bVar.z(this.f16080g);
            bVar.y(this.f16081h);
            bVar.O(this.f16082i);
            bVar.C(true);
            bVar.F(false);
            ArrayList<String> arrayList = this.f16078e;
            bVar.J(arrayList.get(arrayList.size() - 1));
            return new CustomMessage<>(2010000, bVar.v(context));
        }
        return (CustomMessage) invokeL.objValue;
    }
}
