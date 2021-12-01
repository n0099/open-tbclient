package c.a.r0.z3.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.r0.z3.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantPerItemView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public AvatarPendantActivity f25909e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f25910f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f25911g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.z3.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1491b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AvatarPendantPerItemView a;

        public C1491b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1491b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(AvatarPendantActivity avatarPendantActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25909e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<DressItemData> list = this.f25910f;
            if (list == null || list.size() <= 0 || this.f25910f.size() <= i2) {
                return null;
            }
            return this.f25910f.get(i2);
        }
        return (DressItemData) invokeI.objValue;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (view != null) {
                this.f25909e.getLayoutMode().k(skinType == 1);
                this.f25909e.getLayoutMode().j(view);
            }
        }
    }

    public void c(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f25911g = aVar;
        }
    }

    public void d(List<DressItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f25910f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<DressItemData> list = this.f25910f;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1491b c1491b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C1491b)) {
                c1491b = (C1491b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f25909e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
                c1491b = new C1491b(this, null);
                AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
                c1491b.a = avatarPendantPerItemView;
                avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f25911g);
                view.setTag(c1491b);
            }
            DressItemData item = getItem(i2);
            if (item != null) {
                c1491b.a.fillView(item);
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
