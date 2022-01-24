package c.a.t0.c4.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.a.t0.c4.d.c;
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
    public AvatarPendantActivity f15636e;

    /* renamed from: f  reason: collision with root package name */
    public List<DressItemData> f15637f;

    /* renamed from: g  reason: collision with root package name */
    public c.a f15638g;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.t0.c4.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0999b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AvatarPendantPerItemView a;

        public C0999b(b bVar) {
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

        public /* synthetic */ C0999b(b bVar, a aVar) {
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
        this.f15636e = avatarPendantActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public DressItemData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<DressItemData> list = this.f15637f;
            if (list == null || list.size() <= 0 || this.f15637f.size() <= i2) {
                return null;
            }
            return this.f15637f.get(i2);
        }
        return (DressItemData) invokeI.objValue;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            if (view != null) {
                this.f15636e.getLayoutMode().k(skinType == 1);
                this.f15636e.getLayoutMode().j(view);
            }
        }
    }

    public void c(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f15638g = aVar;
        }
    }

    public void d(List<DressItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f15637f = list;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<DressItemData> list = this.f15637f;
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
        C0999b c0999b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view != null && (view.getTag() instanceof C0999b)) {
                c0999b = (C0999b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15636e.getActivity()).inflate(R.layout.avatar_pendant_gridview_item, viewGroup, false);
                c0999b = new C0999b(this, null);
                AvatarPendantPerItemView avatarPendantPerItemView = (AvatarPendantPerItemView) view.findViewById(R.id.avatar_pendant_per_item);
                c0999b.a = avatarPendantPerItemView;
                avatarPendantPerItemView.setAvatarPendantItemClickListener(this.f15638g);
                view.setTag(c0999b);
            }
            DressItemData item = getItem(i2);
            if (item != null) {
                c0999b.a.fillView(item);
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
