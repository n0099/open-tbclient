package c.a.r0.w0.q1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public class d extends c.a.e.l.e.a<c.a.r0.w0.q1.c.b, ForumRuleDetailSelfVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumRulesShowActivity m;
    public String n;
    public boolean o;
    public int p;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.w0.q1.c.b f27606e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f27607f;

        public a(d dVar, c.a.r0.w0.q1.c.b bVar) {
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
            this.f27607f = dVar;
            this.f27606e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f27607f.o) {
                    this.f27607f.o0();
                } else {
                    this.f27607f.p0(this.f27606e);
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
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.w0.q1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        n0(i2, view, viewGroup, bVar, forumRuleDetailSelfVH);
        return view;
    }

    public final void k0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, c.a.r0.w0.q1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailSelfVH, bVar) == null) {
            if (bVar.d() != null) {
                forumRuleDetailSelfVH.mHeadView.setDefaultResource(R.drawable.img_default_100);
                forumRuleDetailSelfVH.mHeadView.startLoad(bVar.d().portrait, 12, false);
                forumRuleDetailSelfVH.mUserName.setText(bVar.d().name_show);
                forumRuleDetailSelfVH.onChangeForumLevelSkinType(bVar.d().user_level.intValue());
                forumRuleDetailSelfVH.mUserForumLevel.setVisibility(0);
            }
            forumRuleDetailSelfVH.mUserIdentity.setText(R.string.bawu_member_bazhu_tip);
            forumRuleDetailSelfVH.mUserIdentity.setVisibility(0);
            forumRuleDetailSelfVH.onChangeUserIdentitySkinType("manager");
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.onChangeTimeSkinType(String.valueOf(System.currentTimeMillis() / 1000));
            } else {
                forumRuleDetailSelfVH.mTime.setText(bVar.l());
            }
            l0(forumRuleDetailSelfVH, bVar);
            forumRuleDetailSelfVH.onChangePrefaceSkinType(bVar.k());
        }
    }

    public final void l0(ForumRuleDetailSelfVH forumRuleDetailSelfVH, c.a.r0.w0.q1.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, forumRuleDetailSelfVH, bVar) == null) && bVar.i()) {
            forumRuleDetailSelfVH.mEditStatusBtn.setOnClickListener(new a(this, bVar));
            if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
                forumRuleDetailSelfVH.mEditStatusBtn.setVisibility(8);
            } else if (!StringUtils.isNull(bVar.l()) && bVar.c() == 0) {
                long a2 = c.a.r0.w0.q1.e.a.a(bVar.l());
                int b2 = c.a.r0.w0.q1.e.a.b(Long.valueOf(StringUtils.isNull(bVar.g()) ? "0" : bVar.g()).longValue() - a2);
                if (b2 < 0) {
                    b2 = c.a.r0.w0.q1.e.a.b((System.currentTimeMillis() / 1000) - a2);
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
                forumRuleDetailSelfVH.onChangeStatusSkinType(bVar.c());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public ForumRuleDetailSelfVH U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailSelfVH forumRuleDetailSelfVH = new ForumRuleDetailSelfVH(LayoutInflater.from(this.m).inflate(R.layout.forum_rules_user_area, viewGroup, false));
            this.k = forumRuleDetailSelfVH;
            return forumRuleDetailSelfVH;
        }
        return (ForumRuleDetailSelfVH) invokeL.objValue;
    }

    public View n0(int i2, View view, ViewGroup viewGroup, c.a.r0.w0.q1.c.b bVar, ForumRuleDetailSelfVH forumRuleDetailSelfVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, forumRuleDetailSelfVH})) == null) {
            if (bVar == null) {
                return view;
            }
            k0(forumRuleDetailSelfVH, bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0() {
        ForumRulesShowActivity forumRulesShowActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (forumRulesShowActivity = this.m) == null) {
            return;
        }
        String string = forumRulesShowActivity.getString(R.string.forum_rules_later_days_edit);
        String format = String.format(string, this.p + "");
        if (this.m.getView() != null) {
            new BdTopToast(this.m).setIcon(false).setContent(format).show(this.m.getView().j());
        }
    }

    public final void p0(c.a.r0.w0.q1.c.b bVar) {
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.m, bVar.h().forum_id + "", bVar.h().forum_name + "", ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, forumRuleBaseData, bVar.h().avatar, bVar.d().user_level.intValue(), 25053)));
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.n = str;
        }
    }
}
