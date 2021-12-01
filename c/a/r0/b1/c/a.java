package c.a.r0.b1.c;

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
/* loaded from: classes5.dex */
public class a extends c.a.d.m.e.a<b, ComplaintBarlordViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public View.OnClickListener n;

    /* renamed from: c.a.r0.b1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC0894a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f14717e;

        public View$OnClickListenerC0894a(a aVar) {
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
            this.f14717e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof String)) {
                String str = (String) view.getTag();
                if (this.f14717e.m == 1 || this.f14717e.m == 4) {
                    str = str + "?isNightModel=1";
                }
                CustomMessage customMessage = new CustomMessage(2002001, new TbWebViewActivityConfig(this.f14717e.f2907e, this.f14717e.f2907e.getString(R.string.complaint_bar_lord), str, true));
                customMessage.setTag(this.f14717e.f2911i);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.d.a.f fVar) {
        super(fVar.getPageActivity(), b.f14718g, fVar.getUniqueId());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new View$OnClickListenerC0894a(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        n0(i2, view, viewGroup, bVar, complaintBarlordViewHolder);
        return view;
    }

    public final void k0(ComplaintBarlordViewHolder complaintBarlordViewHolder, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, complaintBarlordViewHolder, bVar) == null) {
            complaintBarlordViewHolder.mTitleView.setText(bVar.f14719e);
            complaintBarlordViewHolder.mRootLayout.setTag(bVar.f14720f);
            complaintBarlordViewHolder.mRootLayout.setOnClickListener(this.n);
        }
    }

    public final void l0(ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, complaintBarlordViewHolder) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.m = skinType;
            if (complaintBarlordViewHolder.mSkinType == skinType) {
                return;
            }
            complaintBarlordViewHolder.mSkinType = skinType;
            SkinManager.setBackgroundResource(complaintBarlordViewHolder.mRootLayout, R.drawable.frs_member_manito_bg);
            SkinManager.setBackgroundColor(complaintBarlordViewHolder.mLineView, R.color.CAM_X0204);
            SkinManager.setViewTextColor(complaintBarlordViewHolder.mTitleView, R.color.CAM_X0105, 1);
            SkinManager.setImageResource(complaintBarlordViewHolder.mArrowImg, R.drawable.icon_arrow12_gray66_right);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: m0 */
    public ComplaintBarlordViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new ComplaintBarlordViewHolder(LayoutInflater.from(this.f2907e).inflate(R.layout.item_complaint_bar_lord_view, viewGroup, false)) : (ComplaintBarlordViewHolder) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, b bVar, ComplaintBarlordViewHolder complaintBarlordViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, complaintBarlordViewHolder})) == null) {
            if (bVar != null && complaintBarlordViewHolder != null) {
                l0(complaintBarlordViewHolder);
                k0(complaintBarlordViewHolder, bVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
