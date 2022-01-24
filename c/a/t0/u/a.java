package c.a.t0.u;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.u.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f23834e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23835f;

    /* renamed from: g  reason: collision with root package name */
    public List<AccountData> f23836g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f23837h;

    /* renamed from: c.a.t0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C1449a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f23838b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f23839c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f23840d;

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

        public /* synthetic */ b(a aVar, C1449a c1449a) {
            this(aVar);
        }
    }

    public a(BaseActivity baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23834e = baseActivity;
        this.f23836g = null;
        this.f23835f = false;
        this.f23837h = onClickListener;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23835f : invokeV.booleanValue;
    }

    public void b(List<AccountData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f23836g = list;
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f23835f = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<AccountData> list = this.f23836g;
            return (list != null ? list.size() : 0) + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<AccountData> list = this.f23836g;
            if (list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return this.f23836g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (getItem(i2) != null) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? getItemId(i2) >= 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            try {
                try {
                    if (view == null) {
                        if (getItemViewType(i2) == 0) {
                            view = LayoutInflater.from(this.f23834e.getPageContext().getContext()).inflate(R.layout.account_item, viewGroup, false);
                            bVar = new b(this, null);
                            bVar.a = (TextView) view.findViewById(R.id.account);
                            bVar.f23839c = (ImageView) view.findViewById(R.id.active);
                            TextView textView = (TextView) view.findViewById(R.id.delete);
                            bVar.f23840d = textView;
                            textView.setOnClickListener(this.f23837h);
                            view.setTag(bVar);
                            c.d(bVar.a).v(R.color.CAM_X0105);
                            SkinManager.setBackgroundResource(bVar.f23839c, R.drawable.icon_set_list_ok_s);
                        } else {
                            view = LayoutInflater.from(this.f23834e.getPageContext().getContext()).inflate(R.layout.account_add_item, viewGroup, false);
                            bVar = new b(this, null);
                            bVar.f23838b = (TextView) view.findViewById(R.id.add_text);
                            view.setTag(bVar);
                            c.d(bVar.f23838b).v(R.color.CAM_X0302);
                        }
                    } else {
                        bVar = (b) view.getTag();
                    }
                    if (getItemViewType(i2) == 0) {
                        AccountData accountData = (AccountData) getItem(i2);
                        bVar.f23839c.setVisibility(8);
                        bVar.f23840d.setVisibility(8);
                        bVar.f23840d.setTag(accountData);
                        if (accountData != null) {
                            bVar.a.setText(accountData.getAccountNameShow());
                            if (TextUtils.equals(accountData.getID(), TbadkCoreApplication.getCurrentAccount())) {
                                bVar.f23839c.setVisibility(0);
                            }
                            if (this.f23835f) {
                                bVar.f23840d.setVisibility(0);
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                return view;
            } finally {
                c.d(view).f(R.color.CAM_X0205);
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }
}
