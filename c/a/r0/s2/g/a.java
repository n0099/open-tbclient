package c.a.r0.s2.g;

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
/* loaded from: classes6.dex */
public class a extends c.a.d.m.e.a<c.a.r0.s2.d, PersonCenterIntervalHolder> {
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.s2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        h0(i2, view, viewGroup, dVar, personCenterIntervalHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: g0 */
    public PersonCenterIntervalHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PersonCenterIntervalHolder(LayoutInflater.from(this.f2907e).inflate(R.layout.item_person_center_list_interval, viewGroup, false)) : (PersonCenterIntervalHolder) invokeL.objValue;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, c.a.r0.s2.d dVar, PersonCenterIntervalHolder personCenterIntervalHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, personCenterIntervalHolder})) == null) {
            if (dVar != null && personCenterIntervalHolder != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (personCenterIntervalHolder.skinType != skinType) {
                    personCenterIntervalHolder.skinType = skinType;
                    SkinManager.setBackgroundResource(personCenterIntervalHolder.intervalView, dVar.f23471g);
                }
                ViewGroup.LayoutParams layoutParams = personCenterIntervalHolder.intervalView.getLayoutParams();
                int i3 = dVar.f23469e;
                if (i3 > 0) {
                    layoutParams.height = i3;
                }
                int i4 = dVar.f23470f;
                if (i4 > 0) {
                    layoutParams.width = i4;
                }
                personCenterIntervalHolder.intervalView.setLayoutParams(layoutParams);
                personCenterIntervalHolder.intervalView.setOnClickListener(null);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
