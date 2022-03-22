package c.a.p0.j1.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.p0.j1.c.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public List<a.C1174a> f15610b;

    /* renamed from: c  reason: collision with root package name */
    public MyGiftListActivity f15611c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f15612d;

    /* renamed from: e  reason: collision with root package name */
    public NoDataView f15613e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f15614f;

    /* renamed from: g  reason: collision with root package name */
    public int f15615g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f15616h;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    this.a.f15611c.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.obfuscated_res_0x7f091e73)), (String) view.getTag(R.id.obfuscated_res_0x7f091ea7))));
                    return;
                }
                this.a.f15611c.showToast(R.string.obfuscated_res_0x7f0f0c15);
            }
        }
    }

    /* renamed from: c.a.p0.j1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1175b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15617b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f15618c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15619d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f15620e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f15621f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f15622g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f15623h;
        public TextView i;

        public C1175b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1175b(a aVar) {
            this();
        }
    }

    public b(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f15612d = false;
        this.f15615g = -1;
        this.f15616h = new a(this);
        this.f15611c = myGiftListActivity;
        this.f15614f = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f15611c.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f15611c.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f15611c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d016e, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f15611c.getResources().getString(R.string.obfuscated_res_0x7f0f10dc), this.f15611c.getSendGiftClickListener()));
            this.f15611c.getResources().getDimension(R.dimen.tbds200);
            this.f15611c.getResources().getDimension(R.dimen.obfuscated_res_0x7f070240);
            String userSex = this.f15611c.getUserSex();
            this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3c);
            String string = this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f03f0);
            String format = String.format(this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10df), userSex);
            Activity pageActivity = this.f15611c.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f15614f) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f15614f && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f15613e = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f15611c.getLayoutMode().k(skinType == 1);
            this.f15611c.getLayoutMode().j(inflate);
            this.f15613e.f(this.f15611c.getPageContext(), skinType);
            this.f15613e.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1174a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.f15612d) {
                return null;
            }
            int itemId = (int) getItemId(i);
            List<a.C1174a> list = this.f15610b;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f15610b.size()) {
                return null;
            }
            return this.f15610b.get(itemId);
        }
        return (a.C1174a) invokeI.objValue;
    }

    public void e(List<a.C1174a> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            if (list != null && list.size() > 0) {
                this.f15612d = false;
            } else {
                this.f15612d = true;
            }
            this.f15610b = list;
            this.f15615g = i;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f15612d) {
                return 1;
            }
            List<a.C1174a> list = this.f15610b;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f15610b.size();
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
        C1175b c1175b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view, viewGroup)) == null) {
            if (this.f15612d) {
                return c();
            }
            if (view != null && view.getTag(R.id.obfuscated_res_0x7f091e73) != null) {
                c1175b = (C1175b) view.getTag(R.id.obfuscated_res_0x7f091e73);
            } else {
                view = LayoutInflater.from(this.f15611c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0598, viewGroup, false);
                c1175b = new C1175b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090f8b);
                c1175b.a = tbImageView;
                tbImageView.setRadius(n.d(this.f15611c.getBaseContext(), 25.0f));
                c1175b.f15617b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f8d);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.obfuscated_res_0x7f090f8a);
                c1175b.f15618c = headImageView;
                headImageView.setRadius(n.d(this.f15611c.getBaseContext(), 50.0f));
                c1175b.f15618c.setOnClickListener(this.f15616h);
                c1175b.f15618c.setPlaceHolder(1);
                c1175b.f15619d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0922bb);
                c1175b.f15623h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090caa);
                c1175b.f15622g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090cb9);
                c1175b.f15621f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090ca9);
                c1175b.f15620e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091ffb);
                c1175b.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091644);
                view.setTag(R.id.obfuscated_res_0x7f091e73, c1175b);
            }
            if (!this.f15614f) {
                c1175b.f15620e.setVisibility(8);
                c1175b.i.setVisibility(8);
            } else {
                c1175b.i.setVisibility(0);
            }
            a.C1174a item = getItem(i);
            if (item != null) {
                if (this.f15611c.userType == 1) {
                    c1175b.f15618c.J(item.f15601c, 12, false);
                    int i2 = item.f15606h;
                    if (i2 == 1) {
                        c1175b.a.setVisibility(0);
                        c1175b.a.setImageResource(R.drawable.obfuscated_res_0x7f080727);
                        c1175b.f15617b.setVisibility(8);
                    } else if (i2 == 2) {
                        c1175b.a.setVisibility(0);
                        c1175b.a.setImageResource(R.drawable.obfuscated_res_0x7f080728);
                        c1175b.f15617b.setVisibility(8);
                    } else if (i2 == 3) {
                        c1175b.a.setVisibility(0);
                        c1175b.a.setImageResource(R.drawable.obfuscated_res_0x7f080729);
                        c1175b.f15617b.setVisibility(8);
                    } else {
                        c1175b.a.setVisibility(8);
                        c1175b.f15617b.setVisibility(0);
                        TextView textView = c1175b.f15617b;
                        textView.setText(item.f15606h + "");
                    }
                } else {
                    c1175b.f15618c.J(item.f15602d, 10, false);
                    c1175b.a.setVisibility(8);
                    c1175b.f15617b.setVisibility(8);
                }
                c1175b.f15618c.setDrawBorder(false);
                c1175b.f15619d.setText(TextUtils.isEmpty(item.i) ? item.f15600b : item.i);
                c1175b.f15618c.setTag(R.id.obfuscated_res_0x7f091e73, Long.valueOf(item.a));
                c1175b.f15618c.setTag(R.id.obfuscated_res_0x7f091ea7, item.f15600b);
                c1175b.f15621f.setText(this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e7));
                TextView textView2 = c1175b.f15622g;
                textView2.setText(this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f07a1) + item.f15605g);
                if (item.f15604f < 1) {
                    c1175b.f15623h.setVisibility(8);
                } else {
                    TextView textView3 = c1175b.f15623h;
                    textView3.setText(this.f15611c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b19) + item.f15604f);
                    c1175b.f15623h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f15603e * 1000);
                c1175b.f15620e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.f15615g)) {
                    c1175b.f15620e.setVisibility(8);
                    c1175b.f15622g.setText(formatTime);
                    SkinManager.setViewTextColor(c1175b.f15622g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1175b.f15622g, R.color.CAM_X0301, 1);
                }
            }
            b(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a : invokeV.intValue;
    }
}
