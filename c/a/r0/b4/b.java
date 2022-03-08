package c.a.r0.b4;

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
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<InterestFrsData.Card> f15160e;

    /* renamed from: f  reason: collision with root package name */
    public Context f15161f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f15162g;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.r0.b4.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0971b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f15163b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f15164c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f15165d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15166e;

        public C0971b(b bVar) {
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

        public /* synthetic */ C0971b(b bVar, a aVar) {
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
        this.f15161f = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f15160e = list;
            notifyDataSetChanged();
        }
    }

    public void b(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, z) == null) {
            if (!z) {
                imageView.setBackgroundDrawable(this.f15161f.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
            } else {
                imageView.setBackgroundDrawable(this.f15161f.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f15162g = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<InterestFrsData.Card> list = this.f15160e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<InterestFrsData.Card> list = this.f15160e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f15160e.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C0971b c0971b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f15161f).inflate(R.layout.new_user_img_item, viewGroup, false);
                c0971b = new C0971b(this, null);
                c0971b.f15163b = (TbImageView) view.findViewById(R.id.pic);
                c0971b.f15164c = (ImageView) view.findViewById(R.id.select_icon);
                c0971b.f15165d = (RelativeLayout) view.findViewById(R.id.lay_select);
                c0971b.f15166e = (TextView) view.findViewById(R.id.tv_fname);
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pic_layout);
                c0971b.a = frameLayout;
                frameLayout.setOnClickListener(this.f15162g);
                view.setTag(c0971b);
            } else {
                c0971b = (C0971b) view.getTag();
            }
            c0971b.f15163b.setTag(null);
            c0971b.f15165d.setTag(null);
            c0971b.f15166e.setText("");
            c0971b.a.setTag(null);
            Object item = getItem(i2);
            if (item != null && (item instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) item;
                b(c0971b.f15164c, card.getIs_like() == 1);
                c0971b.f15165d.setTag(card);
                c0971b.a.setTag(card);
                c0971b.f15163b.setTag(card.getIcon_url());
                c0971b.f15163b.startLoad(card.getIcon_url(), 21, false);
                c0971b.f15166e.setText(card.getFname());
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
