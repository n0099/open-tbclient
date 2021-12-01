package c.a.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
    public static final int F;
    public transient /* synthetic */ FieldHolder $fh;
    public InterviewLiveLayout C;
    public int D;
    public TextView E;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896352109, "Lc/a/k/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896352109, "Lc/a/k/r;");
                return;
            }
        }
        F = c.a.d.f.p.l.k(TbadkCoreApplication.getInst()) - ((c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + c.a.d.f.p.l.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = 3;
        z();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.C.setFromCDN(z);
        }
    }

    @Override // c.a.k.t0, c.a.k.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3574j : (View) invokeV.objValue;
    }

    @Override // c.a.k.a
    public void k(c.a.r0.g0.d0<c.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d0Var) == null) {
            this.C.setSubClickListener(d0Var);
        }
    }

    @Override // c.a.k.t0, c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            if (this.D != i2) {
                SkinManager.setBackgroundResource(this.C, R.drawable.addresslist_item_bg);
                this.C.onChangeSkinType(this.D);
            }
            this.D = i2;
        }
    }

    @Override // c.a.k.t0
    public c.a.r0.x2.r.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            c.a.r0.x2.r.b bVar = new c.a.r0.x2.r.b(this.f3487f, this.m);
            bVar.setStageType("2003");
            return bVar;
        }
        return (c.a.r0.x2.r.a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.k.t0, c.a.k.p
    /* renamed from: q */
    public void onBindDataToView(c.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.l = aVar;
            if (aVar == null || aVar.getThreadData() == null) {
                return;
            }
            d2 threadData = aVar.getThreadData();
            if (threadData.t1() != null) {
                this.C.setVisibility(8);
                this.m.setVisibility(0);
                this.E.setVisibility(8);
                super.onBindDataToView(aVar);
                return;
            }
            this.m.setVisibility(8);
            this.C.setVisibility(0);
            this.E.setVisibility(0);
            this.C.onBindDataToView(aVar);
            ThreadCardUtils.setTitle(this.f3575k, threadData);
            ThreadCardUtils.setAbstract(this.E, this.f3575k, threadData, F);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View inflate = LayoutInflater.from(this.f3487f).inflate(R.layout.card_interview_layout, (ViewGroup) null, true);
            this.f3574j = inflate;
            this.f3575k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.E = (TextView) this.f3574j.findViewById(R.id.video_seg_abstract);
            this.m = (RoundCornerFrameLayout) this.f3574j.findViewById(R.id.frame_video);
            this.C = (InterviewLiveLayout) this.f3574j.findViewById(R.id.frame_interview_no_video);
            c.a.r0.x2.r.a p = p();
            this.n = p;
            p.getMainView().setBackgroundResource(R.color.transparent);
        }
    }
}
