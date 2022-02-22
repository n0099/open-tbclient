package c.b.b.n.l.g.g;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short[] a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<c> f27473b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.a<ModelMaterial> f27474c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.a<e> f27475d;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<a> f27476e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new short[2];
        this.f27473b = new c.b.b.q.a<>();
        this.f27474c = new c.b.b.q.a<>();
        this.f27475d = new c.b.b.q.a<>();
        this.f27476e = new c.b.b.q.a<>();
    }
}
