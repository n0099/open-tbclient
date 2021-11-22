package b.a.r0.x0.b2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.x0.e1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailSelfVH;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForumRule;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class d extends b.a.e.m.e.a<b.a.r0.x0.b2.c.b, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity m;
    public String n;
    public boolean o;
    public int p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.x0.b2.c.b f27037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f27038f;

        public a(d dVar, b.a.r0.x0.b2.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27038f = dVar;
            this.f27037e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f27038f.o) {
                    this.f27038f.n0();
                } else {
                    this.f27038f.o0(this.f27037e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ForumRulesShowActivity forumRulesShowActivity, BdUniqueId bdUniqueId) {
        super(forumRulesShowActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumRulesShowActivity, bdUniqueId};
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
        this.o = false;
        this.p = 0;
        this.m = forumRulesShowActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.x0.b2.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        m0(i2, view, viewGroup, bVar, forumRuleDetailSelfVH);
        return view;
    }

    public final void j0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, b.a.r0.x0.b2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailSelfVH, bVar) == null) {
            if (bVar.e() != null) {
                forumRuleDetailSelfVH.mHeadView.setDefaultResource(e1.img_default_100);
                forumRuleDetailSelfVH.mHeadView.startLoad(bVar.e().portrait, 12, false);
                forumRuleDetailSelfVH.mUserName.setText(bVar.e().name_show);
                forumRuleDetailSelfVH.onChangeForumLevelSkinType(bVar.e().user_level.intValue());
                forumRuleDetailSelfVH.mUserForumLevel.setVisibility(0);
            }
            forumRuleDetailSelfVH.mUserIdentity.setText(i1.bawu_member_bazhu_tip);
            forumRuleDetailSelfVH.mUserIdentity.setVisibility(0);
            forumRuleDetailSelfVH.onChangeUserIdentitySkinType("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.onChangeTimeSkinType(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.mTime.setText(bVar.l());
            }
            k0(forumRuleDetailSelfVH, bVar);
            forumRuleDetailSelfVH.onChangePrefaceSkinType(bVar.k());
        }
    }

    public final void k0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, b.a.r0.x0.b2.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, forumRuleDetailSelfVH, bVar) == null) && bVar.i()) {
            forumRuleDetailSelfVH.mEditStatusBtn.setOnClickListener(new a(this, bVar));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.mEditStatusBtn.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.l()) && bVar.d() == 0) {
                long a2 = b.a.r0.x0.b2.e.a.a(bVar.l());
                int b2 = b.a.r0.x0.b2.e.a.b(Long.valueOf(StringUtils.isNull(bVar.g()) ? "0" : bVar.g()).longValue() - a2);
                if (b2 < 0) {
                    b2 = b.a.r0.x0.b2.e.a.b((System.currentTimeMillis() / 1000) - a2);
                }
                forumRuleDetailSelfVH.mEditStatusBtn.setVisibility(0);
                if (b2 >= 7) {
                    this.o = false;
                    return;
                }
                forumRuleDetailSelfVH.mEditStatusBtn.setUseDisableState(true);
                this.o = true;
                this.p = 7 - b2;
            } else {
                forumRuleDetailSelfVH.onChangeStatusSkinType(bVar.d());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: l0 */
    public ForumRuleDetailSelfVH T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.m).inflate(g1.forum_rules_user_area, viewGroup, false));
            this.k = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, b.a.r0.x0.b2.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, forumRuleDetailSelfVH})) == null) {
            if (bVar == null) {
                return view;
            }
            j0(forumRuleDetailSelfVH, bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (forumRulesShowActivity = this.m) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(i1.forum_rules_later_days_edit);
        String format = String.format(string, this.p + "");
        if (this.m.getView() != null) {
            new BdTopToast(this.m).setIcon(false).setContent(format).show(this.m.getView().j());
        }
    }

    public final void o0(b.a.r0.x0.b2.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || this.m == null || bVar == null) {
            return;
        }
        ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
        forumRuleBaseData.setTitle(bVar.o());
        forumRuleBaseData.setPreface(bVar.k());
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < bVar.n().size(); i2++) {
            ForumRule forumRule = bVar.n().get(i2);
            ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData = new ForumRuleBaseData.ForumRuleItemPbData();
            forumRuleItemPbData.status = forumRule.status + "";
            forumRuleItemPbData.title = forumRule.title + "";
            forumRuleItemPbData.mContent = new ArrayList();
            List<PbContent> list = forumRule.content;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < forumRule.content.size(); i3++) {
                    PbContent pbContent = forumRule.content.get(i3);
                    ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = new ForumRuleBaseData.ForumRuleItemPbContentData();
                    forumRuleItemPbContentData.href = pbContent.link;
                    if (pbContent.type.intValue() == 0) {
                        forumRuleItemPbContentData.tag = "plainText";
                    } else if (pbContent.type.intValue() == 1) {
                        forumRuleItemPbContentData.tag = "a";
                    } else if (pbContent.type.intValue() == 2) {
                        forumRuleItemPbContentData.tag = "br";
                    }
                    forumRuleItemPbContentData.value = pbContent.text;
                    forumRuleItemPbData.mContent.add(forumRuleItemPbContentData);
                }
            }
            arrayList.add(forumRuleItemPbData);
        }
        forumRuleBaseData.setPbDataList(arrayList);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.m, bVar.h().forum_id + "", bVar.h().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.h().avatar, bVar.e().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.n = str;
        }
    }
}
