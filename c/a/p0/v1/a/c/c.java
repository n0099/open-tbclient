package c.a.p0.v1.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContextSupport a;

    /* renamed from: b  reason: collision with root package name */
    public List<c.a.o0.s.f.a> f19065b;

    /* renamed from: c  reason: collision with root package name */
    public TbCheckBox.b f19066c;

    /* renamed from: d  reason: collision with root package name */
    public b f19067d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f19068e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19069f;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f19070b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19071c;

        /* renamed from: d  reason: collision with root package name */
        public TbCheckBox f19072d;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void b(View view, c.a.o0.s.f.a aVar);
    }

    public c(TbPageContextSupport tbPageContextSupport, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19067d = null;
        this.f19068e = null;
        this.a = tbPageContextSupport;
        this.f19069f = z;
    }

    public final a a(Object obj, c.a.o0.s.f.a aVar) {
        InterceptResult invokeLL;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, aVar)) == null) {
            if (obj == null) {
                aVar2 = b();
            } else {
                aVar2 = (a) obj;
            }
            b bVar = this.f19067d;
            if (bVar != null) {
                bVar.b(aVar2.a, aVar);
            }
            c(aVar, aVar2, aVar.h());
            aVar2.f19071c.setText(aVar.g());
            if (this.f19069f) {
                aVar2.f19072d.setVisibility(8);
            } else {
                aVar2.f19072d.setTagData(aVar);
            }
            TbPageContextSupport tbPageContextSupport = this.a;
            if (tbPageContextSupport instanceof InviteFriendListActivity) {
                ((InviteFriendListActivity) tbPageContextSupport).getLayoutMode().j(aVar2.a);
            }
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this);
            View inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d03f7, (ViewGroup) null);
            aVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091827);
            aVar.f19070b = headImageView;
            headImageView.setIsRound(false);
            aVar.f19071c = (TextView) aVar.a.findViewById(R.id.obfuscated_res_0x7f092246);
            TbCheckBox tbCheckBox = (TbCheckBox) aVar.a.findViewById(R.id.obfuscated_res_0x7f09064d);
            aVar.f19072d = tbCheckBox;
            TbCheckBox.b bVar = this.f19066c;
            if (bVar != null) {
                tbCheckBox.setStatedChangedListener(bVar);
            }
            aVar.a.setTag(aVar);
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void c(c.a.o0.s.f.a aVar, a aVar2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, aVar, aVar2, str) == null) || aVar == null) {
            return;
        }
        aVar2.f19070b.setTag(str);
        aVar2.f19070b.J(str, 12, false);
    }

    public void d(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f19066c = bVar;
        }
    }

    public void e(List<c.a.o0.s.f.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f19065b = list;
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f19067d = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<c.a.o0.s.f.a> list = this.f19065b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<c.a.o0.s.f.a> list = this.f19065b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            if (this.f19068e == null) {
                this.f19068e = viewGroup;
            }
            c.a.o0.s.f.a aVar2 = (c.a.o0.s.f.a) getItem(i);
            if (aVar2 != null) {
                aVar = a(view != null ? view.getTag() : null, aVar2);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                return aVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
