package c.a.q0.i2.k.e.b1;

import android.view.View;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import c.a.q0.a0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends c.a.q0.i2.k.e.b1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f19285f;

    /* renamed from: g  reason: collision with root package name */
    public int f19286g;

    /* renamed from: h  reason: collision with root package name */
    public int f19287h;

    /* loaded from: classes3.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19288a;

        /* renamed from: c.a.q0.i2.k.e.b1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0920a extends c.a.p0.s.q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f19289e;

            public C0920a(a aVar) {
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
                this.f19289e = aVar;
            }

            @Override // c.a.p0.s.q.a
            public x0 getNegFeedBackData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (x0) invokeV.objValue;
            }

            @Override // c.a.p0.s.q.a
            public c2 getThreadData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    OriginalThreadInfo originalThreadInfo = this.f19289e.f19288a.f19276d;
                    if (originalThreadInfo != null) {
                        return originalThreadInfo.a();
                    }
                    return null;
                }
                return (c2) invokeV.objValue;
            }

            @Override // com.baidu.tieba.card.data.BaseCardInfo, c.a.e.l.e.n
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
            this.f19288a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            c cVar;
            b0 b0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || (b0Var = (cVar = this.f19288a).f19274b) == null) {
                return;
            }
            b0Var.a(cVar.f19285f, new C0920a(this));
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
        this.f19287h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f19286g = i2;
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19285f == null) {
                OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f19273a.getPageActivity());
                this.f19285f = originalThreadCardView;
                originalThreadCardView.sourceFormForPb = this.f19286g;
                originalThreadCardView.setSubClickListener(new a(this));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i2 = this.f19287h;
                layoutParams.bottomMargin = i2;
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
                this.f19285f.setLayoutParams(layoutParams);
                this.f19285f.onChangeSkinType();
            }
            return this.f19285f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f19277e == i2) {
            return;
        }
        this.f19277e = i2;
        OriginalThreadCardView originalThreadCardView = this.f19285f;
        if (originalThreadCardView != null) {
            originalThreadCardView.onChangeSkinType();
        }
    }

    @Override // c.a.q0.i2.k.e.b1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f19276d = originalThreadInfo;
            OriginalThreadCardView originalThreadCardView = this.f19285f;
            if (originalThreadCardView != null) {
                originalThreadCardView.fillData(originalThreadInfo);
            }
        }
    }
}
