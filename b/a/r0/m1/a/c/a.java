package b.a.r0.m1.a.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public IMBlackListActivity f20933e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<BlackListItemData> f20934f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f20935g;

    /* renamed from: b.a.r0.m1.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1027a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20936e;

        public View$OnClickListenerC1027a(a aVar) {
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
                    return;
                }
            }
            this.f20936e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (tag = view.getTag()) != null && (tag instanceof BlackListItemData)) {
                this.f20936e.f20933e.handler(view, (BlackListItemData) tag);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f20937a;

        /* renamed from: b  reason: collision with root package name */
        public HeadImageView f20938b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f20939c;

        /* renamed from: d  reason: collision with root package name */
        public Button f20940d;

        public b(a aVar) {
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

        public /* synthetic */ b(a aVar, View$OnClickListenerC1027a view$OnClickListenerC1027a) {
            this(aVar);
        }
    }

    public a(IMBlackListActivity iMBlackListActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMBlackListActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20935g = new View$OnClickListenerC1027a(this);
        this.f20933e = iMBlackListActivity;
    }

    public final b b(Object obj, BlackListItemData blackListItemData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, blackListItemData)) == null) {
            if (obj == null) {
                bVar = c();
            } else {
                bVar = (b) obj;
            }
            d(bVar, blackListItemData.w());
            bVar.f20939c.setText(blackListItemData.x());
            bVar.f20940d.setTag(blackListItemData);
            this.f20933e.getLayoutMode().j(bVar.f20937a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.f20933e.getPageContext().getContext()).inflate(R.layout.im_black_list_item, (ViewGroup) null);
            bVar.f20937a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.header_view);
            bVar.f20938b = headImageView;
            headImageView.setIsRound(true);
            bVar.f20939c = (TextView) bVar.f20937a.findViewById(R.id.user_name);
            bVar.f20940d = (Button) bVar.f20937a.findViewById(R.id.remove_button);
            bVar.f20937a.setTag(bVar);
            bVar.f20940d.setOnClickListener(this.f20935g);
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final void d(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, str) == null) || str == null) {
            return;
        }
        bVar.f20938b.setTag(str);
        bVar.f20938b.startLoad(str, 12, false);
    }

    public void e(BlackListItemData blackListItemData) {
        ArrayList<BlackListItemData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, blackListItemData) == null) || (arrayList = this.f20934f) == null) {
            return;
        }
        arrayList.remove(blackListItemData);
    }

    public void f(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f20934f = arrayList;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<BlackListItemData> arrayList = this.f20934f;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            ArrayList<BlackListItemData> arrayList = this.f20934f;
            if (arrayList != null) {
                return arrayList.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            BlackListItemData blackListItemData = (BlackListItemData) getItem(i2);
            if (blackListItemData != null) {
                bVar = b(view != null ? view.getTag() : null, blackListItemData);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.f20937a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
