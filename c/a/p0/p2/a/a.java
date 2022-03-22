package c.a.p0.p2.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
import c.a.o0.t.h;
import c.a.o0.t.i;
import c.a.p0.q1.k.c;
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
/* loaded from: classes2.dex */
public class a extends c.a.d.o.e.a<i, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public int j;
    public boolean k;

    /* renamed from: c.a.p0.p2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1269a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1269a(a aVar) {
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

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof i)) {
                i iVar = (i) nVar;
                String str = iVar.a;
                boolean z = !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str);
                c.h(i + 1, this.a.j, 2, iVar.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.i).createNormalConfig(c.a.d.f.m.b.g(str, 0L), z, false)));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f16902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f16903c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f16904d;

        public b(a aVar, ViewGroup viewGroup, i iVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, viewGroup, iVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16904d = aVar;
            this.a = viewGroup;
            this.f16902b = iVar;
            this.f16903c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16904d.k) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.a.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    i iVar = this.f16902b;
                    a aVar = this.f16904d;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new c.a.o0.w.v.f.a(iVar, aVar.d0(aVar.j))));
                }
                c.h(this.f16903c + 1, this.f16904d.j, 1, this.f16902b.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i)};
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
        this.i = context;
        this.j = i;
        V(new C1269a(this));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        f0(i, view, viewGroup, iVar, nearbyForumFriendItemViewHolder);
        return view;
    }

    public final int d0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public NearbyForumFriendItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d05e9, viewGroup, false), this.i) : (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public View f0(int i, View view, ViewGroup viewGroup, i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, iVar, nearbyForumFriendItemViewHolder})) == null) {
            if (iVar != null && nearbyForumFriendItemViewHolder != null) {
                j0(iVar, nearbyForumFriendItemViewHolder);
                h0(iVar, nearbyForumFriendItemViewHolder);
                c.n(i + 1, this.j);
                nearbyForumFriendItemViewHolder.k.setOnClickListener(new b(this, viewGroup, iVar, i));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void g0(NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, nearbyForumFriendItemViewHolder, i) == null) {
            nearbyForumFriendItemViewHolder.p.setVisibility(0);
            if (i == 1) {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c0b));
                nearbyForumFriendItemViewHolder.f34588c.setShowActiveStatus(true);
            } else if (i == 2) {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c09));
                nearbyForumFriendItemViewHolder.f34588c.setShowActiveStatus(true);
            } else if (i != 3) {
                nearbyForumFriendItemViewHolder.p.setVisibility(8);
                nearbyForumFriendItemViewHolder.f34588c.setShowActiveStatus(false);
            } else {
                nearbyForumFriendItemViewHolder.p.setText(this.i.getString(R.string.obfuscated_res_0x7f0f0c0a));
                nearbyForumFriendItemViewHolder.f34588c.setShowActiveStatus(false);
            }
        }
    }

    public final void h0(i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, iVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.f34588c.J(iVar.f11456c, 25, false);
            nearbyForumFriendItemViewHolder.f34589d.setText(iVar.f11455b);
            int i = iVar.f11457d;
            boolean z2 = true;
            if ((i != 1 && i != 2) || iVar.f11458e <= 0) {
                nearbyForumFriendItemViewHolder.f34590e.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.f34590e.setVisibility(0);
                nearbyForumFriendItemViewHolder.f34592g.setText(String.valueOf(iVar.f11458e));
                z = true;
            }
            if (StringUtils.isNull(iVar.f11459f)) {
                nearbyForumFriendItemViewHolder.f34593h.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.f34593h.setVisibility(0);
                nearbyForumFriendItemViewHolder.f34593h.setText(iVar.f11459f);
                z = true;
            }
            if (StringUtils.isNull(iVar.f11460g)) {
                nearbyForumFriendItemViewHolder.i.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.i.setVisibility(0);
                nearbyForumFriendItemViewHolder.i.setText(iVar.f11460g);
            }
            g0(nearbyForumFriendItemViewHolder, iVar.k);
            if (z2 && nearbyForumFriendItemViewHolder.p.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.o.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.o.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f065c));
            if (!ListUtils.isEmpty(iVar.f11461h)) {
                List<h> list = iVar.f11461h;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i2).a);
                    sb.append(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f063c));
                }
            }
            nearbyForumFriendItemViewHolder.j.setText(sb);
            nearbyForumFriendItemViewHolder.n.setText(iVar.i);
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    public final void j0(i iVar, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.f34588c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34589d).v(R.color.CAM_X0105);
            int i = iVar.f11457d;
            if (i == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f34591f, R.drawable.obfuscated_res_0x7f0807c6, R.color.CAM_X0330, null);
                c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34592g).v(R.color.CAM_X0330);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34590e);
                d2.e(R.string.A_X11);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0330);
            } else if (i == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f34591f, R.drawable.obfuscated_res_0x7f0807e0, R.color.CAM_X0308, null);
                c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34592g).v(R.color.CAM_X0308);
                c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34590e);
                d3.e(R.string.A_X11);
                d3.n(R.string.J_X01);
                d3.f(R.color.CAM_X0308);
            }
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.f34593h);
            d4.n(R.string.J_X01);
            d4.v(R.color.CAM_X0107);
            d4.f(R.color.CAM_X0202);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.i).v(R.color.CAM_X0109);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.o).v(R.color.CAM_X0109);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.p).v(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.l, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0302, null);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.m).v(R.color.CAM_X0302);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.k);
            d5.n(R.string.J_X01);
            d5.f(R.color.CAM_X0905);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.j).v(R.color.CAM_X0109);
            c.a.o0.r.v.c.d(nearbyForumFriendItemViewHolder.n).v(R.color.CAM_X0107);
        }
    }
}
