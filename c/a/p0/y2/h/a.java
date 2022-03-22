package c.a.p0.y2.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.person.holder.PersonCenterIntervalHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends c.a.d.o.e.a<c.a.p0.y2.d, PersonCenterIntervalHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.y2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        a0(i, view, viewGroup, dVar, personCenterIntervalHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public PersonCenterIntervalHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCenterIntervalHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d040f, viewGroup, false)) : (PersonCenterIntervalHolder) invokeL.objValue;
    }

    public View a0(int i, View view, ViewGroup viewGroup, c.a.p0.y2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar, personCenterIntervalHolder})) == null) {
            if (dVar != null && personCenterIntervalHolder != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (personCenterIntervalHolder.a != skinType) {
                    personCenterIntervalHolder.a = skinType;
                    SkinManager.setBackgroundResource(personCenterIntervalHolder.f35347b, dVar.f20782c);
                }
                ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.f35347b.getLayoutParams();
                int i2 = dVar.a;
                if (i2 > 0) {
                    layoutParams.height = i2;
                }
                int i3 = dVar.f20781b;
                if (i3 > 0) {
                    layoutParams.width = i3;
                }
                personCenterIntervalHolder.f35347b.setLayoutParams(layoutParams);
                personCenterIntervalHolder.f35347b.setOnClickListener(null);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
