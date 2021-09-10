package c.a.r0.x1.c.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import c.a.e.e.p.l;
import c.a.r0.x1.c.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f28436e;

    /* renamed from: f  reason: collision with root package name */
    public List<o> f28437f;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f28438a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f28439b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, ArrayList<o> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28436e = tbPageContext;
        this.f28437f = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<o> list = this.f28437f;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<o> list = this.f28437f;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            List<o> list = this.f28437f;
            if (list == null) {
                return 0L;
            }
            return list.get(i2).d();
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                aVar = new a();
                LinearLayout linearLayout = new LinearLayout(this.f28436e.getPageActivity());
                aVar.f28438a = linearLayout;
                linearLayout.setGravity(1);
                TbImageView tbImageView = new TbImageView(this.f28436e.getPageActivity());
                int g2 = ((l.q(this.f28436e.getPageActivity()).widthPixels - (l.g(this.f28436e.getPageActivity(), R.dimen.ds24) * 2)) - l.g(this.f28436e.getPageActivity(), R.dimen.ds10)) / 2;
                tbImageView.setLayoutParams(new LinearLayout.LayoutParams(g2, (int) ((g2 / 173.0f) * 85.0f)));
                tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                aVar.f28439b = tbImageView;
                aVar.f28438a.addView(tbImageView);
                view2 = aVar.f28438a;
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            aVar.f28439b.startLoad(this.f28437f.get(i2).b(), 10, false);
            c.a.q0.w0.a.a(this.f28436e, view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
