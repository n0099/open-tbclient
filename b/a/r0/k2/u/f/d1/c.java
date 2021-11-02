package b.a.r0.k2.u.f.d1;

import android.view.View;
import android.widget.FrameLayout;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.b0.c0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c extends b.a.r0.k2.u.f.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f19189f;

    /* renamed from: g  reason: collision with root package name */
    public int f19190g;

    /* renamed from: h  reason: collision with root package name */
    public int f19191h;

    /* loaded from: classes5.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19192a;

        /* renamed from: b.a.r0.k2.u.f.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0964a extends b.a.q0.s.q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19193e;

            public C0964a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19193e = aVar;
            }

            @Override // b.a.q0.s.q.a
            public x0 getNegFeedBackData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (x0) invokeV.objValue;
            }

            @Override // b.a.q0.s.q.a
            public d2 getThreadData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    OriginalThreadInfo originalThreadInfo = this.f19193e.f19192a.f19181d;
                    if (originalThreadInfo != null) {
                        return originalThreadInfo.a();
                    }
                    return null;
                }
                return (d2) invokeV.objValue;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
            public BdUniqueId getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (BdUniqueId) invokeV.objValue;
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19192a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            c cVar;
            c0 c0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || (c0Var = (cVar = this.f19192a).f19179b) == null) {
                return;
            }
            c0Var.a(cVar.f19189f, new C0964a(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19191h = l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.ds34);
        this.f19190g = i2;
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19189f == null) {
                OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f19178a.getPageActivity());
                this.f19189f = originalThreadCardView;
                originalThreadCardView.sourceFormForPb = this.f19190g;
                originalThreadCardView.setSubClickListener(new a(this));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i2 = this.f19191h;
                layoutParams.bottomMargin = i2;
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
                this.f19189f.setLayoutParams(layoutParams);
                this.f19189f.onChangeSkinType();
            }
            return this.f19189f;
        }
        return (View) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19182e == i2) {
            return;
        }
        this.f19182e = i2;
        OriginalThreadCardView originalThreadCardView = this.f19189f;
        if (originalThreadCardView != null) {
            originalThreadCardView.onChangeSkinType();
        }
    }

    @Override // b.a.r0.k2.u.f.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19181d = originalThreadInfo;
            OriginalThreadCardView originalThreadCardView = this.f19189f;
            if (originalThreadCardView != null) {
                originalThreadCardView.fillData(originalThreadInfo);
            }
        }
    }
}
