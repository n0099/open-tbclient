package c.a.p0.d4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
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
    public List<InterestFrsData.Card> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13677b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f13678c;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f13679b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13680c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f13681d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f13682e;

        public b(c cVar) {
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

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(Context context) {
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
        this.f13677b = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public void b(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, z) == null) {
            if (!z) {
                imageView.setBackgroundDrawable(this.f13677b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a38));
            } else {
                imageView.setBackgroundDrawable(this.f13677b.getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a37));
            }
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f13678c = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<InterestFrsData.Card> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            List<InterestFrsData.Card> list = this.a;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f13677b).inflate(R.layout.obfuscated_res_0x7f0d060f, viewGroup, false);
                bVar = new b(this, null);
                bVar.f13679b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091830);
                bVar.f13680c = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f091c77);
                bVar.f13681d = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0911b8);
                bVar.f13682e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0921ac);
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.obfuscated_res_0x7f091834);
                bVar.a = frameLayout;
                frameLayout.setOnClickListener(this.f13678c);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f13679b.setTag(null);
            bVar.f13681d.setTag(null);
            bVar.f13682e.setText("");
            bVar.a.setTag(null);
            Object item = getItem(i);
            if (item != null && (item instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) item;
                b(bVar.f13680c, card.getIs_like() == 1);
                bVar.f13681d.setTag(card);
                bVar.a.setTag(card);
                bVar.f13679b.setTag(card.getIcon_url());
                bVar.f13679b.J(card.getIcon_url(), 21, false);
                bVar.f13682e.setText(card.getFname());
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
