package c.a.s0.l2.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.s0.l2.b.d;
import c.a.s0.o1.j.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.nearby.viewholder.NearbyForumFriendItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends c.a.d.m.e.a<d, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public int n;
    public boolean o;

    /* renamed from: c.a.s0.l2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1156a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19126e;

        public C1156a(a aVar) {
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
            this.f19126e = aVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d)) {
                d dVar = (d) nVar;
                String str = dVar.f19136e;
                boolean z = !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str);
                c.g(i2 + 1, this.f19126e.n, 2, dVar.f19136e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f19126e.m).createNormalConfig(c.a.d.f.m.b.g(str, 0L), z, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f19128f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19129g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f19130h;

        public b(a aVar, ViewGroup viewGroup, d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19130h = aVar;
            this.f19127e = viewGroup;
            this.f19128f = dVar;
            this.f19129g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19130h.o) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.f19127e.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    c.a.s0.l2.c.a.a(this.f19128f);
                }
                c.g(this.f19129g + 1, this.f19130h.n, 1, this.f19128f.f19136e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId, int i2) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
        this.n = i2;
        c0(new C1156a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, d dVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        k0(i2, view, viewGroup, dVar, nearbyForumFriendItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: j0 */
    public NearbyForumFriendItemViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.m).inflate(R.layout.nearby_forum_friend_item, viewGroup, false), this.m) : (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, d dVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, nearbyForumFriendItemViewHolder})) == null) {
            if (dVar != null && nearbyForumFriendItemViewHolder != null) {
                n0(dVar, nearbyForumFriendItemViewHolder);
                l0(dVar, nearbyForumFriendItemViewHolder);
                c.l(i2 + 1, this.n);
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemHi.setOnClickListener(new b(this, viewGroup, dVar, i2));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(d dVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.startLoad(dVar.f19138g, 25, false);
            nearbyForumFriendItemViewHolder.mTvForumFriendItemNickname.setText(dVar.f19137f);
            int i2 = dVar.f19139h;
            if ((i2 != 1 && i2 != 2) || dVar.f19140i <= 0) {
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemAge.setText(String.valueOf(dVar.f19140i));
            }
            if (StringUtils.isNull(dVar.f19141j)) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setText(dVar.f19141j);
            }
            if (StringUtils.isNull(dVar.f19142k)) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setText(dVar.f19142k);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.m.getResources().getString(R.string.forum_friend_item_from));
            if (!ListUtils.isEmpty(dVar.l)) {
                List<c.a.s0.l2.b.c> list = dVar.l;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (i3 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i3).a);
                    sb.append(this.m.getResources().getString(R.string.forum));
                }
            }
            nearbyForumFriendItemViewHolder.mTvForumFriendItemLabel.setText(sb);
            nearbyForumFriendItemViewHolder.mTvForumFriendItemSlogan.setText(dVar.m);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.o = z;
        }
    }

    public final void n0(d dVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, dVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemNickname).v(R.color.CAM_X0105);
            int i2 = dVar.f19139h;
            if (i2 == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemSex, R.drawable.icon_mask_boy, R.color.CAM_X0330, null);
                c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemAge).v(R.color.CAM_X0330);
                c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge);
                d2.e(R.string.A_X11);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0330);
            } else if (i2 == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemSex, R.drawable.icon_mask_girl, R.color.CAM_X0308, null);
                c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemAge).v(R.color.CAM_X0308);
                c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge);
                d3.e(R.string.A_X11);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0308);
            }
            c.a.r0.s.v.c d4 = c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemSign);
            d4.n(R.string.J_X01);
            d4.v(R.color.CAM_X0107);
            d4.f(R.color.CAM_X0202);
            c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemHi, R.drawable.icon_pure_sayhi, R.color.CAM_X0101, null);
            c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemHi).v(R.color.CAM_X0101);
            c.a.r0.s.v.c d5 = c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemHi);
            d5.n(R.string.J_X01);
            d5.f(R.color.CAM_X0302);
            c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemLabel).v(R.color.CAM_X0109);
            c.a.r0.s.v.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemSlogan).v(R.color.CAM_X0107);
        }
    }
}
