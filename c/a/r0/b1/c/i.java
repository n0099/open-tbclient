package c.a.r0.b1.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivityConfig;
import com.baidu.tieba.forumMember.member.FrsMemberTeamViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class i extends c.a.r0.d1.k<j, FrsMemberTeamViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f14733e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14733e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = "";
                if (view.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view.getTag();
                    this.f14733e.o.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f14733e.f2907e, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view.getId() == R.id.title_text_view) {
                    Object tag = view.getTag();
                    if (tag instanceof Integer) {
                        Integer num = (Integer) tag;
                        if (this.f14733e.z(num.intValue()) instanceof j) {
                            jVar = (j) this.f14733e.z(num.intValue());
                            if (jVar != null || jVar.d() == null) {
                            }
                            String[] split = StringUtils.isNull(jVar.d().member_group_type) ? null : jVar.d().member_group_type.split("_");
                            if (split != null && split.length == 2) {
                                str = split[0];
                            }
                            if (StringUtils.isNull(str) || !str.equalsIgnoreCase("1")) {
                                return;
                            }
                            this.f14733e.o.sendMessage(new CustomMessage(2002001, new BawuTeamInfoActivityConfig(this.f14733e.f2907e, c.a.d.f.m.b.g(jVar.a(), 0L))));
                            return;
                        }
                    }
                    jVar = null;
                    if (jVar != null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    @Override // c.a.r0.d1.k, c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y0(i2, view, viewGroup, (j) obj, (FrsMemberTeamViewHolder) viewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: x0 */
    public FrsMemberTeamViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new FrsMemberTeamViewHolder(LayoutInflater.from(this.f2907e).inflate(R.layout.forum_member_team_user_view, (ViewGroup) null), this.x) : (FrsMemberTeamViewHolder) invokeL.objValue;
    }

    public View y0(int i2, View view, ViewGroup viewGroup, j jVar, FrsMemberTeamViewHolder frsMemberTeamViewHolder) {
        InterceptResult invokeCommon;
        MemberGroupInfo d2;
        List<BawuRoleInfoPub> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, frsMemberTeamViewHolder})) == null) {
            super.Z(i2, view, viewGroup, jVar, frsMemberTeamViewHolder);
            if (jVar != null && jVar.d() != null && (list = (d2 = jVar.d()).member_group_list) != null && list.size() > 0 && !StringUtils.isNull(d2.member_group_type)) {
                frsMemberTeamViewHolder.mTitleView.setTag(Integer.valueOf(i2));
                String[] split = !StringUtils.isNull(d2.member_group_type) ? d2.member_group_type.split("_") : null;
                String str = (split == null || split.length != 2) ? "" : split[1];
                TextView textView = frsMemberTeamViewHolder.mTitleView;
                textView.setText(str + "(" + d2.member_group_num + SmallTailInfo.EMOTION_SUFFIX);
                int i3 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : d2.member_group_list) {
                    if (i3 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        frsMemberTeamViewHolder.fillMemberView(bawuRoleInfoPub, i3);
                        i3++;
                    }
                }
                frsMemberTeamViewHolder.onChangeSkine(this.r);
                SkinManager.setBackgroundColor(frsMemberTeamViewHolder.forumMemberTeamItemView, R.color.CAM_X0201);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.mTitleView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.nameView1, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.nameView2, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.nameView3, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.nameView4, R.color.CAM_X0106, 1);
                frsMemberTeamViewHolder.mTitleView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
