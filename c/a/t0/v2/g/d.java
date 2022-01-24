package c.a.t0.v2.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.holder.PersonInfoUserPicsHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d extends c.a.t0.w.a<f, PersonInfoUserPicsHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener m;
    public TbPageContext n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.n = tbPageContext;
    }

    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        a0(i2, view, viewGroup, (f) obj, (PersonInfoUserPicsHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public PersonInfoUserPicsHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            PersonInfoUserPicsHolder personInfoUserPicsHolder = new PersonInfoUserPicsHolder(LayoutInflater.from(this.f3360e).inflate(c.a.t0.z2.e.person_info_user_pics_layout, viewGroup, false), this.n);
            personInfoUserPicsHolder.adapterManager.d(this.m);
            return personInfoUserPicsHolder;
        }
        return (PersonInfoUserPicsHolder) invokeL.objValue;
    }

    public View a0(int i2, View view, ViewGroup viewGroup, f fVar, PersonInfoUserPicsHolder personInfoUserPicsHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, personInfoUserPicsHolder})) == null) {
            if (fVar != null && personInfoUserPicsHolder != null) {
                personInfoUserPicsHolder.fillViewResource();
                personInfoUserPicsHolder.fillView(fVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
