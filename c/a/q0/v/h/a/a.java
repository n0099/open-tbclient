package c.a.q0.v.h.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f25569e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<AlaSquareTabInfo> f25570f;

    /* renamed from: c.a.q0.v.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1190a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f25571a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f25572b;

        public C1190a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25569e = tbPageContext;
    }

    public ArrayList<AlaSquareTabInfo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25570f : (ArrayList) invokeV.objValue;
    }

    public void b(ArrayList<AlaSquareTabInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f25570f = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f25570f)) {
                return 0;
            }
            return this.f25570f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (ListUtils.isEmpty(this.f25570f)) {
                return null;
            }
            return this.f25570f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        C1190a c1190a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1190a = new C1190a(this);
                view2 = LayoutInflater.from(this.f25569e.getPageActivity()).inflate(R.layout.ala_all_game_entry_item, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.cover);
                c1190a.f25571a = tbImageView;
                tbImageView.setDrawerType(1);
                c1190a.f25571a.setDefaultResource(R.drawable.ala_all_game_default_icon);
                c1190a.f25571a.setDefaultBgResource(R.color.transparent);
                c1190a.f25571a.setRadius(this.f25569e.getResources().getDimensionPixelSize(R.dimen.ds20));
                TextView textView = (TextView) view2.findViewById(R.id.title);
                c1190a.f25572b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
                view2.setTag(c1190a);
            } else {
                view2 = view;
                c1190a = (C1190a) view.getTag();
            }
            c1190a.f25571a.startLoad(this.f25570f.get(i2).iconUrl, 10, false);
            c1190a.f25572b.setText(this.f25570f.get(i2).name);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
