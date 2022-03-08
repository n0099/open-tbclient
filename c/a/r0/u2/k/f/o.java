package c.a.r0.u2.k.f;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class o<T, V extends TypeAdapter.ViewHolder> extends c.a.d.o.e.a<T, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.u2.o.c m;
    public PbFragment n;
    public AbsVideoPbFragment o;
    public int p;
    public boolean q;
    public SparseIntArray r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(c.a.r0.u2.o.c cVar, BdUniqueId bdUniqueId) {
        super(cVar == null ? null : cVar.getPbActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, bdUniqueId};
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
        this.p = 3;
        this.q = false;
        new SparseArray();
        this.r = new SparseIntArray();
        a0(cVar);
    }

    @Override // c.a.d.o.e.a
    public View S(int i2, View view, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, t, v})) == null) {
            this.p = TbadkCoreApplication.getInst().getSkinType();
            c.a.d.o.e.p pVar = (c.a.d.o.e.p) viewGroup;
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public int Z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.r.get(i2, -1);
            if (i3 != -1) {
                return i3;
            }
            int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
            this.r.put(i2, dimensionPixelSize);
            return dimensionPixelSize;
        }
        return invokeI.intValue;
    }

    public void a0(c.a.r0.u2.o.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        this.m = cVar;
        this.n = cVar.getPbFragment();
        AbsVideoPbFragment videoPbFragment = cVar.getVideoPbFragment();
        this.o = videoPbFragment;
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            this.f3076e = pbFragment.getActivity();
        } else if (videoPbFragment != null) {
            this.f3076e = videoPbFragment.getActivity();
        } else {
            this.f3076e = null;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.q = z;
        }
    }
}
