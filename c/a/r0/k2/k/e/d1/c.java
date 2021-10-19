package c.a.r0.k2.k.e.d1;

import android.view.View;
import android.widget.FrameLayout;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.x0;
import c.a.r0.b0.c0;
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
public class c extends c.a.r0.k2.k.e.d1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public OriginalThreadCardView f20187f;

    /* renamed from: g  reason: collision with root package name */
    public int f20188g;

    /* renamed from: h  reason: collision with root package name */
    public int f20189h;

    /* loaded from: classes3.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20190a;

        /* renamed from: c.a.r0.k2.k.e.d1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0965a extends c.a.q0.s.q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f20191e;

            public C0965a(a aVar) {
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
                this.f20191e = aVar;
            }

            @Override // c.a.q0.s.q.a
            public x0 getNegFeedBackData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return null;
                }
                return (x0) invokeV.objValue;
            }

            @Override // c.a.q0.s.q.a
            public d2 getThreadData() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    OriginalThreadInfo originalThreadInfo = this.f20191e.f20190a.f20178d;
                    if (originalThreadInfo != null) {
                        return originalThreadInfo.a();
                    }
                    return null;
                }
                return (d2) invokeV.objValue;
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
            this.f20190a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            c cVar;
            c0 c0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) || (c0Var = (cVar = this.f20190a).f20176b) == null) {
                return;
            }
            c0Var.a(cVar.f20187f, new C0965a(this));
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
        this.f20189h = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds34);
        this.f20188g = i2;
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f20187f == null) {
                OriginalThreadCardView originalThreadCardView = new OriginalThreadCardView(this.f20175a.getPageActivity());
                this.f20187f = originalThreadCardView;
                originalThreadCardView.sourceFormForPb = this.f20188g;
                originalThreadCardView.setSubClickListener(new a(this));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i2 = this.f20189h;
                layoutParams.bottomMargin = i2;
                layoutParams.leftMargin = i2;
                layoutParams.rightMargin = i2;
                this.f20187f.setLayoutParams(layoutParams);
                this.f20187f.onChangeSkinType();
            }
            return this.f20187f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void b(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) || this.f20179e == i2) {
            return;
        }
        this.f20179e = i2;
        OriginalThreadCardView originalThreadCardView = this.f20187f;
        if (originalThreadCardView != null) {
            originalThreadCardView.onChangeSkinType();
        }
    }

    @Override // c.a.r0.k2.k.e.d1.a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.f20178d = originalThreadInfo;
            OriginalThreadCardView originalThreadCardView = this.f20187f;
            if (originalThreadCardView != null) {
                originalThreadCardView.fillData(originalThreadInfo);
            }
        }
    }
}
