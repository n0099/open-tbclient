package c.a.p0.j1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public List<GiftCommonList.GiftItem> f15566b;

    /* renamed from: c  reason: collision with root package name */
    public int f15567c;

    /* renamed from: d  reason: collision with root package name */
    public RelativeLayout.LayoutParams f15568d;

    /* renamed from: c.a.p0.j1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1171a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public View f15569b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f15570c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15571d;

        public b(a aVar) {
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
                }
            }
        }

        public /* synthetic */ b(a aVar, C1171a c1171a) {
            this(aVar);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15567c = -1;
        this.a = context;
        this.f15568d = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702bf) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i < 0 || i >= getCount()) {
                return null;
            }
            return this.f15566b.get(i);
        }
        return (GiftCommonList.GiftItem) invokeI.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15567c : invokeV.intValue;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f15566b = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f15567c = i;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<GiftCommonList.GiftItem> list = this.f15566b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (view != null && view.getTag() != null) {
                bVar = (b) view.getTag();
            } else {
                view = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0383, (ViewGroup) null);
                bVar = new b(this, null);
                bVar.a = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e69);
                bVar.f15569b = view.findViewById(R.id.obfuscated_res_0x7f0913b0);
                bVar.f15570c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0914e9);
                bVar.f15571d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0918ea);
                view.setTag(bVar);
            }
            bVar.f15569b.setLayoutParams(this.f15568d);
            SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
            SkinManager.setViewTextColor(bVar.f15570c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f15571d, R.color.CAM_X0301, 1);
            if (i == this.f15567c) {
                SkinManager.setBackgroundResource(bVar.f15569b, R.drawable.obfuscated_res_0x7f080459);
            } else {
                bVar.f15569b.setBackgroundResource(R.color.common_color_10022);
            }
            GiftCommonList.GiftItem item = getItem(i);
            if (item != null) {
                bVar.f15570c.setText(item.getName());
                bVar.f15571d.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f137d), Integer.valueOf(item.getPrice())));
                bVar.a.J(item.getThumbnailUrl(), 10, false);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
