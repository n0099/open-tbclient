package c.a.t0.h1.c;

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
import c.a.t0.h1.b.g;
import c.a.t0.h1.c.a;
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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18050e;

    /* renamed from: f  reason: collision with root package name */
    public List<a.C1127a> f18051f;

    /* renamed from: g  reason: collision with root package name */
    public MyGiftListActivity f18052g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18053h;

    /* renamed from: i  reason: collision with root package name */
    public NoDataView f18054i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18055j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18056e;

        public a(b bVar) {
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
                    return;
                }
            }
            this.f18056e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.z()) {
                    this.f18056e.f18052g.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view.getTag(R.id.tag_first)), (String) view.getTag(R.id.tag_second))));
                    return;
                }
                this.f18056e.f18052g.showToast(R.string.neterror);
            }
        }
    }

    /* renamed from: c.a.t0.h1.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1128b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f18057b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f18058c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18059d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18060e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18061f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f18062g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18063h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f18064i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f18065j;
        public TextView k;

        public C1128b() {
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

        public /* synthetic */ C1128b(a aVar) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18050e = 1;
        this.f18053h = false;
        this.k = -1;
        this.l = new a(this);
        this.f18052g = myGiftListActivity;
        this.f18055j = z;
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f18052g.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f18052g.getLayoutMode().j(view);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.f18052g.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.f18052g.getResources().getString(R.string.send_gift), this.f18052g.getSendGiftClickListener()));
            this.f18052g.getResources().getDimension(R.dimen.tbds200);
            this.f18052g.getResources().getDimension(R.dimen.ds140);
            String userSex = this.f18052g.getUserSex();
            this.f18052g.getPageContext().getString(R.string.no_gift);
            String string = this.f18052g.getPageContext().getString(R.string.come_on);
            String format = String.format(this.f18052g.getPageContext().getString(R.string.send_him_gift_note), userSex);
            Activity pageActivity = this.f18052g.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f18055j) {
                string = format;
            }
            NoDataViewFactory.e d2 = NoDataViewFactory.e.d(null, string);
            if (!this.f18055j && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.f18054i = NoDataViewFactory.a(pageActivity, inflate, a3, d2, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            this.f18052g.getLayoutMode().k(skinType == 1);
            this.f18052g.getLayoutMode().j(inflate);
            this.f18054i.onChangeSkinType(this.f18052g.getPageContext(), skinType);
            this.f18054i.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public a.C1127a getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (this.f18053h) {
                return null;
            }
            int itemId = (int) getItemId(i2);
            List<a.C1127a> list = this.f18051f;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.f18051f.size()) {
                return null;
            }
            return this.f18051f.get(itemId);
        }
        return (a.C1127a) invokeI.objValue;
    }

    public void e(List<a.C1127a> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i2) == null) {
            if (list != null && list.size() > 0) {
                this.f18053h = false;
            } else {
                this.f18053h = true;
            }
            this.f18051f = list;
            this.k = i2;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f18053h) {
                return 1;
            }
            List<a.C1127a> list = this.f18051f;
            if (list == null || list.size() == 0) {
                return 0;
            }
            return this.f18051f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1128b c1128b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (this.f18053h) {
                return c();
            }
            if (view != null && view.getTag(R.id.tag_first) != null) {
                c1128b = (C1128b) view.getTag(R.id.tag_first);
            } else {
                view = LayoutInflater.from(this.f18052g.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_item, viewGroup, false);
                c1128b = new C1128b(null);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.item_rank_image);
                c1128b.a = tbImageView;
                tbImageView.setRadius(n.d(this.f18052g.getBaseContext(), 25.0f));
                c1128b.f18057b = (TextView) view.findViewById(R.id.item_rank_text);
                HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1128b.f18058c = headImageView;
                headImageView.setRadius(n.d(this.f18052g.getBaseContext(), 50.0f));
                c1128b.f18058c.setOnClickListener(this.l);
                c1128b.f18058c.setPlaceHolder(1);
                c1128b.f18059d = (TextView) view.findViewById(R.id.user_name);
                c1128b.f18063h = (TextView) view.findViewById(R.id.gift_num);
                c1128b.f18062g = (TextView) view.findViewById(R.id.gift_value_text);
                c1128b.f18061f = (TextView) view.findViewById(R.id.gift_name);
                c1128b.f18060e = (TextView) view.findViewById(R.id.time);
                c1128b.f18064i = (TextView) view.findViewById(R.id.paly_icon);
                c1128b.f18065j = (TextView) view.findViewById(R.id.reward_prefix);
                c1128b.k = (TextView) view.findViewById(R.id.reward_num);
                view.setTag(R.id.tag_first, c1128b);
            }
            if (!this.f18055j) {
                c1128b.f18060e.setVisibility(8);
                c1128b.f18064i.setVisibility(8);
            } else {
                c1128b.f18064i.setVisibility(0);
            }
            a.C1127a item = getItem(i2);
            if (item != null) {
                if (this.f18052g.userType == 1) {
                    c1128b.f18058c.startLoad(item.f18039c, 12, false);
                    int i3 = item.f18046j;
                    if (i3 == 1) {
                        c1128b.a.setVisibility(0);
                        c1128b.a.setImageResource(R.drawable.icon_frs_no1);
                        c1128b.f18057b.setVisibility(8);
                    } else if (i3 == 2) {
                        c1128b.a.setVisibility(0);
                        c1128b.a.setImageResource(R.drawable.icon_frs_no2);
                        c1128b.f18057b.setVisibility(8);
                    } else if (i3 == 3) {
                        c1128b.a.setVisibility(0);
                        c1128b.a.setImageResource(R.drawable.icon_frs_no3);
                        c1128b.f18057b.setVisibility(8);
                    } else {
                        c1128b.a.setVisibility(8);
                        c1128b.f18057b.setVisibility(0);
                        TextView textView = c1128b.f18057b;
                        textView.setText(item.f18046j + "");
                    }
                } else {
                    c1128b.f18058c.startLoad(item.f18040d, 10, false);
                    c1128b.a.setVisibility(8);
                    c1128b.f18057b.setVisibility(8);
                }
                c1128b.f18058c.setDrawBorder(false);
                c1128b.f18059d.setText(TextUtils.isEmpty(item.k) ? item.f18038b : item.k);
                c1128b.f18058c.setTag(R.id.tag_first, Long.valueOf(item.a));
                c1128b.f18058c.setTag(R.id.tag_second, item.f18038b);
                c1128b.f18061f.setText(this.f18052g.getPageContext().getString(R.string.send_to_you));
                TextView textView2 = c1128b.f18062g;
                textView2.setText(this.f18052g.getPageContext().getString(R.string.gift_value) + item.f18043g);
                if (item.f18042f < 1) {
                    c1128b.f18063h.setVisibility(8);
                } else {
                    TextView textView3 = c1128b.f18063h;
                    textView3.setText(this.f18052g.getPageContext().getString(R.string.mutil_sign) + item.f18042f);
                    c1128b.f18063h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.f18041e * 1000);
                c1128b.f18060e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.k)) {
                    c1128b.f18060e.setVisibility(8);
                    c1128b.f18062g.setText(formatTime);
                    SkinManager.setViewTextColor(c1128b.f18062g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(c1128b.f18062g, R.color.CAM_X0301, 1);
                }
                c1128b.f18065j.setVisibility(0);
                c1128b.k.setVisibility(0);
                if (item.f18044h > 0) {
                    if (Integer.parseInt(item.f18045i) == 1) {
                        c1128b.k.setText(g.a(item.f18044h, 1, this.k));
                    } else if (Integer.parseInt(item.f18045i) == 2) {
                        c1128b.k.setText(g.a(item.f18044h, 2, this.k));
                    } else {
                        c1128b.f18065j.setVisibility(8);
                        c1128b.k.setVisibility(8);
                    }
                } else {
                    c1128b.f18065j.setVisibility(8);
                    c1128b.k.setVisibility(8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18050e : invokeV.intValue;
    }
}
