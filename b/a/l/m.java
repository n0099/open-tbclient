package b.a.l;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m extends b.a.l.a<b.a.q0.s.q.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardForumHeadLayout j;
    public b.a.q0.s.q.a k;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f3347e;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3347e = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f3347e.c() == null) {
                return;
            }
            this.f3347e.c().a(view, this.f3347e.k);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().f14152f instanceof CardForumHeadLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().f14152f.getParent() == null) {
            this.j = (CardForumHeadLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().f14152f;
        } else {
            this.j = new CardForumHeadLayout(context);
        }
        this.j.setAfterClickListener(new a(this));
    }

    @Override // b.a.l.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    /* renamed from: o */
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        CardForumHeadLayout cardForumHeadLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (cardForumHeadLayout = this.j) == null || aVar == null) {
            return;
        }
        this.k = aVar;
        cardForumHeadLayout.setOnClickListener();
        this.j.setData(aVar.getThreadData());
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        CardForumHeadLayout cardForumHeadLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || (cardForumHeadLayout = this.j) == null) {
            return;
        }
        cardForumHeadLayout.onChangeSkinType();
    }
}
