package c.a.t0.l2.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.u.h;
import c.a.s0.u.i;
import c.a.t0.o1.j.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
public class a extends c.a.d.n.e.a<i, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public int n;
    public boolean o;

    /* renamed from: c.a.t0.l2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1181a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19619e;

        public C1181a(a aVar) {
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
            this.f19619e = aVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof i)) {
                i iVar = (i) nVar;
                String str = iVar.f14469e;
                boolean z = !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str);
                c.h(i2 + 1, this.f19619e.n, 2, iVar.f14469e);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f19619e.m).createNormalConfig(c.a.d.f.m.b.g(str, 0L), z, false)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f19620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f19621f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19622g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f19623h;

        public b(a aVar, ViewGroup viewGroup, i iVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19623h = aVar;
            this.f19620e = viewGroup;
            this.f19621f = iVar;
            this.f19622g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19623h.o) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.f19620e.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    i iVar = this.f19621f;
                    a aVar = this.f19623h;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new c.a.s0.x.v.e.a(iVar, aVar.d0(aVar.n))));
                }
                c.h(this.f19622g + 1, this.f19623h.n, 1, this.f19621f.f14469e);
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
        V(new C1181a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        f0(i2, view, viewGroup, iVar, nearbyForumFriendItemViewHolder);
        return view;
    }

    public final int d0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 != 1) {
                return i2 != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public NearbyForumFriendItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.m).inflate(R.layout.nearby_forum_friend_item, viewGroup, false), this.m) : (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View f0(int i2, View view, ViewGroup viewGroup, i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, iVar, nearbyForumFriendItemViewHolder})) == null) {
            if (iVar != null && nearbyForumFriendItemViewHolder != null) {
                j0(iVar, nearbyForumFriendItemViewHolder);
                h0(iVar, nearbyForumFriendItemViewHolder);
                c.n(i2 + 1, this.n);
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemHi.setOnClickListener(new b(this, viewGroup, iVar, i2));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, nearbyForumFriendItemViewHolder, i2) == null) {
            nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.setVisibility(0);
            if (i2 == 1) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.setText(this.m.getString(R.string.nearby_friends_item_active_status_online));
                nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setShowActiveStatus(true);
            } else if (i2 == 2) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.setText(this.m.getString(R.string.nearby_friends_item_active_status_just_been_to));
                nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setShowActiveStatus(true);
            } else if (i2 != 3) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.setVisibility(8);
                nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setShowActiveStatus(false);
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.setText(this.m.getString(R.string.nearby_friends_item_active_status_offline));
                nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setShowActiveStatus(false);
            }
        }
    }

    public final void h0(i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, iVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.startLoad(iVar.f14471g, 25, false);
            nearbyForumFriendItemViewHolder.mTvForumFriendItemNickname.setText(iVar.f14470f);
            int i2 = iVar.f14472h;
            boolean z2 = true;
            if ((i2 != 1 && i2 != 2) || iVar.f14473i <= 0) {
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemAge.setText(String.valueOf(iVar.f14473i));
                z = true;
            }
            if (StringUtils.isNull(iVar.f14474j)) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemSign.setText(iVar.f14474j);
                z = true;
            }
            if (StringUtils.isNull(iVar.f14475k)) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setVisibility(0);
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance.setText(iVar.f14475k);
            }
            g0(nearbyForumFriendItemViewHolder, iVar.o);
            if (z2 && nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDot.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.mTvForumFriendItemDot.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.m.getResources().getString(R.string.forum_friend_item_from));
            if (!ListUtils.isEmpty(iVar.l)) {
                List<h> list = iVar.l;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (i3 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i3).a);
                    sb.append(this.m.getResources().getString(R.string.forum));
                }
            }
            nearbyForumFriendItemViewHolder.mTvForumFriendItemLabel.setText(sb);
            nearbyForumFriendItemViewHolder.mTvForumFriendItemSlogan.setText(iVar.m);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.o = z;
        }
    }

    public final void j0(i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.mForumFriendItemHeadImg.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemNickname).v(R.color.CAM_X0105);
            int i2 = iVar.f14472h;
            if (i2 == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemSex, R.drawable.icon_mask_boy, R.color.CAM_X0330, null);
                c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemAge).v(R.color.CAM_X0330);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge);
                d2.e(R.string.A_X11);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0330);
            } else if (i2 == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemSex, R.drawable.icon_mask_girl, R.color.CAM_X0308, null);
                c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemAge).v(R.color.CAM_X0308);
                c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemSexAge);
                d3.e(R.string.A_X11);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0308);
            }
            c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemSign);
            d4.n(R.string.J_X01);
            d4.v(R.color.CAM_X0107);
            d4.f(R.color.CAM_X0202);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemDistance).v(R.color.CAM_X0109);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemDot).v(R.color.CAM_X0109);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemActiveStatus).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.mIvForumFriendItemHi, R.drawable.icon_pure_sayhi, R.color.CAM_X0302, null);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemHi).v(R.color.CAM_X0302);
            c.a.s0.s.u.c d5 = c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mLayoutForumFriendItemHi);
            d5.n(R.string.J_X01);
            d5.f(R.color.CAM_X0905);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemLabel).v(R.color.CAM_X0109);
            c.a.s0.s.u.c.d(nearbyForumFriendItemViewHolder.mTvForumFriendItemSlogan).v(R.color.CAM_X0107);
        }
    }
}
