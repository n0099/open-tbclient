package b.a.r0.e2.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.n.f;
import b.a.r0.e2.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import com.baidu.tieba.newdetail.view.HotTopicDetailSpecialItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a extends b.a.e.m.e.a<b.a.r0.e2.e.b, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<HotTopicDetailActivity> m;
    public f<b.a.r0.e2.e.b> n;

    /* renamed from: b.a.r0.e2.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0867a implements f<b.a.r0.e2.e.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f17254e;

        public C0867a(a aVar) {
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
            this.f17254e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: b */
        public void c(View view, b.a.r0.e2.e.b bVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: d */
        public void a(View view, b.a.r0.e2.e.b bVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bVar == null || this.f17254e.m == null) {
                return;
            }
            c.a("c13820", bVar, i2, ((HotTopicDetailActivity) this.f17254e.m.getOrignalPage()).getTopicId());
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HotTopicDetailSpecialItem f17255a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicDetailSpecialItem hotTopicDetailSpecialItem) {
            super(hotTopicDetailSpecialItem);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailSpecialItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17255a = hotTopicDetailSpecialItem;
        }

        public void a(b.a.r0.e2.e.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
                return;
            }
            this.f17255a.bindData(bVar);
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f17255a.setCurrentTopicId(str);
            }
        }

        public void c(f<b.a.r0.e2.e.b> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
                this.f17255a.setOnItemCoverListener(fVar);
            }
        }

        public void onChangeSkinType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.f17255a.onChangeSkinType(i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), b.a.r0.e2.e.a.f17298a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new C0867a(this);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public b T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b bVar = new b(new HotTopicDetailSpecialItem(viewGroup.getContext()));
            bVar.b(this.m.getOrignalPage().getTopicId());
            bVar.c(this.n);
            bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.e2.e.b bVar, b bVar2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, bVar2})) == null) {
            if (bVar == null || bVar2 == null) {
                return null;
            }
            bVar2.a(bVar);
            bVar2.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return bVar2.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
