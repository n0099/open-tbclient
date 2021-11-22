package b.a.r0.p2.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends b.a.e.m.e.a<b.a.r0.p2.e.c, CardViewHolder<b.a.r0.p2.j.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public b.a.e.f.k.b<PersonCommonForumItemView> n;

    /* loaded from: classes5.dex */
    public class a implements b.a.e.f.k.c<PersonCommonForumItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f23631a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23631a = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView a(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            e(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ PersonCommonForumItemView c(PersonCommonForumItemView personCommonForumItemView) {
            PersonCommonForumItemView personCommonForumItemView2 = personCommonForumItemView;
            h(personCommonForumItemView2);
            return personCommonForumItemView2;
        }

        public PersonCommonForumItemView e(PersonCommonForumItemView personCommonForumItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, personCommonForumItemView)) == null) ? personCommonForumItemView : (PersonCommonForumItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: f */
        public void b(PersonCommonForumItemView personCommonForumItemView) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, personCommonForumItemView) == null) || personCommonForumItemView == null) {
                return;
            }
            personCommonForumItemView.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: g */
        public PersonCommonForumItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new PersonCommonForumItemView(this.f23631a.f2421e) : (PersonCommonForumItemView) invokeV.objValue;
        }

        public PersonCommonForumItemView h(PersonCommonForumItemView personCommonForumItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, personCommonForumItemView)) == null) ? personCommonForumItemView : (PersonCommonForumItemView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), b.a.r0.p2.e.c.f23759f);
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
        this.n = new b.a.e.f.k.b<>(new a(this), 12, 0);
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: h0 */
    public CardViewHolder<b.a.r0.p2.j.a> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b.a.r0.p2.j.a aVar = new b.a.r0.p2.j.a(this.m);
            aVar.w(this.n);
            return new CardViewHolder<>(aVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.p2.e.c cVar, CardViewHolder<b.a.r0.p2.j.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, cardViewHolder})) == null) {
            cardViewHolder.getCardView().k(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.getCardView().j(cVar);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
