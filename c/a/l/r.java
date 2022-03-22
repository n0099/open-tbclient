package c.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class r extends t0 {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public InterviewLiveLayout y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896322318, "Lc/a/l/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896322318, "Lc/a/l/r;");
                return;
            }
        }
        B = c.a.d.f.p.n.k(TbadkCoreApplication.getInst()) - ((c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = 3;
        z();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.y.setFromCDN(z);
        }
    }

    @Override // c.a.l.t0, c.a.l.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3482f : (View) invokeV.objValue;
    }

    @Override // c.a.l.a
    public void l(c.a.p0.h0.b0<c.a.o0.r.r.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b0Var) == null) {
            this.y.setSubClickListener(b0Var);
        }
    }

    @Override // c.a.l.t0, c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.z != i) {
                SkinManager.setBackgroundResource(this.y, R.drawable.addresslist_item_bg);
                this.y.l(this.z);
            }
            this.z = i;
        }
    }

    @Override // c.a.l.t0
    public c.a.p0.c3.w.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.p0.c3.w.b bVar = new c.a.p0.c3.w.b(this.f3392b, this.i);
            bVar.setStageType("2003");
            return bVar;
        }
        return (c.a.p0.c3.w.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.t0, c.a.l.p
    /* renamed from: q */
    public void a(c.a.o0.r.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f3484h = aVar;
            if (aVar == null || aVar.getThreadData() == null) {
                return;
            }
            ThreadData threadData = aVar.getThreadData();
            if (threadData.getThreadVideoInfo() != null) {
                this.y.setVisibility(8);
                this.i.setVisibility(0);
                this.A.setVisibility(8);
                super.a(aVar);
                return;
            }
            this.i.setVisibility(8);
            this.y.setVisibility(0);
            this.A.setVisibility(0);
            this.y.a(aVar);
            ThreadCardUtils.setTitle(this.f3483g, threadData);
            ThreadCardUtils.setAbstract(this.A, this.f3483g, threadData, B);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View inflate = LayoutInflater.from(this.f3392b).inflate(R.layout.obfuscated_res_0x7f0d01a4, (ViewGroup) null, true);
            this.f3482f = inflate;
            this.f3483g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092375);
            this.A = (TextView) this.f3482f.findViewById(R.id.obfuscated_res_0x7f092374);
            this.i = (RoundCornerFrameLayout) this.f3482f.findViewById(R.id.obfuscated_res_0x7f090aaf);
            this.y = (InterviewLiveLayout) this.f3482f.findViewById(R.id.obfuscated_res_0x7f090aab);
            c.a.p0.c3.w.a p = p();
            this.j = p;
            p.getMainView().setBackgroundResource(R.color.transparent);
        }
    }
}
