package c.a.p0.c1.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.member.ComplaintBarlordViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.d.o.e.a<b, ComplaintBarlordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public View.OnClickListener j;

    /* renamed from: c.a.p0.c1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1011a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1011a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                String str = (String) view.getTag();
                if (this.a.i == 1 || this.a.i == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a, this.a.a.getString(R.string.obfuscated_res_0x7f0f040b), str, true));
                customMessage.setTag(this.a.f2571e);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.d.a.f fVar) {
        super(fVar.getPageActivity(), b.f13410c, fVar.getUniqueId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new View$OnClickListenerC1011a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        g0(i, view, viewGroup, bVar, complaintBarlordViewHolder);
        return view;
    }

    public final void d0(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, complaintBarlordViewHolder, bVar) == null) {
            complaintBarlordViewHolder.f32201d.setText(bVar.a);
            complaintBarlordViewHolder.f32199b.setTag(bVar.f13411b);
            complaintBarlordViewHolder.f32199b.setOnClickListener(this.j);
        }
    }

    public final void e0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, complaintBarlordViewHolder) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.i = skinType;
            if (complaintBarlordViewHolder.a == skinType) {
                return;
            }
            complaintBarlordViewHolder.a = skinType;
            SkinManager.setBackgroundResource(complaintBarlordViewHolder.f32199b, R.drawable.frs_member_manito_bg);
            SkinManager.setBackgroundColor(complaintBarlordViewHolder.f32200c, R.color.CAM_X0204);
            SkinManager.setViewTextColor(complaintBarlordViewHolder.f32201d, R.color.CAM_X0105, 1);
            SkinManager.setImageResource(complaintBarlordViewHolder.f32202e, R.drawable.icon_arrow12_gray66_right);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: f0 */
    public ComplaintBarlordViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new ComplaintBarlordViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03fc, viewGroup, false)) : (ComplaintBarlordViewHolder) invokeL.objValue;
    }

    public View g0(int i, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, complaintBarlordViewHolder})) == null) {
            if (bVar != null && complaintBarlordViewHolder != null) {
                e0(complaintBarlordViewHolder);
                d0(complaintBarlordViewHolder, bVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
