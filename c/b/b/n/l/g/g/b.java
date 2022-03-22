package c.b.b.n.l.g.g;

import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final short[] a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<c> f22609b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.a<ModelMaterial> f22610c;

    /* renamed from: d  reason: collision with root package name */
    public final c.b.b.q.a<e> f22611d;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<a> f22612e;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new short[2];
        this.f22609b = new c.b.b.q.a<>();
        this.f22610c = new c.b.b.q.a<>();
        this.f22611d = new c.b.b.q.a<>();
        this.f22612e = new c.b.b.q.a<>();
    }
}
