package b.a.l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.l.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class q0 extends b.a.l.a<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int q;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public TextView k;
    public TextView l;
    public OriginalThreadCardView m;
    public b.a.q0.s.q.a n;
    public boolean o;
    public OriginalThreadCardView.b p;

    /* loaded from: classes.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q0 f3366a;

        public a(q0 q0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3366a = q0Var;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || this.f3366a.n == null || this.f3366a.n.getThreadData() == null) {
                return;
            }
            if (this.f3366a.c() != null) {
                this.f3366a.c().a(this.f3366a.m, this.f3366a.n);
            }
            String f0 = this.f3366a.n.getThreadData().f0();
            b.a.r0.b0.m.a(f0);
            this.f3366a.r(f0);
            this.f3366a.f3306e.n(new a.C0092a(1));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1143963790, "Lb/a/l/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1143963790, "Lb/a/l/q0;");
                return;
            }
        }
        q = b.a.e.f.p.l.k(TbadkCoreApplication.getInst()) - ((b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + b.a.e.f.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(Context context) {
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
        this.o = false;
        this.p = new a(this);
        if (TbadkCoreApplication.getInst().getPersonalizeViewData().q != null && TbadkCoreApplication.getInst().getPersonalizeViewData().q.getParent() == null) {
            this.j = TbadkCoreApplication.getInst().getPersonalizeViewData().q;
        } else {
            this.j = LayoutInflater.from(context).inflate(R.layout.card_transmit_thread_layout, (ViewGroup) null, false);
        }
        this.k = (TextView) this.j.findViewById(R.id.thread_card_title);
        this.l = (TextView) this.j.findViewById(R.id.thread_card_abstract);
        OriginalThreadCardView originalThreadCardView = (OriginalThreadCardView) this.j.findViewById(R.id.original_thread_view);
        this.m = originalThreadCardView;
        originalThreadCardView.setSubClickListener(this.p);
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    @Override // b.a.l.a
    public void k(b.a.r0.b0.d0<b.a.q0.s.q.a> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d0Var) == null) {
            super.k(d0Var);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) {
            this.m.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: q */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        this.n = aVar;
        ThreadCardUtils.setTitle(this.k, aVar.getThreadData(), this.o);
        ThreadCardUtils.setAbstract(this.l, this.k, aVar.getThreadData(), q, this.o);
        this.m.fillData(aVar.getThreadData().y1);
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            b.a.r0.b0.m.l(this.k, str, R.color.CAM_X0105, R.color.CAM_X0109);
            b.a.r0.b0.m.l(this.l, str, R.color.CAM_X0105, R.color.CAM_X0109);
            this.m.setReadState(b.a.r0.b0.m.k(str));
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.m.sourceFormForPb = i2;
        }
    }
}
