package c.a.r0.b1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<GiftCommonList.NumInfo> f15872e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15873f;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.b1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0757b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f15874a;

        /* renamed from: b  reason: collision with root package name */
        public View f15875b;

        public C0757b(b bVar) {
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

        public /* synthetic */ C0757b(b bVar, a aVar) {
            this(bVar);
        }
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15873f = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.NumInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f15872e == null || i2 < 0 || i2 >= getCount() - 1) {
                return null;
            }
            return this.f15872e.get(i2);
        }
        return (GiftCommonList.NumInfo) invokeI.objValue;
    }

    public void b(List<GiftCommonList.NumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f15872e = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<GiftCommonList.NumInfo> list = this.f15872e;
            if (list == null) {
                return 1;
            }
            return list.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 == getCount() - 1 ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0757b c0757b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                c0757b = (C0757b) view.getTag();
            } else {
                view = LayoutInflater.from(this.f15873f).inflate(R.layout.gift_num_item, (ViewGroup) null);
                c0757b = new C0757b(this, null);
                c0757b.f15874a = (TextView) view.findViewById(R.id.text);
                c0757b.f15875b = view.findViewById(R.id.divider);
                view.setTag(c0757b);
            }
            SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
            SkinManager.setViewTextColor(c0757b.f15874a, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(c0757b.f15875b, R.color.CAM_X0204);
            GiftCommonList.NumInfo item = getItem(i2);
            if (getItemViewType(i2) == 1) {
                c0757b.f15874a.setText(R.string.custom_num);
                c0757b.f15875b.setVisibility(4);
            } else {
                if (item != null) {
                    int num = item.getNum() > 0 ? item.getNum() : 1;
                    String name = item.getName() != null ? item.getName() : "";
                    TextView textView = c0757b.f15874a;
                    textView.setText(num + name);
                    c0757b.f15875b.setVisibility(0);
                } else {
                    c0757b.f15874a.setText("");
                    c0757b.f15875b.setVisibility(0);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
