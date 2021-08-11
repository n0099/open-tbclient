package c.a.p0.m3;

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
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<InterestFrsData.Card> f22105e;

    /* renamed from: f  reason: collision with root package name */
    public Context f22106f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f22107g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.m3.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1027b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f22108a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f22109b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f22110c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f22111d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f22112e;

        public C1027b(b bVar) {
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

        public /* synthetic */ C1027b(b bVar, a aVar) {
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
        this.f22106f = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f22105e = list;
            notifyDataSetChanged();
        }
    }

    public void b(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageView, z) == null) {
            if (!z) {
                imageView.setBackgroundDrawable(this.f22106f.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
            } else {
                imageView.setBackgroundDrawable(this.f22106f.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
            }
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f22107g = onClickListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<InterestFrsData.Card> list = this.f22105e;
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
            List<InterestFrsData.Card> list = this.f22105e;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f22105e.get(i2);
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
        C1027b c1027b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f22106f).inflate(R.layout.new_user_img_item, viewGroup, false);
                c1027b = new C1027b(this, null);
                c1027b.f22109b = (TbImageView) view.findViewById(R.id.pic);
                c1027b.f22110c = (ImageView) view.findViewById(R.id.select_icon);
                c1027b.f22111d = (RelativeLayout) view.findViewById(R.id.lay_select);
                c1027b.f22112e = (TextView) view.findViewById(R.id.tv_fname);
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pic_layout);
                c1027b.f22108a = frameLayout;
                frameLayout.setOnClickListener(this.f22107g);
                view.setTag(c1027b);
            } else {
                c1027b = (C1027b) view.getTag();
            }
            c1027b.f22109b.setTag(null);
            c1027b.f22111d.setTag(null);
            c1027b.f22112e.setText("");
            c1027b.f22108a.setTag(null);
            Object item = getItem(i2);
            if (item != null && (item instanceof InterestFrsData.Card)) {
                InterestFrsData.Card card = (InterestFrsData.Card) item;
                b(c1027b.f22110c, card.getIs_like() == 1);
                c1027b.f22111d.setTag(card);
                c1027b.f22108a.setTag(card);
                c1027b.f22109b.setTag(card.getIcon_url());
                c1027b.f22109b.startLoad(card.getIcon_url(), 21, false);
                c1027b.f22112e.setText(card.getFname());
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
