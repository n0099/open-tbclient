package c.a.r0.u0.b;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.q0.d1.m0;
import c.a.r0.w0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoMemberItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends k<d, ManitoMemberItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener x;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25223e;

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
            this.f25223e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d dVar = (d) view.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f25223e.f2957e, dVar.i(), dVar.g(), "")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new a(this);
    }

    @Override // c.a.r0.w0.k, c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        x0(i2, view, viewGroup, (d) obj, (ManitoMemberItemViewHolder) viewHolder);
        return view;
    }

    public final SpannableStringBuilder v0(String str, String[] strArr, int[] iArr) {
        InterceptResult invokeLLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, strArr, iArr)) == null) {
            if (str == null || strArr == null || iArr == null || strArr.length <= 0 || iArr.length <= 0 || strArr.length != iArr.length) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(str);
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (strArr[i2] != null && (indexOf = str.indexOf(strArr[i2])) >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(iArr[i2]), indexOf, strArr[i2].length() + indexOf, 17);
                }
            }
            spannableStringBuilder.append((CharSequence) spannableString);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: w0 */
    public ManitoMemberItemViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new ManitoMemberItemViewHolder(LayoutInflater.from(this.f2957e).inflate(R.layout.manito_item_member, (ViewGroup) null)) : (ManitoMemberItemViewHolder) invokeL.objValue;
    }

    public View x0(int i2, View view, ViewGroup viewGroup, d dVar, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, manitoMemberItemViewHolder})) == null) {
            super.a0(i2, view, viewGroup, dVar, manitoMemberItemViewHolder);
            if (dVar != null && manitoMemberItemViewHolder != null) {
                if (manitoMemberItemViewHolder.mSkinType != this.r) {
                    SkinManager.setBackgroundResource(manitoMemberItemViewHolder.getView(), R.drawable.frs_member_manito_bg);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.name, R.color.CAM_X0106, 1);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.intro, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundColor(manitoMemberItemViewHolder.dividerLine, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.fans, R.color.CAM_X0109, 1);
                }
                manitoMemberItemViewHolder.head.startLoad(dVar.c(), 12, false);
                manitoMemberItemViewHolder.name.setText(m0.e(dVar.h(), 16));
                if (StringUtils.isNull(dVar.d())) {
                    manitoMemberItemViewHolder.intro.setText(R.string.god_intro_default);
                } else {
                    manitoMemberItemViewHolder.intro.setText(m0.e(dVar.d(), 30));
                }
                int color = SkinManager.getColor(R.color.CAM_X0301);
                String numberUniformFormat = StringHelper.numberUniformFormat(dVar.b());
                manitoMemberItemViewHolder.fans.setText(v0(String.format(this.f2957e.getResources().getString(R.string.fans_count), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
                manitoMemberItemViewHolder.getView().setTag(dVar);
                manitoMemberItemViewHolder.getView().setOnClickListener(this.x);
                manitoMemberItemViewHolder.mSkinType = this.r;
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
